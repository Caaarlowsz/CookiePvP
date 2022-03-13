package me.cangasso.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.API.HorarioAPI;

public class HorasCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("horas") && args.length == 0) {
			p.sendMessage("�7Checando hor\u00e1rio atual do �a�lBrasil ");
			p.sendMessage(" ");
			p.sendMessage("�7Data e hor\u00e1rio atual: �6�l" + HorarioAPI.getHorario());
			p.sendMessage(" ");
			return true;
		}
		return false;
	}
}
