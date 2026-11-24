package xyz.refinedev.spigot.cmds.impl.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.spigotmc.SpigotConfig;
import xyz.refinedev.spigot.api.command.annotation.Command;
import xyz.refinedev.spigot.api.command.annotation.OptArg;
import xyz.refinedev.spigot.api.command.annotation.Register;
import xyz.refinedev.spigot.api.command.annotation.Sender;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.utils.CC;

@Register(name = "ping")
@SuppressWarnings("unused")
public class PingCommand {

    @Command(name = "", usage = "[target]", aliases = "help", desc = "View a player's ping")
    public void ping(@Sender Player player, @OptArg Player target) {
        if (!SettingsConfig.PING_COMMAND_ENABLED) {
            player.sendMessage(SpigotConfig.unknownCommandMessage);
            return;
        }
        if (target == null || !player.hasPermission("carbon.ping")) {
            player.sendMessage(CC.translate(SettingsConfig.SELF_PING_MESSAGE).replace("%ping%", Integer.toString(player.spigot().getPing())));
            return;
        }

        if (player.hasPermission("carbon.ping")) {
            String finalString = CC.translate(SettingsConfig.TARGET_PING_MESSAGE)
                    .replace("%player%", target.getName())
                    .replace("%ping%", Integer.toString(target.spigot().getPing()));
            player.sendMessage(finalString);
        }
    }
}
