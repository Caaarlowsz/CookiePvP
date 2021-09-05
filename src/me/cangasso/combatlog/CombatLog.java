package me.cangasso.combatlog;

import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import me.cangasso.configura\u00e7\u00e3o.cfStatus;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.EventHandler;
import me.cangasso.main.Main;
import org.bukkit.Bukkit;
import me.cangasso.scoreboard.sScoreAPI;
import me.cangasso.API.API;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.event.Listener;

public class CombatLog implements Listener
{
    public static ArrayList<Player> combat;
    
    static {
        CombatLog.combat = new ArrayList<Player>();
    }
    
    public static String getCombat(final Player p) {
        if (CombatLog.combat.contains(p)) {
            return "§a§lSIM";
        }
        if (!CombatLog.combat.contains(p)) {
            return "§c§lNAO";
        }
        return "§c§lNAO";
    }
    
    @EventHandler
    public void aoHitar(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player k = (Player)e.getDamager();
            if (API.getWarp(p) != "Spawn" && API.getWarp(k) != "Spawn") {
                if (!CombatLog.combat.contains(p)) {
                    CombatLog.combat.add(p);
                    sScoreAPI.scoreboard(p);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            CombatLog.combat.remove(p);
                            sScoreAPI.scoreboard(p);
                        }
                    }, 200L);
                }
                if (!CombatLog.combat.contains(k)) {
                    CombatLog.combat.add(k);
                    sScoreAPI.scoreboard(k);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            CombatLog.combat.remove(k);
                            sScoreAPI.scoreboard(k);
                        }
                    }, 200L);
                }
            }
        }
    }
    
    @EventHandler
    public void aoSair(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (CombatLog.combat.contains(p)) {
            cfStatus.setDeaths(p);
        }
    }
    
    @EventHandler
    public void aoComando(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        if (CombatLog.combat.contains(p) && !e.getMessage().contains("/report") && !cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Helper")) {
            e.setCancelled(true);
        }
    }
}
