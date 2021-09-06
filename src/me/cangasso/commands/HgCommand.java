package me.cangasso.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.bans.API;

public class HgCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("hg") || cmd.getName().equalsIgnoreCase("hungergames"))
				&& args.length == 0) {
			API.sendMsg((CommandSender) p, "§cNenhum servidor de HardcoreGames foi encontrado!");
		}
		return false;
	}
}
