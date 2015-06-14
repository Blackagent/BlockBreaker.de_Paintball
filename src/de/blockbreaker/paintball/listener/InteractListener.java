package de.blockbreaker.paintball.listener;

import de.blockbreaker.paintball.data.Config;
import de.blockbreaker.paintball.data.Data;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Janne on 14.06.2015.
 */
public class InteractListener implements Listener{

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player p = e.getPlayer();

            //von Spielern zu Zuschauern wechseln
            if(e.getMaterial().equals(Material.BLAZE_ROD)) {
                if(Data.players.size() > 4) {
                    Data.players.remove(p);
                    p.sendMessage(Data.Prefix + ChatColor.BLUE + "Du bist nun " + ChatColor.DARK_GRAY + "Zuschauer");
                }
            }

            //Von Zuschauern zu Spielern wechseln
            if(e.getMaterial().equals(Material.STICK)) {
                if(Data.players.size() < Config.cfg.getInt("maxPlayer")) {
                    Data.players.add(p);
                    p.sendMessage(Data.Prefix + ChatColor.BLUE + "Du bist nun " + ChatColor.YELLOW + "Spieler");
                }
            }
        }
    }
}
