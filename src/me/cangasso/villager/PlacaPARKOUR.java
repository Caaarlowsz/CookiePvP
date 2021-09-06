package me.cangasso.villager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import me.cangasso.API.API;
import me.cangasso.API.WarpsAPI;
import me.cangasso.configura\u00e7\u00e3o.cfStatus;
import me.cangasso.scoreboard.sScoreAPI;

public class PlacaPARKOUR implements Listener {
	@EventHandler
	public void Escrever(final SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("parkoursign")) {
			e.setLine(0, "§6§lPARKOUR");
			e.setLine(1, "§7Iniciar parkour");
			e.setLine(2, " §7(Clique)");
			e.setLine(3, " ");
		}
	}

	@EventHandler
	public void clicar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null
				&& (e.getClickedBlock().getType() == Material.WALL_SIGN
						|| e.getClickedBlock().getType() == Material.SIGN_POST)
				&& API.getWarp(p) == "Parkour") {
			final Sign s = (Sign) e.getClickedBlock().getState();
			final String[] lines = s.getLines();
			if (lines.length > 0 && lines[0].equals(" ") && lines.length > 1 && lines[1].equals("§6§lPARKOUR")
					&& lines.length > 2 && lines[2].equals(" §7(Clique)") && lines.length > 3 && lines[3].equals(" ")) {
				p.sendMessage("§aParab\u00e9ns, voc\u00ea completou o parkour!");
				cfStatus.setMoney(p, 100);
				p.sendMessage("§aEm b\u00f4nus, voc\u00ea recebeu §a§l100 §ade XP!");
				API.setWarp(p, "Spawn");
				WarpsAPI.Ir(p, "Spawn");
				p.removePotionEffect(PotionEffectType.INVISIBILITY);
				p.getInventory().clear();
				p.getInventory().setArmorContents((ItemStack[]) null);
				API.sendItems(p);
				sScoreAPI.scoreboard(p);
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player todos = onlinePlayers[i];
					p.showPlayer(todos);
					todos.showPlayer(p);
				}
			}
		}
	}
}
