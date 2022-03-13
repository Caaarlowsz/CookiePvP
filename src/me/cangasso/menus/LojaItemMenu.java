package me.cangasso.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.cangasso.API.API;

public class LojaItemMenu implements Listener {
	public static void setarInventario(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 27, "�7Lojas dos �9�lservidores�7.");
		final ItemStack kits = new ItemStack(Material.DIAMOND_SWORD);
		final ItemMeta kitsm = kits.getItemMeta();
		kitsm.setDisplayName("�fLoja de �6�lKITS");
		kits.setItemMeta(kitsm);
		final ItemStack site = new ItemStack(Material.EMERALD);
		final ItemMeta sitem = site.getItemMeta();
		sitem.setDisplayName("�fLoja �a�lONLINE");
		site.setItemMeta(sitem);
		inv.setItem(11, kits);
		inv.setItem(15, site);
		p.openInventory(inv);
	}

	@EventHandler
	public void abrirInv(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.EMERALD && API.getWarp(p) == "Spawn"
				&& e.getAction() == Action.RIGHT_CLICK_AIR)
				|| (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta()
						&& p.getItemInHand().getItemMeta().hasDisplayName()
						&& p.getItemInHand().getItemMeta().getDisplayName().equals("�6� �7Loja"))) {
			setarInventario(p);
		}
	}

	@EventHandler
	public void clicarInv(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("�7Lojas dos �9�lservidores�7.")) {
			if (e.getCurrentItem().getType() == Material.AIR) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
				e.setCancelled(true);
				LojaMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getType() == Material.EMERALD) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage(" ");
				p.sendMessage(
						"�6�lCookie�f�lNetwork �7� �fCompre pacotes de �a�lVIP �fou �6�lKITS �facessando: �6�lmc-cookie.com.br");
				p.sendMessage(" ");
			}
		}
	}
}
