package xyz.refinedev.spigot.api.handlers;

import org.bukkit.plugin.java.JavaPlugin;
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

public interface IPacketAPI {

    /**
     * Register a {@link PacketHandler} to carbon
     *
     * @param packetHandler {@link PacketHandler instance}
     */
    void registerPacketHandler(JavaPlugin plugin, PacketHandler packetHandler);

    /**
     * Register a {@link MovementHandler} to carbon
     *
     * @param movementHandler {@link MovementHandler instance}
     */
    void registerMovementHandler(JavaPlugin plugin, MovementHandler movementHandler);
}
