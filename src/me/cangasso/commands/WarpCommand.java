package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.cangasso.API.API;
import me.cangasso.API.KitAPI;
import me.cangasso.API.WarpsAPI;
import me.cangasso.invencivel.Prote\u00e7\u00e3o;
import me.cangasso.main.Main;
import me.cangasso.menus.WarpsMenu;
import me.cangasso.scoreboard.sScoreAPI;

public class WarpCommand implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("warp")) {
			if (Args.length == 0) {
				WarpsMenu.inventory(p);
				return true;
			}
			if (Args[0].equalsIgnoreCase("fps")) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 99999));
				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents((ItemStack[]) null);
				p.sendMessage("§fVoc\u00ea est\u00e1 sendo enviado para a warp §6§lFPS§f!");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.setGameMode(GameMode.SURVIVAL);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0);
						p.setMaxHealth(20.0);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents((ItemStack[]) null);
						WarpsAPI.Ir(p, "Fps");
						API.setWarp(p, "Fps");
						sScoreAPI.scoreboard(p);
						final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
						for (int i = 0; i < 36; ++i) {
							p.getInventory().setItem(i, sopa);
							p.updateInventory();
						}
						p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "§a§lCogumelo!",
								new String[] { "" }, 64, (short) 0));
						p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "§e§lCogumelo!",
								new String[] { "" }, 64, (short) 0));
						p.getInventory().setItem(15,
								API.criarItem(p, Material.BOWL, "§9§lPote!", new String[] { "" }, 64, (short) 0));
						final ItemStack Espada = new ItemStack(Material.STONE_SWORD);
						Espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
						final ItemMeta kEspada = Espada.getItemMeta();
						kEspada.setDisplayName("§5§oEspeada");
						Espada.setItemMeta(kEspada);
						p.getInventory().setItem(0, Espada);
					}
				}, 60L);
			} else if (Args[0].equalsIgnoreCase("1v1")) {
				p.sendMessage("§fVoc\u00ea est\u00e1 sendo enviado para a warp §6§l1V1§f!");
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 99999));
				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents((ItemStack[]) null);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0);
						p.setMaxHealth(20.0);
						p.setGameMode(GameMode.SURVIVAL);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents((ItemStack[]) null);
						KitAPI.removeKits(p);
						WarpsAPI.Ir(p, "1v1");
						API.setWarp(p, "1v1");
						Prote\u00e7\u00e3o.setImortal(p, true);
						sScoreAPI.scoreboard(p);
						WarpsAPI.segundos.remove(p.getName());
						final ItemStack Espada = new ItemStack(Material.BLAZE_ROD);
						final ItemMeta kEspada = Espada.getItemMeta();
						kEspada.setDisplayName("§eDesafie um jogador! §8(bot\u00e3o direito)");
						Espada.setItemMeta(kEspada);
						final ItemStack Espada2 = new ItemStack(Material.INK_SACK, 1, (short) 8);
						final ItemMeta kEspada2 = Espada2.getItemMeta();
						kEspada2.setDisplayName("§eDuelo r\u00e1pido! §8(bot\u00e3o direito)");
						Espada2.setItemMeta(kEspada2);
						p.getInventory().setItem(3, Espada);
						p.getInventory().setItem(5, Espada2);
					}
				}, 60L);
			} else if (Args[0].equalsIgnoreCase("challenge")) {
				p.sendMessage("§fVoc\u00ea est\u00e1 sendo enviado para a warp §6§lLAVACHALLENGE§f!");
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 99999));
				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents((ItemStack[]) null);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0);
						p.setMaxHealth(20.0);
						p.setGameMode(GameMode.SURVIVAL);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents((ItemStack[]) null);
						WarpsAPI.Ir(p, "Challenge");
						API.setWarp(p, "Challenge");
						sScoreAPI.scoreboard(p);
						final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
						for (int i = 0; i < 36; ++i) {
							p.getInventory().setItem(i, sopa);
							p.updateInventory();
						}
						p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "§cCogumelo vermelho",
								new String[] { "" }, 64, (short) 0));
						p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "§eCogumelo marrom",
								new String[] { "" }, 64, (short) 0));
						p.getInventory().setItem(15,
								API.criarItem(p, Material.BOWL, "§7Pote", new String[] { "" }, 64, (short) 0));
					}
				}, 60L);
			} else if (Args[0].equalsIgnoreCase("knockback")) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 99999));
				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents((ItemStack[]) null);
				p.sendMessage("§fVoc\u00ea est\u00e1 sendo enviado para a warp §6§lKNOCKBACK§f!");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.setGameMode(GameMode.SURVIVAL);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0);
						p.setMaxHealth(20.0);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents((ItemStack[]) null);
						WarpsAPI.Ir(p, "Knockback");
						API.setWarp(p, "Knockback");
						sScoreAPI.scoreboard(p);
						Prote\u00e7\u00e3o.setImortal(p, false);
						final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
						for (int i = 0; i < 36; ++i) {
							p.getInventory().setItem(i, sopa);
							p.updateInventory();
						}
						p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "§cCogumelo vermelho",
								new String[] { "" }, 64, (short) 0));
						p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "§eCogumelo marrom",
								new String[] { "" }, 64, (short) 0));
						p.getInventory().setItem(15,
								API.criarItem(p, Material.BOWL, "§7Pote", new String[] { "" }, 64, (short) 0));
						final ItemStack Espada = new ItemStack(Material.STICK);
						final ItemMeta kEspada = Espada.getItemMeta();
						kEspada.setDisplayName("§eKnockBack");
						kEspada.addEnchant(Enchantment.KNOCKBACK, 5, true);
						Espada.setItemMeta(kEspada);
						p.getInventory().setItem(0, Espada);
					}
				}, 60L);
			} else if (Args[0].equalsIgnoreCase("main")) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 99999));
				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents((ItemStack[]) null);
				p.sendMessage("§fVoc\u00ea est\u00e1 sendo enviado para a warp §6§lMAIN");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.setGameMode(GameMode.SURVIVAL);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0);
						p.setMaxHealth(20.0);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents((ItemStack[]) null);
						WarpsAPI.Ir(p, "Main");
						API.setWarp(p, "Main");
						sScoreAPI.scoreboard(p);
						Prote\u00e7\u00e3o.setImortal(p, false);
						final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
						for (int i = 0; i < 36; ++i) {
							p.getInventory().setItem(i, sopa);
							p.updateInventory();
						}
						final ItemStack peitoral = new ItemStack(Material.IRON_CHESTPLATE);
						final ItemMeta peitoralm = peitoral.getItemMeta();
						peitoralm.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
						peitoralm.setDisplayName("§6§lPeitoral de Ferro");
						peitoral.setItemMeta(peitoralm);
						final ItemStack capacete = new ItemStack(Material.IRON_HELMET);
						final ItemMeta capacetem = capacete.getItemMeta();
						capacetem.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
						capacetem.setDisplayName("§6§lCapacete de Ferro");
						capacete.setItemMeta(capacetem);
						final ItemStack calca = new ItemStack(Material.IRON_LEGGINGS);
						final ItemMeta calcam = peitoral.getItemMeta();
						calcam.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
						calcam.setDisplayName("§6§lCal\u00e7a de Ferro");
						calca.setItemMeta(calcam);
						final ItemStack bota = new ItemStack(Material.IRON_BOOTS);
						final ItemMeta botam = bota.getItemMeta();
						botam.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
						botam.setDisplayName("§6§lBotas de Ferro");
						bota.setItemMeta(botam);
						p.getInventory().setHelmet(capacete);
						p.getInventory().setChestplate(peitoral);
						p.getInventory().setLeggings(calca);
						p.getInventory().setBoots(bota);
						p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "§a§lCogumelo!",
								new String[] { "" }, 64, (short) 0));
						p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "§e§lCogumelo!",
								new String[] { "" }, 64, (short) 0));
						p.getInventory().setItem(15,
								API.criarItem(p, Material.BOWL, "§9§lPote!", new String[] { "" }, 64, (short) 0));
						final ItemStack Espada = new ItemStack(Material.DIAMOND_SWORD);
						Espada.addEnchantment(Enchantment.DAMAGE_ALL, 2);
						final ItemMeta kEspada = Espada.getItemMeta();
						kEspada.setDisplayName("§5§oEspada");
						Espada.setItemMeta(kEspada);
						p.getInventory().setItem(0, Espada);
					}
				}, 60L);
			} else if (Args[0].equalsIgnoreCase("fisherman")) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 99999));
				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents((ItemStack[]) null);
				p.sendMessage("§fVoc\u00ea est\u00e1 sendo enviado para a warp §6§lFISHERMAN");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.setGameMode(GameMode.SURVIVAL);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0);
						p.setMaxHealth(20.0);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents((ItemStack[]) null);
						WarpsAPI.Ir(p, "Fisherman");
						API.setWarp(p, "Fisherman");
						KitAPI.setKit(p, "Fisherman");
						sScoreAPI.scoreboard(p);
						Prote\u00e7\u00e3o.setImortal(p, false);
						final ItemStack Espada = new ItemStack(Material.FISHING_ROD);
						final ItemMeta kEspada = Espada.getItemMeta();
						kEspada.setDisplayName("§5§oVara de pesca");
						Espada.setItemMeta(kEspada);
						p.getInventory().setItem(0, Espada);
					}
				}, 60L);
			}
		}
		return false;
	}

	@EventHandler
	public void aoConsume(final PlayerItemConsumeEvent e) {
		final Player p = e.getPlayer();
		if (API.getWarp(p) == "Arena" || API.getWarp(p) == "Main" || API.getWarp(p) == "Fisherman") {
			e.setCancelled(true);
		}
	}
}
