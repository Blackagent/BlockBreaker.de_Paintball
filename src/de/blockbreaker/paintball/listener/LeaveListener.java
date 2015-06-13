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
        //TODO: von listen removen
    }

}
