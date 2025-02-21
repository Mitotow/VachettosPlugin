package fr.mitoto.vachettosplugin.commands;

import fr.mitoto.vachettosplugin.configs.Messages;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CraftCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player player) {
            if(!player.getInventory().contains(Material.CRAFTING_TABLE)) {
                player.sendMessage(String.format(Messages.CANNOT_OPEN_CRAFTING_MENU));
            } else player.openWorkbench(null, true);
        }

        return true;
    }
}
