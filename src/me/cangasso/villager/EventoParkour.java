package me.cangasso.villager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import me.cangasso.API.API;
import me.cangasso.API.WarpsAPI;
import me.cangasso.invencivel.Proteção;

public class EventoParkour implements Listener {
	@EventHandler
	public void noExecut(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (VillagerParkour.noParkour.contains(p)) {
			e.setCancelled(true);
			p.sendMessage("�cVoc\u00ea não pode executar comandos enquanto estiver no Parkour!");
		}
	}

	@EventHandler
	public void protect(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.WATER
				&& Proteção.isImortal(p) && API.getWarp(p) == "FPS") {
			p.sendMessage("�cVoc\u00ea perdeu a sua proteção!");
			Proteção.setImortal(p, false);
		}
	}

	@EventHandler
	public void clickar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (API.getWarp(p) == "Spawn" && VillagerParkour.noParkour.contains(p)
				&& p.getItemInHand().getType() == Material.BED) {
			WarpsAPI.Ir(p, "Spawn");
			API.sendItems(p);
			VillagerParkour.noParkour.remove(p);
			p.getInventory().clear();
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.sendMessage("�cVoc\u00ea saiu do Parkour!");
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
			Player[] onlinePlayers;
			for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
				final Player todos = onlinePlayers[i];
				p.showPlayer(todos);
				todos.showPlayer(p);
			}
		}
	}

	@EventHandler
	public void limite(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.WATER && API.getWarp(p) == "Spawn"
				&& VillagerParkour.noParkour.contains(p)) {
			WarpsAPI.Ir(p, "Parkour");
			p.sendMessage("�7Voc\u00ea �c�lFALHOU�7, tente novamente!");
		}
	}
}
