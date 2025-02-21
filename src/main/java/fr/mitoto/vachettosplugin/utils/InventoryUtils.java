package fr.mitoto.vachettosplugin.utils;

import org.bukkit.inventory.Inventory;

/**
 * Utility class for handling inventory-related operations.
 */
public class InventoryUtils {

    /**
     * Finds the first empty slot in the given inventory.
     *
     * @param inventory The inventory to search.
     * @return The index of the first empty slot, or -1 if no empty slots are available.
     */
    public static int getFirstEmptySlot(Inventory inventory) {
        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null)
                return i;
        }
        return -1;
    }
}
