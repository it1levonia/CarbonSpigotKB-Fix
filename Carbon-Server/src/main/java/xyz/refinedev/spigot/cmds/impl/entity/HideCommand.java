package xyz.refinedev.spigot.cmds.impl.entity;

import org.bukkit.entity.Player;

import xyz.refinedev.spigot.api.command.annotation.Command;
import xyz.refinedev.spigot.api.command.annotation.Register;
import xyz.refinedev.spigot.api.command.annotation.Require;
import xyz.refinedev.spigot.api.command.annotation.Sender;

import xyz.refinedev.spigot.utils.CC;
import xyz.refinedev.spigot.utils.StringUtils;

@Register(name = "hide", aliases = {"toggeplayer", "show"})
@SuppressWarnings("unused")
public class HideCommand{

    @Command(name = "", usage = "<target>", desc = "Toggle a player's visibility for yourself")
    @Require("carbon.hide")
    public void execute(@Sender Player player, Player target) {
        if (player == target) {
            player.sendMessage("§cYou can not edit your own visibility!");
            return;
        }

        boolean see = player.canSee(target);
        if (see) {
            player.hidePlayer(target);
            player.sendMessage(CC.translate(StringUtils.PREFIX + "&c" + target.getName() + " &7is now hidden for you."));
        } else {
            player.showPlayer(target);
            player.sendMessage(CC.translate(StringUtils.PREFIX + "&7You can now see &c" + target.getName() + "&7."));
        }
    }
}
