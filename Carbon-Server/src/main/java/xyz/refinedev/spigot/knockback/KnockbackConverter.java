package xyz.refinedev.spigot.knockback;

import lombok.extern.log4j.Log4j2;
import org.bukkit.command.CommandSender;
import org.simpleyaml.configuration.ConfigurationSection;
import org.simpleyaml.configuration.file.YamlFile;
import xyz.refinedev.spigot.CarbonSpigot;
import xyz.refinedev.spigot.api.knockback.meta.KnockbackType;
import xyz.refinedev.spigot.api.knockback.meta.KnockbackValue;
import xyz.refinedev.spigot.knockback.impl.DetailedKnockbackProfile;
import xyz.refinedev.spigot.knockback.impl.EasyKnockbackProfile;
import xyz.refinedev.spigot.knockback.impl.ExpertKnockbackProfile;
import xyz.refinedev.spigot.knockback.impl.SmoothKnockbackProfile;
import xyz.refinedev.spigot.utils.CC;

import java.io.File;

/**
 * This Project is property of Refine Development.
 * Copyright © 2023, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 *
 * @author Drizzy
 * @version CarbonSpigot
 * @since 7/12/2022
 */

@Log4j2
public final class KnockbackConverter {

    /**
     * Migrate old config manually
     *
     * @param name {@link String file name}
     */
    public void migrate(CommandSender sender, String name) {
        File file = new File(name);

        if (!file.exists()) {
            sender.sendMessage(CC.translate("&c&l[Carbon] &fFile does not exist!"));
            return;
        } else {
            sender.sendMessage(CC.translate("&c&l[Carbon] &fImporting..."));
        }

        YamlFile configuration;
        try {
            configuration = new YamlFile(file);
            configuration.load();
        } catch (Exception e) {
            sender.sendMessage(CC.translate("&c&l[Carbon] &fUnable to load as a config, please check for syntax errors!"));
            return;
        }

        this.convertOld(configuration, file);
    }

    /**
     * This converts previous gay configs into the new sexy ones
     *
     * @param config {@link YamlFile kb config}
     */
    public void convertOld(YamlFile config, File file) {
        KnockbackHandler instance = CarbonSpigot.getInstance().getKnockbackHandler();
        ConfigurationSection section = config.getConfigurationSection("profiles");
        if (section == null || section.getKeys(false).isEmpty()) return;

        int converted = 0;

        for (String key : section.getKeys(false)) {
            KnockbackType type;
            try {
                type = KnockbackType.valueOf(section.getString(key + ".type"));
            } catch (Exception e) {
                log.error("[Carbon] Failed to load " + key + " because the type is invalid!");
                log.error("[Carbon] Check for syntax errors.");
                continue;
            }

            KnockbackProfile knockback;

            switch (type) {
                case SMOOTH: {
                    knockback = new SmoothKnockbackProfile(key.toLowerCase());
                    break;
                }
                case EXPERT: {
                    knockback = new ExpertKnockbackProfile(key.toLowerCase());
                    break;
                }
                case DETAILED: {
                    knockback = new DetailedKnockbackProfile(key.toLowerCase());
                    break;
                }
                case EASY: {
                    knockback = new EasyKnockbackProfile(key.toLowerCase());
                    break;
                }
                default: {
                    log.info("[Carbon] You cannot import the knockback profile '" + key.toLowerCase() + "' because it's type is invalid!");
                    continue;
                }
            }

            knockback.loadValues(); // Load values first
            String path = "profiles." + key + ".";

            for (KnockbackValue value : knockback.getValues()) {
                if (!config.contains(path + value.getId())) {
                    config.set(path + value.getPath(), value.getValue());
                    continue;
                }

                if (value.getValue() instanceof Integer) {
                    int val = config.getInt(path + value.getId());
                    value.setValue(val);
                } else if (value.getValue() instanceof Double) {
                    double val = config.getDouble(path + value.getId());
                    value.setValue(val);
                } else if (value.getValue() instanceof Boolean) {
                    boolean val = config.getBoolean(path + value.getId());
                    value.setValue(val);
                }
            }
            instance.addKnockbackProfile(knockback);
            knockback.save(instance.getConfig(), "PROFILES." + key.toUpperCase() + ".");
            converted++;
        }

        instance.createDefaultKnockback();
        instance.save();

        file.delete();

        log.info("[Carbon] Successfully loaded knockback profiles from old config! (" + converted + ")");
    }
}
