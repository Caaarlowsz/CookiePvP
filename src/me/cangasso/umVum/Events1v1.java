package me.cangasso.umVum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import me.cangasso.API.API;
import me.cangasso.API.KitAPI;
import me.cangasso.API.WarpsAPI;
import me.cangasso.configuração.cfGrupo;
import me.cangasso.invencivel.Proteção;
import me.cangasso.main.CookiePvP;

public class Events1v1 implements Listener {
	public static List<Player> ChamouDuelo;
	public static List<Player> AceitarDuelo;
	public static List<Player> Jogando1v1Player;
	public static List<Player> congelar;
	public static List<Player> inPvP;
	public static HashMap<String, String> JogandoSair;

	static {
		Events1v1.ChamouDuelo = new ArrayList<Player>();
		Events1v1.AceitarDuelo = new ArrayList<Player>();
		Events1v1.Jogando1v1Player = new ArrayList<Player>();
		Events1v1.congelar = new ArrayList<Player>();
		Events1v1.inPvP = new ArrayList<Player>();
		Events1v1.JogandoSair = new HashMap<String, String>();
	}

	@EventHandler
	public void PlayerInteractEntityEvent4(final PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		if (p.getItemInHand().equals((Object) Join1v1.Item_)) {
			if (Events1v1.ChamouDuelo.contains(p)) {
				p.sendMessage("�cAguarde para desafiar outro jogador...");
				return;
			}
			final Player Player2 = (Player) event.getRightClicked();
			Events1v1.AceitarDuelo.add(Player2);
			Events1v1.ChamouDuelo.add(p);
			p.sendMessage("�fVoc\u00ea desafiou o jogador: �6�l" + Player2.getName() + " �fpara um duelo!");
			Player2.sendMessage("�fVoc\u00ea foi desafiado por: �6�l" + p.getName() + " �fpara um duelo!");
			Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Events1v1.ChamouDuelo.contains(p)) {
						Events1v1.ChamouDuelo.remove(p);
						Events1v1.AceitarDuelo.remove(Player2);
					}
				}
			}, 100L);
		}
	}

	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		if (Events1v1.congelar.contains(player)) {
			event.setTo(player.getLocation());
			Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					Events1v1.congelar.remove(player);
				}
			}, 60L);
		}
	}

	@EventHandler
	public void PlayerInteractEntityEvent3(final PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		if (Events1v1.AceitarDuelo.contains(p) && p.getItemInHand().equals((Object) Join1v1.Item_)) {
			final Player Player2 = (Player) event.getRightClicked();
			if (Events1v1.ChamouDuelo.contains(Player2)) {
				Events1v1.Jogando1v1Player.add(p);
				Events1v1.Jogando1v1Player.add(Player2);
				Events1v1.JogandoSair.put(p.getName(), Player2.getName());
				Events1v1.JogandoSair.put(Player2.getName(), p.getName());
				Events1v1.congelar.add(p);
				Events1v1.congelar.add(Player2);
				Proteção.setImortal(Player2, false);
				Proteção.setImortal(p, false);
				WarpsAPI.Ir(Player2, "1v1loc2");
				WarpsAPI.Ir(p, "1v1loc1");
				Events1v1.ChamouDuelo.remove(Player2);
				Events1v1.AceitarDuelo.remove(Player2);
				Events1v1.ChamouDuelo.remove(p);
				Events1v1.AceitarDuelo.remove(p);
				Events1v1.inPvP.add(p);
				Events1v1.inPvP.add(Player2);
				p.getInventory().clear();
				Player2.getInventory().clear();
				final ItemStack Espada = new ItemStack(Material.DIAMOND_SWORD);
				Espada.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
				final ItemMeta Espada2 = Espada.getItemMeta();
				Espada2.setDisplayName("�5�oEspada");
				Espada.setItemMeta(Espada2);
				p.getInventory().addItem(new ItemStack[] { Espada });
				Player2.getInventory().addItem(new ItemStack[] { Espada });
				Player2.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
				Player2.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
				Player2.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				Player2.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
				p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
				p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
				p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
				p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
				for (int i = 1; i < 9; ++i) {
					final ItemStack Fisherman = new ItemStack(Material.MUSHROOM_SOUP);
					p.getInventory().addItem(new ItemStack[] { Fisherman });
					Player2.getInventory().addItem(new ItemStack[] { Fisherman });
					Player2.updateInventory();
					p.updateInventory();
					if (Speed1v1.Iniciou.contains(p)) {
						Speed1v1.Iniciou.remove(p);
						Speed1v1.Partida1 = false;
					}
					if (Speed1v1.Iniciou.contains(Player2)) {
						Speed1v1.Iniciou.remove(Player2);
						Speed1v1.Partida1 = false;
					}
					Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
						@Override
						public void run() {
							Player[] onlinePlayers;
							for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length,
									i = 0; i < length; ++i) {
								final Player plr = onlinePlayers[i];
								Player2.hidePlayer(plr);
								p.hidePlayer(plr);
								p.showPlayer(Player2);
								Player2.showPlayer(p);
							}
						}
					}, 2L);
					Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.plugin, (Runnable) new Runnable() {
						@Override
						public void run() {
							if (Events1v1.congelar.contains(p)) {
								p.setMaxHealth(20);
								p.setHealth(20);
								Player2.setMaxHealth(20);
								Player2.setHealth(20);
							}
						}
					}, 20L);
					Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.plugin, (Runnable) new Runnable() {
						@Override
						public void run() {
							if (Events1v1.congelar.contains(p)) {
								p.setMaxHealth(20);
								p.setHealth(20);
								Player2.setMaxHealth(20);
								Player2.setHealth(20);
							}
						}
					}, 40L);
					Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.plugin, (Runnable) new Runnable() {
						@Override
						public void run() {
							if (Events1v1.congelar.contains(p)) {
								p.setMaxHealth(20);
								p.setHealth(20);
								Player2.setMaxHealth(20);
								Player2.setHealth(20);
								Events1v1.congelar.remove(p);
							}
						}
					}, 60L);
				}
			}
		}
	}

	@EventHandler
	public void Morrer2(final PlayerDeathEvent e) {
		final Player v = e.getEntity();
		e.setDeathMessage("");
		if (e.getEntity().getKiller() instanceof Player) {
			final Player m = e.getEntity().getKiller();
			if (m != v) {
				if (!Events1v1.Jogando1v1Player.contains(m) && !Events1v1.Jogando1v1Player.contains(v)) {
					Events1v1.Jogando1v1Player.remove(v);
					Events1v1.Jogando1v1Player.remove(m);
					return;
				}
				final int amountv = this.itemsInInventory((Inventory) v.getInventory(),
						new Material[] { Material.MUSHROOM_SOUP });
				final int amountm = this.itemsInInventory((Inventory) m.getInventory(),
						new Material[] { Material.MUSHROOM_SOUP });
				Events1v1.inPvP.remove(m);
				Events1v1.inPvP.remove(v);
				m.sendMessage("     ");
				m.sendMessage(
						"�aVoc\u00ea ganhou o duelo contra " + v.getName() + "�a com �a�l" + amountv + " �asopas.");
				m.sendMessage("     ");
				Proteção.setImortal(v, true);
				Proteção.setImortal(m, true);
				v.sendMessage("     ");
				v.sendMessage("�cVoc\u00ea perdeu o duelo contra " + m.getName() + ". �cO jogador estava com �c�l"
						+ amountm + " �csopas.");
				v.sendMessage("     ");
				WarpsAPI.Ir(m, "1v1");
				m.setGameMode(GameMode.SURVIVAL);
				m.getInventory().setArmorContents((ItemStack[]) null);
				m.getInventory().clear();
				for (final PotionEffect effect : m.getActivePotionEffects()) {
					m.removePotionEffect(effect.getType());
				}
				Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						WarpsAPI.Ir(v, "1v1");
						v.setGameMode(GameMode.SURVIVAL);
						v.getInventory().setArmorContents((ItemStack[]) null);
						v.getInventory().clear();
						for (final PotionEffect effect : v.getActivePotionEffects()) {
							v.removePotionEffect(effect.getType());
						}
					}
				}, 1L);
				KitAPI.setKit(m, "1v1");
				KitAPI.setKit(v, "1v1");
				Events1v1.Jogando1v1Player.remove(v);
				Events1v1.Jogando1v1Player.remove(m);
				Events1v1.JogandoSair.remove(m.getName());
				Events1v1.JogandoSair.remove(v.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						v.getInventory().clear();
						m.getInventory().clear();
						v.getInventory().setItem(3, Join1v1.Item_);
						v.getInventory().setItem(5, Join1v1.Cinza);
						m.getInventory().setItem(3, Join1v1.Item_);
						m.getInventory().setItem(5, Join1v1.Cinza);
						m.updateInventory();
						v.updateInventory();
						WarpsAPI.Ir(v, "1v1");
						API.setWarp(m, "1v1");
						KitAPI.setKit(m, "1v1");
						KitAPI.setKit(v, "1v1");
						API.setWarp(v, "1v1");
					}
				}, 2L);
				m.setHealth(20);
				v.setHealth(20);
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player plr = onlinePlayers[i];
					v.showPlayer(plr);
					m.showPlayer(plr);
				}
			}
		}
	}

	@EventHandler
	public void Morrer3(final PlayerDeathEvent e) {
		final Player v = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player m = e.getEntity().getKiller();
			if (m != v) {
				if (!Events1v1.Jogando1v1Player.contains(v) && !Events1v1.Jogando1v1Player.contains(m)) {
					Events1v1.Jogando1v1Player.remove(v);
					Events1v1.Jogando1v1Player.remove(m);
					return;
				}
				final int amountv = this.itemsInInventory((Inventory) v.getInventory(),
						new Material[] { Material.MUSHROOM_SOUP });
				final int amountm = this.itemsInInventory((Inventory) m.getInventory(),
						new Material[] { Material.MUSHROOM_SOUP });
				m.sendMessage("     ");
				m.sendMessage(
						"�aVoc\u00ea ganhou o duelo contra " + v.getName() + "�a com �a�l" + amountv + " �asopas.");
				m.sendMessage("     ");
				Events1v1.inPvP.remove(m);
				Events1v1.inPvP.remove(v);
				Proteção.setImortal(v, true);
				Proteção.setImortal(m, true);
				v.sendMessage("     ");
				v.sendMessage("�cVoc\u00ea perdeu o duelo contra " + m.getName() + ". �cO jogador estava com �c�l"
						+ amountm + " �csopas.");
				v.sendMessage("     ");
				WarpsAPI.Ir(m, "1v1");
				m.setGameMode(GameMode.SURVIVAL);
				m.getInventory().setArmorContents((ItemStack[]) null);
				m.getInventory().clear();
				for (final PotionEffect effect : m.getActivePotionEffects()) {
					m.removePotionEffect(effect.getType());
				}
				Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						WarpsAPI.Ir(v, "1v1");
						v.setGameMode(GameMode.SURVIVAL);
						v.getInventory().setArmorContents((ItemStack[]) null);
						v.getInventory().clear();
						for (final PotionEffect effect : v.getActivePotionEffects()) {
							v.removePotionEffect(effect.getType());
						}
					}
				}, 1L);
				Events1v1.Jogando1v1Player.remove(v);
				Events1v1.Jogando1v1Player.remove(m);
				Events1v1.JogandoSair.remove(m.getName());
				Events1v1.JogandoSair.remove(v.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						v.getInventory().clear();
						m.getInventory().clear();
						v.getInventory().setItem(3, Join1v1.Item_);
						v.getInventory().setItem(5, Join1v1.Cinza);
						m.getInventory().setItem(3, Join1v1.Item_);
						m.getInventory().setItem(5, Join1v1.Cinza);
						m.updateInventory();
						v.updateInventory();
						WarpsAPI.Ir(v, "1v1");
						API.setWarp(m, "1v1");
						API.setWarp(v, "1v1");
						KitAPI.setKit(m, "1v1");
						KitAPI.setKit(v, "1v1");
					}
				}, 2L);
				m.setHealth(20);
				v.setHealth(20);
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player plr = onlinePlayers[i];
					v.showPlayer(plr);
					m.showPlayer(plr);
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLeft(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (Events1v1.JogandoSair.containsKey(p.getName())) {
			final Player t = Bukkit.getServer().getPlayer((String) Events1v1.JogandoSair.get(p.getName()));
			WarpsAPI.Ir(t, "1v1");
			Events1v1.JogandoSair.remove(t.getName());
			Events1v1.JogandoSair.remove(p.getName());
			Events1v1.Jogando1v1Player.remove(p);
			Events1v1.Jogando1v1Player.remove(t);
			Events1v1.inPvP.remove(p);
			Events1v1.inPvP.remove(t);
			t.setMaxHealth(20.0);
			t.setHealth(20.0);
			Proteção.setImortal(t, true);
			t.setGameMode(GameMode.SURVIVAL);
			t.getInventory().setArmorContents((ItemStack[]) null);
			t.getInventory().clear();
			for (final PotionEffect effect : t.getActivePotionEffects()) {
				t.removePotionEffect(effect.getType());
			}
			t.sendMessage("�fO jogador �e�l" + p.getName() + " �fdeslogou durante o duelo!");
			t.getInventory().setItem(3, Join1v1.Item_);
			t.getInventory().setItem(5, Join1v1.Cinza);
			KitAPI.setKit(t, "1v1");
			t.updateInventory();
			Player[] onlinePlayers;
			for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
				final Player plr = onlinePlayers[i];
				t.showPlayer(plr);
				p.showPlayer(plr);
			}
		}
	}

	@EventHandler
	public void cmd(final PlayerCommandPreprocessEvent event) {
		final Player p = event.getPlayer();
		if (API.getWarp(p) == "1v1" && !Events1v1.Jogando1v1Player.contains(p)
				&& !event.getMessage().startsWith("/spawn") && !event.getMessage().startsWith("/score")
				&& !cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")
				&& !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Mod+")
				&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")
				&& !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Helper")) {
			event.getPlayer()
					.sendMessage("�cVoc\u00ea não pode utilizar comandos na �6�l1V1�f. Use �3�l/SPAWN�f!");
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void cmda(final PlayerCommandPreprocessEvent event) {
		final Player p = event.getPlayer();
		if (Events1v1.Jogando1v1Player.contains(p) && API.getWarp(p) == "1v1"
				&& !event.getMessage().startsWith("/score") && !cfGrupo.ChecarGrupo(p, "Dono")
				&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")
				&& !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod")
				&& !cfGrupo.ChecarGrupo(p, "Trial")) {
			event.getPlayer()
					.sendMessage("�cVoc\u00ea est\u00e1 impossibilitado de utilizar comandos durante o duelo!");
			event.setCancelled(true);
		}
	}

	public int itemsInInventory(final Inventory inventory, final Material[] search) {
		final List<Material> wanted = Arrays.asList(search);
		int found = 0;
		ItemStack[] arrayOfItemStack;
		for (int j = (arrayOfItemStack = inventory.getContents()).length, i = 0; i < j; ++i) {
			final ItemStack item = arrayOfItemStack[i];
			if (item != null && wanted.contains(item.getType())) {
				found += item.getAmount();
			}
		}
		return found;
	}

	@EventHandler
	public void PlayerInteractEntityEvent2(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player pl = onlinePlayers[i];
			if (Events1v1.Jogando1v1Player.contains(pl)) {
				pl.hidePlayer(p);
			}
		}
	}
}
