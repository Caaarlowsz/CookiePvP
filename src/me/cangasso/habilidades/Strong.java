package me.cangasso.habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.cangasso.API.CooldownAPI;
import me.cangasso.API.KitAPI;
import me.cangasso.main.Main;

public class Strong implements Listener {
	public static HashMap<Player, ItemStack[]> salvarArmadura;
	public static HashMap<Player, ItemStack[]> salvarInventario;
	public static ArrayList<Player> fulliron;

	static {
		Strong.salvarArmadura = new HashMap<Player, ItemStack[]>();
		Strong.salvarInventario = new HashMap<Player, ItemStack[]>();
		Strong.fulliron = new ArrayList<Player>();
	}

	@EventHandler
	public void interagir(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitAPI.getKit(p) == "Strong" && CooldownAPI.Cooldown.containsKey(p.getName())
				&& p.getItemInHand().getType() == Material.WATCH) {
			e.setCancelled(true);
			p.sendMessage("§8§l<§e§l!§8§l> §7Seu cooldown acaba em " + CooldownAPI.Cooldown + " §7segundos!");
		} else if (KitAPI.getKit(p) == "Strong" && !CooldownAPI.Cooldown.containsKey(p.getName())
				&& p.getItemInHand().getType() == Material.WATCH) {
			Strong.salvarInventario.put(p, p.getInventory().getContents());
			Strong.salvarArmadura.put(p, p.getInventory().getArmorContents());
			p.getInventory().setArmorContents((ItemStack[]) null);
			final ItemStack Peito = new ItemStack(Material.IRON_CHESTPLATE);
			final ItemStack Cal\u00e7a = new ItemStack(Material.IRON_LEGGINGS);
			final ItemStack Bota = new ItemStack(Material.IRON_BOOTS);
			final ItemStack Capacete = new ItemStack(Material.IRON_HELMET);
			final ItemStack Espada = new ItemStack(Material.STONE_SWORD);
			Espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			p.getInventory().setChestplate(Peito);
			p.getInventory().setLeggings(Cal\u00e7a);
			p.getInventory().setHelmet(Capacete);
			p.getInventory().setBoots(Bota);
			p.getInventory().setItem(0, Espada);
			p.updateInventory();
			CooldownAPI.addCooldown(p, 60);
			p.sendMessage("§fAgora voc\u00ea est\u00e1 §7§lFULLIRON §fpor §a§l10 segundos§f.");
			Strong.fulliron.add(p);
			if (Strong.fulliron.contains(p)) {
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						if (Strong.fulliron.contains(p)) {
							p.sendMessage("§aA sua armadura voltou ao normal!");
							p.getInventory().setArmorContents((ItemStack[]) null);
							p.closeInventory();
							p.getInventory().remove(Material.IRON_CHESTPLATE);
							p.getInventory().remove(Material.IRON_LEGGINGS);
							p.getInventory().remove(Material.IRON_BOOTS);
							p.getInventory().remove(Material.IRON_HELMET);
							p.getInventory().remove(Material.IRON_SWORD);
							p.getInventory().setArmorContents((ItemStack[]) Strong.salvarArmadura.get(p));
							if (KitAPI.getKit(p) == "Strong") {
								final ItemStack Espada = new ItemStack(Material.WOOD_SWORD);
								Espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
								final ItemMeta kEspada = Espada.getItemMeta();
								kEspada.setDisplayName("§eEspada");
								Espada.setItemMeta(kEspada);
								p.getInventory().setItem(0, Espada);
							}
						}
					}
				}, 200L);
			}
		}
	}
}
