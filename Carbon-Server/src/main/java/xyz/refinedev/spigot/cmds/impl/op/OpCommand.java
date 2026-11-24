package xyz.refinedev.spigot.cmds.impl.op;

import com.google.common.collect.ImmutableList;

import org.apache.commons.lang.Validate;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.utils.CC;
import xyz.refinedev.spigot.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OpCommand extends Command {

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

    public OpCommand() {
        super("op");
        this.description = "Grant operator status to specified player.";
        this.usageMessage = String.join("\n", HELP_MESSAGE);
        this.setPermission("bukkit.command.op");
    }

    @Override
    public boolean execute(CommandSender sender, String currentAlias, String[] args) {
        if (!this.testPermission(sender)) return false;

        if (args.length != 1 || args[0].length() == 0) {
            sender.sendMessage(HELP_MESSAGE);
        } else {
            OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);
            player.setOp(true);
            sender.sendMessage(CC.translate("&7You've granted " + SettingsConfig.THEME + player.getName() + " &7permissions for " + SettingsConfig.THEME + "operator&7!"));
            if (player.isOnline()) {
                player.getPlayer().sendMessage(" ");
                player.getPlayer().sendMessage(CC.translate(StringUtils.PREFIX + "&7You've been granted " + color + "Operator Status &7!"));
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
            if (!(sender instanceof Player)) {
                return ImmutableList.of();
            }
            String lastWord = args[0];
            if (lastWord.length() == 0) {
                return ImmutableList.of();
            }
            Player senderPlayer = (Player) sender;
            ArrayList<String> matchedPlayers = new ArrayList<>();
            for ( Player player : sender.getServer().getOnlinePlayers() ) {
                String name = player.getName();
                if (!senderPlayer.canSee(player) || player.isOp()) {
                    continue;
                }
                if (StringUtil.startsWithIgnoreCase(name, lastWord)) {
                    matchedPlayers.add(name);
                }
            }
            matchedPlayers.sort(String.CASE_INSENSITIVE_ORDER);
            return matchedPlayers;
        }
        return ImmutableList.of();
    }
}
