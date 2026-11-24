package xyz.refinedev.spigot.plugin;

import lombok.Getter;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.refinedev.spigot.api.command.CommandHandler;
import xyz.refinedev.spigot.api.command.provider.EnumProvider;

import xyz.refinedev.spigot.CarbonSpigot;
import xyz.refinedev.spigot.cmds.impl.entity.TrackingRangeCommand;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.cmds.CarbonCommand;
import xyz.refinedev.spigot.cmds.binds.KnockbackProfileProvider;
import xyz.refinedev.spigot.cmds.binds.KnockbackValueProvider;
import xyz.refinedev.spigot.cmds.binds.PluginProvider;
import xyz.refinedev.spigot.cmds.impl.bukkit.*;
import xyz.refinedev.spigot.cmds.impl.emoji.CryCommand;
import xyz.refinedev.spigot.cmds.impl.emoji.SMHCommand;
import xyz.refinedev.spigot.cmds.impl.emoji.ShrugCommand;
import xyz.refinedev.spigot.cmds.impl.entity.ClearEntitiesCommand;
import xyz.refinedev.spigot.cmds.impl.entity.HideCommand;
import xyz.refinedev.spigot.cmds.impl.player.DayCommand;
import xyz.refinedev.spigot.cmds.impl.player.NightCommand;
import xyz.refinedev.spigot.cmds.impl.player.PingCommand;
import xyz.refinedev.spigot.cmds.impl.settings.*;
import xyz.refinedev.spigot.knockback.KnockbackProfile;
import xyz.refinedev.spigot.api.knockback.meta.KnockbackType;
import xyz.refinedev.spigot.api.knockback.meta.KnockbackValue;
import xyz.refinedev.spigot.feature.cps.CPSTracker;
import xyz.refinedev.spigot.plugin.listener.CarbonListener;
import xyz.refinedev.spigot.plugin.listener.ResourcePackListener;

/**
 * This Project is property of Refine Development © 2021 2023
 * Redistribution of this Project is not allowed
 *
 * @author Drizzy
 * @since 7/10/2022
 * @version CarbonSpigot
 */

@Getter
public class ServerSidePlugin {

    /**
     * This is the plugin instance for Carbon
     */
    @Getter private static JavaPlugin instance;

    private CommandHandler commandHandler;

    public void enable(CarbonSpigot spigot) {
        instance = new JavaPlugin("spigot") {};
        Bukkit.getPluginManager().registerEvents(new CarbonListener(), instance);

        if (SettingsConfig.TRACK_CPS) {
            CPSTracker tracker = new CPSTracker();
            Bukkit.getPluginManager().registerEvents(tracker, instance);
            spigot.registerPacketHandler(tracker);
        }

        if (SettingsConfig.RESOURCE_PACK_SYSTEM) {
            Bukkit.getPluginManager().registerEvents(new ResourcePackListener(), instance);
        }

        this.registerTasks(spigot);
        this.registerExpansions();
    }

    /**
     * Register our custom APIs for usage
     */
    public void registerExpansions() {
        this.commandHandler = new CommandHandler(instance);
        this.commandHandler.bind(Plugin.class).toProvider(new PluginProvider());
        this.commandHandler.bind(KnockbackProfile.class).toProvider(new KnockbackProfileProvider());
        this.commandHandler.bind(KnockbackType.class).toProvider(new EnumProvider<>(KnockbackType.class));
        this.commandHandler.bind(KnockbackValue.class).toProvider(new KnockbackValueProvider());
        this.registerCommands();
    }

    public void registerCommands() {
        this.commandHandler.register(new ChunkUnloadCommand(), "chunkunload", "unloadchunks", "unloadchunk");
        if (SettingsConfig.PLUGIN_COMMAND_ENABLED) {
            this.commandHandler.register(new PluginsCommand(), "plugins", "pl");
        }
        if (SettingsConfig.RELOAD_COMMAND_ENABLED) {
            this.commandHandler.register(new ReloadCommand(), "reload", "rl");
        }
        if (SettingsConfig.VERSION_COMMAND_ENABLED) {
            this.commandHandler.register(new VersionCommand(), "ver", "version", "about");
        }
        if (SettingsConfig.DAY_COMMAND_ENABLED) {
            this.commandHandler.register(new DayCommand(), "day");
        }
        if (SettingsConfig.NIGHT_COMMAND_ENABLED) {
            this.commandHandler.register(new NightCommand(), "night");
        }
        if (SettingsConfig.PING_COMMAND_ENABLED) {
            this.commandHandler.register(new PingCommand(), "ping");
        }
        this.commandHandler.register(new SetSlotsCommand(), "setSlots", "setMaxPlayers");
        this.commandHandler.register(new TicksPerSecondCommand(), "tps", "tickspersecond");
        this.commandHandler.register(new CryCommand(), "cry");
        this.commandHandler.register(new SMHCommand(), "smh");
        this.commandHandler.register(new ShrugCommand(), "shrug");
        this.commandHandler.register(new ClearEntitiesCommand(), "killall", "clearentities");
        this.commandHandler.register(new TrackingRangeCommand(),"trackingrange", "tracker", "ptracker");
        this.commandHandler.register(new HideCommand(), "hide",  "show", "togglePlayer");
        this.commandHandler.register(new EnderpearlSettingsCommand(), "enderpearl", "epearl", "pearl", "pearlsettings");
        this.commandHandler.register(new PotionSettingsCommand(), "pot", "potion", "potionsettings");
        this.commandHandler.register(new DebugCommand(), "cdebug", "carbondebug");
        this.commandHandler.register(new KnockbackCommand(), "knockback", "kb");
        this.commandHandler.register(new PluginCommand(), "plugin");
        this.commandHandler.register(new CarbonCommand(), "carbon");

        this.commandHandler.registerCommands();
        this.commandHandler.registerPermissions();
    }

    // Secondary FunnyProt check
    //TODO: second license check
    public void registerTasks(CarbonSpigot spigot) {

    }
}
