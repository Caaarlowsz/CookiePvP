package me.cangasso.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.API.HatAPI;
import me.cangasso.bans.API;
import me.cangasso.configuração.cfGrupo;

public class cRemoveHead implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("removerhead") || cmd.getName().equalsIgnoreCase("removerhat")
				|| cmd.getName().equalsIgnoreCase("removehead") || cmd.getName().equalsIgnoreCase("removehat")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente")
					&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+")
					&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")
					&& !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber")
					&& !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro")
					&& !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
				p.sendMessage("�c�l(!) �cVoc\u00ea não possui permissão para executar este comando!");
				return true;
			}
			HatAPI.removeHat(p);
			API.sendSound(p, Sound.LEVEL_UP, 10);
			p.sendMessage("�aCabeça removida com sucesso!");
		}
		return false;
	}
}
