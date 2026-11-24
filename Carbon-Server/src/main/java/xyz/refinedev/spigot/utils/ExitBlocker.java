package xyz.refinedev.spigot.utils;

import java.security.Permission;
import java.util.Date;

/**
 * This Project is property of Refine Development.
 * Copyright © 2023, All Rights Reserved.
 * Redistribution of this Project is not allowed.
 *
 * @author Drizzy
 * @since 8/13/2023
 * @version CarbonSpigot
 */
public class ExitBlocker extends SecurityManager {

    public static void activate() {
        System.setSecurityManager(new ExitBlocker());
    }

    @Override
    public void checkExit(int status) {
        System.out.println("Exiting with status code " + status);
        Thread.dumpStack();
    }

    @Override
    public void checkPermission(Permission perm) {
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
    }
}