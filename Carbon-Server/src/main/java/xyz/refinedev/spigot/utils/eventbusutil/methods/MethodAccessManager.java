package xyz.refinedev.spigot.utils.eventbusutil.methods;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import net.minecraft.server.SystemUtils;
import xyz.refinedev.spigot.utils.eventbusutil.modernversion.MethodCaller;
import xyz.refinedev.spigot.utils.eventbusutil.modernversion.MethodCallerFactory;
import xyz.refinedev.spigot.utils.eventbusutil.modernversion.ModernCallerImpl;
import xyz.refinedev.spigot.utils.eventbusutil.util.UnsafeAccessor;
import xyz.refinedev.spigot.utils.eventbusutil.writer.MethodAccessWriter;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

@Log4j2
public class MethodAccessManager {
    private static final boolean MODERN_JAVA = SystemUtils.getVersion() >= 15;

    private final Map<Method, Function> methodAccess = new LinkedHashMap<>();
    private final Map<Method, MethodCaller> jdk17cache = new LinkedHashMap<>();

    @SneakyThrows
    public ICaller getMethod(Method method, Object instance) {
        if (!MODERN_JAVA) {
            Function function = methodAccess.get(method);
            if (function == null) {
                function = UnsafeAccessor.allocate((Class<? extends Function>) UnsafeAccessor.defineAnonymous(method.getDeclaringClass(), new MethodAccessWriter(method).toByteArray()));
                methodAccess.put(method, function);
            }
            return new CallerImpl(function);
        }

        MethodCaller caller = jdk17cache.get(method);
        if (caller == null) {
            caller = MethodCallerFactory.createFor(method);
            jdk17cache.put(method, caller);

        }

        return new ModernCallerImpl(caller, Modifier.isStatic(method.getModifiers()));

    }
}
