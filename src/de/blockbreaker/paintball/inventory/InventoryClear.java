package de.blockbreaker.paintball.inventory;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

/**
 * Created by Lukas on 10.04.2015.
 */
public class InventoryClear {

    public static void clearInv(Player p) {
        p.getInventory().clear();
    }

    public static void removeBoots(Player p) {
        p.getInventory().setArmorContents(null);
    }

    public static void clearEffects(Player p) {
        p.getActivePotionEffects().clear();
    }

    public static void joinPlayer(Player p) {
        p.getActivePotionEffects().clear();
        p.getInventory().clear();
        p.getInventory().setHelmet(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setBoots(null);
        p.setLevel(0);
        p.setExp(0.0F);
        p.setAllowFlight(false);
        p.setFlying(false);
        p.setGameMode(GameMode.ADVENTURE);
        p.setHealth(20.0D);
        p.setFoodLevel(20);
        p.setFireTicks(0);
    }
}