package xyz.refinedev.spigot.cmds.impl.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.ChatPaginator;

import org.spigotmc.SpigotConfig;
import xyz.refinedev.spigot.api.command.annotation.*;
import xyz.refinedev.spigot.config.SettingsConfig;
import xyz.refinedev.spigot.utils.CC;
import xyz.refinedev.spigot.utils.Clickable;

@Register(name = "plugins", aliases = "pl")
@SuppressWarnings("unused")
public class PluginsCommand {

    @Require("carbon.plugins")
    @Command(name = "", usage = "[pageNumber]", aliases = "help", desc = "Gets a list of plugins running on the server")
    public void plugins(@Sender CommandSender sender, @OptArg("1") int pageNumber) {
        if (!SettingsConfig.PLUGIN_COMMAND_ENABLED)  {
            sender.sendMessage(SpigotConfig.unknownCommandMessage);
            return;
        }

        if (Bukkit.getPluginManager().getPlugins() == null) {
            sender.sendMessage(CC.translate("&cThis server isn't currently running any plugins!"));
            return;
        }

        if (SettingsConfig.DEFAULT_PLUGINS_COMMAND) {
            sender.sendMessage("Plugins " + this.getPluginList());
        } else {
            String list = this.getCustomList();

            // Pagination, hopefully works...
            ChatPaginator.ChatPage page = ChatPaginator.paginate(list, pageNumber);

            sender.sendMessage(SettingsConfig.CHAT_BAR);
            sender.sendMessage(CC.translate(SettingsConfig.THEME + "&lPlugins List" + (page.getTotalPages() > 1 ? " &7(" + page.getPageNumber() + " )" : "")));
            sender.sendMessage(" ");
            sender.sendMessage(CC.translate("&7&oThis server is currently running " + SettingsConfig.THEME + Bukkit.getPluginManager().getPlugins().length + " &7&oplugin(s)!"));
            sender.sendMessage(CC.translate(" "));


            for (String line : page.getLines()) {
                sender.sendMessage(line);
            }
            sender.sendMessage(CC.translate(" "));

            if (sender instanceof Player && page.getTotalPages() > 1) {
                Player player = (Player) sender;
                sender.sendMessage("");
                Clickable clickable;
                if (pageNumber == page.getTotalPages()) {
                    clickable = new Clickable("&7 * &c[Previous Page]", "&7Click here to view previous page", "/plugins " + (pageNumber - 1));
                } else if (pageNumber > 1) {
                    clickable = new Clickable("&7 * &c[Previous Page]", "&7Click here to view previous page", "/plugins " + (pageNumber - 1));
                    clickable.add(" &a[Next Page]", "&7Click here to view next page", "/plugins " + (pageNumber + 1));
                } else {
                    clickable = new Clickable("&7 * &a[Next Page]", "&7Click here to view next page", "/plugins " + (pageNumber + 1));
                }
                clickable.sendToPlayer(player);
            }

            sender.sendMessage(SettingsConfig.CHAT_BAR);
        }
    }

    /**
     * Gives the plugin list in one string
     *
     * @return {@link String plugins}
     */
    private String getPluginList() {
        StringBuilder list = new StringBuilder();

        for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            if (list.length() > 0) {
                list.append(ChatColor.WHITE);
                list.append(", ");
            }
            list.append(plugin.isEnabled() ? ChatColor.GREEN : ChatColor.RED).append(plugin.getName());
        }

        return "(" +  Bukkit.getPluginManager().getPlugins().length + "): " + list;
    }

    /**
     * Gives the plugin list in one string
     *
     * @return {@link String plugins}
     */
    private String getCustomList() {
        StringBuilder list = new StringBuilder();
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            if (list.length() > 0) {
                list.append("\n");
            }
            list.append(ChatColor.GRAY).append(" * ")
                    .append(plugin.isEnabled() ? ChatColor.GREEN : ChatColor.RED)
                    .append(plugin.getName()).append(ChatColor.DARK_GRAY)
                    .append(" [").append(ChatColor.GRAY)
                    .append(plugin.getDescription().getVersion())
                    .append(ChatColor.DARK_GRAY)
                    .append("]");
        }
        return list.toString();
    }
}

