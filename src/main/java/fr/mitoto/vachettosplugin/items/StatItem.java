package fr.mitoto.vachettosplugin.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

/**
 * Represents a custom item designed to display statistics in the StatsInventory.
 * This item extends {@link ItemStack} and is initialized with a specific material, title, and statistic.
 */
public class StatItem extends ItemStack {

    /**
     * Constructs a {@code StatItem} with the specified material, title, and statistic.
     *
     * The item's display name is set to the given title, and its description contains the string representation
     * of the provided {@link Statistic}.
     *
     * @param material  The {@link Material} of the item. Determines its appearance.
     * @param title     The display name of the item, visible in the inventory.
     * @param statistic The {@link Statistic} associated with this item, displayed in the description.
     */
    public StatItem(Material material, String title, int statistic) {
        super(material);

        ItemMeta itemMeta = getItemMeta();
        assert itemMeta != null;

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setDisplayName(ChatColor.YELLOW + title);
        itemMeta.setLore(Collections.singletonList(ChatColor.LIGHT_PURPLE + Integer.toString(statistic)));
        setItemMeta(itemMeta);
    }
}

