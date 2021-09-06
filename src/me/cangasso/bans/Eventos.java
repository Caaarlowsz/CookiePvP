package me.cangasso.bans;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class Eventos implements Listener {
	@EventHandler
	void chatevent(final PlayerChatEvent evento) {
		final Player jogador = evento.getPlayer();
		if (Config.getConfig().getMute().get("Mute." + jogador.getUniqueId()) != null) {
			API.sendMsg((CommandSender) jogador, "§cVoc\u00ea est\u00e1 mutado!");
			API.sendSound(jogador, Sound.ANVIL_USE, 10);
			evento.setCancelled(true);
		} else if (Config.getConfig().getTempMute().get("TempMute." + jogador.getUniqueId()) != null) {
			API.sendMsg((CommandSender) jogador, "§cVoc\u00ea est\u00e1 mutado!");
			API.sendSound(jogador, Sound.ANVIL_USE, 10);
			evento.setCancelled(true);
		}
	}

	@EventHandler
	public void loginEvent(final PlayerLoginEvent evento) {
		final Player jogador = evento.getPlayer();
		if (Config.getConfig().getBans().get("Bans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER,
					ChatColor.GRAY + "§7Voc\u00ea est\u00e1 banido §4§lPERMANENTEMENTE §7do servidor!" + "\n"
							+ "§7Username banido: §c§l"
							+ Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Nome") + "\n"
							+ "§7Banido por: §c§l"
							+ Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Banido por") + "\n"
							+ "§7Motivo: §c§l"
							+ Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Motivo") + "\n"
							+ "§7Expira em: §c§lNUNCA" + "\n" + "§7Data do banimento: §c§l"
							+ Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Data do banimento")
							+ "\n" + "§7Compre §e§lUNBAN §7em nossa loja §6§lmc-cookie.com.br" + "\n"
							+ "§7Banimento incorreto? Contate-nos pelo Twitter §b§l@Cookie_Suporte§f!");
		} else if (Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER,
					ChatColor.GRAY + "§7Voc\u00ea est\u00e1 banido §9§TEMPORARIAMENTE §7 do servidor!" + "\n"
							+ "§7Username banido §c§l: "
							+ Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Nome") + "\n"
							+ "§7Banido por: §c§l"
							+ Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Banido por")
							+ "\n" + "§7Motivo: §c§l"
							+ Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Motivo")
							+ "\n" + "§7Expira em: §c§l"
							+ Config.getConfig().getTempBans()
									.get("TempBans." + jogador.getUniqueId() + ".Tempo do Ban")
							+ "\n" + "§7Data do banimento: §c§l"
							+ Config.getConfig().getTempBans()
									.get("TempBans." + jogador.getUniqueId() + ".Data do banimento")
							+ "\n" + "§7Compre §9§lUNBAN §fem nossa loja §6§lmc-cookie.com.br" + "\n"
							+ "§7Banimento incorreto? Contate-nos pelo Twitter §b§l@Cookie_Suporte§f!");
		} else if (Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER,
					ChatColor.GRAY + "§fVoc\u00ea est\u00e1 banido  §4§PERMANENTEMENTE§f do servidor!" + "\n"
							+ "§7Username banido: §c§l "
							+ Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Nome") + "\n"
							+ "§7IP banido: §c§l"
							+ Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".IP do Jogador")
							+ "\n" + "§7Banido por: §c§l"
							+ Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Banido por")
							+ "\n" + "§7Motivo: §c§l"
							+ Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Motivo") + "\n"
							+ "§7Expira em: §c§lNUNCA" + "\n" + "§cData do banimento: "
							+ Config.getConfig().getIpBans()
									.get("IPBans." + jogador.getUniqueId() + ".Data do banimento")
							+ "\n" + "§fCompre §2§lUNBAN §fem: §c§nmc-cookie.com.br" + "\n"
							+ "§7Foi banido injustamente? Contate-nos via Twitter §b§l@Cookie_Suporte§f!");
		} else if (evento.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			evento.setKickMessage("§c§lWHITELIST ATIVADA...\n§7Estamos em manuten\u00e7\u00e3o!");
		}
	}
}
