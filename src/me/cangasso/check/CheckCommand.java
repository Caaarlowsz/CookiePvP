package me.cangasso.check;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.bans.API;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import me.cangasso.configura\u00e7\u00e3o.cfStatus;

public class CheckCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("check")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")
					&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Mod+")
					&& !cfGrupo.ChecarGrupo(p, "Dono")) {
				API.sendMsg((CommandSender) p,
						"§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§fUtilize §a§l/check §a(jogador)§f.");
				return true;
			}
			final Player check = Bukkit.getPlayer(args[0]);
			if (check == null) {
				p.sendMessage("Jogador offline!");
				return true;
			}
			p.sendMessage(" ");
			p.sendMessage("§aChecando informa\u00e7\u00f5es de " + check.getName() + "§a...");
			p.sendMessage(" ");
			p.sendMessage("§6\u2022 §fRanking: " + CheckUtils.Grupo(check));
			p.sendMessage("§6\u2022 §fNickname: §7" + CheckUtils.Nickname(check));
			p.sendMessage("§6\u2022 §fUUID: §7" + CheckUtils.UUID(check));
			p.sendMessage("§6\u2022 §fIP: §7" + CheckUtils.IP(check));
			p.sendMessage("§6\u2022 §fIP §8(reverso): §7" + CheckUtils.IPReverso(check));
			p.sendMessage("§6\u2022 §fGEOIP: §7" + CheckUtils.GeoIP(check));
			p.sendMessage("§6\u2022 §fGamemode: §7" + CheckUtils.Gamemode(check));
			p.sendMessage("§6\u2022 §fFly: §7" + CheckUtils.Fly(check));
			p.sendMessage("§6\u2022 §fVida: §7" + CheckUtils.Vida(check));
			p.sendMessage("§6\u2022 §fFome: §7" + CheckUtils.Fome(check));
			p.sendMessage("§6\u2022 §fKit: §7" + CheckUtils.Kit(check));
			p.sendMessage("§6\u2022 §fWarp: §7" + CheckUtils.Warp(check));
			p.sendMessage("§6\u2022 §fElo: " + CheckUtils.Rank(check));
			p.sendMessage("§6\u2022 §fXP: §7" + cfStatus.getMoney(check));
			p.sendMessage("§6\u2022 §fKills: §7" + cfStatus.getKills(check));
			p.sendMessage("§6\u2022 §fDeaths: §7" + cfStatus.getDeaths(check));
			p.sendMessage("§6\u2022 §fKillStreak: §7" + cfStatus.getKillStreak(check));
			p.sendMessage(" ");
		}
		return false;
	}
}
