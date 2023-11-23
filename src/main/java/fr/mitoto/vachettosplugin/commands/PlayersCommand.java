package fr.mitoto.vachettosplugin.commands;

import fr.mitoto.vachettosplugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;

public class PlayersCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        StringBuilder message = new StringBuilder("Players List :\n");
        Collection<? extends Player> onlinePlayers = Main.getPlugin().getServer().getOnlinePlayers();
        OfflinePlayer[] offlinePlayers = Main.getPlugin().getServer().getOfflinePlayers();

        for(Player p : onlinePlayers)
            message.append(ChatColor.GREEN + "+ " + ChatColor.WHITE + p.getName()+"\n");
        for(OfflinePlayer p : offlinePlayers)
            if(!onlinePlayers.contains(p.getPlayer())) message.append(ChatColor.RED + "- " + ChatColor.WHITE + p.getName()+"\n");

        sender.sendMessage(message.toString());
        return true;
    }
}
