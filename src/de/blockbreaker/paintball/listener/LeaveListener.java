package de.blockbreaker.paintball.listener;

import de.blockbreaker.paintball.Paintball;
import de.blockbreaker.paintball.data.Data;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Janne on 01.06.2015.
 */
public class LeaveListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        //LeaveMessage:
        Bukkit.broadcastMessage(Data.Prefix + ChatColor.RED + "<-- " + ChatColor.YELLOW + e.getPlayer().getName() + ChatColor.AQUA + " hat das Spiel " + ChatColor.RED + "verlassen");

        //Countdown canceln wenn zu wenig Spieler auf dem Server sind:
        if(Bukkit.getOnlinePlayers().size() < 4) {
            Bukkit.getOnlinePlayers().forEach(player -> player.setExp(0));
            Bukkit.getOnlinePlayers().forEach(player -> player.setLevel(1));
            Bukkit.getScheduler().cancelTask(Paintball.getInstance().countdownID);
        }

        //TODO: von listen removen
    }

}
