package me.cangasso.rdmautomatica;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Configura\u00e7\u00e3o {
	private static FileConfiguration Evento;
	private static File EventoFile;

	public static void getConfig(final Plugin plugin) {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		Configura\u00e7\u00e3o.EventoFile = new File(plugin.getDataFolder(), "Evento.yml");
		if (Configura\u00e7\u00e3o.EventoFile.exists()) {
			try {
				Configura\u00e7\u00e3o.EventoFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Configura\u00e7\u00e3o.Evento = (FileConfiguration) YamlConfiguration
				.loadConfiguration(Configura\u00e7\u00e3o.EventoFile);
	}

	public static FileConfiguration getEvento() {
		return Configura\u00e7\u00e3o.Evento;
	}

	public static void salvarConfig() {
		try {
			Configura\u00e7\u00e3o.Evento.save(Configura\u00e7\u00e3o.EventoFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
