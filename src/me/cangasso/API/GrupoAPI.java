package me.cangasso.API;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import me.cangasso.configura\u00e7\u00e3o.cfTempGrupo;
import me.cangasso.events.CorGrupo;
import me.cangasso.main.Main;
import me.cangasso.scoreboard.sScoreAPI;

public class GrupoAPI {
	public static boolean Checando;

	public static void expirar(final Player p, final int dia, final int mes, final int ano, final int hora,
			final int minutos, final int segundos) {
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Nick", (Object) p.getName());
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Dia", (Object) dia);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Mes", (Object) mes);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Ano", (Object) ano);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Hora", (Object) hora);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Minuto", (Object) minutos);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Segundos", (Object) segundos);
		cfTempGrupo.salvarconfiguracao();
		checarVip(p);
		if (cfGrupo.ChecarGrupo(p, "DONO")) {
			CorGrupo.setarTag(p, "§4§l");
		} else if (cfGrupo.ChecarGrupo(p, "GERENTE")) {
			CorGrupo.setarTag(p, "§3§l");
		} else if (cfGrupo.ChecarGrupo(p, "ADMIN")) {
			CorGrupo.setarTag(p, "§c§l");
		} else if (cfGrupo.ChecarGrupo(p, "MOD+")) {
			CorGrupo.setarTag(p, "§5§l");
		} else if (cfGrupo.ChecarGrupo(p, "MOD")) {
			CorGrupo.setarTag(p, "§5§l");
		} else if (cfGrupo.ChecarGrupo(p, "TRIAL")) {
			CorGrupo.setarTag(p, "§5§l");
		} else if (cfGrupo.ChecarGrupo(p, "YOUTUBER+")) {
			CorGrupo.setarTag(p, "§3§l");
		} else if (cfGrupo.ChecarGrupo(p, "HELPER")) {
			CorGrupo.setarTag(p, "§d§l");
		} else if (cfGrupo.ChecarGrupo(p, "YOUTUBER")) {
			CorGrupo.setarTag(p, "§b§l");
		} else if (cfGrupo.ChecarGrupo(p, "S-PRO")) {
			CorGrupo.setarTag(p, "§e§l");
		} else if (cfGrupo.ChecarGrupo(p, "PRO")) {
			CorGrupo.setarTag(p, "§6§l");
		} else if (cfGrupo.ChecarGrupo(p, "MVP")) {
			CorGrupo.setarTag(p, "§9§l");
		} else if (cfGrupo.ChecarGrupo(p, "LIGHT")) {
			CorGrupo.setarTag(p, "§a§l");
		} else if (cfGrupo.ChecarGrupo(p, "MEMBRO")) {
			CorGrupo.setarTag(p, "§7§l");
		}
		sScoreAPI.scoreboard(p);
		p.chat("/tag " + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo"));
	}

	public static void expirarOffline(final OfflinePlayer p, final int dia, final int mes, final int ano,
			final int hora, final int minutos, final int segundos) {
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Nick", (Object) p.getName());
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Dia", (Object) dia);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Mes", (Object) mes);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Ano", (Object) ano);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Hora", (Object) hora);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Minuto", (Object) minutos);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Segundos", (Object) segundos);
		cfTempGrupo.salvarconfiguracao();
		checarVipOffline(p);
	}

	public static void checarVip(final Player p) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				if (cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Dia") != null
						&& cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Mes") != null
						&& cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Ano") != null
						&& cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Hora") != null
						&& cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Minuto") != null
						&& cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Segundos") != null
						&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Dia") < CalendarioAPI
								.PegarCalendario(CalendarioAPI.Calendario.Dia)
								|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
										+ ".Dia") == CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Dia)
										&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
												|| cfGrupo.ChecarGrupo(p, "Light"))))
						&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Mes") < CalendarioAPI
								.PegarCalendario(CalendarioAPI.Calendario.Mes)
								|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
										+ ".Mes") == CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Mes)
										&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
												|| cfGrupo.ChecarGrupo(p, "Light"))))
						&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Ano") < CalendarioAPI
								.PegarCalendario(CalendarioAPI.Calendario.Ano)
								|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
										+ ".Ano") == CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Ano)
										&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
												|| cfGrupo.ChecarGrupo(p, "Light"))))
						&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Hora") < CalendarioAPI
								.PegarCalendario(CalendarioAPI.Calendario.Hora)
								|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
										+ ".Hora") == CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Hora)
										&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
												|| cfGrupo.ChecarGrupo(p, "Light"))))
						&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Minuto") < CalendarioAPI
								.PegarCalendario(CalendarioAPI.Calendario.Minuto)
								|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
										+ ".Minuto") == CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Minuto)
										&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
												|| cfGrupo.ChecarGrupo(p, "Light"))))
						&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
								+ ".Segundos") < CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Segundo)
								|| (cfTempGrupo.pegargrupo()
										.getInt("tempgrupos." + p.getUniqueId() + ".Segundos") == CalendarioAPI
												.PegarCalendario(CalendarioAPI.Calendario.Segundo)
										&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
												|| cfGrupo.ChecarGrupo(p, "Light"))))) {
					API.mandarTitulo(p, "§6§lCookie§f§lNetwork");
					API.mandarSubTitulo(p, "§7Seu VIP [§6§l"
							+ cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo") + "§7] expirou");
					cfGrupo.salvarconfiguracao();
					Bukkit.getConsoleSender().sendMessage(
							"§6§lCookie§f§lNetwork §7» §fO Vip do jogador §6§l" + p.getName() + " §fexpirou.");
					p.sendMessage("§6§lCookie§f§lNetwork §7» §fO seu Vip §7(§d§l"
							+ cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo") + "§7) §fexpirou");
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Nick", (Object) null);
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".grupo", (Object) null);
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Dia", (Object) null);
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Mes", (Object) null);
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Ano", (Object) null);
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Hora", (Object) null);
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Minuto", (Object) null);
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Segundos", (Object) null);
					cfTempGrupo.salvarconfiguracao();
					Player[] onlinePlayers;
					for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
						final Player todos = onlinePlayers[i];
						if (cfGrupo.ChecarGrupo(todos, "Dono") || cfGrupo.ChecarGrupo(todos, "Gerente")
								|| cfGrupo.ChecarGrupo(todos, "Admin")) {
							todos.sendMessage("§6§lCookie§f§lNetwork §6» §7O VIP [§6§l"
									+ cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo")
									+ "§7] do jogador §6" + p.getName() + " §7expirou");
						}
					}
					cfGrupo.setarGrupo(p, "MEMBRO");
					if (cfGrupo.ChecarGrupo(p, "DONO")) {
						CorGrupo.setarTag(p, "§4§l");
					} else if (cfGrupo.ChecarGrupo(p, "GERENTE")) {
						CorGrupo.setarTag(p, "§c§l");
					} else if (cfGrupo.ChecarGrupo(p, "ADMIN")) {
						CorGrupo.setarTag(p, "§c§l");
					} else if (cfGrupo.ChecarGrupo(p, "MOD+")) {
						CorGrupo.setarTag(p, "§5§l");
					} else if (cfGrupo.ChecarGrupo(p, "MOD")) {
						CorGrupo.setarTag(p, "§5§l");
					} else if (cfGrupo.ChecarGrupo(p, "TRIAL")) {
						CorGrupo.setarTag(p, "§5§l");
					} else if (cfGrupo.ChecarGrupo(p, "YOUTUBER+")) {
						CorGrupo.setarTag(p, "§3§l");
					} else if (cfGrupo.ChecarGrupo(p, "BUILDER")) {
						CorGrupo.setarTag(p, "§2§l");
					} else if (cfGrupo.ChecarGrupo(p, "HELPER")) {
						CorGrupo.setarTag(p, "§e§l");
					} else if (cfGrupo.ChecarGrupo(p, "YOUTUBER")) {
						CorGrupo.setarTag(p, "§b§l");
					} else if (cfGrupo.ChecarGrupo(p, "S-PRO")) {
						CorGrupo.setarTag(p, "§e§l");
					} else if (cfGrupo.ChecarGrupo(p, "PRO")) {
						CorGrupo.setarTag(p, "§6§l");
					} else if (cfGrupo.ChecarGrupo(p, "MVP")) {
						CorGrupo.setarTag(p, "§9§l");
					} else if (cfGrupo.ChecarGrupo(p, "LIGHT")) {
						CorGrupo.setarTag(p, "§a§l");
					} else if (cfGrupo.ChecarGrupo(p, "MEMBRO")) {
						CorGrupo.setarTag(p, "§7§l");
					}
					sScoreAPI.scoreboard(p);
					p.chat("/tag normal");
				}
			}
		}, 0L, 20L);
	}

	public static void checarVipOffline(final OfflinePlayer p) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				if ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Dia") < CalendarioAPI
						.PegarCalendario(CalendarioAPI.Calendario.Dia)
						|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Dia") == CalendarioAPI
								.PegarCalendario(CalendarioAPI.Calendario.Dia) && !cfGrupo.ChecarGrupo(p, "Membro")))
						&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Mes") < CalendarioAPI
								.PegarCalendario(CalendarioAPI.Calendario.Mes)
								|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
										+ ".Mes") == CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Mes)
										&& !cfGrupo.ChecarGrupo(p, "Membro")))
						&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Ano") < CalendarioAPI
								.PegarCalendario(CalendarioAPI.Calendario.Ano)
								|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
										+ ".Ano") == CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Ano)
										&& !cfGrupo.ChecarGrupo(p, "Membro")))
						&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Hora") < CalendarioAPI
								.PegarCalendario(CalendarioAPI.Calendario.Hora)
								|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
										+ ".Hora") == CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Hora)
										&& !cfGrupo.ChecarGrupo(p, "Membro")))
						&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Minuto") < CalendarioAPI
								.PegarCalendario(CalendarioAPI.Calendario.Minuto)
								|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
										+ ".Minuto") == CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Minuto)
										&& !cfGrupo.ChecarGrupo(p, "Membro")))
						&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
								+ ".Segundos") < CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Segundo)
								|| (cfTempGrupo.pegargrupo()
										.getInt("tempgrupos." + p.getUniqueId() + ".Segundos") == CalendarioAPI
												.PegarCalendario(CalendarioAPI.Calendario.Segundo)
										&& !cfGrupo.ChecarGrupo(p, "Membro")))
						&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
								|| cfGrupo.ChecarGrupo(p, "Light"))) {
					cfGrupo.salvarconfiguracao();
					Bukkit.getConsoleSender().sendMessage(
							"§6§lCookie§f§lNetwork §7» §7O VIP do jogador §6" + p.getName() + " §7expirou");
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Nick", (Object) null);
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".grupo", (Object) null);
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Dia", (Object) null);
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Mes", (Object) null);
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Ano", (Object) null);
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Hora", (Object) null);
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Minuto", (Object) null);
					cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Segundos", (Object) null);
					cfTempGrupo.salvarconfiguracao();
					Player[] onlinePlayers;
					for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
						final Player todos = onlinePlayers[i];
						if (cfGrupo.ChecarGrupo(todos, "Dono") || cfGrupo.ChecarGrupo(todos, "Gerente")
								|| cfGrupo.ChecarGrupo(todos, "Admin")) {
							todos.sendMessage("§6§lCookie§f§lNetwork §7» §7O VIP [§6§l"
									+ cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo")
									+ "§7] do jogador §6" + p.getName() + " §7expirou");
						}
					}
					cfGrupo.setarGrupo(p, "Membro");
				}
			}
		}, 0L, 20L);
	}
}
