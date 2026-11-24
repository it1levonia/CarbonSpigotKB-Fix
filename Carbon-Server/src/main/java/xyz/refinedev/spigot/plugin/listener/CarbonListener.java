package xyz.refinedev.spigot.plugin.listener;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

import net.minecraft.server.MathHelper;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import org.spigotmc.SpigotConfig;

import xyz.refinedev.spigot.CarbonSpigot;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.knockback.KnockbackProfile;
import xyz.refinedev.spigot.plugin.ServerSidePlugin;
import xyz.refinedev.spigot.utils.CC;

import java.util.Arrays;

/**
 * This Project is property of Refine Development.
 * Copyright © 2023, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 *
 * @author Drizzy
 * @since 1/26/2023
 * @version CarbonSpigot
 */

public class CarbonListener implements Listener {


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onArrowVelocity(PlayerVelocityEvent event) {
        Player player = event.getPlayer();
        if (player.getLastDamageCause() == null) return;

        // Per Knockback configuration
        KnockbackProfile profile = (KnockbackProfile) player.carbon().getKnockbackProfile();
        if (!profile.getStraightBow().getValue()) return;

        Vector velocity = event.getVelocity();
        EntityDamageEvent damageEvent = player.getLastDamageCause();
        if (damageEvent == null || damageEvent.isCancelled() || !(damageEvent instanceof EntityDamageByEntityEvent)) return;

        // Need it to be a EntityDamageByEntityEvent to get the attacker entity
        Entity attacker = ((EntityDamageByEntityEvent) damageEvent).getDamager();
        if (!(attacker instanceof Arrow)) return;

        Arrow arrow = (Arrow) attacker;
        // Arrow needs to be self shot
        if (!arrow.getShooter().equals(player)) return;

        // We add 0.2 at the end to increase the launch distance, it's very low for vanilla instances
        double magnitude = MathHelper.sqrt(Math.pow(velocity.getX(), 2) + Math.pow(velocity.getZ(), 2)) + 0.2;
        // Unit vector for direction of where arrow was heading
        Vector dir = arrow.getLocation().getDirection().normalize();

        double x = dir.getX() * magnitude * -1.0D;
        double z = dir.getZ() * magnitude;

        event.setVelocity(new Vector(x, velocity.getY(), z));
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onEmpty(PlayerBucketEmptyEvent event) {
        if (!Bukkit.getPluginManager().isPluginEnabled("mBedwars")) return;

        Runnable wrapper = () -> event.getPlayer().setItemInHand(new ItemStack(Material.AIR));
        Bukkit.getScheduler().runTaskLater(ServerSidePlugin.getInstance(), wrapper, 1L);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onResourcePack(PlayerResourcePackStatusEvent event) {
        if (!SettingsConfig.RESOURCE_PACK_SYSTEM) return;

        Bukkit.getScheduler().runTask(ServerSidePlugin.getInstance(), () -> {
            switch (event.getStatus()) {
                case DECLINED: {
                    if (SettingsConfig.RESOURCE_KICK_ON_DENY) {
                        Player player = event.getPlayer();
                        player.kickPlayer(CC.translate(SettingsConfig.KICK_MESSAGE));
                    }
                    break;
                }
                case FAILED_DOWNLOAD: {
                    if (SettingsConfig.RESOURCE_KICK_ON_FAIL) {
                        Player player = event.getPlayer();
                        player.kickPlayer(CC.translate(SettingsConfig.KICK_MESSAGE));
                    }
                    break;
                }
            }
        });
    }
}
