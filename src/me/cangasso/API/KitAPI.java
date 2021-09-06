package me.cangasso.API;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import me.cangasso.commands.FlyCommand;
import me.cangasso.invencivel.Prote\u00e7\u00e3o;
import me.cangasso.main.Main;
import me.cangasso.scoreboard.sScoreAPI;

public class KitAPI {
	private static HashMap<Player, String> Kit;
	private static HashMap<Player, String> KitAntes;

	static {
		KitAPI.Kit = new HashMap<Player, String>();
		KitAPI.KitAntes = new HashMap<Player, String>();
	}

	public static String getKit(final Player p) {
		if (KitAPI.Kit.containsKey(p)) {
			return KitAPI.Kit.get(p);
		}
		return "Nenhum";
	}

	public static String getKitAntes(final Player p) {
		if (KitAPI.KitAntes.containsKey(p)) {
			return KitAPI.KitAntes.get(p);
		}
		return "Nenhum";
	}

	public static void setKit(final Player p, final String kit) {
		KitAPI.Kit.put(p, kit);
	}

	public static void setKitAntes(final Player p, final String kit) {
		KitAPI.KitAntes.put(p, kit);
	}

	public static void removeKits(final Player p) {
		KitAPI.Kit.remove(p);
		KitAPI.KitAntes.remove(p);
	}

	public static void darKit(final Player p, final String kit) {
		if (p.getLocation().getY() < 160.0) {
			p.setGameMode(GameMode.SURVIVAL);
			p.setAllowFlight(false);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			API.setWarp(p, "Arena");
			sScoreAPI.scoreboard(p);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					Prote\u00e7\u00e3o.setImortal(p, false);
				}
			}, 20L);
			FlyCommand.Fly.remove(p);
			final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
			for (int i = 0; i < 36; ++i) {
				p.getInventory().setItem(i, sopa);
				p.updateInventory();
			}
			p.getInventory().setItem(13,
					API.criarItem(p, Material.RED_MUSHROOM, "§c§lCogumelo!", new String[] { "" }, 64, (short) 0));
			p.getInventory().setItem(14,
					API.criarItem(p, Material.BROWN_MUSHROOM, "§e§lCogumelo!", new String[] { "" }, 64, (short) 0));
			p.getInventory().setItem(15,
					API.criarItem(p, Material.BOWL, "§9§lPote!", new String[] { "" }, 64, (short) 0));
			if (getKitAntes(p) == "PvP") {
				final ItemStack Espada = new ItemStack(Material.STONE_SWORD);
				Espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				final ItemMeta kEspada = Espada.getItemMeta();
				kEspada.setDisplayName("§5§oEspada");
				Espada.setItemMeta(kEspada);
				p.getInventory().setItem(0, Espada);
				final ItemStack Peito = new ItemStack(Material.LEATHER_CHESTPLATE);
				final LeatherArmorMeta kPeito = (LeatherArmorMeta) Peito.getItemMeta();
				kPeito.setDisplayName("§a§lPeitoral");
				kPeito.setColor(Color.LIME);
				Peito.setItemMeta((ItemMeta) kPeito);
				p.getInventory().setChestplate(Peito);
			} else {
				final ItemStack Espada = new ItemStack(Material.WOOD_SWORD);
				Espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				final ItemMeta kEspada = Espada.getItemMeta();
				kEspada.setDisplayName("§5§lSword!");
				Espada.setItemMeta(kEspada);
				final ItemStack Peito = new ItemStack(Material.LEATHER_CHESTPLATE);
				final LeatherArmorMeta kPeito = (LeatherArmorMeta) Peito.getItemMeta();
				kPeito.setDisplayName("§3§lPeitoral");
				kPeito.setColor(Color.AQUA);
				Peito.setItemMeta((ItemMeta) kPeito);
				p.getInventory().setChestplate(Peito);
				p.getInventory().setItem(0, Espada);
			}
			if (getKitAntes(p) == "Kangaroo") {
				final ItemStack Item = new ItemStack(Material.FIREWORK);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
			if (getKitAntes(p) == "Archer") {
				final ItemStack Item = new ItemStack(Material.BOW);
				Item.addEnchantment(Enchantment.ARROW_INFINITE, 1);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				final ItemStack Item2 = new ItemStack(Material.ARROW);
				final ItemMeta kItem2 = Item2.getItemMeta();
				kItem2.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item2.setItemMeta(kItem2);
				p.getInventory().setItem(1, Item);
				p.getInventory().setItem(9, Item2);
			}
			if (getKitAntes(p) == "Grappler") {
				final ItemStack Item = new ItemStack(Material.LEASH);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
			if (getKitAntes(p) == "Gladiator") {
				final ItemStack Item = new ItemStack(Material.IRON_FENCE);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
			if (getKitAntes(p) == "Fisherman") {
				final ItemStack Item = new ItemStack(Material.FISHING_ROD);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
			if (getKitAntes(p) == "Monk") {
				final ItemStack Item = new ItemStack(Material.BLAZE_ROD);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
			if (getKitAntes(p) == "Phantom") {
				final ItemStack Item = new ItemStack(Material.FEATHER);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
			if (getKitAntes(p) == "Thor") {
				final ItemStack Item = new ItemStack(Material.GOLD_AXE);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
			if (getKitAntes(p) == "Stomper") {
				final ItemStack Item = new ItemStack(Material.GOLDEN_APPLE);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
			if (getKitAntes(p) == "Timelord") {
				final ItemStack Item = new ItemStack(Material.WATCH);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
			if (getKitAntes(p) == "Cactus") {
				final ItemStack Item = new ItemStack(Material.CACTUS);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.addEnchant(Enchantment.THORNS, 2, true);
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setHelmet(Item);
			}
			if (getKitAntes(p) == "Grandpa") {
				final ItemStack Item = new ItemStack(Material.STICK);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.addEnchant(Enchantment.KNOCKBACK, 3, true);
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
			if (getKitAntes(p) == "Switcher") {
				final ItemStack Item = new ItemStack(Material.SNOW_BALL, 10);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
			if (getKitAntes(p) == "FireLauncher") {
				final ItemStack Item = new ItemStack(Material.BLAZE_POWDER);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
			if (getKitAntes(p) == "Strong") {
				final ItemStack Item = new ItemStack(Material.WATCH);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
			if (getKitAntes(p) == "Forcefield") {
				final ItemStack Item = new ItemStack(Material.IRON_FENCE);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
			if (getKitAntes(p) == "Sumo") {
				final ItemStack Item = new ItemStack(Material.APPLE);
				final ItemMeta kItem = Item.getItemMeta();
				kItem.setDisplayName("§7\u27b3 §a§l" + getKitAntes(p));
				Item.setItemMeta(kItem);
				p.getInventory().setItem(1, Item);
			}
		}
	}
}
