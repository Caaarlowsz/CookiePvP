package me.cangasso.habilidades;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import me.cangasso.API.CooldownAPI;
import me.cangasso.API.KitAPI;

public class Hulk implements Listener {
	@EventHandler
	public void hulk(final PlayerInteractEntityEvent event) {
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p = event.getPlayer();
		final Player r = (Player) event.getRightClicked();
		if (p.getItemInHand().getType() == Material.AIR && KitAPI.getKit(p) == "Hulk"
				&& !CooldownAPI.Cooldown.containsKey(p.getName()) && p.getPassenger() == null
				&& r.getPassenger() == null) {
			p.setPassenger((Entity) r);
			CooldownAPI.addCooldown(p, 15);
			return;
		}
		if (p.getItemInHand().getType() == Material.AIR && KitAPI.getKit(p) == "Hulk"
				&& CooldownAPI.Cooldown.containsKey(p.getName()) && p.getPassenger() == null
				&& r.getPassenger() == null) {
			p.sendMessage("§8§l<§e§l!§8§l> §7Seu cooldown acaba em " + CooldownAPI.Cooldown + " §7segundos!");
		}
	}

	@EventHandler
	public static void playerInteract(final PlayerInteractEvent event) {
		if (!event.getAction().equals((Object) Action.LEFT_CLICK_AIR)) {
			return;
		}
		final Player player = event.getPlayer();
		if (player.getPassenger() == null || !(player.getPassenger() instanceof Player)) {
			return;
		}
		final Player pass = (Player) player.getPassenger();
		player.eject();
		pass.damage(0.0, (Entity) player);
		pass.setVelocity(new Vector(pass.getVelocity().getX(), 1.0, pass.getVelocity().getZ()));
	}
}
