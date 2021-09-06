package me.cangasso.API;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import me.cangasso.configura\u00e7\u00e3o.WarpsConfig;

public class WarpsAPI implements Listener {
	public static ArrayList<String> segundos;

	static {
		WarpsAPI.segundos = new ArrayList<String>();
	}

	@EventHandler
	public void andou(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (WarpsAPI.segundos.contains(p.getName())) {
			WarpsAPI.segundos.remove(p.getName());
			p.sendMessage("§cVoc\u00ea n\u00e3o deve se mover! Teleporte §c§lCANCELADO§c!");
			p.removePotionEffect(PotionEffectType.SLOW);
			p.removePotionEffect(PotionEffectType.BLINDNESS);
		}
	}

	public static void Set(final Player p, final String Warp) {
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".X", (Object) p.getLocation().getX());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".Y", (Object) p.getLocation().getY());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".Z", (Object) p.getLocation().getZ());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".Pitch", (Object) p.getLocation().getPitch());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".Yaw", (Object) p.getLocation().getYaw());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".World", (Object) p.getLocation().getWorld().getName());
		WarpsConfig.getConfig().saveConfigs();
	}

	public static void Ir(final Player p, final String Warp) {
		if (WarpsConfig.getConfig().config().contains("Warps." + Warp)) {
			final double x = WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".X");
			final double y = WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".Y");
			final double z = WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".Z");
			final float Pitch = (float) WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".Pitch");
			final float Yaw = (float) WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".Yaw");
			final World world = Bukkit.getWorld(WarpsConfig.getConfig().config().getString("Warps." + Warp + ".World"));
			final Location loc = new Location(world, x, y, z, Yaw, Pitch);
			p.teleport(loc);
		} else {
			p.sendMessage("§6§lCookie§f§lNetwork §7» §fEssa §6§lWARP §fainda n\u00e3o foi setada!");
		}
	}
}
