package xyz.refinedev.spigot.api.knockback.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * This Project is property of Refine Development.
 * Copyright © 2023, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 *
 * @author Drizzy
 * @since 9/4/2021
 * @version CarbonSpigot
 */

@Getter
@AllArgsConstructor
public class KnockbackValue<T> {

    private final String id, path, name, comment;
    private final int priority;
    private final Class<T> type;
    @Setter
    private T value;
}
