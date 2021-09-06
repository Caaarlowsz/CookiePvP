package me.cangasso.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LojaVips {
	public static ItemStack criarItemMenu(final Material material, final String nome, final String[] habilidade) {
		final ItemStack item = new ItemStack(material);
		final ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		return item;
	}

	public static void inventory(final Player p) {
		final Inventory menu = Bukkit.createInventory((InventoryHolder) p, 9, "§7Qual §6[VIP] §7deseja?");
		menu.setItem(2, criarItemMenu(Material.EMERALD_BLOCK, "§7[VIP] §a§lLIGHT",
				new String[] { " ", "                   §7\u25ff §7§lBeneficios §7\u25ff",
						"§7- §7§lSLOT EXCLUSIVO EM NOSSO SERVIDOR", "§7- §7§lTAG §a§lLIGHT §7§lPARA SER DIFRENCIADO",
						"§7- §7§lACESSO A 11 KITS DO SERVIDOR", " " }));
		menu.setItem(4,
				criarItemMenu(Material.LAPIS_BLOCK, "§7[VIP] §9§lMVP",
						new String[] { " ", "                   §7\u25ff §7§lBeneficios §7\u25ff",
								"§7- §7§lSLOT EXCLUSIVO EM NOSSO SERVIDOR",
								"§7- §7§lTAG §a§lLIGHT §7e §9§lMVP §7§lPARA SER DIFRENCIADO",
								"§7- §7§lACESSO A 16 KITS DO SERVIDOR", " " }));
		menu.setItem(6,
				criarItemMenu(Material.GOLD_BLOCK, "§7[VIP] §6§lPRO",
						new String[] { " ", "                   §7\u25ff §7§lBeneficios §7\u25ff",
								"§7- §7§lSLOT EXCLUSIVO EM NOSSO SERVIDOR",
								"§7- §7§lTAG §a§lLIGHT§7, §9§lMVP §7e §6§lPRO §7§lPARA SER DIFRENCIADO",
								"§7- §7§lACESSO A TODOS KITS DO SERVIDOR", " " }));
		p.openInventory(menu);
	}
}
