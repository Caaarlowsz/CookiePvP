package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import me.cangasso.bans.API;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;

public class TpHereCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (!cmd.getName().equalsIgnoreCase("tphere") && !cmd.getName().equalsIgnoreCase("s")) {
			return false;
		}
		if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin")
				&& !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")
				&& !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Helper")) {
			p.sendMessage("§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
			return true;
		}
		if (args.length == 0) {
			p.sendMessage("§cUse §c§l/tphere §cou §c§l/s §cpara puxar um jogador at\u00e9 voc\u00ea!");
			return true;
		}
		final Player k = Bukkit.getPlayer(args[0]);
		if (k == null) {
			API.sendMsg((CommandSender) p, "§7O jogador §a§l" + args[0] + " §7est\u00e1 offline!");
			return true;
		}
		k.teleport((Entity) p);
		p.sendMessage("§7Voc\u00ea puxou o jogador §a§l" + k.getName() + " §7at\u00e9 voc\u00ea!");
		me.cangasso.API.API.sendWarn("§7§o[" + p.getName() + " puxou o jogador " + k.getName() + "§7§o]");
		return true;
	}
}
