package me.cangasso.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.spigotmc.ProtocolInjector;

import me.cangasso.bossbar.api.BossBarAPI;
import me.cangasso.commands.GiveAllCommand;
import me.cangasso.configuração.cfConfig;
import me.cangasso.configuração.cfGrupo;
import me.cangasso.configuração.cfKitdiario;
import me.cangasso.configuração.cfPermissão;
import me.cangasso.configuração.cfStatus;
import me.cangasso.configuração.cfTempGrupo;
import me.cangasso.events.CorGrupo;
import me.cangasso.habilidades.Ajnin;
import me.cangasso.habilidades.Ninja;
import me.cangasso.habilidades.Strong;
import me.cangasso.invencivel.Proteção;
import me.cangasso.main.CookiePvP;
import me.cangasso.nametag.Array;
import me.cangasso.nametag.NametagManager;
import me.cangasso.nametag.NametagUtils;
import me.cangasso.nametag.PlayerLoader;
import me.cangasso.scoreboard.sScoreAPI;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.Packet;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;

public class API {
	public static ArrayList<Player> inCombat;
	private static HashMap<Player, String> Warp;

	static {
		API.inCombat = new ArrayList<Player>();
		API.Warp = new HashMap<Player, String>();
	}

	public static void BarAPI(final Player p, final String menssagem) {
		final int numero = 20;
		BossBarAPI.setMessage(p, menssagem);
		Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				BossBarAPI.removeBar(p);
			}
		}, (long) (numero * 4));
	}

	public static void checarGrupo(final Player p) {
		if (cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") == null) {
			cfGrupo.setarGrupo(p, "Membro");
			cfGrupo.salvarconfiguracao();
		} else if (cfGrupo.pegargrupo().get("configuração." + p.getUniqueId() + ".PadraoKit") == null) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "PvP");
			cfConfig.salvarconfiguracao();
		}
	}

	public static void setarKitPadrao(final Player p) {
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("PvP")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "PvP");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Archer")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Archer");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Kangaroo")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Kangaroo");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit")
				.equals("Fisherman")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit",
					(Object) "Fisherman");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Cactus")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Cactus");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Monk")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Monk");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Ninja")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Ninja");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Phantom")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Phantom");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Grappler")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Grappler");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Viper")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Viper");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Snail")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Snail");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Hulk")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Hulk");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Timelord")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Timelord");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Thor")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Thor");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Switcher")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Switcher");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit")
				.equals("Gladiator")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit",
					(Object) "Gladiator");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Stomper")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Stomper");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Magma")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Magma");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Grandpa")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Grandpa");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Ajnin")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Ajnin");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit")
				.equals("FireLauncher")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit",
					(Object) "FireLauncher");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Strong")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Strong");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Sumo")) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "Sumo");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals(null)) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "PvP");
			cfConfig.salvarconfiguracao();
		}
	}

	public static void corGrupo(final Player p) {
		if (cfGrupo.ChecarGrupo(p, "Dono")) {
			CorGrupo.setarTag(p, "�4�l");
		} else if (cfGrupo.ChecarGrupo(p, "Gerente")) {
			CorGrupo.setarTag(p, "�3�l");
		} else if (cfGrupo.ChecarGrupo(p, "Admin")) {
			CorGrupo.setarTag(p, "�c�l");
		} else if (cfGrupo.ChecarGrupo(p, "Mod+")) {
			CorGrupo.setarTag(p, "�5�l");
		} else if (cfGrupo.ChecarGrupo(p, "Mod")) {
			CorGrupo.setarTag(p, "�5�l");
		} else if (cfGrupo.ChecarGrupo(p, "Trial")) {
			CorGrupo.setarTag(p, "�5�l");
		} else if (cfGrupo.ChecarGrupo(p, "Youtuber+")) {
			CorGrupo.setarTag(p, "�3�l");
		} else if (cfGrupo.ChecarGrupo(p, "Builder")) {
			CorGrupo.setarTag(p, "�2�l");
		} else if (cfGrupo.ChecarGrupo(p, "Helper")) {
			CorGrupo.setarTag(p, "�9�l");
		} else if (cfGrupo.ChecarGrupo(p, "Youtuber")) {
			CorGrupo.setarTag(p, "�b�l");
		} else if (cfGrupo.ChecarGrupo(p, "S-Pro")) {
			CorGrupo.setarTag(p, "�e�l");
		} else if (cfGrupo.ChecarGrupo(p, "Pro")) {
			CorGrupo.setarTag(p, "�6�l");
		} else if (cfGrupo.ChecarGrupo(p, "Mvp")) {
			CorGrupo.setarTag(p, "�9�l");
		} else if (cfGrupo.ChecarGrupo(p, "Light")) {
			CorGrupo.setarTag(p, "�a�l");
		} else if (cfGrupo.ChecarGrupo(p, "Membro")) {
			CorGrupo.setarTag(p, "�7�l");
		}
	}

	public static void acharTag(final Player p) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				API.checarGrupo(p);
				if (cfGrupo.ChecarGrupo(p, "Dono")) {
					p.chat("/tag dono");
				}
				if (cfGrupo.ChecarGrupo(p, "Admin")) {
					p.chat("/tag admin");
				}
				if (cfGrupo.ChecarGrupo(p, "Gerente")) {
					p.chat("/tag gerente");
				}
				if (cfGrupo.ChecarGrupo(p, "Mod+")) {
					p.chat("/tag modplus");
				}
				if (cfGrupo.ChecarGrupo(p, "Mod")) {
					p.chat("/tag mod");
				}
				if (cfGrupo.ChecarGrupo(p, "Trial")) {
					p.chat("/tag trial");
				}
				if (cfGrupo.ChecarGrupo(p, "Youtuber+")) {
					p.chat("/tag youtuber+");
				}
				if (cfGrupo.ChecarGrupo(p, "Builder")) {
					p.chat("/tag builder");
				}
				if (cfGrupo.ChecarGrupo(p, "Helper")) {
					p.chat("/tag helper");
				}
				if (cfGrupo.ChecarGrupo(p, "Youtuber")) {
					p.chat("/tag youtuber");
				}
				if (cfGrupo.ChecarGrupo(p, "Pro")) {
					p.chat("/tag pro");
				}
				if (cfGrupo.ChecarGrupo(p, "S-Pro")) {
					p.chat("/tag semiyt");
				}
				if (cfGrupo.ChecarGrupo(p, "Mvp")) {
					p.chat("/tag mvp");
				}
				if (cfGrupo.ChecarGrupo(p, "Light")) {
					p.chat("/tag vip");
				}
				if (cfGrupo.ChecarGrupo(p, "Membro")) {
					p.chat("/tag normal");
				}
				if (GiveAllCommand.pro && cfGrupo.ChecarGrupo(p, "Membro")) {
					p.chat("/tag pro");
				}
				if (GiveAllCommand.mvp && cfGrupo.ChecarGrupo(p, "Membro")) {
					p.chat("/tag mvp");
				}
				if (GiveAllCommand.light && cfGrupo.ChecarGrupo(p, "Membro")) {
					p.chat("/tag vip");
				}
			}
		}, 2L);
	}

	public static void checarAlgumasCoisas(final Player p) {
		if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin")
				&& !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod")
				&& !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Pro")
				&& !cfGrupo.ChecarGrupo(p, "Youtuber")
				&& cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".dia") == null) {
			p.sendMessage("�6�lCookie�f�lNetwork �7� �fVoc\u00ea j\u00e1 pode pegar o seu kit di\u00e1rio!");
		}
		sendItems(p);
		if (cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Dia") != null
				&& cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Mes") != null
				&& cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Ano") != null
				&& cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Hora") != null
				&& cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Minuto") != null
				&& cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Segundos") != null
				&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Dia") < CalendarioAPI
						.PegarCalendario(CalendarioAPI.Calendario.Dia)
						|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Dia") == CalendarioAPI
								.PegarCalendario(CalendarioAPI.Calendario.Dia)
								&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
										|| cfGrupo.ChecarGrupo(p, "Light"))))
				&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Mes") < CalendarioAPI
						.PegarCalendario(CalendarioAPI.Calendario.Mes)
						|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Mes") == CalendarioAPI
								.PegarCalendario(CalendarioAPI.Calendario.Mes)
								&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
										|| cfGrupo.ChecarGrupo(p, "Light"))))
				&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Ano") < CalendarioAPI
						.PegarCalendario(CalendarioAPI.Calendario.Ano)
						|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Ano") == CalendarioAPI
								.PegarCalendario(CalendarioAPI.Calendario.Ano)
								&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
										|| cfGrupo.ChecarGrupo(p, "Light"))))
				&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Hora") < CalendarioAPI
						.PegarCalendario(CalendarioAPI.Calendario.Hora)
						|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Hora") == CalendarioAPI
								.PegarCalendario(CalendarioAPI.Calendario.Hora)
								&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
										|| cfGrupo.ChecarGrupo(p, "Light"))))
				&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Minuto") < CalendarioAPI
						.PegarCalendario(CalendarioAPI.Calendario.Minuto)
						|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
								+ ".Minuto") == CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Minuto)
								&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
										|| cfGrupo.ChecarGrupo(p, "Light"))))
				&& (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Segundos") < CalendarioAPI
						.PegarCalendario(CalendarioAPI.Calendario.Segundo)
						|| (cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId()
								+ ".Segundos") == CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Segundo)
								&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
										|| cfGrupo.ChecarGrupo(p, "Light"))))) {
			mandarTitulo(p, "�6�lCookie�f�lNetwork");
			mandarSubTitulo(p, "�6�lCookie�f�lNetwork �7� O seu VIP "
					+ cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo") + " �7acabou de expirar!");
			cfGrupo.salvarconfiguracao();
			Bukkit.getConsoleSender().sendMessage(
					"�6�lCookie�f�lNetwork �7� �fO VIP do jogador �6�l" + p.getName() + " �facabou de expirar!");
			p.sendMessage("�6�lCookie�f�lNetwork �7� �7O seu VIP "
					+ cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo") + "�7 acabou de expirar!");
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
					todos.sendMessage("�6�lCookie�f�lNetwork �7� �fO VIP "
							+ cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo")
							+ "�f do jogador �6�l" + p.getName() + " �facagou de expirar!");
				}
			}
			cfGrupo.setarGrupo(p, "Membro");
			if (cfGrupo.ChecarGrupo(p, "Dono")) {
				CorGrupo.setarTag(p, "�4�l");
			} else if (cfGrupo.ChecarGrupo(p, "Gerente")) {
				CorGrupo.setarTag(p, "�3�l");
			} else if (cfGrupo.ChecarGrupo(p, "Admin")) {
				CorGrupo.setarTag(p, "�c�l");
			} else if (cfGrupo.ChecarGrupo(p, "Mod+")) {
				CorGrupo.setarTag(p, "�5�l");
			} else if (cfGrupo.ChecarGrupo(p, "Mod")) {
				CorGrupo.setarTag(p, "�5�l");
			} else if (cfGrupo.ChecarGrupo(p, "Trial")) {
				CorGrupo.setarTag(p, "�5�l");
			} else if (cfGrupo.ChecarGrupo(p, "Youtuber+")) {
				CorGrupo.setarTag(p, "�3�l");
			} else if (cfGrupo.ChecarGrupo(p, "Builder")) {
				CorGrupo.setarTag(p, "�2�l");
			} else if (cfGrupo.ChecarGrupo(p, "Helper")) {
				CorGrupo.setarTag(p, "�e�l");
			} else if (cfGrupo.ChecarGrupo(p, "Youtuber")) {
				CorGrupo.setarTag(p, "�b�l");
			} else if (cfGrupo.ChecarGrupo(p, "S-Pro")) {
				CorGrupo.setarTag(p, "�e�l");
			} else if (cfGrupo.ChecarGrupo(p, "Pro")) {
				CorGrupo.setarTag(p, "�6�l");
			} else if (cfGrupo.ChecarGrupo(p, "Mvp")) {
				CorGrupo.setarTag(p, "�9�l");
			} else if (cfGrupo.ChecarGrupo(p, "Light")) {
				CorGrupo.setarTag(p, "�a�l");
			} else if (cfGrupo.ChecarGrupo(p, "Membro")) {
				CorGrupo.setarTag(p, "�7�l");
			}
			sScoreAPI.scoreboard(p);
			p.chat("/tag normal");
		}
	}

	public static void checarNameTag(final Player p) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				NametagManager.MandarTeamsParaJogador(p);
				NametagManager.Limpar(p.getName());
				final LinkedHashMap<String, String> pData = PlayerLoader.getPlayer(p.getName());
				if (pData != null) {
					String Prefix = pData.get("prefix");
					String Suffix = pData.get("suffix");
					if (Prefix != null) {
						Prefix = NametagUtils.formatColors(Prefix);
					}
					if (Suffix != null) {
						Suffix = NametagUtils.formatColors(Suffix);
					}
					if (Array.consolePrintEnabled) {
						System.out.println(
								"Setting prefix/suffix for " + p.getName() + ": " + Prefix + ", " + Suffix + " (user)");
					}
					NametagManager.Overlap(p.getName(), Prefix, Suffix);
				}
			}
		}, 1L);
		Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				API.acharTag(p);
			}
		}, 2L);
	}

	public static void checarConfig(final Player p) {
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".Nick") == null) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Nick", (Object) p.getName());
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit") == null) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", (Object) "PvP");
			cfConfig.salvarconfiguracao();
		}
		if (cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".Tell") == null) {
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Tell", (Object) "Ativado");
			cfConfig.salvarconfiguracao();
		}
		cfConfig.salvarconfiguracao();
	}

	public static void checarPermissao(final Player p) {
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.monk") == null) {
			cfPermissão.setarPermissao(p, "kit.monk", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.ninja") == null) {
			cfPermissão.setarPermissao(p, "kit.ninja", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.phantom") == null) {
			cfPermissão.setarPermissao(p, "kit.phantom", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.grappler") == null) {
			cfPermissão.setarPermissao(p, "kit.grappler", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.viper") == null) {
			cfPermissão.setarPermissao(p, "kit.viper", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.snail") == null) {
			cfPermissão.setarPermissao(p, "kit.snail", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.hulk") == null) {
			cfPermissão.setarPermissao(p, "kit.hulk", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.timelord") == null) {
			cfPermissão.setarPermissao(p, "kit.timelord", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.thor") == null) {
			cfPermissão.setarPermissao(p, "kit.thor", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.switcher") == null) {
			cfPermissão.setarPermissao(p, "kit.switcher", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.gladiator") == null) {
			cfPermissão.setarPermissao(p, "kit.gladiator", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.endermage") == null) {
			cfPermissão.setarPermissao(p, "kit.endermage", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.stomper") == null) {
			cfPermissão.setarPermissao(p, "kit.stomper", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.magma") == null) {
			cfPermissão.setarPermissao(p, "kit.magma", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.grandpa") == null) {
			cfPermissão.setarPermissao(p, "kit.grandpa", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.ajnin") == null) {
			cfPermissão.setarPermissao(p, "kit.ajnin", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.firelauncher") == null) {
			cfPermissão.setarPermissao(p, "kit.firelauncher", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.strong") == null) {
			cfPermissão.setarPermissao(p, "kit.strong", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.forcefield") == null) {
			cfPermissão.setarPermissao(p, "kit.forcefield", "false");
		}
		if (cfPermissão.pegarpermissao().get("permiss\u00f5es." + p.getUniqueId() + ".kit.sumo") == null) {
			cfPermissão.setarPermissao(p, "kit.sumo", "false");
		}
	}

	public static ItemStack criarItem(final Player p, final Material material, final String nome, final String[] lore,
			final int quantidade, final short cor) {
		final ItemStack item = new ItemStack(material, quantidade, cor);
		final ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(lore));
		item.setItemMeta(kitem);
		return item;
	}

	public static String getWarp(final Player p) {
		if (API.Warp.containsKey(p)) {
			return API.Warp.get(p);
		}
		return "Spawn";
	}

	public static void setWarp(final Player p, final String warp) {
		API.Warp.put(p, warp);
	}

	public static void sendItems(final Player p) {
		if (getWarp(p) == "Spawn") {
			p.getInventory().setArmorContents((ItemStack[]) null);
			Ajnin.a.remove(p);
			Ninja.a.remove(p);
			Ninja.b.remove(p);
			Strong.fulliron.remove(p);
			p.setFoodLevel(20);
			p.setFireTicks(0);
			cfStatus.RemoverKS(p);
			setWarp(p, "Spawn");
			final ItemStack Kits = new ItemStack(Material.CHEST);
			final ItemMeta kKits = Kits.getItemMeta();
			kKits.setDisplayName("�8\u27bc �a�lKITS");
			kKits.setLore(Arrays.asList("�7Confira aqui os kits que voc\u00ea possui e afins!"));
			Kits.setItemMeta(kKits);
			final ItemStack Warps = new ItemStack(Material.NAME_TAG);
			final ItemMeta kWarps = Warps.getItemMeta();
			kWarps.setDisplayName("�8\u27bc �6�lWARPS");
			kWarps.setLore(Arrays.asList("�7Confira aqui as Warps dispon\u00edveis em nosso servidor!"));
			Warps.setItemMeta(kWarps);
			final ItemStack Loja = new ItemStack(Material.EMERALD);
			final ItemMeta kLoja = Loja.getItemMeta();
			kLoja.setDisplayName("�8\u27bc �2�lLOJA");
			kLoja.setLore(Arrays.asList("�7Clique neste item para obter a URL de nossa loja!"));
			Loja.setItemMeta(kLoja);
			final ItemStack Rank = new ItemStack(Material.FLOWER_POT_ITEM);
			final ItemMeta kRank = Rank.getItemMeta();
			kRank.setDisplayName("�8\u27bc �a�lAJUSTES");
			kRank.setLore(Arrays.asList("�7Ajuste as suas configuraç\u00f5es pessoais!"));
			Rank.setItemMeta(kRank);
			final ItemStack Heads = new ItemStack(Material.NOTE_BLOCK);
			final ItemMeta kHeads = Heads.getItemMeta();
			kHeads.setDisplayName("�8\u27bc �b�lHEADS");
			kHeads.setLore(Arrays.asList("�7Selecione uma cabeça!"));
			Heads.setItemMeta(kHeads);
			final ItemStack Caixas = new ItemStack(Material.ENDER_CHEST);
			final ItemMeta kCaixas = Caixas.getItemMeta();
			kCaixas.setDisplayName("�8\u27bc �6�lKIT DIARIO");
			kCaixas.setLore(Arrays.asList("�7A cada 24 horas, receba um kit aleat\u00f3rio!"));
			Caixas.setItemMeta(kCaixas);
			final ItemStack KitPadrao = new ItemStack(Material.getMaterial(351), 1, (short) 14);
			final ItemMeta kKitPadrao = KitPadrao.getItemMeta();
			kKitPadrao.setDisplayName("�8\u27bc �a�lKIT PADRAO");
			kKitPadrao.setLore(Arrays.asList("�7Selecione um kit para ser \u00fanico!"));
			KitPadrao.setItemMeta(kKitPadrao);
			final ItemStack Vidro = new ItemStack(Material.AIR, 1, (short) 7);
			final ItemMeta kVidro = Caixas.getItemMeta();
			kVidro.setDisplayName("");
			kVidro.setLore(Arrays.asList(""));
			Vidro.setItemMeta(kVidro);
			p.getInventory().clear();
			p.getInventory().setArmorContents((ItemStack[]) null);
			Proteção.setImortal(p, true);
			p.setHealth(20.0);
			p.setMaxHealth(20.0);
			sScoreAPI.scoreboard(p);
			CooldownAPI.tirarCooldown(p);
			WarpsAPI.Ir(p, "Spawn");
			if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".dia") == null) {
				p.getInventory().setItem(8, Caixas);
			}
			p.getInventory().setHeldItemSlot(4);
			p.getInventory().setItem(4, Kits);
			p.getInventory().setItem(2, Warps);
			p.getInventory().setItem(6, Loja);
			p.getInventory().setItem(0, Heads);
			p.getInventory().setItem(3, Vidro);
			p.getInventory().setItem(5, Vidro);
		}
	}

	public static int getAmount(final Player p, final Material m) {
		int amount = 0;
		ItemStack[] contents;
		for (int length = (contents = p.getInventory().getContents()).length, i = 0; i < length; ++i) {
			final ItemStack item = contents[i];
			if (item != null && item.getType() == m && item.getAmount() > 0) {
				amount += item.getAmount();
			}
		}
		return amount;
	}

	public static void mandarTitulo(final Player player, final String titulo) {
		if (((CraftPlayer) player).getHandle().playerConnection.networkManager.getVersion() < 45) {
			return;
		}
		((CraftPlayer) player).getHandle().playerConnection
				.sendPacket((Packet) new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TITLE,
						ChatSerializer.a("{\"text\": \"\"}").a(titulo)));
	}

	public static void mandarSubTitulo(final Player player, final String titulo) {
		if (((CraftPlayer) player).getHandle().playerConnection.networkManager.getVersion() < 45) {
			return;
		}
		((CraftPlayer) player).getHandle().playerConnection
				.sendPacket((Packet) new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE,
						ChatSerializer.a("{\"text\": \"\"}").a(titulo)));
	}

	public static void mandarActionBar(final Player player, final String titulo) {
		final CraftPlayer p = (CraftPlayer) player;
		if (p.getHandle().playerConnection.networkManager.getVersion() != 47) {
			return;
		}
		final IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + titulo + "\"}");
		final PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, 2);
		p.getHandle().playerConnection.sendPacket((Packet) ppoc);
		p.getHandle().playerConnection.sendPacket((Packet) ppoc);
	}

	public static void clear(final Player player) {
		if (((CraftPlayer) player).getHandle().playerConnection.networkManager.getVersion() < 45) {
			return;
		}
		((CraftPlayer) player).getHandle().playerConnection
				.sendPacket((Packet) new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.CLEAR));
	}

	public static void setHotbar(final Player p) {
		final ItemStack Kits = new ItemStack(Material.CHEST);
		final ItemMeta kKits = Kits.getItemMeta();
		kKits.setDisplayName("�8\u27bc �a�KITS ");
		kKits.setLore(Arrays.asList("�7Confira aqui os kits que voc\u00ea possui e afins!"));
		Kits.setItemMeta(kKits);
		final ItemStack Ranks = new ItemStack(Material.ENCHANTED_BOOK);
		final ItemMeta kRanks = Ranks.getItemMeta();
		kRanks.setDisplayName("�8\u27bc  �5�lRANKS");
		kRanks.setLore(Arrays.asList("�7Confira a lista de ranks!"));
		Ranks.setItemMeta(kRanks);
		final ItemStack Warps = new ItemStack(Material.NAME_TAG);
		final ItemMeta kWarps = Warps.getItemMeta();
		kWarps.setDisplayName("�8\u27bc �6�lWARPS");
		kWarps.setLore(Arrays.asList("�7Confira as Warps dispon\u00edveis em nosso servidor!"));
		Warps.setItemMeta(kWarps);
		final ItemStack Loja = new ItemStack(Material.EMERALD);
		final ItemMeta kLoja = Loja.getItemMeta();
		kLoja.setDisplayName("�8\u27bc �2�lLOJA");
		kLoja.setLore(Arrays.asList("�7Clique �7�nneste item �7para obter a URL de nossa loja."));
		Loja.setItemMeta(kLoja);
		final ItemStack Rank = new ItemStack(Material.FLOWER_POT_ITEM);
		final ItemMeta kRank = Rank.getItemMeta();
		kRank.setDisplayName("�a�nConfiguraç\u00f5es pessoais!");
		kRank.setLore(Arrays.asList("�7Ajuste as suas configuraç\u00f5es pessoais!"));
		Rank.setItemMeta(kRank);
		final ItemStack Heads = new ItemStack(Material.NOTE_BLOCK);
		final ItemMeta kHeads = Heads.getItemMeta();
		kHeads.setDisplayName("�8\u27bc �b�lHEADS");
		kHeads.setLore(Arrays.asList("�7Selecione, neste menu", "�7uma cabeca para ser colocada"));
		Heads.setItemMeta(kHeads);
		final ItemStack Caixas = new ItemStack(Material.ENDER_CHEST);
		final ItemMeta kCaixas = Caixas.getItemMeta();
		kCaixas.setDisplayName("�8\u27bc �aKIT DIARIO");
		kCaixas.setLore(Arrays.asList("�7A cada 24 horas, receba um kit aleat\u00f3rio!"));
		Caixas.setItemMeta(kCaixas);
		final ItemStack KitPadrao = new ItemStack(Material.getMaterial(351), 1, (short) 14);
		final ItemMeta kKitPadrao = KitPadrao.getItemMeta();
		kKitPadrao.setDisplayName("�8\u27bc �a�lKIT PADRAO");
		kKitPadrao.setLore(Arrays.asList("�7Escolha um kit para ser \u00fanico!"));
		KitPadrao.setItemMeta(kKitPadrao);
		final ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
		final BookMeta bm = (BookMeta) book.getItemMeta();
		bm.setAuthor("�6�lCookie�f�lNetwork");
		bm.setTitle("�a�lAtualizaç\u00f5es de 2017");
		final ArrayList<String> pages = new ArrayList<String>();
		pages.add(
				"�7Seja muito bem-vindo ao �6�lCookiep�f�lNetwork �3�l3.0�7. �7Gostar\u00edamos de inform\u00e1-los que ap\u00f3s \u00e1rduos dias de duro trabalho e dedicação de cada membro da equipe, conseguimos trazer uma grande atualização! �f- �7Foi implementada novas �6�lWARPS�7, �9�lTAGS �7e �a�lKITS�7! �7Caso voc\u00ea encontre algum erro, reporte-o em nosso �7Twiter�7: �b�l@_McCookie \n \n �7�oAtenciosamente, Cangasso �f- �4�oDesenvolvedor");
		bm.setPages(pages);
		book.setItemMeta((ItemMeta) bm);
		final ItemStack Vidro = new ItemStack(Material.AIR, 1, (short) 7);
		final ItemMeta kVidro = Caixas.getItemMeta();
		kVidro.setDisplayName("");
		kVidro.setLore(Arrays.asList(""));
		Vidro.setItemMeta(kVidro);
		if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".dia") == null) {
			p.getInventory().setItem(8, Caixas);
		}
		p.getInventory().setHeldItemSlot(4);
		p.getInventory().setItem(4, Kits);
		p.getInventory().setItem(2, Warps);
		p.getInventory().setItem(3, Ranks);
		p.getInventory().setItem(0, Heads);
		p.getInventory().setItem(3, Vidro);
		p.getInventory().setItem(5, Vidro);
	}

	public static void sendWarn(final String msg) {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player todos = onlinePlayers[i];
			if (cfGrupo.ChecarGrupo(todos, "Dono") || cfGrupo.ChecarGrupo(todos, "Gerente")) {
				Player[] onlinePlayers2;
				for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
					final Player k = onlinePlayers2[j];
					if ((cfGrupo.ChecarGrupo(k, "Dono") || cfGrupo.ChecarGrupo(k, "Gerente")
							|| cfGrupo.ChecarGrupo(k, "Admin") || cfGrupo.ChecarGrupo(k, "Mod+")
							|| cfGrupo.ChecarGrupo(k, "Mod") || cfGrupo.ChecarGrupo(k, "Trial")
							|| cfGrupo.ChecarGrupo(k, "Youtuber+") || cfGrupo.ChecarGrupo(k, "Helper"))
							&& ArraysAPI.Monitor.contains(todos)) {
						todos.sendMessage(msg);
						return;
					}
				}
			}
		}
	}
}
