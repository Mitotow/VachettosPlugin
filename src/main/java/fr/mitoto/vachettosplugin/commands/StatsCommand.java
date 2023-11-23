package fr.mitoto.vachettosplugin.commands;

import fr.mitoto.vachettosplugin.inventories.StatsInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player player) {
            player.openInventory(StatsInventory.createInventory(player));
            return true;
        }

        return false;
    }
}
