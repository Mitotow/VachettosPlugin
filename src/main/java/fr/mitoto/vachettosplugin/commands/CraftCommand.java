package fr.mitoto.vachettosplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.CraftingInventory;

public class CraftCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player player) {
            if(!player.getInventory().contains(Material.CRAFTING_TABLE)) {
                player.sendMessage(ChatColor.RED + "You cannot open crafting menu without a crafting table in your inventory.");
            } else player.openWorkbench(null, true);
        }

        return true;
    }
}
