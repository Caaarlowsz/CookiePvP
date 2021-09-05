package me.cangasso.habilidades;

import org.bukkit.event.EventHandler;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import me.cangasso.API.KitAPI;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.Listener;

public class Fisherman implements Listener
{
    @EventHandler
    public void onPlayerFish(final PlayerFishEvent e) {
        final Player p = e.getPlayer();
        final Entity caught = e.getCaught();
        final Block block = e.getHook().getLocation().getBlock();
        if (caught != null && caught != block && KitAPI.getKit(p) == "Fisherman") {
            caught.teleport(p.getPlayer().getLocation());
        }
    }
}
