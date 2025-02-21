package fr.mitoto.vachettosplugin.configs;

import fr.mitoto.vachettosplugin.Main;
import fr.mitoto.vachettosplugin.models.StatisticProperty;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.*;

/**
 * Handles the loading and storage of player statistics properties from a YAML configuration file.
 */
public class StatisticsProperties {
    private static final ArrayList<StatisticProperty> statistics = new ArrayList<>();
    private static final Plugin plugin = Main.getPlugin();
    private static FileConfiguration config = null;

    /**
     * Loads the statistics configuration file and returns its {@link FileConfiguration} instance.
     * If the file does not exist, it is copied from the plugin's resources.
     *
     * @return The statistics file configuration.
     */
    private static FileConfiguration getFileConfiguration() {
        if (config != null)
            return config;

        File file = new File(plugin.getDataFolder(), Constants.STATISTICS_PROPERTY_PATH);
        if (!file.exists()) {
            plugin.saveResource(Constants.STATISTICS_PROPERTY_PATH, false);
        }

        config = YamlConfiguration.loadConfiguration(file);
        return config;
    }

    /**
     * Loads the statistics data from the configuration file into memory.
     * This method parses each statistic entry and converts it into a {@link StatisticProperty} object.
     */
    public static void loadData() {
        statistics.clear();
        FileConfiguration config = getFileConfiguration();
        Set<String> keys = Objects.requireNonNull(config.getConfigurationSection(Constants.STATISTICS_SECTION)).getKeys(false);

        for (String key : keys) {
            statistics.add(new StatisticProperty(
                    config.getString("statistics." + key + ".title"),
                    Material.valueOf(config.getString("statistics." + key + ".material")),
                    Statistic.valueOf(config.getString("statistics." + key + ".statistic"))
            ));
        }
    }

    /**
     * Retrieves the list of loaded statistics properties.
     *
     * @return A list of {@link StatisticProperty} objects.
     */
    public static ArrayList<StatisticProperty> getStatistics() {
        return statistics;
    }
}
