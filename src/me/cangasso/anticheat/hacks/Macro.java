package me.cangasso.anticheat.hacks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.cangasso.anticheat.Utills;
import me.cangasso.main.Main;

public class Macro implements Listener {
	@EventHandler
	private void onInventoryClickEvent(final InventoryClickEvent Evento) {
		if (!(Evento.getWhoClicked() instanceof Player)) {
			return;
		}
		if (!Evento.isShiftClick()) {
			return;
		}
		final Player Jogador = (Player) Evento.getWhoClicked();
		if (Utills.MacroClicks.containsKey(Jogador)) {
			Utills.MacroClicks.put(Jogador, Utills.MacroClicks.get(Jogador) + 1);
		} else {
			Utills.MacroClicks.put(Jogador, 1);
		}
		if (Utills.ClicksMacro.containsKey(Jogador)) {
			Utills.ClicksMacro.put(Jogador, Utills.ClicksMacro.get(Jogador) + 1);
		} else {
			Utills.ClicksMacro.put(Jogador, 1);
		}
		final Utills.Hack MacroTalvez = Utills.Hack.MACROTALVEZ;
		final Utills.Hack MacroProvavelmente = Utills.Hack.MACROPROVAVELMENTE;
		final Utills.Hack MacroDefinitivamente = Utills.Hack.MACRODEFINITIVAMENTE;
		new BukkitRunnable() {
			public void run() {
				Utills.ClicksMacro.remove(Jogador);
				Utills.MacroClicks.remove(Jogador);
			}
		}.runTaskLater(Main.getPlugin(), 20L);
		if (Utills.MacroClicks.get(Jogador) >= 45) {
			Utills.Macro = MacroTalvez.getMenssagem().replace("nick", Jogador.getName())
					.replace("avisos", new StringBuilder().append(Utills.AvisosMacro.get(Jogador)).toString())
					.replace("clicks", new StringBuilder().append(Utills.ClicksMacro.get(Jogador)).toString());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Utills.Macro != null) {
						Utills.AvisosMacro.put(Jogador, Utills.AvisosMacro.get(Jogador) + 1);
						Utills.sendAntiCheat(Utills.Macro);
					}
					if (Utills.MacroClicks.containsKey(Jogador)) {
						Utills.MacroClicks.remove(Jogador);
					}
					Utills.Macro = null;
					Utills.ClicksMacro.put(Jogador, 0);
				}
			}, 20L);
		}
		if (Utills.MacroClicks.get(Jogador) >= 55) {
			Utills.Macro = MacroProvavelmente.getMenssagem().replace("nick", Jogador.getName())
					.replace("avisos", new StringBuilder().append(Utills.AvisosMacro.get(Jogador)).toString())
					.replace("clicks", new StringBuilder().append(Utills.ClicksMacro.get(Jogador)).toString());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Utills.Macro != null) {
						Utills.AvisosMacro.put(Jogador, Utills.AvisosMacro.get(Jogador) + 1);
						Utills.sendAntiCheat(Utills.Macro);
					}
					if (Utills.MacroClicks.containsKey(Jogador)) {
						Utills.MacroClicks.remove(Jogador);
					}
					Utills.Macro = null;
					Utills.ClicksMacro.put(Jogador, 0);
				}
			}, 20L);
		}
		if (Utills.MacroClicks.get(Jogador) >= 65) {
			Utills.Macro = MacroDefinitivamente.getMenssagem().replace("nick", Jogador.getName())
					.replace("avisos", new StringBuilder().append(Utills.AvisosMacro.get(Jogador)).toString())
					.replace("clicks", new StringBuilder().append(Utills.ClicksMacro.get(Jogador)).toString());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Utills.Macro != null) {
						Utills.AvisosMacro.put(Jogador, Utills.AvisosMacro.get(Jogador) + 1);
						Utills.sendAntiCheat(Utills.Macro);
					}
					if (Utills.MacroClicks.containsKey(Jogador)) {
						Utills.MacroClicks.remove(Jogador);
					}
					Utills.Macro = null;
					Utills.ClicksMacro.put(Jogador, 0);
				}
			}, 20L);
		}
	}
}
