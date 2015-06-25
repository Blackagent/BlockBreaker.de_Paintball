package de.blockbreaker.paintball.inventory;


import de.blockbreaker.paintball.api.ColorAPI;
import de.blockbreaker.paintball.data.Data;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/**
 * Created by Janne on 02.06.2015.
 */
public class Items {

    public static void getSwitchItem(Player p) {
        //Wenn man ein Spieler ist:
        if(Data.players.contains(p)) {
            ItemStack switchItem = new ItemStack(Material.BLAZE_ROD);
            ItemMeta meta = switchItem.getItemMeta();

            meta.setDisplayName(ChatColor.RED + "Rechtsklick," + ChatColor.BLUE + " um zu den " + ChatColor.DARK_GRAY + "Zuschauern" + ChatColor.BLUE + "  zu wechseln");
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "Du bist " + ChatColor.YELLOW + "Spieler");
            meta.setLore(lore);
            //Enchantment adden, wenn man wechseln kann:
            if(Data.players.size() > 4) {
                meta.addEnchant(Enchantment.DURABILITY, 1, true);
            }
            switchItem.setItemMeta(meta);

            p.getInventory().setItem(8, switchItem);
        }

        //Wenn man Zuschauer ist:
        if(!Data.players.contains(p)) {
            ItemStack switchItem = new ItemStack(Material.STICK);
            ItemMeta meta = switchItem.getItemMeta();

            meta.setDisplayName(ChatColor.RED + "Rechtsklick," + ChatColor.BLUE + " um zu den " + ChatColor.YELLOW + "Spielern" + ChatColor.BLUE + " zu wechseln");
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Du bist " + ChatColor.DARK_GRAY + "Zuschauer");
            meta.setLore(lore);
            //Enchantment adden, wenn man wechseln kann:
            if(Data.players.size() < Data.maxPlayer) {
                meta.addEnchant(Enchantment.DURABILITY, 1, true);
            }
            switchItem.setItemMeta(meta);

            p.getInventory().setItem(8, switchItem);
        }
    }



    public static void getLeaveItem(Player p) {
        ItemStack leaveItem = new ItemStack(Material.EMERALD);
        ItemMeta meta = leaveItem.getItemMeta();

        meta.setDisplayName(ChatColor.RED + "Rechtsklick," + ChatColor.BLUE + " um wieder in die " + ChatColor.DARK_GREEN + "Lobby" + ChatColor.BLUE + "  zu springen");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Zuruück zur" + ChatColor.DARK_GREEN + "Lobby");
        meta.setLore(lore);

        leaveItem.setItemMeta(meta);

        p.getInventory().setItem(4, leaveItem);
    }



    public static void getTeamItem(Player p) {
        ItemStack teamItem = new ItemStack(Material.SNOW_BALL);
        ItemMeta meta = teamItem.getItemMeta();

        meta.setDisplayName(ChatColor.BLUE + "Teamauswahl");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        if(!Data.teamGreen.contains(p) && !Data.teamOrange.contains(p)) {
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
        }

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.BLUE + "Zuruück zur" + ChatColor.DARK_GREEN + "Lobby");
        meta.setLore(lore);

        teamItem.setItemMeta(meta);

        p.getInventory().setItem(0, teamItem);
    }

    public static void getTeamBoots(Player p) {
        if(Data.teamGreen.contains(p)) {
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta meta = boots.getItemMeta();
            ColorAPI.setColor(boots, Color.LIME);

            meta.setDisplayName(ChatColor.GREEN + "Teamboots");
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            boots.setItemMeta(meta);

            p.getInventory().setBoots(boots);
        }

        if(Data.teamOrange.contains(p)) {
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta meta = boots.getItemMeta();
            ColorAPI.setColor(boots, Color.ORANGE);

            meta.setDisplayName(ChatColor.GOLD + "Teamboots");
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            boots.setItemMeta(meta);

            p.getInventory().setBoots(boots);
        }
    }
}
