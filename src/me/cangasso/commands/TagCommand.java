package me.cangasso.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.configuração.cfGrupo;
import me.cangasso.configuração.cfPermissão;
import me.cangasso.nametag.Array;
import me.cangasso.nametag.NameTagChangeEvento;
import me.cangasso.nametag.NametagUtils;
import me.cangasso.nametag.PlayerLoader;
import me.cangasso.scoreboard.sScoreAPI;

public class TagCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (!Cmd.getName().equalsIgnoreCase("tag")) {
			return false;
		}
		if (Args.length == 0) {
			p.sendMessage(
					"�6�lCookie�f�lNetwork �7� Use �6�l/tag (tag) �7para selecionar uma tag ou �6�l/tags �7para ver a sua lista de tags.");
			return true;
		}
		if (Args[0].equalsIgnoreCase("dev")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Admin")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �4�lDev");
				p.setDisplayName("�4�lDEV\u2615 �4" + p.getName());
				String prefix = "�4�l �4";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("builderplus")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin")
					|| cfGrupo.ChecarGrupo(p, "Mod+")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �2�oBuilderPlus");
				p.setDisplayName("�2�lBUILDER �2" + p.getName());
				String prefix = "�2�lBUILDER �2";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cTag inexistente.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("dono")) {
			if (cfGrupo.ChecarGrupo(p, "Dono")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �4�lDono");
				p.setDisplayName("�4�lDONO �4" + p.getName());
				String prefix = "�4�lDONO �4";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("gerente")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente")
					|| cfGrupo.ChecarGrupo(p, "Admin")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �cGerente");
				p.setDisplayName("�c�lGERENTE �c" + p.getName());
				String prefix = "�c�lGERENTE �c";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("admin")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Admin")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �cAdmin");
				p.setDisplayName("�c�lADMIN �c" + p.getName());
				String prefix = "�c�lADMIN �c";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("modplus")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin")
					|| cfGrupo.ChecarGrupo(p, "Mod+")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �5�oMod+");
				p.setDisplayName("�5�lMOD+ �5" + p.getName());
				String prefix = "�5�lMOD+ �5";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�aVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("mod")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin")
					|| cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �5Mod");
				p.setDisplayName("�5�lMOD �5" + p.getName());
				String prefix = "�5�lMOD �5";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("trial")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin")
					|| cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod")
					|| cfGrupo.ChecarGrupo(p, "Trial")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �dTrial");
				p.setDisplayName("�d�lTRIAL �d" + p.getName());
				String prefix = "�d�lTRIAL �d";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("builder")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente")
					|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Builder")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �2Builder");
				p.setDisplayName("�2�lBUILDER �2" + p.getName());
				String prefix = "�2�lBUILDER �2";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("helper")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin")
					|| cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod")
					|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Helper")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �d�oHelper");
				p.setDisplayName("�d�lHELPER �d" + p.getName());
				String prefix = "�d�lHELPER �d";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("youtuber+")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin")
					|| cfGrupo.ChecarGrupo(p, "Youtuber+")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �3�oYoutuber+");
				p.setDisplayName("�3�lYT+ �3" + p.getName());
				String prefix = "�3�lYT+ �3";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("exstaff")) {
			if (cfPermissão.getPermissao(p, "tag.exstaff")) {
				p.sendMessage("�cA tag ex-staff est\u00e1 em manutenção!");
				p.setDisplayName("�8�lEX-STAFF �7" + p.getName());
				String prefix = "�8";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("youtuber")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin")
					|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Youtuber")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �bYoutuber");
				p.setDisplayName("�b�lYOUTUBER �b" + p.getName());
				String prefix = "�b�lYOUTUBER �b";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("semiyt")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin")
					|| cfGrupo.ChecarGrupo(p, "S-Pro")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �eSemiYt");
				p.setDisplayName("�e�lSEMIYT �e" + p.getName());
				String prefix = "�e�lSEMIYT �e";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("pro")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Builder")
					|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Pro")
					|| cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Youtuber+")
					|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �6Pro");
				p.setDisplayName("�6�lPRO �6" + p.getName());
				String prefix = "�6�lPRO �6";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("mvp")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Gerente")
					|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Pro")
					|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Youtuber+")
					|| cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Trial")
					|| cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Mod+")
					|| cfGrupo.ChecarGrupo(p, "Mod")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �9Mvp");
				p.setDisplayName("�9�lMVP �9" + p.getName());
				String prefix = "�9�lMVP �9";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("vip")) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Gerente")
					|| cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Light")
					|| cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")
					|| cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Youtuber+")
					|| cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Trial")
					|| cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Mod")) {
				p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �aVip");
				p.setDisplayName("�a�lVIP �a" + p.getName());
				String prefix = "�a�lVIP �a";
				NameTagChangeEvento.NametagChangeReason reason = null;
				reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
				prefix = NametagUtils.formatColors(prefix);
				String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
				reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
				suffix = NametagUtils.formatColors(suffix);
				Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
				PlayerLoader.update(p.getName(), prefix, suffix);
			} else {
				p.sendMessage("�cVoc\u00ea não possui esta tag.");
			}
			return true;
		}
		if (Args[0].equalsIgnoreCase("normal")) {
			p.sendMessage("�8�l<�e�l!�8�l> �aVoc\u00ea escolheu a tag �7Normal");
			p.setDisplayName("�7" + p.getName());
			String prefix = "�0�7";
			NameTagChangeEvento.NametagChangeReason reason = null;
			reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			prefix = NametagUtils.formatColors(prefix);
			String suffix = " �7(" + sScoreAPI.getRank(p) + "�7)";
			reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			suffix = NametagUtils.formatColors(suffix);
			Array.SetarNameTagSoft(p.getName(), prefix, suffix, reason);
			PlayerLoader.update(p.getName(), prefix, suffix);
		} else {
			p.sendMessage("�cEssa tag não existe!");
		}
		return true;
	}
}
