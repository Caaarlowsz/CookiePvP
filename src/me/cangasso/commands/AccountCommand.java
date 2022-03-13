package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.accutils.AccountUtils;
import me.cangasso.bans.API;
import me.cangasso.bans.Config;

public class AccountCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("account") || cmd.getName().equalsIgnoreCase("acc")) {
			if (args.length == 0) {
				p.sendMessage("�8�l<�e�l!�8�l> �7Argumento correto: �6�l/account �7(jogador)");
				API.sendSound(p, Sound.NOTE_PLING, 10);
				return true;
			}
			final Player acc = Bukkit.getPlayer(args[0]);
			if (acc == null) {
				final OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
				if (Config.getConfig().getJogadores().get("Jogadores." + off.getUniqueId()) == null) {
					API.sendMsg((CommandSender) p, "�6�lCookie�f�lNetwork �7� �fO jogador �9�l" + off.getName()
							+ "�f nunca entrou no servidor!");
					API.sendSound(p, Sound.NOTE_PLING, 10);
					return true;
				}
				if (Config.getConfig().getJogadores().get("Jogadores." + off.getUniqueId()) != null) {
					API.sendMsg((CommandSender) p, "�e�m>------- �f �l�kIII �f �6�lACCOUNT �f �l�kIII �e�m-------<");
					API.sendMsg((CommandSender) p, " ");
					API.sendMsg((CommandSender) p,
							"�fO jogador �6�l" + off.getName()
									+ " �fest\u00e1 atualmente �c�lOFFLINE �fem nossos servidores" + "�f. Na liga "
									+ AccountUtils.getRankOffline((OfflinePlayer) acc) + " "
									+ AccountUtils.getRankNomeOffline((OfflinePlayer) acc)
									+ "�f. Grupo atual do jogador: " + AccountUtils.getGrupo((OfflinePlayer) acc));
					API.sendMsg((CommandSender) p, " ");
					API.sendMsg((CommandSender) p, "�e�m>------- �f �l�kIII �f �6�lACCOUNT �f �l�kIII �e�m-------<");
				}
			}
			if (acc != null) {
				API.sendMsg((CommandSender) p, "�e�m>------- �f �l�kIII �f �6�lACCOUNT �f �l�kIII �e�m-------<");
				API.sendMsg((CommandSender) p, " ");
				API.sendMsg((CommandSender) p,
						"�fO jogador �6�l" + acc.getName() + " �fest\u00e1 atualmente �a�lONLINE �fem nossos servidores"
								+ "�f. Na liga " + AccountUtils.getRankOffline((OfflinePlayer) acc) + " "
								+ AccountUtils.getRankNomeOffline((OfflinePlayer) acc) + "�f. Grupo atual do jogador: "
								+ AccountUtils.getGrupo((OfflinePlayer) acc));
				API.sendMsg((CommandSender) p, " ");
				API.sendMsg((CommandSender) p, "�e�m>------- �f �l�kIII �f �6�lACCOUNT �f �l�kIII �e�m-------<");
			}
		}
		return false;
	}
}
