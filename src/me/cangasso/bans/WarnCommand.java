package me.cangasso.bans;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.cangasso.API.HorarioAPI;
import me.cangasso.configuração.cfGrupo;
import me.cangasso.main.CookiePvP;

public class WarnCommand implements CommandExecutor {
	public static HashMap<Player, String> Aviso;
	public static FileConfiguration kAvisos;
	public static File Avisos;

	static {
		WarnCommand.Aviso = new HashMap<Player, String>();
	}

	public WarnCommand() {
		final Plugin plugin = CookiePvP.getPlugin();
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		WarnCommand.Avisos = new File(plugin.getDataFolder(), "playersstatus.yml");
		if (!WarnCommand.Avisos.exists()) {
			try {
				WarnCommand.Avisos.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		WarnCommand.kAvisos = (FileConfiguration) YamlConfiguration.loadConfiguration(WarnCommand.Avisos);
	}

	public static void Save() {
		try {
			WarnCommand.kAvisos.save(WarnCommand.Avisos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("aviso")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente")
					&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")
					&& !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Admin")
					&& !cfGrupo.ChecarGrupo(p, "Admin")) {
				API.sendMsg((CommandSender) p,
						"�c�l(!) �cVoc\u00ea não possui permissão para executar este comando!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("�7Use �4�l/aviso �7(jogador) (aviso)");
				return true;
			}
			final Player aviso = Bukkit.getPlayer(args[0]);
			if (aviso == null) {
				p.sendMessage("�7O jogador �a�l" + args[0] + " �7est\u00e1 offline.");
				return true;
			}
			if (aviso.getName() == p.getName()) {
				p.sendMessage("�4�l(!) �cVoc\u00ea nao pode enviar avisos para si mesmo.");
				return true;
			}
			String motivo = "";
			for (int i = 1; i < args.length; ++i) {
				motivo = String.valueOf(motivo) + args[i] + " ";
			}
			if (WarnCommand.Aviso.get(aviso) == "0") {
				WarnCommand.Aviso.put(aviso, "1");
				final double l = WarnCommand.kAvisos.getDouble("Jogadores advertidos");
				API.sendBC("�7O jogador �c�l" + aviso.getName() + " �7recebeu uma advert\u00eancia de �a�l"
						+ p.getName() + "�7. Motivo: �6�l" + motivo + "�7. �4�l(1/3)");
				WarnCommand.kAvisos.set("Jogadores advertidos", (Object) (l + 1.0));
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Nome", (Object) aviso.getName());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Advertido por", (Object) p.getName());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Motivo", (Object) motivo);
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Data do advertimento",
						(Object) HorarioAPI.getHorario());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Avisos", (Object) "1");
				Save();
			} else if (WarnCommand.Aviso.get(aviso) == "1") {
				WarnCommand.Aviso.put(aviso, "2");
				final double l = WarnCommand.kAvisos.getDouble("Jogadores advertidos");
				API.sendBC("�c" + aviso.getName() + " recebeu uma advertencia de " + p.getName() + " por " + motivo
						+ "(2/3)");
				API.sendMsg((CommandSender) p,
						"�aVoce deu uma advertencia a " + aviso.getName() + " por " + motivo + "(2/3)");
				API.sendStaff("�7O staffer " + p.getName() + " deu uma advertencia ao jogador " + aviso.getName()
						+ " pelo motivo " + motivo + "(2/3)");
				API.sendMsg((CommandSender) aviso,
						"�cVoce recebeu uma advertencia de " + p.getName() + " por " + motivo + "(2/3");
				WarnCommand.kAvisos.set("Jogadores advertidos", (Object) (l + 1.0));
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Nome", (Object) aviso.getName());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Advertido por", (Object) p.getName());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Motivo", (Object) motivo);
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Data do advertimento",
						(Object) HorarioAPI.getHorario());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Avisos", (Object) "2");
				Save();
			} else if (WarnCommand.Aviso.get(aviso) == "2") {
				WarnCommand.Aviso.put(aviso, "3");
				final double l = WarnCommand.kAvisos.getDouble("Jogadores advertidos");
				API.sendBC("�c" + aviso.getName() + " recebeu uma advertencia de " + p.getName() + " por " + motivo
						+ "(3/3)");
				API.sendMsg((CommandSender) p,
						"�aVoce deu uma advertencia a " + aviso.getName() + " por " + motivo + "(3/3)");
				API.sendStaff("�7O staffer " + p.getName() + " deu uma advertencia ao jogador " + aviso.getName()
						+ " pelo motivo " + motivo + "(3/3)");
				API.sendMsg((CommandSender) aviso,
						"�cVoce recebeu uma advertencia de " + p.getName() + " por " + motivo + "(3/3");
				WarnCommand.kAvisos.set("Jogadores advertidos", (Object) (l + 1.0));
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Nome", (Object) aviso.getName());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Advertido por", (Object) p.getName());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Motivo", (Object) motivo);
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Data do advertimento",
						(Object) HorarioAPI.getHorario());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Avisos", (Object) "3");
				Save();
			} else if (WarnCommand.Aviso.get(aviso) == "3") {
				WarnCommand.Aviso.put(aviso, "4");
				final double l = WarnCommand.kAvisos.getDouble("Jogadores advertidos");
				API.sendBC("�c" + aviso.getName() + " recebeu uma advertencia de " + p.getName() + " por " + motivo
						+ "(4/3)");
				API.sendMsg((CommandSender) p,
						"�aVoce deu uma advertencia a " + aviso.getName() + " por " + motivo + "(4/3)");
				API.sendStaff("�7O staffer " + p.getName() + " deu uma advertencia ao jogador " + aviso.getName()
						+ " pelo motivo " + motivo + "(4/3)");
				API.sendMsg((CommandSender) aviso,
						"�cVoce recebeu uma advertencia de " + p.getName() + " por " + motivo + "(4/3");
				WarnCommand.kAvisos.set("Jogadores advertidos", (Object) (l + 1.0));
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Nome", (Object) aviso.getName());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Advertido por", (Object) p.getName());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Motivo", (Object) motivo);
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Data do advertimento",
						(Object) HorarioAPI.getHorario());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Avisos", (Object) "3");
				Save();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(CookiePvP.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						API.sendBC("�c" + aviso.getName()
								+ " foi kickado do servidor por exceder o numero maximo de avisos (4/3)");
						API.sendMsg((CommandSender) p, "�aO jogador " + p.getName()
								+ " foi kickado do servidor por exceder o numero maximo de avisos (4/3)");
						API.sendStaff("�7O jogador " + aviso.getName()
								+ " foi kickado do servidor por exceder o numero maximo de avisos (4/3)");
						aviso.kickPlayer("�cVoce foi �c�nkickado�c do servidor.\n�cJogador kickado: " + aviso.getName()
								+ "\n" + "�cKickado por: " + p.getName() + "\n"
								+ "�cMotivo: Exceder o numero maximo de avisos (4/3)");
					}
				}, 20L);
			} else if (WarnCommand.Aviso.get(aviso) == "4") {
				WarnCommand.Aviso.put(aviso, "5");
				final double l = WarnCommand.kAvisos.getDouble("Jogadores advertidos");
				API.sendBC("�c" + aviso.getName() + " recebeu uma advertencia de " + p.getName() + " por " + motivo
						+ "(5/3)");
				API.sendMsg((CommandSender) p,
						"�aVoce deu uma advertencia a " + aviso.getName() + " por " + motivo + "(5/3)");
				API.sendStaff("�7O staffer " + p.getName() + " deu uma advertencia ao jogador " + aviso.getName()
						+ " pelo motivo " + motivo + "(5/3)");
				API.sendMsg((CommandSender) aviso,
						"�cVoce recebeu uma advertencia de " + p.getName() + " por " + motivo + "(5/3");
				WarnCommand.kAvisos.set("Jogadores advertidos", (Object) (l + 1.0));
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Nome", (Object) aviso.getName());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Advertido por", (Object) p.getName());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Motivo", (Object) motivo);
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Data do advertimento",
						(Object) HorarioAPI.getHorario());
				WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Avisos", (Object) "3");
				Save();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(CookiePvP.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						API.sendBC("�c" + aviso.getName()
								+ " foi banido temporariamente do servidor por exceder o numero maximo de avisos (5/3)");
						API.sendMsg((CommandSender) p, "�aO jogador " + p.getName()
								+ " foi banido temporariamente do servidor por exceder o numero maximo de avisos (5/3)");
						API.sendStaff("�7O jogador " + aviso.getName()
								+ " foi banido temporariamente do servidor por exceder o numero maximo de avisos (5/3)");
						aviso.kickPlayer("�cVoce foi �c�nbanido temporariamente�c do servidor.\n�cJogador banido: "
								+ aviso.getName() + "\n" + "�cBanido por: " + p.getName() + "\n"
								+ "�cMotivo: Exceder o numero maximo de avisos (5/3)" + "\n"
								+ "�cDuracao do banimento: 1 dia" + "\n" + "Data do banimento: "
								+ HorarioAPI.getHorario() + "\n" + "�cVenda de UNBANS em: �c�nloja.cakekits.tk" + "\n"
								+ "�cFoi banido injustamente? Contate-nos via Twitter (�c�n@CakeKitsMC�c)");
						Config.getConfig().getTempBans().set("TempBans." + aviso.getUniqueId() + ".Nome",
								(Object) aviso.getName());
						Config.getConfig().getTempBans().set("TempBans." + aviso.getUniqueId() + ".Banido por",
								(Object) p.getName());
						Config.getConfig().getTempBans().set("TempBans." + aviso.getUniqueId() + ".Motivo",
								(Object) "Exceder o numero maximo de avisos (5/3)");
						Config.getConfig().getTempBans().set("TempBans." + aviso.getUniqueId() + ".Tempo do Ban",
								(Object) "1 dia");
						Config.getConfig().getTempBans().set("TempBans." + aviso.getUniqueId() + ".Data do banimento",
								(Object) HorarioAPI.getHorario());
						Config.getConfig().saveTempBans();
						Bukkit.getScheduler().scheduleAsyncDelayedTask(CookiePvP.plugin, (Runnable) new Runnable() {
							@Override
							public void run() {
								if (Config.getConfig().getTempBans().get("TempBans." + aviso.getUniqueId()) != null) {
									Config.getConfig().getTempBans().set("TempBans." + aviso.getUniqueId(),
											(Object) null);
									WarnCommand.kAvisos.set("Advertencias." + aviso.getUniqueId(), (Object) null);
									WarnCommand.Aviso.put(aviso, "0");
									Config.getConfig().saveTempBans();
									API.sendBC("�cO jogador " + aviso.getName() + " foi desbanido automaticamente");
									API.sendStaff("�7O jogador " + aviso.getName() + " foi desbanido automaticamente");
								}
							}
						}, 1728000L);
					}
				}, 20L);
			}
			if (args.length == 1) {
				p.sendMessage("�7Use �4�l/aviso �7(jogador) (aviso)");
				return true;
			}
		}
		return false;
	}
}
