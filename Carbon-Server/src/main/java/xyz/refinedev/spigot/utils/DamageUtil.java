package xyz.refinedev.spigot.utils;

import lombok.experimental.UtilityClass;
import net.minecraft.server.DamageSource;
import net.minecraft.server.EntityDamageSource;
import net.minecraft.server.EntityDamageSourceIndirect;
import net.minecraft.server.EntityPlayer;
import org.bukkit.entity.Player;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2024, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * @author Drizzy
 * @version CarbonSpigot
 * @since 2/14/2024
 */

@UtilityClass
public class DamageUtil {

    public boolean isPlayerAttack(DamageSource damageSource) {
        if (damageSource == null) return false;
        if (!(damageSource instanceof EntityDamageSource)) return false;
        if (damageSource instanceof EntityDamageSourceIndirect) return false;

        EntityDamageSource entityDamageSource = (EntityDamageSource) damageSource;
        if (entityDamageSource.p().contains("explosion")) return false;

        return entityDamageSource.getEntity() instanceof EntityPlayer;
    }

}
