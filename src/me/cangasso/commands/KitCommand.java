package me.cangasso.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.API.API;
import me.cangasso.API.KitAPI;
import me.cangasso.configuração.cfGrupo;
import me.cangasso.configuração.cfPermissão;
import me.cangasso.scoreboard.sScoreAPI;

public class KitCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("kit")) {
			if (API.getWarp(p) != "Spawn") {
				p.sendMessage("�fVoc\u00ea s\u00f3 pode selecionar um �6�lKIT �fno �a�lSPAWN�f!");
				return true;
			}
			if (Args.length == 0) {
				p.sendMessage("�7Utilize �6�l/kit (kit)");
				return true;
			}
			if (KitAPI.getKit(p) != "Nenhum") {
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKit(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				return true;
			}
			if (Args[0].equalsIgnoreCase("pvp")) {
				if (!cfGrupo.ChecarGrupo(p, "Membro") && !cfGrupo.ChecarGrupo(p, "Light")
						&& !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Builder")
						&& !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "Trial")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.light && !GiveAllCommand.mvp
						&& !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "PvP");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("archer")) {
				if (!cfGrupo.ChecarGrupo(p, "Membro") && !cfGrupo.ChecarGrupo(p, "Light")
						&& !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Builder")
						&& !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "Trial")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.light && !GiveAllCommand.mvp
						&& !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Archer");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("kangaroo")) {
				if (!cfGrupo.ChecarGrupo(p, "Membro") && !cfGrupo.ChecarGrupo(p, "Light")
						&& !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Builder")
						&& !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "Trial")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.light && !GiveAllCommand.mvp
						&& !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Kangaroo");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("fisherman")) {
				if (!cfGrupo.ChecarGrupo(p, "Membro") && !cfGrupo.ChecarGrupo(p, "Light")
						&& !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Builder")
						&& !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "Trial")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.light && !GiveAllCommand.mvp
						&& !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Fisherman");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("cactus")) {
				if (!cfGrupo.ChecarGrupo(p, "Membro") && !cfGrupo.ChecarGrupo(p, "Light")
						&& !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Builder")
						&& !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "Trial")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.light && !GiveAllCommand.mvp
						&& !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Cactus");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("monk")) {
				if (!cfPermissão.getPermissao(p, "kit.monk") && !cfGrupo.ChecarGrupo(p, "Light")
						&& !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Builder")
						&& !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "Trial")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.light && !GiveAllCommand.mvp
						&& !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Monk");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("ninja")) {
				if (!cfPermissão.getPermissao(p, "kit.ninja") && !cfGrupo.ChecarGrupo(p, "Light")
						&& !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Builder")
						&& !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "Trial")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.light && !GiveAllCommand.mvp
						&& !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Ninja");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("phantom")) {
				if (!cfPermissão.getPermissao(p, "kit.phantom") && !cfGrupo.ChecarGrupo(p, "Light")
						&& !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Builder")
						&& !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "Trial")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.light && !GiveAllCommand.mvp
						&& !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Phantom");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("grappler")) {
				if (!cfPermissão.getPermissao(p, "kit.grappler") && !cfGrupo.ChecarGrupo(p, "Light")
						&& !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Builder")
						&& !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "Trial")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.light && !GiveAllCommand.mvp
						&& !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Grappler");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("viper")) {
				if (!cfPermissão.getPermissao(p, "kit.viper") && !cfGrupo.ChecarGrupo(p, "Light")
						&& !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Builder")
						&& !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "Trial")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.light && !GiveAllCommand.mvp
						&& !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Viper");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("snail")) {
				if (!cfPermissão.getPermissao(p, "kit.snail") && !cfGrupo.ChecarGrupo(p, "Light")
						&& !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Builder")
						&& !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "Trial")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.light && !GiveAllCommand.mvp
						&& !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Snail");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("hulk")) {
				if (!cfPermissão.getPermissao(p, "kit.hulk") && !cfGrupo.ChecarGrupo(p, "Mvp")
						&& !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Builder")
						&& !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Youtuber")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.mvp && !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Hulk");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("timelord")) {
				if (!cfPermissão.getPermissao(p, "kit.timelord") && !cfGrupo.ChecarGrupo(p, "Mvp")
						&& !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Builder")
						&& !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Youtuber")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.mvp && !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Timelord");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("thor")) {
				if (!cfPermissão.getPermissao(p, "kit.thor") && !cfGrupo.ChecarGrupo(p, "Mvp")
						&& !cfGrupo.ChecarGrupo(p, "Builder") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "Mod")
						&& !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Gerente")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Admin")
						&& !cfGrupo.ChecarGrupo(p, "Dono") && !GiveAllCommand.fullkit && !GiveAllCommand.mvp
						&& !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Thor");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("switcher")) {
				if (!cfPermissão.getPermissao(p, "kit.switcher") && !cfGrupo.ChecarGrupo(p, "Mvp")
						&& !cfGrupo.ChecarGrupo(p, "Builder") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "Mod")
						&& !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Gerente")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Admin")
						&& !cfGrupo.ChecarGrupo(p, "Dono") && !GiveAllCommand.fullkit && !GiveAllCommand.mvp
						&& !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Switcher");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("gladiator")) {
				if (!cfPermissão.getPermissao(p, "kit.gladiator") && !cfGrupo.ChecarGrupo(p, "Mvp")
						&& !cfGrupo.ChecarGrupo(p, "Builder") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "Mod")
						&& !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Gerente")
						&& !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Admin")
						&& !cfGrupo.ChecarGrupo(p, "Dono") && !GiveAllCommand.fullkit && !GiveAllCommand.mvp
						&& !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Gladiator");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("stomper")) {
				if (!cfPermissão.getPermissao(p, "kit.stomper") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Builder") && !cfGrupo.ChecarGrupo(p, "Youtuber")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Stomper");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("magma")) {
				if (!cfPermissão.getPermissao(p, "kit.magma") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Builder") && !cfGrupo.ChecarGrupo(p, "Youtuber")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Magma");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("grandpa")) {
				if (!cfPermissão.getPermissao(p, "kit.grandpa") && !cfGrupo.ChecarGrupo(p, "Builder")
						&& !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Youtuber")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Grandpa");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
			}
			if (Args[0].equalsIgnoreCase("ajnin")) {
				if (!cfPermissão.getPermissao(p, "kit.ajnin") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Builder") && !cfGrupo.ChecarGrupo(p, "Youtuber")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui esta permissão.");
					return true;
				}
				KitAPI.setKitAntes(p, "Ajnin");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("firelauncher")) {
				if (!cfPermissão.getPermissao(p, "kit.firelauncher") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Builder") && !cfGrupo.ChecarGrupo(p, "Youtuber")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "FireLauncher");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("strong")) {
				if (!cfPermissão.getPermissao(p, "kit.strong") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Builder") && !cfGrupo.ChecarGrupo(p, "Youtuber")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Strong");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
			if (Args[0].equalsIgnoreCase("sumo")) {
				if (!cfPermissão.getPermissao(p, "kit.sumo") && !cfGrupo.ChecarGrupo(p, "Pro")
						&& !cfGrupo.ChecarGrupo(p, "Builder") && !cfGrupo.ChecarGrupo(p, "Youtuber")
						&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Mod+")
						&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Youtuber+")
						&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Dono")
						&& !GiveAllCommand.fullkit && !GiveAllCommand.pro) {
					p.sendMessage("�cVoc\u00ea não possui este kit.");
					return true;
				}
				KitAPI.setKitAntes(p, "Sumo");
				p.sendMessage("�7Voc\u00ea selecionou o kit: �6�l" + KitAPI.getKitAntes(p));
				p.sendMessage("�7Agora pule do Spawn para receber seu kit!");
				sScoreAPI.scoreboard(p);
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}
		}
		return false;
	}
}
