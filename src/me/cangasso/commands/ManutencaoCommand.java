package me.cangasso.commands;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import me.cangasso.bans.Config;
import org.bukkit.Bukkit;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class ManutencaoCommand implements CommandExecutor, Listener
{
    public static boolean manutencao;
    
    static {
        ManutencaoCommand.manutencao = false;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("manutencao")) {
            if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
                p.sendMessage("�c�l(!) �cVoc\u00ea nao possui permissao para executar este comando.");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("�6�lCookie�f�lNetwork �f� �fUse �c�l/manutencao (on | off)");
                return true;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("on")) {
                    if (ManutencaoCommand.manutencao) {
                        p.sendMessage("�cO modo manuten\u00e7\u00e3o j\u00e1 est\u00e1 ativado!");
                        return true;
                    }
                    ManutencaoCommand.manutencao = true;
                    p.sendMessage("�fVoc\u00ea �a�lATIVOU �fo modo manuten\u00e7\u00e3o!");
                    Player[] onlinePlayers;
                    for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                        final Player todos = onlinePlayers[i];
                        if (!cfGrupo.ChecarGrupo(todos, "Dono") && !cfGrupo.ChecarGrupo(todos, "Gerente") && !cfGrupo.ChecarGrupo(todos, "Admin")) {
                            todos.kickPlayer("�c�lSERVIDOR FECHADO!\n   �7O servidor acabou de ser fechado para manuten\u00e7\u00f5es\nAssim que poss\u00edvel, n\u00f3s estaremos de volta!\n�7Atenciosamente, CookieNetwork.");
                            return true;
                        }
                    }
                    Config.getConfig().saveManutencao();
                    return true;
                }
                else if (args[0].equalsIgnoreCase("off")) {
                    if (!ManutencaoCommand.manutencao) {
                        p.sendMessage("�cO modo manuten\u00e7\u00e3o j\u00e1 est\u00e1 desativado!");
                        return true;
                    }
                    ManutencaoCommand.manutencao = false;
                    p.sendMessage("�fVoc\u00ea �c�lDESATIVOU �fo modo manuten\u00e7\u00e3o!");
                    return true;
                }
            }
        }
        return false;
    }
    
    @EventHandler
    public void aoEntrarManutencao(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        if (ManutencaoCommand.manutencao && !cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin")) {
            e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "�c�lMANUTENCAO...\n�7O servidor est\u00e1 em manuten\u00e7\u00e3o. Estamos com certeza aprimorando\n�7a sua jogatina. Contamos com a compreens\u00e3o de todos\n�7Atenciosamente, �6�lCookie�f�lNetwork");
        }
    }
}
