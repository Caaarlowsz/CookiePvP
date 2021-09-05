package me.cangasso.commands;

import me.cangasso.API.KitAPI;
import org.bukkit.inventory.ItemStack;
import me.cangasso.API.ArraysAPI;
import org.bukkit.Bukkit;
import me.cangasso.bans.API;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class ClearAllCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin")) {
            API.sendMsg((CommandSender)p, "§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("clearall")) {
            API.sendMsg((CommandSender)p, "§aVoc\u00ea limpou o invent\u00e1rio de todos os jogadores!");
            me.cangasso.API.API.sendWarn("§a§l" + p.getName() + " §7acabou de limpar todos os invent\u00e1rios.");
            Player[] onlinePlayers;
            for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                final Player todos = onlinePlayers[i];
                if (todos != p && !ArraysAPI.Admin.contains(todos)) {
                    todos.getInventory().clear();
                    todos.getInventory().setArmorContents((ItemStack[])null);
                    todos.updateInventory();
                    KitAPI.removeKits(p);
                    me.cangasso.API.API.setWarp(todos, "Spawn");
                    return true;
                }
            }
            return true;
        }
        return false;
    }
}
