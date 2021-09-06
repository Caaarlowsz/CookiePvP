package me.cangasso.anticheat.hacks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.cangasso.anticheat.Utills;
import me.cangasso.main.Main;

public class FastClick implements Listener {
	@EventHandler
	private void onPlayerInteractEvent(final PlayerInteractEvent Evento) {
		if (!(Evento.getPlayer() instanceof Player)) {
			return;
		}
		if (!Evento.getAction().name().contains("LEFT")) {
			return;
		}
		final Player Jogador = Evento.getPlayer();
		if (Utills.FastAttackClicks.containsKey(Jogador)) {
			Utills.FastAttackClicks.put(Jogador, Utills.FastAttackClicks.get(Jogador) + 1);
		} else {
			Utills.FastAttackClicks.put(Jogador, 1);
		}
		if (Utills.ClicksFastClicks.containsKey(Jogador)) {
			Utills.ClicksFastClicks.put(Jogador, Utills.ClicksFastClicks.get(Jogador) + 1);
		} else {
			Utills.ClicksFastClicks.put(Jogador, 1);
		}
		final Utills.Hack FastClickTalvez = Utills.Hack.FASTCLICKTALVEZ;
		final Utills.Hack FastClickProvelmente = Utills.Hack.FASTCLICKPROVAVELMENTE;
		final Utills.Hack FastClickDefinitimante = Utills.Hack.FASTCLICKDEFINITIVAMENTE;
		new BukkitRunnable() {
			public void run() {
				Utills.ClicksFastClicks.remove(Jogador);
				Utills.FastAttackClicks.remove(Jogador);
			}
		}.runTaskLater(Main.getPlugin(), 20L);
		if (Utills.FastAttackClicks.get(Jogador) >= 50) {
			Utills.FastAttack = FastClickTalvez.getMenssagem().replace("nick", Jogador.getName().toString())
					.replace("avisos", new StringBuilder().append(Utills.AvisosFastClick.get(Jogador)).toString())
					.replace("clicks", new StringBuilder().append(Utills.ClicksFastClicks.get(Jogador)).toString());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Utills.FastAttackClicks.containsKey(Jogador)) {
						Utills.FastAttackClicks.remove(Jogador);
					}
					if (Utills.FastAttack != null) {
						Utills.AvisosFastClick.put(Jogador, Utills.AvisosFastClick.get(Jogador) + 1);
						Utills.sendAntiCheat(Utills.FastAttack);
					}
					Utills.FastAttack = null;
					Utills.ClicksFastClicks.remove(Jogador);
					Utills.FastAttackClicks.remove(Jogador);
				}
			}, 20L);
		}
		if (Utills.FastAttackClicks.get(Jogador) >= 60) {
			Utills.FastAttack = FastClickProvelmente.getMenssagem().replace("nick", Jogador.getName().toString())
					.replace("avisos", new StringBuilder().append(Utills.AvisosFastClick.get(Jogador)).toString())
					.replace("clicks", new StringBuilder().append(Utills.ClicksFastClicks.get(Jogador)).toString());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Utills.FastAttackClicks.containsKey(Jogador)) {
						Utills.FastAttackClicks.remove(Jogador);
					}
					if (Utills.FastAttack != null) {
						Utills.AvisosFastClick.put(Jogador, Utills.AvisosFastClick.get(Jogador) + 1);
						Utills.sendAntiCheat(Utills.FastAttack);
					}
					Utills.FastAttack = null;
					Utills.ClicksFastClicks.remove(Jogador);
					Utills.FastAttackClicks.remove(Jogador);
				}
			}, 20L);
		}
		if (Utills.FastAttackClicks.get(Jogador) >= 80) {
			Utills.FastAttack = FastClickDefinitimante.getMenssagem().replace("nick", Jogador.getName().toString())
					.replace("avisos", new StringBuilder().append(Utills.AvisosFastClick.get(Jogador)).toString())
					.replace("clicks", new StringBuilder().append(Utills.ClicksFastClicks.get(Jogador)).toString());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Utills.FastAttackClicks.containsKey(Jogador)) {
						Utills.FastAttackClicks.remove(Jogador);
					}
					if (Utills.FastAttack != null) {
						Utills.AvisosFastClick.put(Jogador, Utills.AvisosFastClick.get(Jogador) + 1);
						Utills.sendAntiCheat(Utills.FastAttack);
					}
					Utills.ClicksFastClicks.remove(Jogador);
					Utills.FastAttackClicks.remove(Jogador);
				}
			}, 20L);
		}
	}
}
