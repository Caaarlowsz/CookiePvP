package me.cangasso.commands;

import me.cangasso.API.WarpsAPI;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class SetCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("set")) {
            if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Builder")) {
                p.sendMessage("§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("§7Use §6§l/set <local>§7!");
                p.sendMessage("§aAlguns locais... ");
                p.sendMessage(" ");
                p.sendMessage("§a-> §6Spawn");
                p.sendMessage("§a-> §6loc1");
                p.sendMessage("§a-> §6loc2");
                p.sendMessage("§a-> §6loc3");
                p.sendMessage("§a-> §6loc4");
                p.sendMessage("§a-> §6loc5");
                p.sendMessage("§a-> §6Parkour");
                p.sendMessage("§a-> §6Villagerparkour");
                p.sendMessage("§a-> §6Fps");
                p.sendMessage("§a-> §61v1loc1");
                p.sendMessage("§a-> §61v1loc2");
                p.sendMessage("§a-> §6Challenge");
                p.sendMessage("§a-> §6Fisherman");
                return true;
            }
            if (args[0].equalsIgnoreCase("spawn")) {
                WarpsAPI.Set(p, "Spawn");
                p.sendMessage("§7O §6§lSpawn §7foi setado com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("loc1")) {
                WarpsAPI.Set(p, "Loc1");
                p.sendMessage("§7O §6§lLoc1 §7foi setado com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("loc2")) {
                WarpsAPI.Set(p, "Loc2");
                p.sendMessage("§7O §6§lLoc2 §7foi setado com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("loc3")) {
                WarpsAPI.Set(p, "Loc3");
                p.sendMessage("§7O §6§lLoc3 §7§7foi setado com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("loc4")) {
                WarpsAPI.Set(p, "Loc4");
                p.sendMessage("§7O §6§lLoc4 §7foi setado com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("loc5")) {
                WarpsAPI.Set(p, "Loc5");
                p.sendMessage("§7O §6§lLoc5 §7foi setado com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("parkour")) {
                WarpsAPI.Set(p, "Parkour");
                p.sendMessage("§7O §6§lParkour §7foi setado com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("villagerparkour")) {
                WarpsAPI.Set(p, "VillagerParkour");
                p.sendMessage("§7O §6§lVillagerParkour §7foi setado com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("fps")) {
                WarpsAPI.Set(p, "Fps");
                p.sendMessage("§7A §6§lFps §7foi setada com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("1v1")) {
                WarpsAPI.Set(p, "1v1");
                p.sendMessage("§7A §6§l1v1 §7foi setada com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("1v1loc1")) {
                WarpsAPI.Set(p, "1v1loc1");
                p.sendMessage("§7O §6§l1v1Loc1 §7foi setado com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("1v1loc2")) {
                WarpsAPI.Set(p, "1v1loc2");
                p.sendMessage("§7O §6§l1v1Loc2 §7foi setado com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("challenge")) {
                WarpsAPI.Set(p, "Challenge");
                p.sendMessage("§7A Warp §6§lLavaChallenge §7foi setada com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("knockback")) {
                WarpsAPI.Set(p, "Knockback");
                p.sendMessage("§7A Warp §6§lKnockback §7foi setada com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("main")) {
                WarpsAPI.Set(p, "Main");
                p.sendMessage("§7A Warp §6§lMain §7foi setada com sucesso!");
                return true;
            }
            if (args[0].equalsIgnoreCase("fisherman")) {
                WarpsAPI.Set(p, "Fisherman");
                p.sendMessage("§7A Warp §6§lFisherman §7foi setada com sucesso!");
                return true;
            }
        }
        return false;
    }
}
