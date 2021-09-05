package me.cangasso.scoreboard;

import me.cangasso.API.KitAPI;
import me.cangasso.check.CheckUtils;
import net.md_5.bungee.api.ChatColor;
import me.cangasso.configura\u00e7\u00e3o.cfStatus;
import org.bukkit.entity.Player;
import java.util.ArrayList;

public class sScoreAPI
{
    public static ArrayList<Player> Score;
    public static ArrayList<Player> Delay;
    
    static {
        sScoreAPI.Score = new ArrayList<Player>();
        sScoreAPI.Delay = new ArrayList<Player>();
    }
    
    public static String getRank(final Player p) {
        final double a = cfStatus.getKills(p);
        if (a <= 100.0) {
            return "§f\u268a";
        }
        if (a <= 200.0) {
            return ChatColor.GREEN + "\u268c";
        }
        if (a <= 300.0) {
            return ChatColor.YELLOW + "\u2630";
        }
        if (a <= 400.0) {
            return "§1\u2725";
        }
        if (a <= 500.0) {
            return "§7\u272f";
        }
        if (a <= 600.0) {
            return "§6\u272a";
        }
        if (a <= 700.0) {
            return ChatColor.AQUA + "§b\u2748";
        }
        if (a <= 800.0) {
            return "§2\u2738";
        }
        if (a <= 900.0) {
            return ChatColor.RED + "\u2739";
        }
        if (a <= 1000.0) {
            return "§3\u2737";
        }
        if (a <= 1500.0) {
            return "§4\u2742";
        }
        return "§4\u2742";
    }
    
    public static String getRankConfig(final Player p) {
        final double a = cfStatus.getKills(p);
        if (a <= 100.0) {
            return "§fNOOB";
        }
        if (a <= 200.0) {
            return "§aINICIANTE";
        }
        if (a <= 300.0) {
            return "§eAPRENDIZ";
        }
        if (a <= 400.0) {
            return "§1EXPERT";
        }
        if (a <= 500.0) {
            return "§7SILVER";
        }
        if (a <= 600.0) {
            return "§6GOLD";
        }
        if (a <= 700.0) {
            return "§bDIAMOND";
        }
        if (a <= 800.0) {
            return "§2EMERALD";
        }
        if (a <= 900.0) {
            return "§cRUBY";
        }
        if (a <= 1000.0) {
            return "§3SAFIRA";
        }
        if (a <= 1500.0) {
            return "§4LENDARIO";
        }
        return "§4LENDARIO";
    }
    
    public static String getNomeRank(final Player p) {
        final double a = cfStatus.getKills(p);
        if (a <= 100.0) {
            return "§fNOOB";
        }
        if (a <= 200.0) {
            return "§aINICIANTE";
        }
        if (a <= 300.0) {
            return "§eAPRENDIZ";
        }
        if (a <= 400.0) {
            return "§1EXPERT";
        }
        if (a <= 500.0) {
            return "§7SILVER";
        }
        if (a <= 600.0) {
            return "§6GOLD";
        }
        if (a <= 700.0) {
            return "§bDIAMOND";
        }
        if (a <= 800.0) {
            return "§2EMERALD";
        }
        if (a <= 900.0) {
            return "§CRUBY";
        }
        if (a <= 1000.0) {
            return "§3SAFIRA";
        }
        if (a <= 1500.0) {
            return "§4LENDARIO";
        }
        return "§4LENDARIO";
    }
    
    public static String getNomeRankConfig(final Player p) {
        final double a = cfStatus.getKills(p);
        if (a <= 100.0) {
            return "§fNOOB";
        }
        if (a <= 200.0) {
            return "§aINICIANTE";
        }
        if (a <= 300.0) {
            return "§eAPRENDIZ";
        }
        if (a <= 400.0) {
            return "§1EXPERT";
        }
        if (a <= 500.0) {
            return "§7SILVER";
        }
        if (a <= 600.0) {
            return "§6GOLD";
        }
        if (a <= 700.0) {
            return "§bDIAMOND";
        }
        if (a <= 800.0) {
            return "§2EMERALD";
        }
        if (a <= 900.0) {
            return "§cRUBY";
        }
        if (a <= 1000.0) {
            return "§3SAFIRA";
        }
        if (a <= 1500.0) {
            return "§4LENDARIO";
        }
        return "§4LENDARIO";
    }
    
    public static void scoreboard(final Player p) {
        final uScore scoreboard = new uScore("§6§l> §e§lKITPVP §6§l<");
        scoreboard.addLine("    §7pvp.mc-cookie.com.br", 12);
        scoreboard.addLine("", 11);
        scoreboard.addLine(" §7Grupo: " + CheckUtils.Grupo(p), 10);
        scoreboard.addLine(" §7XP: §b" + cfStatus.getMoney(p), 9);
        scoreboard.addLine(" §7Elo: " + getRank(p) + " " + getNomeRank(p), 8);
        scoreboard.addLine(" §b ", 7);
        scoreboard.addLine(" §7Kills: §b" + cfStatus.getKills(p), 6);
        scoreboard.addLine(" §7Deaths: §b" + cfStatus.getDeaths(p), 5);
        scoreboard.addLine(" §7KillStreak: §b" + cfStatus.getKillStreak(p), 4);
        scoreboard.addLine("§g ", 3);
        scoreboard.addLine(" §7Kit: §b" + KitAPI.getKitAntes(p), 2);
        scoreboard.addLine(" ", 1);
        if (sScoreAPI.Score.contains(p)) {
            scoreboard.setScoreboard();
            p.setScoreboard(scoreboard.getScoreboard());
        }
        else {
            scorenull(p);
        }
    }
    
    public static void scorenull(final Player p) {
        final uScore scoreboard = new uScore("");
        scoreboard.setScoreboard();
        p.setScoreboard(scoreboard.getScoreboard());
    }
}
