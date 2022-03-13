package me.cangasso.configuração;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class cfPermissão {
	private static FileConfiguration player_permissao;
	private static File playerpermissao;

	public static void setarconfig(final Plugin plugin) {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		cfPermissão.playerpermissao = new File(plugin.getDataFolder(), "permiss\u00f5es.yml");
		if (cfPermissão.playerpermissao.exists()) {
			try {
				cfPermissão.playerpermissao.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		cfPermissão.player_permissao = (FileConfiguration) YamlConfiguration
				.loadConfiguration(cfPermissão.playerpermissao);
	}

	public static FileConfiguration pegarpermissao() {
		return cfPermissão.player_permissao;
	}

	public static void salvarconfiguracao() {
		try {
			cfPermissão.player_permissao.save(cfPermissão.playerpermissao);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setarPermissao(final Player p, final String Permissao, final String trueoufalse) {
		pegarpermissao().set("permiss\u00f5es." + p.getUniqueId() + ".Nick", (Object) p.getName());
		pegarpermissao().set("permiss\u00f5es." + p.getUniqueId() + "." + Permissao, (Object) trueoufalse);
		salvarconfiguracao();
	}

	public static boolean getPermissao(final Player p, final String Permissao) {
		return pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + "." + Permissao).equals("true");
	}
}
