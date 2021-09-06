package me.cangasso.configura\u00e7\u00e3o;

import java.io.File;
import java.io.IOException;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class cfGrupo {
	private static FileConfiguration player_grupo;
	private static File playergrupo;

	public static void setarconfig(final Plugin plugin) {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		cfGrupo.playergrupo = new File(plugin.getDataFolder(), "grupos.yml");
		if (cfGrupo.playergrupo.exists()) {
			try {
				cfGrupo.playergrupo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		cfGrupo.player_grupo = (FileConfiguration) YamlConfiguration.loadConfiguration(cfGrupo.playergrupo);
	}

	public static FileConfiguration pegargrupo() {
		return cfGrupo.player_grupo;
	}

	public static void salvarconfiguracao() {
		try {
			cfGrupo.player_grupo.save(cfGrupo.playergrupo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean ChecarGrupo(final Player p, final String Grupo) {
		return pegargrupo().get("grupos." + p.getUniqueId() + ".grupo").equals(Grupo);
	}

	public static boolean ChecarGrupo(final OfflinePlayer p, final String Grupo) {
		return pegargrupo().get("grupos." + p.getUniqueId() + ".grupo").equals(Grupo);
	}

	public static void setarGrupo(final Player p, final String Grupo) {
		pegargrupo().set("grupos." + p.getUniqueId() + ".Nick", (Object) p.getName());
		pegargrupo().set("grupos." + p.getUniqueId() + ".grupo", (Object) Grupo);
		salvarconfiguracao();
	}

	public static void setarGrupo(final OfflinePlayer p, final String Grupo) {
		pegargrupo().set("grupos." + p.getUniqueId() + ".Nick", (Object) p.getName());
		pegargrupo().set("grupos." + p.getUniqueId() + ".grupo", (Object) Grupo);
		salvarconfiguracao();
	}
}
