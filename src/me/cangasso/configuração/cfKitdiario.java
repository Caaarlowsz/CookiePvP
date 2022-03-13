package me.cangasso.configuração;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.cangasso.API.CalendarioAPI;

public class cfKitdiario {
	private static FileConfiguration playerkitdiario;
	private static File player_kitdiario;

	public static void setarconfig(final Plugin plugin) {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		cfKitdiario.player_kitdiario = new File(plugin.getDataFolder(), "kitdiario.yml");
		if (cfKitdiario.player_kitdiario.exists()) {
			try {
				cfKitdiario.player_kitdiario.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		cfKitdiario.playerkitdiario = (FileConfiguration) YamlConfiguration
				.loadConfiguration(cfKitdiario.player_kitdiario);
	}

	public static FileConfiguration pegargrupo() {
		return cfKitdiario.playerkitdiario;
	}

	public static void salvarconfiguracao() {
		try {
			cfKitdiario.playerkitdiario.save(cfKitdiario.player_kitdiario);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setarTempo(final Player p, final String Kit) {
		pegargrupo().set("kitdiario." + p.getUniqueId() + ".Nick", (Object) p.getName());
		pegargrupo().set("kitdiario." + p.getUniqueId() + ".kit", (Object) Kit);
		pegargrupo().set("kitdiario." + p.getUniqueId() + ".dia",
				(Object) CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Dia));
		pegargrupo().set("kitdiario." + p.getUniqueId() + ".hora",
				(Object) CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Hora));
		pegargrupo().set("kitdiario." + p.getUniqueId() + ".minuto",
				(Object) CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Minuto));
		pegargrupo().set("kitdiario." + p.getUniqueId() + ".segundos",
				(Object) CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Segundo));
		salvarconfiguracao();
	}
}
