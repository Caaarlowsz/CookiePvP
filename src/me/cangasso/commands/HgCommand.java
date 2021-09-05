package me.cangasso.commands;

import me.cangasso.bans.API;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class HgCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if ((cmd.getName().equalsIgnoreCase("hg") || cmd.getName().equalsIgnoreCase("hungergames")) && args.length == 0) {
            API.sendMsg((CommandSender)p, "§cNenhum servidor de HardcoreGames foi encontrado!");
        }
        return false;
    }
}
