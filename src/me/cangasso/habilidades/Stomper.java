package me.cangasso.habilidades;

import org.bukkit.Location;
import org.bukkit.util.Vector;
import org.bukkit.Sound;
import me.cangasso.API.CooldownAPI;
import org.bukkit.event.block.Action;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import java.util.Iterator;
import org.bukkit.entity.Entity;
import me.cangasso.API.KitAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.Listener;

public class Stomper implements Listener
{
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerStomp(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (KitAPI.getKit(p) == "Stomper") {
            for (final Entity ent : p.getNearbyEntities(3.0, 3.0, 3.0)) {
                if (!(ent instanceof Player)) {
                    continue;
                }
                final Player plr = (Player)ent;
                if (e.getDamage() <= 4.0) {
                    e.setCancelled(true);
                    return;
                }
                if (plr.isSneaking()) {
                    plr.damage(6.0, (Entity)p);
                }
                else {
                    plr.damage(e.getDamage(), (Entity)p);
                    plr.getKiller();
                }
            }
            e.setDamage(4.0);
        }
    }
    
    @EventHandler
    public void stomperApple(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (event.getPlayer().getItemInHand().getType() == Material.GOLDEN_APPLE && KitAPI.getKit(p) == "Stomper" && (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)) {
            event.setCancelled(true);
            if (CooldownAPI.Cooldown.containsKey(p.getName())) {
                p.sendMessage("§fO seu §3§lCOOLDOWN §facaba em: §c§l" + CooldownAPI.Cooldown(p) + "s");
            }
            else {
                final Vector vector = p.getEyeLocation().getDirection();
                vector.multiply(0.0f);
                vector.setY(6.0f);
                p.setVelocity(vector);
                final Location loc = p.getLocation();
                p.getWorld().playSound(loc, Sound.ENDERMAN_TELEPORT, 5.0f, -5.0f);
                CooldownAPI.addCooldown(p, 45);
            }
        }
    }
}
