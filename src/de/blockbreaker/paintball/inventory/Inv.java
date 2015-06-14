package de.blockbreaker.paintball.inventory;


import de.blockbreaker.paintball.data.GameState;
import org.bukkit.entity.Player;

/**
 * Created by Janne on 02.06.2015.
 */
public class Inv {

    public static void getStandartInventory(Player p) {
        if(GameState.isState(GameState.IN_LOBBY)) {
            Items.getSwitchItem(p);
        }

        if(GameState.isState(GameState.IN_GAME)) {

        }

        if(GameState.isState(GameState.POST_GAME)) {

        }
    }
}
