package me.cangasso.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.cangasso.commands.GiveAllCommand;
import me.cangasso.configuração.cfGrupo;
import me.cangasso.configuração.cfPermissão;

public class PadraoMenu {
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
				"�7\u27b3 �3�lKIT PADRAO �8(p\u00e1g. 1)");
		final ItemStack Voltar = new ItemStack(Material.CARPET, 1, (short) 14);
		final ItemMeta kVoltar = Voltar.getItemMeta();
		kVoltar.setDisplayName("�c�lVOLTAR");
		kVoltar.setLore(Arrays.asList("�7volte para o menu", "�7dos kits que voc\u00ea possui", " "));
		Voltar.setItemMeta(kVoltar);
		final ItemStack PQ = new ItemStack(Material.SLIME_BALL);
		final ItemMeta kPQ = PQ.getItemMeta();
		kPQ.setDisplayName("�7\u27b3 �3�lKIT PADRAO");
		kPQ.setLore(Arrays.asList("�7Para que voc\u00ea não precise ficar", "�7escolhendo toda hora um kit",
				"�7criamos o kit padrao."));
		PQ.setItemMeta(kPQ);
		final ItemStack maiskits = new ItemStack(Material.getMaterial(351), 1, (short) 10);
		final ItemMeta kmaiskits = maiskits.getItemMeta();
		kmaiskits.setDisplayName("�7\u27b3 �a�lPROXIMA PAGINA");
		maiskits.setItemMeta(kmaiskits);
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
		final ItemMeta kvidro = vidro.getItemMeta();
		kvidro.setDisplayName("�6�lCookie�f�lNetwork");
		vidro.setItemMeta(kvidro);
		final ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		final ItemMeta kvidro2 = vidro2.getItemMeta();
		kvidro.setDisplayName("�6�lCookie�f�lNetwork");
		vidro.setItemMeta(kvidro2);
		final ItemStack cake = new ItemStack(Material.COOKIE);
		final ItemMeta kcake = cake.getItemMeta();
		kvidro.setDisplayName("�6�lCookie!");
		vidro.setItemMeta(kcake);
		menu.setItem(0, Voltar);
		menu.setItem(8, Voltar);
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
		menu.setItem(3, vidro);
		menu.setItem(4, PQ);
		menu.setItem(5, vidro);
		menu.setItem(35, maiskits);
		if (cfGrupo.ChecarGrupo(p, "Membro") || cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.STONE_SWORD, "�aPvP",
					new String[] { "�7O Unico kit que possui", "�7espada de pedra" }) });
		}
		if (cfGrupo.ChecarGrupo(p, "Membro") || cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.BOW, "�aArcher",
					new String[] { "�7Vire um arqueiro e de", "�7flechadas em seus ininimigos" }) });
		}
		if (cfGrupo.ChecarGrupo(p, "Membro") || cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "S-Pro")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.FIREWORK, "�aKangaroo",
					new String[] { "�7Use seu firework para", "�7da double jumps" }) });
		}
		if (cfGrupo.ChecarGrupo(p, "Membro") || cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] {
					criarItemMenu(Material.FISHING_ROD, "�aFisherman", new String[] { "�7Pesque seus inimigos" }) });
		}
		if (cfGrupo.ChecarGrupo(p, "Membro") || cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.CACTUS, "�aCactus",
					new String[] { "�7Vire um cactu e", "�7devolva o dano em seu inimigo" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.monk") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.BLAZE_ROD, "�aMonk",
					new String[] { "�7Confuda o inventraio de", "�7seus inimigos" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.ninja") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.COMPASS, "�aNinja",
					new String[] { "�7Aperte shift para teleportar ao", "�7ultimo jogador hitado" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.phantom") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.FEATHER, "�aPhantom",
					new String[] { "�7Use a pena para virar", "�7um passaro e voar" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.grappler") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.LEASH, "�aGrappler",
					new String[] { "�7Use seu laço para se", "�7locomover pelo mapa" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.viper") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.SPIDER_EYE, "�aViper",
					new String[] { "�7Invenene seus inimigos", "�7ao bater neles" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.snail") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] {
					criarItemMenu(Material.STRING, "�aSnail", new String[] { "�7Deixe seus inimigos lerdos" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.hulk") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.SADDLE, "�aHulk",
					new String[] { "�7Puxe seus inimigos para carcunda", "�7e critique eles" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.timelord") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.WATCH, "�aTimelord",
					new String[] { "�7Congele os players de", "�7sua volta" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.thor") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.WOOD_AXE, "�aThor",
					new String[] { "�7Vire o thor e lançe raios", "�7em seus inimigos" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.switcher") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.SNOW_BALL, "�aSwitcher",
					new String[] { "�7Troque de lugar com seus inimigos ao", "�7acertar uma bola de neve nele" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.gladiator") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.IRON_FENCE, "�aGladiator",
					new String[] { "�7Puxe seus inimigos para", "�7um 1v1 na jaula" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.stomper") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.IRON_BOOTS, "�aStomper",
					new String[] { "�7Ao cair em cima de seus", "�7inimigos esmague-os" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.magma") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.FIRE, "�aMagma",
					new String[] { "�7Ao bater em seu inimigo", "�7tenha chançe de colocar fogo nele" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.grandpa") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.STICK, "�aGrandpa",
					new String[] { "�7Jogue seu inimigo longe", "�7usando seu stick" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.ajnin") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.NETHER_STAR, "�aAjnin", new String[] {
					"�7Ao apertar shift o ultimo", "�7jogador hitado \u00e9 teleportado a voc\u00ea" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.firelauncher") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.FIREBALL, "�aFireLauncher",
					new String[] { "�7Use seu kit para", "�7queimar seus inimigos" }) });
		}
		p.openInventory(menu);
	}
}
