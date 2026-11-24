package xyz.refinedev.spigot.cmds.impl.settings;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import xyz.refinedev.spigot.api.command.annotation.Command;
import xyz.refinedev.spigot.api.command.annotation.Register;
import xyz.refinedev.spigot.api.command.annotation.Require;
import xyz.refinedev.spigot.api.command.annotation.Sender;
import xyz.refinedev.spigot.CarbonSpigot;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.utils.CC;
import xyz.refinedev.spigot.utils.StringUtils;

/**
 * This Project is property of Refine Development © 2021
 * Redistribution of this Project is not allowed
 *
 * @author Drizzy
 * Created at 6/8/2021
 * @version CarbonSpigot
 */

@Register(name = "potion", aliases = {"potionSettings", "pot"})
public class PotionSettingsCommand {

    private final ChatColor color = SettingsConfig.THEME;

    private final String[] HELP_MESSAGE = {
            SettingsConfig.CHAT_BAR,
            CC.translate(color + CC.BOLD + "Potion Help"),
            CC.translate(""),
            CC.translate(" &f<> &7= &fRequired &7｜ &f[] &7= &fOptional"),
            CC.translate(""),
            CC.translate("&7 * " + color + "/potion values &7- View current potion settings"),
            CC.translate("&7 * " + color + "/potion speed &7<value> &7- Set Potion Throw Speed"),
            CC.translate("&7 * " + color + "/potion gravity &7<value> &7- Set Potion Throw Gravity"),
            CC.translate("&7 * " + color + "/potion time &7<value> &7- Set Potion Air Time"),
            CC.translate("&7 * " + color + "/potion vertical-offset &7<value> &7- Set Potion Throw vertical-offset"),
            CC.translate("&7 * " + color + "/potion horizontal-offset &7<value> &7- Set Potion Throw horizontal-offset"),
            CC.translate("&7 * " + color + "/potion smoothPots &7<true|false> &7- Set Smooth-Potion Mode"),
            CC.translate("&7 * " + color + "/potion reducedSplash &7<true|false> &7- Set Reduced-Splash Mode"),
            SettingsConfig.CHAT_BAR
    };

    @Command(name = "", aliases = "help", desc = "View Potion Setting commands")
    @Require("carbon.potion")
    public void help(@Sender CommandSender sender) {
        sender.sendMessage(HELP_MESSAGE);
    }

    @Command(name = "values", desc = "View Potion values")
    @Require("carbon.potion")
    public void values(@Sender CommandSender sender) {
        sender.sendMessage(SettingsConfig.CHAT_BAR);
        sender.sendMessage(SettingsConfig.THEME + "Potion Values");
        sender.sendMessage("");
        sender.sendMessage(CC.translate("&7 * &cSpeed&7: &f" + SettingsConfig.POTION_SPEED));
        sender.sendMessage(CC.translate("&7 * &cGravity&7: &f" + SettingsConfig.POTION_GRAVITY));
        sender.sendMessage(CC.translate("&7 * &cAir Ticks&7: &f" + SettingsConfig.POTION_AIR_TICKS));
        sender.sendMessage(CC.translate("&7 * &cVertical-Offset&7: &f" + SettingsConfig.POTION_VERTICAL_OFFSET));
        //sender.sendMessage(CC.translate("&7 * &cHorizontal-Offset&7: &f" + SettingsConfig.POTION_HORIZONTAL_OFFSET));
        sender.sendMessage(CC.translate("&7 * &cSmooth-Potions: &f" + SettingsConfig.SMOOTH_POTIONS));
        sender.sendMessage(CC.translate("&7 * &cReduced-Splash: &f" + SettingsConfig.REDUCED_SPLASH));
        sender.sendMessage(SettingsConfig.CHAT_BAR);
    }


    @Command(name = "speed", usage = "<value>", desc = "Set potion speed")
    @Require("carbon.potion")
    public void speed(@Sender CommandSender sender, double value) {
        if (Double.isNaN(value)) {
            sender.sendMessage(StringUtils.PREFIX + "&7Invalid Value");
            return;
        }
        SettingsConfig.POTION_SPEED = value;
        CarbonSpigot.getConfig().writeConfig();
        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&7You have updated potion " + color + "speed &7to " + color + value + "&7."));
    }

    @Command(name = "gravity", usage = "<value>", desc = "Set potion gravity")
    @Require("carbon.potion")
    public void gravity(@Sender CommandSender sender, double value) {
        if (Double.isNaN(value)) {
            sender.sendMessage(StringUtils.PREFIX + "&7Invalid Value");
            return;
        }
        SettingsConfig.POTION_GRAVITY = value;
        CarbonSpigot.getConfig().writeConfig();
        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&7You have updated potion " + color + "gravity &7to " + color + value + "&7."));
    }

    @Command(name = "time", usage = "<value>", desc = "Set potion time")
    @Require("carbon.potion")
    public void time(@Sender CommandSender sender, int value) {
        SettingsConfig.POTION_AIR_TICKS = value;
        CarbonSpigot.getConfig().writeConfig();
        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&7You have updated potion " + color + "time &7to " + color + value + "&7."));
    }

    @Command(name = "vertical-offset", aliases = "yOffset", usage = "<value>", desc = "Set potion vertical offset")
    @Require("carbon.potion")
    public void verticalOff(@Sender CommandSender sender, double value) {
        if (Double.isNaN(value)) {
            sender.sendMessage(StringUtils.PREFIX + "&7Invalid Value");
            return;
        }
        SettingsConfig.POTION_VERTICAL_OFFSET = value;
        CarbonSpigot.getConfig().writeConfig();
        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&7You have updated potion " + color + "vertical-offset &7to " + color + value + "&7."));
    }

//    @Command(name = "horizontal-offset", aliases = {"zOffset", "xOffset"}, usage = "<value>", desc = "Set potion horizontal offset")
//    @Require("carbon.potion")
//    public void horizontalOff(@Sender CommandSender sender, double value) {
//        if (Double.isNaN(value)) {
//            sender.sendMessage(StringUtils.PREFIX + "&7Invalid Value");
//            return;
//        }
//        SettingsConfig.POTION_HORIZONTAL_OFFSET = value;
//        CarbonSpigot.getConfig().writeConfig();
//        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&7You have updated potion " + color + "horizontal-offset &7to " + color + value + "&7."));
//    }

    @Command(name = "smoothpots", aliases = "smoothpotting", usage = "<value>", desc = "Toggle potion smooth-potting")
    @Require("carbon.potion")
    public void smoothPots(@Sender CommandSender sender, boolean value) {
        SettingsConfig.SMOOTH_POTIONS = value;
        if (SettingsConfig.REDUCED_SPLASH && SettingsConfig.SMOOTH_POTIONS) {
            SettingsConfig.REDUCED_SPLASH = false;
        }
        CarbonSpigot.getConfig().writeConfig();
        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&7You have updated potion " + color + "smooth-potting &7to " + color + value + "&7."));
    }
    @Command(name = "reducedsplash", aliases = "expandedRaytrace", usage = "<value>", desc = "Toggle potion expanded-raytrace")
    @Require("carbon.potion")
    public void betterYaw(@Sender CommandSender sender, boolean value) {
        SettingsConfig.REDUCED_SPLASH = value;
        if (SettingsConfig.REDUCED_SPLASH && SettingsConfig.SMOOTH_POTIONS) {
            SettingsConfig.SMOOTH_POTIONS = false;
        }
        CarbonSpigot.getConfig().writeConfig();
        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&7You have updated potion " + color + "expanded-raytrace &7to " + color + value + "&7."));
    }
}
