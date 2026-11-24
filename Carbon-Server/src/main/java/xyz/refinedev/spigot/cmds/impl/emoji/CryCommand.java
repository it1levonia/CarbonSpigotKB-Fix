package xyz.refinedev.spigot.cmds.impl.emoji;

import org.bukkit.entity.Player;

import xyz.refinedev.spigot.api.command.annotation.Command;
import xyz.refinedev.spigot.api.command.annotation.Register;
import xyz.refinedev.spigot.api.command.annotation.Sender;

/**
 * This Project is property of Refine Development © 2021 2023
 * Redistribution of this Project is not allowed
 *
 * @author Drizzy
 * @since 8/11/2022
 * @version CarbonSpigot
 */

@Register(name = "cry")
public class CryCommand {

    @Command(name = "", aliases = "help", desc = "Type the cry emoji in chat")
    public void execute(@Sender Player sender) {
        sender.chat("(ಥ _ ಥ)");
    }
}
