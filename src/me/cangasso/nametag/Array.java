package me.cangasso.nametag;

import org.bukkit.event.Event;
import java.util.Iterator;
import me.cangasso.main.Main;
import org.bukkit.Bukkit;
import java.util.LinkedHashMap;

public class Array
{
    public static LinkedHashMap<String, LinkedHashMap<String, String>> groups;
    public static LinkedHashMap<String, LinkedHashMap<String, String>> config;
    public static boolean tabListDisabled;
    public static boolean deathMessageEnabled;
    public static boolean checkForUpdatesEnabled;
    public static boolean consolePrintEnabled;
    public String permissions;
    public static String name;
    public static String type;
    public static String version;
    public String link;
    
    static {
        Array.groups = null;
        Array.config = null;
        Array.tabListDisabled = false;
        Array.deathMessageEnabled = false;
        Array.checkForUpdatesEnabled = false;
        Array.consolePrintEnabled = false;
        Array.name = "";
        Array.type = "";
        Array.version = "";
    }
    
    public Array() {
        this.permissions = "";
        this.link = "";
    }
    
    public static void InciarTag() {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                final LinkedHashMap<String, LinkedHashMap<String, String>> JogadorData2 = new LinkedHashMap<String, LinkedHashMap<String, String>>();
                if (JogadorData2 != null) {
                    for (final String JogadorNome : JogadorData2.keySet()) {
                        final LinkedHashMap<String, String> JogadorData3 = JogadorData2.get(JogadorNome);
                        String Prefix = JogadorData3.get("prefix");
                        String Suffix = JogadorData3.get("suffix");
                        if (Prefix != null) {
                            Prefix = NametagUtils.formatColors(Prefix);
                        }
                        if (Suffix != null) {
                            Suffix = NametagUtils.formatColors(Suffix);
                        }
                        NametagManager.Overlap(JogadorNome, Prefix, Suffix);
                    }
                }
            }
        });
    }
    
    public static void SetarNameTagHard(final String Jogador, final String Prefix, final String Suffix, final NameTagChangeEvento.NametagChangeReason Reac\u00e3o) {
        final NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador), NametagAPI.PegarSuffix(Jogador), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.HARD, Reac\u00e3o);
        Bukkit.getServer().getPluginManager().callEvent((Event)e);
        if (!e.isCancelled()) {
            NametagManager.Overlap(Jogador, Prefix, Suffix);
        }
    }
    
    public static void SetarNameTagSoft(final String Jogador, final String Prefix, final String Suffix, final NameTagChangeEvento.NametagChangeReason Reac\u00e3o) {
        final NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador), NametagAPI.PegarSuffix(Jogador), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.SOFT, Reac\u00e3o);
        Bukkit.getServer().getPluginManager().callEvent((Event)e);
        if (!e.isCancelled()) {
            NametagManager.Overlap(Jogador, Prefix, Suffix);
        }
    }
}
