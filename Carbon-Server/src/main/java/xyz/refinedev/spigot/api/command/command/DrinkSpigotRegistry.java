package xyz.refinedev.spigot.api.command.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.craftbukkit.CraftServer;
import xyz.refinedev.spigot.api.command.command.DrinkCommandContainer;
import xyz.refinedev.spigot.api.command.command.DrinkCommandService;
import xyz.refinedev.spigot.api.command.exception.CommandRegistrationException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DrinkSpigotRegistry {

    private final DrinkCommandService commandService;
    private SimpleCommandMap commandMap;

    public DrinkSpigotRegistry(DrinkCommandService commandService) {
        this.commandService = commandService;
        commandMap = ((CraftServer)Bukkit.getServer()).getCommandMap();
    }

    public boolean register(DrinkCommandContainer container, boolean unregisterExisting) throws CommandRegistrationException {
        return commandMap.register(container.getCommandService().getPlugin().getName(), container);
    }
}
