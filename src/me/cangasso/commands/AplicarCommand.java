package me.cangasso.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.bans.API;

public class AplicarCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("aplicar") || cmd.getName().equalsIgnoreCase("virarstaff"))
				&& args.length == 0) {
			API.sendMsg((CommandSender) p, "�9�m>-------------------------<");
			API.sendMsg((CommandSender) p, "            �6� �f�lAPLICAR �6�              ");
			API.sendMsg((CommandSender) p, "�9�m>-------------------------<");
			API.sendMsg((CommandSender) p, " ");
			API.sendMsg((CommandSender) p, "�6\u2022 �fAplique-se para �5�lTRIAL �facessando: �c�o(Indispon\u00edvel)");
			API.sendMsg((CommandSender) p,
					"�6\u2022 �fAplique-se para �e�lHELPER �facessando: �c�o(Indispon\u00edvel)");
			API.sendMsg((CommandSender) p,
					"�6\u2022 �fAplique-se para �2�lBUILDER �facessando: �c�o(Indispon\u00edvel)");
			API.sendMsg((CommandSender) p,
					"�6\u2022 �fAplique-se para o �6�lHRC �facessando: �7http://bit.ly/APPHrcCN");
			API.sendMsg((CommandSender) p, "");
			API.sendMsg((CommandSender) p,
					"�fN\u00e3o sabe o que \u00e9 �6�lHRC�f? Use �8�o/hrc �fpar mais informa\u00e7\u00f5es!");
			API.sendMsg((CommandSender) p, "");
			API.sendMsg((CommandSender) p,
					"�4�lATENCAO: �fAo solicitar a leitura de sua aplica\u00e7\u00e3o, suas chances s\u00e3o reduzidas em �c�l15%�f!");
			API.sendMsg((CommandSender) p, " ");
			API.sendMsg((CommandSender) p,
					"�6\u2022 �7Atualiza\u00e7\u00f5es da equipe em tempo real: �bhttps://twitter.com/CookieStaff_");
			API.sendMsg((CommandSender) p, "�9�m>-------------------------<");
		}
		return false;
	}
}
