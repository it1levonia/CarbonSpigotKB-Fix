package xyz.refinedev.spigot.cmds.impl.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.plugin.PluginManager;
import xyz.refinedev.spigot.api.command.annotation.Command;
import xyz.refinedev.spigot.api.command.annotation.Register;
import xyz.refinedev.spigot.api.command.annotation.Require;
import xyz.refinedev.spigot.api.command.annotation.Sender;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.utils.CC;
import xyz.refinedev.spigot.utils.StringUtils;

/**
 * This Project is property of Refine Development.
 * Copyright © 2023, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 *
 * @author Drizzy
 * @since 4/1/2023
 * @version CarbonSpigot
 */

@Register(name = "chunkunload", aliases = "unloadchunks")
public class ChunkUnloadCommand {

    @Command(name = "", aliases = "help", desc = "Force unload all unused chunks")
    @Require("carbon.chunkunload")
    public void unload(@Sender CommandSender sender) {
        int chunks = 0;

        PluginManager pluginManager = Bukkit.getPluginManager();
        for ( World world : Bukkit.getServer().getWorlds() ) {
            for ( Chunk chunk : world.getCachedChunks() ) {
                if (world.isChunkInUse(chunk.getX(), chunk.getZ())) continue;

                ChunkUnloadEvent event = new ChunkUnloadEvent(chunk);
                pluginManager.callEvent(event);

                if (chunk.unload(world.isAutoSave())) chunks++;
            }
        }

        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&fSuccessfully unloaded " + SettingsConfig.THEME + chunks + "&f chunks"));
    }
}
