package xyz.refinedev.spigot;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import net.minecraft.server.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.Main;

import xyz.refinedev.spigot.api.chunk.ChunkAPI;
import xyz.refinedev.spigot.api.handlers.PacketAPI;
import xyz.refinedev.spigot.api.handlers.impl.MovementHandler;
import xyz.refinedev.spigot.api.handlers.impl.PacketHandler;
import xyz.refinedev.spigot.api.knockback.KnockbackAPI;

import xyz.refinedev.spigot.feature.async.threading.ThreadingManager;
import xyz.refinedev.spigot.cmds.impl.bukkit.*;
import xyz.refinedev.spigot.cmds.impl.op.DeopCommand;
import xyz.refinedev.spigot.cmds.impl.op.OpCommand;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.knockback.KnockbackHandler;
import xyz.refinedev.spigot.feature.console.filter.LogFilter;
import xyz.refinedev.spigot.feature.pack.ResourcePackHandler;
import xyz.refinedev.spigot.plugin.ServerSidePlugin;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@Getter @Log4j2
public class CarbonSpigot {

    public static final String version = "4.3.4";

    private static CarbonSpigot instance;
    @Getter private static KnockbackAPI knockbackAPI;
    @Getter private static PacketAPI packetAPI;
    @Getter private static ChunkAPI chunkAPI;

    @Getter private static SettingsConfig config;

    private boolean instantiated;

    final List<MovementHandler> movementHandlers = new LinkedList<>();
    final List<PacketHandler> packetHandlers = new LinkedList<>();

    final KnockbackHandler knockbackHandler = new KnockbackHandler();
    final ServerSidePlugin serverSidePlugin = new ServerSidePlugin();
    final ThreadingManager threadManager = new ThreadingManager();
    final ResourcePackHandler resourcePackHandler = new ResourcePackHandler();

    public CarbonSpigot(SettingsConfig settingsConfig) {
        instance = this;
        config = settingsConfig;
        knockbackAPI = new KnockbackAPI(this);
        packetAPI = new PacketAPI(this);
        chunkAPI = new ChunkAPI();
    }

    public void init() {
        registerPlugin();

        threadManager.getMainPool().schedule(System::gc, 40L, TimeUnit.MILLISECONDS);

        instantiated = true;
    }

    public void initFilter() {
        if (!SettingsConfig.FILTER_ENABLED) return;

        LogFilter logFilter = new LogFilter();
        Logger logger = (Logger) LogManager.getRootLogger();
        logger.addFilter(logFilter);
    }

    /**
     * Register the carbon-plugin's expansions and tasks
     */
    public void registerPlugin() {
        Bukkit.getServer().getCommandMap().register("spigot", new OpCommand());
        Bukkit.getServer().getCommandMap().register("spigot", new DeopCommand());
    }

    public void setupTps() {
        MinecraftServer.TPS = SettingsConfig.TARGET_TPS;
        MinecraftServer.TICK_TIME = 1000000000 / MinecraftServer.TPS;
    }

    public void shutDown() {
        if (!instantiated) return;

        if (ServerSidePlugin.getInstance() != null && ServerSidePlugin.getInstance().isEnabled()) {
            Bukkit.getScheduler().cancelTasks(ServerSidePlugin.getInstance());
        }

        this.threadManager.shutdown();
        this.knockbackHandler.save();
    }

    /**
     * Register a {@link MovementHandler} to be called upon when
     * {@link PlayerConnection} triggers it
     *
     * @param movementHandler the movement handler being registered
     */
    public void registerMovementHandler(MovementHandler movementHandler) {
        this.movementHandlers.add(movementHandler);
    }

    /**
     * Remove a {@link MovementHandler}
     *
     * @param movementHandler the handler being removed
     */
    public void removeMovementHandler(MovementHandler movementHandler) {
        this.movementHandlers.remove(movementHandler);
    }

    /**
     * Register a {@link PacketHandler} to be called upon when
     * {@link NetworkManager} triggers it
     *
     * @param packetHandler the packet handler being registered
     */
    public void registerPacketHandler(PacketHandler packetHandler) {
        this.packetHandlers.add(packetHandler);
    }

    /**
     * Remove a {@link PacketHandler}
     *
     * @param packetHandler the handler being removed
     */
    public void removePacketHandler(PacketHandler packetHandler) {
        this.packetHandlers.remove(packetHandler);
    }

    public static CarbonSpigot getInstance() {
        if (instance == null) {
            instance = new CarbonSpigot(Main.getConfig());
        }
        return instance;
    }
}