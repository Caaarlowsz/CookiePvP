package me.cangasso.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.cangasso.configura\u00e7\u00e3o.cfGrupo;

public class CageCommand implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("cage")) {
			if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente")
					&& !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+")
					&& !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")
					&& !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Helper")) {
				p.sendMessage("§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar esse comando!");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(
						"§7Use: §6§l/cage <nickname> §7para prender um jogador. Lembre-se: \u00c9 necess\u00e1rio que voc\u00ea seja no m\u00ednimo §3§lYOUTUBER+ §7ou §5§lMOD+ §7para executar este comando por espont\u00e2nea vontade ou poder\u00e1 sofrer consequ\u00eancias graves!");
				return true;
			}
			if (args.length == 1) {
				final Player t = Bukkit.getPlayer(args[0]);
				if (t == null) {
					p.sendMessage("Jogador offline!");
					return true;
				}
				if (t.getName() == p.getName()) {
					p.sendMessage("§cVoc\u00ea n\u00e3o pode prender a si mesmo!");
					return true;
				}
				t.getLocation().add(0.0, 13.0, 0.0).getBlock().setType(Material.BEDROCK);
				t.getLocation().add(0.0, 11.0, 1.0).getBlock().setType(Material.BEDROCK);
				t.getLocation().add(1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
				t.getLocation().add(0.0, 11.0, -1.0).getBlock().setType(Material.BEDROCK);
				t.getLocation().add(-1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
				t.getLocation().add(0.0, 10.0, 0.0).getBlock().setType(Material.BEDROCK);
				t.teleport(t.getLocation().add(0.0, 11.0, -0.05));
				p.teleport(t.getLocation().add(3.0, 0.0, 0.05));
				p.sendMessage("§fVoc\u00ea prendeu o jogador: §a§l" + t.getName());
				return true;
			}
		}
		return false;
	}
}
