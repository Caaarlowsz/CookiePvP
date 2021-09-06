package me.cangasso.anticheat.hacks;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.cangasso.anticheat.Utills;

public class ForceField implements Listener {
	@EventHandler
	private void onEntityDamageByEntityEvent(final EntityDamageByEntityEvent Evento) {
		if (!(Evento.getDamager() instanceof Player)) {
			return;
		}
		if (!(Evento.getEntity() instanceof LivingEntity)) {
			return;
		}
		final Player Jogador = (Player) Evento.getDamager();
		final Utills.Hack ForcefieldTalvez = Utills.Hack.FORCEFIELDTALVEZ;
		final Utills.Hack ForcefieldProvavelmente = Utills.Hack.FORCEFIELDPROVAVELMENTE;
		final Utills.Hack ForcefieldDefinitivamente = Utills.Hack.FORCEFIELDDEFINITIVAMENTE;
		if (Evento.getEntity() instanceof LivingEntity && Evento.getDamager() instanceof Player) {
			if (Evento.getEntity().getLocation().distance(Jogador.getLocation()) > 6.7) {
				Utills.Forcefield = ForcefieldDefinitivamente.getMenssagem().replace("nick", Jogador.getName())
						.replace("avisos", new StringBuilder().append(Utills.AvisosForcefield.get(Jogador)).toString());
				if (Utills.Forcefield != null) {
					Utills.AvisosForcefield.put(Jogador, Utills.AvisosForcefield.get(Jogador) + 1);
					Utills.sendAntiCheat(Utills.Forcefield);
				}
				Utills.Forcefield = null;
			} else if (Evento.getEntity().getLocation().distance(Jogador.getLocation()) > 6.5) {
				Utills.Forcefield = ForcefieldProvavelmente.getMenssagem().replace("nick", Jogador.getName())
						.replace("avisos", new StringBuilder().append(Utills.AvisosForcefield.get(Jogador)).toString());
				if (Utills.Forcefield != null) {
					Utills.AvisosForcefield.put(Jogador, Utills.AvisosForcefield.get(Jogador) + 1);
					Utills.sendAntiCheat(Utills.Forcefield);
				}
				Utills.Forcefield = null;
			} else if (Evento.getEntity().getLocation().distance(Jogador.getLocation()) > 6.0) {
				Utills.Forcefield = ForcefieldTalvez.getMenssagem().replace("nick", Jogador.getName()).replace("avisos",
						new StringBuilder().append(Utills.AvisosForcefield.get(Jogador)).toString());
				if (Utills.Forcefield != null) {
					Utills.AvisosForcefield.put(Jogador, Utills.AvisosForcefield.get(Jogador) + 1);
					Utills.sendAntiCheat(Utills.Forcefield);
				}
				Utills.Forcefield = null;
			}
		}
	}
}
