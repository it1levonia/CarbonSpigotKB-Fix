package xyz.refinedev.spigot.cmds.impl.settings;

import net.minecraft.server.*;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.spigotmc.SpigotConfig;
import xyz.refinedev.spigot.api.command.annotation.*;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.feature.chunk.player.AsyncPlayerChunk;
import xyz.refinedev.spigot.knockback.KnockbackProfile;
import xyz.refinedev.spigot.utils.CC;
import xyz.refinedev.spigot.utils.StringUtils;

/**
 * This Project is property of Refine Development © 2021 2023
 * Redistribution of this Project is not allowed
 *
 * @author Drizzy
 * @version CarbonSpigot
 * @since 5/4/2022
 */

@Register(name = "cdebug", aliases = "carbondebug")
@SuppressWarnings("unused")
public class DebugCommand {

    @Command(name = "", aliases = "help", desc = "Toggle drizzy mode")
    @Require("carbon.debug")
    public void main(@Sender Player player, @OptArg String password) {
        // Drizzy only niggas
        // Not a backdoor, only used for testing and debugging!
        if (password == null || !password.equalsIgnoreCase("7332971093297321101051031031011143298111121")) {
            player.sendMessage(SpigotConfig.unknownCommandMessage);
            return;
        }

        SettingsConfig.DEBUG_MODE = !SettingsConfig.DEBUG_MODE;
        player.sendMessage(CC.translate(StringUtils.PREFIX + "&7Toggled &cDebug mode &7to &" + (SettingsConfig.DEBUG_MODE ? "aTrue" : "cFalse")));
    }

    @Command(name = "chunk", desc = "Debug current player chunk")
    @Require("carbon.debug")
    public void check(@Sender Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();

        World world = entityPlayer.getWorld();
        PlayerChunkMap.PlayerChunk playerChunk = ((WorldServer) world).getPlayerChunkMap().a(entityPlayer.getChunkX(), entityPlayer.getChunkZ(), false);

        if (playerChunk == null) {
            player.sendMessage(CC.translate("&cPlayer chunk is null!"));
            return;
        }

        String[] msg = {
                SettingsConfig.CHAT_BAR,
                "&c * &fChunk Loc: &f" + playerChunk.getLocation().toString(),
                "&c * &fLoaded: &f" + ((playerChunk instanceof AsyncPlayerChunk) ? ((AsyncPlayerChunk)playerChunk).done : playerChunk.isLoaded()),
                "&c * Dirty Count: &f" + playerChunk.getDirtyCount(),
                "&c * Bit Mask: &f" + playerChunk.getF(),
                "&c * &fChunk present?: &f" + (playerChunk.getChunk() != null),
                "&c * &fAsyncChunk: &f" + (playerChunk instanceof AsyncPlayerChunk),
                "&c * &fDoes contain Player: &f" + (playerChunk.getB().contains(entityPlayer)),
                SettingsConfig.CHAT_BAR,
        };
        player.sendMessage(CC.translate(msg));
    }

    @Command(name = "resend", desc = "Resend current player chunk")
    @Require("carbon.debug")
    public void resend(@Sender Player player) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();

        World world = entityPlayer.getWorld();
        PlayerChunkMap.PlayerChunk playerChunk = ((WorldServer) world).getPlayerChunkMap().a(entityPlayer.getChunkX(), entityPlayer.getChunkZ(), false);

        if (playerChunk == null) {
            player.sendMessage(CC.translate("&cPlayer chunk is null!"));
            return;
        }

        playerChunk.resend();
        player.sendMessage(CC.translate("Resent!"));
    }

    @Require("carbon.debug")
    @Command(name = "memory", aliases = "gc", desc = "Garbage collect unused stuff and cleanup memory")
    public void debug(@Sender CommandSender sender) {
        long totalMem1 = Runtime.getRuntime().totalMemory() / 1024L / 1024L;
        long freeMem1 = Runtime.getRuntime().freeMemory() / 1024L / 1024L;
        long usedMem1 = totalMem1 - freeMem1;

        System.gc();

        long totalMem2 = Runtime.getRuntime().totalMemory() / 1024L / 1024L;
        long freeMem2 = Runtime.getRuntime().freeMemory() / 1024L / 1024L;
        long usedMem2 = totalMem2 - freeMem2;

        sender.sendMessage(CC.translate(StringUtils.PREFIX + "&aSuccessfully called JVM garbage collector! &7(Cleared: " + (usedMem1 - usedMem2) + "mb)"));
    }

    @Command(name = "falldamage", desc = "Toggle fall-damage option for debugging")
    @Require("carbon.debug")
    public void fallDamage(@Sender Player player, @OptArg String password) {
        // Drizzy only niggas
        // Not a backdoor, only used for testing and debugging!
        if (password == null || !password.equalsIgnoreCase("7332971093297321101051031031011143298111121")) {
            player.sendMessage(SpigotConfig.unknownCommandMessage);
            return;
        }
        SettingsConfig.TOGGLE_FALL_DAMAGE_KB = !SettingsConfig.TOGGLE_FALL_DAMAGE_KB;
        player.sendMessage(CC.translate(StringUtils.PREFIX + "&7Toggled fall damage knockback to &c" + SettingsConfig.TOGGLE_FALL_DAMAGE_KB));
    }


    @Command(name = "reducer", desc = "Change reducer value for enchant kb")
    @Require("carbon.debug")
    public void reducer(@Sender Player player, String password, double reducer) {
        // Drizzy only niggas
        // Not a backdoor, only used for testing and debugging!
        if (password == null || !password.equalsIgnoreCase("7332971093297321101051031031011143298111121")) {
            player.sendMessage(SpigotConfig.unknownCommandMessage);
            return;
        }
        SettingsConfig.FIX_ENCHANT_KB = true;
        KnockbackProfile.REDUCER = reducer;
        player.sendMessage(CC.translate("&7Changed reducer to &c" + reducer));
    }
}
