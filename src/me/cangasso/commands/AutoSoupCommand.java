package me.cangasso.commands;

import me.cangasso.main.Main;
import me.cangasso.API.API;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import me.cangasso.API.ArraysAPI;
import org.bukkit.Bukkit;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import java.util.HashMap;
import org.bukkit.command.CommandExecutor;

public class AutoSoupCommand implements CommandExecutor
{
    public static HashMap<Player, ItemStack[]> inventario;
    
    static {
        AutoSoupCommand.inventario = new HashMap<Player, ItemStack[]>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("autosoup")) {
            if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Helper")) {
                p.sendMessage("Voc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("§7Utilize §a§l/autosoup (jogador)§f.");
                p.sendMessage("§4§lATENCAO §7Verifique se o jogador n\u00e3o est\u00e1 em duelo com algu\u00e9m pois o teste de autosoup poder\u00e1 prejudic\u00e1-lo.");
                return true;
            }
            if (args.length == 1) {
                final Player t = Bukkit.getPlayer(args[0]);
                if (t == null) {
                    p.sendMessage("§cO jogador §c§l " + args[0] + " §7est\u00e1 offline.");
                    return true;
                }
                if (t.getName() == p.getName()) {
                    p.sendMessage("§cVoc\u00ea n\u00e3o pode testar §c§lAutosoup §cem si mesmo!");
                    return true;
                }
                if (ArraysAPI.Checando.contains(t)) {
                    p.sendMessage("§4§lAUTOSOUP §7Outro membro da equipe j\u00e1 est\u00e1 testando §c§lAutosoup §7neste jogador. Tente novamente!");
                }
                AutoSoupCommand.inventario.put(t, t.getInventory().getContents());
                t.getInventory().clear();
                t.setHealth(0.5);
                ArraysAPI.Checando.add(t);
                p.openInventory((Inventory)t.getInventory());
                t.getInventory().setItem(20, API.criarItem(p, Material.MUSHROOM_SOUP, "§f§oSopa", new String[] { "" }, 1, (short)0));
                t.getInventory().setItem(21, API.criarItem(p, Material.MUSHROOM_SOUP, "§f§oSopa", new String[] { "" }, 1, (short)0));
                t.getInventory().setItem(22, API.criarItem(p, Material.MUSHROOM_SOUP, "§f§oSopa", new String[] { "" }, 1, (short)0));
                p.sendMessage("§aChecando...");
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (API.getAmount(t, Material.BOWL) >= 1) {
                            p.closeInventory();
                            p.sendMessage(" ");
                            p.sendMessage("§4§lPROBABILIDADE: §fA probabilidade do jogador estar de Autosoup \u00e9: §4§lCERTEZA");
                            p.sendMessage(" ");
                        }
                        else if (API.getAmount(t, Material.BOWL) == 0) {
                            p.closeInventory();
                            p.sendMessage(" ");
                            p.sendMessage("§4§lPROBABILIDADE: §fA probabilidade do jogador estar de Autosoup \u00e9: §a§lNENHUMA");
                            p.sendMessage(" ");
                        }
                        ArraysAPI.Checando.remove(t);
                        t.getInventory().clear();
                        t.closeInventory();
                        t.getInventory().setContents((ItemStack[])AutoSoupCommand.inventario.get(t));
                        t.setHealth(20.0);
                    }
                }, 60L);
            }
        }
        return false;
    }
}
