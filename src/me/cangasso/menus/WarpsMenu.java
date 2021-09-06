package me.cangasso.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WarpsMenu {
	public static ItemStack criarItemMenu(final Material material, final String nome, final String[] habilidade) {
		final ItemStack item = new ItemStack(material);
		final ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		return item;
	}

	public static void inventory(final Player p) {
		final Inventory menu = Bukkit.createInventory((InventoryHolder) p, 27, "§7\u27b3 §6§lWARPS");
		menu.setItem(10, criarItemMenu(Material.GLASS, "§6§lFPS", new String[1]));
		menu.setItem(12, criarItemMenu(Material.BLAZE_ROD, "§6§l1V1", new String[1]));
		menu.setItem(14, criarItemMenu(Material.LAVA, "§6§lLAVACHALLENGE", new String[1]));
		menu.setItem(16, criarItemMenu(Material.STICK, "§6§lKNOCKBACK", new String[1]));
		menu.setItem(2, criarItemMenu(Material.FISHING_ROD, "§6§lFISHERMAN", new String[1]));
		menu.setItem(0, criarItemMenu(Material.WATER_BUCKET, "§6§lMLG", new String[1]));
		menu.setItem(18, criarItemMenu(Material.BEDROCK, "§c§lEM BREVE", new String[1]));
		menu.setItem(4, criarItemMenu(Material.DIAMOND_SWORD, "§6§lMAIN", new String[1]));
		menu.setItem(6, criarItemMenu(Material.BEDROCK, "§c§lEM BREVE", new String[1]));
		menu.setItem(8, criarItemMenu(Material.BEDROCK, "§c§lEM BREVE", new String[1]));
		menu.setItem(20, criarItemMenu(Material.BEDROCK, "§c§lEM BREVE", new String[1]));
		menu.setItem(22, criarItemMenu(Material.BEDROCK, "§c§lEM BREVE", new String[1]));
		menu.setItem(24, criarItemMenu(Material.BEDROCK, "§c§lEM BREVE", new String[1]));
		menu.setItem(26, criarItemMenu(Material.BEDROCK, "§c§lEM BREVE", new String[1]));
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
		final ItemMeta vidrom = vidro.getItemMeta();
		vidrom.setDisplayName("§6§lCookie§f§lNetwork");
		vidro.setItemMeta(vidrom);
		final ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		final ItemMeta vidro1m = vidro2.getItemMeta();
		vidro1m.setDisplayName("§6§lCookie§f§lNetwork");
		vidro.setItemMeta(vidro1m);
		menu.setItem(1, vidro);
		menu.setItem(3, vidro2);
		menu.setItem(5, vidro2);
		menu.setItem(7, vidro);
		menu.setItem(9, vidro2);
		menu.setItem(11, vidro);
		menu.setItem(13, vidro);
		menu.setItem(15, vidro);
		menu.setItem(17, vidro2);
		menu.setItem(19, vidro);
		menu.setItem(21, vidro2);
		menu.setItem(23, vidro2);
		menu.setItem(25, vidro);
		p.openInventory(menu);
	}
}
