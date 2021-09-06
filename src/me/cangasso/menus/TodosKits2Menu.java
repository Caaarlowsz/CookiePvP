package me.cangasso.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TodosKits2Menu {
	public static ItemStack criarItemMenu(final Material material, final String nome, final String[] habilidade) {
		final ItemStack item = new ItemStack(material);
		final ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		return item;
	}

	public static void inventory(final Player p) {
		final Inventory menu = Bukkit.createInventory((InventoryHolder) p, 54,
				"§7\u27b3 §9§lTODOS OS KITS §8(p\u00e1g. 2)");
		final ItemStack maiskits = new ItemStack(Material.getMaterial(351), 1, (short) 1);
		final ItemMeta kmaiskits = maiskits.getItemMeta();
		kmaiskits.setDisplayName("§7\u27b3 §c§lPAGINA ANTERIOR");
		maiskits.setItemMeta(kmaiskits);
		final ItemStack kits = new ItemStack(Material.getMaterial(54));
		final ItemMeta kkits = kits.getItemMeta();
		kkits.setDisplayName("§7\u27b3 §a§lSEUS KITS");
		kits.setItemMeta(kkits);
		final ItemStack lojadekits = new ItemStack(Material.getMaterial(388));
		final ItemMeta klojadekits = lojadekits.getItemMeta();
		klojadekits.setDisplayName("§7\u27b3 §2§lLOJA DE KITS");
		lojadekits.setItemMeta(klojadekits);
		final ItemStack padraokit = new ItemStack(Material.getMaterial(351), 1, (short) 6);
		final ItemMeta kpadraokit = padraokit.getItemMeta();
		kpadraokit.setDisplayName("§7\u27b3 §3§lKIT PADRAO");
		kpadraokit.setLore(Arrays.asList("§7Facilite seu modo de jogo", "§7usando o sistema §e§lPADRAO KIT.", " "));
		padraokit.setItemMeta(kpadraokit);
		final ItemStack todososkits = new ItemStack(Material.getMaterial(399));
		final ItemMeta ktodososkits = todososkits.getItemMeta();
		ktodososkits.setDisplayName("§7\u27b3 §9§lTODOS OS KITS");
		todososkits.setItemMeta(ktodososkits);
		final ItemStack ConfigureKit = new ItemStack(Material.getMaterial(131));
		final ItemMeta kConfigureKit = ConfigureKit.getItemMeta();
		kConfigureKit.setDisplayName("§7\u27b3 §6§lCUSTOM KIT");
		kConfigureKit.setLore(Arrays.asList("§c§l[§4§lEM BREVE§c§l] ", "§7Configure seu kit",
				"§7para uma melhor jogabilidade.", " "));
		ConfigureKit.setItemMeta(kConfigureKit);
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
		final ItemMeta kvidro = vidro.getItemMeta();
		kvidro.setDisplayName("§6§lCookie§f§lNetwork");
		vidro.setItemMeta(kvidro);
		final ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		final ItemMeta kvidro2 = vidro2.getItemMeta();
		kvidro.setDisplayName("§6§lCookie§f§lNetwork");
		vidro.setItemMeta(kvidro2);
		final ItemStack cake = new ItemStack(Material.COOKIE);
		final ItemMeta kcake = cake.getItemMeta();
		kvidro.setDisplayName("§6§lCookie!");
		vidro.setItemMeta(kcake);
		menu.setItem(0, padraokit);
		menu.setItem(8, padraokit);
		menu.setItem(1, vidro2);
		menu.setItem(2, vidro);
		menu.setItem(6, vidro);
		menu.setItem(7, vidro2);
		menu.setItem(9, vidro2);
		menu.setItem(10, vidro);
		menu.setItem(11, vidro2);
		menu.setItem(12, vidro);
		menu.setItem(13, vidro2);
		menu.setItem(14, vidro);
		menu.setItem(15, vidro2);
		menu.setItem(16, vidro);
		menu.setItem(17, vidro2);
		menu.setItem(18, vidro);
		menu.setItem(26, vidro);
		menu.setItem(27, maiskits);
		menu.setItem(35, vidro2);
		menu.setItem(36, vidro2);
		menu.setItem(44, vidro2);
		menu.setItem(45, vidro);
		menu.setItem(46, vidro2);
		menu.setItem(47, vidro);
		menu.setItem(48, vidro2);
		menu.setItem(49, cake);
		menu.setItem(50, vidro2);
		menu.setItem(51, vidro);
		menu.setItem(52, vidro2);
		menu.setItem(53, vidro);
		menu.setItem(3, todososkits);
		menu.setItem(4, kits);
		menu.setItem(5, lojadekits);
		menu.setItem(27, maiskits);
		menu.addItem(new ItemStack[] {
				criarItemMenu(Material.WATCH, "§aStrong", new String[] { "§7Fique fulliron por 10s" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.APPLE, "§aSumo",
				new String[] { "§7Voc\u00ea \u00e9 t\u00e3o gordo que joga ", "§7seus inimigos pro alto" }) });
		p.openInventory(menu);
	}
}
