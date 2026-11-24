package xyz.refinedev.spigot.cmds.impl.emoji;

import org.bukkit.entity.Player;

import xyz.refinedev.spigot.api.command.annotation.Command;
import xyz.refinedev.spigot.api.command.annotation.Register;
import xyz.refinedev.spigot.api.command.annotation.Sender;

import java.util.Collections;

@Register(name = "shrug")
public class ShrugCommand {

    @Command(name = "", aliases = "help", desc = "Type the shrug emoji in chat")
    public void execute(@Sender Player sender) {
        sender.chat("¯\\_(ツ)_/¯");
    }
}