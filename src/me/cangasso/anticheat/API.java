package me.cangasso.anticheat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class API {
	public static final ChatColor BLACK;
	public static final ChatColor DARK_BLUE;
	public static final ChatColor DARK_GREEN;
	public static final ChatColor DARK_AQUA;
	public static final ChatColor DARK_RED;
	public static final ChatColor DARK_PURPLE;
	public static final ChatColor GOLD;
	public static final ChatColor GRAY;
	public static final ChatColor DARK_GRAY;
	public static final ChatColor BLUE;
	public static final ChatColor GREEN;
	public static final ChatColor YELLOW;
	public static final ChatColor LIGHT_PURPLE;
	public static final ChatColor RED;
	public static final ChatColor WHITE;
	public static final ChatColor AQUA;
	public static final ChatColor BOLD;
	public static final ChatColor ITALIC;
	public static final ChatColor UNDERLINE;
	public static final ChatColor STRIKETHROUGH;
	public static String PrefixStaffer;

	static {
		BLACK = ChatColor.BLACK;
		DARK_BLUE = ChatColor.DARK_BLUE;
		DARK_GREEN = ChatColor.DARK_GREEN;
		DARK_AQUA = ChatColor.DARK_AQUA;
		DARK_RED = ChatColor.DARK_RED;
		DARK_PURPLE = ChatColor.DARK_PURPLE;
		GOLD = ChatColor.GOLD;
		GRAY = ChatColor.GRAY;
		DARK_GRAY = ChatColor.DARK_GRAY;
		BLUE = ChatColor.BLUE;
		GREEN = ChatColor.GREEN;
		YELLOW = ChatColor.YELLOW;
		LIGHT_PURPLE = ChatColor.LIGHT_PURPLE;
		RED = ChatColor.RED;
		WHITE = ChatColor.WHITE;
		AQUA = ChatColor.AQUA;
		BOLD = ChatColor.BOLD;
		ITALIC = ChatColor.ITALIC;
		UNDERLINE = ChatColor.UNDERLINE;
		STRIKETHROUGH = ChatColor.STRIKETHROUGH;
		API.PrefixStaffer = API.GRAY + "» " + API.GRAY;
	}

	public static void sendStaffer(final Player Jogador, final String Menssagem) {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player Jogadores = onlinePlayers[i];
			if (Jogadores != Jogador) {
				Jogadores.sendMessage(Menssagem);
			}
		}
	}
}
