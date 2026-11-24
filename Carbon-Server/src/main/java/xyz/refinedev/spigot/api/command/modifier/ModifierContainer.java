package xyz.refinedev.spigot.api.command.modifier;

import lombok.Getter;
import xyz.refinedev.spigot.api.command.modifier.DrinkModifier;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Getter
public class ModifierContainer {

    private final ConcurrentMap<Class<?>, Set<xyz.refinedev.spigot.api.command.modifier.DrinkModifier<?>>> modifiers = new ConcurrentHashMap<>();

    public Set<DrinkModifier<?>> getModifiersFor(Class<?> type) {
        if (modifiers.containsKey(type)) {
            return modifiers.get(type);
        }
        for (Class<?> modifierType : modifiers.keySet()) {
            if (modifierType.isAssignableFrom(type) || type.isAssignableFrom(modifierType)) {
                return modifiers.get(modifierType);
            }
        }
        return null;
    }

}
