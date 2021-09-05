package me.cangasso.configura\u00e7\u00e3o;

import org.bukkit.configuration.file.YamlConfiguration;
import java.io.IOException;
import org.bukkit.plugin.Plugin;
import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;

public class WarpsConfig
{
    public static WarpsConfig pasta;
    FileConfiguration Warps;
    File FileWarps;
    
    static {
        WarpsConfig.pasta = new WarpsConfig();
    }
    
    public static WarpsConfig getConfig() {
        return WarpsConfig.pasta;
    }
    
    public void ConfigEnable(final Plugin plugin) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }
        this.FileWarps = new File(plugin.getDataFolder(), "warps.yml");
        if (this.FileWarps.exists()) {
            try {
                this.FileWarps.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.Warps = (FileConfiguration)YamlConfiguration.loadConfiguration(this.FileWarps);
    }
    
    public FileConfiguration config() {
        return this.Warps;
    }
    
    public void saveConfigs() {
        try {
            this.Warps.save(this.FileWarps);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public class Warps
    {
    }
}
