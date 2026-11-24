package xyz.refinedev.spigot.api.command.provider.spigot;

import org.bukkit.command.CommandSender;
import xyz.refinedev.spigot.api.command.parametric.DrinkProvider;
import xyz.refinedev.spigot.api.command.argument.CommandArg;
import xyz.refinedev.spigot.api.command.exception.CommandExitMessage;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;

public class CommandSenderProvider extends DrinkProvider<CommandSender> {

    public static final CommandSenderProvider INSTANCE = new CommandSenderProvider();

    @Override
    public boolean doesConsumeArgument() {
        return false;
    }

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public boolean allowNullArgument() {
        return true;
    }

    @Override
    public CommandSender defaultNullValue() {
        return null;
    }

    @Override
    public CommandSender provide(CommandArg arg, List<? extends Annotation> annotations) throws CommandExitMessage {
        return arg.getSender();
    }

    @Override
    public String argumentDescription() {
        return "sender";
    }

    @Override
    public List<String> getSuggestions(String prefix) {
        return Collections.emptyList();
    }
}
