package me.cangasso.menus;

import org.bukkit.inventory.Inventory;
import me.cangasso.commands.GiveAllCommand;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import me.cangasso.configura\u00e7\u00e3o.cfPermiss\u00e3o;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import java.util.Arrays;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class Padrao2Menu
{
    public static ItemStack criarItemMenu(final Material material, final String nome, final String[] habilidade) {
        final ItemStack item = new ItemStack(material);
        final ItemMeta kitem = item.getItemMeta();
        kitem.setDisplayName(nome);
        kitem.setLore((List)Arrays.asList(habilidade));
        item.setItemMeta(kitem);
        return item;
    }
    
    public static void inventory(final Player p) {
        final Inventory menu = Bukkit.createInventory((InventoryHolder)p, 54, "§7\u27b3 §3§lKIT PADRAO §8(p\u00e1g. 2)");
        final ItemStack Voltar = new ItemStack(Material.CARPET, 1, (short)14);
        final ItemMeta kVoltar = Voltar.getItemMeta();
        kVoltar.setDisplayName("§c§lVOLTAR");
        kVoltar.setLore((List)Arrays.asList("§7volte para o menu", "§7dos kits que voc\u00ea possui", " "));
        Voltar.setItemMeta(kVoltar);
        final ItemStack PQ = new ItemStack(Material.SLIME_BALL);
        final ItemMeta kPQ = PQ.getItemMeta();
        kPQ.setDisplayName("§7\u27b3 §3§lKIT PADRAO");
        kPQ.setLore((List)Arrays.asList("§7Para que voc\u00ea n\u00e3o precise ficar", "§7escolhendo toda hora um kit", "§7criamos o kit padrao."));
        PQ.setItemMeta(kPQ);
        final ItemStack maiskits = new ItemStack(Material.getMaterial(351), 1, (short)1);
        final ItemMeta kmaiskits = maiskits.getItemMeta();
        kmaiskits.setDisplayName("§7\u27b3 §c§lPAGINA ANTERIOR");
        maiskits.setItemMeta(kmaiskits);
        final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)1);
        final ItemMeta kvidro = vidro.getItemMeta();
        kvidro.setDisplayName("§6§lCookie§f§lNetwork");
        vidro.setItemMeta(kvidro);
        final ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
        final ItemMeta kvidro2 = vidro2.getItemMeta();
        kvidro.setDisplayName("§6§lCookie§f§lNetwork");
        vidro.setItemMeta(kvidro2);
        final ItemStack cake = new ItemStack(Material.COOKIE);
        final ItemMeta kcake = cake.getItemMeta();
        kvidro.setDisplayName("§6§lCookie");
        vidro.setItemMeta(kcake);
        menu.setItem(0, Voltar);
        menu.setItem(8, Voltar);
        menu.setItem(1, vidro2);
        menu.setItem(2, vidro);
        menu.setItem(6, vidro);
        menu.setItem(7, vidro2);
        menu.setItem(9, vidro2);
        menu.setItem(10, vidro);
        menu.setItem(11, vidro2);
        menu.setItem(12, vidro);
        menu.setItem(13, vidro2);
        menu.setItem(14, vidro);
        menu.setItem(15, vidro2);
        menu.setItem(16, vidro);
        menu.setItem(17, vidro2);
        menu.setItem(18, vidro);
        menu.setItem(26, vidro);
        menu.setItem(27, maiskits);
        menu.setItem(35, vidro2);
        menu.setItem(36, vidro2);
        menu.setItem(44, vidro2);
        menu.setItem(45, vidro);
        menu.setItem(46, vidro2);
        menu.setItem(47, vidro);
        menu.setItem(48, vidro2);
        menu.setItem(49, cake);
        menu.setItem(50, vidro2);
        menu.setItem(51, vidro);
        menu.setItem(52, vidro2);
        menu.setItem(53, vidro);
        menu.setItem(3, vidro);
        menu.setItem(4, PQ);
        menu.setItem(5, vidro);
        menu.setItem(27, maiskits);
        if (cfPermiss\u00e3o.getPermissao(p, "kit.strong") || cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.pro) {
            menu.addItem(new ItemStack[] { criarItemMenu(Material.WATCH, "§7\u27b3 §6§lStrong", new String[] { "§a§lHABILIDADE: §7Fique Full Iron por alguns instantes!" }) });
        }
        if (cfPermiss\u00e3o.getPermissao(p, "kit.sumo") || cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Youtuber") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.pro) {
            menu.addItem(new ItemStack[] { criarItemMenu(Material.APPLE, "§7\u27b3 §6§lSumo", new String[] { "§7§a§lHABILIDADE: §7Jogue seus inimigos", "para o alto utilizando seu peso" }) });
        }
        p.openInventory(menu);
    }
}
