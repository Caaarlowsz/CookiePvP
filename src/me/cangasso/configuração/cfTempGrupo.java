package me.cangasso.configuração;

import java.io.File;
import java.io.IOException;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class cfTempGrupo {
	private static FileConfiguration player_grupo;
	private static File playergrupo;

	public static void setarconfig(final Plugin plugin) {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		cfTempGrupo.playergrupo = new File(plugin.getDataFolder(), "tempgrupos.yml");
		if (cfTempGrupo.playergrupo.exists()) {
			try {
				cfTempGrupo.playergrupo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		cfTempGrupo.player_grupo = (FileConfiguration) YamlConfiguration.loadConfiguration(cfTempGrupo.playergrupo);
	}

	public static FileConfiguration pegargrupo() {
		return cfTempGrupo.player_grupo;
	}

	public static void salvarconfiguracao() {
		try {
			cfTempGrupo.player_grupo.save(cfTempGrupo.playergrupo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean ChecarGrupo(final Player p, final String Grupo) {
		return pegargrupo().get("tempgrupos." + p.getUniqueId() + ".grupo").equals(Grupo);
	}

	public static void setarGrupo(final Player p, final String Grupo) {
		pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Nick", (Object) p.getName());
		pegargrupo().set("tempgrupos." + p.getUniqueId() + ".grupo", (Object) Grupo);
		salvarconfiguracao();
	}

	public static void setarGrupo(final OfflinePlayer p, final String Grupo) {
		pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Nick", (Object) p.getName());
		pegargrupo().set("tempgrupos." + p.getUniqueId() + ".grupo", (Object) Grupo);
		salvarconfiguracao();
	}
}
