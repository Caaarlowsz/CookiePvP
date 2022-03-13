package me.cangasso.habilidades;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.cangasso.API.CooldownAPI;
import me.cangasso.API.KitAPI;

public class Thor implements Listener {
	@EventHandler
	public void ThorKit(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.GOLD_AXE && e.getAction() == Action.RIGHT_CLICK_BLOCK
				&& KitAPI.getKit(p) == "Thor") {
			if (CooldownAPI.Cooldown.containsKey(p.getName())) {
				p.sendMessage("�8�l<�e�l!�8�l> �7Seu cooldown acaba em " + CooldownAPI.Cooldown + " �7segundos!");
				return;
			}
			CooldownAPI.addCooldown(p, 5);
			final Location loc = p.getTargetBlock(null, 25).getLocation();
			p.getWorld().strikeLightning(loc);
			e.setCancelled(true);
			p.damage(0.0);
		}
	}
}
