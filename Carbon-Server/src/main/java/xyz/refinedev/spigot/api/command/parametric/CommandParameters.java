package xyz.refinedev.spigot.api.command.parametric;

import lombok.Getter;
import xyz.refinedev.spigot.api.command.parametric.CommandParameter;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Getter
public class CommandParameters {

    private final int count;
    private final xyz.refinedev.spigot.api.command.parametric.CommandParameter[] parameters;

    public CommandParameters(int count, xyz.refinedev.spigot.api.command.parametric.CommandParameter[] parameters) {
        this.count = count;
        this.parameters = parameters;
    }

    public CommandParameters(Method method) {
        xyz.refinedev.spigot.api.command.parametric.CommandParameter[] parameters = new xyz.refinedev.spigot.api.command.parametric.CommandParameter[method.getParameters().length];
        for (int i = 0; i < method.getParameters().length; i++) {
            Parameter param = method.getParameters()[i];
            parameters[i] = new xyz.refinedev.spigot.api.command.parametric.CommandParameter(param.getType(), param, method.getParameterAnnotations()[i]);
        }
        this.parameters = parameters;
        this.count = method.getParameterCount();
    }

    public boolean isLastArgument(int index) {
        if (index != parameters.length - 1) {
            for (int i = index + 1; i < parameters.length; i++) {
                CommandParameter parameter = parameters[i];
                if (!parameter.isFlag()) {
                    return false;
                }
            }
        }
        return true;
    }

}
