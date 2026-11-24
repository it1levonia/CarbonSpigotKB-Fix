package xyz.refinedev.spigot.cmds.impl.op;

import com.google.common.collect.ImmutableList;

import org.apache.commons.lang.Validate;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.util.StringUtil;

import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.utils.CC;
import xyz.refinedev.spigot.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DeopCommand extends Command {

    private final ChatColor color = SettingsConfig.THEME;
     String[] HELP_MESSAGE = {
             SettingsConfig.CHAT_BAR,
             CC.translate(color + CC.BOLD + "Operator Help"),
             CC.translate(""),
             CC.translate(" &f<> &7= &fRequired &7｜ &f[] &7= &fOptional"),
             CC.translate(""),
             CC.translate("&7 * " + color + "/op &7<player> - Grant operator to player"),
             CC.translate("&7 * " + color + "/deop &7<player> - Revoke operator from a player"),
             CC.translate(""),
             SettingsConfig.CHAT_BAR,
    };

    public DeopCommand() {
        super("deop");
        this.description = "Remove specified player's operator status.";
        this.usageMessage = String.join("\n", HELP_MESSAGE);
        this.setPermission("bukkit.command.deop");
    }

    @Override
    public boolean execute(CommandSender sender, String currentAlias, String[] args) {
        if (!this.testPermission(sender)) return false;

        if (args.length != 1 || args[0].length() == 0) {
            sender.sendMessage(HELP_MESSAGE);
        } else {
            OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);
            player.setOp(false);
            sender.sendMessage(CC.translate("&7You've taken " + color + player.getName() + "'s &7permissions for " + color + "operator&7!"));
            if (player.isOnline()) {
                player.getPlayer().sendMessage(" ");
                player.getPlayer().sendMessage(CC.translate(StringUtils.PREFIX + "&7Your " + color + "operator status &7has been removed."));
                player.getPlayer().sendMessage(" ");
            }
        }
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        Validate.notNull(sender, "Sender cannot be null");
        Validate.notNull(args, "Arguments cannot be null");
        Validate.notNull(alias, "Alias cannot be null");
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();
            for ( OfflinePlayer player : Bukkit.getOperators() ) {
                String playerName = player.getName();
                if (StringUtil.startsWithIgnoreCase(playerName, args[0])) {
                    completions.add(playerName);
                }
            }
            return completions;
        }
        return ImmutableList.of();
    }
}
