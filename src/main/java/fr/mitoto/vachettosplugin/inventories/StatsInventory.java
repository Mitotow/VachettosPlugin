package fr.mitoto.vachettosplugin.inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class StatsInventory implements Listener {
    final static String INV_TITLE = "Player Skills";

    public static Inventory createInventory(Player player) {
        final int DEATHS = player.getStatistic(Statistic.DEATHS);
        final int PLAYER_KILLS = player.getStatistic(Statistic.PLAYER_KILLS);
        final int MOB_KILLS = player.getStatistic(Statistic.MOB_KILLS);
        final int DAMAGE_ABSORBED = player.getStatistic(Statistic.DAMAGE_ABSORBED);
        final int TRADED_WITH_VILLAGER = player.getStatistic(Statistic.TRADED_WITH_VILLAGER);
        final int RAID_TRIGGER = player.getStatistic(Statistic.RAID_TRIGGER);
        final int RAID_WIN = player.getStatistic(Statistic.RAID_WIN);

        Inventory inventory = Bukkit.createInventory(null, 27, INV_TITLE);
        setBorder(inventory);

        inventory.setItem(10, createStatItem(Material.PLAYER_HEAD, "Players Killed", PLAYER_KILLS));
        inventory.setItem(11, createStatItem(Material.ZOMBIE_HEAD, "Mobs Killed", MOB_KILLS));
        inventory.setItem(12, createStatItem(Material.SKELETON_SKULL, "Deaths", DEATHS));
        inventory.setItem(13, createStatItem(Material.NETHERITE_CHESTPLATE, "Damage Absorbed", DAMAGE_ABSORBED));
        inventory.setItem(14, createStatItem(Material.EMERALD, "Trades With Villager", TRADED_WITH_VILLAGER));
        inventory.setItem(15, createStatItem(Material.TOTEM_OF_UNDYING, "Raid Won", RAID_WIN));
        inventory.setItem(16, createStatItem(Material.BELL, "Raid Triggered", RAID_TRIGGER));

        return inventory;
    }

    private static void setBorder(Inventory inventory) {
        ItemStack borderItem = new ItemStack(Material.GREEN_STAINED_GLASS);
        ItemMeta meta = borderItem.getItemMeta();
        if(meta != null) meta.setDisplayName(ChatColor.MAGIC + "border");
        borderItem.setItemMeta(meta);
        for(int i = 0; i<inventory.getSize(); i++)
            if(i <= 8 || (i >= 18 && i <= 26) || i % 9 == 0 || (i + 1) % 9 == 0)
                inventory.setItem(i, borderItem);
    }

    private static ItemStack createStatItem(Material material, String title, int stat) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if(meta == null) return item;
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setDisplayName(ChatColor.YELLOW + title);
        meta.setLore(Collections.singletonList(ChatColor.LIGHT_PURPLE + Integer.toString(stat)));
        item.setItemMeta(meta);
        return item;
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if(!e.getView().getTitle().equals(INV_TITLE)) return;
        e.setCancelled(true);
        e.getWhoClicked().closeInventory(); // Solution to avoid exploit (spamming item and press [ECHAP] to get the item in player's inventory)
    }

}
