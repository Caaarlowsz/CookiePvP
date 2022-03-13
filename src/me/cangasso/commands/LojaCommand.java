package me.cangasso.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.bans.API;

public class LojaCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("loja") || cmd.getName().equalsIgnoreCase("store")) && args.length == 0) {
			API.sendMsg((CommandSender) p, " ");
			API.sendMsg((CommandSender) p,
					"�6�lCookie�f�lNetwork �7� �fCompre pacotes de �a�lVIP �fou �6�lKITS �facessando: �6�lmc-cookie.com.br");
			API.sendMsg((CommandSender) p, " ");
		}
		return false;
	}
}
