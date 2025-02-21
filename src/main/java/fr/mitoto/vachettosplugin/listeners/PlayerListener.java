package fr.mitoto.vachettosplugin.listeners;

import fr.mitoto.vachettosplugin.configs.Messages;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage(String.format(Messages.ON_PLAYER_JOIN, e.getPlayer().getDisplayName()));
    }

    @EventHandler
    public void onPlayerLeft(PlayerQuitEvent e) {
        e.setQuitMessage(String.format(Messages.ON_PLAYER_LEFT, e.getPlayer().getDisplayName()));
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent e) {
        e.setLeaveMessage(String.format(Messages.ON_PLAYER_KICK, e.getPlayer().getDisplayName()));
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        e.setDeathMessage(String.format(Messages.ON_PLAYER_DEATH, e.getEntity().getDisplayName(), e.getEntity().getStatistic(Statistic.DEATHS)));
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String message = String.format(Messages.ON_PLAYER_MESSAGE, player.getDisplayName(), e.getMessage());
        e.setFormat(message);
    }
}
