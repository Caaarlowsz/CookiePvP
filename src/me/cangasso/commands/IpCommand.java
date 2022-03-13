package me.cangasso.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.bans.API;

public class IpCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("ip") || cmd.getName().equalsIgnoreCase("servidor")) && args.length == 0) {
			API.sendMsg((CommandSender) p, " ");
			API.sendMsg((CommandSender) p, "�7Voc\u00ea est\u00e1 conectado ao: �b�lpvp.mc-cookie.com.br ");
			API.sendMsg((CommandSender) p, " ");
		}
		return false;
	}
}
