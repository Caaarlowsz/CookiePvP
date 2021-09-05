package me.cangasso.check;

import me.cangasso.API.cfStatus;
import me.cangasso.scoreboard.sScoreAPI;
import me.cangasso.API.API;
import me.cangasso.API.KitAPI;
import me.cangasso.commands.FlyCommand;
import org.bukkit.GameMode;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.entity.Player;

public class CheckUtils
{
    public static String Grupo(final Player p) {
        if (cfGrupo.ChecarGrupo(p, "Membro")) {
            return "§7MEMBRO";
        }
        if (cfGrupo.ChecarGrupo(p, "Light")) {
            return "§aVIP";
        }
        if (cfGrupo.ChecarGrupo(p, "Mvp")) {
            return "§9MVP";
        }
        if (cfGrupo.ChecarGrupo(p, "Pro")) {
            return "§6PRO";
        }
        if (cfGrupo.ChecarGrupo(p, "S-Pro")) {
            return "§eSEMIYT";
        }
        if (cfGrupo.ChecarGrupo(p, "Youtuber")) {
            return "§bYOUTUBER";
        }
        if (cfGrupo.ChecarGrupo(p, "Youtuber+")) {
            return "§3§oYOUTUBER+";
        }
        if (cfGrupo.ChecarGrupo(p, "Helper")) {
            return "§d§oHELPER";
        }
        if (cfGrupo.ChecarGrupo(p, "Builder")) {
            return "§2BUILDER";
        }
        if (cfGrupo.ChecarGrupo(p, "Trial")) {
            return "§dTRIAL";
        }
        if (cfGrupo.ChecarGrupo(p, "Mod")) {
            return "§5§oMOD";
        }
        if (cfGrupo.ChecarGrupo(p, "Mod+")) {
            return "§5§oMOD+";
        }
        if (cfGrupo.ChecarGrupo(p, "Gerente")) {
            return "§cGERENTE";
        }
        if (cfGrupo.ChecarGrupo(p, "Admin")) {
            return "§cADMIN";
        }
        if (cfGrupo.ChecarGrupo(p, "Dono")) {
            return "§4DONO";
        }
        return "§4DONO";
    }
    
    public static String Nickname(final Player p) {
        return "§6" + p.getName();
    }
    
    public static String UUID(final Player p) {
        return "§7" + p.getUniqueId().toString();
    }
    
    public static String IP(final Player p) {
        return "§7" + p.getAddress().getHostString();
    }
    
    public static String IPReverso(final Player p) {
        return "§7" + p.getAddress().getHostName();
    }
    
    public static String GeoIP(final Player p) {
        return "§7https://www.geoiptool.com/pt/?ip=" + p.getAddress().getHostString();
    }
    
    public static String Gamemode(final Player p) {
        if (p.getGameMode() == GameMode.CREATIVE) {
            return "§9§lCRIATIVO";
        }
        if (p.getGameMode() == GameMode.SURVIVAL) {
            return "§9§lSOBREVIVENCIA";
        }
        if (p.getGameMode() == GameMode.ADVENTURE) {
            return "§9§lAVENTURA";
        }
        return "§9§lAVENTURA";
    }
    
    public static String Fly(final Player p) {
        if (FlyCommand.Fly.contains(p)) {
            return "§a§lATIVADO";
        }
        if (!FlyCommand.Fly.contains(p)) {
            return "§c§lDESATIVADO";
        }
        return "§c§lDESATIVADO";
    }
    
    public static String Vida(final Player p) {
        return "§7" + p.getHealthScale();
    }
    
    public static String Fome(final Player p) {
        return "§7" + p.getFoodLevel();
    }
    
    public static String Kit(final Player p) {
        return "§7" + KitAPI.getKitAntes(p);
    }
    
    public static String Warp(final Player p) {
        return "§7" + API.getWarp(p);
    }
    
    public static String Rank(final Player p) {
        return "§7" + sScoreAPI.getRank(p) + " " + sScoreAPI.getNomeRank(p);
    }
    
    public static String Coins(final Player p) {
        return "§7" + cfStatus.getMoney(p);
    }
    
    public static String Kills(final Player p) {
        return "§7" + cfStatus.getKills(p);
    }
    
    public static String Deaths(final Player p) {
        return "§7" + cfStatus.getDeaths(p);
    }
    
    public static String KillStreak(final Player p) {
        return "§7" + cfStatus.getKillStreak(p);
    }
}
