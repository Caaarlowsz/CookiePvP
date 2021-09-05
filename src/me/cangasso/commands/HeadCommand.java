package me.cangasso.commands;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import me.cangasso.bans.API;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class HeadCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("head")) {
            if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin")) {
                API.sendMsg((CommandSender)p, "§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando.");
                return true;
            }
            if (args.length == 0) {
                p.sendMessage("§fUtilize §2§l/head §2(jogador)§f.");
                return true;
            }
            if (args.length == 1) {
                final String jogador = args[0];
                final ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
                final SkullMeta itemm = (SkullMeta)item.getItemMeta();
                itemm.setOwner(jogador);
                item.setItemMeta((ItemMeta)itemm);
                p.getInventory().addItem(new ItemStack[] { item });
                p.updateInventory();
                p.sendMessage("§fVoc\u00ea pegou a cabe\u00e7a de: §a§l" + jogador);
                return true;
            }
        }
        return false;
    }
}
