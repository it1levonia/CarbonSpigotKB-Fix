package xyz.refinedev.spigot.cmds.impl.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import xyz.refinedev.spigot.api.command.annotation.Command;
import xyz.refinedev.spigot.api.command.annotation.Register;
import xyz.refinedev.spigot.api.command.annotation.Require;
import xyz.refinedev.spigot.api.command.annotation.Sender;
import xyz.refinedev.spigot.config.SettingsConfig;

@Register(name = "reload", aliases = "rl")
@SuppressWarnings("unused")
public class ReloadCommand {

    @Command(name = "", aliases = "help", desc = "Reloads the server configuration and plugins")
    @Require("bukkit.command.reload")
    public void reload(@Sender CommandSender sender) {
        if (!SettingsConfig.RELOAD_COMMAND_ENABLED) return;

        sender.sendMessage(ChatColor.RED + "Please note that this command is not supported and may cause issues when using some plugins.");
        sender.sendMessage(ChatColor.RED + "If you encounter any issues please use the /stop command to restart your server.");
        Bukkit.reload();
        sender.sendMessage(ChatColor.GREEN + "Reload complete.");
    }
}
