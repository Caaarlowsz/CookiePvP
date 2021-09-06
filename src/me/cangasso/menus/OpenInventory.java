package me.cangasso.menus;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.cangasso.API.API;
import me.cangasso.API.KitdiarioAPI;
import me.cangasso.configura\u00e7\u00e3o.cfKitdiario;

public class OpenInventory implements Listener {
	@EventHandler
	public void abrirMenuKits(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.CHEST && API.getWarp(p) == "Spawn"
				&& e.getAction() == Action.RIGHT_CLICK_AIR)
				|| (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta()
						&& p.getItemInHand().getItemMeta().hasDisplayName()
						&& p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7Seletor de KITS"))) {
			KitsMenu.inventory(p);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 20.0f, 20.0f);
		}
	}

	@EventHandler
	public void abrirMenuWarps(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.NAME_TAG && API.getWarp(p) == "Spawn"
				&& e.getAction() == Action.RIGHT_CLICK_AIR)
				|| (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta()
						&& p.getItemInHand().getItemMeta().hasDisplayName()
						&& p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7Seletor de WARPS"))) {
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 20.0f, 20.0f);
			WarpsMenu.inventory(p);
		}
	}

	@EventHandler
	public void abrirConfig(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.getMaterial(351) && API.getWarp(p) == "Spawn"
				&& e.getAction() == Action.RIGHT_CLICK_AIR)
				|| (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta()
						&& p.getItemInHand().getItemMeta().hasDisplayName()
						&& p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7Kit PADRAO"))) {
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 20.0f, 20.0f);
			PadraoMenu.inventory(p);
		}
	}

	@EventHandler
	public void openCaixa(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.ENDER_CHEST && API.getWarp(p) == "Spawn"
				&& e.getAction() == Action.RIGHT_CLICK_AIR)
				|| (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta()
						&& p.getItemInHand().getItemMeta().hasDisplayName()
						&& p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7Kit DIARIO"))) {
			if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".hora") != null) {
				p.sendMessage("§cVoc\u00ea j\u00e1 utilizou o seu kit di\u00e1rio!");
			} else if (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".hora") == null) {
				p.playSound(p.getLocation(), Sound.EXPLODE, 20.0f, 20.0f);
				KitdiarioAPI.kitdiario(p);
				p.getInventory().remove(Material.ENDER_CHEST);
			}
		}
	}
}
