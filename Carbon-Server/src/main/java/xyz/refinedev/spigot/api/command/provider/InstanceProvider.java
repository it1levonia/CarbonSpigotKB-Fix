package xyz.refinedev.spigot.api.command.provider;

import xyz.refinedev.spigot.api.command.parametric.DrinkProvider;
import xyz.refinedev.spigot.api.command.argument.CommandArg;
import xyz.refinedev.spigot.api.command.exception.CommandExitMessage;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;

public class InstanceProvider<T> extends DrinkProvider<T> {

    private final T instance;

    public InstanceProvider(T instance) {
        this.instance = instance;
    }

    @Override
    public boolean doesConsumeArgument() {
        return false;
    }

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public T provide(CommandArg arg, List<? extends Annotation> annotations) throws CommandExitMessage {
        return instance;
    }

    @Override
    public String argumentDescription() {
        return instance.getClass().getSimpleName() + " (provided)";
    }

    @Override
    public List<String> getSuggestions(String prefix) {
        return Collections.emptyList();
    }
}
