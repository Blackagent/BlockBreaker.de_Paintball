package de.blockbreaker.paintball.listener;

import de.blockbreaker.paintball.data.Config;
import de.blockbreaker.paintball.data.Data;
import de.blockbreaker.paintball.inventory.Inv;
import org.bukkit.Bukkit;
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
        Player p = e.getPlayer();

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {

            //von Spielern zu Zuschauern wechseln
            if(e.getMaterial().equals(Material.BLAZE_ROD)) {
                if(Data.players.size() > 4) {
                    Data.players.remove(p);
                    Bukkit.getOnlinePlayers().forEach(player -> Inv.getStandardInventory(player));
                    p.sendMessage(Data.Prefix + ChatColor.BLUE + "Du bist nun " + ChatColor.DARK_GRAY + "Zuschauer");
                } else {
                    p.sendMessage(Data.Prefix + ChatColor.BLUE + "Du kannst leider nicht wechseln, da es sonst " + ChatColor.DARK_BLUE + "zu wenig Spieler" + ChatColor.BLUE + " gibt!");
                }
            }

            //Von Zuschauern zu Spielern wechseln
            if(e.getMaterial().equals(Material.STICK)) {
                if(Data.players.size() < Config.cfg.getInt("maxPlayer")) {
                    Data.players.add(p);
                    Bukkit.getOnlinePlayers().forEach(player -> Inv.getStandardInventory(player));
                    p.sendMessage(Data.Prefix + ChatColor.BLUE + "Du bist nun " + ChatColor.YELLOW + "Spieler");
                }
                else {
                    p.sendMessage(Data.Prefix + ChatColor.BLUE + "Du kannst leider nicht wechseln, da schon " + ChatColor.DARK_BLUE + "alle Slots belegt " + ChatColor.BLUE + " sind!");
                }
            }

            //Mit dem Leave Item in die Lobby springen
            if(e.getMaterial().equals(Material.EMERALD)) {
                if(Data.players.contains(p)) {
                    Data.players.remove(p);
                }
                p.performCommand("l");
            }

            if(e.getMaterial().equals(Material.SNOW_BALL)) {
                e.setCancelled(true);

                //TODO: Virtuelles Inventar + Team Listen
            }
        }
    }
}
