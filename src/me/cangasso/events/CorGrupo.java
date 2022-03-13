package me.cangasso.events;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class CorGrupo {
	public static HashMap<Player, String> tag;

	static {
		CorGrupo.tag = new HashMap<Player, String>();
	}

	public static String getTag(final Player player) {
		if (CorGrupo.tag.containsKey(player)) {
			return CorGrupo.tag.get(player);
		}
		return "�7";
	}

	public static void setarTag(final Player player, final String Tag) {
		CorGrupo.tag.put(player, Tag);
	}
}
