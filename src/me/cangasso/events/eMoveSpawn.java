package me.cangasso.events;

import org.bukkit.event.EventHandler;
import me.cangasso.configura\u00e7\u00e3o.cfConfig;
import me.cangasso.scoreboard.sScoreAPI;
import me.cangasso.API.KitAPI;
import me.cangasso.API.ArraysAPI;
import me.cangasso.API.API;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.Listener;

public class eMoveSpawn implements Listener
{
    @EventHandler
    public void passou(final EntityDamageEvent e) {
        final Player p = (Player)e.getEntity();
        if (e.getCause().equals((Object)EntityDamageEvent.DamageCause.FALL) && API.getWarp(p) == "Spawn" && !ArraysAPI.Admin.contains(p)) {
            if (KitAPI.getKitAntes(p) == "PvP") {
                KitAPI.darKit(p, "PvP");
                KitAPI.setKit(p, "PvP");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "FireLauncher") {
                KitAPI.darKit(p, "FireLauncher");
                KitAPI.setKit(p, "FireLauncher");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Strong") {
                KitAPI.darKit(p, "Strong");
                KitAPI.setKit(p, "Strong");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Forcefield") {
                KitAPI.darKit(p, "Forcefield");
                KitAPI.setKit(p, "Forcefield");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Sumo") {
                KitAPI.darKit(p, "Sumo");
                KitAPI.setKit(p, "Sumo");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "PvP") {
                KitAPI.setKitAntes(p, "PvP");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "PvP");
                KitAPI.setKit(p, "PvP");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Archer") {
                KitAPI.setKitAntes(p, "Archer");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Archer");
                KitAPI.setKit(p, "Archer");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "FireLauncher") {
                KitAPI.setKitAntes(p, "FireLauncher");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "FireLauncher");
                KitAPI.setKit(p, "FireLauncher");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Strong") {
                KitAPI.setKitAntes(p, "Strong");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Strong");
                KitAPI.setKit(p, "Strong");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Forcefield") {
                KitAPI.setKitAntes(p, "Forcefield");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Forcefield");
                KitAPI.setKit(p, "Forcefield");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Sumo") {
                KitAPI.setKitAntes(p, "Sumo");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Sumo");
                KitAPI.setKit(p, "Sumo");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Kangaroo") {
                KitAPI.setKitAntes(p, "Kangaroo");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Kangaroo");
                KitAPI.setKit(p, "Kangaroo");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Fisherman") {
                KitAPI.setKitAntes(p, "Fisherman");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Fisherman");
                KitAPI.setKit(p, "Fisherman");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Cactus") {
                KitAPI.setKitAntes(p, "Cactus");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Cactus");
                KitAPI.setKit(p, "Cactus");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Monk") {
                KitAPI.setKitAntes(p, "Monk");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Monk");
                KitAPI.setKit(p, "Monk");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Ninja") {
                KitAPI.setKitAntes(p, "Ninja");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Ninja");
                KitAPI.setKit(p, "Ninja");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Phantom") {
                KitAPI.setKitAntes(p, "Phantom");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Phantom");
                KitAPI.setKit(p, "Phantom");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Grappler") {
                KitAPI.setKitAntes(p, "Grappler");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Grappler");
                KitAPI.setKit(p, "Grappler");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Viper") {
                KitAPI.setKitAntes(p, "Viper");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Viper");
                KitAPI.setKit(p, "Viper");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Snail") {
                KitAPI.setKitAntes(p, "Snail");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Snail");
                KitAPI.setKit(p, "Snail");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Hulk") {
                KitAPI.setKitAntes(p, "Hulk");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Hulk");
                KitAPI.setKit(p, "Hulk");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Timelord") {
                KitAPI.setKitAntes(p, "Timelord");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Timelord");
                KitAPI.setKit(p, "Timelord");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Thor") {
                KitAPI.setKitAntes(p, "Thor");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Thor");
                KitAPI.setKit(p, "Thor");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Switcher") {
                KitAPI.setKitAntes(p, "Switcher");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Switcher");
                KitAPI.setKit(p, "Switcher");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Gladiator") {
                KitAPI.setKitAntes(p, "Gladiator");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Gladiator");
                KitAPI.setKit(p, "Gladiator");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Stomper") {
                KitAPI.setKitAntes(p, "Stomper");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Stomper");
                KitAPI.setKit(p, "Stomper");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Magma") {
                KitAPI.setKitAntes(p, "Magma");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Magma");
                KitAPI.setKit(p, "Magma");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Grandpa") {
                KitAPI.setKitAntes(p, "Grandpa");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Grandpa");
                KitAPI.setKit(p, "Grandpa");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Nenhum" && cfConfig.pegarconfig().get("configura\u00e7\u00e3o." + p.getUniqueId() + ".PadraoKit") == "Ajnin") {
                KitAPI.setKitAntes(p, "Ajnin");
                sScoreAPI.scoreboard(p);
                KitAPI.darKit(p, "Ajnin");
                KitAPI.setKit(p, "Ajnin");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Archer") {
                KitAPI.darKit(p, "Archer");
                KitAPI.setKit(p, "Archer");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Kangaroo") {
                KitAPI.darKit(p, "Kangaroo");
                KitAPI.setKit(p, "Kangaroo");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Fisherman") {
                KitAPI.darKit(p, "Fisherman");
                KitAPI.setKit(p, "Fisherman");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Cactus") {
                KitAPI.darKit(p, "Cactus");
                KitAPI.setKit(p, "Cactus");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Monk") {
                KitAPI.darKit(p, "Monk");
                KitAPI.setKit(p, "Monk");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Ninja") {
                KitAPI.darKit(p, "Ninja");
                KitAPI.setKit(p, "Ninja");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Phantom") {
                KitAPI.darKit(p, "Phantom");
                KitAPI.setKit(p, "Phantom");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Grappler") {
                KitAPI.darKit(p, "Grappler");
                KitAPI.setKit(p, "Grappler");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Viper") {
                KitAPI.darKit(p, "Viper");
                KitAPI.setKit(p, "Viper");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Snail") {
                KitAPI.darKit(p, "Snail");
                KitAPI.setKit(p, "Snail");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Hulk") {
                KitAPI.darKit(p, "Hulk");
                KitAPI.setKit(p, "Hulk");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Timelord") {
                KitAPI.darKit(p, "Timelord");
                KitAPI.setKit(p, "Timelord");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Thor") {
                KitAPI.darKit(p, "Thor");
                KitAPI.setKit(p, "Thor");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Switcher") {
                KitAPI.darKit(p, "Switcher");
                KitAPI.setKit(p, "Switcher");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Gladiator") {
                KitAPI.darKit(p, "Gladiator");
                KitAPI.setKit(p, "Gladiator");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Stomper") {
                KitAPI.darKit(p, "Stomper");
                KitAPI.setKit(p, "Stomper");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Magma") {
                KitAPI.darKit(p, "Magma");
                KitAPI.setKit(p, "Magma");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Grandpa") {
                KitAPI.darKit(p, "Grandpa");
                KitAPI.setKit(p, "Grandpa");
                sScoreAPI.scoreboard(p);
                return;
            }
            if (KitAPI.getKitAntes(p) == "Ajnin") {
                KitAPI.darKit(p, "Ajnin");
                KitAPI.setKit(p, "Ajnin");
                sScoreAPI.scoreboard(p);
            }
        }
    }
}
