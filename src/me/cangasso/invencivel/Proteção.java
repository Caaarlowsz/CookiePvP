package me.cangasso.invencivel;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.entity.Player;
import java.util.HashMap;
import org.bukkit.event.Listener;

public class Prote\u00e7\u00e3o implements Listener
{
    private static HashMap<Player, ImortalEnum> imortal;
    
    static {
        Prote\u00e7\u00e3o.imortal = new HashMap<Player, ImortalEnum>();
    }
    
    @EventHandler
    public void dano(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player && e.getCause() != EntityDamageEvent.DamageCause.LAVA) {
            final Player p = (Player)e.getEntity();
            if (isImortal(p)) {
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void entityDamage(final EntityDamageByEntityEvent e) {
        final Player d = (Player)e.getEntity();
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL && isImortal(d)) {
            e.setCancelled(true);
        }
        if (e.getDamager() instanceof Player) {
            final Player p = (Player)e.getDamager();
            if (isImortal(p)) {
                e.setCancelled(true);
            }
        }
    }
    
    public static ImortalEnum getImortal(final Player p) {
        return Prote\u00e7\u00e3o.imortal.get(p);
    }
    
    public static boolean isImortal(final Player p) {
        return getImortal(p) == ImortalEnum.ON;
    }
    
    public static void setImortal(final Player p, final boolean i) {
        if (i) {
            Prote\u00e7\u00e3o.imortal.put(p, ImortalEnum.ON);
        }
        else {
            Prote\u00e7\u00e3o.imortal.put(p, ImortalEnum.OFF);
        }
    }
}
