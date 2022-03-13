package me.cangasso.rdmautomatica;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import me.cangasso.API.API;
import me.cangasso.API.KitAPI;
import me.cangasso.configuração.cfGrupo;
import me.cangasso.invencivel.Proteção;
import me.cangasso.main.CookiePvP;

public class Comando implements CommandExecutor {
	private boolean CheckarNumero(final String Numero) {
		try {
			Integer.parseInt(Numero);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean onCommand(final CommandSender Sender, final Command Comando, final String Label,
			final String[] Args) {
		if (!(Sender instanceof Player)) {
			return true;
		}
		final Player Jogador = (Player) Sender;
		if (Comando.getName().equalsIgnoreCase("RDM") || Comando.getName().equalsIgnoreCase("ReiDaMesa")) {
			if (!cfGrupo.ChecarGrupo(Jogador, "Dono") && !cfGrupo.ChecarGrupo(Jogador, "Gerente")) {
				Jogador.sendMessage("�cVoc\u00ea não possui permissão para utilizar este comando!");
				return true;
			}
			if (Args.length == 0) {
				Jogador.sendMessage("�6�lCookie�f�lNetwork �7� �cUse /rdm (iniciar | cancelar | tempo)");
				return true;
			}
			if (Args[0].equalsIgnoreCase("Iniciar") || Args[0].equalsIgnoreCase("Start")) {
				if (CookiePvP.Evento == Estado.INICIANDO) {
					Jogador.sendMessage(
							"�6�lCookie�f�lNetwork �7� �fNão foi poss\u00edvel iniciar este �5�lEVENTO �fpois j\u00e1 h\u00e1 outro sendo iniciado!");
					return true;
				}
				if (CookiePvP.Evento == Estado.ANDAMENTO) {
					Jogador.sendMessage(
							"�6�lCookie�f�lNetwork �7� �fNão foi poss\u00edvel iniciar este �5�lEVENTO �fpois j\u00e1 h\u00e1 outro em andamento!");
					return true;
				}
				Jogador.sendMessage("�6�lCookie�f�lNetwork �7� �aVoc\u00ea iniciou o evento RDM!");
				Tempo.mandarBroadcast(" \n�4�lAVISO: �fO evento �a�lREI DA MESA �facabou de ser iniciado!\n ");
				Tempo.CancelarTempo();
				CookiePvP.Evento = Estado.INICIANDO;
				Tempo.Iniciando = 301;
				new Tempo(Jogador);
				return true;
			} else if (Args[0].equalsIgnoreCase("Cancelar") || Args[0].equalsIgnoreCase("Cancel")) {
				if (CookiePvP.Evento == Estado.FECHADO) {
					Jogador.sendMessage("�cEi! Voc\u00ea deve primeiro iniciar o evento para depois cancela-lo.");
					return true;
				}
				if (CookiePvP.Evento == Estado.ANDAMENTO) {
					Jogador.sendMessage(
							"�cNão foi poss\u00edvel cancelar o evento pois j\u00e1 h\u00e1 outro em andamento!");
					return true;
				}
				Jogador.sendMessage("�cVoc\u00ea acabou de cancelar o evento RDM!");
				Tempo.mandarBroadcast(" \n�4�lAVISO: �fO evento �a�lREI DA MESA �ffoi cancelado!\n ");
				Tempo.mandarBroadcast("�aTodos os jogadores foram teleportados ao spawn!");
				if (PlayerAPI.Participando.contains(Jogador)) {
					PlayerAPI.Participando.remove(Jogador);
					EventoAPI.TeleportarWarp(Jogador, "Saida");
				}
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player Jogadores = onlinePlayers[i];
					if (PlayerAPI.Participando.contains(Jogadores)) {
						Jogadores.sendMessage("�cDesculpe mas o evento em que voc\u00ea estava foi cancelado...");
						PlayerAPI.Participando.remove(Jogadores);
						EventoAPI.TeleportarWarp(Jogadores, "Saida");
					}
				}
				CookiePvP.Evento = Estado.FECHADO;
				Tempo.Iniciando = 301;
				Tempo.CancelarTempo();
				return true;
			} else if (Args[0].equalsIgnoreCase("Tempo") || Args[0].equalsIgnoreCase("Time")) {
				if (CookiePvP.Evento == Estado.FECHADO) {
					Jogador.sendMessage("�cNão h\u00e1 evento aberto! Como pretende alterar o tempo?");
					return true;
				}
				if (CookiePvP.Evento == Estado.ANDAMENTO) {
					Jogador.sendMessage(
							"�cVoc\u00ea não pode alterar o tempo pois o evento j\u00e1 est\u00e1 em andamento!");
					return true;
				}
				if (Args.length == 1) {
					Jogador.sendMessage("�cUse /tempo <tempo>");
					return true;
				}
				if (!this.CheckarNumero(Args[1])) {
					Jogador.sendMessage("�cUtilize apenas �c�ln\u00fameros�c!");
					return true;
				}
				final Integer Time = Integer.parseInt(Args[1]);
				if (Time == 0 || Time > 301) {
					Jogador.sendMessage(
							"�cVoc\u00ea s\u00f3 pode utilizar n\u00fameros acima de �c�l60 segundos �cou �c�l301 segundos �8(5 minutos)");
					return true;
				}
				Jogador.sendMessage("�7Voc\u00ea alterou o tempo para: �a�l" + Time + " �7segundo(s)");
				Tempo.mandarBroadcast(
						"�6�lCookie�f�lNetwork �7� O tempo foi alterado para �a�l" + Time + " �7segundo(s)");
				Tempo.Iniciando = Time;
				return true;
			} else {
				if (!Args[0].equalsIgnoreCase("Setar") && !Args[0].equalsIgnoreCase("Set")) {
					Jogador.sendMessage("�cUse �c�l/rdm �c(iniciar | cancelar | tempo)");
					return true;
				}
				if (Args.length == 1) {
					Jogador.sendMessage("�cUse �c�l/rdm �c<set> (spawn | saida | loc1 | loc2)");
					return true;
				}
				if (Args[1].equalsIgnoreCase("Spawn")) {
					Jogador.sendMessage("�aLocal setado com sucesso!");
					EventoAPI.SetarWarp(Jogador, "Spawn");
					return true;
				}
				if (Args[1].equalsIgnoreCase("Loc1")) {
					Jogador.sendMessage("�aLocal setado com sucesso!");
					EventoAPI.SetarWarp(Jogador, "Loc1");
					return true;
				}
				if (Args[1].equalsIgnoreCase("Loc2")) {
					Jogador.sendMessage("�aLocal setado com sucesso!");
					EventoAPI.SetarWarp(Jogador, "Loc2");
					return true;
				}
				if (Args[1].equalsIgnoreCase("Saida")) {
					Jogador.sendMessage("�aLocal setado com sucesso!");
					EventoAPI.SetarWarp(Jogador, "Saida");
					return true;
				}
				Jogador.sendMessage("�cUse �c�l/rdm �c<set> (spawn | saida | loc1 | loc2)");
				return true;
			}
		} else if (Comando.getName().equalsIgnoreCase("Entrar") || Comando.getName().equalsIgnoreCase("Join")) {
			if (CookiePvP.Evento == Estado.FECHADO) {
				Jogador.sendMessage(
						"�c�lFALHA �c> �fNão foi poss\u00edvel entrar pois o evento est\u00e1 lotado!");
				return true;
			}
			if (CookiePvP.Evento == Estado.INICIANDO) {
				if (PlayerAPI.Participando.size() == 30) {
					if (!cfGrupo.ChecarGrupo(Jogador, "Dono") && !cfGrupo.ChecarGrupo(Jogador, "Admin")
							&& !cfGrupo.ChecarGrupo(Jogador, "Gerente") && !cfGrupo.ChecarGrupo(Jogador, "Mod+")
							&& !cfGrupo.ChecarGrupo(Jogador, "Mod") && !cfGrupo.ChecarGrupo(Jogador, "Trial")
							&& !cfGrupo.ChecarGrupo(Jogador, "Youtuber+") && !cfGrupo.ChecarGrupo(Jogador, "Helper")
							&& !cfGrupo.ChecarGrupo(Jogador, "Pro") && !cfGrupo.ChecarGrupo(Jogador, "Mvp")
							&& !cfGrupo.ChecarGrupo(Jogador, "Light")) {
						Jogador.sendMessage(
								"�c�lFALHA �c> �fNão foi poss\u00edvel entrar pois o evento est\u00e1 lotado!");
						return true;
					}
					if (PlayerAPI.Participando.contains(Jogador)) {
						Jogador.sendMessage(
								"�cVoc\u00ea j\u00e1 est\u00e1 participando de um evento! Para sair, use: �c�l/sair");
						return true;
					}
					if (EventoAPI.Teleportando.contains(Jogador)) {
						Jogador.sendMessage("�aVoc\u00ea est\u00e1 sendo teleportado, aguarde...");
						return true;
					}
					if (EventoAPI.Cooldown.containsKey(Jogador)) {
						Jogador.sendMessage("�7Aguarde �6�l" + EventoAPI.PegarCooldown(Jogador)
								+ " �7segundo(s) para teleportar-se novamente!");
						return true;
					}
					if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2 || Tempo.Iniciando == 3) {
						Jogador.sendMessage(
								"�cO seu teleporte est\u00e1 sendo cancelado pois o evento est\u00e1 iniciando!");
						return true;
					}
					EventoAPI.AdicinarCooldown(Jogador, 5);
					EventoAPI.Teleportando.add(Jogador);
					EventoAPI.AntiBug.add(Jogador);
					Jogador.setExp(0.0f);
					Jogador.setLevel(3);
					Jogador.sendMessage("�fO seu teleporte ser\u00e1 conclu\u00eddo em �a�l3segundos�f!");
					new BukkitRunnable() {
						public void run() {
							if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2
									|| Tempo.Iniciando == 3) {
								Jogador.sendMessage(
										"�cO seu teleporte est\u00e1 sendo cancelado pois o evento est\u00e1 iniciando!");
								EventoAPI.Teleportando.remove(Jogador);
								return;
							}
							if (EventoAPI.Teleportando.contains(Jogador)) {
								Jogador.setExp(0.5f);
								Jogador.setLevel(2);
								Jogador.sendMessage("�7O seu teleporte ser\u00e1 conclu\u00eddo em �a�l2 segundos�f!");
							}
						}
					}.runTaskLater(CookiePvP.getPlugin(), 20L);
					new BukkitRunnable() {
						public void run() {
							if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2
									|| Tempo.Iniciando == 3) {
								Jogador.sendMessage(
										"�cO seu teleporte est\u00e1 sendo cancelado pois o evento est\u00e1 iniciando!");
								EventoAPI.Teleportando.remove(Jogador);
								return;
							}
							if (EventoAPI.Teleportando.contains(Jogador)) {
								Jogador.setExp(1.0f);
								Jogador.setLevel(1);
								Jogador.sendMessage("�7O seu teleporte ser\u00e1 conclu\u00eddo em �a�l1 segundo�f!");
							}
						}
					}.runTaskLater(CookiePvP.getPlugin(), 40L);
					new BukkitRunnable() {
						public void run() {
							if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2
									|| Tempo.Iniciando == 3) {
								Jogador.sendMessage(
										"�cO seu teleporte est\u00e1 sendo cancelado pois o evento est\u00e1 iniciando!");
								EventoAPI.Teleportando.remove(Jogador);
								return;
							}
							if (CookiePvP.Evento == Estado.FECHADO && EventoAPI.Teleportando.contains(Jogador)) {
								Jogador.sendMessage(
										"�cVoc\u00ea não p\u00f4de se conectar ao evento pois ele foi fechado.");
								EventoAPI.Teleportando.remove(Jogador);
								return;
							}
							if (EventoAPI.Teleportando.contains(Jogador)) {
								if (CookiePvP.Evento == Estado.FECHADO) {
									Jogador.sendMessage(
											"�cNão foi poss\u00edvel completar o teleporte pois o evento est\u00e1 fechado!");
									return;
								}
								Jogador.setExp(0.0f);
								Jogador.setLevel(0);
								PlayerAPI.AdicionarRDMCheio(Jogador);
								Proteção.setImortal(Jogador, true);
								Jogador.setMaxHealth(20);
								Jogador.setHealth(20.0);
								Jogador.setFoodLevel(20);
								Jogador.setFlySpeed(0.1f);
								Jogador.setAllowFlight(false);
								Jogador.setWalkSpeed(0.2f);
								Jogador.getInventory().clear();
								Jogador.setGameMode(GameMode.SURVIVAL);
								Jogador.getInventory().setBoots((ItemStack) null);
								Jogador.getInventory().setChestplate((ItemStack) null);
								Jogador.getInventory().setHelmet((ItemStack) null);
								Jogador.getInventory().setLeggings((ItemStack) null);
							}
						}
					}.runTaskLater(CookiePvP.getPlugin(), 60L);
				} else {
					if (PlayerAPI.Participando.contains(Jogador)) {
						Jogador.sendMessage(
								"�6�lCookie�f�lNetwork �7� �cVoc\u00ea j\u00e1 est\u00e1 participando do evento!");
						return true;
					}
					if (EventoAPI.Teleportando.contains(Jogador)) {
						Jogador.sendMessage("�cAguarde a conclusão do teleporte...");
						return true;
					}
					if (EventoAPI.Cooldown.containsKey(Jogador)) {
						Jogador.sendMessage("�6�lCookie�f�lNetwork �7� Aguarde �6�l" + EventoAPI.PegarCooldown(Jogador)
								+ " �7segundo(s) para se teleportar novamente.");
						return true;
					}
					if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2 || Tempo.Iniciando == 3) {
						Jogador.sendMessage("�cO seu teleporte foi cancelado pois o evento est\u00e1 sendo iniciado!");
						return true;
					}
					EventoAPI.AdicinarCooldown(Jogador, 5);
					EventoAPI.Teleportando.add(Jogador);
					EventoAPI.AntiBug.add(Jogador);
					Jogador.setExp(0.0f);
					Jogador.setLevel(3);
					Jogador.sendMessage("�7O seu teleporte ser\u00e1 conclu\u00eddo em �a�l3 segundos�f!");
					new BukkitRunnable() {
						public void run() {
							if (!EventoAPI.Teleportando.contains(Jogador)) {
								return;
							}
							if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2
									|| Tempo.Iniciando == 3) {
								Jogador.sendMessage(
										"�cO seu teleporte foi cancelado pois o evento j\u00e1 est\u00e1 iniciando");
								EventoAPI.Teleportando.remove(Jogador);
								return;
							}
							if (EventoAPI.Teleportando.contains(Jogador)) {
								Jogador.setExp(0.5f);
								Jogador.setLevel(2);
								Jogador.sendMessage("�7O seu teleporte ser\u00e1 conclu\u00eddo em �a�l2 segundos�f!");
							}
						}
					}.runTaskLater(CookiePvP.getPlugin(), 20L);
					new BukkitRunnable() {
						public void run() {
							if (!EventoAPI.Teleportando.contains(Jogador)) {
								return;
							}
							if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2
									|| Tempo.Iniciando == 3) {
								Jogador.sendMessage(
										"�cO seu teleporte foi cancelado pois o evento j\u00e1 est\u00e1 iniciando");
								EventoAPI.Teleportando.remove(Jogador);
								return;
							}
							if (EventoAPI.Teleportando.contains(Jogador)) {
								Jogador.setExp(1.0f);
								Jogador.setLevel(1);
								Jogador.sendMessage("�7O seu teleporte ser\u00e1 conclu\u00eddo em �a�l1 segundo�f!");
							}
						}
					}.runTaskLater(CookiePvP.getPlugin(), 40L);
					new BukkitRunnable() {
						public void run() {
							if (!EventoAPI.Teleportando.contains(Jogador)) {
								return;
							}
							if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2
									|| Tempo.Iniciando == 3) {
								Jogador.sendMessage(
										"�cO seu teleporte foi cancelado pois o evento j\u00e1 est\u00e1 iniciando");
								EventoAPI.Teleportando.remove(Jogador);
								return;
							}
							if (CookiePvP.Evento == Estado.FECHADO && EventoAPI.Teleportando.contains(Jogador)) {
								Jogador.sendMessage(
										"�cO evento foi cancelado. Imposs\u00edvel completar o seu teleporte.");
								EventoAPI.Teleportando.remove(Jogador);
								return;
							}
							if (EventoAPI.Teleportando.contains(Jogador)) {
								Jogador.setExp(0.0f);
								Jogador.setLevel(0);
								if (PlayerAPI.Participando.size() == 30) {
									if (!Jogador.hasPermission("RDM.Full")) {
										Jogador.sendMessage(
												"�cNão foi poss\u00edvel entrar no evento pois j\u00e1 lotou!");
										EventoAPI.Teleportando.remove(Jogador);
										return;
									}
									PlayerAPI.AdicionarRDMCheio(Jogador);
									Proteção.setImortal(Jogador, true);
									Jogador.setMaxHealth(20);
									Jogador.setHealth(20.0);
									Jogador.setFoodLevel(20);
									Jogador.setFlySpeed(0.1f);
									Jogador.setAllowFlight(false);
									Jogador.setWalkSpeed(0.2f);
									Jogador.getInventory().clear();
									Jogador.setGameMode(GameMode.SURVIVAL);
									Jogador.getInventory().setBoots((ItemStack) null);
									Jogador.getInventory().setChestplate((ItemStack) null);
									Jogador.getInventory().setHelmet((ItemStack) null);
									Jogador.getInventory().setLeggings((ItemStack) null);
								}
								KitAPI.removeKits(Jogador);
								Jogador.sendMessage("�a�lSUCESSO �a> �7Voc\u00ea acaba de entrar no evento!");
								Jogador.sendMessage(
										"�6�lBOA SORTE �6> �7Tenha um bom jogo. Que a sorte esteja convosco!");
								PlayerAPI.AdicionarRDM(Jogador);
								PlayerAPI.Participando.add(Jogador);
								EventoAPI.AntiBug.remove(Jogador);
								EventoAPI.Teleportando.remove(Jogador);
								EventoAPI.TeleportarWarp(Jogador, "Spawn");
								Tempo.mandarBroadcast("�7O jogador �6�l" + Jogador.getName()
										+ " �7entrou no evento �e�l(" + PlayerAPI.Participando.size() + "�e�l/30)");
								API.setWarp(Jogador, "RDM");
								Proteção.setImortal(Jogador, true);
								for (final PotionEffect Efeito : Jogador.getActivePotionEffects()) {
									Jogador.removePotionEffect(Efeito.getType());
								}
								Jogador.setMaxHealth(20);
								Jogador.setHealth(20.0);
								Jogador.setFoodLevel(20);
								Jogador.setFlySpeed(0.1f);
								Jogador.setAllowFlight(false);
								Jogador.setWalkSpeed(0.2f);
								Jogador.getInventory().clear();
								Jogador.setGameMode(GameMode.SURVIVAL);
								Jogador.getInventory().setBoots((ItemStack) null);
								Jogador.getInventory().setChestplate((ItemStack) null);
								Jogador.getInventory().setHelmet((ItemStack) null);
								Jogador.getInventory().setLeggings((ItemStack) null);
							}
						}
					}.runTaskLater(CookiePvP.getPlugin(), 60L);
				}
			} else if (CookiePvP.Evento == Estado.ANDAMENTO) {
				Jogador.sendMessage("�cO evento j\u00e1 est\u00e1 em andamento!");
			}
			return true;
		} else {
			if (!Comando.getName().equalsIgnoreCase("Sair") && !Comando.getName().equalsIgnoreCase("Leave")) {
				return false;
			}
			if (CookiePvP.Evento == Estado.FECHADO) {
				Jogador.sendMessage("�cEi! O evento est\u00e1 fechado. Como pretende entrar?");
				return true;
			}
			if (!PlayerAPI.Participando.contains(Jogador)) {
				Jogador.sendMessage("�cVoc\u00ea não est\u00e1 em um evento!");
				return true;
			}
			if (EventoAPI.Teleportando.contains(Jogador)) {
				Jogador.sendMessage("�cAguarde at\u00e9 a conclusão do teleporte!");
				return true;
			}
			if (EventoAPI.Cooldown.containsKey(Jogador)) {
				Jogador.sendMessage("�7Aguarde �6�l" + EventoAPI.PegarCooldown(Jogador)
						+ " �7segundo(s) para se teleportar novamente!");
				return true;
			}
			if (PlayerAPI.Participando.contains(Jogador) && PlayerAPI.Ganhador.containsKey(Jogador)) {
				final Player Ganhador = Bukkit.getPlayer((String) PlayerAPI.Ganhador.get(Jogador));
				PlayerAPI.CheckarGanhador(Ganhador);
			}
			EventoAPI.AdicinarCooldown(Jogador, 5);
			EventoAPI.Teleportando.remove(Jogador);
			EventoAPI.AntiBug.remove(Jogador);
			PlayerAPI.Participando.remove(Jogador);
			Jogador.sendMessage("�6�lCookie�f�lNetwork �7� �fVoc\u00ea saiu do evento �a�lREI DA MESA�f!");
			Tempo.mandarBroadcast("�7O jogador �6�l" + Jogador.getName() + " �7saiu do evento �e�l("
					+ PlayerAPI.Participando.size() + "�e�l/30)");
			PlayerAPI.RemoverRDM(Jogador);
			EventoAPI.TeleportarWarp(Jogador, "Saida");
			API.setWarp(Jogador, "Spawn");
			API.sendItems(Jogador);
			Proteção.setImortal(Jogador, true);
			return true;
		}
	}
}
