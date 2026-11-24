package xyz.refinedev.spigot.api.handlers;

import com.google.common.base.Preconditions;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import org.bukkit.plugin.java.JavaPlugin;

import xyz.refinedev.spigot.CarbonSpigot;
import xyz.refinedev.spigot.api.handlers.impl.MovementHandler;
import xyz.refinedev.spigot.api.handlers.impl.PacketHandler;

/**
 * This Project is property of Refine Development.
 * Copyright © 2023, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 *
 * @author Drizzy
 * @since 9/10/2022
 * @version CarbonSpigot
 */

@Log4j2
public class PacketAPI implements IPacketAPI {

    /**
     * Static instance that ppl can use for their plugins
     */
    @Getter
    private static PacketAPI instance;
    /**
     * Carbon instance to get knockbackHandler
     */
    private final CarbonSpigot spigot;

    public PacketAPI(CarbonSpigot spigot) {
        PacketAPI.instance = this;
        this.spigot = spigot;
    }

    /**
     * Register a {@link PacketHandler} to carbon
     *
     * @param packetHandler {@link PacketHandler instance}
     */
    public void registerPacketHandler(JavaPlugin javaPlugin, PacketHandler packetHandler) {
       log.info("[Carbon] Registering a PacketHandler from " + javaPlugin.getName());
       this.spigot.registerPacketHandler(packetHandler);
    }

    /**
     * Remove a {@link PacketHandler} from carbon
     *
     * @param packetHandler {@link PacketHandler instance}
     */
    public void removePacketHandler(JavaPlugin javaPlugin, PacketHandler packetHandler) {
        log.info("[Carbon] Removing a PacketHandler from " + javaPlugin.getName());
        this.spigot.removePacketHandler(packetHandler);
    }


    /**
     * Register a {@link MovementHandler} to carbon
     *
     * @param movementHandler {@link MovementHandler instance}
     */
    public void registerMovementHandler(JavaPlugin javaPlugin, MovementHandler movementHandler) {
        log.info("[Carbon] Registering a MovementHandler from " + javaPlugin.getName());
        this.spigot.registerMovementHandler(movementHandler);
    }

    /**
     * Remove a {@link MovementHandler} from carbon
     *
     * @param movementHandler {@link MovementHandler instance}
     */
    public void removeMovementHandler(JavaPlugin javaPlugin, MovementHandler movementHandler) {
        log.info("[Carbon] Registering a MovementHandler from " + javaPlugin.getName());
        this.spigot.removeMovementHandler(movementHandler);
    }
}
