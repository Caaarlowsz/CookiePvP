package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.configuração.cfGrupo;
import me.cangasso.configuração.cfPermissão;

public class GiveKitCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("givekit")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Admin")
					&& !cfGrupo.ChecarGrupo(p, "Gerente")) {
				p.sendMessage("�c�l(!) �cVoc\u00ea não possui permissão para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("�fUtilize �6�l/givekit �6(jogador) (kit)�f.");
				return true;
			}
			if (args.length == 2) {
				final String kit = args[1];
				final Player k = Bukkit.getPlayer(args[0]);
				if (kit.equalsIgnoreCase("pvp")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lPVP �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lPVP�7!");
					cfPermissão.setarPermissao(k, "kit.pvp", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("archer")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lARCHER �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lARCHER�7!");
					cfPermissão.setarPermissao(k, "kit.archer", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("kangaroo")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lKANGAROO �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lKANGAROO�7!");
					cfPermissão.setarPermissao(k, "kit.kangaroo", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("fisherman")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lFISHERMAN �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lFISHERMAN�7!");
					cfPermissão.setarPermissao(k, "kit.fisherman", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("cactus")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lCACTUS �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lCACTUS�7!");
					cfPermissão.setarPermissao(k, "kit.cactus", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("monk")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lMONK �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lMONK�7!");
					cfPermissão.setarPermissao(k, "kit.", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("ninja")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lNINJA �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lNINJA�7!");
					cfPermissão.setarPermissao(k, "kit.ninja", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("phantom")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lPHANTOM �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lPHANTOM�7!");
					cfPermissão.setarPermissao(k, "kit.phantom", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("grappler")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lGRAPPLER �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lGRAPPLER�7!");
					cfPermissão.setarPermissao(k, "kit.grappler", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("viper")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lVIPER �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lVIPER�7!");
					cfPermissão.setarPermissao(k, "kit.viper", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("snail")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lSNAIL �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lSNAIL7!");
					cfPermissão.setarPermissao(k, "kit.snail", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("hulk")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lHULK �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lHULK�7!");
					cfPermissão.setarPermissao(k, "kit.hulk", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("timelord")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lTIMELORD �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lTIMELORD�7!");
					cfPermissão.setarPermissao(k, "kit.timelord", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("thor")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lTHOR �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Thor");
					cfPermissão.setarPermissao(k, "kit.thor", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("switcher")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lSWITCHER �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lSWITCHER�7!");
					cfPermissão.setarPermissao(k, "kit.switcher", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("gladiator")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lGLADIATOR �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lGLADIATOR�7!");
					cfPermissão.setarPermissao(k, "kit.gladiator", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("stomper")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lSTOMPER �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lSTOMPER");
					cfPermissão.setarPermissao(k, "kit.stomper", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("magma")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lMAGMA �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lMAGMA�7!");
					cfPermissão.setarPermissao(k, "kit.magma", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("grandpa")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lGRANDPA �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lGRANDPA�7!");
					cfPermissão.setarPermissao(k, "kit.grandpa", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("ajnin")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lAJNIN �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lAJNIN�7!");
					cfPermissão.setarPermissao(k, "kit.ajnin", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("firelauncher")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lFIRELAUNCHER �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lFIRELAUNCHER�7!");
					cfPermissão.setarPermissao(k, "kit.firelauncher", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("strong")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lSTRONG �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lSTRONG�7!");
					cfPermissão.setarPermissao(k, "kit.strong", "true");
					return true;
				}
				if (kit.equalsIgnoreCase("sumo")) {
					p.sendMessage("�7Voc\u00ea aplicou o kit �6�lSUMO �7para o jogador: �6�l" + k.getName());
					k.sendMessage("�7Voc\u00ea recebeu o kit: �6�lSUMO�7!");
					cfPermissão.setarPermissao(k, "kit.sumo", "true");
					return true;
				}
				p.sendMessage("�cEsse kit não existe!");
				return true;
			}
		}
		return false;
	}
}
