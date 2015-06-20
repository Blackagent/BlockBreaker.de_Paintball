package de.blockbreaker.paintball.listener;

import de.blockbreaker.paintball.data.Data;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Janne on 01.06.2015.
 */
public class LeaveListener implements Listener{

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        e.setQuitMessage(null);

        Bukkit.broadcastMessage(Data.Prefix + ChatColor.RED + "<-- " + ChatColor.YELLOW + e.getPlayer().getName() + ChatColor.AQUA + " hat das Spiel " + ChatColor.RED + "verlassen");
        if(Data.players.contains(e.getPlayer())) {
            Data.players.remove(e.getPlayer());
            if(Data.teamGreen.contains(e.getPlayer())) {
                Data.teamGreen.remove(e.getPlayer());
            }
            if(Data.teamOrange.contains(e.getPlayer())) {
                Data.teamOrange.remove(e.getPlayer());
            }
        }
    }

}
