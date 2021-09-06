package me.cangasso.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TodosKitsMenu {
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
				"§7\u27b3 §9§lTODOS OS KITS §8(p\u00e1g. 1)");
		final ItemStack maiskits = new ItemStack(Material.getMaterial(351), 1, (short) 10);
		final ItemMeta kmaiskits = maiskits.getItemMeta();
		kmaiskits.setDisplayName("§7\u27b3 §a§lPROXIMA PAGINA");
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
		kvidro2.setDisplayName("§6§lCookie§f§lNetwork");
		vidro2.setItemMeta(kvidro2);
		final ItemStack cake = new ItemStack(Material.COOKIE);
		final ItemMeta kcake = cake.getItemMeta();
		kcake.setDisplayName("§6§lCookie!");
		cake.setItemMeta(kcake);
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
		menu.setItem(35, maiskits);
		menu.addItem(new ItemStack[] { criarItemMenu(Material.STONE_SWORD, "§7\u27b3 §6§lPvP", new String[] {
				"§a§lHABILIDADE: §7Supere os advers\u00e1rios", "§7com a sua espada avan\u00e7ada!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.BOW, "§7\u27b3 §6§lArcher",
				new String[] { "§a§lHABILIDADE: §7Use o seu Arco para", "§7combater seus inimigos!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.FIREWORK, "§7\u27b3 §6§lKangaroo",
				new String[] { "§a§lHABILIDADE: §7Use a sua habilidade e", "§7d\u00ea pulos como um canguru!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.FISHING_ROD, "§7\u27b3 §6§lFisherman",
				new String[] { "§a§lHABILIDADE: §7Pesque os seus inimigos e puxe-os at\u00e9 voc\u00ea!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.CACTUS, "§7\u27b3 §6§lCactus",
				new String[] { "§a§lHABILIDADE: §7Vire um cacto e espete", "§7os seus inimigos" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.BLAZE_ROD, "§7\u27b3 §6§lMonk",
				new String[] { "§a§lHABILIDADE: §7Fa\u00e7a altera\u00e7\u00f5es no invet\u00e1rio", "§7inimigo!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.COMPASS, "§7\u27b3 §6§lNinja",
				new String[] { "§a§lHABILIDADE: §7Use as suas habilidades", "§7e voe igual um p\u00e1ssaro!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.FEATHER, "§7\u27b3 §6§lPhantom",
				new String[] { "§a§lHABILIDADE: §7Use as suas habilidades", "§7e voe igual um p\u00e1ssaro!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.LEASH, "§7\u27b3 §6§lGrappler",
				new String[] { "§a§lHABILIDADE: §7Fisgue o seu la\u00e7o em algo", "§7e divirta-se!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.SPIDER_EYE, "§7\u27b3 §6§lViper",
				new String[] { "§a§lHABILIDADE: §7Aplique veneno nos", "§7inimigos e obtenha vantagem!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.STRING, "§7\u27b3 §6§lSnail",
				new String[] { "§a§lHABILIDADE: §7Deixe seus advers\u00e1rios cansados e ataque-os!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.SADDLE, "§7\u27b3 §6§lHulk", new String[] {
				"§a§lHABILIDADE: §7Puxe seus inimigos para cima", "§7de voc\u00ea e os deixe im\u00f3veis!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.WATCH, "§7\u27b3 §6§lTimelord",
				new String[] { "§a§lHABILIDADE: §7Congele os jogadores", "§7a sua volta" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.WOOD_AXE, "§7\u27b3 §6§lThor",
				new String[] { "§a§lHABILIDADE: §7Fa\u00e7a uma chuva de", "§7raios e combata seus inimigos!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.SNOW_BALL, "§7\u27b3 §6§lSwitcher",
				new String[] { "§a§lHABILIDADE: §7Troque de lugar com",
						"§7seu advers\u00e1rio usando suas bolas de neve ( \u0361° \u035c\u0296 \u0361°)" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.IRON_FENCE, "§7\u27b3 §6§lGladiator",
				new String[] { "§a§lHABILIDADE: §7Puxe seu advers\u00e1rio para um duelo", "§7nas alturas!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.IRON_BOOTS, "§7\u27b3 §6§lStomper",
				new String[] { "§a§lHABILIDADE: §7Pise em seus inimigos e", "§7e esmague-os!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.FIRE, "§7\u27b3 §6§lMagma",
				new String[] { "§a§lHABILIDADE: §7Acerte golpes nos seus inimigos",
						"§7e receba §2§l30% §7de chance de queima-los!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.STICK, "§7\u27b3 §6§lGrandpa",
				new String[] { "§a§lHABILIDADE: §7Lance os seus inimigos", "§7para longe utilizando seu graveto!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.NETHER_STAR, "§7\u27b3 §6§lAjnin",
				new String[] { "§a§lHABILIDADE: §7Puxe at\u00e9 voc\u00ea o \u00faltimo", "§7jogador hitado!" }) });
		menu.addItem(new ItemStack[] { criarItemMenu(Material.FIREBALL, "§7\u27b3 §6§lFireLauncher",
				new String[] { "§a§lHABILIDADE: §7Use o seu kit", "§7para p\u00f4r chamas nos advers\u00e1rios!" }) });
		p.openInventory(menu);
	}
}
