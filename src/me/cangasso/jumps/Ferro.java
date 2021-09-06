package me.cangasso.jumps;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class Ferro implements Listener {
	public static ArrayList<String> jump;

	static {
		Ferro.jump = new ArrayList<String>();
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void aoMove(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.IRON_BLOCK) {
			Ferro.jump.remove(p.getName());
			final Location loc = e.getTo().getBlock().getLocation();
			final Vector sponge = p.getLocation().getDirection().multiply(0).setY(2);
			p.setVelocity(sponge);
			p.playSound(loc, Sound.HORSE_JUMP, 6.0f, 1.0f);
			p.playEffect(loc, Effect.ENDER_SIGNAL, (Object) null);
			Ferro.jump.add(p.getName());
		}
	}

	@EventHandler
	public void aoQueda(final EntityDamageEvent e) {
		final Player p = (Player) e.getEntity();
		if (e.getEntity() instanceof Player && e.getCause().equals((Object) EntityDamageEvent.DamageCause.FALL)
				&& Ferro.jump.contains(p.getName())) {
			e.setCancelled(true);
			Ferro.jump.remove(p.getName());
		}
	}
}
