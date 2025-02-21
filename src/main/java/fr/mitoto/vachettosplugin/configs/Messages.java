package fr.mitoto.vachettosplugin.configs;

import org.bukkit.ChatColor;

public class Messages {
    // Global
    public static final String ON_PLUGIN_ENABLE = "VachettosPlugin is enable.";
    public static final String ON_PLUGIN_DISABLE = "VachettosPlugin is disable.";

    // PlayerListener
    public static final String ON_PLAYER_JOIN = ChatColor.GREEN + "%s" + ChatColor.WHITE + " joined.";
    public static final String ON_PLAYER_LEFT = ChatColor.RED + "%s" + ChatColor.WHITE + " left.";
    public static final String ON_PLAYER_KICK = ChatColor.GOLD + "%s" + ChatColor.WHITE + " kicked.";
    public static final String ON_PLAYER_DEATH = ChatColor.BLACK + "%s" + ChatColor.WHITE + " died for the " + ChatColor.DARK_RED + "%d" + " time(s).";
    public static final String ON_PLAYER_MESSAGE = ChatColor.LIGHT_PURPLE + "%s" + ChatColor.WHITE + " » %s";

    // Craft Command
    public static final String CANNOT_OPEN_CRAFTING_MENU = ChatColor.RED + "You cannot open crafting menu without a crafting table in your inventory.";

    // Players Command
    public static final String PLAYERS_TOP_MESSAGE = "Players List :";
    public static final String PLAYERS_ONLINE_ENTRY_MESSAGE = ChatColor.GREEN + "+ " + ChatColor.WHITE + "%s\n";
}
