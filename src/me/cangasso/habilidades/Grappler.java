package me.cangasso.habilidades;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.cangasso.API.KitAPI;
import me.cangasso.main.Main;
import net.minecraft.server.v1_7_R4.EntityHuman;

public class Grappler implements Listener {
	public static Main plugin;
	Map<Player, Cordinha> hooks;

	public Grappler() {
		this.hooks = new HashMap<Player, Cordinha>();
	}

	@EventHandler
	public void onSlot(final PlayerItemHeldEvent e) {
		if (this.hooks.containsKey(e.getPlayer())) {
			this.hooks.get(e.getPlayer()).remove();
			this.hooks.remove(e.getPlayer());
		}
	}

	@EventHandler
	public void grapplerDamageNoLeash(final EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		final Player player = (Player) event.getEntity();
		if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (this.hooks.containsKey(player) && this.hooks.get(player).isHooked() && event.getDamage() > 3.0) {
			event.setDamage(3.0);
		}
	}

	@EventHandler
	public void onMove(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (this.hooks.containsKey(e.getPlayer())
				&& !e.getPlayer().getItemInHand().getType().equals((Object) Material.LEASH)
				&& KitAPI.getKit(p) == "Grappler") {
			this.hooks.get(e.getPlayer()).remove();
			this.hooks.remove(e.getPlayer());
		}
	}

	@EventHandler
	public void onLeash(final PlayerLeashEntityEvent e) {
		final Player p = e.getPlayer();
		if (e.getPlayer().getItemInHand().getType().equals((Object) Material.LEASH) && KitAPI.getKit(p) == "Grappler") {
			e.setCancelled(true);
			e.getPlayer().updateInventory();
			e.setCancelled(true);
			if (!this.hooks.containsKey(p)) {
				return;
			}
			if (!this.hooks.get(p).isHooked()) {
				return;
			}
			final double t;
			t = this.hooks.get(p).getBukkitEntity().getLocation().distance(p.getLocation());
			final double v_x = (1.0 + 0.07 * t)
					* (this.hooks.get(p).getBukkitEntity().getLocation().getX() - p.getLocation().getX()) / t;
			final double v_y = (1.0 + 0.03 * t)
					* (this.hooks.get(p).getBukkitEntity().getLocation().getY() - p.getLocation().getY()) / t;
			final double v_z = (1.0 + 0.07 * t)
					* (this.hooks.get(p).getBukkitEntity().getLocation().getZ() - p.getLocation().getZ()) / t;
			final Vector v = p.getVelocity();
			v.setX(v_x);
			v.setY(v_y);
			v.setZ(v_z);
			p.setVelocity(v);
		}
	}

	@EventHandler
	public void onClick(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getPlayer().getItemInHand().getType().equals((Object) Material.LEASH) && KitAPI.getKit(p) == "Grappler") {
			e.setCancelled(true);
			if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
				if (this.hooks.containsKey(p)) {
					this.hooks.get(p).remove();
				}
				final Cordinha nmsHook = new Cordinha(p.getWorld(), (EntityHuman) ((CraftPlayer) p).getHandle());
				nmsHook.spawn(p.getEyeLocation().add(p.getLocation().getDirection().getX(),
						p.getLocation().getDirection().getY(), p.getLocation().getDirection().getZ()));
				nmsHook.move(p.getLocation().getDirection().getX() * 5.0, p.getLocation().getDirection().getY() * 5.0,
						p.getLocation().getDirection().getZ() * 5.0);
				this.hooks.put(p, nmsHook);
			} else {
				if (!this.hooks.containsKey(p)) {
					return;
				}
				if (!this.hooks.get(p).isHooked()) {
					return;
				}
				final double t;
				t = this.hooks.get(p).getBukkitEntity().getLocation().distance(p.getLocation());
				final double v_x = (1.0 + 0.2 * t)
						* (this.hooks.get(p).getBukkitEntity().getLocation().getX() - p.getLocation().getX()) / t;
				final double v_y = (1.0 + 0.03 * t)
						* (this.hooks.get(p).getBukkitEntity().getLocation().getY() - p.getLocation().getY()) / t;
				final double v_z = (1.0 + 0.2 * t)
						* (this.hooks.get(p).getBukkitEntity().getLocation().getZ() - p.getLocation().getZ()) / t;
				final Vector v = p.getVelocity();
				v.setX(v_x);
				v.setY(v_y);
				v.setZ(v_z);
				p.setVelocity(v);
			}
		}
	}
}
