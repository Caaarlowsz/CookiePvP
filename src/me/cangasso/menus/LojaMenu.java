package me.cangasso.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import me.cangasso.configura\u00e7\u00e3o.cfPermiss\u00e3o;

public class LojaMenu {
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
				"§7\u27b3 §2§lLOJA DE KITS §8(p\u00e1g. 1)");
		final ItemStack maiskits = new ItemStack(Material.getMaterial(351), 1, (short) 10);
		final ItemMeta kmaiskits = maiskits.getItemMeta();
		kmaiskits.setDisplayName("§7\u27b3  §a§lPROXIMA PAGINA");
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
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		final ItemMeta kvidro = vidro.getItemMeta();
		kvidro.setDisplayName("§6§lCookie§f§lNetwork");
		vidro.setItemMeta(kvidro);
		menu.setItem(0, padraokit);
		menu.setItem(8, padraokit);
		menu.setItem(1, vidro);
		menu.setItem(2, vidro);
		menu.setItem(6, vidro);
		menu.setItem(7, vidro);
		menu.setItem(9, vidro);
		menu.setItem(10, vidro);
		menu.setItem(11, vidro);
		menu.setItem(12, vidro);
		menu.setItem(13, vidro);
		menu.setItem(14, vidro);
		menu.setItem(15, vidro);
		menu.setItem(16, vidro);
		menu.setItem(17, vidro);
		menu.setItem(18, vidro);
		menu.setItem(26, vidro);
		menu.setItem(27, vidro);
		menu.setItem(35, vidro);
		menu.setItem(36, vidro);
		menu.setItem(44, vidro);
		menu.setItem(45, vidro);
		menu.setItem(46, vidro);
		menu.setItem(47, vidro);
		menu.setItem(48, vidro);
		menu.setItem(49, vidro);
		menu.setItem(50, vidro);
		menu.setItem(51, vidro);
		menu.setItem(52, vidro);
		menu.setItem(53, vidro);
		menu.setItem(3, todososkits);
		menu.setItem(4, kits);
		menu.setItem(5, lojadekits);
		menu.setItem(35, maiskits);
		if (cfGrupo.ChecarGrupo(p, "Membro")) {
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.monk")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.BLAZE_ROD, "§cMonk §c§l15.000",
						new String[] { "§7Confuda o inventraio de", "§7seus inimigos" }) });
			} else {
				menu.remove(Material.BLAZE_ROD);
			}
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.ninja")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.COMPASS, "§cNinja §c§l17.000",
						new String[] { "§7Aperte shift para teleportar ao", "§7ultimo jogador hitado" }) });
			} else {
				menu.remove(Material.COMPASS);
			}
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.phantom")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.FEATHER, "§cPhantom §c§l15.000",
						new String[] { "§7Use a pena para virar", "§7um passaro e voar" }) });
			} else {
				menu.remove(Material.FEATHER);
			}
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.grappler")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.LEASH, "§cGrappler §c§l17.000",
						new String[] { "§7Use seu la\u00e7o para se", "§7locomover pelo mapa" }) });
			} else {
				menu.remove(Material.LEASH);
			}
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.viper")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.SPIDER_EYE, "§cViper §c§l10.000",
						new String[] { "§7Invenene seus inimigos", "§7ao bater neles" }) });
			} else {
				menu.remove(Material.SPIDER_EYE);
			}
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.snail")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.STRING, "§cSnail §c§l10.000",
						new String[] { "§7Deixe seus inimigos lerdos" }) });
			} else {
				menu.remove(Material.STRING);
			}
		}
		if (cfGrupo.ChecarGrupo(p, "Membro") || cfGrupo.ChecarGrupo(p, "Light") || cfGrupo.ChecarGrupo(p, "Trial")) {
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.hulk")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.SADDLE, "§cHulk §c§l15.000",
						new String[] { "§7Puxe seus inimigos para carcunda", "§7e critique eles" }) });
			} else {
				menu.remove(Material.SADDLE);
			}
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.timelord")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.WATCH, "§cTimelord §c§l15.000",
						new String[] { "§7Congele os players de", "§7sua volta" }) });
			} else {
				menu.remove(Material.WATCH);
			}
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.thor")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.WOOD_AXE, "§cThor §c§l15.000",
						new String[] { "§7Vire o thor e lan\u00e7e raios", "§7em seus inimigos" }) });
			} else {
				menu.remove(Material.WOOD_AXE);
			}
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.switcher")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.SNOW_BALL, "§cSwitcher §c§l10.000", new String[] {
						"§7Troque de lugar com seus inimigos ao", "§7acertar uma bola de neve nele" }) });
			} else {
				menu.remove(Material.SNOW_BALL);
			}
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.gladiator")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.IRON_FENCE, "§cGladiator §c§l30.000",
						new String[] { "§7Puxe seus inimigos para", "§7um 1v1 na jaula" }) });
			} else {
				menu.remove(Material.IRON_FENCE);
			}
		}
		if (cfGrupo.ChecarGrupo(p, "Membro") || cfGrupo.ChecarGrupo(p, "Light") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Trial")) {
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.stomper")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.IRON_BOOTS, "§cStomper §c§l35.000",
						new String[] { "§7Ao cair em cima de seus", "§7inimigos esmague-os" }) });
			} else {
				menu.remove(Material.IRON_BOOTS);
			}
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.magma")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.FIRE, "§cMagma §c§l17.000",
						new String[] { "§7Ao bater em seu inimigo", "§7tenha chan\u00e7e de colocar fogo nele" }) });
			} else {
				menu.remove(Material.FIRE);
			}
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.grandpa")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.STICK, "§cGrandpa §c§l10.000",
						new String[] { "§7Jogue seu inimigo longe", "§7usando seu stick" }) });
			} else {
				menu.remove(Material.STICK);
			}
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.ajnin")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.NETHER_STAR, "§cAjnin §c§l20.000", new String[] {
						"§7Ao apertar shift o ultimo", "§7jogador hitado \u00e9 teleportado a voc\u00ea" }) });
			} else {
				menu.remove(Material.NETHER_STAR);
			}
			if (!cfPermiss\u00e3o.getPermissao(p, "kit.firelauncher")) {
				menu.addItem(new ItemStack[] { criarItemMenu(Material.FIREBALL, "§cFireLauncher §c§l15.000",
						new String[] { "§7Use seu kit para", "§7queimar seus inimigos" }) });
			} else {
				menu.remove(Material.FIREBALL);
			}
		}
		final ItemStack PossuiTodos = new ItemStack(Material.MAGMA_CREAM);
		final ItemMeta kPossuiTodos = kits.getItemMeta();
		kPossuiTodos.setDisplayName("§4§l(!) §cVoc\u00ea j\u00e1 possui todos os kits!");
		PossuiTodos.setItemMeta(kPossuiTodos);
		if (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Dono")) {
			menu.setItem(31, PossuiTodos);
		}
		if (cfPermiss\u00e3o.getPermissao(p, "kit.monk") && cfPermiss\u00e3o.getPermissao(p, "kit.ninja")
				&& cfPermiss\u00e3o.getPermissao(p, "kit.phantom") && cfPermiss\u00e3o.getPermissao(p, "kit.grappler")
				&& cfPermiss\u00e3o.getPermissao(p, "kit.viper") && cfPermiss\u00e3o.getPermissao(p, "kit.snail")
				&& cfPermiss\u00e3o.getPermissao(p, "kit.hulk") && cfPermiss\u00e3o.getPermissao(p, "kit.timelord")
				&& cfPermiss\u00e3o.getPermissao(p, "kit.thor") && cfPermiss\u00e3o.getPermissao(p, "kit.switcher")
				&& cfPermiss\u00e3o.getPermissao(p, "kit.gladiator")
				&& cfPermiss\u00e3o.getPermissao(p, "kit.endermage") && cfPermiss\u00e3o.getPermissao(p, "kit.stomper")
				&& cfPermiss\u00e3o.getPermissao(p, "kit.firelauncher")
				&& cfPermiss\u00e3o.getPermissao(p, "kit.strong") && cfPermiss\u00e3o.getPermissao(p, "kit.sumo")
				&& cfPermiss\u00e3o.getPermissao(p, "kit.forcefield") && cfPermiss\u00e3o.getPermissao(p, "kit.magma")
				&& cfPermiss\u00e3o.getPermissao(p, "kit.grandpa") && cfPermiss\u00e3o.getPermissao(p, "kit.ajnin")) {
			menu.setItem(31, PossuiTodos);
		}
		p.openInventory(menu);
	}
}
