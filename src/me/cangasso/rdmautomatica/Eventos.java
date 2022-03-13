package me.cangasso.rdmautomatica;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.cangasso.API.API;
import me.cangasso.invencivel.Proteção;
import me.cangasso.main.CookiePvP;

public class Eventos implements Listener {
	@EventHandler
	public void onPlayerQuitEvent(final PlayerQuitEvent Evento) {
		final Player Jogador = Evento.getPlayer();
		if (CookiePvP.Evento == Estado.FECHADO) {
			return;
		}
		if (CookiePvP.Evento == Estado.INICIANDO && PlayerAPI.Participando.contains(Jogador)) {
			PlayerAPI.RemoverRDM(Jogador);
			PlayerAPI.Participando.remove(Jogador);
			Tempo.mandarBroadcast("�7O jogador �6�l" + Jogador.getName() + " �7saiu do evento �e�l("
					+ PlayerAPI.Participando.size() + "�e�l/30)");
		} else if (CookiePvP.Evento == Estado.ANDAMENTO) {
			if (!PlayerAPI.Batalhando.contains(Jogador) && PlayerAPI.Participando.contains(Jogador)) {
				PlayerAPI.RemoverRDM(Jogador);
				PlayerAPI.Participando.remove(Jogador);
				Tempo.mandarBroadcast("�7O jogador �6�l" + Jogador.getName() + "�7 saiu do evento �e�l("
						+ PlayerAPI.Participando.size() + "�e�l/30)");
				return;
			}
			if (PlayerAPI.Batalhando.contains(Jogador) && PlayerAPI.Participando.contains(Jogador)
					&& PlayerAPI.Batalhando1.get(Jogador) == Jogador.getName()
					&& PlayerAPI.Ganhador.get(Jogador) == Jogador.getName()) {
				final Player Ganhador = Bukkit.getPlayer((String) PlayerAPI.Batalhando2.get(Jogador));
				PlayerAPI.Batalhando.remove(Jogador);
				PlayerAPI.Participando.remove(Jogador);
				Tempo.mandarBroadcast(
						"�7O jogador �c�l" + Jogador.getName() + " �7não aguentou e desistiu do duelo contra �a�l"
								+ Ganhador.getName() + "�7. �e�l(" + PlayerAPI.Participando.size() + "�e�l/30)");
				Tempo.mandarBroadcast("�7O jogador �a�l" + Ganhador.getName() + " �7venceu o duelo contra �c�l"
						+ Jogador.getName() + "�7. �e�l(" + PlayerAPI.Participando.size() + "�e�l/30)");
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player Jogadores = onlinePlayers[i];
					PlayerAPI.Batalhando1.remove(Jogadores);
					PlayerAPI.Ganhador.put(Jogadores, Ganhador.getName());
					PlayerAPI.Batalhando2.remove(Jogadores);
					PlayerAPI.Batalhando.remove(Jogadores);
				}
				if (PlayerAPI.Participando.size() > 1) {
					PlayerAPI.SelecionarProximoJogador(Ganhador);
				} else {
					PlayerAPI.CheckarGanhador(Ganhador);
				}
				return;
			}
			if (PlayerAPI.Batalhando.contains(Jogador) && PlayerAPI.Participando.contains(Jogador)
					&& PlayerAPI.Batalhando1.get(Jogador) == Jogador.getName()
					&& PlayerAPI.Ganhador.get(Jogador) != Jogador.getName()) {
				final Player Ganhador = Bukkit.getPlayer((String) PlayerAPI.Batalhando2.get(Jogador));
				PlayerAPI.Batalhando.remove(Jogador);
				PlayerAPI.Participando.remove(Jogador);
				Tempo.mandarBroadcast(
						"�7O jogador �c�l" + Jogador.getName() + " �7não aguentou e desistiu do duelo contra �a�l"
								+ Ganhador.getName() + "�7. �6(" + PlayerAPI.Participando.size() + "/30)");
				Tempo.mandarBroadcast("�7O jogador �a�l" + Ganhador.getName() + " �7venceu o duelo contra �c�l"
						+ Jogador.getName() + "�7. �e�l(" + PlayerAPI.Participando.size() + "�e�l/30)");
				Player[] onlinePlayers2;
				for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
					final Player Jogadores = onlinePlayers2[j];
					PlayerAPI.Batalhando1.remove(Jogadores);
					PlayerAPI.Ganhador.put(Jogadores, Ganhador.getName());
					PlayerAPI.Batalhando2.remove(Jogadores);
					PlayerAPI.Batalhando.remove(Jogadores);
				}
				if (PlayerAPI.Participando.size() > 1) {
					PlayerAPI.SelecionarProximoJogador(Ganhador);
				} else {
					PlayerAPI.CheckarGanhador(Ganhador);
				}
				return;
			}
			if (PlayerAPI.Batalhando.contains(Jogador) && PlayerAPI.Participando.contains(Jogador)
					&& PlayerAPI.Batalhando2.get(Jogador) == Jogador.getName()
					&& PlayerAPI.Ganhador.get(Jogador) == Jogador.getName()) {
				final Player Ganhador = Bukkit.getPlayer((String) PlayerAPI.Batalhando1.get(Jogador));
				PlayerAPI.Batalhando.remove(Jogador);
				PlayerAPI.Participando.remove(Jogador);
				Tempo.mandarBroadcast(
						"�7O jogador �c�l" + Jogador.getName() + " �7não aguentou e desistiu do duelo contra �a�l"
								+ Ganhador.getName() + "�7. �e�l(" + PlayerAPI.Participando.size() + "�e�l/30)");
				Tempo.mandarBroadcast("�7O jogador �a�l" + Ganhador.getName() + " �7venceu o duelo contra �c�l"
						+ Jogador.getName() + "�7. �e�l(" + PlayerAPI.Participando.size() + "�e�l/30)");
				Player[] onlinePlayers3;
				for (int length3 = (onlinePlayers3 = Bukkit.getOnlinePlayers()).length, k = 0; k < length3; ++k) {
					final Player Jogadores = onlinePlayers3[k];
					PlayerAPI.Ganhador.put(Jogadores, Ganhador.getName());
					PlayerAPI.Batalhando2.remove(Jogadores);
					PlayerAPI.Batalhando1.remove(Jogadores);
					PlayerAPI.Batalhando.remove(Jogadores);
				}
				if (PlayerAPI.Participando.size() > 1) {
					PlayerAPI.SelecionarProximoJogador(Ganhador);
				} else {
					PlayerAPI.CheckarGanhador(Ganhador);
				}
				return;
			}
			if (PlayerAPI.Batalhando.contains(Jogador) && PlayerAPI.Participando.contains(Jogador)
					&& PlayerAPI.Batalhando2.get(Jogador) == Jogador.getName()
					&& PlayerAPI.Ganhador.get(Jogador) != Jogador.getName()) {
				final Player Ganhador = Bukkit.getPlayer((String) PlayerAPI.Batalhando1.get(Jogador));
				PlayerAPI.Batalhando.remove(Jogador);
				PlayerAPI.Participando.remove(Jogador);
				Tempo.mandarBroadcast(
						"�7O jogador �c�l" + Jogador.getName() + " �7não aguentou e desistiu do duelo contra �a�l"
								+ Ganhador.getName() + "�7. �6(" + PlayerAPI.Participando.size() + "/30)");
				Tempo.mandarBroadcast("�7O jogador �a�l" + Ganhador.getName() + " �7venceu o duelo contra �c�l"
						+ Jogador.getName() + "�7. �6(" + PlayerAPI.Participando.size() + "/30)");
				Player[] onlinePlayers4;
				for (int length4 = (onlinePlayers4 = Bukkit.getOnlinePlayers()).length, l = 0; l < length4; ++l) {
					final Player Jogadores = onlinePlayers4[l];
					PlayerAPI.Ganhador.put(Jogadores, Ganhador.getName());
					PlayerAPI.Batalhando2.remove(Jogadores);
					PlayerAPI.Batalhando1.remove(Jogadores);
					PlayerAPI.Batalhando.remove(Jogadores);
				}
				if (PlayerAPI.Participando.size() > 1) {
					PlayerAPI.SelecionarProximoJogador(Ganhador);
				} else {
					PlayerAPI.CheckarGanhador(Ganhador);
				}
			}
		}
	}

	@EventHandler
	public void onPlayerDeathEvent(final PlayerDeathEvent Evento) {
		if (!(Evento.getEntity().getKiller() instanceof Player) || !(Evento.getEntity() instanceof Player)) {
			return;
		}
		final Player Matador = Evento.getEntity().getKiller();
		final Player Vitima = Evento.getEntity();
		if (Matador != Vitima) {
			if (CookiePvP.Evento == Estado.ANDAMENTO && PlayerAPI.Participando.contains(Matador)
					&& PlayerAPI.Participando.contains(Vitima)) {
				Matador.sendMessage("�fVoc\u00ea �a�lGANHOU �fa batalha contra �6�l" + Vitima.getName());
				Vitima.sendMessage("�fVoc\u00ea �c�lPERDEU �fa batalha contra �6�l" + Matador.getName());
				PlayerAPI.RemoverRDM(Vitima);
				PlayerAPI.Batalhando1.remove(Matador);
				PlayerAPI.Ganhador.put(Matador, Matador.getName());
				PlayerAPI.Batalhando2.remove(Matador);
				PlayerAPI.Batalhando.remove(Matador);
				PlayerAPI.Batalhando1.remove(Vitima);
				PlayerAPI.Ganhador.put(Vitima, Matador.getName());
				PlayerAPI.Batalhando2.remove(Vitima);
				PlayerAPI.Batalhando.remove(Vitima);
				PlayerAPI.Participando.remove(Vitima);
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player Jogadores = onlinePlayers[i];
					PlayerAPI.Batalhando1.remove(Jogadores);
					PlayerAPI.Ganhador.put(Jogadores, Matador.getName());
					PlayerAPI.Batalhando2.remove(Jogadores);
					PlayerAPI.Batalhando.remove(Jogadores);
				}
				Tempo.mandarBroadcast("�7O jogador �a�l" + Matador.getName() + " �7venceu o duelo contra �c�l"
						+ Vitima.getName() + "�7. �e�l(" + PlayerAPI.Participando.size() + "�e�l/30)");
				if (PlayerAPI.Ganhador.get(Matador) == Matador.getName()) {
					Tempo.mandarBroadcast("�7O jogador �a�l" + Matador.getName() + " �7continua na liderança!");
				} else {
					Tempo.mandarBroadcast(
							"�a�lGANHADOR: �fO jogador �2�l" + Matador.getName() + " �7\u00e9 o vencedor do evento!");
				}
				if (PlayerAPI.Participando.size() >= 2) {
					PlayerAPI.SelecionarProximoJogador(Matador);
				} else if (PlayerAPI.Participando.size() == 1) {
					PlayerAPI.CheckarGanhador(Matador);
				}
				Evento.getDrops().clear();
				Evento.setDroppedExp(0);
				Evento.setDeathMessage((String) null);
			}
		}
	}

	@EventHandler
	public void onPlayerRespawnEvent(final PlayerRespawnEvent Evento) {
		final Player Jogador = Evento.getPlayer();
		if (Configuração.getEvento().get("Saida") == null) {
			Jogador.sendMessage("�cO local de sa\u00edda ainda não foi setado!");
			return;
		}
		final double x = Configuração.getEvento().getDouble("Saida.X");
		final double y = Configuração.getEvento().getDouble("Saida.Y");
		final double z = Configuração.getEvento().getDouble("Saida.Z");
		final float pitch = (float) Configuração.getEvento().getDouble("Saida.Pitch");
		final float yaw = (float) Configuração.getEvento().getDouble("Saida.Yaw");
		if (CookiePvP.Evento == Estado.ANDAMENTO && PlayerAPI.Participando.contains(Jogador)) {
			Evento.setRespawnLocation(new Location(Jogador.getWorld(), x, y, z, yaw, pitch));
			API.sendItems(Jogador);
			Proteção.setImortal(Jogador, true);
		}
	}

	@EventHandler
	public void onPlayerCommandPreprocessEvent(final PlayerCommandPreprocessEvent Evento) {
		final Player Jogador = Evento.getPlayer();
		if (PlayerAPI.Batalhando.contains(Jogador)) {
			if (Evento.getMessage().toLowerCase().startsWith("/")) {
				Jogador.sendMessage("�cVoc\u00ea não pode utilizar comandos durante o duelo!");
				Evento.setCancelled(true);
			}
			return;
		}
		if (PlayerAPI.Participando.contains(Jogador) && !PlayerAPI.Batalhando.contains(Jogador)) {
			if (!Evento.getMessage().startsWith("/sair") && !Evento.getMessage().startsWith("/rdm")) {
				if (!Jogador.hasPermission("RDM.Admin")) {
					Jogador.sendMessage("�cVoc\u00ea não pode executar este comando aqui!");
				} else {
					Jogador.sendMessage(
							"�cVoc\u00ea s\u00f3 pode utilizar os comandos �c�l/sair �ce �c�l/rdm �cneste local.");
				}
				Evento.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onPlayerJoinEvent(final PlayerJoinEvent Evento) {
		if (CookiePvP.Evento == Estado.FECHADO) {
			return;
		}
		final Player Jogador = Evento.getPlayer();
		if (CookiePvP.Evento == Estado.INICIANDO || CookiePvP.Evento == Estado.ANDAMENTO) {
			Player[] onlinePlayers;
			for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
				final Player Jogadores = onlinePlayers[i];
				PlayerAPI.jogador1.put(Jogador, PlayerAPI.jogador1.get(Jogadores));
				PlayerAPI.jogador2.put(Jogador, PlayerAPI.jogador2.get(Jogadores));
				PlayerAPI.jogador3.put(Jogador, PlayerAPI.jogador3.get(Jogadores));
				PlayerAPI.jogador4.put(Jogador, PlayerAPI.jogador4.get(Jogadores));
				PlayerAPI.jogador5.put(Jogador, PlayerAPI.jogador5.get(Jogadores));
				PlayerAPI.jogador6.put(Jogador, PlayerAPI.jogador6.get(Jogadores));
				PlayerAPI.jogador7.put(Jogador, PlayerAPI.jogador7.get(Jogadores));
				PlayerAPI.jogador8.put(Jogador, PlayerAPI.jogador8.get(Jogadores));
				PlayerAPI.jogador9.put(Jogador, PlayerAPI.jogador9.get(Jogadores));
				PlayerAPI.jogador10.put(Jogador, PlayerAPI.jogador10.get(Jogadores));
				PlayerAPI.jogador11.put(Jogador, PlayerAPI.jogador11.get(Jogadores));
				PlayerAPI.jogador12.put(Jogador, PlayerAPI.jogador12.get(Jogadores));
				PlayerAPI.jogador13.put(Jogador, PlayerAPI.jogador13.get(Jogadores));
				PlayerAPI.jogador14.put(Jogador, PlayerAPI.jogador14.get(Jogadores));
				PlayerAPI.jogador15.put(Jogador, PlayerAPI.jogador15.get(Jogadores));
				PlayerAPI.jogador16.put(Jogador, PlayerAPI.jogador16.get(Jogadores));
				PlayerAPI.jogador17.put(Jogador, PlayerAPI.jogador17.get(Jogadores));
				PlayerAPI.jogador18.put(Jogador, PlayerAPI.jogador18.get(Jogadores));
				PlayerAPI.jogador19.put(Jogador, PlayerAPI.jogador19.get(Jogadores));
				PlayerAPI.jogador20.put(Jogador, PlayerAPI.jogador20.get(Jogadores));
				PlayerAPI.jogador21.put(Jogador, PlayerAPI.jogador21.get(Jogadores));
				PlayerAPI.jogador22.put(Jogador, PlayerAPI.jogador22.get(Jogadores));
				PlayerAPI.jogador23.put(Jogador, PlayerAPI.jogador23.get(Jogadores));
				PlayerAPI.jogador24.put(Jogador, PlayerAPI.jogador24.get(Jogadores));
				PlayerAPI.jogador25.put(Jogador, PlayerAPI.jogador25.get(Jogadores));
				PlayerAPI.jogador26.put(Jogador, PlayerAPI.jogador26.get(Jogadores));
				PlayerAPI.jogador27.put(Jogador, PlayerAPI.jogador27.get(Jogadores));
				PlayerAPI.jogador28.put(Jogador, PlayerAPI.jogador28.get(Jogadores));
				PlayerAPI.jogador29.put(Jogador, PlayerAPI.jogador29.get(Jogadores));
				PlayerAPI.jogador30.put(Jogador, PlayerAPI.jogador30.get(Jogadores));
			}
		}
	}
}
