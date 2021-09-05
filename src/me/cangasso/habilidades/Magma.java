package me.cangasso.habilidades;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.EventHandler;
import me.cangasso.API.KitAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.Listener;

public class Magma implements Listener
{
    @EventHandler
    public void damage(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (KitAPI.getKit(p) == "Magma" && (e.getCause() == EntityDamageEvent.DamageCause.LAVA || e.getCause() == EntityDamageEvent.DamageCause.FIRE || e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)) {
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void snailEventd(final EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player)) {
            return;
        }
        final Player player = (Player)event.getDamager();
        final Player player2 = (Player)event.getEntity();
        if (KitAPI.getKit(player) != "Magma") {
            return;
        }
        if (Math.random() > 0.5 && Math.random() < 0.4) {
            player2.setFireTicks(150);
        }
    }
}
