package me.cangasso.habilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.cangasso.API.CooldownAPI;
import me.cangasso.API.KitAPI;
import me.cangasso.configuração.cfGrupo;
import me.cangasso.main.CookiePvP;

public class Gladiator implements Listener {
	public boolean generateGlass;
	public static ArrayList<Player> noExecut;
	public static HashMap<String, Location> oldl;
	public static HashMap<String, String> fighting;
	public HashMap<Integer, ArrayList<Location>> blocks;
	public static HashMap<Player, Location> localizacao;
	public static HashMap<Location, Block> bloco;
	public HashMap<Integer, String[]> players;
	public HashMap<String, Integer> tasks;
	int nextID;
	public static int id1;
	public static int id2;

	static {
		Gladiator.noExecut = new ArrayList<Player>();
		Gladiator.oldl = new HashMap<String, Location>();
		Gladiator.fighting = new HashMap<String, String>();
		Gladiator.localizacao = new HashMap<Player, Location>();
		Gladiator.bloco = new HashMap<Location, Block>();
	}

	public Gladiator() {
		this.generateGlass = true;
		this.blocks = new HashMap<Integer, ArrayList<Location>>();
		this.players = new HashMap<Integer, String[]>();
		this.tasks = new HashMap<String, Integer>();
		this.nextID = 0;
	}

