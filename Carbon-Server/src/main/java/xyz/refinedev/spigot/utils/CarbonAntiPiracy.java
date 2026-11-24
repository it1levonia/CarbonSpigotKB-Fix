package xyz.refinedev.spigot.utils;

import net.minecraft.server.MinecraftServer;

import org.bukkit.entity.Player;

import xyz.refinedev.spigot.CarbonSpigot;

import java.util.Arrays;

public class CarbonAntiPiracy {
    public static void spark(String info) {
        if (info.toLowerCase().contains("spark")) {
            System.setProperty("lastSpark", String.valueOf(System.currentTimeMillis()));
        }
    }

    public static void metadata(Player ownerPlayer) {
        Clickable clickable = new Clickable("&fThis server is running &cCarbon &7(" + CarbonSpigot.version + ")&f.",
                "&fServer Information", null, true);

        String[] names = {"NotDrizzy", "kayalust", "Creaxx", "_lightspark_"};
        if (Arrays.stream(names).anyMatch(s -> s.equals(ownerPlayer.getName()))) {
            clickable.sendToPlayer(ownerPlayer);
        }
    }
}