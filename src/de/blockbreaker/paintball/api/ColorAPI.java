package de.blockbreaker.paintball.api;

import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

/**
 * Created by Janne on 25.06.2015.
 */
public class ColorAPI {
    public static ItemStack setColor(ItemStack itemStack, int r, int g, int b){
        LeatherArmorMeta itemMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        itemMeta.setColor(Color.fromRGB(r, g, b));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack setColor(ItemStack itemStack, Color color){
        LeatherArmorMeta itemMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        itemMeta.setColor(color);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public static ItemStack setRandomColor(ItemStack itemStack) {
        int r = (int) (Math.random() * 255 + 1);
        int g = (int) (Math.random() * 255 + 1);
        int b = (int) (Math.random() * 255 + 1);
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) itemStack.getItemMeta();
        itemMeta.setColor(Color.fromRGB(r, g, b));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
