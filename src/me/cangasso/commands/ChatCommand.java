package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import me.cangasso.configuração.cfGrupo;

public class ChatCommand implements CommandExecutor, Listener {
	public static boolean pausado;

	static {
		ChatCommand.pausado = false;
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		if (Cmd.getName().equalsIgnoreCase("chat")) {
			final Player p = (Player) Sender;
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente")
					&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+")
					&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")
					&& !cfGrupo.ChecarGrupo(p, "Youtuber+")) {
				p.sendMessage("�4�l(!) �cVoc\u00ea não possui permissão para executar este comando!");
				return true;
			}
			if (Args.length == 0) {
				p.sendMessage(" �7Utilize alguns dos argumentos:");
				p.sendMessage(" ");
				p.sendMessage("�f- �3�lCLEAR �8(Para limpar o chat)");
				p.sendMessage("�f- �3�lON �8(Para ativar o chat)");
				p.sendMessage("�f- �3�lOFF �8(Para desativar o chat)");
				return true;
			}
			if (Args[0].equalsIgnoreCase("clear")) {
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage(
						"�6�lCookie�f�lNetwork �7� �fO chat do servidor foi limpo por: �6�l" + p.getName());
			} else if (Args[0].equalsIgnoreCase("off")) {
				Bukkit.getServer()
						.broadcastMessage("�6�lCookie�f�lNetwork �7� �fO chat do servidor foi �c�lDESATIVADO�f.");
				ChatCommand.pausado = true;
			} else if (Args[0].equalsIgnoreCase("on")) {
				Bukkit.getServer()
						.broadcastMessage("�6�lCookie�f�lNetwork �7� �fO chat do servidor foi �a�lATIVADO�f.");
				ChatCommand.pausado = false;
			}
		}
		return true;
	}

	@EventHandler
	public void onChat(final PlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (ChatCommand.pausado && !cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente")
				&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod")
				&& !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
				&& !cfGrupo.ChecarGrupo(p, "Dono")) {
			e.setCancelled(true);
			p.sendMessage("�cO chat est\u00e1 desativado.");
		}
	}
}
