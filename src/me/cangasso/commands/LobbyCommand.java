package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import me.cangasso.main.CookiePvP;

public class LobbyCommand implements CommandExecutor {
	public static void sendPlayerBungee(final Player p, final String s) {
		final ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("Connect");
		out.writeUTF(s);
		p.sendPluginMessage(CookiePvP.getPlugin(), "BungeeCord", out.toByteArray());
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("lobby") && args.length == 0) {
			p.sendMessage(
					"�6�lCookie�f�lNetwork �7� �fVoc\u00ea est\u00e1 sendo enviado ao �6�lLOBBY�f! Aguarde �3�l3 segundos...");
			p.sendMessage("�6�lCookie�f�lNetwork �7� �fPara cancelar o teleporte, utilzie �6�l/LOBBY �fnovamente!");
			Bukkit.getScheduler().scheduleAsyncDelayedTask(CookiePvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage("�6�lCookie�f�lNetwork �7� �fVoc\u00ea est\u00e1 sendo enviado ao �6�lLOBBY");
					LobbyCommand.sendPlayerBungee(p, "lobby");
				}
			}, 60L);
		}
		return false;
	}
}
