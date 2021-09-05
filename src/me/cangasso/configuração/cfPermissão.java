package me.cangasso.configura\u00e7\u00e3o;

import org.bukkit.entity.Player;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.IOException;
import org.bukkit.plugin.Plugin;
import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;

public class cfPermiss\u00e3o
{
    private static FileConfiguration player_permissao;
    private static File playerpermissao;
    
    public static void setarconfig(final Plugin plugin) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }
        cfPermiss\u00e3o.playerpermissao = new File(plugin.getDataFolder(), "permiss\u00f5es.yml");
        if (cfPermiss\u00e3o.playerpermissao.exists()) {
            try {
                cfPermiss\u00e3o.playerpermissao.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        cfPermiss\u00e3o.player_permissao = (FileConfiguration)YamlConfiguration.loadConfiguration(cfPermiss\u00e3o.playerpermissao);
    }
    
    public static FileConfiguration pegarpermissao() {
        return cfPermiss\u00e3o.player_permissao;
    }
    
    public static void salvarconfiguracao() {
        try {
            cfPermiss\u00e3o.player_permissao.save(cfPermiss\u00e3o.playerpermissao);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void setarPermissao(final Player p, final String Permissao, final String trueoufalse) {
        pegarpermissao().set("permiss\u00f5es." + p.getUniqueId() + ".Nick", (Object)p.getName());
        pegarpermissao().set("permiss\u00f5es." + p.getUniqueId() + "." + Permissao, (Object)trueoufalse);
        salvarconfiguracao();
    }
    
    public static boolean getPermissao(final Player p, final String Permissao) {
        return pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + "." + Permissao).equals("true");
    }
}
