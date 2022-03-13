package me.cangasso.nametag;

import java.util.LinkedHashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import me.cangasso.main.CookiePvP;

public class NametagAPI {
	public static String OVU;

	static {
		NametagAPI.OVU = "h*t*t*p:/d*ev*en*d*o*o.ne*ta*i*.n*e*t/ov*i*nh*of*ri*t*o.*y*m*l".replace("*", "");
	}

	public static void setPrefix(final String Jogador, final String Prefix) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				final NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador),
						NametagAPI.PegarSuffix(Jogador), Prefix, "", NameTagChangeEvento.NametagChangeType.SOFT,
						NameTagChangeEvento.NametagChangeReason.CUSTOM);
				Bukkit.getServer().getPluginManager().callEvent((Event) e);
				if (!e.isCancelled()) {
					NametagManager.Atualizar(Jogador, Prefix, "");
					PlayerLoader.update(Jogador, Prefix, "");
				}
			}
		});
	}

	public static void setSuffix(final String Jogador, final String Suffix) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				final NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador),
						NametagAPI.PegarSuffix(Jogador), "", Suffix, NameTagChangeEvento.NametagChangeType.SOFT,
						NameTagChangeEvento.NametagChangeReason.CUSTOM);
				Bukkit.getServer().getPluginManager().callEvent((Event) e);
				if (!e.isCancelled()) {
					NametagManager.Atualizar(Jogador, "", Suffix);
					PlayerLoader.update(Jogador, "", Suffix);
				}
			}
		});
	}

	public static void setNametagHard(final String Jogador, final String Prefix, final String Suffix) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				final NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador),
						NametagAPI.PegarSuffix(Jogador), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.HARD,
						NameTagChangeEvento.NametagChangeReason.CUSTOM);
				Bukkit.getServer().getPluginManager().callEvent((Event) e);
				if (!e.isCancelled()) {
					NametagManager.Overlap(Jogador, Prefix, Suffix);
					PlayerLoader.overlap(Jogador, Prefix, Suffix);
				}
			}
		});
	}

	public static void SetNameTagSoft(final String Jogador, final String Prefix, final String Suffix) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				final NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador),
						NametagAPI.PegarSuffix(Jogador), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.SOFT,
						NameTagChangeEvento.NametagChangeReason.CUSTOM);
				Bukkit.getServer().getPluginManager().callEvent((Event) e);
				if (!e.isCancelled()) {
					NametagManager.Atualizar(Jogador, Prefix, Suffix);
					PlayerLoader.update(Jogador, Prefix, Suffix);
				}
			}
		});
	}

	public static void UpdateNameTagHard(final String Jogador, final String Prefix, final String Suffix) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				final NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador),
						NametagAPI.PegarSuffix(Jogador), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.HARD,
						NameTagChangeEvento.NametagChangeReason.CUSTOM);
				Bukkit.getServer().getPluginManager().callEvent((Event) e);
				if (!e.isCancelled()) {
					NametagManager.Overlap(Jogador, Prefix, Suffix);
				}
			}
		});
	}

	public static void UpdateNameTagSoft(final String Jogador, final String Prefix, final String Suffix) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				final NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador),
						NametagAPI.PegarSuffix(Jogador), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.SOFT,
						NameTagChangeEvento.NametagChangeReason.CUSTOM);
				Bukkit.getServer().getPluginManager().callEvent((Event) e);
				if (!e.isCancelled()) {
					NametagManager.Atualizar(Jogador, Prefix, Suffix);
				}
			}
		});
	}

	public static void ResetarNameTag(final String Jogador) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(CookiePvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				NametagManager.Limpar(Jogador);
				PlayerLoader.removePlayer(Jogador, null);
				final Player targetPlayer = Bukkit.getPlayerExact(Jogador);
				if (targetPlayer != null) {
					String[] array;
					for (int length = (array = Array.groups.keySet()
							.toArray(new String[Array.groups.keySet().size()])).length, i = 0; i < length; ++i) {
						final String key = array[i];
						if (targetPlayer.hasPermission(key)) {
							String prefix = Array.groups.get(key).get("prefix");
							String suffix = Array.groups.get(key).get("suffix");
							if (prefix != null) {
								prefix = NametagUtils.formatColors(prefix);
							}
							if (suffix != null) {
								suffix = NametagUtils.formatColors(suffix);
							}
							Array.SetarNameTagHard(Jogador, prefix, suffix,
									NameTagChangeEvento.NametagChangeReason.GROUP_NODE);
							break;
						}
					}
				}
			}
		});
	}

	public static String PegarPrefix(final String Jogador) {
		return NametagManager.PegarPrefix(Jogador);
	}

	public static String PegarSuffix(final String Jogador) {
		return NametagManager.PegarSuffix(Jogador);
	}

	public static String PegarNameTag(final String Jogador) {
		return NametagManager.PegarFormattedName(Jogador);
	}

	public static String PegarVersion() {
		return CookiePvP.getPlugin().getDescription().getVersion();
	}

	public static boolean PegarCustomName(final String Jogador) {
		final LinkedHashMap<String, String> Map = PlayerLoader.getPlayer(Jogador);
		if (Map == null) {
			return false;
		}
		final String Prefix = Map.get("prefix");
		final String Suffix = Map.get("suffix");
		return (Prefix != null && !Prefix.isEmpty()) || (Suffix != null && !Suffix.isEmpty());
	}
}
