package me.cangasso.habilidades;

import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.Effect;
import me.cangasso.API.KitAPI;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.Listener;

public class Switcher implements Listener
{
    @EventHandler
    public void snowball(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Snowball && e.getEntity() instanceof Player) {
            final Snowball s = (Snowball)e.getDamager();
            if (s.getShooter() instanceof Player) {
                final Player shooter = (Player)s.getShooter();
                if (KitAPI.getKit(shooter) == "Switcher") {
                    final Location shooterLoc = shooter.getLocation();
                    shooter.teleport(e.getEntity().getLocation());
                    e.getEntity().teleport(shooterLoc);
                    shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.ENDER_SIGNAL, 10);
                    shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.EXTINGUISH, 10);
                    shooter.getWorld().playSound(shooter.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.2f);
                }
            }
        }
    }
}
