package xyz.refinedev.spigot.api.command.command;

import org.bukkit.command.CommandSender;
import xyz.refinedev.spigot.api.command.command.DrinkCommandContainer;

public interface HelpFormatter {

    void sendHelpFor(CommandSender sender, DrinkCommandContainer container);
}
