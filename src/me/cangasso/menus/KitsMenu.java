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

public class KitsMenu {
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
				"�7\u27b3 �a�lSEUS KITS �8(p\u00e1g. 1)");
		final ItemStack maiskits = new ItemStack(Material.getMaterial(351), 1, (short) 10);
		final ItemMeta kmaiskits = maiskits.getItemMeta();
		kmaiskits.setDisplayName("�7\u27b3 �a�lPROXIMA PAGINA");
		maiskits.setItemMeta(kmaiskits);
		final ItemStack kits = new ItemStack(Material.getMaterial(54));
		final ItemMeta kkits = kits.getItemMeta();
		kkits.setDisplayName("�7\u27b3 �a�lSEUS KITS");
		kits.setItemMeta(kkits);
		final ItemStack lojadekits = new ItemStack(Material.getMaterial(388));
		final ItemMeta klojadekits = lojadekits.getItemMeta();
		klojadekits.setDisplayName("�7\u27b3 �2�lLOJA DE KITS");
		lojadekits.setItemMeta(klojadekits);
		final ItemStack padraokit = new ItemStack(Material.getMaterial(351), 1, (short) 6);
		final ItemMeta kpadraokit = padraokit.getItemMeta();
		kpadraokit.setDisplayName("�7\u27b3 �3�lKIT PADRAO");
		kpadraokit.setLore(Arrays.asList("�7Facilite seu modo de jogo", "�7usando o sistema �e�lPADRAO KIT.", " "));
		padraokit.setItemMeta(kpadraokit);
		final ItemStack todososkits = new ItemStack(Material.getMaterial(399));
		final ItemMeta ktodososkits = todososkits.getItemMeta();
		ktodososkits.setDisplayName("�7\u27b3 �9�lTODOS OS KITS");
		todososkits.setItemMeta(ktodososkits);
		final ItemStack ConfigureKit = new ItemStack(Material.getMaterial(131));
		final ItemMeta kConfigureKit = ConfigureKit.getItemMeta();
		kConfigureKit.setDisplayName("�7\u27b3 �6�lCUSTOM KIT");
		kConfigureKit.setLore(Arrays.asList("�c�l[�4�lEM BREVE�c�l] ", "�7Configure seu kit",
				"�7para uma melhor jogabilidade.", " "));
		ConfigureKit.setItemMeta(kConfigureKit);
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
		if (cfGrupo.ChecarGrupo(p, "Membro") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Helper")
				|| cfGrupo.ChecarGrupo(p, "Light") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.STONE_SWORD, "�7\u27b3 �6�lPvP", new String[] {
					"�a�lHABILIDADE: �7Derrote seus advers\u00e1rios ", "�7utilizando sua espada avançada" }) });
		}
		if (cfGrupo.ChecarGrupo(p, "Membro") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Helper")
				|| cfGrupo.ChecarGrupo(p, "Light") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.BOW, "�7\u27b3 �6�lArcher",
					new String[] { "�a�lHABILIDADE: �7Acabe com os oponentes usando", "�7seu arco!" }) });
		}
		if (cfGrupo.ChecarGrupo(p, "Membro") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Helper")
				|| cfGrupo.ChecarGrupo(p, "Light") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "S-Pro")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.FIREWORK, "�7\u27b3 �6�lKangaroo",
					new String[] { "�a�lHABILIDADE: �7D\u00ea saltos como um", "�7canguru utilizando seu item" }) });
		}
		if (cfGrupo.ChecarGrupo(p, "Membro") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Helper")
				|| cfGrupo.ChecarGrupo(p, "Light") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.FISHING_ROD, "�7\u27b3 �6�lFisherman",
					new String[] { "�a�lHABILIDADE: �7Pesque o seu advers\u00e1rio e faça estrat\u00e9gias!" }) });
		}
		if (cfGrupo.ChecarGrupo(p, "Membro") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Helper")
				|| cfGrupo.ChecarGrupo(p, "Light") || cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.CACTUS, "�7\u27b3 �6�lCactus",
					new String[] { "�a�lHABILIDADE: �7Vire um cacto e", "�7espete seus inimigos!" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.monk") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Trial")
				|| cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light
				|| GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.BLAZE_ROD, "�7\u27b3 �6�lMonk",
					new String[] { "�a�lHABILIDADE: �7Faça alteraç\u00f5es no invent\u00e1rio",
							"�7dos seus oponentes!" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.ninja") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Trial")
				|| cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light
				|| GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.COMPASS, "�7\u27b3 �6�lNinja", new String[] {
					"�a�lHABILIDADE: �7Teleporte-se at\u00e9 o", "�7\u00faltimo jogador hitado clicando Shift!" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.phantom") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Trial")
				|| cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light
				|| GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.FEATHER, "�7\u27b3 �6�lPhantom",
					new String[] { "�a�lHABILIDADE: �7Utilize sua pena para", "�7voar como um p\u00e1ssaro!" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.grappler") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Trial")
				|| cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light
				|| GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.LEASH, "�7\u27b3 �6�lGrappler",
					new String[] { "�a�lHABILIDADE: �7Escale paredes utilizando", "�7sua corda m\u00e1gica!" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.viper") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Trial")
				|| cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light
				|| GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.SPIDER_EYE, "�7\u27b3 �6�lViper", new String[] {
					"�a�lHABILIDADE: �7Aplique veneno em seus", "�7advers\u00e1rios ao entra em combate!" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.snail") || cfGrupo.ChecarGrupo(p, "Light")
				|| cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Trial")
				|| cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light
				|| GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.STRING, "�7\u27b3 �6�lSnail",
					new String[] { "�a�lHABILIDADE: �7Aplique lentidão profunda", "�7e ganhe vantagem!" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.hulk") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.SADDLE, "�7\u27b3 �6�lHulk",
					new String[] { "�a�lHABILIDADE: �7Puxe seus inimigos para cima", "�7e os detenha!" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.timelord") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.mvp || GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.WATCH, "�7\u27b3 �6�lTimelord",
					new String[] { "�a�lHABILIDADE: �7Congele os players de", "�7sua volta" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.thor") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod")
				|| cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.mvp
				|| GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.WOOD_AXE, "�7\u27b3 �6�lThor",
					new String[] { "�a�lHABILIDADE: �7Vire o thor e lançe raios", "�7em seus inimigos" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.switcher") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod")
				|| cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.mvp
				|| GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.SNOW_BALL, "�7\u27b3 �6�lSwitcher", new String[] {
					"�a�lHABILIDADE: �7Troque de lugar com seus inimigos ao", "�7acertar uma bola de neve nele" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.gladiator") || cfGrupo.ChecarGrupo(p, "Mvp")
				|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod")
				|| cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.mvp
				|| GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.IRON_FENCE, "�7\u27b3 �6�lGladiator",
					new String[] { "�a�lHABILIDADE: �7Puxe seus inimigos para um", "�7duelo nas alturas!" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.stomper") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.IRON_BOOTS, "�7\u27b3 �6�lStomper", new String[] {
					"�a�lHABILIDADE: �7Transfira seu dano de", "�7queda para seus inimigos ao pular neles." }) });
		}
		if (cfPermissão.getPermissao(p, "kit.magma") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.FIRE, "�7\u27b3 �6�lMagma",
					new String[] { "�a�lHABILIDADE: �7Receba 30% de chance de queimar", "�7seus inimigos!" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.grandpa") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.STICK, "�7\u27b3 �6�lGrandpa", new String[] {
					"�a�lHABILIDADE: �7Jogue seus inimigos para longe", "�7utilizando seu graveto!" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.ajnin") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.NETHER_STAR, "�7\u27b3 �6�lAjnin", new String[] {
					"�a�lHABILIDADE: �7Puxe o \u00faltimo jogador hitado", "�7at\u00e9 voc\u00ea clicando shift!" }) });
		}
		if (cfPermissão.getPermissao(p, "kit.firelauncher") || cfGrupo.ChecarGrupo(p, "Pro")
				|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+")
				|| cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+")
				|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit
				|| GiveAllCommand.pro) {
			menu.addItem(new ItemStack[] { criarItemMenu(Material.FIREBALL, "�7\u27b3 �6�lFirelauncher",
					new String[] { "�a�lHABILIDADE: �7Utilize a sua habilidade para", "�7queimar seus inimigos" }) });
		}
		p.openInventory(menu);
	}
}
