package me.cangasso.API;

import org.bukkit.entity.Player;

import me.cangasso.configuração.cfConfig;
import me.cangasso.scoreboard.sScoreAPI;

public class PadraoAPI {
	public static void setKit(final Player p, final String kit) {
		cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) kit);
		cfConfig.salvarconfiguracao();
		sScoreAPI.scoreboard(p);
	}
}
