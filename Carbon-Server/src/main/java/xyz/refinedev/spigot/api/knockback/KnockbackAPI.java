package xyz.refinedev.spigot.api.knockback;

import lombok.Getter;

import org.bukkit.entity.Player;

import org.jetbrains.annotations.Nullable;
import xyz.refinedev.spigot.CarbonSpigot;
import xyz.refinedev.spigot.api.knockback.meta.KnockbackValue;
import xyz.refinedev.spigot.knockback.KnockbackProfile;

import java.util.Collection;

/**
 * This Project is property of Refine Development © 2021
 * Redistribution of this Project is not allowed
 *
 * @author Drizzy
 * @since 9/6/2021
 * @version CarbonSpigot
 */

@SuppressWarnings({"unchecked", "unused"})
public class KnockbackAPI implements IKnockbackAPI {

    /**
     * Static instance that people can use for their plugins
     */
    @Getter private static KnockbackAPI instance;
    /**
     * Carbon instance to get knockbackHandler
     */
    private final CarbonSpigot spigot;

    public KnockbackAPI(CarbonSpigot spigot) {
        KnockbackAPI.instance = this;
        this.spigot = spigot;
    }

    /**
     * Register a custom created knockback profile.
     * Which you can create by extending the KnockbackProfile class
     *
     * @param knockback {@link KnockbackProfile profile}
     */
    public void registerKnockbackProfile(KnockbackProfile knockback) {
        this.spigot.getKnockbackHandler().addKnockbackProfile(knockback);
    }

    /**
     * Delete a knockback profile via name.
     *
     * @param name {@link String profile name}
     */
    public void deleteKnockbackProfile(String name) {
        this.spigot.getKnockbackHandler().removeKnockbackProfile(name);
    }

    /**
     * Get the default knockback profile
     *
     * @return {@link KnockbackProfile profile}
     */
    public KnockbackProfile getDefaultProfile() {
        return this.spigot.getKnockbackHandler().getDefaultKnockback();
    }

    /**
     * Set the default knockback profile
     *
     * @param name {@link String name of default profile}
     */
    public void setDefaultProfile(String name) {
        this.spigot.getKnockbackHandler().setDefaultKnockback(name);
    }

    public KnockbackProfile getPlayerProfile(Player player) {
        return (KnockbackProfile) player.carbon().getKnockbackProfile();
    }

    /**
     * Set a player's profile indirectly
     */
    public void setPlayerProfile(Player player, String name) {
        player.carbon().setKnockbackProfile(this.getProfile(name));
    }

    /**
     * Set a player's profile directly
     */
    public void setPlayerProfile(Player player, KnockbackProfile knockbackProfile) {
        player.carbon().setKnockbackProfile(knockbackProfile);
    }

    /**
     * Get a knockback profile by name
     *
     * @param name {@link String name}
     * @return {@link KnockbackProfile profile}
     */
    public KnockbackProfile getProfile(String name) {
        KnockbackProfile profile = this.spigot.getKnockbackHandler().getKnockbackProfile(name);
        return profile == null ? this.getDefaultProfile() : profile;
    }

    /**
     * Get all KnockbackValues of a {@link KnockbackProfile} of carbon
     *
     * @param profile {@link KnockbackProfile profile}
     * @return        {@link Collection<KnockbackValue> values}
     */
    public Collection<KnockbackValue<?>> getKnockbackValues(KnockbackProfile profile) {
        return profile.getProfileValues();
    }

    /**
     * Get all KnockbackValues of a {@link KnockbackProfile} of carbon
     *
     * @param profile {@link KnockbackProfile profile}
     * @return        {@link Collection<KnockbackValue> values}
     */
    public Collection<KnockbackValue<?>> getProjectileValues(KnockbackProfile profile) {
        return profile.getProjectileValues();
    }

    /**
     * Get all KnockbackValues of a {@link KnockbackProfile} of carbon
     *
     * @param profile {@link KnockbackProfile profile}
     * @return        {@link Collection<KnockbackValue> values}
     */
    public Collection<KnockbackValue<?>> getDamageValues(KnockbackProfile profile) {
        return profile.getDamageTickValues();
    }

    /**
     * Get all registered/loaded profiles of carbon
     *
     * @return {@link Collection<KnockbackProfile> profiles}
     */
    public Collection<KnockbackProfile> getProfiles() {
        return this.spigot.getKnockbackHandler().getProfiles();
    }

    /**
     * Get a Boolean {@link KnockbackValue value} from {@link KnockbackProfile profile}
     * matching the specified {@link String ID}
     *
     * @param profile {@link KnockbackProfile profile}
     * @param id      {@link String ID}
     * @return        {@link KnockbackValue}
     */
    @Nullable
    public KnockbackValue<Boolean> getBooleanValue(KnockbackProfile profile, String id) {
        for ( KnockbackValue<?> value : profile.getValues() ) {
            if (value.getValue() instanceof Boolean && value.getId().equalsIgnoreCase(id)) {
                return (KnockbackValue<Boolean>) value;
            }
        }
        return null;
    }

    /**
     * Get a Double {@link KnockbackValue value} from {@link KnockbackProfile profile}
     * matching the specified {@link String ID}
     *
     * @param profile {@link KnockbackProfile profile}
     * @param id      {@link String ID}
     * @return        {@link KnockbackValue}
     */
    @Nullable
    public KnockbackValue<Double> getDoubleValue(KnockbackProfile profile, String id) {
        for ( KnockbackValue<?> value : profile.getValues() ) {
            if (value.getValue() instanceof Double && value.getId().equalsIgnoreCase(id)) {
                return (KnockbackValue<Double>) value;
            }
        }
        return null;
    }

    /**
     * Get an Integer {@link KnockbackValue value} from {@link KnockbackProfile profile}
     * matching the specified {@link String ID}
     *
     * @param profile {@link KnockbackProfile profile}
     * @param id      {@link String ID}
     * @return        {@link KnockbackValue}
     */
    @Nullable
    public KnockbackValue<Integer> getIntegerValue(KnockbackProfile profile, String id) {
        for ( KnockbackValue<?> value : profile.getValues() ) {
            if (value.getValue() instanceof Integer && value.getId().equalsIgnoreCase(id)) {
                return (KnockbackValue<Integer>) value;
            }
        }
        return null;
    }

    /**
     * Get a Float {@link KnockbackValue value} from {@link KnockbackProfile profile}
     * matching the specified {@link String ID}
     *
     * @param profile {@link KnockbackProfile profile}
     * @param id      {@link String ID}
     * @return        {@link KnockbackValue}
     */
    @Nullable
    public KnockbackValue<Float> getFloatValue(KnockbackProfile profile, String id) {
        for ( KnockbackValue<?> value : profile.getValues() ) {
            if (value.getValue() instanceof Float && value.getId().equalsIgnoreCase(id)) {
                return (KnockbackValue<Float>) value;
            }
        }
        return null;
    }
}
