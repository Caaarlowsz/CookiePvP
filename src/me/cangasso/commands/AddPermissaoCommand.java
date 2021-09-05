package me.cangasso.commands;

import me.cangasso.configura\u00e7\u00e3o.cfPermiss\u00e3o;
import org.bukkit.Bukkit;
import me.cangasso.bans.API;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class AddPermissaoCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("addpermission")) {
            if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
                API.sendMsg((CommandSender)p, "§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("§7Utilize §a§l/addpermission §7(jogador) (permiss\u00e3o)");
                return true;
            }
            if (args.length == 1) {
                p.sendMessage("§7Utilize §a§l/addpermission §7(jogador) (permiss\u00e3o)");
                return true;
            }
            final Player k = Bukkit.getPlayer(args[0]);
            final String permissao = args[1];
            cfPermiss\u00e3o.setarPermissao(k, permissao, "true");
            p.sendMessage("§7Permiss\u00e3o §6§l" + permissao + " §7adicionada ao jogador §6§l" + k.getName());
        }
        if (cmd.getName().equalsIgnoreCase("removepermission")) {
            if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
                API.sendMsg((CommandSender)p, "§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("§7Utilize §c§l/removepermission §7(jogador) (permiss\u00e3o)");
                return true;
            }
            if (args.length == 1) {
                p.sendMessage("§7Utilize §c§l/removepermission §7(jogador) (permiss\u00e3o)");
                return true;
            }
            final Player k = Bukkit.getPlayer(args[0]);
            final String permissao = args[1];
            cfPermiss\u00e3o.setarPermissao(k, permissao, "false");
            p.sendMessage("§7Permiss\u00e3o §6§l" + permissao + " §7retirada do jogador §6§l" + k.getName());
        }
        return false;
    }
}
