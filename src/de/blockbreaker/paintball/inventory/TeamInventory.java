package de.blockbreaker.paintball.inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/**
 * Created by Janne on 18.06.2015.
 */
public class TeamInventory {

    //Inventar der Teamauswahl:

    public static void open(Player p) {
        Inventory inv = null;

        inv = p.getServer().createInventory(null, 9, ChatColor.BLUE + "Teamauswahl");

        //Item für Team 1:
        ItemStack team1 = new ItemStack(Material.WOOL);//TODO: korrekte Farben
        ItemMeta meta1 = team1.getItemMeta();
        meta1.setDisplayName(ChatColor.GREEN + "Team 1 " + ChatColor.BLUE + "betreten");
        meta1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta1.addEnchant(Enchantment.DURABILITY, 1, true);
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add(ChatColor.BLUE + "Linksklick, um dem Team beizutreten");
        meta1.setLore(lore1);
        team1.setItemMeta(meta1);


        //Item für Team 2:
        ItemStack team2 = new ItemStack(Material.WOOL);//TODO richtigen Farben
        ItemMeta meta2 = team2.getItemMeta();
        meta2.setDisplayName(ChatColor.GOLD + "Team 2 " + ChatColor.BLUE + "betreten");
        meta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta2.addEnchant(Enchantment.DURABILITY, 1, true);
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add(ChatColor.BLUE + "Linksklick, um dem Team beizutreten");
        meta2.setLore(lore2);
        team2.setItemMeta(meta2);


        //Items ins Inventar einfügen:
        inv.setItem(2, team1);
        inv.setItem(6, team2);

        p.openInventory(inv);
        p.updateInventory(); //TODO: Listen der Teams, Wenn man auf die Bloöcke klickt joinen, aktualisieren und wenn joinbar Enchanten
    }
}
