package me.cangasso.bans;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.API.HorarioAPI;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import me.cangasso.twitter.TweetAPI;

public class IPBanCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player jogador = (Player) sender;
		if (!cmd.getName().equalsIgnoreCase("ipban")) {
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
			API.sendMsg((CommandSender) jogador, "§cUse /ipban (jogador) (motivo)");
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
			API.sendMsg((CommandSender) jogador, "§cVoc\u00ea n\u00e3o pode banir a si mesmo!");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (Config.getConfig().getBans().get("Bans." + vitima.getUniqueId()) != null) {
			API.sendMsg((CommandSender) jogador,
					"§fO Jogador §6§l" + vitima.getName() + " §fj\u00e1 est\u00e1 §4§lBANIDO§f! ");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId()) != null) {
			API.sendMsg((CommandSender) jogador,
					"§fO Jogador §6§l" + vitima.getName() + " §fj\u00e1 est\u00e1 §6§lBANIDO§4(IP)§f!");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
			API.sendMsg((CommandSender) jogador,
					"§fO Jogador §6§l" + vitima.getName() + " §7j\u00e1 est\u00e1 §6§lBANIDO§4(tempban)§f!");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (args.length == 1) {
			API.sendMsg((CommandSender) jogador, "§cUse /ipban (jogador) (motivo)");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		String Motivo = "";
		for (int i = 1; i < args.length; ++i) {
			Motivo = String.valueOf(Motivo) + args[i] + " ";
		}
		API.sendMsg((CommandSender) jogador, "§aVoc\u00ea baniu o jogador " + vitima.getName() + "§a!");
		API.sendBC("§4§l[BAN] §7" + vitima.getName() + " §7foi banido permanentemente por " + Motivo);
		API.sendStaff("§c" + jogador.getName() + " §cbaniu o jogador §c" + vitima.getName() + "§c. Motivo: " + Motivo);
		vitima.kickPlayer(
				"§7Voc\u00ea teve o seu IP banido §4§lPERMANENTEMENTE §7 do servidor!\n§7Username banido: §c§l"
						+ vitima.getName() + "\n" + "§7IP banido: §c§l" + vitima.getAddress().getHostString() + "\n"
						+ "§7Banido por: §c§l" + jogador.getName() + "\n" + "§7Motivo: §c§l" + Motivo + "\n"
						+ "§7Expira em: §c§lNUNCA" + "\n" + "§7Data do banimento: §c§l" + HorarioAPI.getHorario() + "\n"
						+ "§7Compre §2§lUNBAN §7em nossa loja: §6§lnmc-cookie.com.br" + "\n"
						+ "§7Banimento incorreto? Contate-nos pelo Twitter §b§l@Cookie_Suporte§f!");
		TweetAPI.update("\ud83d\udd10 Jogador banido: " + vitima.getName() + "\n" + "Banido por: " + jogador.getName()
				+ "\n" + "Motivo: " + Motivo);
		Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".Nome", (Object) vitima.getName());
		Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".Banido por",
				(Object) jogador.getName());
		Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".Motivo", (Object) Motivo);
		Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".IP do Jogador",
				(Object) vitima.getAddress().getHostString());
		Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".Data do banimento",
				(Object) HorarioAPI.getHorario());
		Config.getConfig().saveIpBans();
		Bukkit.banIP(vitima.getAddress().getHostString());
		return true;
	}
}
