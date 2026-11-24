package xyz.refinedev.spigot.api.command.parametric;

import lombok.Getter;
import xyz.refinedev.spigot.api.command.parametric.DrinkBinding;

import java.util.HashSet;
import java.util.Set;

@Getter
public class BindingContainer<T> {

    private final Class<T> type;
    private final Set<DrinkBinding<T>> bindings;

    public BindingContainer(Class<T> type) {
        this.type = type;
        this.bindings = new HashSet<>();
    }

    public BindingContainer(Class<T> type, Set<DrinkBinding<T>> bindings) {
        this.type = type;
        this.bindings = bindings;
    }

}
