package me.cangasso.commands;

import org.bukkit.Bukkit;
import me.cangasso.API.ArraysAPI;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class VisCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("vis")) {
            if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")) {
                p.sendMessage("§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
                return true;
            }
            if (args.length == 0) {
                if (!ArraysAPI.Admin.contains(p)) {
                    p.sendMessage("§cVoc\u00ea s\u00f3 pode utilizar este comando quando no modo admin.");
                    return true;
                }
                final Player[] onlinePlayers;
                if ((onlinePlayers = Bukkit.getOnlinePlayers()).length != 0) {
                    final Player todos = onlinePlayers[0];
                    todos.showPlayer(p);
                    p.showPlayer(todos);
                    p.sendMessage("§6§lVIS: §fVoc\u00ea est\u00e1 vis\u00edvel para todos os jogadores");
                    return true;
                }
            }
        }
        return false;
    }
}
