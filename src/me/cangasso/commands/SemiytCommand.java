package me.cangasso.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.bans.API;

public class SemiytCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("semiyt") || cmd.getName().equalsIgnoreCase("semiyt"))
				&& args.length == 0) {
			API.sendMsg((CommandSender) p, "�e�m>-------------------------<");
			API.sendMsg((CommandSender) p, "               �6� �f�lSEMIYT �6�     ");
			API.sendMsg((CommandSender) p, "�e�m>-------------------------<");
			p.sendMessage("");
			p.sendMessage("�fTer no m\u00ednimo �3�l3.000 �finscritos.");
			p.sendMessage("�fTer um v\u00eddeo no servidor, de no m\u00ednimo �a�l3 minutos�f.");
			p.sendMessage("�fTer um feedback aceit\u00e1vel.");
			p.sendMessage("");
			p.sendMessage(
					"�6�lCOMO ENTRAR EM CONTATO? �fVoc\u00ea pode entrar em contato conosco pelo Twitter �3�o@Cookie_Suporte �fe solicitar sua tag. Caso a sua solicita\u00e7\u00e3o for aceita, voc\u00ea receber\u00e1 a tag, juntamente as permiss\u00f5es em 48 horas.");
			p.sendMessage("");
			p.sendMessage("�fUse �b�l/youtuber �fe �6�l/pro");
			p.sendMessage("");
			API.sendMsg((CommandSender) p, "�e�m>-------------------------<");
		}
		return false;
	}
}
