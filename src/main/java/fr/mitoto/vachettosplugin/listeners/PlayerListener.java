package fr.mitoto.vachettosplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage(ChatColor.BLUE + e.getPlayer().getDisplayName() + ChatColor.WHITE + " joined.");
    }

    @EventHandler
    public void onPlayerLeft(PlayerQuitEvent e) {
        e.setQuitMessage(ChatColor.RED + e.getPlayer().getDisplayName() + ChatColor.WHITE + " left.");
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent e) {
        e.setLeaveMessage(ChatColor.GOLD + e.getPlayer().getDisplayName() + ChatColor.WHITE + " kicked.");
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        e.setDeathMessage(ChatColor.BLACK + e.getEntity().getDisplayName() + ChatColor.WHITE + " died for the " + ChatColor.DARK_RED + e.getEntity().getStatistic(Statistic.DEATHS) + " time(s).");
    }
}
