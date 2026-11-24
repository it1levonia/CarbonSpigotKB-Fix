package xyz.refinedev.spigot.utils.eventbusutil.modernversion;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import xyz.refinedev.spigot.utils.ClassUtils;
import xyz.refinedev.spigot.utils.eventbusutil.methods.ICaller;

import java.util.Arrays;

@RequiredArgsConstructor
public class ModernCallerImpl implements ICaller {

    @Getter
    private final MethodCaller function;
    private final boolean isStatic;

    @Override
    public Object call(Object... parameters) {
        if (isStatic) {
            return function.call(null, Arrays.copyOfRange(parameters, 1, parameters.length));
        } else {
            Object instance = parameters[0];
            return function.call(instance, Arrays.copyOfRange(parameters, 1, parameters.length));
        }
    }
}
