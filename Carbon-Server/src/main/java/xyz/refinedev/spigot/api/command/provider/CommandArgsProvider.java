package xyz.refinedev.spigot.api.command.provider;

import xyz.refinedev.spigot.api.command.parametric.DrinkProvider;
import xyz.refinedev.spigot.api.command.argument.CommandArg;
import xyz.refinedev.spigot.api.command.argument.CommandArgs;
import xyz.refinedev.spigot.api.command.exception.CommandExitMessage;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;

public class CommandArgsProvider extends DrinkProvider<CommandArgs> {

    public static final CommandArgsProvider INSTANCE = new CommandArgsProvider();

    @Override
    public boolean doesConsumeArgument() {
        return false;
    }

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public CommandArgs provide(CommandArg arg, List<? extends Annotation> annotations) throws CommandExitMessage {
        return arg.getArgs();
    }

    @Override
    public String argumentDescription() {
        return "args";
    }

    @Override
    public List<String> getSuggestions(String prefix) {
        return Collections.emptyList();
    }
}
