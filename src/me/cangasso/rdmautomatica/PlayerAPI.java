package me.cangasso.rdmautomatica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.cangasso.API.API;
import me.cangasso.API.CalendarioAPI;
import me.cangasso.API.GrupoAPI;
import me.cangasso.configuração.cfGrupo;
import me.cangasso.configuração.cfTempGrupo;
import me.cangasso.invencivel.Proteção;
import me.cangasso.main.CookiePvP;
import me.cangasso.scoreboard.sScoreAPI;

public class PlayerAPI {
	public static ArrayList<Player> Participando;
	public static ArrayList<Player> Batalhando;
	public static ArrayList<Player> Esperando;
	public static ArrayList<Player> NaoComandos;
	public static boolean RDM1;
	public static boolean RDM2;
	public static boolean RDM3;
	public static boolean RDM4;
	public static boolean RDM5;
	public static boolean RDM6;
	public static boolean RDM7;
	public static boolean RDM8;
	public static boolean RDM9;
	public static boolean RDM10;
	public static boolean RDM11;
	public static boolean RDM12;
	public static boolean RDM13;
	public static boolean RDM14;
	public static boolean RDM15;
	public static boolean RDM16;
	public static boolean RDM17;
	public static boolean RDM18;
	public static boolean RDM19;
	public static boolean RDM20;
	public static boolean RDM21;
	public static boolean RDM22;
	public static boolean RDM23;
	public static boolean RDM24;
	public static boolean RDM25;
	public static boolean RDM26;
	public static boolean RDM27;
	public static boolean RDM28;
	public static boolean RDM29;
	public static boolean RDM30;
	public static HashMap<Player, String> Ganhador;
	public static HashMap<Player, String> Batalhando1;
	public static HashMap<Player, String> Batalhando2;
	public static HashMap<Player, String> jogador1;
	public static HashMap<Player, String> jogador2;
	public static HashMap<Player, String> jogador3;
	public static HashMap<Player, String> jogador4;
	public static HashMap<Player, String> jogador5;
	public static HashMap<Player, String> jogador6;
	public static HashMap<Player, String> jogador7;
	public static HashMap<Player, String> jogador8;
	public static HashMap<Player, String> jogador9;
	public static HashMap<Player, String> jogador10;
	public static HashMap<Player, String> jogador11;
	public static HashMap<Player, String> jogador12;
	public static HashMap<Player, String> jogador13;
	public static HashMap<Player, String> jogador14;
	public static HashMap<Player, String> jogador15;
	public static HashMap<Player, String> jogador16;
	public static HashMap<Player, String> jogador17;
	public static HashMap<Player, String> jogador18;
	public static HashMap<Player, String> jogador19;
	public static HashMap<Player, String> jogador20;
	public static HashMap<Player, String> jogador21;
	public static HashMap<Player, String> jogador22;
	public static HashMap<Player, String> jogador23;
	public static HashMap<Player, String> jogador24;
	public static HashMap<Player, String> jogador25;
	public static HashMap<Player, String> jogador26;
	public static HashMap<Player, String> jogador27;
	public static HashMap<Player, String> jogador28;
	public static HashMap<Player, String> jogador29;
	public static HashMap<Player, String> jogador30;

	static {
		PlayerAPI.Participando = new ArrayList<Player>();
		PlayerAPI.Batalhando = new ArrayList<Player>();
		PlayerAPI.Esperando = new ArrayList<Player>();
		PlayerAPI.NaoComandos = new ArrayList<Player>();
		PlayerAPI.Ganhador = new HashMap<Player, String>();
		PlayerAPI.Batalhando1 = new HashMap<Player, String>();
		PlayerAPI.Batalhando2 = new HashMap<Player, String>();
		PlayerAPI.jogador1 = new HashMap<Player, String>();
		PlayerAPI.jogador2 = new HashMap<Player, String>();
		PlayerAPI.jogador3 = new HashMap<Player, String>();
		PlayerAPI.jogador4 = new HashMap<Player, String>();
		PlayerAPI.jogador5 = new HashMap<Player, String>();
		PlayerAPI.jogador6 = new HashMap<Player, String>();
		PlayerAPI.jogador7 = new HashMap<Player, String>();
		PlayerAPI.jogador8 = new HashMap<Player, String>();
		PlayerAPI.jogador9 = new HashMap<Player, String>();
		PlayerAPI.jogador10 = new HashMap<Player, String>();
		PlayerAPI.jogador11 = new HashMap<Player, String>();
		PlayerAPI.jogador12 = new HashMap<Player, String>();
		PlayerAPI.jogador13 = new HashMap<Player, String>();
		PlayerAPI.jogador14 = new HashMap<Player, String>();
		PlayerAPI.jogador15 = new HashMap<Player, String>();
		PlayerAPI.jogador16 = new HashMap<Player, String>();
		PlayerAPI.jogador17 = new HashMap<Player, String>();
		PlayerAPI.jogador18 = new HashMap<Player, String>();
		PlayerAPI.jogador19 = new HashMap<Player, String>();
		PlayerAPI.jogador20 = new HashMap<Player, String>();
		PlayerAPI.jogador21 = new HashMap<Player, String>();
		PlayerAPI.jogador22 = new HashMap<Player, String>();
		PlayerAPI.jogador23 = new HashMap<Player, String>();
		PlayerAPI.jogador24 = new HashMap<Player, String>();
		PlayerAPI.jogador25 = new HashMap<Player, String>();
		PlayerAPI.jogador26 = new HashMap<Player, String>();
		PlayerAPI.jogador27 = new HashMap<Player, String>();
		PlayerAPI.jogador28 = new HashMap<Player, String>();
		PlayerAPI.jogador29 = new HashMap<Player, String>();
		PlayerAPI.jogador30 = new HashMap<Player, String>();
	}

	private static ItemStack CriarItem(final Player player, final Material material, final int quantia, final short cor,
			final String[] lore, final String nome, final int slot, final int slotitem) {
		final ItemStack item = new ItemStack(material, quantia, cor);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		itemmeta.setLore(Arrays.asList(lore));
		item.setItemMeta(itemmeta);
		player.getInventory().setItem(slot, item);
		player.getInventory().setHeldItemSlot(slotitem);
		return item;
	}

