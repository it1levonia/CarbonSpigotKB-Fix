package xyz.refinedev.spigot.utils.eventbusutil;

import lombok.SneakyThrows;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.utils.eventbusutil.methods.CallerImpl;
import xyz.refinedev.spigot.utils.eventbusutil.methods.ICaller;
import xyz.refinedev.spigot.utils.eventbusutil.methods.MethodAccessManager;

import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

public class InvokerFactory {

    private static final InvokerFactory INSTANCE = new InvokerFactory();

    public static InvokerFactory getInstance() {
        return INSTANCE;
    }

    private final MethodAccessManager manager = new MethodAccessManager();

    public MethodAccessManager getManager() {
        return manager;
    }

    public ICaller convert(Method method, Object instance) {
        return manager.getMethod(method, instance);
    }
}
