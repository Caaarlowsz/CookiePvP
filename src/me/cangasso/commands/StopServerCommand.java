package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.configuração.cfGrupo;

public class StopServerCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("stopserver")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") || !p.isOp()) {
				p.sendMessage("�c�l(!) �cVoc\u00ea não possui permissão para executar este comando!");
				return true;
			}
			Player[] onlinePlayers;
			for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
				final Player todos = onlinePlayers[i];
				todos.kickPlayer(
						"�6�lCookie�f�lNetwork\n�c�lSERVIDOR FECHADO!\n    �7Podemos estar fechando por v\u00e1rios motivos,\n  �7mas com certeza estamos fazendo algo\n�7em função de sua jogatina.\n �7Esperamos a compreensão de todos.\n�7[Att. �6�lCookie�f�lNetwork�7]");
			}
			Bukkit.shutdown();
		}
		return false;
	}
}
