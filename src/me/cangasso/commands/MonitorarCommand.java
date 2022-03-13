package me.cangasso.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.API.ArraysAPI;
import me.cangasso.configuração.cfGrupo;

public class MonitorarCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("monitorar")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
				p.sendMessage("�cVoc\u00ea não possui permissão para utilizar este comando.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("�cUso correto: /monitorar <on | off>.");
				return true;
			}
			if (args[0].equalsIgnoreCase("on")) {
				ArraysAPI.Monitor.add(p);
				cfGrupo.ChecarGrupo(p, "Dono");
				p.sendMessage("�dVoc\u00ea entrou no modo MONITOR");
				p.sendMessage("�dVoc\u00ea est\u00e1 invis\u00edvel para GERENTE e abaixo!");
				return true;
			}
			if (args[0].equalsIgnoreCase("off")) {
				ArraysAPI.Monitor.remove(p);
				p.sendMessage("�5�oVoc\u00ea saiu do modo MONITOR");
				p.sendMessage("�5�oVoc\u00ea est\u00e1 vis\u00edvel para todos os jogadores!");
				return true;
			}
		}
		return false;
	}
}
