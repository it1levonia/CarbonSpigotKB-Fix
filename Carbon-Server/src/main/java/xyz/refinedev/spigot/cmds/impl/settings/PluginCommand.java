package xyz.refinedev.spigot.cmds.impl.settings;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import xyz.refinedev.spigot.api.command.annotation.Command;
import xyz.refinedev.spigot.api.command.annotation.Register;
import xyz.refinedev.spigot.api.command.annotation.Require;
import xyz.refinedev.spigot.api.command.annotation.Sender;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.utils.PluginUtil;
import xyz.refinedev.spigot.utils.CC;
import xyz.refinedev.spigot.utils.StringUtils;

/**
 * This Project is property of Refine Development.
 * Copyright © 2023, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 *
 * @author Drizzy
 * @since 3/28/2023
 * @version CarbonSpigot
 */

@Register(name = "plugin")
public class PluginCommand {

    private final static ChatColor color = SettingsConfig.THEME;

    private static final String[] HELP_MESSAGE = {
            SettingsConfig.CHAT_BAR,
            CC.translate(color + CC.BOLD + "Plugin Manage Help"),
            CC.translate(""),
            CC.translate(" &f<> &7= &fRequired") + CC.GRAY + " | " + CC.translate("&f[] &7= &fOptional"),
            CC.translate(""),
            CC.translate("&7* " + color + "/plugin reload <plugin> &7- Reload a plugin"),
            CC.translate("&7* " + color + "/plugin load <file-name> &7- Load a plugin from file inside plugins folder"),
            CC.translate("&7* " + color + "/plugin enable <plugin> &7- Enable a disabled plugin"),
            CC.translate("&7* " + color + "/plugin disable <plugin> &7- Disable an enabled plugin"),
            SettingsConfig.CHAT_BAR
    };

    @Command(name = "", aliases = "help", desc = "View plugin commands")
    @Require("carbon.plugin")
    public void help(@Sender CommandSender sender) {
        sender.sendMessage(HELP_MESSAGE);
    }

    @Command(name = "reload", usage = "<plugin>", desc = "Reload a plugin")
    @Require("carbon.plugin")
    public void reload(@Sender CommandSender sender, Plugin plugin) {
        PluginUtil.reload(plugin);
        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&aSuccessfully reloaded the specified plugin!"));
    }

    @Command(name = "load", usage = "<file-name>", desc = "Load a plugin from file")
    @Require("carbon.plugin")
    public void load(@Sender CommandSender sender, String pluginName) {
        sender.sendMessage(PluginUtil.load(pluginName));
    }

    @Command(name = "enable", usage = "<plugin>", desc = "Enable a plugin")
    @Require("carbon.plugin")
    public void enable(@Sender CommandSender sender, Plugin plugin) {
        if (plugin.isEnabled()) {
            sender.sendMessage(CC.translate(StringUtils.PREFIX + "&cThe specified plugin is already enabled!"));
            return;
        }
        PluginUtil.enable(plugin);
        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&aSuccessfully enabled the specified plugin!"));
    }

    @Command(name = "disable", usage = "<plugin>", desc = "Disable a plugin")
    @Require("carbon.plugin")
    public void disable(@Sender CommandSender sender, Plugin plugin) {
        if (!plugin.isEnabled()) {
            sender.sendMessage(CC.translate(StringUtils.PREFIX + "&cThe specified plugin is already disabled!"));
            return;
        }
        PluginUtil.disable(plugin);
        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&aSuccessfully disabled the specified plugin!"));
    }
}
