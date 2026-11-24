package xyz.refinedev.spigot.cmds;

import net.minecraft.server.AsyncUtil;
import net.minecraft.server.PacketPlayOutExplosion;
import net.minecraft.server.Vec3D;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import xyz.refinedev.spigot.api.command.annotation.Command;
import xyz.refinedev.spigot.api.command.annotation.Register;
import xyz.refinedev.spigot.api.command.annotation.Require;
import xyz.refinedev.spigot.api.command.annotation.Sender;

import xyz.refinedev.spigot.CarbonSpigot;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.feature.async.profiler.NoOpAsyncProfiler;
import xyz.refinedev.spigot.feature.async.profiler.TimeoutAsyncProfiler;
import xyz.refinedev.spigot.utils.CC;
import xyz.refinedev.spigot.utils.StringUtils;
import xyz.refinedev.spigot.utils.traffic.StaticConstants;

import java.util.Collections;

@Register(name = "carbon", aliases = "carbonspigot")
@SuppressWarnings("unused")
public class CarbonCommand  {

    private final ChatColor color = SettingsConfig.THEME;

    String[] HELP_MESSAGE = {
            SettingsConfig.CHAT_BAR,
            CC.translate(color + CC.BOLD + "Carbon Help"),
            CC.translate(""),
            CC.translate(" &f<> &7= &fRequired &7｜ &f[] &7= &fOptional"),
            CC.translate(""),
            CC.translate("&7 * " + color + "/carbon &7- View this message"),
            CC.translate("&7 * " + color + "/carbon reload &7- Reload carbon config"),
            CC.translate("&7 * " + color + "/carbon save &7- Save carbon config"),
            CC.translate(""),
            CC.translate("&7 * " + color + "/setSlots &7<amount> &7- Set the server's max players"),
            CC.translate("&7 * " + color + "/shrug &7- Force type ¯\\_(ツ)_/¯ in chat"),
            CC.translate("&7 * " + color + "/cry &7- Force type ¯(ಥ _ ಥ) in chat"),
            CC.translate("&7 * " + color + "/smh &7- Force type (￣﹃￣) in chat"),
            CC.translate("&7 * " + color + "/killall &7- Kill all entities in all worlds"),
            CC.translate("&7 * " + color + "/day &7- Set your own time to day"),
            CC.translate("&7 * " + color + "/night &7- Set your own time to night"),
            CC.translate("&7 * " + color + "/hide &7<target> &7- Toggle a player's visibility for yourself"),
            CC.translate("&7 * " + color + "/plugins &7[pageNumber] &7- View plugins list"),
            CC.translate("&7 * " + color + "/plugin <enable/disable/load> <pluginName> &7- Manage plugins"),
            CC.translate("&7 * " + color + "/knockback &7- View knockback commands"),
            CC.translate("&7 * " + color + "/potion &7- View potion settings commands"),
            CC.translate("&7 * " + color + "/pearl &7- View pearl settings commands"),
            SettingsConfig.CHAT_BAR
    };

    @Command(name = "", aliases = "help", desc = "View CarbonSpigot commands")
    @Require("carbon.help")
    public void help(@Sender CommandSender sender) {
        sender.sendMessage(HELP_MESSAGE);
    }

    @Command(name = "reload", desc = "Reload carbon settings from file")
    @Require("carbon.help")
    public void reload(@Sender CommandSender sender) {
        CarbonSpigot.getConfig().reload();
        CarbonSpigot.getInstance().getResourcePackHandler().init();
        CarbonSpigot.getInstance().setupTps();
        if (!(SettingsConfig.ASYNC_MONITOR_TIMEOUT_ENABLED && AsyncUtil.ASYNC_PROFILER instanceof TimeoutAsyncProfiler)) {
            AsyncUtil.ASYNC_PROFILER = SettingsConfig.ASYNC_MONITOR_TIMEOUT_ENABLED ? new TimeoutAsyncProfiler() : new NoOpAsyncProfiler();
        }

        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&fSuccessfully&a re-loaded &fall configuration files!"));
    }

    @Command(name = "save", desc = "Save carbon settings to file")
    @Require("carbon.help")
    public void save(@Sender CommandSender sender) {
        CarbonSpigot.getConfig().writeConfig();
        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&fSuccessfully&a saved &fall configuration files!"));
    }

    @Command(name = "crash", desc = "Crash a player's client")
    @Require("carbon.crash")
    public void crash(@Sender CommandSender sender, Player player) {
        double doubleValue = StaticConstants.d();
        float floatValue = StaticConstants.f();

        PacketPlayOutExplosion explosion = new PacketPlayOutExplosion(
                doubleValue, doubleValue, doubleValue,
                floatValue,
                Collections.emptyList(),
                new Vec3D(doubleValue, doubleValue, doubleValue));

        player.carbon().sendPacket(explosion);
    }
}