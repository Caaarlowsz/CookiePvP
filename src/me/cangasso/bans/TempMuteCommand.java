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

public class TempMuteCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player jogador = (Player) sender;
		if (!cmd.getName().equalsIgnoreCase("tempmute")) {
			return false;
		}
		if (!cfGrupo.ChecarGrupo(jogador, "Dono") && !cfGrupo.ChecarGrupo(jogador, "Gerente")
				&& !cfGrupo.ChecarGrupo(jogador, "Admin") && !cfGrupo.ChecarGrupo(jogador, "Mod+")
				&& !cfGrupo.ChecarGrupo(jogador, "Mod") && !cfGrupo.ChecarGrupo(jogador, "Trial")
				&& !cfGrupo.ChecarGrupo(jogador, "Youtuber+") && !cfGrupo.ChecarGrupo(jogador, "Helper")) {
			API.sendMsg((CommandSender) jogador,
					"§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para utilizar este comando!");
			return true;
		}
		if (args.length == 0) {
			API.sendMsg((CommandSender) jogador, "§b§lTEMPMUTE §fUtilize §b§l/tempmute §b(jogador) (sigla)");
			API.sendMsg((CommandSender) jogador, " ");
			API.sendMsg((CommandSender) jogador, "§2§lSIGLAS §fAbaixo segue a lista de siglas e seus significados...");
			API.sendMsg((CommandSender) jogador, " ");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lflood §f- §8(Floodar os chats do servidor) ");
			API.sendMsg((CommandSender) jogador,
					"§6\u2022 §3§lpdvip §f- §8(Solicitar VIP para algum membro da equipe sem qualquer prop\u00f3sito) ");
			API.sendMsg((CommandSender) jogador,
					"§6\u2022 §3§lpdstaff §f- §8(Solicitar algum cargo na equipe sem a necessidade de formul\u00e1rios) ");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lofj §f- §8(Ofensa aos jogadores)");
			API.sendMsg((CommandSender) jogador,
					"§6\u2022 §3§lcitch §f- §8(Citar qualquer canal do Youtube com o intuito de divulgar o pr\u00f3prio ou terceiros)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lcitsv §f- §8(Citar o nome de qualquer outro servidor)");
			API.sendMsg((CommandSender) jogador,
					"§6\u2022 §3§lcomercio §f- §8(Comercializa\u00e7\u00e3o: Venda ou troca de produtos materiais ou virtuais)");
			API.sendMsg((CommandSender) jogador,
					"§6\u2022 §3§lspam §f- §8(Spammar nos chats do servidor. Falar coisas sem fundamento com a finalidade de atingir)");
			API.sendMsg((CommandSender) jogador,
					"§6\u2022 §3§lcplk §f- §8(Falar continuamente com a tecla Caps-Lock ativada, mesmo ap\u00f3s alguma advert\u00eancia)");
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
			API.sendMsg((CommandSender) jogador, "§cVoc\u00ea n\u00e3o pode mutar a si mesmo!");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (Config.getConfig().getMute().get("Mute." + vitima.getUniqueId()) != null) {
			API.sendMsg((CommandSender) jogador,
					"§fO jogador §6§l" + vitima.getName() + "§f j\u00e1 est\u00e1 §9§lMUTADO§f!");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
			API.sendMsg((CommandSender) jogador,
					"§fO jogador §6§l" + vitima.getName() + " §fj\u00e1 est\u00e1 §9§lMUTADO§f! ");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (args.length == 1) {
			API.sendMsg((CommandSender) jogador, "§b§lTEMPMUTE §fUtilize §b§l/tempmute §b(jogador) (sigla)");
			API.sendMsg((CommandSender) jogador, " ");
			API.sendMsg((CommandSender) jogador, "§2§lSILAS §fAbaixo segue a lista de siglas e seus significados...");
			API.sendMsg((CommandSender) jogador, " ");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lflood §f- §8(Floodar os chats do servidor) ");
			API.sendMsg((CommandSender) jogador,
					"§6\u2022 §3§lpdvip §f- §8(Solicitar VIP para algum membro da equipe sem qualquer prop\u00f3sito) ");
			API.sendMsg((CommandSender) jogador,
					"§6\u2022 §3§lpdstaff §f- §8(Solicitar algum cargo na equipe sem a necessidade de formul\u00e1rios) ");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lofj §f- §8(Ofensa aos jogadores)");
			API.sendMsg((CommandSender) jogador,
					"§6\u2022 §3§lcitch §f- §8(Citar qualquer canal do Youtube com o intuito de divulgar o pr\u00f3prio ou terceiros)");
			API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lcitsv §f- §8(Citar o nome de qualquer outro servidor)");
			API.sendMsg((CommandSender) jogador,
					"§6\u2022 §3§lcomercio §f- §8(Comercializa\u00e7\u00e3o: Venda ou troca de produtos materiais ou virtuais)");
			API.sendMsg((CommandSender) jogador,
					"§6\u2022 §3§lspam §f- §8(Spammar nos chats do servidor. Falar coisas sem fundamento; com a finalidade de atingir)");
			API.sendMsg((CommandSender) jogador,
					"§6\u2022 §3§lcplk §f- §8(Falar continuamente com a tecla Caps-Lock ativada, mesmo ap\u00f3s alguma advert\u00eancia)");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		if (args[1].equalsIgnoreCase("flood")) {
			API.sendMsg((CommandSender) jogador, "§aVoc\u00ea mutou temporariamente o jogador " + vitima);
			API.sendStaff("§c" + jogador.getName() + " mutou temporariamente o jogador " + vitima.getName()
					+ ". Motivo: Flood");
			API.sendMsg((CommandSender) jogador,
					"§cVoc\u00ea foi mutado temporariamente. Por: " + jogador.getName() + "§c. Motivo: Flood");
			TweetAPI.update("Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: " + jogador.getName() + "\n"
					+ "Motivo: Flood" + "\n" + "Expira em: 2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
					(Object) jogador.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", (Object) "Flood");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute",
					(Object) "2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempMute();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
						API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
						API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§lDESMUTADO §fautomaticamente!");
						Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempMute();
					}
				}
			}, 3456000L);
			return true;
		}
		if (args[1].equalsIgnoreCase("pdvip")) {
			API.sendMsg((CommandSender) jogador, "§b§lTEMPMUTE §fVoc\u00ea mutou o jogador §6§l" + vitima.getName()
					+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lPedir Vip");
			API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
					+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§l");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fVoc\u00ea foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
					+ jogador.getName() + "§f. Motivo §c§lPedir Vip§f.");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");
			TweetAPI.update("\ud83d\udd10 Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: "
					+ jogador.getName() + "\n" + "Motivo: Pedir VIP" + "\n" + "Expira em: 2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
					(Object) jogador.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", (Object) "Pedir VIP");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute",
					(Object) "2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempMute();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
						API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
						API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§lDESMUTADO §fautomaticamente!");
						Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempMute();
					}
				}
			}, 3456000L);
			return true;
		}
		if (args[1].equalsIgnoreCase("pdstaff")) {
			API.sendMsg((CommandSender) jogador, "§b§lTEMPMUTE §fVoc\u00ea mutou o jogador §6§l" + vitima.getName()
					+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lPedir Staff");
			API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
					+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lPedir Staff");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fVoc\u00ea foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
					+ jogador.getName() + "§f. Motivo §c§lPedir Staff§f.");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l3 dias§f.");
			TweetAPI.update("\ud83d\udd10 Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: "
					+ jogador.getName() + "\n" + "Motivo: Pedir Staff" + "\n" + "Expira em: 3 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
					(Object) jogador.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo",
					(Object) "Pedir Staff");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute",
					(Object) "3 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempMute();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
						API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
						API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§lDESMUTADO §fautomaticamente!");
						Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempMute();
					}
				}
			}, 5184000L);
			return true;
		}
		if (args[1].equalsIgnoreCase("ofj")) {
			API.sendMsg((CommandSender) jogador, "§b§lTEMPMUTE §fVoc\u00ea mutou o jogador §6§l" + vitima.getName()
					+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lOfensa a Jogador");
			API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
					+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lOfensa a Jogador");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fVoc\u00ea foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
					+ jogador.getName() + "§f. Motivo §c§lOfensa a Jogador§f.");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");
			TweetAPI.update("\ud83d\udd10 Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: "
					+ jogador.getName() + "\n" + "Motivo: Ofensa a Jogador(es)" + "\n" + "Expira em: 2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
					(Object) jogador.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo",
					(Object) "Ofensa a Jogador(es)");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute",
					(Object) "2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempMute();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
						API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
						API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§lDESMUTADO §fautomaticamente!");
						Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempMute();
					}
				}
			}, 3456000L);
			return true;
		}
		if (args[1].equalsIgnoreCase("citch")) {
			API.sendMsg((CommandSender) jogador, "§b§lTEMPMUTE §fVoc\u00ea mutou o jogador §6§l" + vitima.getName()
					+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lCita\u00e7\u00e3o de Canais");
			API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
					+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lCita\u00e7\u00e3o de Canais");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fVoc\u00ea foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
					+ jogador.getName() + "§f. Motivo §c§lCita\u00e7\u00e3o de Canais§f.");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");
			TweetAPI.update("\ud83d\udd10 Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: "
					+ jogador.getName() + "\n" + "Motivo: Citar caians" + "\n" + "Expira em: 2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
					(Object) jogador.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo",
					(Object) "Citar canais");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute",
					(Object) "2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempMute();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
						API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
						API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§lDESMUTADO §fautomaticamente!");
						Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempMute();
					}
				}
			}, 3456000L);
			return true;
		}
		if (args[1].equalsIgnoreCase("citsv")) {
			API.sendMsg((CommandSender) jogador, "§b§lTEMPMUTE §fVoc\u00ea mutou o jogador §6§l" + vitima.getName()
					+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lCita\u00e7\u00e3o de Servidores");
			API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
					+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lCita\u00e7\u00e3o de Servidores");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fVoc\u00ea foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
					+ jogador.getName() + "§f. Motivo §c§lCita\u00e7\u00e3o de Servidores§f.");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");
			TweetAPI.update("\ud83d\udd10 Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: "
					+ jogador.getName() + "\n" + "Motivo: Citar servidores" + "\n" + "Expira em: 2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
					(Object) jogador.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo",
					(Object) "Citar servidores");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute",
					(Object) "2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempMute();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
						API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
						API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§lDESMUTADO §fautomaticamente!");
						Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempMute();
					}
				}
			}, 3456000L);
			return true;
		}
		if (args[1].equalsIgnoreCase("comercio")) {
			API.sendMsg((CommandSender) jogador, "§b§lTEMPMUTE §fVoc\u00ea mutou o jogador §6§l" + vitima.getName()
					+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lComercializa\u00e7\u00e3o");
			API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
					+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lComercializa\u00e7\u00e3o");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fVoc\u00ea foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
					+ jogador.getName() + "§f. Motivo §c§lComercializa\u00e7\u00e3o§f.");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");
			TweetAPI.update("\ud83d\udd10 Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: "
					+ jogador.getName() + "\n" + "Motivo: Comercio no servidor" + "\n" + "Expira em: 2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
					(Object) jogador.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo",
					(Object) "Comercio no servidor");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute",
					(Object) "2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempMute();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
						API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
						API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§lDESMUTADO §fautomaticamente!");
						Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempMute();
					}
				}
			}, 3456000L);
			return true;
		}
		if (args[1].equalsIgnoreCase("spam")) {
			API.sendMsg((CommandSender) jogador, "§b§lTEMPMUTE §fVoc\u00ea mutou o jogador §6§l" + vitima.getName()
					+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lSpam");
			API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
					+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lSpam");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fVoc\u00ea foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
					+ jogador.getName() + "§f. Motivo §c§lSpam§f.");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");
			TweetAPI.update("\ud83d\udd10 Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: "
					+ jogador.getName() + "\n" + "Motivo: Spam" + "\n" + "Expira em: 2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
					(Object) jogador.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", (Object) "Spam");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute",
					(Object) "2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempMute();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
						API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
						API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§lDESMUTADO §fautomaticamente!");
						Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempMute();
					}
				}
			}, 3456000L);
			return true;
		}
		if (args[1].equalsIgnoreCase("caps")) {
			API.sendMsg((CommandSender) jogador, "§b§lTEMPMUTE §fVoc\u00ea mutou o jogador §6§l" + vitima.getName()
					+ " §b§lTEMPORARIAMENTE§f. Motivo: §c§lCaps-Lock");
			API.sendStaff("§b§lTEMPMUTE §f" + jogador.getName() + " mutou o jogador §6§l" + vitima.getName()
					+ "§b§l TEMPORARIAMENTE§f. Motivo: §c§lCaps-Lock");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fVoc\u00ea foi §b§lMUTADO TEMPORARIAMENTE§f. Por: §4§l"
					+ jogador.getName() + "§f. Motivo §c§lCaps-Lock§f.");
			API.sendMsg((CommandSender) vitima, "§b§lTEMPMUTE §fO seu §b§lTEMPMUTE §facaba em §3§l2 dias§f.");
			TweetAPI.update("\ud83d\udd10 Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: "
					+ jogador.getName() + "\n" + "Motivo: CapsLock" + "\n" + "Expira em: 2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome",
					(Object) vitima.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por",
					(Object) jogador.getName());
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", (Object) "CapsLock");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute",
					(Object) "2 dias");
			Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute",
					(Object) HorarioAPI.getHorario());
			Config.getConfig().saveTempMute();
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {
						API.sendStaff("§6§lPARDON §f" + vitima.getName() + " foi desmutado por: §c§lCONSOLE");
						API.sendMsg((CommandSender) vitima, "§fVoc\u00ea foi §6§lDESMUTADO §fautomaticamente!");
						Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), (Object) null);
						Config.getConfig().saveTempMute();
					}
				}
			}, 3456000L);
			return true;
		}
		API.sendMsg((CommandSender) jogador, "§b§lTEMPMUTE §fUtilize §b§l/tempmute §b(jogador) (sigla)");
		API.sendMsg((CommandSender) jogador, " ");
		API.sendMsg((CommandSender) jogador, "§2§lSILAS §fAbaixo segue a lista de siglas e seus significados...");
		API.sendMsg((CommandSender) jogador, " ");
		API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lflood §f- §8(Floodar os chats do servidor) ");
		API.sendMsg((CommandSender) jogador,
				"§6\u2022 §3§lpdvip §f- §8(Solicitar VIP para algum membro da equipe sem qualquer prop\u00f3sito) ");
		API.sendMsg((CommandSender) jogador,
				"§6\u2022 §3§lpdstaff §f- §8(Solicitar algum cargo na equipe sem a necessidade de formul\u00e1rios) ");
		API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lofj §f- §8(Ofensa aos jogadores)");
		API.sendMsg((CommandSender) jogador,
				"§6\u2022 §3§lcitch §f- §8(Citar qualquer canal do Youtube com o intuito de divulgar o pr\u00f3prio ou terceiros)");
		API.sendMsg((CommandSender) jogador, "§6\u2022 §3§lcitsv §f- §8(Citar o nome de qualquer outro servidor)");
		API.sendMsg((CommandSender) jogador,
				"§6\u2022 §3§lcomercio §f- §8(Comercializa\u00e7\u00e3o: Venda ou troca de produtos materiais ou virtuais)");
		API.sendMsg((CommandSender) jogador,
				"§6\u2022 §3§lspam §f- §8(Spammar nos chats do servidor. Falar coisas sem fundamento; com a finalidade de atingir)");
		API.sendMsg((CommandSender) jogador,
				"§6\u2022 §3§lcplk §f- §8(Falar continuamente com a tecla Caps-Lock ativada, mesmo ap\u00f3s alguma advert\u00eancia)");
		API.sendSound(jogador, Sound.NOTE_PLING, 10);
		return true;
	}
}
