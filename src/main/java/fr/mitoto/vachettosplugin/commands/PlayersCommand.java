package fr.mitoto.vachettosplugin.commands;

import fr.mitoto.vachettosplugin.Main;
import fr.mitoto.vachettosplugin.configs.Messages;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collection;

public class PlayersCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        StringBuilder message = new StringBuilder(Messages.PLAYERS_TOP_MESSAGE).append("\n");
        Server server = Main.getPlugin().getServer();

        server.getOnlinePlayers()
                .forEach(player -> message.append(String
                            .format(Messages.PLAYERS_ONLINE_ENTRY_MESSAGE, player.getDisplayName()))
                        .append("\n"));

        sender.sendMessage(message.toString());
        return true;
    }
}
