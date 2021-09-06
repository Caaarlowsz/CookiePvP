package me.cangasso.bans;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.configura\u00e7\u00e3o.cfGrupo;

public class KickCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player jogador = (Player) sender;
		if (!cmd.getName().equalsIgnoreCase("kick")) {
			return false;
		}
		if (!cfGrupo.ChecarGrupo(jogador, "Dono") && !cfGrupo.ChecarGrupo(jogador, "Gerente")
				&& !cfGrupo.ChecarGrupo(jogador, "Admin") && !cfGrupo.ChecarGrupo(jogador, "Mod+")
				&& !cfGrupo.ChecarGrupo(jogador, "Mod") && !cfGrupo.ChecarGrupo(jogador, "Trial")
				&& !cfGrupo.ChecarGrupo(jogador, "Youtuber+")) {
			API.sendMsg((CommandSender) jogador,
					"§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
			return true;
		}
		if (args.length == 0) {
			API.sendMsg((CommandSender) jogador, "§cUse /kick (jogador) (motivo)");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		final Player vitima = Bukkit.getPlayer(args[0]);
		if (vitima == null) {
			API.sendMsg((CommandSender) jogador,
					"§cO jogador em quest\u00e3o est\u00e1 offline ou nunca entrou no servidor!");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (vitima.getName() == jogador.getName()) {
			API.sendMsg((CommandSender) jogador, "§cVoc\u00ea n\u00e3o pode kickar a si mesmo!");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (args.length == 1) {
			API.sendMsg((CommandSender) jogador, "§cUse /kick (jogador) (motivo)");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		String Motivo = "";
		for (int i = 1; i < args.length; ++i) {
			Motivo = String.valueOf(Motivo) + args[i] + " ";
		}
		API.sendMsg((CommandSender) jogador, "§aVoc\u00ea kickou o jogador " + vitima.getName() + "§a.");
		API.sendStaff("§c" + vitima.getName() + " §cfoi kickado por " + jogador.getName() + "§c. Motivo: §c" + Motivo);
		vitima.kickPlayer("§7Voc\u00ea foi kickado §fdo servidor!\n§7Username kickado: §c§l" + vitima.getName() + "\n"
				+ "§7Kickado por: §c§l" + jogador.getName() + "\n" + "§7Motivo: §c§l" + Motivo);
		return true;
	}
}
