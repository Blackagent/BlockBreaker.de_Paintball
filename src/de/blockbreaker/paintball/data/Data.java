package de.blockbreaker.paintball.data;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Janne on 01.06.2015.
 */
public class Data {

    //Prefix:
    public static String Prefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "P" + ChatColor.GREEN + "a" + ChatColor.DARK_AQUA + "i" + ChatColor.DARK_GREEN + "n" + ChatColor.DARK_AQUA + "t" + ChatColor.GREEN + "b" + ChatColor.AQUA + "a" + ChatColor.DARK_GREEN +"l" + ChatColor.DARK_AQUA + "l" + ChatColor.DARK_GRAY + "] ";
    public static String BlockBreaker = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_GREEN + "by BlockBreaker.de" + ChatColor.DARK_GRAY + "]";
    public static int counter;
    public static List<Player> players;
}
