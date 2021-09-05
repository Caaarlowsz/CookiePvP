package me.cangasso.API;

import me.cangasso.main.Main;
import org.bukkit.Bukkit;
import java.util.concurrent.TimeUnit;
import org.bukkit.entity.Player;
import java.util.HashMap;

public class CooldownAPI
{
    public static HashMap<String, Long> Cooldown;
    
    static {
        CooldownAPI.Cooldown = new HashMap<String, Long>();
    }
    
    public static void addCooldown(final Player jogador, final int Tempo) {
        CooldownAPI.Cooldown.put(jogador.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(Tempo));
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                CooldownAPI.tirarCooldown(jogador);
            }
        }, (long)(Tempo * 20));
    }
    
    public static void tirarCooldown(final Player p) {
        CooldownAPI.Cooldown.remove(p.getName());
    }
    
    public static boolean SemCooldown(final Player p) {
        return !CooldownAPI.Cooldown.containsKey(p.getName()) || CooldownAPI.Cooldown.get(p.getName()) <= System.currentTimeMillis();
    }
    
    public static long Cooldown(final Player p) {
        final long tempo = TimeUnit.MILLISECONDS.toSeconds(CooldownAPI.Cooldown.get(p.getName()) - System.currentTimeMillis());
        if (CooldownAPI.Cooldown.containsKey(p.getName()) || CooldownAPI.Cooldown.get(p.getName()) > System.currentTimeMillis()) {
            return tempo;
        }
        return 0L;
    }
}
