package me.cangasso.commands;

import org.bukkit.Bukkit;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class RemoveAllCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("removeall")) {
            if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
                p.sendMessage("§6§lCookie§f§lNetwork §7» §fVoc\u00ea n\u00e3o possui permiss\u00e3o para utilizar este comando.");
                return true;
            }
            if (Args.length == 0) {
                p.sendMessage("§fUse §2§l/removeall <fullkit>§f!");
                return true;
            }
            if (Args[0].equalsIgnoreCase("fullkit")) {
                if (GiveAllCommand.fullkit) {
                    p.sendMessage("§cVoc\u00ea removeu o FullKit de todos os jogadores!");
                    Bukkit.broadcastMessage("§fO benef\u00edcio de §6§lFULLKIT §ffoi removido!");
                    GiveAllCommand.fullkit = false;
                    return true;
                }
                p.sendMessage("§cO benef\u00edcio FullKit n\u00e3o est\u00e1 liberado!");
            }
        }
        return false;
    }
}
