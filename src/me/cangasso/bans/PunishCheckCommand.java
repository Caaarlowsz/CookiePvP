package me.cangasso.bans;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.configuração.cfGrupo;

public class PunishCheckCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player jogador = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("bancheck")) {
			if (!cfGrupo.ChecarGrupo(jogador, "Dono") && !cfGrupo.ChecarGrupo(jogador, "Gerente")
					&& !cfGrupo.ChecarGrupo(jogador, "Admin") && !cfGrupo.ChecarGrupo(jogador, "Mod+")
					&& !cfGrupo.ChecarGrupo(jogador, "Mod") && !cfGrupo.ChecarGrupo(jogador, "Dono")) {
				API.sendMsg((CommandSender) jogador,
						"�4�l(!) �cVoc\u00ea não possui permissão para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg((CommandSender) jogador,
						"�fO �c�l/bancheck �fserve para checar o hist\u00f3rico de puniç\u00f5es de um certo jogador. Use: �6�l/bancheck <nickname>�f!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			final Player check = Bukkit.getPlayer(args[0]);
			if (check == null) {
				final OfflinePlayer checkoff = Bukkit.getOfflinePlayer(args[0]);
				if (Config.getConfig().getJogadores().get("Jogadores." + checkoff.getUniqueId()) == null) {
					API.sendMsg((CommandSender) jogador,
							"�fO jogador �6�l" + checkoff.getName() + " �fnunca entrou no servidor!");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (Config.getConfig().getJogadores().get("Jogadores." + checkoff.getUniqueId()) != null) {
					if (Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId()) == null
							&& Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId()) == null
							&& Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId()) == null) {
						API.sendMsg((CommandSender) jogador,
								"�cNão h\u00e1 hist\u00f3rico de puniç\u00f5es registradas neste nickname.");
						return true;
					}
					if (Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId()) != null
							&& Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId()) == null
							&& Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId()) == null) {
						API.sendMsg((CommandSender) jogador,
								"�aChecando informaç\u00f5es de " + checkoff.getName());
						API.sendMsg((CommandSender) jogador, " ");
						API.sendMsg((CommandSender) jogador, "�7Banido �4�lPERMANENTEMENTE�f: �a�lSIM");
						API.sendMsg((CommandSender) jogador, "�7Banido por: �5�l"
								+ Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId() + ".Banido por"));
						API.sendMsg((CommandSender) jogador, "�7Motivo: �6�l"
								+ Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg((CommandSender) jogador, "�7Data do banimento: �a" + Config.getConfig().getBans()
								.get("Bans." + checkoff.getUniqueId() + ".Data do banimento"));
						API.sendMsg((CommandSender) jogador, "�7Banido �9�lTEMPORARIAMENTE�f: �c�lNAO");
						API.sendMsg((CommandSender) jogador, "�7Banido por �8�lIP�7: �c�lNAO");
						return true;
					}
					if (Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId()) == null
							&& Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId()) != null
							&& Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId()) == null) {
						API.sendMsg((CommandSender) jogador,
								"�aChecando informaç\u00f5es de " + checkoff.getName());
						API.sendMsg((CommandSender) jogador, " ");
						API.sendMsg((CommandSender) jogador, "�7Banido �4�lPERMANENTEMENTE�7: �c�lNAO");
						API.sendMsg((CommandSender) jogador, "�7Banido �9�lTEMPORARIAMENTE�7: �a�lSIM");
						API.sendMsg((CommandSender) jogador, "�7Banido por: �5�l" + Config.getConfig().getTempBans()
								.get("TempBans." + checkoff.getUniqueId() + ".Banido por"));
						API.sendMsg((CommandSender) jogador, "�7Motivo: �6�l" + Config.getConfig().getTempBans()
								.get("TempBans." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg((CommandSender) jogador, "�7Expira em: �a" + Config.getConfig().getTempBans()
								.get("TempBans." + checkoff.getUniqueId() + ".Tempo do Ban"));
						API.sendMsg((CommandSender) jogador, "�7Data do banimento: �e" + Config.getConfig()
								.getTempBans().get("TempBans." + checkoff.getUniqueId() + ".Data do banimento"));
						API.sendMsg((CommandSender) jogador, "�7Banido �8IP�7: �c�lNAO");
						return true;
					}
					if (Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId()) == null
							&& Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId()) == null
							&& Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId()) != null) {
						API.sendMsg((CommandSender) jogador,
								"�aChecando informaç\u00f5es de " + checkoff.getName());
						API.sendMsg((CommandSender) jogador, " ");
						API.sendMsg((CommandSender) jogador, "�7Banido �4�lPERMANENTEMENTE�7: �c�lNAO");
						API.sendMsg((CommandSender) jogador, "�7Banido �9�lTEMPORARIAMENTE�7: �c�lNAO");
						API.sendMsg((CommandSender) jogador, "�7Banido por �8�lIP�7: �a�lSIM");
						API.sendMsg((CommandSender) jogador, "�7Banido por: �e�l" + Config.getConfig().getIpBans()
								.get("IPBans." + checkoff.getUniqueId() + ".Banido por"));
						API.sendMsg((CommandSender) jogador, "�7Motivo: �6�l"
								+ Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg((CommandSender) jogador, "�7Data do banimento: �a" + Config.getConfig().getIpBans()
								.get("IPBans." + checkoff.getUniqueId() + ".Data do banimento"));
						API.sendMsg((CommandSender) jogador, "�7IP banido: �8" + Config.getConfig().getIpBans()
								.get("IPBans." + checkoff.getUniqueId() + ".IP do Jogador"));
						return true;
					}
				}
			}
			if (Config.getConfig().getBans().get("Bans." + check.getUniqueId()) == null
					&& Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId()) == null
					&& Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId()) == null) {
				API.sendMsg((CommandSender) jogador, "�aChecando informaç\u00f5es de " + check.getName());
				API.sendMsg((CommandSender) jogador, " ");
				API.sendMsg((CommandSender) jogador, "�7Banido �4�lPERMANENTEMENTE�7: �c�lNAO");
				API.sendMsg((CommandSender) jogador, "�7Banido �9�lTEMPORARIAMENTE�7: �c�lNAO");
				API.sendMsg((CommandSender) jogador, "�7Banido por �8�lIP�7: �c�lNAO");
				return true;
			}
			if (Config.getConfig().getBans().get("Bans." + check.getUniqueId()) != null
					&& Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId()) == null
					&& Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId()) == null) {
				API.sendMsg((CommandSender) jogador, "�aChecando informaç\u00f5es de " + check.getName());
				API.sendMsg((CommandSender) jogador, " ");
				API.sendMsg((CommandSender) jogador, "�7Banido �4�lPERMANENTEMENTE�7: �a�lSIM");
				API.sendMsg((CommandSender) jogador, "�7Banido por: �5�l"
						+ Config.getConfig().getBans().get("Bans." + check.getUniqueId() + ".Banido por"));
				API.sendMsg((CommandSender) jogador,
						"�7Motivo: �6�l" + Config.getConfig().getBans().get("Bans." + check.getUniqueId() + ".Motivo"));
				API.sendMsg((CommandSender) jogador, "�7Data do banimento: �a"
						+ Config.getConfig().getBans().get("Bans." + check.getUniqueId() + ".Data do banimento"));
				API.sendMsg((CommandSender) jogador, "�7Banido �9�lTEMPORARIAMENTE�7: �c�lNAO");
				API.sendMsg((CommandSender) jogador, "�7Banido por �8�lIP�7: �c�lNAO");
				return true;
			}
			if (Config.getConfig().getBans().get("Bans." + check.getUniqueId()) == null
					&& Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId()) != null
					&& Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId()) == null) {
				API.sendMsg((CommandSender) jogador, "�aChecando informaç\u00f5es de " + check.getName());
				API.sendMsg((CommandSender) jogador, "�7Banido �4�lPERMANENTEMENTE: �c�lNAO");
				API.sendMsg((CommandSender) jogador, "�7Banido �9�lTEMPORARIAMENTE�7: �a�lSIM");
				API.sendMsg((CommandSender) jogador, "�7Banido por: �5�l"
						+ Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId() + ".Banido por"));
				API.sendMsg((CommandSender) jogador, "�7Motivo: �6�l "
						+ Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId() + ".Motivo"));
				API.sendMsg((CommandSender) jogador, "�7Expira em: �a"
						+ Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId() + ".Tempo do Ban"));
				API.sendMsg((CommandSender) jogador, "�7Data do banimento: �e" + Config.getConfig().getTempBans()
						.get("TempBans." + check.getUniqueId() + ".Data do banimento"));
				API.sendMsg((CommandSender) jogador, "�7Banido por �8�lIP�7: �c�lNAO");
				return true;
			}
			if (Config.getConfig().getBans().get("Bans." + check.getUniqueId()) == null
					&& Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId()) == null
					&& Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId()) != null) {
				API.sendMsg((CommandSender) jogador, "�eChecando informaç\u00f5es de " + check.getName());
				API.sendMsg((CommandSender) jogador, " ");
				API.sendMsg((CommandSender) jogador, "�7Banido �4�lPERMANENTEMENTE�7: �c�lNAO");
				API.sendMsg((CommandSender) jogador, "�7Banido �9�LTEMPORARIAMENTE: �c�lNAO");
				API.sendMsg((CommandSender) jogador, "�7Banido por �8�lIP: �a�lSIM");
				API.sendMsg((CommandSender) jogador, "�7Banido por: �5�l"
						+ Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId() + ".Banido por"));
				API.sendMsg((CommandSender) jogador, "�7Motivo: �6�l"
						+ Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId() + ".Motivo"));
				API.sendMsg((CommandSender) jogador, "�7Data do banimento: �a"
						+ Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId() + ".Data do banimento"));
				API.sendMsg((CommandSender) jogador, "�7IP banido: �8"
						+ Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId() + ".IP do Jogador"));
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("mutecheck")) {
			if (!cfGrupo.ChecarGrupo(jogador, "Dono") && !cfGrupo.ChecarGrupo(jogador, "Gerente")
					&& !cfGrupo.ChecarGrupo(jogador, "Admin") && !cfGrupo.ChecarGrupo(jogador, "Mod+")
					&& !cfGrupo.ChecarGrupo(jogador, "Mod")) {
				API.sendMsg((CommandSender) jogador,
						"�cVoc\u00ea não possui permissão para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg((CommandSender) jogador,
						"�fO �b�l/mutecheck �fserve para checar o hist\u00f3rico de puniç\u00f5es de um certo jogador. Use: �b�l/mutecheck <nickname>�f!");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			final Player check = Bukkit.getPlayer(args[0]);
			if (check == null) {
				final OfflinePlayer checkoff = Bukkit.getOfflinePlayer(args[0]);
				if (Config.getConfig().getJogadores().get("Jogadores." + checkoff.getUniqueId()) == null) {
					API.sendMsg((CommandSender) jogador,
							"�fO jogador �6�l" + checkoff.getName() + " �fnunca entrou no servidor!");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (Config.getConfig().getJogadores().get("Jogadores." + checkoff.getUniqueId()) != null) {
					if (Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId()) == null
							&& Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId()) == null) {
						API.sendMsg((CommandSender) jogador, "�a" + checkoff.getName());
						API.sendMsg((CommandSender) jogador, " ");
						API.sendMsg((CommandSender) jogador, "�7Mutado �4�lPERMANENTEMENTE�7: �c�lNAO");
						API.sendMsg((CommandSender) jogador, "�7Mutado �9�lTEMPORARIAMENTE: �c�lNAO");
						return true;
					}
					if (Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId()) != null
							&& Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId()) == null) {
						API.sendMsg((CommandSender) jogador, "�7Checando informacoes de " + checkoff.getName());
						API.sendMsg((CommandSender) jogador, " ");
						API.sendMsg((CommandSender) jogador, "�7Mutado �4�lPERMANENTEMENTE�7: �a�lSIM");
						API.sendMsg((CommandSender) jogador, "�7Mutado por: �5�l"
								+ Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId() + ".Mutado por"));
						API.sendMsg((CommandSender) jogador, "�7Motivo: �6�l"
								+ Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg((CommandSender) jogador, "�7Data do mute: �e"
								+ Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId() + ".Data do mute"));
						API.sendMsg((CommandSender) jogador, "�7Mutado �9�lTEMPORARIAMENTE�7: �c�lNAO");
						return true;
					}
					if (Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId()) == null
							&& Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId()) != null) {
						API.sendMsg((CommandSender) jogador, "�7Checando informacoes de " + checkoff.getName());
						API.sendMsg((CommandSender) jogador, " ");
						API.sendMsg((CommandSender) jogador, "�7Mutado �4�lPERMANENTEMENTE�7: �c�lNAO");
						API.sendMsg((CommandSender) jogador, "�7Mutado �9�lTEMPORARIAMENTE�7: �a�lSIM");
						API.sendMsg((CommandSender) jogador, "�7Mutado por: �5�l" + Config.getConfig().getTempMute()
								.get("TempMute." + checkoff.getUniqueId() + ".Mutado por"));
						API.sendMsg((CommandSender) jogador, "�7Motivo: �6�l" + Config.getConfig().getTempMute()
								.get("TempMute." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg((CommandSender) jogador, "�7Expira em: �a" + Config.getConfig().getTempMute()
								.get("TempMute." + checkoff.getUniqueId() + ".Tempo do Mute"));
						API.sendMsg((CommandSender) jogador, "�7Data do mute: �e" + Config.getConfig().getTempMute()
								.get("TempMute." + checkoff.getUniqueId() + ".Data do mute"));
						return true;
					}
				}
			}
			if (Config.getConfig().getMute().get("Mute." + check.getUniqueId()) == null
					&& Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId()) == null) {
				API.sendMsg((CommandSender) jogador, "�aChecando informaç\u00f5es de " + check.getName());
				API.sendMsg((CommandSender) jogador, "");
				API.sendMsg((CommandSender) jogador, "�7Mutado �4�lPERMANENTEMENTE�7: �c�lNAO");
				API.sendMsg((CommandSender) jogador, "�7Mutado �9�lTEMPORARIAMENTE�7: �c�lNAO");
				return true;
			}
			if (Config.getConfig().getMute().get("Mute." + check.getUniqueId()) != null
					&& Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId()) == null) {
				API.sendMsg((CommandSender) jogador, "�aChecando informaç\u00f5es de " + check.getName());
				API.sendMsg((CommandSender) jogador, " ");
				API.sendMsg((CommandSender) jogador, "�7Mutado �4�lPERMANENTEMENTE: �a�lSIM");
				API.sendMsg((CommandSender) jogador, "�7Mutado por: �5�l"
						+ Config.getConfig().getMute().get("Mute." + check.getUniqueId() + ".Mutado por"));
				API.sendMsg((CommandSender) jogador,
						"�7Motivo: �6�l" + Config.getConfig().getMute().get("Mute." + check.getUniqueId() + ".Motivo"));
				API.sendMsg((CommandSender) jogador, "�7Data do mute: �a"
						+ Config.getConfig().getMute().get("Mute." + check.getUniqueId() + ".Data do mute"));
				API.sendMsg((CommandSender) jogador, "�7Mutado �9�lTEMPORARIAMENTE: �c�lNAO");
				return true;
			}
			if (Config.getConfig().getMute().get("Mute." + check.getUniqueId()) == null
					&& Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId()) != null) {
				API.sendMsg((CommandSender) jogador, "�aChecando informaç\u00f5es de " + check.getName());
				API.sendMsg((CommandSender) jogador, " ");
				API.sendMsg((CommandSender) jogador, "�7Mutado �4�lPERMANENTEMENTE�7: �c�lNAO");
				API.sendMsg((CommandSender) jogador, "�7Mutado �9�lTEMPORARIAMENTE�7: �a�lSIM");
				API.sendMsg((CommandSender) jogador, "�7Mutado por: �5�l"
						+ Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId() + ".Mutado por"));
				API.sendMsg((CommandSender) jogador, "�7Motivo: �6�l"
						+ Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId() + ".Motivo"));
				API.sendMsg((CommandSender) jogador, "�7Expira em: �a"
						+ Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId() + ".Tempo do Mute"));
				API.sendMsg((CommandSender) jogador, "�7Data do mute: �e"
						+ Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId() + ".Data do mute"));
				return true;
			}
		}
		return false;
	}
}
