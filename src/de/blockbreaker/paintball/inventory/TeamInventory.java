package de.blockbreaker.paintball.inventory;

import de.blockbreaker.paintball.Paintball;
import de.blockbreaker.paintball.data.Data;
import org.bukkit.Bukkit;
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
        ItemStack team1 = new ItemStack(Material.WOOL, 1,(short) 5);
        ItemMeta meta1 = team1.getItemMeta();
        meta1.setDisplayName(ChatColor.GREEN + "Team 1");
        meta1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        if(Data.teamGreen.size() < Data.maxPlayer/2) {
            meta1.addEnchant(Enchantment.DURABILITY, 1, true);
        }

        //Lore mit allen Spielern in dem Team und ob man beitreten kann:
        ArrayList<String> lore1 = new ArrayList<>();
        if(Data.teamGreen.contains(p)) {
            lore1.add(ChatColor.GREEN + "Dein Team:");
        } else {
            lore1.add(ChatColor.BLUE + "Linksklick, um " + ChatColor.GREEN + "Team 1 " + ChatColor.BLUE + "zu betreten");
        }
        for (int i = 0; i < Data.teamGreen.size(); i++) {
            lore1.add(ChatColor.YELLOW + Data.teamGreen.get(i).getDisplayName());
        }

        meta1.setLore(lore1);
        team1.setItemMeta(meta1);


        //Item für Team 2:
        ItemStack team2 = new ItemStack(Material.WOOL, 1,(short) 1);
        ItemMeta meta2 = team2.getItemMeta();
        meta2.setDisplayName(ChatColor.GOLD + "Team 2");
        meta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        if(Data.teamOrange.size() < Data.maxPlayer/2) {
            meta2.addEnchant(Enchantment.DURABILITY, 1, true);//TODO: teams nich grün 1000000 orange 1
        }

        ArrayList<String> lore2 = new ArrayList<>();
        if(Data.teamOrange.contains(p)) {
            lore2.add(ChatColor.GOLD + "Dein Team:");
        } else {
            lore2.add(ChatColor.BLUE + "Linksklick, um " + ChatColor.GOLD + "Team 2 " + ChatColor.BLUE + "zu betreten");
        }
        for (int i = 0; i < Data.teamOrange.size(); i++) {
            lore2.add(ChatColor.YELLOW + Data.teamOrange.get(i).getDisplayName());
        }

        meta2.setLore(lore2);
        team2.setItemMeta(meta2);

        //Item für leere Slots:
        ItemStack glass = new ItemStack(Material.STAINED_GLASS);
        ItemMeta metaGlass = glass.getItemMeta();
        metaGlass.setDisplayName(" ");
        metaGlass.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        glass.setItemMeta(metaGlass);

        //Inventar öffnen + "Reinwandern" der Items:
        final Inventory finalInv = inv;
        Paintball.getInstance().teamInventoryID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Paintball.getInstance(), new Runnable() {
            int teamInventoryCounter = 8;
            @Override
            public void run() {
                switch (teamInventoryCounter) {
                    case 8:
                        finalInv.setItem(0, glass);
                        finalInv.setItem(1, glass);
                        finalInv.setItem(2, glass);
                        finalInv.setItem(3, glass);
                        finalInv.setItem(4, glass);
                        finalInv.setItem(5, glass);
                        finalInv.setItem(6, glass);
                        finalInv.setItem(7, glass);
                        finalInv.setItem(8, glass);
                        p.openInventory(finalInv);
                        p.updateInventory();
                        break;
                    case 7:
                        finalInv.setItem(0, team1);
                        finalInv.setItem(1, glass);
                        finalInv.setItem(2, glass);
                        finalInv.setItem(3, glass);
                        finalInv.setItem(4, glass);
                        finalInv.setItem(5, glass);
                        finalInv.setItem(6, glass);
                        finalInv.setItem(7, glass);
                        finalInv.setItem(8, team2);
                        p.updateInventory();
                        break;
                    case 6:
                        finalInv.setItem(1, team1);
                        finalInv.setItem(2, glass);
                        finalInv.setItem(3, glass);
                        finalInv.setItem(4, glass);
                        finalInv.setItem(5, glass);
                        finalInv.setItem(6, glass);
                        finalInv.setItem(7, team2);
                        p.updateInventory();
                        break;
                    case 5:
                        finalInv.setItem(2, team1);
                        finalInv.setItem(3, glass);
                        finalInv.setItem(4, glass);
                        finalInv.setItem(5, glass);
                        finalInv.setItem(6, team2);
                        p.updateInventory();
                        break;
                    case 4:
                        finalInv.setItem(0, glass);
                        finalInv.setItem(8, glass);
                        p.updateInventory();
                        break;
                    case 3:
                        finalInv.setItem(1, glass);
                        finalInv.setItem(7, glass);
                        p.updateInventory();
                        break;
                    case 2:
                        p.updateInventory();
                        break;
                    case 1:
                        p.updateInventory();
                        Bukkit.getScheduler().cancelTask(Paintball.getInstance().teamInventoryID);
                        break;
                    default:
                        break;
                }
                teamInventoryCounter--;
            }
        }, 0, 1);
    }
}
