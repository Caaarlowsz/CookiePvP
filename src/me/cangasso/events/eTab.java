package me.cangasso.events;

import org.bukkit.event.EventHandler;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PlayerConnection;
import net.minecraft.server.v1_7_R4.Packet;
import org.spigotmc.ProtocolInjector;
import me.cangasso.configura\u00e7\u00e3o.cfStatus;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import me.cangasso.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

public class eTab implements Listener
{
    private static int VERSION;
    
    static {
        eTab.VERSION = 47;
    }
    
    @EventHandler
    void TabDoServidor(final PlayerJoinEvent evento) {
        final Player jogador = evento.getPlayer();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final PlayerConnection connect = ((CraftPlayer)jogador).getHandle().playerConnection;
                final IChatBaseComponent top = ChatSerializer.a("{'extra': [{text: '', color: 'aqua'}],'color': gold, 'text': '    §e§m------------------------------- §f     \n  §e§l> §6§lCookie§f§lNetwork §e§l<\n     '}");
                final IChatBaseComponent bottom = ChatSerializer.a("{'extra': [{'color': 'aqua', 'text': ' \n      §f§lKills: §7" + cfStatus.getKills(jogador) + "  §7-  §f§lDeaths: §7" + cfStatus.getDeaths(jogador) + "§7  -  §f§lKillStreak: §7" + cfStatus.getKillStreak(jogador) + "\n" + "§f§lJogadores: §7" + Bukkit.getOnlinePlayers().length + "§7/§7120" + "  §7-  §f§lPing: §7" + ((CraftPlayer)jogador).getHandle().ping + "  §7-  §f§lXP: §b§l" + cfStatus.getMoney(jogador) + "\n" + "\n" + "    §f§lLoja: §7§ohttp://mc-cookie.com.br\n     §f§lTwitter: §7§ohttps://twitter.com/_McCookie" + "\n" + "    §e§m--------------------------------" + "', 'underline': 'true'}], 'color': 'gold', 'text': ''}");
                if (((CraftPlayer)jogador).getHandle().playerConnection.networkManager.getVersion() < eTab.VERSION) {
                    return;
                }
                connect.sendPacket((Packet)new ProtocolInjector.PacketTabHeader(top, bottom));
            }
        }, 1L, 20L);
    }
}
