package me.cangasso.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.bans.API;

public class RankCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("rank") || cmd.getName().equalsIgnoreCase("liga")) && args.length == 0) {
			API.sendMsg((CommandSender) p, " ");
			API.sendMsg((CommandSender) p,
					"�8�l<�c�l!�8�l> �c�lComando desativado temporariamente para atualiza\u00e7\u00f5es!");
			API.sendMsg((CommandSender) p, " ");
		}
		return false;
	}
}
