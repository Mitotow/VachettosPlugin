package fr.mitoto.vachettosplugin;

import fr.mitoto.vachettosplugin.commands.CraftCommand;
import fr.mitoto.vachettosplugin.commands.PlayersCommand;
import fr.mitoto.vachettosplugin.commands.StatsCommand;
import fr.mitoto.vachettosplugin.configs.Messages;
import fr.mitoto.vachettosplugin.configs.StatisticsProperties;
import fr.mitoto.vachettosplugin.inventories.StatsInventory;
import fr.mitoto.vachettosplugin.listeners.PlayerListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

/**
 * Main class of the VachettosPlugin.
 * Handles plugin initialization, command registration, and event listeners.
 */
public final class Main extends JavaPlugin {

    private final PluginManager pm;
    private static Main plugin;
    private static Logger logger;

    /** Initializes the plugin instance and retrieves the plugin manager. */
    public Main() {
        logger = getLogger();
        this.pm = this.getServer().getPluginManager();
        plugin = this;
    }

    /**
     * Called when the plugin is enabled.
     * Loads statistics data, registers commands and event listeners.
     */
    @Override
    public void onEnable() {
        StatisticsProperties.loadData();
        loadCommands();
        registerEvents();

        logger.info(Messages.ON_PLUGIN_ENABLE);
    }

    /**
     * Called when the plugin is disabled.
     * Logs the shutdown message.
     */
    @Override
    public void onDisable() {
        logger.info(Messages.ON_PLUGIN_DISABLE);
    }

    /** Registers all plugin commands and assigns their executors. */
    private void loadCommands() {
        Objects.requireNonNull(getCommand("players")).setExecutor(new PlayersCommand());
        Objects.requireNonNull(getCommand("stats")).setExecutor(new StatsCommand());
        Objects.requireNonNull(getCommand("craft")).setExecutor(new CraftCommand());
    }

    /** Registers all event listeners for the plugin. */
    private void registerEvents() {
        pm.registerEvents(new PlayerListener(), this);
        pm.registerEvents(new StatsInventory(), this);
    }

    /**
     * Retrieves the main plugin instance.
     *
     * @return The main plugin instance.
     */
    public static Plugin getPlugin() {
        return plugin;
    }
}
