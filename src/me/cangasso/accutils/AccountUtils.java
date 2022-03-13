package me.cangasso.accutils;

import org.bukkit.OfflinePlayer;

import me.cangasso.configuração.cfGrupo;
import me.cangasso.configuração.cfStatus;
import net.md_5.bungee.api.ChatColor;

public class AccountUtils {
	public static String getRankOffline(final OfflinePlayer p) {
		final double a = cfStatus.getKillsOff(p);
		if (a <= 100.0) {
			return "�f\u268a";
		}
		if (a <= 200.0) {
			return ChatColor.GREEN + "\u268c";
		}
		if (a <= 300.0) {
			return ChatColor.YELLOW + "\u2630";
		}
		if (a <= 400.0) {
			return "�1\u2725";
		}
		if (a <= 500.0) {
			return "�7\u272f";
		}
		if (a <= 600.0) {
			return "�6\u272a";
		}
		if (a <= 700.0) {
			return ChatColor.AQUA + "�b\u2748";
		}
		if (a <= 800.0) {
			return "�2\u2738";
		}
		if (a <= 900.0) {
			return ChatColor.RED + "\u2739";
		}
		if (a <= 1000.0) {
			return "�3\u2737";
		}
		if (a <= 1500.0) {
			return "�4\u2742";
		}
		return "�4\u2742";
	}

	public static String getRankNomeOffline(final OfflinePlayer p) {
		final double a = cfStatus.getKillsOff(p);
		if (a <= 100.0) {
			return "�fNOOB";
		}
		if (a <= 200.0) {
			return "�aINICIANTE";
		}
		if (a <= 300.0) {
			return "�eAPRENDIZ";
		}
		if (a <= 400.0) {
			return "�1EXPERT";
		}
		if (a <= 500.0) {
			return "�7SILVER";
		}
		if (a <= 600.0) {
			return "�6GOLD";
		}
		if (a <= 700.0) {
			return "�bDIAMOND";
		}
		if (a <= 800.0) {
			return "�2EMERALD";
		}
		if (a <= 900.0) {
			return "�cRUBY";
		}
		if (a <= 1000.0) {
			return "�3SAFIRA";
		}
		if (a <= 1500.0) {
			return "�4LENDARIO";
		}
		return "�4LENDARIO";
	}

	public static String getGrupo(final OfflinePlayer p) {
		if (cfGrupo.ChecarGrupo(p, "Membro")) {
			return "�7�lMEMBRO";
		}
		if (cfGrupo.ChecarGrupo(p, "light")) {
			return "�a�lVIP";
		}
		if (cfGrupo.ChecarGrupo(p, "Mvp")) {
			return "�9�lMVP";
		}
		if (cfGrupo.ChecarGrupo(p, "Pro")) {
			return "�6�lPRO";
		}
		if (cfGrupo.ChecarGrupo(p, "S-Pro")) {
			return "�e�lSEMIYT";
		}
		if (cfGrupo.ChecarGrupo(p, "Youtuber")) {
			return "�b�lYOUTUBER";
		}
		if (cfGrupo.ChecarGrupo(p, "Youtuber+")) {
			return "�3�lYOUTUBER+";
		}
		if (cfGrupo.ChecarGrupo(p, "Helper")) {
			return "�d�lHELPER";
		}
		if (cfGrupo.ChecarGrupo(p, "Builder")) {
			return "�2�lBUILDER";
		}
		if (cfGrupo.ChecarGrupo(p, "Trial")) {
			return "�d�lTRIAL";
		}
		if (cfGrupo.ChecarGrupo(p, "Mod")) {
			return "�5�lMOD";
		}
		if (cfGrupo.ChecarGrupo(p, "Mod+")) {
			return "�5�lMOD+";
		}
		if (cfGrupo.ChecarGrupo(p, "Gerente")) {
			return "�c�lGERENTE";
		}
		if (cfGrupo.ChecarGrupo(p, "Admin")) {
			return "�c�lADMIN";
		}
		if (cfGrupo.ChecarGrupo(p, "Dono")) {
			return "�4�lDONO";
		}
		return "�4�lDONO";
	}
}
