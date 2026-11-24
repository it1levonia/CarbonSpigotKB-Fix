package xyz.refinedev.spigot.feature.async.tracker;

import lombok.extern.log4j.Log4j2;
import net.minecraft.server.*;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.spigot.CarbonSpigot;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.utils.collection.ConcurrentIntHashMap;
import xyz.refinedev.spigot.utils.collection.IndexedArrayEntityTrackerSet;
import xyz.refinedev.spigot.utils.collection.IndexedConcurrentSet;

import java.util.Iterator;
import java.util.concurrent.Callable;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2024, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 * <br>
 * <p>
 * This entity tracker handles things completely off-thread.
 * This is useful for large servers with many entities.
 * This won't block the main thread and will allow for better performance.
 * However, it increases cpu usage significantly more than the {@link AsyncEntityTracker}
 * </p>
 *
 * @author Steviebeenz
 * @version CarbonSpigot
 * @since 3/21/2024
 */

@Log4j2
public class ParallelEntityTracker extends AsyncEntityTracker {

    private static final int threadCount = SettingsConfig.ASYNC_ENTITY_THREADS + 2;

    public ParallelEntityTracker(WorldServer worldserver) {
        this.c = new IndexedArrayEntityTrackerSet();
        this.trackedEntities = new ConcurrentIntHashMap<>();
        this.e = SettingsConfig.USE_OPTIMIZED_TRACKING_RANGE ? 128 : PlayerChunkMap.getFurthestViewableBlock(worldserver.spigotConfig.viewDistance);
    }

    public EntityTrackerEntry addEntity(Entity entity, int i, final int j, boolean flag, boolean addToList) {
        // org.spigotmc.AsyncCatcher.catchOp( "entity track"); // Spigot

        @Nullable AsyncEntityTrackerEntry entry = null;

        // Carbon start - Allow hiding of TNT & sand
        if (SettingsConfig.HIDE_SAND && entity instanceof EntityFallingBlock
                || SettingsConfig.HIDE_TNT && entity instanceof EntityTNTPrimed) {
            return entry;
        }
        // Carbon end

        i = org.spigotmc.TrackingRange.getEntityTrackingRange(entity, i); // Spigot
        if (i > this.e) {
            i = this.e;
        }

        if (this.trackedEntities.b(entity.getId())) {
            // Carbon start - Async entity tracker
            //throw new IllegalStateException("Entity is already tracked!");
            //untrackEntity(entity);
            // Carbon end
            log.error("[Carbon-Async] Entity is already tracked, please report this to Drizzy.(ID: {})", entity.getId());
            EntityTrackerEntry entityTrackerEntry = this.trackedEntities.d(entity.getId());
            entityTrackerEntry.addNearPlayers();
            return null;
        }

        AsyncEntityTrackerEntry entityTrackerEntry = new AsyncEntityTrackerEntry(entity, i, j, flag);
        if (SettingsConfig.TNT_UNSAFE && entity instanceof EntityTNTPrimed) {
            IndexedArrayEntityTrackerSet indexedSet = (IndexedArrayEntityTrackerSet) c;
            if (SettingsConfig.BATCH_DISPENSERS && !addToList) {
                entry = entityTrackerEntry;
            } else {
                indexedSet.fastAdd(entityTrackerEntry);
            }
        } else if (SettingsConfig.FALLING_ENTITY_FAST_UNSAFE && entity instanceof EntityFallingBlock) {
            IndexedArrayEntityTrackerSet indexedSet = (IndexedArrayEntityTrackerSet) c;
            if (SettingsConfig.ASYNC_SAND_TRACK) {
                AsyncUtil.run(() -> indexedSet.fastAdd(entityTrackerEntry), CarbonSpigot.getInstance().getThreadManager().getTrackerThreadPool());
            } else {
                indexedSet.fastAdd(entityTrackerEntry);
            }
        } else {
            Runnable runnable = () -> this.c.add(entityTrackerEntry);
            if (SettingsConfig.ASYNC_ENTITY_ADD) {
                if (SettingsConfig.AWAIT_ENTITY_UPDATES) {
                    MinecraftServer.getServer().awaitableTasks.add(AsyncUtil.runAsyncWithFuture(runnable, CarbonSpigot.getInstance().getThreadManager().getTrackerThreadPool()));
                } else if (SettingsConfig.BYPASS_AWAIT_DEPEND) {
                    AsyncUtil.runAsyncWithFuture(runnable, CarbonSpigot.getInstance().getThreadManager().getTrackerThreadPool());
                } else {
                    runnable.run();
                }
            } else {
                runnable.run();
            }
        }
        this.trackedEntities.a(entity.getId(), entityTrackerEntry);

        // Carbon start - Async entity tracker
        //entitytrackerentry.scanPlayers(this.world.players);
        entityTrackerEntry.addNearPlayers();
        // Carbon end

        return entry;
    }

    public void untrackEntity(Entity entity) {
        // org.spigotmc.AsyncCatcher.catchOp( "entity untrack"); // Spigot // CarbonSpigot: This is kinda thread safe ig?
        if (entity instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer) entity;

            // DO NOT MIGRATE THIS FROM AN ITERATOR
            // THIS NEEDS TO STAY AS AN ITERATOR FOREVER
            Iterator iterator = this.c.iterator();

            while (iterator.hasNext()) {
                EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry) iterator.next();
                entitytrackerentry.a(entityplayer);
            }
        }

        EntityTrackerEntry entitytrackerentry1 = this.trackedEntities.d(entity.getId());

        if (entitytrackerentry1 != null) {
            // Carbon start
            Runnable runnable = () -> c.remove(entitytrackerentry1);
            // remove the entity async
            // Set entity as inactive and then queue for removal
            AsyncEntityTrackerEntry asyncEntry = (AsyncEntityTrackerEntry) entitytrackerentry1;
            asyncEntry.isActive = false;

            if (SettingsConfig.AWAIT_ENTITY_UPDATES) {
                MinecraftServer.getServer().awaitableTasks.add(AsyncUtil.runAsyncWithFuture(runnable, CarbonSpigot.getInstance().getThreadManager().getTrackerThreadPool()));
            } else if (SettingsConfig.BYPASS_AWAIT_DEPEND) {
                AsyncUtil.runAsyncWithFuture(runnable, CarbonSpigot.getInstance().getThreadManager().getTrackerThreadPool());
            } else {
                runnable.run();
            }
            // Carbon end
            entitytrackerentry1.a();
        }

    }

    @Override
    public void updatePlayers() {
        int offset = 0;

        // run this once as it can hit performance slightly
        if (instance == null) {
            instance =  CarbonSpigot.getInstance().getThreadManager().getTrackerThreadPool();
        }

        Object[] c = this.c.toArray(); // Copy to array to avoid locking every time - will improve performance

        for (int i = 1; i <= threadCount; i++) {
            final int localOffset = offset++;

            Runnable wrapper = () -> {
                for (int index = localOffset; index < c.length; index += threadCount) {
                    try {
                        final EntityTrackerEntry entry = (EntityTrackerEntry) c[index];
                        if (entry == null || !entry.isActive()) continue;

                        entry.update();
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            };

            MinecraftServer.getServer().awaitableTasks.add(AsyncUtil.runAsyncWithFuture(wrapper, instance));
        }
    }
}
