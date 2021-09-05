package me.cangasso.commands;

import org.bukkit.Bukkit;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class GiveAllCommand implements CommandExecutor
{
    public static boolean fullkit;
    public static boolean mvp;
    public static boolean light;
    public static boolean pro;
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
            p.sendMessage("§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
            return true;
        }
        if (Args.length == 0) {
            p.sendMessage("§fUtilize §2§l/giveall §2(fullkit)§f!");
            return true;
        }
        if (!Args[0].equalsIgnoreCase("fullkit")) {
            return false;
        }
        if (GiveAllCommand.fullkit) {
            p.sendMessage("§cO FullKit j\u00e1 est\u00e1 liberado!");
            return true;
        }
        p.sendMessage("§fVoc\u00ea ativou o §2§lFULLKIT §fpara todos!");
        Bukkit.broadcastMessage("§fO benef\u00edcio de §6§lFULLKIT §ffoi ativado para todos os jogadores, aroveite!");
        return GiveAllCommand.fullkit = true;
    }
}
