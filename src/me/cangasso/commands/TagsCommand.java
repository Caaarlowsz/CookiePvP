package me.cangasso.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.configuração.cfGrupo;

public class TagsCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("tags")) {
			if (cfGrupo.ChecarGrupo(p, "Dono")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				p.sendMessage(" ");
				p.sendMessage("�6\u2022 �4Dono");
				p.sendMessage("�6\u2022 �4Dev");
				p.sendMessage("�6\u2022 �cAdmin");
				p.sendMessage("�6\u2022 �cGerente");
				p.sendMessage("�6\u2022 �5Mod+");
				p.sendMessage("�6\u2022 �5Mod");
				p.sendMessage("�6\u2022 �dTrial");
				p.sendMessage("�6\u2022 �dHelper");
				p.sendMessage("�6\u2022 �2Builder");
				p.sendMessage("�6\u2022 �2BuilderPlus");
				p.sendMessage("�6\u2022 �3YoutuberPlus");
				p.sendMessage("�6\u2022 �bYoutuber");
				p.sendMessage("�6\u2022 �eSemiyt");
				p.sendMessage("�6\u2022 �6Pro");
				p.sendMessage("�6\u2022 �9Mvp");
				p.sendMessage("�6\u2022 �aVip");
				p.sendMessage("�6\u2022 �7Normal");
				p.sendMessage(" ");
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				return true;
			}
			if (cfGrupo.ChecarGrupo(p, "Admin")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				p.sendMessage(" ");
				p.sendMessage("�6\u2022 �cAdmin");
				p.sendMessage("�6\u2022 �cGerente");
				p.sendMessage("�6\u2022 �5Mod+");
				p.sendMessage("�6\u2022 �5Mod");
				p.sendMessage("�6\u2022 �dTrial");
				p.sendMessage("�6\u2022 �dHelper");
				p.sendMessage("�6\u2022 �2Builder");
				p.sendMessage("�6\u2022 �2BuilderPlus");
				p.sendMessage("�6\u2022 �3YoutuberPlus");
				p.sendMessage("�6\u2022 �bYoutuber");
				p.sendMessage("�6\u2022 �eSemiyt");
				p.sendMessage("�6\u2022 �6Pro");
				p.sendMessage("�6\u2022 �9Mvp");
				p.sendMessage("�6\u2022 �aVip");
				p.sendMessage("�6\u2022 �7Normal");
				p.sendMessage(" ");
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				return true;
			}
			if (cfGrupo.ChecarGrupo(p, "Gerente")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				p.sendMessage(" ");
				p.sendMessage("�6\u2022 �cGerente");
				p.sendMessage("�6\u2022 �5Mod+");
				p.sendMessage("�6\u2022 �5Mod");
				p.sendMessage("�6\u2022 �dTrial");
				p.sendMessage("�6\u2022 �dHelper");
				p.sendMessage("�6\u2022 �2Builder");
				p.sendMessage("�6\u2022 �2BuilderPlus");
				p.sendMessage("�6\u2022 �3YoutuberPlus");
				p.sendMessage("�6\u2022 �bYoutuber");
				p.sendMessage("�6\u2022 �eSemiyt");
				p.sendMessage("�6\u2022 �6Pro");
				p.sendMessage("�6\u2022 �9Mvp");
				p.sendMessage("�6\u2022 �aVip");
				p.sendMessage("�6\u2022 �7Normal");
				p.sendMessage(" ");
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				return true;
			}
			if (cfGrupo.ChecarGrupo(p, "Mod+")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				p.sendMessage(" ");
				p.sendMessage("�6\u2022 �5Mod+");
				p.sendMessage("�6\u2022 �5Mod");
				p.sendMessage("�6\u2022 �dTrial");
				p.sendMessage("�6\u2022 �dHelper");
				p.sendMessage("�6\u2022 �2Builder");
				p.sendMessage("�6\u2022 �2BuilderPlus");
				p.sendMessage("�6\u2022 �6Pro");
				p.sendMessage("�6\u2022 �9Mvp");
				p.sendMessage("�6\u2022 �aVip");
				p.sendMessage("�6\u2022 �7Normal");
				p.sendMessage(" ");
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				return true;
			}
			if (cfGrupo.ChecarGrupo(p, "Mod")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				p.sendMessage(" ");
				p.sendMessage("�6\u2022 �5Mod");
				p.sendMessage("�6\u2022 �dTrial");
				p.sendMessage("�6\u2022 �dHelper");
				p.sendMessage("�6\u2022 �6Pro");
				p.sendMessage("�6\u2022 �9Mvp");
				p.sendMessage("�6\u2022 �aVip");
				p.sendMessage("�6\u2022 �7Normal");
				p.sendMessage(" ");
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				return true;
			}
			if (cfGrupo.ChecarGrupo(p, "Trial")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				p.sendMessage(" ");
				p.sendMessage("�6\u2022 �dTrial");
				p.sendMessage("�6\u2022 �dHelper");
				p.sendMessage("�6\u2022 �6Pro");
				p.sendMessage("�6\u2022 �9Mvp");
				p.sendMessage("�6\u2022 �aVip");
				p.sendMessage("�6\u2022 �7Normal");
				p.sendMessage(" ");
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				return true;
			}
			if (cfGrupo.ChecarGrupo(p, "Builder")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				p.sendMessage(" ");
				p.sendMessage("�6\u2022 �2Builder");
				p.sendMessage("�6\u2022 �9Mvp");
				p.sendMessage("�6\u2022 �aVip");
				p.sendMessage("�6\u2022 �7Normal");
				p.sendMessage(" ");
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				return true;
			}
			if (cfGrupo.ChecarGrupo(p, "Helper")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				p.sendMessage(" ");
				p.sendMessage("�6\u2022 �dHelper");
				p.sendMessage("�6\u2022 �7Normal");
				p.sendMessage(" ");
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				return true;
			}
			if (cfGrupo.ChecarGrupo(p, "Youtuber+")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				p.sendMessage(" ");
				p.sendMessage("�6\u2022 �3YoutuberPlus");
				p.sendMessage("�6\u2022 �bYoutuber");
				p.sendMessage("�6\u2022 �6Pro");
				p.sendMessage("�6\u2022 �9Mvp");
				p.sendMessage("�6\u2022 �aVip");
				p.sendMessage("�6\u2022 �7Normal");
				p.sendMessage(" ");
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				return true;
			}
			if (cfGrupo.ChecarGrupo(p, "Youtuber")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				p.sendMessage(" ");
				p.sendMessage("�6\u2022 �bYoutuber");
				p.sendMessage("�6\u2022 �6Pro");
				p.sendMessage("�6\u2022 �9Mvp");
				p.sendMessage("�6\u2022 �aVip");
				p.sendMessage("�6\u2022 �7Normal");
				p.sendMessage(" ");
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				return true;
			}
			if (cfGrupo.ChecarGrupo(p, "S-Pro")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				p.sendMessage(" ");
				p.sendMessage("�6\u2022 �eSemiyt");
				p.sendMessage("�6\u2022 �7Normal");
				p.sendMessage(" ");
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				return true;
			}
			if (cfGrupo.ChecarGrupo(p, "Pro")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				p.sendMessage(" ");
				p.sendMessage("�6\u2022 �6Pro");
				p.sendMessage("�6\u2022 �9Mvp");
				p.sendMessage("�6\u2022 �aVip");
				p.sendMessage("�6\u2022 �7Normal");
				p.sendMessage(" ");
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				return true;
			}
			if (cfGrupo.ChecarGrupo(p, "Mvp")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				p.sendMessage(" ");
				p.sendMessage("�6\u2022 �9Mvp");
				p.sendMessage("�6\u2022 �aVip");
				p.sendMessage("�6\u2022 �7Normal");
				p.sendMessage(" ");
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				return true;
			}
			if (cfGrupo.ChecarGrupo(p, "Light")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
			}
			p.sendMessage(" ");
			p.sendMessage("�6\u2022 �aVip");
			p.sendMessage("�6\u2022 �7Normal");
			p.sendMessage(" ");
			p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
			return true;
		} else {
			if (cfGrupo.ChecarGrupo(p, "Membro")) {
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				p.sendMessage(" ");
				p.sendMessage("�6\u2022 �7Normal");
				p.sendMessage(" ");
				p.sendMessage("�e�m------- �f �6�lCookie�f�lNetwork �e�m-------");
				return true;
			}
			return false;
		}
	}
}
