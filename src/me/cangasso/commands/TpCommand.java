package me.cangasso.commands;

import org.bukkit.Bukkit;
import me.cangasso.API.API;
import org.bukkit.Location;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class TpCommand implements CommandExecutor
{
    private boolean CheckarNumero(final String Numero) {
        try {
            Integer.parseInt(Numero);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("tp")) {
            if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Helper")) {
                p.sendMessage("§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
                return true;
            }
            if (Args.length == 0) {
                p.sendMessage("§6§lTELEPORT §fUtilize §6§l/tp §f(jogador) (alvo) §6| §6§l[X] [Y] [Z]");
                return true;
            }
            if (Args.length > 2 || Args.length == 3) {
                if (!this.CheckarNumero(Args[0])) {
                    p.sendMessage("§c\u00c9 necess\u00e1rio utilizar apenas n\u00fameros para teleportar para uma §c§lcoordenada.");
                    return true;
                }
                final Integer X = Integer.parseInt(Args[0]);
                if (Args.length == 1) {
                    p.sendMessage("§6§lTELEPORT §fUtilize §6§l/tp §f(jogador) (alvo) §6| §6§l[X] [Y] [Z]");
                    return true;
                }
                if (!this.CheckarNumero(Args[1])) {
                    p.sendMessage("§c\u00c9 necess\u00e1rio utilizar apenas n\u00fameros para teleportar para uma §c§lcoordenada.");
                    return true;
                }
                final Integer Y = Integer.parseInt(Args[1]);
                if (Args.length == 2) {
                    p.sendMessage("§c\u00c9 necess\u00e1rio utilizar apenas n\u00fameros para teleportar para uma §c§lcoordenada.");
                    return true;
                }
                if (!this.CheckarNumero(Args[2])) {
                    p.sendMessage("§c\u00c9 necess\u00e1rio utilizar apenas n\u00fameros para teleportar para uma §c§lcoordenada.");
                    return true;
                }
                final Integer Z = Integer.parseInt(Args[2]);
                p.teleport(new Location(p.getWorld(), (double)X, (double)Y, (double)Z));
                p.sendMessage("§7Voc\u00ea foi §6§lTELEPORTADO §7at\u00e9 as coordenadas: §6§l" + X + " " + Y + " " + Z);
                API.sendWarn("§7§o[" + p.getName() + " teleportou-se para §7§o" + X + " " + Y + " " + Z + "§7§o]");
                return true;
            }
            else {
                final Player t = Bukkit.getPlayerExact(Args[0]);
                if (t == null || !(t instanceof Player)) {
                    return true;
                }
                if (Args.length > 1) {
                    if (Args.length == 1) {
                        return true;
                    }
                    final Player t2 = Bukkit.getPlayer(Args[1]);
                    t.teleport(t2.getLocation());
                    p.sendMessage("§aVoc\u00ea teleportou §a§l " + t.getName() + " §aat\u00e9 voc\u00ea!");
                    API.sendWarn("§7§o[" + p.getName() + " puxou o jogador " + t.getName() + "§7§o]");
                    return true;
                }
                else {
                    p.teleport(t.getLocation());
                    p.sendMessage("§6§lTELEPORT §fVoc\u00ea foi teleportado at\u00e9 o jogador: §6§l" + t.getName());
                    API.sendWarn("§7§o[" + p.getName() + " teleportou-se para " + t.getName() + "§7§o]");
                }
            }
        }
        return false;
    }
}
