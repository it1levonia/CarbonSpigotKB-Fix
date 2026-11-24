package xyz.refinedev.spigot.api.command.command;

import lombok.Getter;
import lombok.Setter;

import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.utils.CC;

import org.bukkit.command.CommandSender;
import org.spigotmc.SpigotConfig;

@Getter @Setter
public class DrinkAuthorizer {

    public boolean isAuthorized(CommandSender sender, DrinkCommand command) {
        if (command.getPermission() != null && command.getPermission().length() > 0) {
            if (!sender.hasPermission(command.getPermission())) {
                sender.sendMessage(CC.translate(SettingsConfig.NO_PERMISSION_MESSAGE));
                return false;
            }
        }
        return true;
    }

    public boolean isAuthorized(CommandSender sender, DrinkCommandContainer command){
        if (command.getPermission() != null && command.getPermission().length() > 0) {
            if (!sender.hasPermission(command.getPermission())) {
                sender.sendMessage(CC.translate(SettingsConfig.NO_PERMISSION_MESSAGE));
                return false;
            }
        }
        return true;
    }

}
