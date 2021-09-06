package me.cangasso.events;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Horse;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.cangasso.API.API;
import me.cangasso.API.ArraysAPI;
import me.cangasso.API.KitAPI;
import me.cangasso.API.WarpsAPI;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import me.cangasso.invencivel.Prote\u00e7\u00e3o;
import me.cangasso.main.Main;
import me.cangasso.scoreboard.sScoreAPI;

public class eUtills implements Listener {
	public static HashMap<String, Long> CooldownChat;

	static {
		eUtills.CooldownChat = new HashMap<String, Long>();
	}

	public static void addCooldown(final Player p, final int Tempo) {
		eUtills.CooldownChat.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(Tempo));
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				eUtills.CooldownChat.remove(p.getName());
			}
		}, (long) (Tempo * 20));
	}

	public static long Cooldown(final Player p) {
		final long tempo = TimeUnit.MILLISECONDS
				.toSeconds(eUtills.CooldownChat.get(p.getName()) - System.currentTimeMillis());
		if (eUtills.CooldownChat.containsKey(p.getName())
				|| eUtills.CooldownChat.get(p.getName()) > System.currentTimeMillis()) {
			return tempo;
		}
		return 0L;
	}

	@EventHandler
	public void dropar(final PlayerDropItemEvent e) {
		if (e.getItemDrop().getItemStack().getType() != Material.MUSHROOM_SOUP
				&& e.getItemDrop().getItemStack().getType() != Material.BOWL
				&& e.getItemDrop().getItemStack().getType() != Material.ENDER_PEARL
				&& e.getItemDrop().getItemStack().getType() != Material.RED_MUSHROOM
				&& e.getItemDrop().getItemStack().getType() != Material.BROWN_MUSHROOM
				&& e.getItemDrop().getItemStack().getType() != Material.GLASS_BOTTLE) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void chat(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		e.setFormat("§7(" + sScoreAPI.getRank(p) + "§7) " + p.getDisplayName() + "§7: §f"
				+ e.getMessage().replace("%", "Porcento(s)"));
		if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin")
				|| cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Trial")
				|| cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Youtuber")
				|| cfGrupo.ChecarGrupo(p, "S-Pro") || cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp")) {
			e.setFormat(e.getFormat().replace("&", "§"));
		}
	}

	@EventHandler
	public void onCommand(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (e.getMessage().contains(":") && !cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Mod+")
				&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Gerente")
				&& !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Helper")
				&& !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Admin")) {
			e.setCancelled(true);
			p.sendMessage("§cVoc\u00ea n\u00e3o pode utilizar comandos que possuam §c§l: §c(dois pontos)");
		}
	}

	@EventHandler
	public void onCreeperSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Creeper) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSkeletonSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Skeleton) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSpiderSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Spider) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onWitherSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Wither) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onZombieSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Zombie) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSlimeSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Slime) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onGhastSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Ghast) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPigZombieSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof PigZombie) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onEndermanSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Enderman) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onCaveSpiderSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof CaveSpider) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSilverfishSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Silverfish) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onBlazeSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Blaze) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onMagmaCubeSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof MagmaCube) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onWitchSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Witch) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSheepSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Sheep) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onCowSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Cow) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onChickenSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Chicken) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSquidSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Squid) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onMooshroomSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof MushroomCow) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onOcelotSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Ocelot) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onVillagerSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Villager) {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onHorseSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Horse) {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onEnderDragonSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof EnderDragon) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void aoFoguihnu(final BlockSpreadEvent e) {
		if (e.getNewState().getType() == Material.FIRE) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void aoChatCooldown(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (ArraysAPI.CooldownChat.contains(p)) {
			if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin")
					|| cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod")
					|| cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Youtuber+")
					|| cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Youtuber")) {
				return;
			}
			if (!cfGrupo.ChecarGrupo(p, "Dono") || !cfGrupo.ChecarGrupo(p, "Gerente")
					|| !cfGrupo.ChecarGrupo(p, "Admin") || !cfGrupo.ChecarGrupo(p, "Mod+")
					|| !cfGrupo.ChecarGrupo(p, "Mod") || !cfGrupo.ChecarGrupo(p, "Trial")
					|| !cfGrupo.ChecarGrupo(p, "Youtuber+") || !cfGrupo.ChecarGrupo(p, "Helper")
					|| !cfGrupo.ChecarGrupo(p, "Youtuber")) {
				p.sendMessage("§cAguarde para enviar outra mensagem ao chat!");
				e.setCancelled(true);
				return;
			}
		}
		if (!ArraysAPI.CooldownChat.contains(p)) {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void aoVoid1v1(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (API.getWarp(p) == "1v1" && p.getLocation().getY() == 0.0) {
			e.setCancelled(true);
			KitAPI.removeKits(p);
			WarpsAPI.Ir(p, "1v1");
			API.setWarp(p, "1v1");
			KitAPI.setKit(p, "1v1");
			Prote\u00e7\u00e3o.setImortal(p, true);
			p.getInventory().clear();
			p.getInventory().setArmorContents((ItemStack[]) null);
			final ItemStack Espada = new ItemStack(Material.BLAZE_ROD);
			final ItemMeta kEspada = Espada.getItemMeta();
			kEspada.setDisplayName("§6§l1V1");
			Espada.setItemMeta(kEspada);
			final ItemStack Espada2 = new ItemStack(Material.INK_SACK, 1, (short) 8);
			final ItemMeta kEspada2 = Espada2.getItemMeta();
			kEspada2.setDisplayName("§eDuelo r\u00e1pido §8(Bot\u00e3o direito)");
			Espada2.setItemMeta(kEspada2);
			p.getInventory().setItem(3, Espada);
			p.getInventory().setItem(5, Espada2);
		}
	}

	@EventHandler
	public void aoVoid(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player && e.getCause().equals((Object) EntityDamageEvent.DamageCause.VOID)) {
			final Player p = (Player) e.getEntity();
			e.setCancelled(true);
			WarpsAPI.Ir(p, "Spawn");
			API.setWarp(p, "Spawn");
			p.sendMessage("§8§l<§e§l!§8§l> §7Voc\u00ea foi morto pelo §c§lVOID§7.");
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.spigot().respawn();
				}
			}, 1L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					API.sendItems(p);
				}
			}, 2L);
		}
	}

	@EventHandler
	public void motd(final ServerListPingEvent e) {
		e.setMotd(
				"§6§lCookie§f§lNetwork §7» §a§lATUALIZADO! §f- §fServidor de §6§lKitPvP \n§6\u27a2 §fVenha conferir nossas §a§lNOVIDADES§f!");
	}

	@EventHandler
	public void onSoup(final PlayerInteractEvent e) {
		final Damageable hp;
		final Player p = (Player) (hp = (Damageable) e.getPlayer());
		if (hp.getHealth() != 20.0) {
			final int sopa = 7;
			if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
					&& p.getItemInHand().getTypeId() == 282) {
				p.setHealth((hp.getHealth() + sopa > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + sopa));
				p.getItemInHand().setType(Material.BOWL);
			}
		}
	}

	@EventHandler
	public void quebrarArmor(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (p.getInventory().getChestplate() != null) {
				p.getInventory().getChestplate().setDurability((short) 0);
			}
			if (p.getInventory().getBoots() != null) {
				p.getInventory().getBoots().setDurability((short) 0);
			}
			if (p.getInventory().getLeggings() != null) {
				p.getInventory().getLeggings().setDurability((short) 0);
			}
			if (p.getInventory().getHelmet() != null) {
				p.getInventory().getHelmet().setDurability((short) 0);
			}
		}
	}

	@EventHandler
	public void fome(final FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void achivments(final PlayerAchievementAwardedEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void entityDamagePedra(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && ((Player) e.getDamager()) instanceof Player) {
			final Player p = (Player) e.getDamager();
			if (e.getEntity() instanceof Player && p.getItemInHand().getType() == Material.STONE_SWORD) {
				e.setDamage(e.getDamage() * 0.6);
				return;
			}
			if (p.getItemInHand().getType() == Material.WOOD_SWORD) {
				e.setDamage(e.getDamage() * 0.5);
				return;
			}
			if (p.getItemInHand().getType() == Material.DIAMOND_SWORD) {
				e.setDamage(e.getDamage() * 0.7);
			}
		}
	}

	@EventHandler
	public void onEntityDamageByEntity(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			final Player d = (Player) e.getDamager();
			if (d.getItemInHand().getType() == Material.DIAMOND_SWORD
					|| d.getItemInHand().getType() == Material.STONE_SWORD
					|| d.getItemInHand().getType() == Material.WOOD_SWORD
					|| d.getItemInHand().getType() == Material.STONE_SWORD
					|| d.getItemInHand().getType() == Material.IRON_SWORD
					|| d.getItemInHand().getType() == Material.GOLD_SWORD
					|| d.getItemInHand().getType() == Material.FISHING_ROD
					|| d.getItemInHand().getType() == Material.DIAMOND_AXE
					|| d.getItemInHand().getType() == Material.GOLD_AXE
					|| d.getItemInHand().getType() == Material.STONE_AXE
					|| d.getItemInHand().getType() == Material.WOOD_AXE
					|| d.getItemInHand().getType() == Material.IRON_AXE) {
				d.getItemInHand().setDurability((short) 0);
				d.updateInventory();
			}
		}
	}

	@EventHandler
	public void noBreaking(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.FISHING_ROD
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			p.getItemInHand().setDurability((short) 0);
			p.updateInventory();
		}
	}

	@EventHandler
	public void noMe(final PlayerCommandPreprocessEvent e) {
		if (e.getMessage().toLowerCase().startsWith("/me") || e.getMessage().toLowerCase().startsWith("/bukkit:me")) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void noInfos(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (e.getMessage().toLowerCase().startsWith("/pl") || e.getMessage().toLowerCase().startsWith("/plugins")
				|| e.getMessage().toLowerCase().startsWith("/bukkit:pl")
				|| e.getMessage().toLowerCase().startsWith("/bukkit:plugins")
				|| e.getMessage().toLowerCase().startsWith("/about") || e.getMessage().toLowerCase().startsWith("/ver")
				|| e.getMessage().toLowerCase().startsWith("/bukkit:about")
				|| e.getMessage().toLowerCase().startsWith("/bukkit:ver")
				|| e.getMessage().toLowerCase().startsWith("/help") || e.getMessage().toLowerCase().startsWith("/?")
				|| e.getMessage().toLowerCase().startsWith("/bukkit:?")
				|| e.getMessage().toLowerCase().startsWith("/bukkit:help")) {
			p.sendMessage(
					"§7Plugin de §6§lKITPVP§7. Vers\u00e3o: §3§l3.0§f - §7Para o §6§lCookie§f§lNetwork §f- §4§lBY: §7MoradorDeRua & Cangasso ");
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void clicarBussola(final PlayerInteractEvent e) {
		boolean parar = false;
		if (e.getPlayer().getItemInHand().getType() == Material.COMPASS) {
			for (final Entity entidades : e.getPlayer().getNearbyEntities(100.0, 150.0, 100.0)) {
				if (entidades instanceof Player
						&& e.getPlayer().getLocation().distance(entidades.getLocation()) >= 9.0) {
					if (entidades.getLocation().getY() > 170.0) {
						return;
					}
					parar = true;
					e.getPlayer().setCompassTarget(entidades.getLocation());
					e.getPlayer().sendMessage("§7B\u00fassula apontando para §6" + ((Player) entidades).getName());
					return;
				}
			}
			if (!parar) {
				e.getPlayer().sendMessage("§7Nenhum jogador encontrado!");
				e.getPlayer().setCompassTarget(new Location(e.getPlayer().getWorld(), 0.0, 100.0, 0.0));
			}
		}
	}

	@EventHandler
	public void dropar(final ItemSpawnEvent e) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				e.getEntity().remove();
			}
		}, 80L);
	}

	@EventHandler
	public void pegaritem(final PlayerPickupItemEvent e) {
		final Player p = e.getPlayer();
		if (ArraysAPI.Admin.contains(p)) {
			e.setCancelled(true);
		} else if (KitAPI.getKit(p) == "1v1") {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onGameSignPlacement(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player && e.getCause().equals((Object) EntityDamageEvent.DamageCause.VOID)) {
			final Player p = (Player) e.getEntity();
			p.setHealth(0.5);
		}
	}

	@EventHandler
	public void combatlog(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Snowball) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		if (e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING && e.getEntity() instanceof Player) {
			return;
		}
		final Player bateu = (Player) e.getDamager();
		final Player hitado = (Player) e.getEntity();
		final int numero = 20;
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			if (API.getWarp(hitado) != "Arena") {
				return;
			}
			if (API.getWarp(hitado) == "Arena") {
				API.inCombat.add(bateu);
				API.inCombat.add(hitado);
				API.mandarActionBar(bateu,
						String.valueOf(hitado.getDisplayName()) + " §f- §eKit: §7" + KitAPI.getKit(hitado));
				API.BarAPI(bateu, String.valueOf(hitado.getDisplayName()) + " §f- §eKit: §7" + KitAPI.getKit(hitado));
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						API.inCombat.remove(bateu);
						API.inCombat.remove(hitado);
					}
				}, (long) (numero * 8));
			}
		}
	}

	@EventHandler
	public void weather(final WeatherChangeEvent e) {
		if (e.toWeatherState()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void setarSlots(final ServerListPingEvent e) {
		e.setMaxPlayers(Bukkit.getOnlinePlayers().length + 1);
	}

	@EventHandler
	public void aoDropar(final ItemSpawnEvent e) {
		e.setCancelled(true);
	}
}
