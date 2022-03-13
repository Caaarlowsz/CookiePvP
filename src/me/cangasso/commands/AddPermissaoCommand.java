package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.bans.API;
import me.cangasso.configuração.cfGrupo;
import me.cangasso.configuração.cfPermissão;

public class AddPermissaoCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("addpermission")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
				API.sendMsg((CommandSender) p,
						"�c�l(!) �cVoc\u00ea não possui permissão para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("�7Utilize �a�l/addpermission �7(jogador) (permissão)");
				return true;
			}
			if (args.length == 1) {
				p.sendMessage("�7Utilize �a�l/addpermission �7(jogador) (permissão)");
				return true;
			}
			final Player k = Bukkit.getPlayer(args[0]);
			final String permissao = args[1];
			cfPermissão.setarPermissao(k, permissao, "true");
			p.sendMessage("�7Permissão �6�l" + permissao + " �7adicionada ao jogador �6�l" + k.getName());
		}
		if (cmd.getName().equalsIgnoreCase("removepermission")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
				API.sendMsg((CommandSender) p,
						"�c�l(!) �cVoc\u00ea não possui permissão para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("�7Utilize �c�l/removepermission �7(jogador) (permissão)");
				return true;
			}
			if (args.length == 1) {
				p.sendMessage("�7Utilize �c�l/removepermission �7(jogador) (permissão)");
				return true;
			}
			final Player k = Bukkit.getPlayer(args[0]);
			final String permissao = args[1];
			cfPermissão.setarPermissao(k, permissao, "false");
			p.sendMessage("�7Permissão �6�l" + permissao + " �7retirada do jogador �6�l" + k.getName());
		}
		return false;
	}
}
