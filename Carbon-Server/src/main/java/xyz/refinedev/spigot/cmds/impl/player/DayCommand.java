package xyz.refinedev.spigot.cmds.impl.player;

import org.bukkit.entity.Player;

import org.spigotmc.SpigotConfig;
import xyz.refinedev.spigot.api.command.annotation.Command;
import xyz.refinedev.spigot.api.command.annotation.Register;
import xyz.refinedev.spigot.api.command.annotation.Sender;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.utils.CC;

/**
 * This Project is property of Refine Development © 2021
 * Redistribution of this Project is not allowed
 *
 * @author Drizzy
 * @since 8/12/2021
 * @version CarbonSpigot
 */

@Register(name = "day")
@SuppressWarnings("unused")
public class DayCommand {

    @Command(name = "", aliases = "help", desc = "Set player time to day")
    public void day(@Sender Player player) {
        if (!SettingsConfig.DAY_COMMAND_ENABLED) {
            player.sendMessage(SpigotConfig.unknownCommandMessage);
            return;
        }
        player.setPlayerTime(1000, false);
        player.sendMessage(CC.translate("&aTime set to day!"));
    }
}
