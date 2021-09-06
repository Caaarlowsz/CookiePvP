package me.cangasso.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.API.ArraysAPI;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;

public class InvisCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("invis")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente")
					&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+")
					&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")) {
				p.sendMessage("§4§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para utilizar este comando!");
				return true;
			}
			if (args.length == 0) {
				if (ArraysAPI.Admin.contains(p)) {
					AdminCommand.setAdmin(p);
					p.sendMessage("§dVoc\u00ea est\u00e1 invis\u00edvel para todos os jogadores!");
					return true;
				}
				p.sendMessage(
						"§4§l(!) §cVoc\u00ea s\u00f3 pode alterar sua visibilidade quando estiver no modo Admin.");
				return true;
			}
		}
		return false;
	}
}
