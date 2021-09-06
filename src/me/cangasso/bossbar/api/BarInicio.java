package me.cangasso.bossbar.api;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.cangasso.main.Main;

public class BarInicio implements Listener {
	protected static BarInicio instance;

	@EventHandler
	public void onPluginEnable(final PluginEnableEvent e) {
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onQuit(final PlayerQuitEvent e) {
		BossBarAPI.removeBar(e.getPlayer());
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onKick(final PlayerKickEvent e) {
		BossBarAPI.removeBar(e.getPlayer());
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onTeleport(final PlayerTeleportEvent e) {
		this.handlePlayerTeleport(e.getPlayer(), e.getFrom(), e.getTo());
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onRespawn(final PlayerRespawnEvent e) {
		this.handlePlayerTeleport(e.getPlayer(), e.getPlayer().getLocation(), e.getRespawnLocation());
	}

	protected void handlePlayerTeleport(final Player player, final Location from, final Location to) {
		if (!BossBarAPI.hasBar(player)) {
			return;
		}
		final BossBar bar = BossBarAPI.getBossBar(player);
		bar.setVisible(false);
		new BukkitRunnable() {
			public void run() {
				bar.setVisible(true);
			}
		}.runTaskLater(Main.getPlugin(), 2L);
	}

	@EventHandler
	public void onMove(final PlayerMoveEvent e) {
		final BossBar bar = BossBarAPI.getBossBar(e.getPlayer());
		if (bar != null) {
			new BukkitRunnable() {
				public void run() {
					if (!e.getPlayer().isOnline()) {
						return;
					}
					bar.updateMovement();
				}
			}.runTaskLater(Main.getPlugin(), 0L);
		}
	}
}
