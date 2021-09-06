package me.cangasso.configura\u00e7\u00e3o;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class cfConfig {
	private static FileConfiguration config_player;
	private static File configplayer;

	public static void setarConfig(final Plugin plugin) {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		cfConfig.configplayer = new File(plugin.getDataFolder(), "configura\u00e7ao.yml");
		if (cfConfig.configplayer.exists()) {
			try {
				cfConfig.configplayer.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		cfConfig.config_player = (FileConfiguration) YamlConfiguration.loadConfiguration(cfConfig.configplayer);
	}

	public static FileConfiguration pegarconfig() {
		return cfConfig.config_player;
	}

	public static void salvarconfiguracao() {
		try {
			cfConfig.config_player.save(cfConfig.configplayer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
