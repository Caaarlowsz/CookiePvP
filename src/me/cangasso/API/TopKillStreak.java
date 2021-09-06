package me.cangasso.API;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.cangasso.scoreboard.sScoreAPI;

public class TopKillStreak implements Listener {
	public static HashMap<Player, String> Name;
	public static HashMap<Player, Integer> KsTop;
	public static HashMap<Player, Integer> Ks;

	static {
		TopKillStreak.Name = new HashMap<Player, String>();
		TopKillStreak.KsTop = new HashMap<Player, Integer>();
		TopKillStreak.Ks = new HashMap<Player, Integer>();
	}

	public static String getNameTop(final Player player) {
		if (TopKillStreak.Name.containsKey(player)) {
			return TopKillStreak.Name.get(player);
		}
		return "Ningu\u00e9m";
	}

	public static int getKsTop(final Player player) {
		if (TopKillStreak.KsTop.containsKey(player)) {
			return TopKillStreak.KsTop.get(player);
		}
		return 0;
	}

	public static void createTopKillStreak(final Player player) {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player players = onlinePlayers[i];
			if (TopKillStreak.Ks.get(player) > TopKillStreak.Ks.get(players)) {
				TopKillStreak.Name.put(player, player.getName());
				TopKillStreak.Name.put(players, player.getName());
				TopKillStreak.KsTop.put(player, (int) TopKillStreak.Ks.get(player));
				TopKillStreak.KsTop.put(players, (int) TopKillStreak.Ks.get(player));
				if (getKsTop(player) >= getKsTop(players)) {
					sScoreAPI.scoreboard(players);
					sScoreAPI.scoreboard(player);
				}
			}
		}
	}

	public static String formatTopKillStreak(final Player player) {
		return "§3" + getNameTop(player) + " §f-§3 " + getKsTop(player);
	}
}
