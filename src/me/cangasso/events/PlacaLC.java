package me.cangasso.events;

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

import me.cangasso.API.API;
import me.cangasso.API.KitAPI;
import me.cangasso.API.WarpsAPI;
import me.cangasso.configuração.cfPermissão;
import me.cangasso.configuração.cfStatus;
import me.cangasso.scoreboard.sScoreAPI;

public class PlacaLC implements Listener {
	@EventHandler
	public void Escrever(final SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("lcfacil")) {
			e.setLine(0, "");
			e.setLine(1, "�9�lCompletar!");
			e.setLine(2, " ");
			e.setLine(3, "�7(F\u00e1cil)");
		}
		if (e.getLine(0).equalsIgnoreCase("lcmedio")) {
			e.setLine(0, " ");
			e.setLine(1, "�9�lCompletar!");
			e.setLine(2, " ");
			e.setLine(3, "�7(M\u00e9dio)");
		}
		if (e.getLine(0).equalsIgnoreCase("lcdificil")) {
			e.setLine(0, " ");
			e.setLine(1, "�9�lCompletar!");
			e.setLine(2, " ");
			e.setLine(3, "�7(Dif\u00edcil)");
		}
	}

	@EventHandler
	public void inv(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null
				&& (e.getClickedBlock().getType() == Material.WALL_SIGN
						|| e.getClickedBlock().getType() == Material.SIGN_POST)) {
			final Sign s = (Sign) e.getClickedBlock().getState();
			final String[] lines = s.getLines();
			if (lines.length > 0 && lines[0].equals(" ") && lines.length > 1 && lines[1].equals("�9�lCompletar!")
					&& lines.length > 2 && lines[2].equals(" ") && lines.length > 3 && lines[3].equals("�7(F\u00e1cil)")
					&& API.getWarp(p) == "Challenge") {
				p.sendMessage("�6�lCookie�f�lNetwork �7� �fVoc\u00ea completou o �6�lLavaChallenge �ff\u00e1cil!");
				cfStatus.setMoney(p, 500);
				p.getInventory().clear();
				p.getInventory().setArmorContents((ItemStack[]) null);
				KitAPI.removeKits(p);
				WarpsAPI.Ir(p, "Challenge");
				API.setWarp(p, "Challenge");
				KitAPI.setKitAntes(p, "Challenge");
				final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
				for (int i = 0; i < 36; ++i) {
					p.getInventory().setItem(i, sopa);
					p.updateInventory();
				}
				p.getInventory().setItem(13,
						API.criarItem(p, Material.RED_MUSHROOM, "�c�lCogumelo!", new String[] { "" }, 64, (short) 0));
				p.getInventory().setItem(14,
						API.criarItem(p, Material.BROWN_MUSHROOM, "�e�lCogumelo!", new String[] { "" }, 64, (short) 0));
				p.getInventory().setItem(15,
						API.criarItem(p, Material.BOWL, "�9�lPote!", new String[] { "" }, 64, (short) 0));
				sScoreAPI.scoreboard(p);
				p.sendMessage("�6�lCookie�f�lNetwork �7� �fVoc\u00ea ganhou �9�l500XP�f.");
			}
			if (lines.length > 0 && lines[0].equals(" ") && lines.length > 1 && lines[1].equals("�9�lCompletar!")
					&& lines.length > 2 && lines[2].equals("") && lines.length > 3 && lines[3].equals("�7(M\u00e9dio)")
					&& API.getWarp(p) == "Challenge") {
				p.sendMessage("�6�lCookie�f�lNetwork �7� �fVoc\u00ea completou o �6�lLavaChallenge �fm\u00e9dio!");
				cfStatus.setMoney(p, 1000);
				p.getInventory().clear();
				p.getInventory().setArmorContents((ItemStack[]) null);
				KitAPI.removeKits(p);
				WarpsAPI.Ir(p, "Challenge");
				API.setWarp(p, "Challenge");
				KitAPI.setKitAntes(p, "Challenge");
				final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
				for (int i = 0; i < 36; ++i) {
					p.getInventory().setItem(i, sopa);
					p.updateInventory();
				}
				p.getInventory().setItem(13,
						API.criarItem(p, Material.RED_MUSHROOM, "�c�lCogumelo!", new String[] { "" }, 64, (short) 0));
				p.getInventory().setItem(14,
						API.criarItem(p, Material.BROWN_MUSHROOM, "�e�lCogumelo!", new String[] { "" }, 64, (short) 0));
				p.getInventory().setItem(15,
						API.criarItem(p, Material.BOWL, "�9�lPote!", new String[] { "" }, 64, (short) 0));
				sScoreAPI.scoreboard(p);
				p.sendMessage("�6�lCookie�f�lNetwork �7� �fVoc\u00ea ganhou �9�l1000XP�f.");
			}
			if (lines.length > 0 && lines[0].equals(" ") && lines.length > 1 && lines[1].equals("�9�lCompletar!")
					&& lines.length > 2 && lines[2].equals(" ") && lines.length > 3
					&& lines[3].equals("�7(Dif\u00edcil)") && API.getWarp(p) == "Challenge") {
				p.sendMessage("�6�lCookie�f�lNetwork �7� �fVoc\u00ea completou o �6�lLavaChallenge �fdif\u00edcil!");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage("�6�lCookie�f�lNetwork �7� �fO jogador �9�l" + p.getName()
						+ " �fcompletou o n\u00edvel �c�ldif\u00edcil �fdo �6�lLavaChallenge�f!");
				Bukkit.broadcastMessage(" ");
				cfStatus.setMoney(p, 2000);
				cfPermissão.setarPermissao(p, "kit.firelauncher", "true");
				p.getInventory().clear();
				p.getInventory().setArmorContents((ItemStack[]) null);
				KitAPI.removeKits(p);
				WarpsAPI.Ir(p, "Challenge");
				API.setWarp(p, "Challenge");
				KitAPI.setKitAntes(p, "Challenge");
				final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
				for (int i = 0; i < 36; ++i) {
					p.getInventory().setItem(i, sopa);
					p.updateInventory();
				}
				p.getInventory().setItem(13,
						API.criarItem(p, Material.RED_MUSHROOM, "�c�lCogumelo!", new String[] { "" }, 64, (short) 0));
				p.getInventory().setItem(14,
						API.criarItem(p, Material.BROWN_MUSHROOM, "�e�lCogumelo!", new String[] { "" }, 64, (short) 0));
				p.getInventory().setItem(15,
						API.criarItem(p, Material.BOWL, "�9�lPote!", new String[] { "" }, 64, (short) 0));
				sScoreAPI.scoreboard(p);
				p.sendMessage("�6�lCookie�f�lNetwork �7� �fVoc\u00ea ganhou �9�l2000XP�f.");
				p.sendMessage("�6�lCookie�f�lNetwork �7� �fVoc\u00ea ganhou o kit �9�lFirelauncher�f!");
			}
		}
	}
}
