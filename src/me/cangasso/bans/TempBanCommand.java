package me.cangasso.bans;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.API.HorarioAPI;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import me.cangasso.main.Main;
import me.cangasso.twitter.TweetAPI;

public class TempBanCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player jogador = (Player) sender;
		if (!cmd.getName().equalsIgnoreCase("tempban")) {
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
			API.sendMsg((CommandSender) jogador, "§3§lTEMPBAN §fUtilize §3§l/tempban §3(jogador) (sigla)");
			API.sendMsg((CommandSender) jogador, " ");
			API.sendMsg((CommandSender) jogador, "§2§lSIGLAS §fAbaixo segue a lista de siglas e seus significados...");
			API.sendMsg((CommandSender) jogador, " ");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lftell §f- §8(Flood no tell)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lffa §f- §8(Free for all)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§ltfps §f- §8(Time na fps)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lfkill §f- §8(Freekill)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lofs §f- §8(Ofensa a staff)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§loftell §f- §8(Ofensa pelo tell)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§labug §f- §8(Abuso de bugs)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lcitlink §f- §8(Cita\u00e7\u00e3o de links externos)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lident §f- §8(Falsidade ideol\u00f3gica)");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		final Player vitima = Bukkit.getPlayer(args[0]);
		if (vitima == null) {
			API.sendMsg((CommandSender) jogador, "§cO jogador em quest\u00e3o est\u00e1 offline!");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
			API.sendMsg((CommandSender) jogador, "§3§lTEMPBAN §fUtilize §3§l/tempban §3(jogador) (sigla)");
			API.sendMsg((CommandSender) jogador, " ");
			API.sendMsg((CommandSender) jogador, "§2§lSIGLAS §fAbaixo segue a lista de siglas e seus significados...");
			API.sendMsg((CommandSender) jogador, " ");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lftell §f- §8(Flood no tell)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lffa §f- §8(Free for all)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§ltfps §f- §8(Time na fps)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lfkill §f- §8(Freekill)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lofs §f- §8(Ofensa a staff)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§loftell §f- §8(Ofensa pelo tell)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§labug §f- §8(Abuso de bugs)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lcitlink §f- §8(Cita\u00e7\u00e3o de links externos)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lident §f- §8(Falsidade ideol\u00f3gica)");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId()) != null) {
			API.sendMsg((CommandSender) jogador, "§fO jogador §6§l" + args[0] + " §fj\u00e1 est\u00e1 §4§lBANIDO§f!");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (Config.getConfig().getBans().get("Bans." + vitima.getUniqueId()) != null) {
			API.sendMsg((CommandSender) jogador, "§fO jogador §6§l" + args[0] + " §fj\u00e1 est\u00e1 §4§lBANIDO§f!");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (vitima.getName() == jogador.getName()) {
			API.sendMsg((CommandSender) jogador, "§cVoc\u00ea n\u00e3o pode banir a si mesmo!");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (args.length == 1) {
			API.sendMsg((CommandSender) jogador, "§3§lTEMPBAN §fUtilize §3§l/tempban §3(jogador) (sigla)");
			API.sendMsg((CommandSender) jogador, "§3§lTEMPBAN §fUtilize §3§l/tempban §3(jogador) (sigla)");
			API.sendMsg((CommandSender) jogador, " ");
			API.sendMsg((CommandSender) jogador, "§2§lSIGLAS §fAbaixo segue a lista de siglas e seus significados...");
			API.sendMsg((CommandSender) jogador, " ");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lftell §f- §8(Flood no tell)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lffa §f- §8(Free for all)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§ltfps §f- §8(Time na fps)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lfkill §f- §8(Freekill)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lofs §f- §8(Ofensa a staff)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§loftell §f- §8(Ofensa pelo tell)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§labug §f- §8(Abuso de bugs)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lcitlink §f- §8(Cita\u00e7\u00e3o de links externos)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lident §f- §8(Falsidade ideol\u00f3gica)");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (args[1].equalsIgnoreCase("ftell")) {
			API.sendMsg((CommandSender) jogador,
					"§3§lTEMPBAN §fVoc\u00ea baniu §3§lTEMPORARIAMENTE §fo jogador: §6§l" + vitima.getName() + "§f.");
			API.sendStaff("§3§lTEMPBAN §f" + jogador.getName() + " baniu §3§lTEMPORARIAMENTE §fo jogador §6§l"
					+ vitima.getName() + ". Motivo: §c§lFlood no Tell");
			vitima.kickPlayer("§fVoc\u00ea foi banido §9§lTEMPORARIAMENTE§f do servidor!\n§7Username banido: §c§l"
					+ vitima.getName() + "\n" + "§7Banido por: §c§l" + jogador.getName() + "\n"
					+ "§7Motivo: §c§lFlood no tell" + "\n" + "§7Expira em: §c§l2 dias" + "\n"
					+ "§7Data do banimento: §c§l" + HorarioAPI.getHorario() + "\n"
					+ "§fCompre §9§lUNBAN §fem nossa loja: §6§nmc-cookie.com.br" + "\n"
					+ "§fBanimento incorreto? Contate-nos pelo Twitter §b§l@Cookie_Suporte§f!");
			TweetAPI.update("\ud83d\udd10 Jogador banido: " + vitima.getName() + "\n" + "Banido por: "
					+ jogador.getName() + "\n" + "Motivo: Flood no tell" + "\n" + "Expira em: 2 dias ");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
					(Object) jogador.getName());
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo",
					(Object) "Flood no Tell");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban",
					(Object) "2 dias");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempBans();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
						Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempBans();
						API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desbanido por: §c§lCONSOLE");
						API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§DESBANIDO §fautomaticamente!");
					}
				}
			}, 3456000L);
			return true;
		}
		if (args[1].equalsIgnoreCase("ffa")) {
			API.sendMsg((CommandSender) jogador,
					"§3§lTEMPBAN §fVoc\u00ea baniu §3§lTEMPORARIAMENTE §fo jogador: §6§l" + vitima.getName() + "§f.");
			API.sendStaff("§3§lTEMPBAN §f" + jogador.getName() + " baniu §3§lTEMPORARIAMENTE §fo jogador §6§l"
					+ vitima.getName() + ". Motivo: §c§lFree for all");
			vitima.kickPlayer("§fVoc\u00ea foi banido §9§lTEMPORARIAMENTE§f do servidor!\n§7Jogador banido: §c§l"
					+ vitima.getName() + "\n" + "§7Banido por: §c§l" + jogador.getName() + "\n"
					+ "§7Motivo: §c§lFree for all" + "\n" + "§7Expira em: §c§l2 dias" + "\n"
					+ "§7Data do banimento: §c§l" + HorarioAPI.getHorario() + "\n"
					+ "§fCompre §9§lUNBAN §fem nossa loja: §6§mc-cookie.com.br" + "\n"
					+ "§fBanimento incorreto? Contate-nos pelo Twitter §b§l@Cookie_Suporte§f!");
			TweetAPI.update("\ud83d\udd10 Jogador banido: " + vitima.getName() + "\n" + "Banido por: "
					+ jogador.getName() + "\n" + "Motivo: Free for All" + "\n" + "Expira em: 2 dias");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
					(Object) jogador.getName());
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo",
					(Object) "Free for All");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban",
					(Object) "2 dias");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempBans();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
						Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempBans();
						API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desbanido por: §c§lCONSOLE");
						API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§DESBANIDO §fautomaticamente!");
					}
				}
			}, 3456000L);
			return true;
		}
		if (args[1].equalsIgnoreCase("fkill")) {
			API.sendMsg((CommandSender) jogador,
					"§3§lTEMPBAN §fVoc\u00ea baniu §3§lTEMPORARIAMENTE §fo jogador: §6§l" + vitima.getName() + "§f.");
			API.sendStaff("§3§lTEMPBAN §f" + jogador.getName() + " baniu §3§lTEMPORARIAMENTE §fo jogador §6§l"
					+ vitima.getName() + ". Motivo: §c§lFree Kill");
			vitima.kickPlayer("§fVoc\u00ea foi banido §9§lTEMPORARIAMENTE§f do servidor!\n§7Jogador banido: §c§l"
					+ vitima.getName() + "\n" + "§7Banido por: §c§l" + jogador.getName() + "\n"
					+ "§7Motivo: §c§lFree kill" + "\n" + "§7Expira em: §c§l4 dias" + "\n" + "§7Data do banimento: §c§l"
					+ HorarioAPI.getHorario() + "\n" + "§fCompre §9§lUNBAN §fem nossa loja: §6§nmc-cookie.com.br" + "\n"
					+ "§fBanimento incorreto? Contate-nos pelo Twitter §b§l@Cookie_Suporte§f!");
			TweetAPI.update("\ud83d\udd10 Jogador banido: " + vitima.getName() + "\n" + "Banido por: "
					+ jogador.getName() + "\n" + "Motivo: FreeKill" + "\n" + "Expira em: 4 dias");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
					(Object) jogador.getName());
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", (Object) "FreeKill");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban",
					(Object) "4 dias");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempBans();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
						Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempBans();
						API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desbanido por: §c§lCONSOLE");
						API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§DESBANIDO §fautomaticamente!");
					}
				}
			}, 6912000L);
			return true;
		}
		if (args[1].equalsIgnoreCase("ofs")) {
			API.sendMsg((CommandSender) jogador,
					"§3§lTEMPBAN §fVoc\u00ea baniu §3§lTEMPORARIAMENTE §fo jogador: §6§l" + vitima.getName() + "§f.");
			API.sendStaff("§3§lTEMPBAN §f" + jogador.getName() + " baniu §3§lTEMPORARIAMENTE §fo jogador §6§l"
					+ vitima.getName() + ". Motivo: §c§lOfensa a Staff");
			vitima.kickPlayer("§fVoc\u00ea foi banido §9§lTEMPORARIAMENTE§f do servidor!\n§7Jogador banido: §c§l"
					+ vitima.getName() + "\n" + "§7Banido por: §c§l" + jogador.getName() + "\n"
					+ "§7Motivo: §c§lOfensa a staff" + "\n" + "§7Expira em: §c§l2 dias" + "\n"
					+ "§7Data do banimento: §c§l" + HorarioAPI.getHorario() + "\n"
					+ "§fCompre §9§lUNBAN §fem nossa loja: §6§nlmc-cookie.com.br" + "\n"
					+ "§fBanimento incorreto? Contate-nos pelo Twitter §b§l@Cookie_Suporte§f!");
			TweetAPI.update("\ud83d\udd10 Jogador banido: " + vitima.getName() + "\n" + "Banido por: "
					+ jogador.getName() + "\n" + "Motivo: Ofensa a staff" + "\n" + "Expira em: 4 dias");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
					(Object) jogador.getName());
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo",
					(Object) "Ofensa a Staffer");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban",
					(Object) "4 dias");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempBans();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
						Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempBans();
						API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desbanido por: §c§lCONSOLE");
						API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§DESBANIDO §fautomaticamente!");
					}
				}
			}, 6912000L);
			return true;
		}
		if (args[1].equalsIgnoreCase("abug")) {
			API.sendMsg((CommandSender) jogador,
					"§3§lTEMPBAN §fVoc\u00ea baniu §3§lTEMPORARIAMENTE §fo jogador: §6§l" + vitima.getName() + "§f.");
			API.sendStaff("§3§lTEMPBAN §f" + jogador.getName() + " baniu §3§lTEMPORARIAMENTE §fo jogador §6§l"
					+ vitima.getName() + ". Motivo: §c§lAbuso de Bugs");
			vitima.kickPlayer("§fVoc\u00ea foi banido §9§lTEMPORARIAMENTE§f do servidor!\n§7Jogador banido: §c§l"
					+ vitima.getName() + "\n" + "§7Banido por: §c§l" + jogador.getName() + "\n"
					+ "§7Motivo: §c§lAbuso de Bugs" + "\n" + "§7Expira em: §c§l2 dias" + "\n"
					+ "§7Data do banimento: §c§l" + HorarioAPI.getHorario() + "\n"
					+ "§fCompre §9§lUNBAN §fem nossa loja: §6§nmc-cookie.com.br" + "\n"
					+ "§fBanimento incorreto? Contate-nos pelo Twitter §b§l@Cookie_Suporte§f!");
			TweetAPI.update("\ud83d\udd10 Jogador banido: " + vitima.getName() + "\n" + "Banido por: "
					+ jogador.getName() + "\n" + "Motivo: Abuso de Bugs" + "\n" + "Expira em: 7 dias");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
					(Object) jogador.getName());
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo",
					(Object) "Abuso de Bugs");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban",
					(Object) "7 dias");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempBans();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
						Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempBans();
						API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desbanido por: §c§lCONSOLE");
						API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§DESBANIDO §fautomaticamente!");
					}
				}
			}, 12096000L);
			return true;
		}
		if (args[1].equalsIgnoreCase("tfps")) {
			if (args.length == 2) {
				API.sendMsg((CommandSender) jogador, "§3§lTEMPBAN §fUtilize §3§l/tempban (jogador1) tfps (jogador2)");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			final Player vitimatime = Bukkit.getPlayer(args[2]);
			if (vitimatime == null) {
				API.sendMsg((CommandSender) jogador,
						"§cO jogador em quest\u00e3o est\u00e1 offline ou nunca entrou no servidor!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName() == vitimatime.getName()) {
				API.sendMsg((CommandSender) jogador, "§cAmbos os nicknames devem ser diferentes!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getTempBans().get("TempBans." + vitimatime.getUniqueId()) != null) {
				API.sendMsg((CommandSender) jogador,
						"§fO jogador §6§l" + vitimatime.getName() + " §fj\u00e1 est\u00e1 §4§lBANIDO§f!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getIpBans().get("IPBans." + vitimatime.getUniqueId()) != null) {
				API.sendMsg((CommandSender) jogador,
						"§fO jogador §6§l" + vitimatime.getName() + " §fj\u00e1 est\u00e1 §4§lBANIDO§f!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getBans().get("Bans." + vitimatime.getUniqueId()) != null) {
				API.sendMsg((CommandSender) jogador,
						"§fO jogador §6§l" + vitimatime.getName() + " §fj\u00e1 est\u00e1 §4§lBANIDO§f!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName() == jogador.getName()) {
				API.sendMsg((CommandSender) jogador, "§cVoc\u00ea n\u00e3o pode banir a si mesmo!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitimatime.getName() == jogador.getName()) {
				API.sendMsg((CommandSender) jogador, "§cVoc\u00ea n\u00e3o pode banir a si mesmo!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			API.sendMsg((CommandSender) jogador,
					"§3§lTEMPBAN §fVoc\u00ea baniu §3§lTEMPORARIAMENTE §fo jogador: §6§l" + vitima.getName() + "§f.");
			API.sendStaff("§3§lTEMPBAN §f" + jogador.getName() + " baniu §3§lTEMPORARIAMENTE §fo jogador §6§l"
					+ vitima.getName() + ". Motivo: §c§lTime na warp Fps");
			vitima.kickPlayer("§fVoc\u00ea foi banido §9§lTEMPORARIAMENTE§f do servidor!\n§7Jogador banido: §c§l"
					+ vitima.getName() + "\n" + "§7Banido por: §c§l" + jogador.getName() + "\n"
					+ "§7Motivo: §c§lTime na warp Fps" + "\n" + "§7Expira em: §c§l2 dias" + "\n"
					+ "§7Data do banimento: §c§l" + HorarioAPI.getHorario() + "\n"
					+ "§fCompre §9§lUNBAN §fem nossa loja: §6§lmc-cookie.com.br" + "\n"
					+ "§fBanimento incorreto? Contate-nos pelo Twitter §b§l@Cookie_Suporte§f!");
			vitimatime.kickPlayer("§fVoc\u00ea foi banido §9§lTEMPORARIAMENTE§f do servidor!\n§7Jogador banido: §c§l"
					+ vitima.getName() + "\n" + "§7Banido por: §c§l" + jogador.getName() + "\n"
					+ "§7Motivo: §c§lTime na warp Fps" + "\n" + "§7Expira em: §c§l2 dias" + "\n"
					+ "§7Data do banimento: §c§l" + HorarioAPI.getHorario() + "\n"
					+ "§fCompre §9§lUNBAN §fem nossa loja: §6§lmc-cookie.com.br" + "\n"
					+ "§fBanimento incorreto? Contate-nos pelo Twitter §b§l@Cookie_Suporte§f!");
			TweetAPI.update("\ud83d\udd10 Jogadores banidos: " + vitima.getName() + " e " + vitimatime.getName() + "\n"
					+ "Banidos por: " + jogador.getName() + "\n" + "Motivo: Time na warp Fps" + "\n"
					+ "Expira em: 2 dias");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
					(Object) jogador.getName());
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo",
					(Object) "Time na FPS");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban",
					(Object) "2 dias");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId() + ".Nome",
					(Object) vitimatime.getName());
			Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId() + ".Banido por",
					(Object) jogador.getName());
			Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId() + ".Motivo",
					(Object) "Time na FPS");
			Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId() + ".Tempo do Ban",
					(Object) "2 dias");
			Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempBans();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) == null
							&& Config.getConfig().getTempBans().get("TempBans." + vitimatime.getUniqueId()) != null) {
						Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId(), (Object) null);
						Config.getConfig().saveTempBans();
						API.sendBC("§cO jogador " + vitimatime.getName() + " foi desbanido automaticamente.");
						API.sendStaff("§7O jogador " + vitimatime.getName() + " foi desbanido automaticamente");
					} else if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null
							&& Config.getConfig().getTempBans().get("TempBans." + vitimatime.getUniqueId()) == null) {
						Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempBans();
						API.sendBC("§cO jogador " + vitima.getName() + " foi desbanido automaticamente");
						API.sendStaff("§7O jogador " + vitima.getName() + " foi desbanido automaticamente");
					} else if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null
							&& Config.getConfig().getTempBans().get("TempBans." + vitimatime.getUniqueId()) != null) {
						Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId(), (Object) null);
						Config.getConfig().saveTempBans();
						API.sendStaff("§c" + vitima.getName() + " e " + vitimatime.getName()
								+ " foram desbanidos pelo CONSOLE");
					}
				}
			}, 3456000L);
			return true;
		} else {
			if (args[1].equalsIgnoreCase("oftell")) {
				API.sendMsg((CommandSender) jogador,
						"§3§lTEMPBAN §fVoc\u00ea baniu §3§lTEMPORARIAMENTE §fo jogador: §6§l" + vitima.getName()
								+ "§f.");
				API.sendStaff("§3§lTEMPBAN §f" + jogador.getName() + " baniu §3§lTEMPORARIAMENTE §fo jogador §6§l"
						+ vitima.getName() + ". Motivo: §c§lOfensa por Tell");
				vitima.kickPlayer("§fVoc\u00ea foi banido §9§lTEMPORARIAMENTE§f do servidor!\n§7Jogador banido: §c§l"
						+ vitima.getName() + "\n" + "§7Banido por: §c§l" + jogador.getName() + "\n"
						+ "§7Motivo: §c§lOfensa por tell" + "\n" + "§7Expira em: §c§l2 dias" + "\n"
						+ "§7Data do banimento: §c§l" + HorarioAPI.getHorario() + "\n"
						+ "§fCompre §9§lUNBAN §fem nossa loja: §6§lmc-cookie.com.br" + "\n"
						+ "§fBanimento incorreto? Contate-nos pelo Twitter §b§l@Cookie_Suporte§f!");
				TweetAPI.update("\ud83d\udd10 Jogador banido: " + vitima.getName() + "\n" + "Banido por: "
						+ jogador.getName() + "\n" + "Motivo: Ofensa pelo Tell" + "\n" + "Expira em: 2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome",
						(Object) vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
						(Object) jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo",
						(Object) "Ofensa pelo Tell");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban",
						(Object) "2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
						(Object) HorarioAPI.getHorario());
				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), (Object) null);
							API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desbanido por: §c§lCONSOLE");
							API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§DESBANIDO §fautomaticamente!");
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("citlink")) {
				API.sendMsg((CommandSender) jogador,
						"§3§lTEMPBAN §fVoc\u00ea baniu §3§lTEMPORARIAMENTE §fo jogador: §6§l" + vitima.getName()
								+ "§f.");
				API.sendStaff("§3§lTEMPBAN §f" + jogador.getName() + " baniu §3§lTEMPORARIAMENTE §fo jogador §6§l"
						+ vitima.getName() + ". Motivo: §c§lCita\u00e7\u00e3o de links externos");
				vitima.kickPlayer("§fVoc\u00ea foi banido §9§lTEMPORARIAMENTE§f do servidor!\n§7Jogador banido: §c§l"
						+ vitima.getName() + "\n" + "§7Banido por: §c§l" + jogador.getName() + "\n"
						+ "§7Motivo: §c§lCita\u00e7\u00e3o de links externos" + "\n" + "§7Expira em: §c§l2 dias" + "\n"
						+ "§7Data do banimento: §c§l" + HorarioAPI.getHorario() + "\n"
						+ "§fCompre §9§lUNBAN §fem nossa loja: §6§lmc-cookie.com.br" + "\n"
						+ "§fBanimento incorreto? Contate-nos pelo Twitter §b§l@Cookie_Suporte§f!");
				TweetAPI.update("\ud83d\udd10 Jogador banido: " + vitima.getName() + "\n" + "Banido por: "
						+ jogador.getName() + "\n" + "Motivo: Citar links externos" + "\n" + "Expira em: 2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome",
						(Object) vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
						(Object) jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo",
						(Object) "Citar links externos");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban",
						(Object) "2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
						(Object) HorarioAPI.getHorario());
				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), (Object) null);
							Config.getConfig().saveTempBans();
							API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desbanido por: §c§lCONSOLE");
							API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§DESBANIDO §fautomaticamente!");
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("fident")) {
				API.sendMsg((CommandSender) jogador,
						"§3§lTEMPBAN §fVoc\u00ea baniu §3§lTEMPORARIAMENTE §fo jogador: §6§l" + vitima.getName()
								+ "§f.");
				API.sendStaff("§3§lTEMPBAN §f" + jogador.getName() + " baniu §3§lTEMPORARIAMENTE §fo jogador §6§l"
						+ vitima.getName() + ". Motivo: §c§lFalsidade ideol\u00f3gica");
				vitima.kickPlayer("§fVoc\u00ea foi banido §9§lTEMPORARIAMENTE§f do servidor!\n§7Jogador banido: §c§l"
						+ vitima.getName() + "\n" + "§7Banido por: §c§l" + jogador.getName() + "\n"
						+ "§7Motivo: §c§lFalsidade ideol\u00f3gica" + "\n" + "§7Expira em: §c§l2 dias" + "\n"
						+ "§7Data do banimento: §c§l" + HorarioAPI.getHorario() + "\n"
						+ "§fCompre §9§lUNBAN §fem nossa loja: §6§lmc-cookie.com.br" + "\n"
						+ "§fBanimento incorreto? Contate-nos pelo Twitter §b§l@Cookie_Suporte§f!");
				TweetAPI.update("\ud83d\udd10 Jogador banido: " + vitima.getName() + "\n" + "Banido por: "
						+ jogador.getName() + "\n" + "Motivo: Falsidade ideol\u00f3gica" + "\n" + "Expira em: 7 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome",
						(Object) vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por",
						(Object) jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo",
						(Object) "Falsa identidade");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban",
						(Object) "7 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento",
						(Object) HorarioAPI.getHorario());
				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), (Object) null);
							Config.getConfig().saveTempBans();
							API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desbanido por: §c§lCONSOLE");
							API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§DESBANIDO §fautomaticamente!");
						}
					}
				}, 12096000L);
				return true;
			}
			API.sendMsg((CommandSender) jogador, "§3§lTEMPBAN §fUtilize §3§l/tempban §3(jogador) (sigla)");
			API.sendMsg((CommandSender) jogador, " ");
			API.sendMsg((CommandSender) jogador, "§2§lSIGLAS §fAbaixo segue a lista de siglas e seus significados...");
			API.sendMsg((CommandSender) jogador, " ");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lftell §f- §8(Flood no tell)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lffa §f- §8(Free for all)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§ltfps §f- §8(Time na fps)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lfkill §f- §8(Freekill)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lofs §f- §8(Ofensa a staff)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§loftell §f- §8(Ofensa pelo tell)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§labug §f- §8(Abuso de bugs)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lcitlink §f- §8(Cita\u00e7\u00e3o de links externos)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lident §f- §8(Falsidade ideol\u00f3gica)");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
	}
}
