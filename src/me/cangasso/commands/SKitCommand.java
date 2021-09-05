package me.cangasso.commands;

import me.cangasso.API.ArraysAPI;
import org.bukkit.Bukkit;
import me.cangasso.bans.API;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import org.bukkit.command.CommandExecutor;

public class SKitCommand implements CommandExecutor
{
    public static HashMap<String, ItemStack[]> itens;
    public static HashMap<String, ItemStack[]> armadura;
    
    static {
        SKitCommand.itens = new HashMap<String, ItemStack[]>();
        SKitCommand.armadura = new HashMap<String, ItemStack[]>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("skit")) {
            if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+")) {
                API.sendMsg((CommandSender)p, "§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("§cUse: /skit <criar | remover | aplicar> <nome>");
                return true;
            }
            if (args.length == 1) {
                p.sendMessage("§cUse: /skit <criar | remover | aplicar> <nome>");
                return true;
            }
            if (args.length <= 2) {
                if (args[0].equalsIgnoreCase("criar")) {
                    final String nome = args[1];
                    if (SKitCommand.itens.containsKey(nome) && SKitCommand.armadura.containsKey(nome)) {
                        p.sendMessage("§fO kit denominado de §2§l" + nome + " §fj\u00e1 existe!");
                        return true;
                    }
                    SKitCommand.itens.put(nome, p.getInventory().getContents());
                    SKitCommand.armadura.put(nome, p.getInventory().getArmorContents());
                    p.sendMessage("§aVoc\u00ea criou um kit! Chama-se: §a§l" + nome);
                    return true;
                }
                else if (args[0].equalsIgnoreCase("remover")) {
                    final String nome = args[1];
                    if (!SKitCommand.itens.containsKey(nome) && !SKitCommand.armadura.containsKey(nome)) {
                        p.sendMessage("§fO kit §a§l" + nome + "§f n\u00e3o existe!");
                        return true;
                    }
                    SKitCommand.itens.remove(nome);
                    SKitCommand.armadura.remove(nome);
                    p.sendMessage("§fVoc\u00ea §4§lDELETOU §fo kit §c§l" + nome);
                    return true;
                }
                else if (args[0].equalsIgnoreCase("aplicar")) {
                    final String nome = args[1];
                    if (!SKitCommand.itens.containsKey(nome) && !SKitCommand.armadura.containsKey(nome)) {
                        p.sendMessage("§fO kit §a§l" + nome + "§fn\u00e3o existe!");
                        return true;
                    }
                    if (SKitCommand.itens.containsKey(nome) && SKitCommand.armadura.containsKey(nome)) {
                        Player[] onlinePlayers;
                        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                            final Player todos = onlinePlayers[i];
                            if (todos != p && !ArraysAPI.Admin.contains(todos)) {
                                todos.getInventory().setContents((ItemStack[])SKitCommand.itens.get(nome));
                                todos.getInventory().setArmorContents((ItemStack[])SKitCommand.armadura.get(nome));
                                todos.updateInventory();
                                p.sendMessage("§aVoc\u00ea aplicou o kit §6§l" + nome + "§apara todos os jogadores!");
                                Bukkit.broadcastMessage("§7" + p.getDisplayName() + " §7aplicou o kit §6§l" + nome + "§7 para todos os jogadores!");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
