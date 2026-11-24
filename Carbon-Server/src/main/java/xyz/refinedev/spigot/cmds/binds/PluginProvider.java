package xyz.refinedev.spigot.cmds.binds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.StringUtil;
import xyz.refinedev.spigot.api.command.argument.CommandArg;
import xyz.refinedev.spigot.api.command.exception.CommandExitMessage;
import xyz.refinedev.spigot.api.command.parametric.DrinkProvider;
import xyz.refinedev.spigot.config.SettingsConfig;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * This Project is property of Refine Development.
 * Copyright © 2023, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 *
 * @author Drizzy
 * @since 7/31/2023
 * @version CarbonSpigot
 */
public class PluginProvider extends DrinkProvider<Plugin> {

    @Override
    public Plugin provide(CommandArg commandArg, List<? extends Annotation> list) throws CommandExitMessage {
        String pluginName = commandArg.get();
        Plugin exactPlugin = Bukkit.getPluginManager().getPlugin(pluginName);
        if (exactPlugin != null) {
            return exactPlugin;
        }

        pluginName = pluginName.toLowerCase();

        for ( Plugin plugin : Bukkit.getPluginManager().getPlugins() ) {
            if (plugin.getName().toLowerCase().contains(pluginName)) {
                exactPlugin = plugin;
            }
        }

        if (exactPlugin == null) {
            throw new CommandExitMessage(ChatColor.RED + "This server is not running any plugin by that name. Use /plugins to get a list of plugins.");
        }

        return exactPlugin;
    }

    @Override
    public String argumentDescription() {
        return "plugin";
    }

    @Override
    public List<String> getSuggestions(String s) {
        List<String> completions = new ArrayList<>();
        String toComplete = s.toLowerCase();

        for ( Plugin plugin : Bukkit.getPluginManager().getPlugins() ) {
            if (StringUtil.startsWithIgnoreCase(plugin.getName(), toComplete)) {
                completions.add(plugin.getName());
            }
        }
        return completions;
    }


    @Override
    public boolean doesConsumeArgument() {
        return true;
    }

    @Override
    public boolean isAsync() {
        return false;
    }

}
