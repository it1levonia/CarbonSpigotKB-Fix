package xyz.refinedev.spigot.cmds.binds;

import xyz.refinedev.spigot.api.command.argument.CommandArg;
import xyz.refinedev.spigot.api.command.exception.CommandExitMessage;
import xyz.refinedev.spigot.api.command.parametric.DrinkProvider;
import xyz.refinedev.spigot.CarbonSpigot;
import xyz.refinedev.spigot.knockback.KnockbackHandler;
import xyz.refinedev.spigot.knockback.KnockbackProfile;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This Project is property of Refine Development.
 * Copyright © 2023, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 *
 * @author Drizzy
 * @since 8/1/2023
 * @version CarbonSpigot
 */
public class KnockbackProfileProvider extends DrinkProvider<KnockbackProfile> {

    public KnockbackProfile provide(CommandArg commandArg, List<? extends Annotation> list) throws CommandExitMessage {
        KnockbackHandler knockbackHandler = CarbonSpigot.getInstance().getKnockbackHandler();
        String arg = commandArg.get();

        KnockbackProfile profile = knockbackHandler.getKnockbackProfile(arg);
        if (profile == null) {
            throw new CommandExitMessage("A knockback profile with that name does not exist!");
        }

        return profile;
    }

    public String argumentDescription() {
        return "knockback-profile";
    }

    public List<String> getSuggestions(String prefix) {
        KnockbackHandler knockbackHandler = CarbonSpigot.getInstance().getKnockbackHandler();
        return knockbackHandler.getProfiles()
                .stream()
                .map(KnockbackProfile::getName)
                .filter(s -> prefix.length() == 0 || s.startsWith(prefix))
                .collect(Collectors.toList());
    }

    public boolean doesConsumeArgument() {
        return true;
    }

    public boolean isAsync() {
        return true;
    }
}
