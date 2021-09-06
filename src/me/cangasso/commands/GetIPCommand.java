package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.bans.API;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;

public class GetIPCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("getip")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente")
					&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+")
					&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")) {
				API.sendMsg((CommandSender) p,
						"§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg((CommandSender) p, "§fUtilize §8§l/getip §8(jogador)§f.");
				API.sendSound(p, Sound.NOTE_PLING, 10);
				return true;
			}
			final Player ip = Bukkit.getPlayer(args[0]);
			if (ip == null) {
				API.sendMsg((CommandSender) p, "§7O jogador §6§l " + args[0] + " est\u00e1 offline!");
				API.sendSound(p, Sound.NOTE_PLING, 10);
				return true;
			}
			if (ip != null) {
				API.sendMsg((CommandSender) p, "§6\u27a2 §aChecando informa\u00e7\u00f5es de: §6§l" + ip.getName());
				API.sendMsg((CommandSender) p, " ");
				API.sendMsg((CommandSender) p, "§a§lIP: §7" + ip.getAddress().getHostString());
				API.sendMsg((CommandSender) p, "§a§lIP §8(reverso): §7" + ip.getAddress().getHostName());
				return true;
			}
		}
		return false;
	}
}
