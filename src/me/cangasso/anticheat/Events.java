package me.cangasso.anticheat;

import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

public class Events implements Listener
{
    @EventHandler
    private void onPlayerJoinEvent(final PlayerJoinEvent event) {
        if (!(event.getPlayer() instanceof Player)) {
            return;
        }
        final Player player = event.getPlayer();
        Utills.setPlayer(player);
    }
}
