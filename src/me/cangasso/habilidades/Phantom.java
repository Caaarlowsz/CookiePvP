package me.cangasso.habilidades;

import org.bukkit.event.EventHandler;
import me.cangasso.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Color;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.Material;
import me.cangasso.API.CooldownAPI;
import me.cangasso.API.KitAPI;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import java.util.HashMap;
import org.bukkit.event.Listener;

public class Phantom implements Listener
{
    public static HashMap<Player, ItemStack[]> salvarArmadura;
    
    static {
        Phantom.salvarArmadura = new HashMap<Player, ItemStack[]>();
    }
    
    @EventHandler
    public void interagir(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (KitAPI.getKit(p) == "Phantom" && CooldownAPI.Cooldown.containsKey(p.getName()) && p.getItemInHand().getType() == Material.FEATHER) {
            e.setCancelled(true);
            p.sendMessage("§8§l<§e§l!§8§l> Aguarde para utilizar essa habilidade novamente!");
        }
        else if (KitAPI.getKit(p) == "Phantom" && !CooldownAPI.Cooldown.containsKey(p.getName()) && p.getItemInHand().getType() == Material.FEATHER) {
            Phantom.salvarArmadura.put(p, p.getInventory().getArmorContents());
            p.getInventory().setArmorContents((ItemStack[])null);
            final ItemStack Peito = new ItemStack(Material.LEATHER_CHESTPLATE);
            final LeatherArmorMeta kPeito = (LeatherArmorMeta)Peito.getItemMeta();
            kPeito.setDisplayName("§f§lPhantom");
            kPeito.setColor(Color.WHITE);
            Peito.setItemMeta((ItemMeta)kPeito);
            final ItemStack Cal\u00e7a = new ItemStack(Material.LEATHER_LEGGINGS);
            final LeatherArmorMeta kCa\u00e7a = (LeatherArmorMeta)Cal\u00e7a.getItemMeta();
            kCa\u00e7a.setDisplayName("§f§lPhantom");
            kCa\u00e7a.setColor(Color.WHITE);
            Cal\u00e7a.setItemMeta((ItemMeta)kCa\u00e7a);
            final ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
            final LeatherArmorMeta kBota = (LeatherArmorMeta)Bota.getItemMeta();
            kBota.setDisplayName("§f§lPhantom");
            kBota.setColor(Color.WHITE);
            Bota.setItemMeta((ItemMeta)kBota);
            final ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
            final LeatherArmorMeta kCasapete = (LeatherArmorMeta)Capacete.getItemMeta();
            kCasapete.setDisplayName("§f§lPhantom");
            kCasapete.setColor(Color.WHITE);
            Capacete.setItemMeta((ItemMeta)kCasapete);
            p.getInventory().setChestplate(Peito);
            p.getInventory().setLeggings(Cal\u00e7a);
            p.getInventory().setHelmet(Capacete);
            p.getInventory().setBoots(Bota);
            p.updateInventory();
            p.sendMessage("§aVoc\u00ea pode voar por 5 segundos!");
            CooldownAPI.addCooldown(p, 35);
            p.setAllowFlight(true);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage("§cO seu modo p\u00e1ssaro acabou!");
                    p.getInventory().setArmorContents((ItemStack[])null);
                    p.closeInventory();
                    p.getInventory().remove(Material.LEATHER_BOOTS);
                    p.getInventory().remove(Material.LEATHER_CHESTPLATE);
                    p.getInventory().remove(Material.LEATHER_HELMET);
                    p.getInventory().remove(Material.LEATHER_LEGGINGS);
                    p.updateInventory();
                    p.getInventory().setArmorContents((ItemStack[])Phantom.salvarArmadura.get(p));
                    p.setAllowFlight(false);
                }
            }, 100L);
        }
    }
}
