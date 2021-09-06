package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.main.Main;
import me.cangasso.scoreboard.sScoreAPI;

public class ScoreCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("score")) {
			if (sScoreAPI.Delay.contains(p)) {
				p.sendMessage("§cAguarde para executar este comando novamente!");
				return true;
			}
			if (sScoreAPI.Score.contains(p)) {
				p.sendMessage("§eA sua Scoreboard foi desativada, para ativ\u00e1-la novamente use /score");
				sScoreAPI.Score.remove(p);
				sScoreAPI.scorenull(p);
				sScoreAPI.Delay.add(p);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						sScoreAPI.Delay.remove(p);
					}
				}, 120L);
			} else if (!sScoreAPI.Score.contains(p)) {
				p.sendMessage("§eA sua Scoreboard foi ativada, para desativ\u00e1-la novamente use /score");
				sScoreAPI.Score.add(p);
				sScoreAPI.scoreboard(p);
				sScoreAPI.Delay.add(p);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						sScoreAPI.Delay.remove(p);
					}
				}, 120L);
			}
		}
		return false;
	}
}
