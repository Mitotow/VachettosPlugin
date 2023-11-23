package fr.mitoto.vachettosplugin;

import fr.mitoto.vachettosplugin.commands.CraftCommand;
import fr.mitoto.vachettosplugin.commands.PlayersCommand;
import fr.mitoto.vachettosplugin.commands.StatsCommand;
import fr.mitoto.vachettosplugin.inventories.StatsInventory;
import fr.mitoto.vachettosplugin.listeners.PlayerListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private final PluginManager pm;
    private static Main plugin;

    public Main() {
        this.pm = this.getServer().getPluginManager();
        plugin = this;
    }

    @Override
    public void onEnable() {
        pm.registerEvents(new PlayerListener(), this);
        pm.registerEvents(new StatsInventory(), this);
        this.getCommand("players").setExecutor(new PlayersCommand());
        this.getCommand("stats").setExecutor(new StatsCommand());
        this.getCommand("craft").setExecutor(new CraftCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
