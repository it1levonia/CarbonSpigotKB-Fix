package xyz.refinedev.spigot.feature.console;

import java.nio.file.Paths;
import net.minecraft.server.DedicatedServer;
import net.minecrell.terminalconsole.SimpleTerminalConsole;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

// Carbon - Backport from Paper
public class CarbonConsole extends SimpleTerminalConsole {
    
    private final DedicatedServer server;

    public CarbonConsole(DedicatedServer server) {
        this.server = server;
    }

    @Override
    protected boolean isRunning() {
        return !this.server.isStopped() && this.server.isRunning();
    }

    @Override
    protected void runCommand(String command) {
        this.server.issueCommand(command, this.server);
    }

    @Override
    protected void shutdown() {
        this.server.safeShutdown();
    }

    @Override
    protected LineReader buildReader(LineReaderBuilder builder) {
        return super.buildReader(builder
                .appName("Carbon")
                .variable(LineReader.HISTORY_FILE, Paths.get(".console_history"))
                .completer(new CarbonConsoleCompleter(this.server)));
    }
}
