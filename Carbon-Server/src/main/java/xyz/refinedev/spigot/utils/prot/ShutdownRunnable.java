package xyz.refinedev.spigot.utils.prot;

import org.spigotmc.WatchdogThread;

public class ShutdownRunnable implements Runnable {
    @Override
    public void run() {
        WatchdogThread.stopServer();
    }
}
