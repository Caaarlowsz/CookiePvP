package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.cangasso.bans.API;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;

public class PvPCommand implements CommandExecutor, Listener {
	public static boolean pvp;

	static {
		PvPCommand.pvp = false;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("pvp")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente")
					&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+")) {
				API.sendMsg((CommandSender) p,
						"§cVoc\u00ea n\u00e3o possui permiss\u00e3o para utilizar este comando.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§fUtilize §a§l/pvp §a(on | off)");
				return true;
			}
			if (args.length == 1 && args[0].equalsIgnoreCase("on")) {
				if (PvPCommand.pvp) {
					p.sendMessage("§fO §6§lPVP §fj\u00e1 est\u00e1 ativado!");
					return true;
				}
				PvPCommand.pvp = true;
				p.sendMessage("§fVoc\u00ea §a§lATIVOU §fo pvp!");
				Bukkit.broadcastMessage("§7O §6§lPVP §7foi §a§lATIVADO §7por: §6§l" + p.getName() + "§7.");
				return true;
			} else if (args[0].equalsIgnoreCase("off")) {
				if (!PvPCommand.pvp) {
					p.sendMessage("§fO §a§lPVP §fj\u00e1 est\u00e1 desativado!");
					return true;
				}
				PvPCommand.pvp = false;
				p.sendMessage("§fVoc\u00ea §c§lDESATIVOU §fo pvp!");
				Bukkit.broadcastMessage("§7O §6§lPVP §7foi §c§lDESATIVADO §7por: §6§l" + p.getName() + "§7.");
				return true;
			}
		}
		return false;
	}

	@EventHandler
	public void onDamage(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player && !PvPCommand.pvp) {
			e.setCancelled(true);
		}
	}
}
