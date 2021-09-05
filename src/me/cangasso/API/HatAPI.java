package me.cangasso.API;

import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;

public class HatAPI
{
    public static void removeHat(final Player p) {
        p.getInventory().setHelmet((ItemStack)null);
    }
}
