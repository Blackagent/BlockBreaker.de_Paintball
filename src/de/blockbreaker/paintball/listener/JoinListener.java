package de.blockbreaker.paintball.listener;

import de.blockbreaker.paintball.Paintball;
import de.blockbreaker.paintball.data.Countdown;
import de.blockbreaker.paintball.data.Data;
import de.blockbreaker.paintball.data.GameState;
import de.blockbreaker.paintball.inventory.StandartInventory;
import de.blockbreaker.paintball.inventory.InventoryClear;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Created by Janne on 01.06.2015.
 */
public class JoinListener implements Listener {

    private Paintball plugin;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        e.setJoinMessage(null);
        Player p = e.getPlayer();
        InventoryClear.joinPlayer(p);

        //In der Lobby:
        if(GameState.isState(GameState.IN_LOBBY)) {
            Bukkit.broadcastMessage(Data.Prefix + ChatColor.GREEN + "--> " + ChatColor.YELLOW + e.getPlayer().getName() + ChatColor.AQUA + " hat das Spiel " + ChatColor.GREEN + "betreten");
            if(Bukkit.getOnlinePlayers().size() < 4) {
                Bukkit.broadcastMessage(Data.Prefix + ChatColor.DARK_AQUA + "Es wird auf " + ChatColor.GREEN + "weitere Spieler " + ChatColor.DARK_AQUA + "gewartet");
            }
            if(Bukkit.getOnlinePlayers().size() == 4) {
                Data.counter = 60;
                Countdown.startCountdown();
            }

            //zu Spielern adden, wenn noch Platz ist:
            if(Data.players.size() < Data.maxPlayer) {
                Data.players.add(e.getPlayer());
            }
            StandartInventory.getStandardInventory(p);
            Bukkit.getOnlinePlayers().forEach(player -> StandartInventory.refreshSwitchItem(player));
        }

        //Im Spiel:
        if(GameState.isState(GameState.IN_GAME)) {
            //nix als spec zum spec spawn tpen
        }
    }

    @EventHandler
    public void onConnect(PlayerLoginEvent e) {
        if(GameState.isState(GameState.POST_GAME)) {
            e.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.AQUA + "Die Runde ist vorbei!");
        }
    }
}
