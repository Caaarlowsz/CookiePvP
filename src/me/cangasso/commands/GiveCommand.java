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

public class GiveCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("giveyoutuber")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Admin")
					&& !cfGrupo.ChecarGrupo(p, "Gerente")) {
				p.sendMessage("§cVoc\u00ea n\u00e3o possui permiss\u00e3o para manipular este grupo!");
				return true;
			}
			if (args.length == 0) {
				if (sender instanceof Player) {
					p.sendMessage("§7Use §b§l/giveyoutuber §7(jogador)");
					return true;
				}
				if (!(sender instanceof Player)) {
					sender.sendMessage("§7Use §b§l/giveyoutuber §7(jogador)");
					return true;
				}
			}
			if (args.length == 1) {
				final Player k = Bukkit.getPlayer(args[0]);
				if (sender instanceof Player) {
					if (k == null) {
						final OfflinePlayer off = Bukkit.getOfflinePlayer(args[1]);
						p.sendMessage("§eVoc\u00ea aplicou o grupo Youtuber para " + off.getName());
						cfGrupo.setarGrupo(off, "Youtuber");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (k != null) {
						p.sendMessage("§eVoc\u00ea aplicou o grupo Youtuber para " + k.getName());
						k.sendMessage("§eO seu grupo(Youtuber) foi alterdo para Youtuber com sucesso!");
						TituloAPI.MandarTitulo(k, "§b§lYOUTUBER");
						TituloAPI.MandarSubTitulo(k, "§7O seu grupo foi alterado para §b§lYOUTUBER§7!");
						cfGrupo.setarGrupo(k, "Youtuber");
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
						k.chat("/tag youtuber");
						return true;
					}
				}
				if (!(sender instanceof Player)) {
					if (k == null) {
						final OfflinePlayer off = Bukkit.getOfflinePlayer(args[1]);
						sender.sendMessage("§eVoc\u00ea aplicou o grupo Youtuber para" + off.getName());
						cfGrupo.setarGrupo(off, "Youtuber");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (k != null) {
						sender.sendMessage("§eVoc\u00ea aplicou o grupo Youtuber para" + k.getName());
						k.sendMessage("§eO seu grupo(Youtuber) foi alterado para Youtuber!");
						TituloAPI.MandarTitulo(k, "§b§lYOUTUBER");
						TituloAPI.MandarSubTitulo(k, "§7O seu grupo foi alterado para §b§lYOUTUBER§7!");
						cfGrupo.setarGrupo(k, "Youtuber");
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
						k.chat("/tag youtuber");
						return true;
					}
				}
			}
		}
		if (cmd.getName().equalsIgnoreCase("giveyoutuberplus")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")
					&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Gerente")) {
				p.sendMessage("§cVoc\u00ea n\u00e3o possui permiss\u00e3o para manipular este grupo!");
				return true;
			}
			if (args.length == 0) {
				if (sender instanceof Player) {
					p.sendMessage("§7Use §3§l/giveyoutuberplus §7(jogador)");
					return true;
				}
				if (!(sender instanceof Player)) {
					sender.sendMessage("§7Use §3§l/giveyoutuberplus §7(jogador)");
					return true;
				}
			}
			if (args.length == 1) {
				final Player k = Bukkit.getPlayer(args[0]);
				if (sender instanceof Player) {
					if (k == null) {
						final OfflinePlayer off = Bukkit.getOfflinePlayer(args[1]);
						p.sendMessage("§eVoc\u00ea aplicou o grupo Youtuber+ para " + off.getName());
						cfGrupo.setarGrupo(off, "Youtuber+");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (k != null) {
						p.sendMessage("§eVoc\u00ea aplicou o grupo Youtuber para " + k.getName());
						k.sendMessage("§eO seu grupo(Youtuber+) foi alterdo para Youtuber+ com sucesso!");
						TituloAPI.MandarTitulo(k, "§3§lYOUTUBER+");
						TituloAPI.MandarSubTitulo(k, "§7O seu grupo foi alterado para §3§lYOUTUBER+§7!");
						cfGrupo.setarGrupo(k, "Youtuber+");
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
						k.chat("/tag youtuber+");
						return true;
					}
				}
				if (!(sender instanceof Player)) {
					if (k == null) {
						final OfflinePlayer off = Bukkit.getOfflinePlayer(args[1]);
						sender.sendMessage("§eVoc\u00ea aplicou o grupo Youtuber+ para" + off.getName());
						cfGrupo.setarGrupo(off, "Youtuber+");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (k != null) {
						sender.sendMessage("§eVoc\u00ea aplicou o grupo Youtuber+ para" + k.getName());
						k.sendMessage("§eO seu grupo(Youtuber+) foi alterado para Youtuber+!");
						TituloAPI.MandarTitulo(k, "§3§lYOUTUBER+");
						TituloAPI.MandarSubTitulo(k, "§7O seu grupo foi alterado para §3§lYOUTUBER+§7!");
						cfGrupo.setarGrupo(k, "Youtuber+");
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
						k.chat("/tag youtuber+");
						return true;
					}
				}
			}
		}
		if (cmd.getName().equalsIgnoreCase("givebuilder")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Admin")
					&& !cfGrupo.ChecarGrupo(p, "Gerente")) {
				p.sendMessage("§cVoc\u00ea n\u00e3o possui permiss\u00e3o para manipular este grupo!");
				return true;
			}
			if (args.length == 0) {
				if (sender instanceof Player) {
					p.sendMessage("§7Use §2§l/givebuilder §7(jogador)");
					return true;
				}
				if (!(sender instanceof Player)) {
					sender.sendMessage("§7Use §2§l/givebuilder §7(jogador)");
					return true;
				}
			}
			if (args.length == 1) {
				final Player k = Bukkit.getPlayer(args[0]);
				if (sender instanceof Player) {
					if (k == null) {
						final OfflinePlayer off = Bukkit.getOfflinePlayer(args[1]);
						p.sendMessage("§eVoc\u00ea aplicou o grupo Builder para " + off.getName());
						cfGrupo.setarGrupo(off, "Builder");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if (k != null) {
						p.sendMessage("§eVoc\u00ea aplicou o grupo Builder para " + k.getName());
						k.sendMessage("§eO seu grupo(Builder) foi alterado para Builder!");
						TituloAPI.MandarTitulo(k, "§a§lBUILDER");
						TituloAPI.MandarSubTitulo(k, "§7O seu grupo foi alterado para §2§BUILDER§7!");
						cfGrupo.setarGrupo(k, "Builder");
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
						k.chat("/tag builder");
						return true;
					}
				}
			}
		}
		return false;
	}
}
