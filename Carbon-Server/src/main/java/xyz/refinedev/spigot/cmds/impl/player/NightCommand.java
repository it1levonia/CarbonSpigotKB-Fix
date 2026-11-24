package xyz.refinedev.spigot.cmds.impl.player;

import org.bukkit.command.CommandSender;
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
 * @since 9/6/2021
 * @version CarbonSpigot
 */

@Register(name = "night")
@SuppressWarnings("unused")
public class NightCommand {

    @Command(name = "", aliases = "help", desc = "Set player time to night")
    public void day(@Sender Player player) {
        if (!SettingsConfig.NIGHT_COMMAND_ENABLED) {
            player.sendMessage(SpigotConfig.unknownCommandMessage);
            return;
        }
        player.setPlayerTime(18000L, false);
        player.sendMessage(CC.translate("&aTime set to night!"));
    }
}
