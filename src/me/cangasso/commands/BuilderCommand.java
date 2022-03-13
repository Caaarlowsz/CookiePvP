package me.cangasso.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.cangasso.API.API;
import me.cangasso.API.ArraysAPI;
import me.cangasso.API.KitAPI;
import me.cangasso.configuração.cfGrupo;
import me.cangasso.invencivel.Proteção;
import me.cangasso.main.CookiePvP;
import me.cangasso.scoreboard.sScoreAPI;

public class BuilderCommand implements CommandExecutor, Listener {
	public static HashMap<Player, ItemStack[]> inventario;
	public static HashMap<Player, String> warp;
	public static HashMap<Player, String> kit;

	static {
		BuilderCommand.inventario = new HashMap<Player, ItemStack[]>();
		BuilderCommand.warp = new HashMap<Player, String>();
		BuilderCommand.kit = new HashMap<Player, String>();
	}

	@EventHandler
	private void interact(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.MAGMA_CREAM && ArraysAPI.Admin.contains(p)
				&& e.getAction() == Action.RIGHT_CLICK_AIR)
				|| (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta()
						&& p.getItemInHand().getItemMeta().hasDisplayName()
						&& p.getItemInHand().getItemMeta().getDisplayName().equals("�aTroca Rapida"))) {
			Player[] onlinePlayers;
			for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
				final Player todos = onlinePlayers[i];
				todos.showPlayer(p);
				p.showPlayer(todos);
			}
			Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					ArraysAPI.Admin.add(p);
					BuilderCommand.setAdmin(p);
				}
			}, 10L);
		}
	}

	@EventHandler
	public void autosoup(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (p instanceof Player && e.getRightClicked() instanceof Player
				&& p.getItemInHand().getType() == Material.MUSHROOM_SOUP && ArraysAPI.Admin.contains(p)) {
			final Player t = (Player) e.getRightClicked();
			if (ArraysAPI.Checando.contains(t)) {
				p.sendMessage("�4�l(!) �cAcesso negado!");
				return;
			}
			BuilderCommand.inventario.put(t, t.getInventory().getContents());
			t.getInventory().clear();
			t.setHealth(0.5);
			ArraysAPI.Checando.add(t);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					ArraysAPI.Checando.remove(t);
					t.getInventory().clear();
					t.closeInventory();
					t.getInventory().setContents((ItemStack[]) BuilderCommand.inventario.get(t));
					t.setHealth(20.0);
				}
			}, 60L);
		}
		if (p.getItemInHand().getType() == Material.IRON_FENCE && ArraysAPI.Admin.contains(p)) {
			final Player t = (Player) e.getRightClicked();
			p.sendMessage("�a�l(!) �7Voc\u00ea prendeu o jogador: �6�l" + t.getName());
			t.getLocation().add(0.0, 13.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0, 11.0, 1.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0, 11.0, -1.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(-1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0, 10.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.teleport(t.getLocation().add(0.0, 11.0, -0.05));
			p.teleport(t.getLocation().add(3.0, 0.0, 0.05));
		}
		if (p.getItemInHand().getType() == Material.AIR && ArraysAPI.Admin.contains(p)) {
			final Player t = (Player) e.getRightClicked();
			p.openInventory((Inventory) t.getInventory());
		}
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("builder")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")
					&& !cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Builder")
					&& !cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")
					&& !cfGrupo.ChecarGrupo(p, "Gerente")) {
				p.sendMessage("�c�l(!) �cVoc\u00ea não possui permissão para executar este comando!");
				return true;
			}
			if (!ArraysAPI.Admin.contains(p)) {
				ArraysAPI.Admin.add(p);
				BuilderCommand.kit.put(p, KitAPI.getKitAntes(p));
				BuilderCommand.warp.put(p, API.getWarp(p));
				BuilderCommand.inventario.put(p, p.getInventory().getContents());
				p.getInventory().clear();
				p.getInventory().setArmorContents((ItemStack[]) null);
				Proteção.setImortal(p, false);
				p.sendMessage("�2�lBUILDER: �fModo Builder: �aATIVADO");
				API.sendWarn("�7�o[" + p.getName() + "�7�o entrou no modo BUILDER]");
				KitAPI.setKitAntes(p, "Admin");
				API.setWarp(p, "Admin");
				p.setHealth(20.0);
				p.setMaxHealth(20.0);
				p.setGameMode(GameMode.CREATIVE);
				setAdmin(p);
				ArraysAPI.Jogando.remove(p);
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player todos = onlinePlayers[i];
					sScoreAPI.scoreboard(todos);
				}
				sScoreAPI.scoreboard(p);
				return true;
			}
			if (ArraysAPI.Admin.contains(p)) {
				ArraysAPI.Admin.remove(p);
				p.sendMessage("�2�lBUILDER: �fModo Builder: �cDESATIVADO");
				API.sendWarn("�7�o[" + p.getName() + "�7�o saiu do modo BUILDER]");
				KitAPI.setKitAntes(p, BuilderCommand.kit.get(p));
				API.setWarp(p, BuilderCommand.warp.get(p));
				p.setGameMode(GameMode.SURVIVAL);
				p.getInventory().clear();
				p.getInventory().setArmorContents((ItemStack[]) null);
				p.getInventory().setContents((ItemStack[]) BuilderCommand.inventario.get(p));
				p.updateInventory();
				ArraysAPI.Jogando.add(p);
				Player[] onlinePlayers2;
				for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
					final Player todos = onlinePlayers2[j];
					sScoreAPI.scoreboard(todos);
				}
				Player[] onlinePlayers3;
				for (int length3 = (onlinePlayers3 = Bukkit.getOnlinePlayers()).length, k = 0; k < length3; ++k) {
					final Player todos = onlinePlayers3[k];
					todos.showPlayer(p);
					p.showPlayer(todos);
				}
				sScoreAPI.scoreboard(p);
			}
		}
		return false;
	}

	public static void setAdmin(final Player p) {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player todos = onlinePlayers[i];
			if (cfGrupo.ChecarGrupo(todos, "Dono") || cfGrupo.ChecarGrupo(todos, "Gerente")
					|| cfGrupo.ChecarGrupo(todos, "Admin") || cfGrupo.ChecarGrupo(todos, "Mod+")
					|| cfGrupo.ChecarGrupo(todos, "Builder")) {
				todos.showPlayer(p);
				p.showPlayer(todos);
			} else if (ArraysAPI.Admin.contains(p)) {
				todos.hidePlayer(p);
			}
		}
	}

	public static void checarAdmin() {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player todos = onlinePlayers[i];
			if (ArraysAPI.Admin.contains(todos)) {
				setAdmin(todos);
			}
		}
	}
}