	public static void LimparPlayers() {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player Jogadores = onlinePlayers[i];
			PlayerAPI.Ganhador.remove(Jogadores);
			PlayerAPI.Batalhando.remove(Jogadores);
			PlayerAPI.Batalhando1.remove(Jogadores);
			PlayerAPI.Batalhando2.remove(Jogadores);
			PlayerAPI.Esperando.remove(Jogadores);
			PlayerAPI.Participando.remove(Jogadores);
			PlayerAPI.jogador1.remove(Jogadores);
			PlayerAPI.jogador2.remove(Jogadores);
			PlayerAPI.jogador3.remove(Jogadores);
			PlayerAPI.jogador4.remove(Jogadores);
			PlayerAPI.jogador5.remove(Jogadores);
			PlayerAPI.jogador6.remove(Jogadores);
			PlayerAPI.jogador7.remove(Jogadores);
			PlayerAPI.jogador8.remove(Jogadores);
			PlayerAPI.jogador9.remove(Jogadores);
			PlayerAPI.jogador10.remove(Jogadores);
			PlayerAPI.jogador11.remove(Jogadores);
			PlayerAPI.jogador12.remove(Jogadores);
			PlayerAPI.jogador13.remove(Jogadores);
			PlayerAPI.jogador14.remove(Jogadores);
			PlayerAPI.jogador15.remove(Jogadores);
			PlayerAPI.jogador16.remove(Jogadores);
			PlayerAPI.jogador17.remove(Jogadores);
			PlayerAPI.jogador18.remove(Jogadores);
			PlayerAPI.jogador19.remove(Jogadores);
			PlayerAPI.jogador20.remove(Jogadores);
			PlayerAPI.jogador21.remove(Jogadores);
			PlayerAPI.jogador22.remove(Jogadores);
			PlayerAPI.jogador23.remove(Jogadores);
			PlayerAPI.jogador24.remove(Jogadores);
			PlayerAPI.jogador25.remove(Jogadores);
			PlayerAPI.jogador26.remove(Jogadores);
			PlayerAPI.jogador27.remove(Jogadores);
			PlayerAPI.jogador28.remove(Jogadores);
			PlayerAPI.jogador29.remove(Jogadores);
			PlayerAPI.jogador30.remove(Jogadores);
		}
		PlayerAPI.RDM1 = false;
		PlayerAPI.RDM2 = false;
		PlayerAPI.RDM3 = false;
		PlayerAPI.RDM4 = false;
		PlayerAPI.RDM5 = false;
		PlayerAPI.RDM6 = false;
		PlayerAPI.RDM7 = false;
		PlayerAPI.RDM8 = false;
		PlayerAPI.RDM10 = false;
		PlayerAPI.RDM11 = false;
		PlayerAPI.RDM12 = false;
		PlayerAPI.RDM13 = false;
		PlayerAPI.RDM14 = false;
		PlayerAPI.RDM15 = false;
		PlayerAPI.RDM16 = false;
		PlayerAPI.RDM17 = false;
		PlayerAPI.RDM18 = false;
		PlayerAPI.RDM19 = false;
		PlayerAPI.RDM20 = false;
		PlayerAPI.RDM21 = false;
		PlayerAPI.RDM22 = false;
		PlayerAPI.RDM23 = false;
		PlayerAPI.RDM24 = false;
		PlayerAPI.RDM25 = false;
		PlayerAPI.RDM26 = false;
		PlayerAPI.RDM27 = false;
		PlayerAPI.RDM28 = false;
		PlayerAPI.RDM29 = false;
		PlayerAPI.RDM30 = false;
	}

	public static void LimparPlayer(final Player Jogador) {
		PlayerAPI.Ganhador.remove(Jogador);
		PlayerAPI.Batalhando.remove(Jogador);
		PlayerAPI.Batalhando1.remove(Jogador);
		PlayerAPI.Batalhando2.remove(Jogador);
		PlayerAPI.Esperando.remove(Jogador);
		PlayerAPI.Participando.remove(Jogador);
		PlayerAPI.jogador1.remove(Jogador);
		PlayerAPI.jogador2.remove(Jogador);
		PlayerAPI.jogador3.remove(Jogador);
		PlayerAPI.jogador4.remove(Jogador);
		PlayerAPI.jogador5.remove(Jogador);
		PlayerAPI.jogador6.remove(Jogador);
		PlayerAPI.jogador7.remove(Jogador);
		PlayerAPI.jogador8.remove(Jogador);
		PlayerAPI.jogador9.remove(Jogador);
		PlayerAPI.jogador10.remove(Jogador);
		PlayerAPI.jogador11.remove(Jogador);
		PlayerAPI.jogador12.remove(Jogador);
		PlayerAPI.jogador13.remove(Jogador);
		PlayerAPI.jogador14.remove(Jogador);
		PlayerAPI.jogador15.remove(Jogador);
		PlayerAPI.jogador16.remove(Jogador);
		PlayerAPI.jogador17.remove(Jogador);
		PlayerAPI.jogador18.remove(Jogador);
		PlayerAPI.jogador19.remove(Jogador);
		PlayerAPI.jogador20.remove(Jogador);
		PlayerAPI.jogador21.remove(Jogador);
		PlayerAPI.jogador22.remove(Jogador);
		PlayerAPI.jogador23.remove(Jogador);
		PlayerAPI.jogador24.remove(Jogador);
		PlayerAPI.jogador25.remove(Jogador);
		PlayerAPI.jogador26.remove(Jogador);
		PlayerAPI.jogador27.remove(Jogador);
		PlayerAPI.jogador28.remove(Jogador);
		PlayerAPI.jogador29.remove(Jogador);
		PlayerAPI.jogador30.remove(Jogador);
		PlayerAPI.RDM1 = false;
		PlayerAPI.RDM2 = false;
		PlayerAPI.RDM3 = false;
		PlayerAPI.RDM4 = false;
		PlayerAPI.RDM5 = false;
		PlayerAPI.RDM6 = false;
		PlayerAPI.RDM7 = false;
		PlayerAPI.RDM8 = false;
		PlayerAPI.RDM10 = false;
		PlayerAPI.RDM11 = false;
		PlayerAPI.RDM12 = false;
		PlayerAPI.RDM13 = false;
		PlayerAPI.RDM14 = false;
		PlayerAPI.RDM15 = false;
		PlayerAPI.RDM16 = false;
		PlayerAPI.RDM17 = false;
		PlayerAPI.RDM18 = false;
		PlayerAPI.RDM19 = false;
		PlayerAPI.RDM20 = false;
		PlayerAPI.RDM21 = false;
		PlayerAPI.RDM22 = false;
		PlayerAPI.RDM23 = false;
		PlayerAPI.RDM24 = false;
		PlayerAPI.RDM25 = false;
		PlayerAPI.RDM26 = false;
		PlayerAPI.RDM27 = false;
		PlayerAPI.RDM28 = false;
		PlayerAPI.RDM29 = false;
		PlayerAPI.RDM30 = false;
	}

	public static void SelecionarPrimeirosJogadores(final Player Jogador) {
		if (CookiePvP.Evento == Estado.INICIANDO || CookiePvP.Evento == Estado.FECHADO) {
			return;
		}
		if (PlayerAPI.RDM1) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
			if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM2) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM3) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM4) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM5) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM6) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM7) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM8) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM9) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM10) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM11) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM12) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM13) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM14) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM15) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM16) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM17) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM18) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM19) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM20) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM21) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM22) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM23) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM24) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM25) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM26) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM27) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM28) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM29) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM30) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		} else if (PlayerAPI.RDM30) {
			final Player Selecionado = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
			if (PlayerAPI.RDM1) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM2) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM3) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM4) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM5) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM6) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM7) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM8) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM9) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM10) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM11) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM12) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM13) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM14) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM15) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM16) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM17) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM18) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM19) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM20) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM21) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM22) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM23) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM24) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM25) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM26) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM27) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM28) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			} else if (PlayerAPI.RDM29) {
				final Player Selecionado2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
	}

	public static void IrParaPrimeiraBatalha(final Player Jogador1, final Player Jogador2) {
		if (CookiePvP.Evento == Estado.INICIANDO || CookiePvP.Evento == Estado.FECHADO) {
			return;
		}
		Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY
				+ "Escolhendo Primeiro Jogador!");
		new BukkitRunnable() {
			public void run() {
				Jogador1.sendMessage(
						ChatColor.GREEN + "�7Voc\u00ea \u00e9 o �e�lPRIMEIRO �7jogador do evento �a�lREI DA MESA");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY
						+ "Primeiro Jogador: " + ChatColor.RED + Jogador1.getName() + ChatColor.GRAY + "!");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY
						+ "Escolhendo Segundo Jogador!");
				EventoAPI.TeleportarWarp(Jogador1, "Loc1");
				PlayerAPI.Batalhando1.put(Jogador1, Jogador1.getName());
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player Jogadores = onlinePlayers[i];
					PlayerAPI.Batalhando1.put(Jogadores, Jogador1.getName());
				}
				PlayerAPI.RemoverSoBoolean(Jogador1);
				PlayerAPI.Batalhando.add(Jogador1);
				Proteção.setImortal(Jogador1, false);
				for (final PotionEffect Efeito : Jogador1.getActivePotionEffects()) {
					Jogador1.removePotionEffect(Efeito.getType());
				}
				Jogador1.setMaxHealth(20);
				Jogador1.setHealth(20.0);
				Jogador1.setFoodLevel(20);
				Jogador1.setFlySpeed(0.1f);
				Jogador1.setAllowFlight(false);
				Jogador1.setWalkSpeed(0.2f);
				Jogador1.getInventory().clear();
				Jogador1.setGameMode(GameMode.SURVIVAL);
				Jogador1.getInventory().setBoots((ItemStack) null);
				Jogador1.getInventory().setChestplate((ItemStack) null);
				Jogador1.getInventory().setHelmet((ItemStack) null);
				Jogador1.getInventory().setLeggings((ItemStack) null);
				PlayerAPI.Esperando.add(Jogador1);
				new BukkitRunnable() {
					public void run() {
						Jogador1.sendMessage(ChatColor.GREEN
								+ "�7Voc\u00ea \u00e9 o �6�lSEGUNDO �7jogador do evento �a�lREI DA MESA");
						Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY
								+ "Segundo Jogador: " + ChatColor.RED + Jogador2.getName() + ChatColor.GRAY + "!");
						Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: "
								+ ChatColor.YELLOW + Jogador1.getName() + ChatColor.GRAY + " vs " + ChatColor.YELLOW
								+ Jogador2.getName() + ChatColor.GRAY + "!");
						EventoAPI.TeleportarWarp(Jogador2, "Loc2");
						PlayerAPI.Batalhando2.put(Jogador2, Jogador2.getName());
						Player[] onlinePlayers;
						for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
							final Player Jogadores = onlinePlayers[i];
							PlayerAPI.Batalhando2.put(Jogadores, Jogador2.getName());
						}
						PlayerAPI.RemoverSoBoolean(Jogador2);
						PlayerAPI.Batalhando.add(Jogador2);
						Proteção.setImortal(Jogador2, false);
						for (final PotionEffect Efeito : Jogador2.getActivePotionEffects()) {
							Jogador2.removePotionEffect(Efeito.getType());
						}
						Jogador2.setMaxHealth(20);
						Jogador2.setHealth(20.0);
						Jogador2.setFoodLevel(20);
						Jogador2.setFlySpeed(0.1f);
						Jogador2.setAllowFlight(false);
						Jogador2.setWalkSpeed(0.2f);
						Jogador2.getInventory().clear();
						Jogador2.setGameMode(GameMode.SURVIVAL);
						Jogador2.getInventory().setBoots((ItemStack) null);
						Jogador2.getInventory().setChestplate((ItemStack) null);
						Jogador2.getInventory().setHelmet((ItemStack) null);
						Jogador2.getInventory().setLeggings((ItemStack) null);
						PlayerAPI.Esperando.add(Jogador2);
						new BukkitRunnable() {
							public void run() {
								Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: "
										+ ChatColor.GRAY + "Valendo!");
								PlayerAPI.Esperando.remove(Jogador1);
								PlayerAPI.Esperando.remove(Jogador2);
								for (int slot = 0; slot < Jogador1.getInventory().getSize(); ++slot) {
									CriarItem(Jogador1, Material.MUSHROOM_SOUP, 1, (short) 0, new String[0],
											ChatColor.GOLD + "Sopa", slot, 0);
								}
								for (int slot = 0; slot < Jogador2.getInventory().getSize(); ++slot) {
									CriarItem(Jogador2, Material.MUSHROOM_SOUP, 1, (short) 0, new String[0],
											ChatColor.GOLD + "Sopa", slot, 0);
								}
								CriarItem(Jogador1, Material.STONE_SWORD, 1, (short) 0, new String[0],
										ChatColor.RED + "Rei da Mesa", 0, 0);
								CriarItem(Jogador2, Material.STONE_SWORD, 1, (short) 0, new String[0],
										ChatColor.RED + "Rei da Mesa", 0, 0);
							}
						}.runTaskLater(CookiePvP.getPlugin(), 20L);
					}
				}.runTaskLaterAsynchronously(CookiePvP.getPlugin(), 20L);
			}
		}.runTaskLater(CookiePvP.getPlugin(), 20L);
	}

	public static void IrParaProximaBatalha(final Player Jogador) {
		if (CookiePvP.Evento == Estado.INICIANDO || CookiePvP.Evento == Estado.FECHADO) {
			return;
		}
		final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.Ganhador.get(Jogador));
		Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY
				+ "�aEscolhendo o pr\u00f3ximo jogador" + ChatColor.GRAY + "�a...");
		EventoAPI.TeleportarWarp(Jogador2, "Loc1");
		PlayerAPI.Batalhando1.put(Jogador2, Jogador2.getName());
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player Jogadores = onlinePlayers[i];
			PlayerAPI.Batalhando1.put(Jogadores, Jogador2.getName());
		}
		RemoverSoBoolean(Jogador2);
		Proteção.setImortal(Jogador2, false);
		Proteção.setImortal(Jogador, false);
		for (final PotionEffect Efeito : Jogador2.getActivePotionEffects()) {
			Jogador2.removePotionEffect(Efeito.getType());
		}
		Jogador2.setMaxHealth(20);
		Jogador2.setHealth(20.0);
		Jogador2.setFoodLevel(20);
		Jogador2.setFlySpeed(0.1f);
		Jogador2.setAllowFlight(false);
		Jogador2.setWalkSpeed(0.2f);
		Jogador2.getInventory().clear();
		Jogador2.setGameMode(GameMode.SURVIVAL);
		Jogador2.getInventory().setBoots((ItemStack) null);
		Jogador2.getInventory().setChestplate((ItemStack) null);
		Jogador2.getInventory().setHelmet((ItemStack) null);
		Jogador2.getInventory().setLeggings((ItemStack) null);
		PlayerAPI.Esperando.add(Jogador2);
		new BukkitRunnable() {
			public void run() {
				Jogador.sendMessage(ChatColor.GREEN + "�aVoc\u00ea \u00e9 o pr\u00f3ximo jogador da RDM!");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY
						+ "Pr\u00f3ximo Jogador: " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + "!");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.YELLOW
						+ Jogador2.getName() + ChatColor.GRAY + " vs " + ChatColor.YELLOW + Jogador.getName()
						+ ChatColor.GRAY + "!");
				EventoAPI.TeleportarWarp(Jogador, "Loc2");
				PlayerAPI.Batalhando2.put(Jogador, Jogador.getName());
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player Jogadores = onlinePlayers[i];
					PlayerAPI.Batalhando2.put(Jogadores, Jogador.getName());
				}
				PlayerAPI.RemoverSoBoolean(Jogador);
				Proteção.setImortal(Jogador, false);
				for (final PotionEffect Efeito : Jogador.getActivePotionEffects()) {
					Jogador.removePotionEffect(Efeito.getType());
				}
				Jogador.setMaxHealth(20);
				Jogador.setHealth(20.0);
				Jogador.setFoodLevel(20);
				Jogador.setFlySpeed(0.1f);
				Jogador.setAllowFlight(false);
				Jogador.setWalkSpeed(0.2f);
				Jogador.getInventory().clear();
				Jogador.setGameMode(GameMode.SURVIVAL);
				Jogador.getInventory().setBoots((ItemStack) null);
				Jogador.getInventory().setChestplate((ItemStack) null);
				Jogador.getInventory().setHelmet((ItemStack) null);
				Jogador.getInventory().setLeggings((ItemStack) null);
				PlayerAPI.Esperando.add(Jogador);
				new BukkitRunnable() {
					public void run() {
						Tempo.mandarBroadcast(
								ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "Valendo!");
						PlayerAPI.Esperando.remove(Jogador2);
						PlayerAPI.Esperando.remove(Jogador);
						PlayerAPI.Batalhando.add(Jogador2);
						PlayerAPI.Batalhando.add(Jogador);
						for (int slot = 0; slot < Jogador2.getInventory().getSize(); ++slot) {
							CriarItem(Jogador2, Material.MUSHROOM_SOUP, 1, (short) 0, new String[0],
									ChatColor.GOLD + "Sopa", slot, 0);
						}
						for (int slot = 0; slot < Jogador.getInventory().getSize(); ++slot) {
							CriarItem(Jogador, Material.MUSHROOM_SOUP, 1, (short) 0, new String[0],
									ChatColor.GOLD + "Sopa", slot, 0);
						}
						CriarItem(Jogador2, Material.STONE_SWORD, 1, (short) 0, new String[0],
								ChatColor.RED + "Rei da Mesa", 0, 0);
						CriarItem(Jogador, Material.STONE_SWORD, 1, (short) 0, new String[0],
								ChatColor.RED + "Rei da Mesa", 0, 0);
					}
				}.runTaskLater(CookiePvP.getPlugin(), 20L);
			}
		}.runTaskLaterAsynchronously(CookiePvP.getPlugin(), 20L);
	}

	public static void AdicionarRDM(final Player Jogador) {
		if (CookiePvP.Evento == Estado.ANDAMENTO || CookiePvP.Evento == Estado.FECHADO) {
			return;
		}
		if (!PlayerAPI.RDM1) {
			PlayerAPI.RDM1 = true;
			Player[] onlinePlayers;
			for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
				final Player Jogadores = onlinePlayers[i];
				PlayerAPI.jogador1.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM2) {
			PlayerAPI.RDM2 = true;
			Player[] onlinePlayers2;
			for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
				final Player Jogadores = onlinePlayers2[j];
				PlayerAPI.jogador2.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM3) {
			PlayerAPI.RDM3 = true;
			Player[] onlinePlayers3;
			for (int length3 = (onlinePlayers3 = Bukkit.getOnlinePlayers()).length, k = 0; k < length3; ++k) {
				final Player Jogadores = onlinePlayers3[k];
				PlayerAPI.jogador3.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM4) {
			PlayerAPI.RDM4 = true;
			Player[] onlinePlayers4;
			for (int length4 = (onlinePlayers4 = Bukkit.getOnlinePlayers()).length, l = 0; l < length4; ++l) {
				final Player Jogadores = onlinePlayers4[l];
				PlayerAPI.jogador4.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM5) {
			PlayerAPI.RDM5 = true;
			Player[] onlinePlayers5;
			for (int length5 = (onlinePlayers5 = Bukkit.getOnlinePlayers()).length, n = 0; n < length5; ++n) {
				final Player Jogadores = onlinePlayers5[n];
				PlayerAPI.jogador5.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM6) {
			PlayerAPI.RDM6 = true;
			Player[] onlinePlayers6;
			for (int length6 = (onlinePlayers6 = Bukkit.getOnlinePlayers()).length, n2 = 0; n2 < length6; ++n2) {
				final Player Jogadores = onlinePlayers6[n2];
				PlayerAPI.jogador6.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM7) {
			PlayerAPI.RDM7 = true;
			Player[] onlinePlayers7;
			for (int length7 = (onlinePlayers7 = Bukkit.getOnlinePlayers()).length, n3 = 0; n3 < length7; ++n3) {
				final Player Jogadores = onlinePlayers7[n3];
				PlayerAPI.jogador7.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM8) {
			PlayerAPI.RDM8 = true;
			Player[] onlinePlayers8;
			for (int length8 = (onlinePlayers8 = Bukkit.getOnlinePlayers()).length, n4 = 0; n4 < length8; ++n4) {
				final Player Jogadores = onlinePlayers8[n4];
				PlayerAPI.jogador8.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM9) {
			PlayerAPI.RDM9 = true;
			Player[] onlinePlayers9;
			for (int length9 = (onlinePlayers9 = Bukkit.getOnlinePlayers()).length, n5 = 0; n5 < length9; ++n5) {
				final Player Jogadores = onlinePlayers9[n5];
				PlayerAPI.jogador9.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM10) {
			PlayerAPI.RDM10 = true;
			Player[] onlinePlayers10;
			for (int length10 = (onlinePlayers10 = Bukkit.getOnlinePlayers()).length, n6 = 0; n6 < length10; ++n6) {
				final Player Jogadores = onlinePlayers10[n6];
				PlayerAPI.jogador10.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM11) {
			PlayerAPI.RDM11 = true;
			Player[] onlinePlayers11;
			for (int length11 = (onlinePlayers11 = Bukkit.getOnlinePlayers()).length, n7 = 0; n7 < length11; ++n7) {
				final Player Jogadores = onlinePlayers11[n7];
				PlayerAPI.jogador11.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM12) {
			PlayerAPI.RDM12 = true;
			Player[] onlinePlayers12;
			for (int length12 = (onlinePlayers12 = Bukkit.getOnlinePlayers()).length, n8 = 0; n8 < length12; ++n8) {
				final Player Jogadores = onlinePlayers12[n8];
				PlayerAPI.jogador12.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM13) {
			PlayerAPI.RDM13 = true;
			Player[] onlinePlayers13;
			for (int length13 = (onlinePlayers13 = Bukkit.getOnlinePlayers()).length, n9 = 0; n9 < length13; ++n9) {
				final Player Jogadores = onlinePlayers13[n9];
				PlayerAPI.jogador13.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM14) {
			PlayerAPI.RDM14 = true;
			Player[] onlinePlayers14;
			for (int length14 = (onlinePlayers14 = Bukkit.getOnlinePlayers()).length, n10 = 0; n10 < length14; ++n10) {
				final Player Jogadores = onlinePlayers14[n10];
				PlayerAPI.jogador14.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM15) {
			PlayerAPI.RDM15 = true;
			Player[] onlinePlayers15;
			for (int length15 = (onlinePlayers15 = Bukkit.getOnlinePlayers()).length, n11 = 0; n11 < length15; ++n11) {
				final Player Jogadores = onlinePlayers15[n11];
				PlayerAPI.jogador15.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM16) {
			PlayerAPI.RDM16 = true;
			Player[] onlinePlayers16;
			for (int length16 = (onlinePlayers16 = Bukkit.getOnlinePlayers()).length, n12 = 0; n12 < length16; ++n12) {
				final Player Jogadores = onlinePlayers16[n12];
				PlayerAPI.jogador16.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM17) {
			PlayerAPI.RDM17 = true;
			Player[] onlinePlayers17;
			for (int length17 = (onlinePlayers17 = Bukkit.getOnlinePlayers()).length, n13 = 0; n13 < length17; ++n13) {
				final Player Jogadores = onlinePlayers17[n13];
				PlayerAPI.jogador17.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM18) {
			PlayerAPI.RDM18 = true;
			Player[] onlinePlayers18;
			for (int length18 = (onlinePlayers18 = Bukkit.getOnlinePlayers()).length, n14 = 0; n14 < length18; ++n14) {
				final Player Jogadores = onlinePlayers18[n14];
				PlayerAPI.jogador18.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM19) {
			PlayerAPI.RDM19 = true;
			Player[] onlinePlayers19;
			for (int length19 = (onlinePlayers19 = Bukkit.getOnlinePlayers()).length, n15 = 0; n15 < length19; ++n15) {
				final Player Jogadores = onlinePlayers19[n15];
				PlayerAPI.jogador19.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM20) {
			PlayerAPI.RDM20 = true;
			Player[] onlinePlayers20;
			for (int length20 = (onlinePlayers20 = Bukkit.getOnlinePlayers()).length, n16 = 0; n16 < length20; ++n16) {
				final Player Jogadores = onlinePlayers20[n16];
				PlayerAPI.jogador20.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM21) {
			PlayerAPI.RDM21 = true;
			Player[] onlinePlayers21;
			for (int length21 = (onlinePlayers21 = Bukkit.getOnlinePlayers()).length, n17 = 0; n17 < length21; ++n17) {
				final Player Jogadores = onlinePlayers21[n17];
				PlayerAPI.jogador21.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM22) {
			PlayerAPI.RDM22 = true;
			Player[] onlinePlayers22;
			for (int length22 = (onlinePlayers22 = Bukkit.getOnlinePlayers()).length, n18 = 0; n18 < length22; ++n18) {
				final Player Jogadores = onlinePlayers22[n18];
				PlayerAPI.jogador22.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM23) {
			PlayerAPI.RDM23 = true;
			Player[] onlinePlayers23;
			for (int length23 = (onlinePlayers23 = Bukkit.getOnlinePlayers()).length, n19 = 0; n19 < length23; ++n19) {
				final Player Jogadores = onlinePlayers23[n19];
				PlayerAPI.jogador23.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM24) {
			PlayerAPI.RDM24 = true;
			Player[] onlinePlayers24;
			for (int length24 = (onlinePlayers24 = Bukkit.getOnlinePlayers()).length, n20 = 0; n20 < length24; ++n20) {
				final Player Jogadores = onlinePlayers24[n20];
				PlayerAPI.jogador24.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM25) {
			PlayerAPI.RDM25 = true;
			Player[] onlinePlayers25;
			for (int length25 = (onlinePlayers25 = Bukkit.getOnlinePlayers()).length, n21 = 0; n21 < length25; ++n21) {
				final Player Jogadores = onlinePlayers25[n21];
				PlayerAPI.jogador25.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM26) {
			PlayerAPI.RDM26 = true;
			Player[] onlinePlayers26;
			for (int length26 = (onlinePlayers26 = Bukkit.getOnlinePlayers()).length, n22 = 0; n22 < length26; ++n22) {
				final Player Jogadores = onlinePlayers26[n22];
				PlayerAPI.jogador26.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM27) {
			PlayerAPI.RDM27 = true;
			Player[] onlinePlayers27;
			for (int length27 = (onlinePlayers27 = Bukkit.getOnlinePlayers()).length, n23 = 0; n23 < length27; ++n23) {
				final Player Jogadores = onlinePlayers27[n23];
				PlayerAPI.jogador27.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM28) {
			PlayerAPI.RDM28 = true;
			Player[] onlinePlayers28;
			for (int length28 = (onlinePlayers28 = Bukkit.getOnlinePlayers()).length, n24 = 0; n24 < length28; ++n24) {
				final Player Jogadores = onlinePlayers28[n24];
				PlayerAPI.jogador28.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM29) {
			PlayerAPI.RDM29 = true;
			Player[] onlinePlayers29;
			for (int length29 = (onlinePlayers29 = Bukkit.getOnlinePlayers()).length, n25 = 0; n25 < length29; ++n25) {
				final Player Jogadores = onlinePlayers29[n25];
				PlayerAPI.jogador29.put(Jogadores, Jogador.getName());
			}
		} else if (!PlayerAPI.RDM30) {
			PlayerAPI.RDM30 = true;
			Player[] onlinePlayers30;
			for (int length30 = (onlinePlayers30 = Bukkit.getOnlinePlayers()).length, n26 = 0; n26 < length30; ++n26) {
				final Player Jogadores = onlinePlayers30[n26];
				PlayerAPI.jogador30.put(Jogadores, Jogador.getName());
			}
		}
	}

	public static void AdicionarRDMCheio(final Player Jogador) {
		if (CookiePvP.Evento == Estado.ANDAMENTO || CookiePvP.Evento == Estado.FECHADO) {
			return;
		}
		if (PlayerAPI.RDM1) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM1 = true;
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player Jogadores = onlinePlayers[i];
					PlayerAPI.jogador1.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM2) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM2 = true;
				Player[] onlinePlayers2;
				for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
					final Player Jogadores = onlinePlayers2[j];
					PlayerAPI.jogador2.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} else if (PlayerAPI.RDM3) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM3 = true;
				Player[] onlinePlayers3;
				for (int length3 = (onlinePlayers3 = Bukkit.getOnlinePlayers()).length, k = 0; k < length3; ++k) {
					final Player Jogadores = onlinePlayers3[k];
					PlayerAPI.jogador3.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM4) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM4 = true;
				Player[] onlinePlayers4;
				for (int length4 = (onlinePlayers4 = Bukkit.getOnlinePlayers()).length, l = 0; l < length4; ++l) {
					final Player Jogadores = onlinePlayers4[l];
					PlayerAPI.jogador4.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM5) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM5 = true;
				Player[] onlinePlayers5;
				for (int length5 = (onlinePlayers5 = Bukkit.getOnlinePlayers()).length, n = 0; n < length5; ++n) {
					final Player Jogadores = onlinePlayers5[n];
					PlayerAPI.jogador5.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM6) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM6 = true;
				Player[] onlinePlayers6;
				for (int length6 = (onlinePlayers6 = Bukkit.getOnlinePlayers()).length, n2 = 0; n2 < length6; ++n2) {
					final Player Jogadores = onlinePlayers6[n2];
					PlayerAPI.jogador6.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM7) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "�c�l(!) �cVoc\u00ea foi expulso do evento!");
				Expulso.sendMessage(ChatColor.RED + "�c�l(!) �cMotivo: " + ChatColor.WHITE
						+ "Um jogador com algum grupo VIP ocupou a sua vaga e infelizmente voc\u00ea teve que ser retirado!");
				Jogador.sendMessage(ChatColor.GREEN + "�aTeleporte foi conclu\u00eddo com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "�7Voc\u00ea expulsou o jogador �c�l" + ChatColor.WHITE
						+ Expulso.getName() + ChatColor.GREEN + " �7do evento e obteve a vaga dele.");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + " " + ChatColor.GRAY
						+ "O jogador �6�l" + ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ " �7entrou no evento! " + ChatColor.WHITE + "�e�l(" + PlayerAPI.Participando.size()
						+ "�e�l/30)" + ChatColor.GRAY + "�7!");
				PlayerAPI.RDM7 = true;
				Player[] onlinePlayers7;
				for (int length7 = (onlinePlayers7 = Bukkit.getOnlinePlayers()).length, n3 = 0; n3 < length7; ++n3) {
					final Player Jogadores = onlinePlayers7[n3];
					PlayerAPI.jogador7.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM8) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM8 = true;
				Player[] onlinePlayers8;
				for (int length8 = (onlinePlayers8 = Bukkit.getOnlinePlayers()).length, n4 = 0; n4 < length8; ++n4) {
					final Player Jogadores = onlinePlayers8[n4];
					PlayerAPI.jogador8.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM9) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM9 = true;
				Player[] onlinePlayers9;
				for (int length9 = (onlinePlayers9 = Bukkit.getOnlinePlayers()).length, n5 = 0; n5 < length9; ++n5) {
					final Player Jogadores = onlinePlayers9[n5];
					PlayerAPI.jogador9.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM10) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM10 = true;
				Player[] onlinePlayers10;
				for (int length10 = (onlinePlayers10 = Bukkit.getOnlinePlayers()).length, n6 = 0; n6 < length10; ++n6) {
					final Player Jogadores = onlinePlayers10[n6];
					PlayerAPI.jogador10.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM11) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM11 = true;
				Player[] onlinePlayers11;
				for (int length11 = (onlinePlayers11 = Bukkit.getOnlinePlayers()).length, n7 = 0; n7 < length11; ++n7) {
					final Player Jogadores = onlinePlayers11[n7];
					PlayerAPI.jogador11.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM12) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM12 = true;
				Player[] onlinePlayers12;
				for (int length12 = (onlinePlayers12 = Bukkit.getOnlinePlayers()).length, n8 = 0; n8 < length12; ++n8) {
					final Player Jogadores = onlinePlayers12[n8];
					PlayerAPI.jogador12.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM13) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM13 = true;
				Player[] onlinePlayers13;
				for (int length13 = (onlinePlayers13 = Bukkit.getOnlinePlayers()).length, n9 = 0; n9 < length13; ++n9) {
					final Player Jogadores = onlinePlayers13[n9];
					PlayerAPI.jogador13.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM14) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM14 = true;
				Player[] onlinePlayers14;
				for (int length14 = (onlinePlayers14 = Bukkit.getOnlinePlayers()).length,
						n10 = 0; n10 < length14; ++n10) {
					final Player Jogadores = onlinePlayers14[n10];
					PlayerAPI.jogador14.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM15) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM15 = true;
				Player[] onlinePlayers15;
				for (int length15 = (onlinePlayers15 = Bukkit.getOnlinePlayers()).length,
						n11 = 0; n11 < length15; ++n11) {
					final Player Jogadores = onlinePlayers15[n11];
					PlayerAPI.jogador15.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM16) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM16 = true;
				Player[] onlinePlayers16;
				for (int length16 = (onlinePlayers16 = Bukkit.getOnlinePlayers()).length,
						n12 = 0; n12 < length16; ++n12) {
					final Player Jogadores = onlinePlayers16[n12];
					PlayerAPI.jogador16.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM17) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM17 = true;
				Player[] onlinePlayers17;
				for (int length17 = (onlinePlayers17 = Bukkit.getOnlinePlayers()).length,
						n13 = 0; n13 < length17; ++n13) {
					final Player Jogadores = onlinePlayers17[n13];
					PlayerAPI.jogador17.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM18) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM18 = true;
				Player[] onlinePlayers18;
				for (int length18 = (onlinePlayers18 = Bukkit.getOnlinePlayers()).length,
						n14 = 0; n14 < length18; ++n14) {
					final Player Jogadores = onlinePlayers18[n14];
					PlayerAPI.jogador18.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM19) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM19 = true;
				Player[] onlinePlayers19;
				for (int length19 = (onlinePlayers19 = Bukkit.getOnlinePlayers()).length,
						n15 = 0; n15 < length19; ++n15) {
					final Player Jogadores = onlinePlayers19[n15];
					PlayerAPI.jogador19.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM20) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM20 = true;
				Player[] onlinePlayers20;
				for (int length20 = (onlinePlayers20 = Bukkit.getOnlinePlayers()).length,
						n16 = 0; n16 < length20; ++n16) {
					final Player Jogadores = onlinePlayers20[n16];
					PlayerAPI.jogador20.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM21) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM21 = true;
				Player[] onlinePlayers21;
				for (int length21 = (onlinePlayers21 = Bukkit.getOnlinePlayers()).length,
						n17 = 0; n17 < length21; ++n17) {
					final Player Jogadores = onlinePlayers21[n17];
					PlayerAPI.jogador21.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM22) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM22 = true;
				Player[] onlinePlayers22;
				for (int length22 = (onlinePlayers22 = Bukkit.getOnlinePlayers()).length,
						n18 = 0; n18 < length22; ++n18) {
					final Player Jogadores = onlinePlayers22[n18];
					PlayerAPI.jogador22.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM23) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM23 = true;
				Player[] onlinePlayers23;
				for (int length23 = (onlinePlayers23 = Bukkit.getOnlinePlayers()).length,
						n19 = 0; n19 < length23; ++n19) {
					final Player Jogadores = onlinePlayers23[n19];
					PlayerAPI.jogador23.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM24) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM24 = true;
				Player[] onlinePlayers24;
				for (int length24 = (onlinePlayers24 = Bukkit.getOnlinePlayers()).length,
						n20 = 0; n20 < length24; ++n20) {
					final Player Jogadores = onlinePlayers24[n20];
					PlayerAPI.jogador24.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM25) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM25 = true;
				Player[] onlinePlayers25;
				for (int length25 = (onlinePlayers25 = Bukkit.getOnlinePlayers()).length,
						n21 = 0; n21 < length25; ++n21) {
					final Player Jogadores = onlinePlayers25[n21];
					PlayerAPI.jogador25.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM26) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM26 = true;
				Player[] onlinePlayers26;
				for (int length26 = (onlinePlayers26 = Bukkit.getOnlinePlayers()).length,
						n22 = 0; n22 < length26; ++n22) {
					final Player Jogadores = onlinePlayers26[n22];
					PlayerAPI.jogador26.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM27) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM27 = true;
				Player[] onlinePlayers27;
				for (int length27 = (onlinePlayers27 = Bukkit.getOnlinePlayers()).length,
						n23 = 0; n23 < length27; ++n23) {
					final Player Jogadores = onlinePlayers27[n23];
					PlayerAPI.jogador27.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM28) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM28 = true;
				Player[] onlinePlayers28;
				for (int length28 = (onlinePlayers28 = Bukkit.getOnlinePlayers()).length,
						n24 = 0; n24 < length28; ++n24) {
					final Player Jogadores = onlinePlayers28[n24];
					PlayerAPI.jogador28.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM29) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM29 = true;
				Player[] onlinePlayers29;
				for (int length29 = (onlinePlayers29 = Bukkit.getOnlinePlayers()).length,
						n25 = 0; n25 < length29; ++n25) {
					final Player Jogadores = onlinePlayers29[n25];
					PlayerAPI.jogador29.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM30) {
			final Player Expulso = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED
						+ " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE
						+ "O Evento estava cheio, como ele \u00e9 vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu voc\u00ea, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Voc\u00ea expulsou o " + ChatColor.WHITE + Expulso.getName()
						+ ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora voc\u00ea est\u00e1 participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY
						+ ", pelo motivo que ele \u00e9 vip e pode entrar no evento cheio expulsando algu\u00e9m aleat\u00f3rio.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O "
						+ ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE
						+ "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				PlayerAPI.RDM30 = true;
				Player[] onlinePlayers30;
				for (int length30 = (onlinePlayers30 = Bukkit.getOnlinePlayers()).length,
						n26 = 0; n26 < length30; ++n26) {
					final Player Jogadores = onlinePlayers30[n26];
					PlayerAPI.jogador30.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (PlayerAPI.RDM1 && PlayerAPI.RDM2 && PlayerAPI.RDM3 && PlayerAPI.RDM4 && PlayerAPI.RDM5 && PlayerAPI.RDM6
				&& PlayerAPI.RDM7 && PlayerAPI.RDM8 && PlayerAPI.RDM9 && PlayerAPI.RDM10 && PlayerAPI.RDM11
				&& PlayerAPI.RDM12 && PlayerAPI.RDM13 && PlayerAPI.RDM14 && PlayerAPI.RDM15 && PlayerAPI.RDM16
				&& PlayerAPI.RDM17 && PlayerAPI.RDM18 && PlayerAPI.RDM19 && PlayerAPI.RDM20 && PlayerAPI.RDM21
				&& PlayerAPI.RDM22 && PlayerAPI.RDM23 && PlayerAPI.RDM24 && PlayerAPI.RDM25 && PlayerAPI.RDM26
				&& PlayerAPI.RDM27 && PlayerAPI.RDM28 && PlayerAPI.RDM29 && PlayerAPI.RDM30) {
			Jogador.sendMessage(ChatColor.RED
					+ "Desculpe, todos os participantes do Evento são vips, e voc\u00ea não pode expusar eles.");
		}
	}

	public static void RemoverRDM(final Player Jogador) {
		if (CookiePvP.Evento == Estado.FECHADO) {
			return;
		}
		if (PlayerAPI.jogador1.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM1 = false;
			Player[] onlinePlayers;
			for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
				final Player Jogadores = onlinePlayers[i];
				PlayerAPI.jogador1.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador2.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM2 = false;
			Player[] onlinePlayers2;
			for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
				final Player Jogadores = onlinePlayers2[j];
				PlayerAPI.jogador2.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador3.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM3 = false;
			Player[] onlinePlayers3;
			for (int length3 = (onlinePlayers3 = Bukkit.getOnlinePlayers()).length, k = 0; k < length3; ++k) {
				final Player Jogadores = onlinePlayers3[k];
				PlayerAPI.jogador3.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador4.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM4 = false;
			Player[] onlinePlayers4;
			for (int length4 = (onlinePlayers4 = Bukkit.getOnlinePlayers()).length, l = 0; l < length4; ++l) {
				final Player Jogadores = onlinePlayers4[l];
				PlayerAPI.jogador4.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador5.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM5 = false;
			Player[] onlinePlayers5;
			for (int length5 = (onlinePlayers5 = Bukkit.getOnlinePlayers()).length, n = 0; n < length5; ++n) {
				final Player Jogadores = onlinePlayers5[n];
				PlayerAPI.jogador5.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador6.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM6 = false;
			Player[] onlinePlayers6;
			for (int length6 = (onlinePlayers6 = Bukkit.getOnlinePlayers()).length, n2 = 0; n2 < length6; ++n2) {
				final Player Jogadores = onlinePlayers6[n2];
				PlayerAPI.jogador6.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador7.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM7 = false;
			Player[] onlinePlayers7;
			for (int length7 = (onlinePlayers7 = Bukkit.getOnlinePlayers()).length, n3 = 0; n3 < length7; ++n3) {
				final Player Jogadores = onlinePlayers7[n3];
				PlayerAPI.jogador7.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador8.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM8 = false;
			Player[] onlinePlayers8;
			for (int length8 = (onlinePlayers8 = Bukkit.getOnlinePlayers()).length, n4 = 0; n4 < length8; ++n4) {
				final Player Jogadores = onlinePlayers8[n4];
				PlayerAPI.jogador8.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador9.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM9 = false;
			Player[] onlinePlayers9;
			for (int length9 = (onlinePlayers9 = Bukkit.getOnlinePlayers()).length, n5 = 0; n5 < length9; ++n5) {
				final Player Jogadores = onlinePlayers9[n5];
				PlayerAPI.jogador9.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador10.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM10 = false;
			Player[] onlinePlayers10;
			for (int length10 = (onlinePlayers10 = Bukkit.getOnlinePlayers()).length, n6 = 0; n6 < length10; ++n6) {
				final Player Jogadores = onlinePlayers10[n6];
				PlayerAPI.jogador10.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador11.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM11 = false;
			Player[] onlinePlayers11;
			for (int length11 = (onlinePlayers11 = Bukkit.getOnlinePlayers()).length, n7 = 0; n7 < length11; ++n7) {
				final Player Jogadores = onlinePlayers11[n7];
				PlayerAPI.jogador11.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador12.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM12 = false;
			Player[] onlinePlayers12;
			for (int length12 = (onlinePlayers12 = Bukkit.getOnlinePlayers()).length, n8 = 0; n8 < length12; ++n8) {
				final Player Jogadores = onlinePlayers12[n8];
				PlayerAPI.jogador12.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador13.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM13 = false;
			Player[] onlinePlayers13;
			for (int length13 = (onlinePlayers13 = Bukkit.getOnlinePlayers()).length, n9 = 0; n9 < length13; ++n9) {
				final Player Jogadores = onlinePlayers13[n9];
				PlayerAPI.jogador13.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador14.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM14 = false;
			Player[] onlinePlayers14;
			for (int length14 = (onlinePlayers14 = Bukkit.getOnlinePlayers()).length, n10 = 0; n10 < length14; ++n10) {
				final Player Jogadores = onlinePlayers14[n10];
				PlayerAPI.jogador14.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador15.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM15 = false;
			Player[] onlinePlayers15;
			for (int length15 = (onlinePlayers15 = Bukkit.getOnlinePlayers()).length, n11 = 0; n11 < length15; ++n11) {
				final Player Jogadores = onlinePlayers15[n11];
				PlayerAPI.jogador15.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador16.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM16 = false;
			Player[] onlinePlayers16;
			for (int length16 = (onlinePlayers16 = Bukkit.getOnlinePlayers()).length, n12 = 0; n12 < length16; ++n12) {
				final Player Jogadores = onlinePlayers16[n12];
				PlayerAPI.jogador16.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador17.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM17 = false;
			Player[] onlinePlayers17;
			for (int length17 = (onlinePlayers17 = Bukkit.getOnlinePlayers()).length, n13 = 0; n13 < length17; ++n13) {
				final Player Jogadores = onlinePlayers17[n13];
				PlayerAPI.jogador17.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador18.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM18 = false;
			Player[] onlinePlayers18;
			for (int length18 = (onlinePlayers18 = Bukkit.getOnlinePlayers()).length, n14 = 0; n14 < length18; ++n14) {
				final Player Jogadores = onlinePlayers18[n14];
				PlayerAPI.jogador18.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador19.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM19 = false;
			Player[] onlinePlayers19;
			for (int length19 = (onlinePlayers19 = Bukkit.getOnlinePlayers()).length, n15 = 0; n15 < length19; ++n15) {
				final Player Jogadores = onlinePlayers19[n15];
				PlayerAPI.jogador19.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador20.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM20 = false;
			Player[] onlinePlayers20;
			for (int length20 = (onlinePlayers20 = Bukkit.getOnlinePlayers()).length, n16 = 0; n16 < length20; ++n16) {
				final Player Jogadores = onlinePlayers20[n16];
				PlayerAPI.jogador20.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador21.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM21 = false;
			Player[] onlinePlayers21;
			for (int length21 = (onlinePlayers21 = Bukkit.getOnlinePlayers()).length, n17 = 0; n17 < length21; ++n17) {
				final Player Jogadores = onlinePlayers21[n17];
				PlayerAPI.jogador21.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador22.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM22 = false;
			Player[] onlinePlayers22;
			for (int length22 = (onlinePlayers22 = Bukkit.getOnlinePlayers()).length, n18 = 0; n18 < length22; ++n18) {
				final Player Jogadores = onlinePlayers22[n18];
				PlayerAPI.jogador22.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador23.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM23 = false;
			Player[] onlinePlayers23;
			for (int length23 = (onlinePlayers23 = Bukkit.getOnlinePlayers()).length, n19 = 0; n19 < length23; ++n19) {
				final Player Jogadores = onlinePlayers23[n19];
				PlayerAPI.jogador23.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador24.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM24 = false;
			Player[] onlinePlayers24;
			for (int length24 = (onlinePlayers24 = Bukkit.getOnlinePlayers()).length, n20 = 0; n20 < length24; ++n20) {
				final Player Jogadores = onlinePlayers24[n20];
				PlayerAPI.jogador24.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador25.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM25 = false;
			Player[] onlinePlayers25;
			for (int length25 = (onlinePlayers25 = Bukkit.getOnlinePlayers()).length, n21 = 0; n21 < length25; ++n21) {
				final Player Jogadores = onlinePlayers25[n21];
				PlayerAPI.jogador25.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador26.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM26 = false;
			Player[] onlinePlayers26;
			for (int length26 = (onlinePlayers26 = Bukkit.getOnlinePlayers()).length, n22 = 0; n22 < length26; ++n22) {
				final Player Jogadores = onlinePlayers26[n22];
				PlayerAPI.jogador26.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador27.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM27 = false;
			Player[] onlinePlayers27;
			for (int length27 = (onlinePlayers27 = Bukkit.getOnlinePlayers()).length, n23 = 0; n23 < length27; ++n23) {
				final Player Jogadores = onlinePlayers27[n23];
				PlayerAPI.jogador27.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador28.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM28 = false;
			Player[] onlinePlayers28;
			for (int length28 = (onlinePlayers28 = Bukkit.getOnlinePlayers()).length, n24 = 0; n24 < length28; ++n24) {
				final Player Jogadores = onlinePlayers28[n24];
				PlayerAPI.jogador28.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador29.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM29 = false;
			Player[] onlinePlayers29;
			for (int length29 = (onlinePlayers29 = Bukkit.getOnlinePlayers()).length, n25 = 0; n25 < length29; ++n25) {
				final Player Jogadores = onlinePlayers29[n25];
				PlayerAPI.jogador29.remove(Jogadores);
			}
		} else if (PlayerAPI.jogador30.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM30 = false;
			Player[] onlinePlayers30;
			for (int length30 = (onlinePlayers30 = Bukkit.getOnlinePlayers()).length, n26 = 0; n26 < length30; ++n26) {
				final Player Jogadores = onlinePlayers30[n26];
				PlayerAPI.jogador30.remove(Jogadores);
			}
		}
	}

	public static void RemoverSoBoolean(final Player Jogador) {
		if (PlayerAPI.jogador1.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM1 = false;
		} else if (PlayerAPI.jogador2.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM2 = false;
		} else if (PlayerAPI.jogador3.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM3 = false;
		} else if (PlayerAPI.jogador4.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM4 = false;
		} else if (PlayerAPI.jogador5.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM5 = false;
		} else if (PlayerAPI.jogador6.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM6 = false;
		} else if (PlayerAPI.jogador7.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM7 = false;
		} else if (PlayerAPI.jogador8.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM8 = false;
		} else if (PlayerAPI.jogador9.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM9 = false;
		} else if (PlayerAPI.jogador10.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM10 = false;
		} else if (PlayerAPI.jogador11.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM11 = false;
		} else if (PlayerAPI.jogador12.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM12 = false;
		} else if (PlayerAPI.jogador13.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM13 = false;
		} else if (PlayerAPI.jogador14.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM14 = false;
		} else if (PlayerAPI.jogador15.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM15 = false;
		} else if (PlayerAPI.jogador16.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM16 = false;
		} else if (PlayerAPI.jogador17.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM17 = false;
		} else if (PlayerAPI.jogador18.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM18 = false;
		} else if (PlayerAPI.jogador19.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM19 = false;
		} else if (PlayerAPI.jogador20.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM20 = false;
		} else if (PlayerAPI.jogador21.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM21 = false;
		} else if (PlayerAPI.jogador22.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM22 = false;
		} else if (PlayerAPI.jogador23.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM23 = false;
		} else if (PlayerAPI.jogador24.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM24 = false;
		} else if (PlayerAPI.jogador25.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM25 = false;
		} else if (PlayerAPI.jogador26.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM26 = false;
		} else if (PlayerAPI.jogador27.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM27 = false;
		} else if (PlayerAPI.jogador28.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM28 = false;
		} else if (PlayerAPI.jogador29.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM29 = false;
		} else if (PlayerAPI.jogador30.get(Jogador) == Jogador.getName()) {
			PlayerAPI.RDM30 = false;
		}
	}

	public static void SelecionarProximoJogador(final Player Jogador) {
		if (PlayerAPI.RDM1) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador1.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM2) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador2.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM3) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador3.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM4) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador4.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM5) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador5.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM6) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador6.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM7) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador7.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM8) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador8.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM9) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador9.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM10) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador10.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM11) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador11.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM12) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador12.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM13) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador13.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM14) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador14.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM15) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador15.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM16) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador16.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM17) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador17.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM18) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador18.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM19) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador19.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM20) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador20.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM21) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador21.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM22) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador22.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM23) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador23.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM24) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador24.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM25) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador25.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM26) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador26.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM27) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador27.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM28) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador28.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM29) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador29.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		} else if (PlayerAPI.RDM30) {
			final Player Jogador2 = Bukkit.getPlayer((String) PlayerAPI.jogador30.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
	}

	public static void CheckarGanhador(final Player Jogador) {
		if (PlayerAPI.Participando.size() == 1) {
			Jogador.sendMessage("�7Voc\u00ea \u00e9 o �2�lVENCEDOR �7do evento!");
			Proteção.setImortal(Jogador, true);
			Jogador.setMaxHealth(20);
			Jogador.setHealth(20.0);
			Jogador.setFoodLevel(20);
			Jogador.setFlySpeed(0.1f);
			Jogador.setAllowFlight(false);
			Jogador.setWalkSpeed(0.2f);
			Jogador.getInventory().clear();
			Jogador.setGameMode(GameMode.SURVIVAL);
			Jogador.getInventory().setBoots((ItemStack) null);
			Jogador.getInventory().setChestplate((ItemStack) null);
			Jogador.getInventory().setHelmet((ItemStack) null);
			Jogador.getInventory().setLeggings((ItemStack) null);
			Tempo.mandarBroadcast(
					" \n�4�lAVISO: �fO jogador �2�l" + Jogador.getName() + " �ffoi o vencedor do evento!" + "\n" + " ");
			Jogador.playSound(Jogador.getLocation(), Sound.LEVEL_UP, 20.0f, 20.0f);
			final Vector Vector = Jogador.getLocation().getDirection().multiply(0).setY(4);
			Jogador.setVelocity(Vector);
			if (!Jogador.getAllowFlight()) {
				Jogador.setAllowFlight(true);
			} else {
				Jogador.setAllowFlight(true);
			}
			new BukkitRunnable() {
				public void run() {
					Jogador.sendMessage("�7Voc\u00ea \u00e9 o �2�lVENCEDOR �7do evento!");
					Tempo.mandarBroadcast(" \n�4�lAVISO: �fO jogador �2�l" + Jogador.getName()
							+ " �ffoi o vencedor do evento!" + "\n" + " ");
					Jogador.playSound(Jogador.getLocation(), Sound.LEVEL_UP, 20.0f, 20.0f);
				}
			}.runTaskLaterAsynchronously(CookiePvP.getPlugin(), 20L);
			new BukkitRunnable() {
				public void run() {
					Jogador.sendMessage("�7Voc\u00ea \u00e9 o �2�lVENCEDOR �7do evento!");
					Tempo.mandarBroadcast(" \n�4�lAVISO: �fO jogador �2�l" + Jogador.getName()
							+ " �ffoi o vencedor do evento!" + "\n" + " ");
					Jogador.playSound(Jogador.getLocation(), Sound.LEVEL_UP, 20.0f, 20.0f);
				}
			}.runTaskLaterAsynchronously(CookiePvP.getPlugin(), 60L);
			new BukkitRunnable() {
				public void run() {
					Jogador.sendMessage("�7Voc\u00ea \u00e9 o �2�lVENCEDOR �7do evento!");
					Tempo.mandarBroadcast(" \n�4�lAVISO: �fO jogador �2�l" + Jogador.getName()
							+ " �ffoi o vencedor do evento!" + "\n" + " ");
					Jogador.playSound(Jogador.getLocation(), Sound.LEVEL_UP, 20.0f, 20.0f);
				}
			}.runTaskLaterAsynchronously(CookiePvP.getPlugin(), 100L);
			new BukkitRunnable() {
				public void run() {
					Jogador.sendMessage("�7Voc\u00ea \u00e9 o �2�lVENCEDOR �7do evento!");
					Tempo.mandarBroadcast(" \n�4�lAVISO: �fO jogador �2�l" + Jogador.getName()
							+ " �ffoi o vencedor do evento!" + "\n" + " ");
					Tempo.mandarBroadcast("�5�lFIM: �fO evento foi finalizado com sucesso!");
					EventoAPI.TeleportarWarp(Jogador, "Saida");
					PlayerAPI.LimparPlayers();
					PlayerAPI.LimparPlayer(Jogador);
					CookiePvP.Evento = Estado.FECHADO;
					Tempo.Iniciando = 301;
					Tempo.CancelarTempo();
					Jogador.playSound(Jogador.getLocation(), Sound.LEVEL_UP, 20.0f, 20.0f);
					API.setWarp(Jogador, "Spawn");
					if (cfGrupo.ChecarGrupo(Jogador, "Membro") || cfGrupo.ChecarGrupo(Jogador, "Light")
							|| cfGrupo.ChecarGrupo(Jogador, "Mvp")) {
						cfGrupo.setarGrupo(Jogador, "Pro");
						GrupoAPI.expirar(Jogador, CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Dia) + 1,
								CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Mes),
								CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Ano),
								CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Hora),
								CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Minuto) + 1,
								CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Segundo) + 1);
						GrupoAPI.checarVip(Jogador);
						Jogador.chat("/tag pro");
						sScoreAPI.scoreboard(Jogador);
						Jogador.setAllowFlight(false);
						Jogador.sendMessage(
								"�7Parab\u00e9ns! Voc\u00ea foi o �2�lVENCEDOR �7do evento e como recompensa recebeu o grupo �6�lPRO �7por �e�l1 �7dia.");
						if (CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Dia) == 30) {
							cfTempGrupo.pegargrupo().set("tempgrupo." + Jogador.getUniqueId() + ".dia", (Object) 1);
						}
					} else if (!cfGrupo.ChecarGrupo(Jogador, "Membro") || !cfGrupo.ChecarGrupo(Jogador, "Light")
							|| !cfGrupo.ChecarGrupo(Jogador, "Mvp")) {
						Jogador.sendMessage(
								"�cVoc\u00ea não recebeu um pr\u00eamio por ganhar pois o seu grupo \u00e9 maior do que a recompensa! �7�o(Mais vale um VIP eterno do que um PRO tempor\u00e1rio)");
					}
					API.sendItems(Jogador);
				}
			}.runTaskLaterAsynchronously(CookiePvP.getPlugin(), 140L);
		}
	}
}
