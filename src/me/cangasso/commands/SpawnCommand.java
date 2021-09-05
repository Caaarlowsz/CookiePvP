package me.cangasso.commands;

import me.cangasso.API.KitAPI;
import me.cangasso.API.API;
import me.cangasso.API.WarpsAPI;
import me.cangasso.scoreboard.sScoreAPI;
import me.cangasso.API.TopKillStreak;
import me.cangasso.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class SpawnCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("spawn")) {
            p.sendMessage("§fVoc\u00ea est\u00e1 sendo §6§lTELEPORTADO §fpara o Spawn!");
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 9999, 9999));
            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 9999, 9999));
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    TopKillStreak.Ks.put(p, 0);
                    Player[] onlinePlayers;
                    for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                        final Player players = onlinePlayers[i];
                        TopKillStreak.KsTop.put(p, TopKillStreak.getKsTop(players));
                        TopKillStreak.Name.put(p, TopKillStreak.getNameTop(players));
                        sScoreAPI.scoreboard(players);
                    }
                    WarpsAPI.Ir(p, "Spawn");
                    API.setWarp(p, "Spawn");
                    API.sendItems(p);
                    KitAPI.removeKits(p);
                    sScoreAPI.scoreboard(p);
                    p.removePotionEffect(PotionEffectType.SLOW);
                    p.removePotionEffect(PotionEffectType.BLINDNESS);
                    p.setHealth(20.0);
                    p.setMaxHealth(20.0);
                }
            }, 60L);
        }
        return false;
    }
}
