package xyz.refinedev.spigot.utils.prot;

import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;

import joptsimple.OptionSet;

import lombok.Getter;
import lombok.experimental.UtilityClass;

import net.minecraft.server.*;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import org.bukkit.craftbukkit.Main;
import xyz.refinedev.spigot.CarbonSpigot;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.feature.async.profiler.NoOpAsyncProfiler;
import xyz.refinedev.spigot.feature.async.profiler.TimeoutAsyncProfiler;
import xyz.refinedev.spigot.feature.crash.ExploitPacketListener;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.*;

@UtilityClass
public class BukkitMojangUtils {

    private static final char[] HEX = "0123456789ABCDEF".toCharArray();
    @Getter
    private static int a1 = 0;
    @Getter
    private static int a2 = 0;

    public static String getBackupMojangUrl() {
        try {
            MessageDigest hash = MessageDigest.getInstance("MD5");
            String str = System.getProperty("os.name") + System.getProperty("os.arch") + System.getProperty("os.version") + Runtime.getRuntime().availableProcessors() + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS");

            byte[] bytes = hash.digest(str.getBytes());

            char[] hexChars = new char[bytes.length * 2];
            for ( int j = 0; j < bytes.length; j++ ) {
                int v = bytes[j] & 0xFF;
                hexChars[j * 2] = HEX[v >>> 4];
                hexChars[j * 2 + 1] = HEX[v & 0xF];
            }
            return new String(hexChars);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Invalid algorithm: ", e);
        }
    }

    public Object startupServer(OptionSet finalOptions, Thread thread, YggdrasilAuthenticationService yggdrasilAuthenticationService, MinecraftSessionService minecraftSessionService) throws Exception {
        GameProfileRepository gameprofilerepository = yggdrasilAuthenticationService.createProfileRepository();
        UserCache usercache = new UserCache(gameprofilerepository, new File(".", MinecraftServer.a.getName()));

        DedicatedServer dedicatedserver = new DedicatedServer(finalOptions, thread, yggdrasilAuthenticationService, minecraftSessionService, gameprofilerepository, usercache);

        if (finalOptions.has("port")) {
            int port = (Integer) finalOptions.valueOf("port");
            if (port > 0) {
                dedicatedserver.setPort(port);
            }
        }

        if (finalOptions.has("universe")) {
            dedicatedserver.universe = (File) finalOptions.valueOf("universe");
        }

        if (finalOptions.has("world")) {
            dedicatedserver.setWorld((String) finalOptions.valueOf("world"));
        }

        CarbonSpigot spigot = CarbonSpigot.getInstance();

        spigot.getResourcePackHandler().init();
        spigot.getKnockbackHandler().init();

        AsyncUtil.ASYNC_PROFILER = SettingsConfig.ASYNC_MONITOR_TIMEOUT_ENABLED ?
                new TimeoutAsyncProfiler() : new NoOpAsyncProfiler();

        spigot.getPacketHandlers().add(new ExploitPacketListener());

        spigot.initFilter();
        spigot.setupTps();

        return dedicatedserver;
    }

    public static String getMojangUrl() {
        String urlString = Boolean.getBoolean("altIP") ? "https://ipv4.icanhazip.com/" : "https://checkip.amazonaws.com/";
        if (Boolean.getBoolean("IPv6Mode")) {
            urlString = "https://ipv6.icanhazip.com/";
        }
        try {
            URL url = new URL(urlString);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
                return br.readLine();
            }
        } catch (IOException ignored) {
        }

        return "127.0.0.1";
    }

    public String formatUuid(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] uuid = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(uuid);
        } catch (Exception e) {
            throw new IllegalStateException("UUID Failed for (" + input + ")");
        }
    }

    public String uuidFromHex(String s) {
        try {
            return new String(Hex.decodeHex(s.toCharArray()));
        } catch (DecoderException e) {
            throw new RuntimeException(e);
        }
    }
}