	@EventHandler
	public void OnGladiat0orKit(final PlayerInteractEntityEvent event) {
		final Player p = event.getPlayer();
		if (event.getRightClicked() instanceof Player) {
			final Player r = (Player) event.getRightClicked();
			if (p.getItemInHand().getType() == Material.IRON_FENCE && KitAPI.getKit(p) == "Gladiator"
					&& CooldownAPI.Cooldown.containsKey(p.getName())) {
				p.sendMessage("�fO seu �3�lCOOLDOWN �facaba em: �c�l" + CooldownAPI.Cooldown(p) + "s");
				return;
			}
			if (p.getItemInHand().getType() == Material.IRON_FENCE && KitAPI.getKit(p) == "Gladiator"
					&& !CooldownAPI.Cooldown.containsKey(p.getName())) {
				event.setCancelled(true);
				final Location loc = new Location(p.getWorld(), (double) p.getLocation().getBlockX(),
						(double) (p.getLocation().getBlockY() + 70), (double) p.getLocation().getBlockZ());
				Gladiator.localizacao.put(p, loc);
				Gladiator.localizacao.put(r, loc);
				final Location loc2 = new Location(p.getWorld(), (double) (p.getLocation().getBlockX() + 8),
						(double) (p.getLocation().getBlockY() + 73), (double) (p.getLocation().getBlockZ() + 8));
				final Location loc3 = new Location(p.getWorld(), (double) (p.getLocation().getBlockX() - 8),
						(double) (p.getLocation().getBlockY() + 73), (double) (p.getLocation().getBlockZ() - 8));
				if (Gladiator.fighting.containsKey(p.getName()) || Gladiator.fighting.containsKey(r.getName())) {
					event.setCancelled(true);
					return;
				}
				final Integer currentID = this.nextID;
				++this.nextID;
				final ArrayList<String> list = new ArrayList<String>();
				list.add(p.getName());
				list.add(r.getName());
				this.players.put(currentID, list.toArray(new String[1]));
				Gladiator.oldl.put(p.getName(), p.getLocation());
				Gladiator.oldl.put(r.getName(), r.getLocation());
				if (this.generateGlass) {
					final List<Location> cuboid = new ArrayList<Location>();
					cuboid.clear();
					for (int bX = -10; bX <= 10; ++bX) {
						for (int bZ = -10; bZ <= 10; ++bZ) {
							for (int bY = -1; bY <= 10; ++bY) {
								final Block b = loc.clone().add((double) bX, (double) bY, (double) bZ).getBlock();
								if (!b.isEmpty()) {
									event.setCancelled(true);
									p.sendMessage("�cVoc\u00ea não pode puxar para o Gladiator neste local!");
									return;
								}
								if (bY == 10) {
									cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
								} else if (bY == -1) {
									cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
								} else if (bX == -10 || bZ == -10 || bX == 10 || bZ == 10) {
									cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
								}
							}
						}
					}
					for (final Location loc4 : cuboid) {
						loc4.getBlock().setType(Material.GLASS);
						Gladiator.bloco.put(loc4, loc4.getBlock());
					}
					loc2.setYaw(135.0f);
					p.teleport(loc2);
					loc3.setYaw(-45.0f);
					r.teleport(loc3);
					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
					r.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
					p.getInventory().remove(Material.IRON_FENCE);
					r.getInventory().remove(Material.IRON_FENCE);
					p.sendMessage(
							"�fVoc\u00ea puxou um jogador para um duelo, portanto o item de seu kit foi �c�lREMOVIDO�f!");
					p.sendMessage(
							"�fAssim que o duelo for �e�lFINALIZADO�f, o item voltar\u00e1 para o seu invent\u00e1rio!");
					CooldownAPI.addCooldown(p, 35);
					Gladiator.noExecut.add(p);
					Gladiator.noExecut.add(r);
					Gladiator.fighting.put(p.getName(), r.getName());
					Gladiator.fighting.put(r.getName(), p.getName());
					Gladiator.id2 = Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(),
							(Runnable) new Runnable() {
								@Override
								public void run() {
									if (Gladiator.fighting.containsKey(p.getName())
											&& Gladiator.fighting.get(p.getName()).equalsIgnoreCase(r.getName())
											&& Gladiator.fighting.containsKey(r.getName())) {
										Gladiator.fighting.get(r.getName()).equalsIgnoreCase(p.getName());
									}
								}
							}, 2400L);
					Gladiator.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(),
							(Runnable) new Runnable() {
								@Override
								public void run() {
									if (Gladiator.fighting.containsKey(p.getName())
											&& Gladiator.fighting.get(p.getName()).equalsIgnoreCase(r.getName())
											&& Gladiator.fighting.containsKey(r.getName())
											&& Gladiator.fighting.get(r.getName()).equalsIgnoreCase(p.getName())) {
										Gladiator.fighting.remove(p.getName());
										Gladiator.fighting.remove(r.getName());
										Gladiator.noExecut.remove(p);
										Gladiator.noExecut.remove(r);
										p.teleport((Location) Gladiator.oldl.get(p.getName()));
										r.teleport((Location) Gladiator.oldl.get(r.getName()));
										Gladiator.oldl.remove(p.getName());
										Gladiator.oldl.remove(r.getName());
										final Location loc = Gladiator.localizacao.get(p);
										final List<Location> cuboid = new ArrayList<Location>();
										for (int bX = -10; bX <= 10; ++bX) {
											for (int bZ = -10; bZ <= 10; ++bZ) {
												for (int bY = -1; bY <= 10; ++bY) {
													if (bY == 10) {
														cuboid.add(
																loc.clone().add((double) bX, (double) bY, (double) bZ));
													} else if (bY == -1) {
														cuboid.add(
																loc.clone().add((double) bX, (double) bY, (double) bZ));
													} else if (bX == -10 || bZ == -10 || bX == 10 || bZ == 10) {
														cuboid.add(
																loc.clone().add((double) bX, (double) bY, (double) bZ));
													}
												}
											}
										}
										for (final Location loc2 : cuboid) {
											loc2.getBlock().setType(Material.AIR);
											Gladiator.bloco.get(loc2).setType(Material.AIR);
										}
									}
								}
							}, 100000L);
				}
			}
		}
	}

	@EventHandler
	public void onPlayerInteractGlad(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.IRON_FENCE || KitAPI.getKit(p) == "Gladiator") {
			e.setCancelled(true);
			p.updateInventory();
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlyaerInteract(final PlayerInteractEvent e) {
		if (e.getAction() == Action.LEFT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.GLASS
				&& e.getPlayer().getGameMode() != GameMode.CREATIVE
				&& Gladiator.fighting.containsKey(e.getPlayer().getName())) {
			e.setCancelled(true);
			e.getClickedBlock().setType(Material.GLASS);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					if (Gladiator.fighting.containsKey(e.getPlayer().getName())) {
						e.getClickedBlock().setType(Material.GLASS);
					}
				}
			}, 30L);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLeft(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (Gladiator.fighting.containsKey(p.getName())) {
			final Player t = Bukkit.getServer().getPlayer((String) Gladiator.fighting.get(p.getName()));
			Gladiator.fighting.remove(t.getName());
			Gladiator.fighting.remove(p.getName());
			Gladiator.noExecut.remove(p);
			Gladiator.noExecut.remove(t);
			final ItemStack Item = new ItemStack(Material.IRON_FENCE);
			final ItemMeta kItem = Item.getItemMeta();
			kItem.setDisplayName("�7\u27b3 �a�lGladiator" + KitAPI.getKit(p));
			Item.setItemMeta(kItem);
			Gladiator.fighting.remove(t.getName());
			Gladiator.fighting.remove(p.getName());
			Gladiator.noExecut.remove(p);
			Gladiator.noExecut.remove(t);
			if (KitAPI.getKit(p) == "Gladiator") {
				p.getInventory().setItem(1, Item);
			}
			if (KitAPI.getKit(t) == "Gladiator") {
				t.getInventory().setItem(1, Item);
			}
			final Location old = Gladiator.oldl.get(t.getName());
			t.teleport(old);
			Bukkit.getScheduler().cancelTask(Gladiator.id1);
			Bukkit.getScheduler().cancelTask(Gladiator.id2);
			t.removePotionEffect(PotionEffectType.WITHER);
			final Location loc = Gladiator.localizacao.get(p);
			final List<Location> cuboid = new ArrayList<Location>();
			for (int bX = -10; bX <= 10; ++bX) {
				for (int bZ = -10; bZ <= 10; ++bZ) {
					for (int bY = -1; bY <= 10; ++bY) {
						if (bY == 10) {
							cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
						} else if (bY == -1) {
							cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
						} else if (bX == -10 || bZ == -10 || bX == 10 || bZ == 10) {
							cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
						}
					}
				}
			}
			for (final Location loc2 : cuboid) {
				loc2.getBlock().setType(Material.AIR);
				Gladiator.bloco.get(loc2).setType(Material.AIR);
			}
			for (final Location loc2 : cuboid) {
				loc2.getBlock().setType(Material.AIR);
				Gladiator.bloco.get(loc2).setType(Material.AIR);
			}
			for (final Location loc2 : cuboid) {
				loc2.getBlock().setType(Material.AIR);
				Gladiator.bloco.get(loc2).setType(Material.AIR);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDeathGladiator(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		if (Gladiator.fighting.containsKey(p.getName())) {
			final Player k = Bukkit.getServer().getPlayer((String) Gladiator.fighting.get(p.getName()));
			final Location old = Gladiator.oldl.get(p.getName());
			k.teleport(old);
			Bukkit.getScheduler().cancelTask(Gladiator.id1);
			Bukkit.getScheduler().cancelTask(Gladiator.id2);
			k.removePotionEffect(PotionEffectType.WITHER);
			k.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
			final ItemStack Item = new ItemStack(Material.IRON_FENCE);
			final ItemMeta kItem = Item.getItemMeta();
			kItem.setDisplayName("�7\u27b3 �a�lGladiator" + KitAPI.getKit(p));
			Item.setItemMeta(kItem);
			Gladiator.fighting.remove(k.getName());
			Gladiator.fighting.remove(p.getName());
			Gladiator.noExecut.remove(p);
			Gladiator.noExecut.remove(k);
			if (KitAPI.getKit(p) == "Gladiator") {
				p.getInventory().setItem(1, Item);
			}
			if (KitAPI.getKit(k) == "Gladiator") {
				k.getInventory().setItem(1, Item);
			}
			final Location loc = Gladiator.localizacao.get(p);
			final List<Location> cuboid = new ArrayList<Location>();
			cuboid.clear();
			for (int bX = -10; bX <= 10; ++bX) {
				for (int bZ = -10; bZ <= 10; ++bZ) {
					for (int bY = -1; bY <= 10; ++bY) {
						if (bY == 10) {
							cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
						} else if (bY == -1) {
							cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
						} else if (bX == -10 || bZ == -10 || bX == 10 || bZ == 10) {
							cuboid.add(loc.clone().add((double) bX, (double) bY, (double) bZ));
						}
					}
				}
			}
			for (final Location loc2 : cuboid) {
				loc2.getBlock().setType(Material.AIR);
				if (Gladiator.bloco.containsKey(loc2)) {
					Gladiator.bloco.get(loc2).setType(Material.AIR);
				}
			}
		}
	}

	@EventHandler
	public void processocommand(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (Gladiator.noExecut.contains(p) && !e.getMessage().toLowerCase().startsWith("/report")
				&& (!cfGrupo.ChecarGrupo(p, "Dono") || !cfGrupo.ChecarGrupo(p, "Gerente")
						|| !cfGrupo.ChecarGrupo(p, "Admin"))) {
			e.setCancelled(true);
			p.sendMessage("�cVoc\u00ea não pode executar comandos no Gladiator!");
		}
	}
}
