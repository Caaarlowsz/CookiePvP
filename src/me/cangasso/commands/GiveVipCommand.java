package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import me.cangasso.events.CorGrupo;
import me.cangasso.scoreboard.sScoreAPI;
import me.cangasso.v_1_8.TituloAPI;

public class GiveVipCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("givevip")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+")
					&& !cfGrupo.ChecarGrupo(p, "Gerente")) {
				p.sendMessage("§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
				return true;
			}
			if (args.length == 0 && sender instanceof Player) {
				p.sendMessage("§fUtilize §6§l/givevip §6(jogador) (vip)§f!");
				return true;
			}
			if (args.length == 1 && sender instanceof Player) {
				p.sendMessage("§fUtilize §6§l/givevip §6(jogador) (vip)§f!");
				return true;
			}
			if (args.length == 2) {
				final Player k = Bukkit.getPlayer(args[0]);
				final String arg = args[1];
				if (sender instanceof Player) {
					if (k == null) {
						final OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
						if (arg.equalsIgnoreCase("vip")) {
							p.sendMessage(
									"§6§lCookie§f§lNetwork §7» §fVoc\u00ea aplicou o vip §a§lVIP §fpara o jogador: §a§l"
											+ off.getName());
							cfGrupo.setarGrupo(off, "Light");
							cfGrupo.salvarconfiguracao();
							return true;
						}
						if (arg.equalsIgnoreCase("mvp")) {
							p.sendMessage(
									"§6§lCookie§f§lNetwork §7» §fVoc\u00ea aplicou o vip §9§lMVP §fpara o jogador: §9§l"
											+ off.getName());
							cfGrupo.setarGrupo(off, "Mvp");
							cfGrupo.salvarconfiguracao();
							return true;
						}
						if (arg.equalsIgnoreCase("pro")) {
							p.sendMessage(
									"§6§lCookie§f§lNetwork §7» §fVoc\u00ea aplicou o vip §6§lPRO §fpara o jogador: §6§l"
											+ off.getName());
							cfGrupo.setarGrupo(off, "Pro");
							cfGrupo.salvarconfiguracao();
							return true;
						}
					}
					if (k != null) {
						if (arg.equalsIgnoreCase("vip")) {
							p.sendMessage(
									"§6§lCookie§f§lNetwork §7» §fVoc\u00ea aplicou o vip §a§lVIP §fpara o jogador: §a§l"
											+ k.getName());
							k.sendMessage("§eVoc\u00ea recebeu o Vip. Seu grupo foi alterado para Vip.");
							TituloAPI.MandarTitulo(k, "§a§lVIP");
							TituloAPI.MandarSubTitulo(k, "§7Voc\u00ea recebeu o vip §a§lVIP");
							cfGrupo.setarGrupo(k, "Light");
							cfGrupo.salvarconfiguracao();
							if (cfGrupo.ChecarGrupo(k, "Dono")) {
								CorGrupo.setarTag(k, "§4§l");
							} else if (cfGrupo.ChecarGrupo(k, "Gerente")) {
								CorGrupo.setarTag(k, "§c§l");
							} else if (cfGrupo.ChecarGrupo(k, "Admin")) {
								CorGrupo.setarTag(k, "§c§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mod+")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mod")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Trial")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Youtuber+")) {
								CorGrupo.setarTag(k, "§3§l");
							} else if (cfGrupo.ChecarGrupo(k, "Builder")) {
								CorGrupo.setarTag(k, "§2§l");
							} else if (cfGrupo.ChecarGrupo(k, "Helper")) {
								CorGrupo.setarTag(k, "§9§l");
							} else if (cfGrupo.ChecarGrupo(k, "Youtuber")) {
								CorGrupo.setarTag(k, "§b§l");
							} else if (cfGrupo.ChecarGrupo(k, "S-Pro")) {
								CorGrupo.setarTag(k, "§e§l");
							} else if (cfGrupo.ChecarGrupo(k, "Pro")) {
								CorGrupo.setarTag(k, "§6§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mvp")) {
								CorGrupo.setarTag(k, "§9§l");
							} else if (cfGrupo.ChecarGrupo(k, "Light")) {
								CorGrupo.setarTag(k, "§a§l");
							} else if (cfGrupo.ChecarGrupo(k, "Membro")) {
								CorGrupo.setarTag(k, "§7§l");
							}
							sScoreAPI.scoreboard(k);
							k.chat("/tag light");
							return true;
						}
						if (arg.equalsIgnoreCase("mvp")) {
							p.sendMessage(
									"§6§lCookie§f§lNetwork §7» §fVoc\u00ea aplicou o vip §9§lMVP §fpara o jogador: §9§l"
											+ k.getName());
							k.sendMessage("§eVoc\u00ea recebeu o Vip Mvp. Seu grupo foi alterado para Mvp.");
							TituloAPI.MandarTitulo(k, "§9§lMVP");
							TituloAPI.MandarSubTitulo(k, "§7Voc\u00ea recebeu o vip §9§lMVP");
							cfGrupo.setarGrupo(k, "Mvp");
							cfGrupo.salvarconfiguracao();
							if (cfGrupo.ChecarGrupo(k, "Dono")) {
								CorGrupo.setarTag(k, "§4§l");
							} else if (cfGrupo.ChecarGrupo(k, "Gerente")) {
								CorGrupo.setarTag(k, "§c§l");
							} else if (cfGrupo.ChecarGrupo(k, "Admin")) {
								CorGrupo.setarTag(k, "§c§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mod+")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mod")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Trial")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Youtuber+")) {
								CorGrupo.setarTag(k, "§3§l");
							} else if (cfGrupo.ChecarGrupo(k, "Builder")) {
								CorGrupo.setarTag(k, "§2§l");
							} else if (cfGrupo.ChecarGrupo(k, "Helper")) {
								CorGrupo.setarTag(k, "§9§l");
							} else if (cfGrupo.ChecarGrupo(k, "Youtuber")) {
								CorGrupo.setarTag(k, "§b§l");
							} else if (cfGrupo.ChecarGrupo(k, "S-Pro")) {
								CorGrupo.setarTag(k, "§e§l");
							} else if (cfGrupo.ChecarGrupo(k, "Pro")) {
								CorGrupo.setarTag(k, "§6§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mvp")) {
								CorGrupo.setarTag(k, "§9§l");
							} else if (cfGrupo.ChecarGrupo(k, "Light")) {
								CorGrupo.setarTag(k, "§a§l");
							} else if (cfGrupo.ChecarGrupo(k, "Membro")) {
								CorGrupo.setarTag(k, "§7§l");
							}
							sScoreAPI.scoreboard(k);
							k.chat("/tag mvp");
							return true;
						}
						if (arg.equalsIgnoreCase("pro")) {
							p.sendMessage(
									"§6§lCookie§f§lNetwork §7» §fVoc\u00ea aplicou o vip §6§lPRO §fpara o jogador: §6§l"
											+ k.getName());
							k.sendMessage("§eVoc\u00ea recebeu o Vip Pro. Seu grupo foi alterado para Pro.");
							TituloAPI.MandarTitulo(k, "§6§lPRO");
							TituloAPI.MandarSubTitulo(k, "§7Voc\u00ea recebeu o vip §6§lPRO");
							cfGrupo.setarGrupo(k, "Pro");
							cfGrupo.salvarconfiguracao();
							if (cfGrupo.ChecarGrupo(k, "Dono")) {
								CorGrupo.setarTag(k, "§4§l");
							} else if (cfGrupo.ChecarGrupo(k, "Gerente")) {
								CorGrupo.setarTag(k, "§c§l");
							} else if (cfGrupo.ChecarGrupo(k, "Admin")) {
								CorGrupo.setarTag(k, "§c§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mod+")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mod")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Trial")) {
								CorGrupo.setarTag(k, "§5§l");
							} else if (cfGrupo.ChecarGrupo(k, "Youtuber+")) {
								CorGrupo.setarTag(k, "§3§l");
							} else if (cfGrupo.ChecarGrupo(k, "Builder")) {
								CorGrupo.setarTag(k, "§2§l");
							} else if (cfGrupo.ChecarGrupo(k, "Helper")) {
								CorGrupo.setarTag(k, "§9§l");
							} else if (cfGrupo.ChecarGrupo(k, "Youtuber")) {
								CorGrupo.setarTag(k, "§b§l");
							} else if (cfGrupo.ChecarGrupo(k, "S-Pro")) {
								CorGrupo.setarTag(k, "§e§l");
							} else if (cfGrupo.ChecarGrupo(k, "Pro")) {
								CorGrupo.setarTag(k, "§6§l");
							} else if (cfGrupo.ChecarGrupo(k, "Mvp")) {
								CorGrupo.setarTag(k, "§9§l");
							} else if (cfGrupo.ChecarGrupo(k, "Light")) {
								CorGrupo.setarTag(k, "§a§l");
							} else if (cfGrupo.ChecarGrupo(k, "Membro")) {
								CorGrupo.setarTag(k, "§7§l");
							}
							sScoreAPI.scoreboard(k);
							k.chat("/tag pro");
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
