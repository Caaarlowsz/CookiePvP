package me.cangasso.twitter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.configuração.cfGrupo;

public class cTweetar implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tweetar")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
				p.sendMessage("�c�l(!) �cVoc\u00ea não possui permissão para utilizar este comando!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("�f- �7Escolha um de nossos Twitters para Twittar!");
				p.sendMessage(" ");
				p.sendMessage("�7\u27b3 �b�lPrincipal �f- �c(Manutenção)");
				p.sendMessage("�7\u27b3 �b�lStaff �f- �c(Manutenção)");
				p.sendMessage("�7\u27b3 �b�lBans �f- �a(Autorizado)");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("principal")) {
					p.sendMessage(
							"�a�lVoc\u00ea escolheu Twittar em nossa conta principal. �7Utilize: �6�l/tweetar principal <tweet>");
					return true;
				}
				if (args[0].equalsIgnoreCase("staff")) {
					p.sendMessage(
							"�a�lVoc\u00ea escolheu Twittar em nossa conta de atualizaç\u00f5es da equipe. �7Utilize: �6�l/tweetar staff �6<jogador> <Entrou | saiu | retirado | retorna | removido | rebaixado | afastou | afastado> <cargo> <Twitter do indiv\u00edduo>");
					return true;
				}
				if (args[0].equalsIgnoreCase("bans")) {
					p.sendMessage(
							"�a�lVoc\u00ea escolheu Twittar em nossa conta respons\u00e1vel pelos banimentos. �7Utilize /tweetar bans <Tweet>");
					return true;
				}
			}
			if (args.length >= 2) {
				if (args[0].equalsIgnoreCase("principal")) {
					String tweet = "";
					for (int i = 1; i < args.length; ++i) {
						tweet = String.valueOf(tweet) + args[i] + " ";
					}
					TweetAPI.updatePrincipal(tweet);
					p.sendMessage("�fUm �b�lTWEET �ffoi publicado com sucesso!");
					return true;
				}
				if (args[0].equalsIgnoreCase("bans")) {
					String tweet = "";
					for (int i = 1; i < args.length; ++i) {
						tweet = String.valueOf(tweet) + args[i] + " ";
					}
					TweetAPI.updateBans(tweet);
					p.sendMessage("�fUm �b�lTWEET �ffoi publicado com sucesso!");
					return true;
				}
			}
			if (args.length == 4) {
				if (args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("saiu")) {
					final String jogador = args[1];
					final String twitter = args[3];
					TweetAPI.updateStaffSaiu(jogador, twitter);
					p.sendMessage("�fUm �b�lTWEET �ffoi publicado com sucesso!");
					return true;
				}
				if (args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("retirado")) {
					final String jogador = args[1];
					final String twitter = args[3];
					TweetAPI.updateStaffRetirado(jogador, twitter);
					p.sendMessage("�fUm �b�lTWEET �ffoi publicado com sucesso!");
					return true;
				}
				if (args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("afastou")) {
					final String jogador = args[1];
					final String twitter = args[3];
					TweetAPI.updateStaffAfastou(jogador, twitter);
					p.sendMessage("�fUm �b�lTWEET �ffoi publicado com sucesso!");
					return true;
				}
				if (args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("afastado")) {
					final String jogador = args[1];
					final String twitter = args[3];
					TweetAPI.updateStaffAfastado(jogador, twitter);
					p.sendMessage("�fUm �b�lTWEET �ffoi publicado com sucesso!");
					return true;
				}
			}
			if (args.length == 5) {
				if (args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("entrou")) {
					final String jogador = args[1];
					final String cargo = args[3];
					final String twitter2 = args[4];
					TweetAPI.updateStaffEntrou(jogador, cargo, twitter2);
					p.sendMessage("�fUm �b�lTWEET �ffoi publicado com sucesso!");
					return true;
				}
				if (args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("promovido")) {
					final String jogador = args[1];
					final String cargo = args[3];
					final String twitter2 = args[4];
					TweetAPI.updateStaffPromovido(jogador, cargo, twitter2);
					p.sendMessage("�fUm �b�lTWEET �ffoi publicado com sucesso!");
					return true;
				}
				if (args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("rebaixado")) {
					final String jogador = args[1];
					final String cargo = args[3];
					final String twitter2 = args[4];
					TweetAPI.updateStaffRebaixado(jogador, cargo, twitter2);
					p.sendMessage("�fUm �b�lTWEET �ffoi publicado com sucesso!");
					return true;
				}
				if (args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("retorna")) {
					final String jogador = args[1];
					final String cargo = args[3];
					final String twitter2 = args[4];
					TweetAPI.updateStaffRetorna(jogador, cargo, twitter2);
					p.sendMessage("�fUm �b�lTWEET �ffoi publicado com sucesso!");
					return true;
				}
			}
		}
		return false;
	}
}
