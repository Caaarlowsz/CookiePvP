package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.API.ArraysAPI;
import me.cangasso.configuração.cfGrupo;
import me.cangasso.main.CookiePvP;

public class HelpopCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (ArraysAPI.CooldownDica.contains(p)) {
			p.sendMessage("�c�l(!) �cAguarde para executar este comando novamente!");
			return true;
		}
		if (Args.length == 0) {
			p.sendMessage("�8�l<�e�l!�8�l> �7Argumento correto: /duvida �c�l(d\u00favida)");
			return true;
		}
		p.sendMessage("�aSua d\u00favida foi enviada. Assim que poss\u00edvel voc\u00ea ser\u00e1 respondido!");
		String dica = " ";
		for (int i = 0; i < Args.length; ++i) {
			if (i == Args.length - 1) {
				dica = String.valueOf(dica) + Args[i];
			} else {
				dica = String.valueOf(dica) + Args[i] + " ";
			}
		}
		ArraysAPI.CooldownDica.add(p);
		Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				if (ArraysAPI.CooldownDica.contains(p)) {
					ArraysAPI.CooldownDica.remove(p);
				}
			}
		}, 2400L);
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, j = 0; j < length; ++j) {
			final Player s = onlinePlayers[j];
			if (cfGrupo.ChecarGrupo(s, "Dono") || cfGrupo.ChecarGrupo(p, "Youtuber+")
					|| cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(s, "Gerente")
					|| cfGrupo.ChecarGrupo(s, "Admin") || cfGrupo.ChecarGrupo(s, "Mod+")
					|| cfGrupo.ChecarGrupo(s, "Mod") || cfGrupo.ChecarGrupo(s, "Trial")) {
				s.sendMessage("�d�m>-------------------------<");
				s.sendMessage("               �6� �f�lDUVIDA �6�     ");
				s.sendMessage("�d�m>-------------------------<");
				s.sendMessage(" ");
				s.sendMessage("�6\u2022 �fJogador: �7" + p.getName());
				s.sendMessage("�6\u2022 �fD\u00favida: �7" + dica);
				s.sendMessage("�6\u2022 �fIP: �7KitPvP ");
				s.sendMessage(" ");
				s.sendMessage("�d�m>-------------------------<");
			}
		}
		return false;
	}
}
