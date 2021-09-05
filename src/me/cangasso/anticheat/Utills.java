package me.cangasso.anticheat;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.Bukkit;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import java.util.HashMap;

public class Utills
{
    public static HashMap<Player, Integer> FastAttackClicks;
    public static HashMap<Player, Integer> MacroClicks;
    public static ArrayList<Player> fly;
    public static String FastAttack;
    public static String Forcefield;
    public static String Macro;
    public static String Fly;
    public static String Speed;
    public static String ForjandoAutoSoup;
    public static String AutoSoup;
    public static HashMap<Player, Integer> ClicksFastClicks;
    public static HashMap<Player, Integer> ClicksMacro;
    public static HashMap<Player, Integer> AvisosForcefield;
    public static HashMap<Player, Integer> AvisosFastClick;
    public static HashMap<Player, Integer> AvisosFly;
    public static HashMap<Player, Integer> AvisosSpeed;
    public static HashMap<Player, Integer> AvisosMacro;
    public static HashMap<Player, Integer> AvisosAutoSoup;
    
    static {
        Utills.FastAttackClicks = new HashMap<Player, Integer>();
        Utills.MacroClicks = new HashMap<Player, Integer>();
        Utills.fly = new ArrayList<Player>();
        Utills.FastAttack = null;
        Utills.Forcefield = null;
        Utills.Macro = null;
        Utills.Fly = null;
        Utills.Speed = null;
        Utills.ForjandoAutoSoup = null;
        Utills.AutoSoup = null;
        Utills.ClicksFastClicks = new HashMap<Player, Integer>();
        Utills.ClicksMacro = new HashMap<Player, Integer>();
        Utills.AvisosForcefield = new HashMap<Player, Integer>();
        Utills.AvisosFastClick = new HashMap<Player, Integer>();
        Utills.AvisosFly = new HashMap<Player, Integer>();
        Utills.AvisosSpeed = new HashMap<Player, Integer>();
        Utills.AvisosMacro = new HashMap<Player, Integer>();
        Utills.AvisosAutoSoup = new HashMap<Player, Integer>();
    }
    
    public static void sendAntiCheat(final String Menssagem) {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player playeres = onlinePlayers[i];
            if (cfGrupo.ChecarGrupo(playeres, "Dono") || cfGrupo.ChecarGrupo(playeres, "Helper") || cfGrupo.ChecarGrupo(playeres, "Gerente") || cfGrupo.ChecarGrupo(playeres, "Admin") || cfGrupo.ChecarGrupo(playeres, "Mod+") || cfGrupo.ChecarGrupo(playeres, "Mod") || cfGrupo.ChecarGrupo(playeres, "Trial") || cfGrupo.ChecarGrupo(playeres, "Youtuber+")) {
                playeres.sendMessage(Menssagem);
            }
        }
    }
    
    public static boolean Flight(final Player playeres) {
        return playeres.getGameMode() == GameMode.CREATIVE || playeres.getAllowFlight();
    }
    
    public static boolean Speeding(final Player playeres) {
        return playeres.getGameMode() == GameMode.CREATIVE || playeres.getAllowFlight();
    }
    
    public static void setPlayer(final Player player) {
        Utills.AvisosFastClick.put(player, 1);
        Utills.AvisosMacro.put(player, 1);
        Utills.AvisosFly.put(player, 1);
        Utills.AvisosSpeed.put(player, 1);
        Utills.AvisosForcefield.put(player, 1);
        Utills.AvisosAutoSoup.put(player, 1);
        Utills.ClicksFastClicks.put(player, 1);
        Utills.ClicksMacro.put(player, 1);
    }
    
    public enum Hack
    {
        FASTCLICKTALVEZ("FASTCLICKTALVEZ", 0, ChatColor.DARK_RED + "§c(AntiCheat) §c" + "nick" + " est\u00e1 clicando r\u00e1pido demais! (CPS: clicks) (" + "avisos" + ")."), 
        FASTCLICKPROVAVELMENTE("FASTCLICKPROVAVELMENTE", 1, ChatColor.DARK_RED + "§c(AntiCheat) §c" + "nick" + " est\u00e1 clicando r\u00e1pido demais! (CPS: clicks) (" + "avisos" + ")."), 
        FASTCLICKDEFINITIVAMENTE("FASTCLICKDEFINITIVAMENTE", 2, ChatColor.DARK_RED + "§c(AntiCheat) §c" + "nick" + " est\u00e1 clicando r\u00e1pido demais! (CPS: clicks) (" + "avisos" + ")."), 
        MACROTALVEZ("MACROTALVEZ", 3, ChatColor.DARK_RED + "§c(AntiCheat) §c" + "nick" + " est\u00e1 utilizando Macro (CPS: clicks) (" + "avisos" + ")."), 
        MACROPROVAVELMENTE("MACROPROVAVELMENTE", 4, ChatColor.DARK_RED + "§c(AntiCheat) §c" + "nick" + " est\u00e1 utilizando Macro (CPS: clicks) (" + "avisos" + ")."), 
        MACRODEFINITIVAMENTE("MACRODEFINITIVAMENTE", 5, ChatColor.DARK_RED + "§c(AntiCheat) §c" + "nick" + " est\u00e1 utilizando Macro (CPS: clicks) (" + "avisos" + ")."), 
        FORCEFIELDTALVEZ("FORCEFIELDTALVEZ", 6, ChatColor.DARK_RED + "§c(AntiCheat) §c" + "nick" + " est\u00e1 utilizando Forcefield (" + "avisos" + ")."), 
        FORCEFIELDPROVAVELMENTE("FORCEFIELDPROVAVELMENTE", 7, ChatColor.DARK_RED + "§c(AntiCheat) §c" + "nick" + " est\u00e1 utilizando Forcefield (" + "avisos" + ")."), 
        FORCEFIELDDEFINITIVAMENTE("FORCEFIELDDEFINITIVAMENTE", 8, ChatColor.DARK_RED + "§c(AntiCheat) §c" + "nick" + " est\u00e1 utilizando Forcefield (" + "avisos" + ")."), 
        FLY("FLY", 9, ChatColor.DARK_RED + "§c(AntiCheat) §c" + "nick" + " est\u00e1 utilizando Flight (" + "avisos" + ")."), 
        SPEED("SPEED", 10, ChatColor.DARK_RED + "§c(AntiCheat) §c" + "nick" + " est\u00e1 utilizando Speed (" + "avisos" + ")."), 
        AUTOSOUPTALVEZ("AUTOSOUPTALVEZ", 11, ChatColor.DARK_RED + "§c(AntiCheat) §c" + "nick" + " est\u00e1 utilizando AUTOSOUP (" + "avisos" + ")."), 
        AUTOSOUPPROVAVELMENTE("AUTOSOUPPROVAVELMENTE", 12, ChatColor.DARK_RED + "§c(AntiCheat)" + "nick" + " est\u00e1 utilizando AUTOSOUP (" + "avisos" + ")."), 
        AUTOSOUPDEFINITIVAMENTE("AUTOSOUPDEFINITIVAMENTE", 13, ChatColor.DARK_RED + "§c(AntiCheat) §c" + "nick" + " est\u00e1 utilizando AUTOSOUP (" + "avisos" + ").");
        
        private String Menssagem;
        
        private Hack(final String s, final int n, final String Menssagem) {
            this.Menssagem = Menssagem;
        }
        
        public String getMenssagem() {
            return this.Menssagem;
        }
    }
}
