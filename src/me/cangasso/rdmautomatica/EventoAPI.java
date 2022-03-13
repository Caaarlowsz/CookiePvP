package me.cangasso.rdmautomatica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.cangasso.main.CookiePvP;

public class EventoAPI implements Listener {
	public static ArrayList<Player> Teleportando;
	public static ArrayList<Player> AntiBug;
	public static HashMap<Player, Long> Cooldown;

	static {
		EventoAPI.Teleportando = new ArrayList<Player>();
		EventoAPI.AntiBug = new ArrayList<Player>();
		EventoAPI.Cooldown = new HashMap<Player, Long>();
	}

	public static void SetarWarp(final Player Jogador, final String LocalDoEvento) {
		Configuração.getEvento().set(String.valueOf(LocalDoEvento) + ".Setado por",
				(Object) Jogador.getName());
		Configuração.getEvento().set(String.valueOf(LocalDoEvento) + ".X",
				(Object) Jogador.getLocation().getX());
		Configuração.getEvento().set(String.valueOf(LocalDoEvento) + ".Y",
				(Object) Jogador.getLocation().getY());
		Configuração.getEvento().set(String.valueOf(LocalDoEvento) + ".Z",
				(Object) Jogador.getLocation().getZ());
		Configuração.getEvento().set(String.valueOf(LocalDoEvento) + ".Pitch",
				(Object) Jogador.getLocation().getPitch());
		Configuração.getEvento().set(String.valueOf(LocalDoEvento) + ".Yaw",
				(Object) Jogador.getLocation().getYaw());
		Configuração.salvarConfig();
	}

	public static void TeleportarWarp(final Player Jogador, final String LocalDoEvento) {
		if (Configuração.getEvento().get(LocalDoEvento) == null) {
			Jogador.sendMessage("�fO local �6�l" + LocalDoEvento + " �fainda não foi setado!");
			return;
		}
		final double x = Configuração.getEvento().getDouble(String.valueOf(LocalDoEvento) + ".X");
		final double y = Configuração.getEvento().getDouble(String.valueOf(LocalDoEvento) + ".Y");
		final double z = Configuração.getEvento().getDouble(String.valueOf(LocalDoEvento) + ".Z");
		final float pitch = (float) Configuração.getEvento()
				.getDouble(String.valueOf(LocalDoEvento) + ".Pitch");
		final float yaw = (float) Configuração.getEvento().getDouble(String.valueOf(LocalDoEvento) + ".Yaw");
		Jogador.teleport(new Location(Jogador.getWorld(), x, y, z, yaw, pitch));
	}

	public static void AdicinarCooldown(final Player Jogador, final int Tempo) {
		EventoAPI.Cooldown.put(Jogador, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(Tempo));
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				EventoAPI.RemoverCooldown(Jogador);
			}
		}, (long) (Tempo * 20));
	}

	public static void RemoverCooldown(final Player Jogador) {
		EventoAPI.Cooldown.remove(Jogador);
	}

	public static long PegarCooldown(final Player Jogador) {
		final long Tempo = TimeUnit.MILLISECONDS
				.toSeconds(EventoAPI.Cooldown.get(Jogador) - System.currentTimeMillis());
		if (EventoAPI.Cooldown.containsKey(Jogador) || EventoAPI.Cooldown.get(Jogador) > System.currentTimeMillis()) {
			return Tempo;
		}
		return 0L;
	}

	@EventHandler
	private void onPlayerMoveEvent(final PlayerMoveEvent Evento) {
		final Player Jogador = Evento.getPlayer();
		if (EventoAPI.Teleportando.contains(Jogador)) {
			EventoAPI.Teleportando.remove(Jogador);
			EventoAPI.AntiBug.remove(Jogador);
			Jogador.setExp(0.0f);
			Jogador.setLevel(0);
			Jogador.sendMessage("�cO seu teleporte foi cancelado!");
			Jogador.playSound(Jogador.getLocation(), Sound.NOTE_PIANO, 10.0f, 10.0f);
		}
		if (PlayerAPI.Esperando.contains(Jogador)) {
			Jogador.teleport(Jogador.getLocation());
		}
	}

	@EventHandler
	private void onPlayerQuitEvent(final PlayerQuitEvent event) {
		final Player Jogador = event.getPlayer();
		RemoverCooldown(Jogador);
	}

	@EventHandler
	public void onRightClickPiston(final PlayerInteractEvent Evento) {
		final Player Jogador = Evento.getPlayer();
		if (Evento.getAction().equals((Object) Action.RIGHT_CLICK_BLOCK)
				&& Evento.getClickedBlock().getType() != Material.STONE && EventoAPI.AntiBug.contains(Jogador)) {
			Evento.setCancelled(true);
		}
	}
}
