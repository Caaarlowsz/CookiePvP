package me.cangasso.API;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.cangasso.configuração.cfGrupo;
import me.cangasso.configuração.cfKitdiario;
import me.cangasso.configuração.cfPermissão;
import me.cangasso.main.CookiePvP;

public class KitdiarioAPI {
	public static void iniciarContagem(final Player p) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".dia") != null && (CalendarioAPI
						.PegarCalendario(CalendarioAPI.Calendario.Dia) > cfKitdiario.pegargrupo()
								.getInt("kitdiario." + p.getUniqueId() + ".dia") + 1
						|| CalendarioAPI.PegarCalendario(CalendarioAPI.Calendario.Dia) == cfKitdiario.pegargrupo()
								.getInt("kitdiario." + p.getUniqueId() + ".dia") + 1)) {
					if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Ajnin")) {
						cfPermissão.setarPermissao(p, "kit.ajnin", "false");
					}
					if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Monk")) {
						cfPermissão.setarPermissao(p, "kit.monk", "false");
					}
					if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Hulk")) {
						cfPermissão.setarPermissao(p, "kit.hulk", "false");
					}
					if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Timelord")) {
						cfPermissão.setarPermissao(p, "kit.timelord", "false");
					}
					if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Grappler")) {
						cfPermissão.setarPermissao(p, "kit.grappler", "false");
					}
					if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Phantom")) {
						cfPermissão.setarPermissao(p, "kit.phantom", "false");
					}
					if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Ninja")) {
						cfPermissão.setarPermissao(p, "kit.ninja", "false");
					}
					if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Viper")) {
						cfPermissão.setarPermissao(p, "kit.viper", "false");
					}
					if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Snail")) {
						cfPermissão.setarPermissao(p, "kit.snail", "false");
					}
					if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".kit").equals("Magma")) {
						cfPermissão.setarPermissao(p, "kit.magma", "false");
					}
					cfPermissão.salvarconfiguracao();
					cfKitdiario.pegargrupo().set("kitdiario." + p.getUniqueId() + ".Nick", (Object) null);
					cfKitdiario.pegargrupo().set("kitdiario." + p.getUniqueId() + ".kit", (Object) null);
					cfKitdiario.pegargrupo().set("kitdiario." + p.getUniqueId() + ".dia", (Object) null);
					cfKitdiario.pegargrupo().set("kitdiario." + p.getUniqueId() + ".hora", (Object) null);
					cfKitdiario.pegargrupo().set("kitdiario." + p.getUniqueId() + ".minuto", (Object) null);
					cfKitdiario.pegargrupo().set("kitdiario." + p.getUniqueId() + ".segundos", (Object) null);
					cfKitdiario.salvarconfiguracao();
				}
			}
		}, 0L, 20L);
	}

	public static void kitdiario(final Player p) {
		if (!cfGrupo.ChecarGrupo(p, "Membro") && !cfGrupo.ChecarGrupo(p, "Light") && !cfGrupo.ChecarGrupo(p, "Mvp")
				&& !cfGrupo.ChecarGrupo(p, "Trial")) {
			p.sendMessage(
					"�cVoc\u00ea j\u00e1 possui todos os kits. Não tem o porqu\u00ea de pegar o kit di\u00e1rio!");
			return;
		}
		final Random random = new Random();
		if (cfPermissão.getPermissao(p, "kit.monk") && cfPermissão.getPermissao(p, "kit.ajnin")
				&& cfPermissão.getPermissao(p, "kit.hulk") && cfPermissão.getPermissao(p, "kit.timelord")
				&& cfPermissão.getPermissao(p, "kit.grappler") && cfPermissão.getPermissao(p, "kit.phantom")
				&& cfPermissão.getPermissao(p, "kit.ninja") && cfPermissão.getPermissao(p, "kit.viper")
				&& cfPermissão.getPermissao(p, "kit.snail") && cfPermissão.getPermissao(p, "kit.magma")) {
			p.sendMessage("�6�lCookie�f�lNetwork �7� �fVoc\u00ea j\u00e1 possui todos os kits!");
		} else {
			switch (random.nextInt(10)) {
			case 1: {
				p.sendMessage("�6�lCookie�f�lNetwork �7� �7Voc\u00ea recebeu o kit: �6�lMONK");
				cfPermissão.setarPermissao(p, "kit.monk", "true");
				cfKitdiario.setarTempo(p, "Monk");
				iniciarContagem(p);
				break;
			}
			case 2: {
				p.sendMessage("�6�lCookie�f�lNetwork �7� �7Voc\u00ea recebeu o kit: �6�lAJNIN");
				cfPermissão.setarPermissao(p, "kit.ajnin", "true");
				cfKitdiario.setarTempo(p, "Ajnin");
				iniciarContagem(p);
				break;
			}
			case 3: {
				p.sendMessage("�6�lCookie�f�lNetwork �7� �7Voc\u00ea recebeu o kit: �6�lHULK");
				cfPermissão.setarPermissao(p, "kit.hulk", "true");
				cfKitdiario.setarTempo(p, "Hulk");
				iniciarContagem(p);
				break;
			}
			case 4: {
				p.sendMessage("�6�lCookie�f�lNetwork �7� �7Voc\u00ea recebeu o kit: �6�lTIMELORD");
				cfPermissão.setarPermissao(p, "kit.timelord", "true");
				cfKitdiario.setarTempo(p, "Timelord");
				iniciarContagem(p);
				break;
			}
			case 5: {
				p.sendMessage("�6�lCookie�f�lNetwork �7� �7Voc\u00ea recebeu o kit: �6�lGRAPPLER");
				cfPermissão.setarPermissao(p, "kit.grappler", "true");
				cfKitdiario.setarTempo(p, "Grappler");
				iniciarContagem(p);
				break;
			}
			case 6: {
				p.sendMessage("�6�lCookie�f�lNetwork �7� �7Voc\u00ea recebeu o kit: �6�lPHANTOM");
				cfPermissão.setarPermissao(p, "kit.phantom", "true");
				cfKitdiario.setarTempo(p, "Phantom");
				iniciarContagem(p);
				break;
			}
			case 7: {
				p.sendMessage("�6�lCookie�f�lNetwork �7� �7Voc\u00ea recebeu o kit: �6�lNINJA");
				cfPermissão.setarPermissao(p, "kit.ninja", "true");
				cfKitdiario.setarTempo(p, "Ninja");
				iniciarContagem(p);
				break;
			}
			case 8: {
				p.sendMessage("�6�lCookie�f�lNetwork �7� �7Voc\u00ea recebeu o kit: �6�lVIPER");
				cfPermissão.setarPermissao(p, "kit.viper", "true");
				cfKitdiario.setarTempo(p, "Viper");
				iniciarContagem(p);
				break;
			}
			case 9: {
				p.sendMessage("�6�lCookie�f�lNetwork �7� �7Voc\u00ea recebeu o kit: �6�lSNAIL");
				cfPermissão.setarPermissao(p, "kit.snail", "true");
				cfKitdiario.setarTempo(p, "Snail");
				iniciarContagem(p);
				break;
			}
			case 10: {
				p.sendMessage("�6�lCookie�f�lNetwork �7� �7Voc\u00ea recebeu o kit: �6�lMAGMA");
				cfPermissão.setarPermissao(p, "kit.magma", "true");
				cfKitdiario.setarTempo(p, "Magma");
				iniciarContagem(p);
				break;
			}
			}
		}
	}
}
