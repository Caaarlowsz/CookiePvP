package me.cangasso.jumps;

import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.util.Vector;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.player.PlayerMoveEvent;
import java.util.ArrayList;
import org.bukkit.event.Listener;

public class Diamante implements Listener
{
    public static ArrayList<String> jump;
    
    static {
        Diamante.jump = new ArrayList<String>();
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void aoMove(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.DIAMOND_BLOCK) {
            Diamante.jump.remove(p.getName());
            final Location loc = e.getTo().getBlock().getLocation();
            final Vector sponge = p.getLocation().getDirection().multiply(0).setY(4);
            p.setVelocity(sponge);
            p.playSound(loc, Sound.HORSE_JUMP, 6.0f, 1.0f);
            p.playEffect(loc, Effect.ENDER_SIGNAL, (Object)null);
            Diamante.jump.add(p.getName());
        }
    }
    
    @EventHandler
    public void aoQueda(final EntityDamageEvent e) {
        final Player p = (Player)e.getEntity();
        if (e.getEntity() instanceof Player && e.getCause().equals((Object)EntityDamageEvent.DamageCause.FALL) && Diamante.jump.contains(p.getName())) {
            e.setCancelled(true);
            Diamante.jump.remove(p.getName());
        }
    }
}
