package me.cangasso.habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import me.cangasso.API.CooldownAPI;
import me.cangasso.API.KitAPI;
import me.cangasso.main.Main;

public class Timelord implements Listener {
	public static ArrayList<String> frozenPlayers;

	static {
		Timelord.frozenPlayers = new ArrayList<String>();
	}

	@EventHandler
	public void onTimeLord(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.WATCH
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			if (KitAPI.getKit(p) == "Timelord" && CooldownAPI.Cooldown.containsKey(p.getName())) {
				p.sendMessage("§8§l<§e§l!§8§l> §7Seu cooldown acaba em " + CooldownAPI.Cooldown + " §7segundos!");
				return;
			}
			if (KitAPI.getKit(p) == "Timelord") {
				final List<Entity> ne = (List<Entity>) e.getPlayer().getNearbyEntities(5.0, 5.0, 5.0);
				for (final Entity t : ne) {
					if (t instanceof Player) {
						final Player ta = (Player) t;
						Timelord.frozenPlayers.add(((Player) t).getName());
						((Player) t).sendMessage("§fVoc\u00ea foi congelado por um §e§lTIMELORD§f!");
						CooldownAPI.addCooldown(p, 35);
						p.sendMessage("§aVoc\u00ea congelou os jogador a sua volta");
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
							@Override
							public void run() {
								Timelord.frozenPlayers.remove(ta.getName());
							}
						}, 100L);
					}
				}
			}
		}
	}

	@EventHandler
	public void onTimeLordado(final PlayerMoveEvent e) {
		if (Timelord.frozenPlayers.contains(e.getPlayer().getName())) {
			e.getPlayer().teleport((Entity) e.getPlayer());
		}
	}
}
