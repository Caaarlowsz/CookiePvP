package me.cangasso.bans;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import me.cangasso.configura\u00e7\u00e3o.cfGrupo;

public class API {
	public static ArrayList<Player> Online;
	public static ArrayList<Player> Combate;
	public static ArrayList<Player> ScoreBoard;
	public static ArrayList<Player> ModoSilent;
	public static ArrayList<Player> ModoAdmin;
	public static boolean FeastSpawn;
	public static int FeastSpawnTime;
	public static String CMD;
	public static String TAG;
	public static String VERCMDS;
	public static String ENTRARFULL;
	public static String VERADMINS;

	static {
		API.Online = new ArrayList<Player>();
		API.Combate = new ArrayList<Player>();
		API.ScoreBoard = new ArrayList<Player>();
		API.ModoSilent = new ArrayList<Player>();
		API.ModoAdmin = new ArrayList<Player>();
		API.FeastSpawnTime = 300;
		API.CMD = "comando.";
		API.TAG = "api.tag.";
		API.VERCMDS = "api.ver.cmds";
		API.ENTRARFULL = "api.entrar.full";
		API.VERADMINS = "api.ver.admin";
	}

	public static void sendMsg(final CommandSender jogador, final String Msg) {
		jogador.sendMessage(Msg);
	}

	public static void sendBC(final String Msg) {
		Bukkit.broadcastMessage(Msg);
	}

	public static void clearChat(final Player p) {
		for (int i = 1; i < 100; ++i) {
			p.sendMessage(" ");
		}
	}

	public static void sendSound(final Player jogador, final Sound som, final int time) {
		jogador.playSound(jogador.getLocation(), som, (float) time, (float) time);
	}

	public static void sendEnchant(final Player jogador, final Enchantment encantamento, final int level) {
		jogador.getItemInHand().addUnsafeEnchantment(encantamento, level);
	}

	public static void feastSpawnMin(final int timer) {
		sendBC(ChatColor.GRAY + "§fO §e§lFeast ir\u00e1 spawnar em " + ChatColor.RED + ChatColor.BOLD + timer
				+ ChatColor.GRAY + "§f minuto(s)" + ChatColor.GRAY + "§f!");
	}

	public static void feastSpawnSeg(final int timer) {
		sendBC(ChatColor.GRAY + "§fO §e§lFeast ir\u00e1 spawnar em " + ChatColor.RED + ChatColor.BOLD + timer
				+ ChatColor.GRAY + "§f segundo(s)" + ChatColor.GRAY + "§f!");
	}

	public static String getFormato(final int number) {
		final int ms = number / 60;
		final int ss = number % 60;
		final String m = String.valueOf((ms < 10) ? "0" : "") + ms;
		final String s = String.valueOf((ss < 10) ? "0" : "") + ss;
		final String f = String.valueOf(m) + "m " + s + "s";
		return f;
	}

	public static void sendStaff(final String Msg) {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player jogadores = onlinePlayers[i];
			if (cfGrupo.ChecarGrupo(jogadores, "Dono") || cfGrupo.ChecarGrupo(jogadores, "Gerente")
					|| cfGrupo.ChecarGrupo(jogadores, "Admin") || cfGrupo.ChecarGrupo(jogadores, "Mod+")
					|| cfGrupo.ChecarGrupo(jogadores, "Mod") || cfGrupo.ChecarGrupo(jogadores, "Trial")) {
				sendMsg((CommandSender) jogadores, Msg);
			}
		}
	}
}
