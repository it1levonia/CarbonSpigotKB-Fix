package xyz.refinedev.spigot.utils.eventbusutil.methods;

import java.lang.reflect.InvocationTargetException;

public interface ICaller {

    Object call(Object... parameters) throws InvocationTargetException, IllegalAccessException;
}
