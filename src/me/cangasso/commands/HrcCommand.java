package me.cangasso.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.bans.API;

public class HrcCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("hrc") || cmd.getName().equalsIgnoreCase("hackreportchat"))
				&& args.length == 0) {
			API.sendMsg((CommandSender) p, "§6§m>-------------------------<");
			API.sendMsg((CommandSender) p, "               §6» §f§lHRC §6«     ");
			API.sendMsg((CommandSender) p, "§6§m>-------------------------<");
			API.sendMsg((CommandSender) p, " ");
			API.sendMsg((CommandSender) p,
					"§6§lHRC §fO HRC \u00e9 um chat via §b§lSkype §fdesenvolvido com o intuito de recrutar jogadores para que enviem den\u00fancias ao chat.");
			API.sendMsg((CommandSender) p, "");
			API.sendMsg((CommandSender) p, "§6\u2022 §fAplica\u00e7\u00e3o para o HRC: §7http://bit.ly/APPHrcCN");
			API.sendMsg((CommandSender) p, " ");
			API.sendMsg((CommandSender) p,
					"§c§lOBS: §fCaso voc\u00ea seja §a§lAPROVADO§f, ser\u00e1 contatado por um membro da equipe!");
			API.sendMsg((CommandSender) p, "");
			API.sendMsg((CommandSender) p, "§6§m>-------------------------<");
		}
		return false;
	}
}
