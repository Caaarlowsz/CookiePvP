package me.cangasso.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.cangasso.API.ArraysAPI;
import me.cangasso.configuração.cfConfig;

public class TellCommand implements CommandExecutor, Listener {
	public static ArrayList<Player> cooldown;

	static {
		TellCommand.cooldown = new ArrayList<Player>();
	}

	@EventHandler
	public void flodar(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (TellCommand.cooldown.contains(p) && TellCommand.cooldown.contains(p)
				&& e.getMessage().toLowerCase().startsWith("/tell")) {
			e.setCancelled(true);
			p.sendMessage("�cAguarde antes de enviar outra mensagem...");
		}
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("tell")) {
			if (Args.length == 0) {
				p.sendMessage("�cUtilize o comando �c�l/tell <jogador> <mensagem> �c| �c�l/tell �c(on | off)");
				return true;
			}
			if (Args[0].equalsIgnoreCase("on")) {
				if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".Tell")
						.equals("Desativado")) {
					p.sendMessage("�aSeu tell foi ativado.");
					cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Tell",
							(Object) "Ativado");
					cfConfig.salvarconfiguracao();
				} else {
					p.sendMessage("�cO seu tell j\u00e1 est\u00e1 ativado!");
				}
				return true;
			}
			if (Args[0].equalsIgnoreCase("off")) {
				if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".Tell")
						.equals("Ativado")) {
					p.sendMessage("�cSeu tell foi desativado.");
					cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Tell",
							(Object) "Desativado");
					cfConfig.salvarconfiguracao();
				} else {
					p.sendMessage("�cO seu tell j\u00e1 est\u00e1 desativado!");
				}
				return true;
			}
			final Player tell = Bukkit.getPlayer(Args[0]);
			if (tell == null) {
				p.sendMessage("�cJogador offline!");
				return true;
			}
			if (tell == p) {
				p.sendMessage("�c\u00c9 imposs\u00edvel enviar mensagens a si mesmo!");
				return true;
			}
			if (cfConfig.pegarconfig().get("configuração." + tell.getUniqueId() + ".Tell")
					.equals("Desativado")) {
				p.sendMessage("�7Este jogador est\u00e1 com o tell �c�lDESATIVADO�7. Tente novamente mais tarde.");
				return true;
			}
			if (ArraysAPI.Admin.contains(tell)) {
				p.sendMessage("�cJogador offline!");
				return true;
			}
			String message = " ";
			for (int i = 1; i < Args.length; ++i) {
				if (i == Args.length - 1) {
					message = String.valueOf(message) + Args[i];
				} else {
					message = Args[i];
				}
			}
			p.sendMessage("�7[�a�lVoc\u00ea �7-> �a�l" + tell.getName() + "�7] " + message);
			tell.sendMessage("�7[�a�l" + p.getName() + "�7-> �a�lVoc\u00ea�7] " + message);
		}
		return false;
	}
}
