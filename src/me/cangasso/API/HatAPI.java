package me.cangasso.API;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HatAPI {
	public static void removeHat(final Player p) {
		p.getInventory().setHelmet((ItemStack) null);
	}
}
