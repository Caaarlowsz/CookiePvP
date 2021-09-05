package me.cangasso.commands;

import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.cangasso.API.ArraysAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

public class SpecCommand implements CommandExecutor
{
    public static void setON(final Player p) {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player todos = onlinePlayers[i];
            if (ArraysAPI.Admin.contains(todos) && !ArraysAPI.Spec.contains(p) && todos != p) {
                p.hidePlayer(todos);
            }
        }
    }
    
    public static void setOFF(final Player p) {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player todos = onlinePlayers[i];
            if (ArraysAPI.Admin.contains(todos) && ArraysAPI.Spec.contains(p)) {
                p.showPlayer(todos);
                todos.showPlayer(p);
            }
        }
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")) {
            p.sendMessage("§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
            return true;
        }
        if (Args.length == 0) {
            p.sendMessage("§cUse §c§l/spec §c(on | off)");
            return true;
        }
        if (!Args[0].equalsIgnoreCase("on")) {
            if (Args[0].equalsIgnoreCase("off")) {
                p.sendMessage("§a§lSPEC §7Os espectadores foram: §cDESATIVADOS");
                ArraysAPI.Spec.remove(p);
                setON(p);
            }
            return false;
        }
        if (ArraysAPI.Spec.contains(p)) {
            p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 com os specs ativados");
            return true;
        }
        p.sendMessage("§a§lSPEC §7Os espectadores foram: §aATIVADOS");
        ArraysAPI.Spec.add(p);
        setOFF(p);
        return false;
    }
}
