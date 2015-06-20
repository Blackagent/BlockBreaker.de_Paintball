package de.blockbreaker.paintball.inventory;


import de.blockbreaker.paintball.data.Data;
import de.blockbreaker.paintball.data.GameState;
import org.bukkit.entity.Player;

/**
 * Created by Janne on 02.06.2015.
 */
public class StandartInventory {

    public static void getStandardInventory(Player p) {

        p.getInventory().clear();

        //Wenn man Spieler ist
        if(Data.players.contains(p)) {
            if(GameState.isState(GameState.IN_LOBBY)) {
                Items.getLeaveItem(p);
                Items.getTeamItem(p);
                Items.getSwitchItem(p);
            }

            if(GameState.isState(GameState.IN_GAME)) {

            }

            if(GameState.isState(GameState.POST_GAME)) {

            }
        }


        //Wenn man Zuschauer ist:
        if(!Data.players.contains(p)) {
            if(GameState.isState(GameState.IN_LOBBY)) {
                Items.getLeaveItem(p);
                Items.getSwitchItem(p);
            }

            if(GameState.isState(GameState.IN_GAME)) {

            }

            if(GameState.isState(GameState.POST_GAME)) {

            }
        }
    }

    public static void refreshSwitchItem(Player p) {
        Items.getSwitchItem(p);
    }
}
