package me.cangasso.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class YoutuberCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("youtuber")) {
			p.sendMessage("§b§m>-------------------------<");
			p.sendMessage("               §6» §f§lYOUTUBER §6«     ");
			p.sendMessage("§b§m>-------------------------<");
			p.sendMessage("");
			p.sendMessage("§fTer no m\u00ednimo §3§l4.000 §finscritos.");
			p.sendMessage("§fTer um v\u00eddeo no servidor, de no m\u00ednimo §a§l3 minutos§f.");
			p.sendMessage("§fTer um feedback aceit\u00e1vel.");
			p.sendMessage("");
			p.sendMessage(
					"§6§lCOMO ENTRAR EM CONTATO? §fVoc\u00ea pode entrar em contato conosco pelo Twitter §3§o@Cookie_Suporte §fe solicitar sua tag. Caso a sua solicita\u00e7\u00e3o for aceita, voc\u00ea receber\u00e1 a tag, juntamente as permiss\u00f5es em 48 horas.");
			p.sendMessage("");
			p.sendMessage("§fUse §e§l/semiyt §fe §6§l/pro§f!");
			p.sendMessage("");
			p.sendMessage("§b§m>-------------------------<");
		} else if (Cmd.getName().equalsIgnoreCase("batata")) {
			p.sendMessage(" ");
			p.sendMessage("§7Os requisitos para obter a tag §e§lSEMIYT §7s\u00e3o:");
			p.sendMessage(" ");
			p.sendMessage("§6\u2022 §7Possuir no m\u00ednimo §6§l1.000 §7inscritos;");
			p.sendMessage("§6\u2022 §7Possuir uma feedback aceit\u00e1vel;");
			p.sendMessage("§6\u2022 §7Possuir uma m\u00e9dia de likes aceit\u00e1vel;");
			p.sendMessage("§6\u2022 §7Possuir no m\u00ednimo um v\u00eddeo no servidor;");
			p.sendMessage(" ");
			p.sendMessage(
					"§7Para solicitar a tag \u00e9 simples. Entre em contato atrav\u00e9s do Twitter §b§o@Cookie_Suporte");
		}
		return false;
	}
}
