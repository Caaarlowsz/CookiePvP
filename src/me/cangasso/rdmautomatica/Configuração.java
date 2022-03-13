package me.cangasso.rdmautomatica;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Configuração {
	private static FileConfiguration Evento;
	private static File EventoFile;

	public static void getConfig(final Plugin plugin) {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		Configuração.EventoFile = new File(plugin.getDataFolder(), "Evento.yml");
		if (Configuração.EventoFile.exists()) {
			try {
				Configuração.EventoFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Configuração.Evento = (FileConfiguration) YamlConfiguration
				.loadConfiguration(Configuração.EventoFile);
	}

	public static FileConfiguration getEvento() {
		return Configuração.Evento;
	}

	public static void salvarConfig() {
		try {
			Configuração.Evento.save(Configuração.EventoFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
