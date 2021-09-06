package me.cangasso.habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import me.cangasso.API.CooldownAPI;
import me.cangasso.API.KitAPI;
import me.cangasso.main.Main;

public class Sumo implements Listener {
	public ArrayList<String> Cima;
	private ArrayList<Block> remover;

	public Sumo() {
		this.Cima = new ArrayList<String>();
		this.remover = new ArrayList<Block>();
	}

	@EventHandler
	public void Clicar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p instanceof Player) {
			p.getItemInHand().equals((Object) 260);
			if (!e.getAction().name().contains("RIGHT")) {
				return;
			}
			if (p.getItemInHand().getTypeId() == 260 && KitAPI.getKit(p) == "Sumo") {
				if (Gladiator.noExecut.contains(p)) {
					return;
				}
				e.setCancelled(true);
				if (!CooldownAPI.Cooldown.containsKey(p.getName())) {
					Location Local = e.getPlayer().getLocation();
					Local = Local.getWorld().getHighestBlockAt(Local).getLocation().add(0.0, 22.0, 0.0);
					for (int x = 0; x <= 0; ++x) {
						for (int z = 0; z <= 0; ++z) {
							final Block a = Local.add((double) x, 0.0, (double) z).getBlock();
							a.setType(Material.DIRT);
							e.getPlayer().teleport(Local.add(0.0, 1.0, 0.0));
							CooldownAPI.addCooldown(p, 35);
							this.Cima.add(p.getName());
							Bukkit.getServer().getScheduler().runTaskLater(Main.getPlugin(), (Runnable) new Runnable() {
								@Override
								public void run() {
									a.setType(Material.AIR);
									Sumo.this.remover.remove(a);
								}
							}, 50L);
						}
					}
				} else {
					p.sendMessage("§8§l<§e§l!§8§l> §7Seu cooldown acaba em " + CooldownAPI.Cooldown + " §7segundos!");
				}
			}
		}
	}

	@EventHandler
	public void Cair(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL && this.Cima.contains(p.getName())) {
			e.setCancelled(true);
			for (final Entity Altura : p.getNearbyEntities(8.0, 8.0, 8.0)) {
				if (Altura instanceof Player) {
					final Player Pular = (Player) Altura;
					final Vector v = p.getLocation().getDirection().multiply(0).setY(2.0);
					Pular.setVelocity(v);
				}
			}
			this.Cima.remove(p.getName());
			e.setDamage(9.0);
		}
	}
}
