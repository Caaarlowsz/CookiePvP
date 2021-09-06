package me.cangasso.configura\u00e7\u00e3o;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class cfEntrou {
	private static FileConfiguration player_status;
	private static File playerstatus;
	private static FileConfiguration player_status1;
	private static File playerstatus1;

	public static void setarConfig(final Plugin plugin) {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		cfEntrou.playerstatus = new File(plugin.getDataFolder(), "");
		if (cfEntrou.playerstatus.exists()) {
			try {
				cfEntrou.playerstatus.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		cfEntrou.player_status = (FileConfiguration) YamlConfiguration.loadConfiguration(cfEntrou.playerstatus);
	}

	public static FileConfiguration pegarconfig() {
		return cfEntrou.player_status;
	}

	public static void salvarconfiguracao() {
		try {
			cfEntrou.player_status.save(cfEntrou.playerstatus);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setarConfig1(final Plugin plugin) {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		cfEntrou.playerstatus1 = new File(plugin.getDataFolder(), "");
		if (cfEntrou.playerstatus1.exists()) {
			try {
				cfEntrou.playerstatus1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		cfEntrou.player_status1 = (FileConfiguration) YamlConfiguration.loadConfiguration(cfEntrou.playerstatus1);
	}

	public static FileConfiguration pegarconfig1() {
		return cfEntrou.player_status1;
	}

	public static void salvarconfiguracao1() {
		try {
			cfEntrou.player_status1.save(cfEntrou.playerstatus1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
