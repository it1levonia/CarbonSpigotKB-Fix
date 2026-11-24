package xyz.refinedev.spigot.api.command.modifier;

import xyz.refinedev.spigot.api.command.command.CommandExecution;
import xyz.refinedev.spigot.api.command.exception.CommandExitMessage;
import xyz.refinedev.spigot.api.command.parametric.CommandParameter;
import java.util.Optional;

public interface DrinkModifier<T> {

    Optional<T> modify(CommandExecution execution, CommandParameter commandParameter, T argument) throws CommandExitMessage;

}
