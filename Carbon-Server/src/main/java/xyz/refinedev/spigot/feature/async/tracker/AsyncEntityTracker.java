package xyz.refinedev.spigot.feature.async.tracker;

import lombok.extern.log4j.Log4j2;
import net.minecraft.server.*;

import xyz.refinedev.spigot.CarbonSpigot;
import xyz.refinedev.spigot.feature.async.utils.ResettableLatch;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.utils.collection.ConcurrentIntHashMap;
import xyz.refinedev.spigot.utils.collection.IndexedConcurrentSet;

import java.util.Iterator;
import java.util.concurrent.*;

@Log4j2
public class AsyncEntityTracker extends EntityTracker {

    private final int threadCount = SettingsConfig.ASYNC_ENTITY_THREADS;
    private final ResettableLatch latch = new ResettableLatch(SettingsConfig.ASYNC_ENTITY_THREADS);
    protected static ExecutorService instance = null;

    // Carbon - Used for Parallel Entity tracker
    public AsyncEntityTracker() {
    }
    // Carbon end

    public AsyncEntityTracker(WorldServer worldserver) {
        this.c = new IndexedConcurrentSet<>();
        this.trackedEntities = new ConcurrentIntHashMap<>();
        this.e = SettingsConfig.USE_OPTIMIZED_TRACKING_RANGE ? 128 : PlayerChunkMap.getFurthestViewableBlock(worldserver.spigotConfig.viewDistance);
    }

    public EntityTrackerEntry addEntity(Entity entity, int i, final int j, boolean flag, boolean addToList) {
        // org.spigotmc.AsyncCatcher.catchOp( "entity track"); // Spigot

        // Carbon start - Allow hiding of TNT & sand
        if (SettingsConfig.HIDE_SAND && entity instanceof EntityFallingBlock
                || SettingsConfig.HIDE_TNT && entity instanceof EntityTNTPrimed) {
            return null;
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
            log.error("[Carbon] Entity is already tracked, please report this to Drizzy.(ID: {})", entity.getId());
            EntityTrackerEntry entityTrackerEntry = this.trackedEntities.d(entity.getId());
            entityTrackerEntry.addNearPlayers();
            return null;
        }

        AsyncEntityTrackerEntry entityTrackerEntry = new AsyncEntityTrackerEntry(entity, i, j, flag);
        this.c.add(entityTrackerEntry);
        this.trackedEntities.a(entity.getId(), entityTrackerEntry);

        // Carbon start - Async entity tracker
        //entitytrackerentry.scanPlayers(this.world.players);
        entityTrackerEntry.addNearPlayers();
        // Carbon end

        return null;
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
            // Set entity as inactive and then queue for removal
            AsyncEntityTrackerEntry asyncEntry = (AsyncEntityTrackerEntry) entitytrackerentry1;
            asyncEntry.isActive = false;
            // Carbon end
            c.remove(entitytrackerentry1);
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
                latch.decrement();
            };

            AsyncUtil.runEntityTracker(i, threadCount, wrapper, instance);
        }

        try {
            latch.waitTillZero();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.reset();
    }

    public void a(EntityPlayer entityplayer) {
        // Do not run this sync lol, we do not want to lag out the entire server.
        if (MCUtil.isMainThread()) {
            Runnable runnable = () -> this.a(entityplayer);
            if (SettingsConfig.AWAIT_ENTITY_UPDATES) {
                MinecraftServer.getServer().awaitableTasks.add(AsyncUtil.runAsyncWithFuture(runnable, CarbonSpigot.getInstance().getThreadManager().getTrackerThreadPool()));
            } else if (SettingsConfig.BYPASS_AWAIT_DEPEND) {
                AsyncUtil.runAsyncWithFuture(runnable, CarbonSpigot.getInstance().getThreadManager().getTrackerThreadPool());
            }
            return;
        }
        this.c.forEach((entitytrackerentry) -> {
            if (entitytrackerentry.tracker == entityplayer) {
                entitytrackerentry.addNearPlayers();
            } else {
                entitytrackerentry.updatePlayer(entityplayer);
            }
        });
    }
}
