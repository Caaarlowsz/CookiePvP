package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import me.cangasso.API.API;
import me.cangasso.configuração.cfGrupo;

public class TpAllCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tpall")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente")
					&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+")
					&& !cfGrupo.ChecarGrupo(p, "Mod")) {
				p.sendMessage("�c�l(!) �cVoc\u00ea não possui permissão para utilizar este comando!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("�7Voc\u00ea puxou �3�lTODOS �fos jogadores at\u00e9 voc\u00ea!");
				Bukkit.broadcastMessage(
						"�4�lALERTA �7Todos os jogadores foram teleportados para �6�l" + p.getName() + "�7.");
				API.sendWarn("�7�o[" + p.getName() + " �7�opuxou todos os jogadores]");
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player todos = onlinePlayers[i];
					if (todos != p) {
						todos.teleport((Entity) p);
					}
				}
			}
		}
		return false;
	}
}
