package xyz.refinedev.spigot.cmds.impl.entity;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import xyz.refinedev.spigot.api.command.annotation.Command;
import xyz.refinedev.spigot.api.command.annotation.Register;
import xyz.refinedev.spigot.api.command.annotation.Require;
import xyz.refinedev.spigot.api.command.annotation.Sender;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.utils.StringUtils;

import java.util.Collections;

@Register(name = "killall", aliases = "clearentities")
@SuppressWarnings("unused")
public class ClearEntitiesCommand  {

    @Command(name = "", aliases = "help", desc = "Kill all entities")
    @Require("carbon.killall")
    public void kill(@Sender CommandSender sender) {
        int i = 0;
        for ( World world : Bukkit.getWorlds() ) {
            for ( Entity entity : world.getEntities() ) {
                EntityType entityType = entity.getType();
                if (entityType == EntityType.DROPPED_ITEM
                        || entityType == EntityType.BOAT
                        || entityType == EntityType.PRIMED_TNT
                        || entityType == EntityType.SKELETON
                        || entityType == EntityType.ZOMBIE
                        || entityType == EntityType.COW
                        || entityType == EntityType.SHEEP
                        || entityType == EntityType.ENDERMAN
                        || entityType == EntityType.PIG_ZOMBIE
                        || entityType == EntityType.PIG
                        || entityType == EntityType.CREEPER
                        || entityType == EntityType.BAT
                        || entityType == EntityType.CHICKEN
                        || entityType == EntityType.CAVE_SPIDER
                        || entityType == EntityType.SPIDER
                        || entityType == EntityType.WITCH
                        || entityType == EntityType.HORSE
                ) {
                    entity.remove();
                    i++;
                }
            }
        }
        sender.sendMessage(StringUtils.PREFIX + ChatColor.GRAY + "You have removed a total of " + SettingsConfig.THEME + i + ChatColor.GRAY + " entities");
    }

}
