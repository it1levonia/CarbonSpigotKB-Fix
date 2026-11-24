package xyz.refinedev.spigot.cmds.impl.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import xyz.refinedev.spigot.api.command.annotation.Command;
import xyz.refinedev.spigot.api.command.annotation.Register;
import xyz.refinedev.spigot.api.command.annotation.Require;
import xyz.refinedev.spigot.api.command.annotation.Sender;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.utils.CC;
import xyz.refinedev.spigot.utils.StringUtils;

@Register(name = "setSlots", aliases = "setMaxPlayers")
@SuppressWarnings("unused")
public class SetSlotsCommand {

    @Command(name = "", usage = "<amount>", aliases = "help", desc = "Set maximum amount of players")
    @Require("carbon.setslots")
    public void slots(@Sender CommandSender sender, int amount) {
        Bukkit.getServer().setMaxPlayers(amount);
        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&7Set the maximum players to " + SettingsConfig.THEME + amount + "&7!"));
    }
}
