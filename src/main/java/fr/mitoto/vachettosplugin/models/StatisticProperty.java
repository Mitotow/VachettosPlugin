package fr.mitoto.vachettosplugin.models;


import org.bukkit.Material;
import org.bukkit.Statistic;

public class StatisticProperty {
    public String title;
    public Material material;
    public Statistic statistic;

    public StatisticProperty(String title, Material material, Statistic statistic) {
        this.title = title;
        this.material = material;
        this.statistic = statistic;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public Material getMaterial() {
        return material;
    }

    public String getTitle() {
        return title;
    }
}
