package me.cangasso.invencivel;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class Proteção implements Listener {
	private static HashMap<Player, ImortalEnum> imortal;

	static {
		Proteção.imortal = new HashMap<Player, ImortalEnum>();
	}

	@EventHandler
	public void dano(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player && e.getCause() != EntityDamageEvent.DamageCause.LAVA) {
			final Player p = (Player) e.getEntity();
			if (isImortal(p)) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void entityDamage(final EntityDamageByEntityEvent e) {
		final Player d = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL && isImortal(d)) {
			e.setCancelled(true);
		}
		if (e.getDamager() instanceof Player) {
			final Player p = (Player) e.getDamager();
			if (isImortal(p)) {
				e.setCancelled(true);
			}
		}
	}

	public static ImortalEnum getImortal(final Player p) {
		return Proteção.imortal.get(p);
	}

	public static boolean isImortal(final Player p) {
		return getImortal(p) == ImortalEnum.ON;
	}

	public static void setImortal(final Player p, final boolean i) {
		if (i) {
			Proteção.imortal.put(p, ImortalEnum.ON);
		} else {
			Proteção.imortal.put(p, ImortalEnum.OFF);
		}
	}
}
