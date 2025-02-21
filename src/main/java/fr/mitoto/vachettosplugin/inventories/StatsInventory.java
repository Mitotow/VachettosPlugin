package fr.mitoto.vachettosplugin.inventories;

import fr.mitoto.vachettosplugin.Main;
import fr.mitoto.vachettosplugin.configs.Constants;
import fr.mitoto.vachettosplugin.configs.StatisticsProperties;
import fr.mitoto.vachettosplugin.items.StatItem;
import fr.mitoto.vachettosplugin.models.StatisticProperty;
import fr.mitoto.vachettosplugin.utils.InventoryUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

/**
 * Handles the player's statistics inventory.
 * This inventory displays various statistics as interactive items.
 */
public class StatsInventory implements Listener {
    private static ItemStack borderItem = null;
    private static final HashMap<UUID, Inventory> inventories = new HashMap<>();

    /**
     * Creates a custom inventory to display the player's statistics.
     *
     * @param player The player for whom the inventory is generated.
     * @return The inventory containing the player's statistics.
     */
    public static Inventory createInventory(Player player) {
        ArrayList<StatisticProperty> statistics = StatisticsProperties.getStatistics();
        Inventory inventory = Bukkit.createInventory(null, 27, Constants.INVENTORY_TITLE);
        setBorder(inventory);

        statistics.forEach(s -> addStat(inventory, new StatItem(s.getMaterial(), s.getTitle(), player.getStatistic(s.getStatistic()))));

        inventories.put(player.getUniqueId(), inventory);
        return inventory;
    }

    /**
     * Adds a statistic item to the inventory.
     *
     * @param inventory The inventory where the statistic item will be added.
     * @param item      The statistic item to add.
     */
    private static void addStat(Inventory inventory, StatItem item) {
        int slot = InventoryUtils.getFirstEmptySlot(inventory);
        if (slot < 0) {
            Main.getPlugin().getLogger().warning("Cannot add statistic " + Objects.requireNonNull(item.getItemMeta()).getDisplayName() + ", too many statistic elements in the statistics menu");
            return;
        }

        inventory.setItem(slot, item);
    }

    /**
     * Retrieves the border item for the inventory.
     *
     * @return The border item.
     */
    private static ItemStack getItemBorder() {
        if (borderItem != null) return borderItem;

        borderItem = new ItemStack(Material.GREEN_STAINED_GLASS);
        ItemMeta meta = borderItem.getItemMeta();
        if (meta != null) meta.setDisplayName(ChatColor.MAGIC + "border");
        borderItem.setItemMeta(meta);

        return borderItem;
    }

    /**
     * Sets the border around the inventory using a predefined border item.
     *
     * @param inventory The inventory to set the border for.
     */
    private static void setBorder(Inventory inventory) {
        ItemStack item = getItemBorder();
        for (int i = 0; i < inventory.getSize(); i++) {
            if (i <= 8 || (i >= 18 && i <= 26) || i % 9 == 0 || (i + 1) % 9 == 0) {
                inventory.setItem(i, item);
            }
        }
    }

    /**
     * Prevents players from getting items from the statistics inventory.
     *
     * @param e The InventoryClickEvent.
     */
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player player) {
            Inventory inventory = e.getClickedInventory();
            if (inventory == null || !inventories.containsKey(player.getUniqueId()) || !inventories.get(player.getUniqueId()).equals(inventory))
                return;

            e.setCancelled(true);
        }
    }

    /**
     * Removes the inventory from memory when the player closes it.
     *
     * @param e The InventoryCloseEvent.
     */
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if (e.getPlayer() instanceof Player player) {
            inventories.remove(player.getUniqueId());
        }
    }
}
