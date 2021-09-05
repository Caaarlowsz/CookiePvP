package me.cangasso.villager;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Bukkit;
import me.cangasso.API.API;
import me.cangasso.API.WarpsAPI;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import me.cangasso.API.ArraysAPI;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class VillagerParkour implements CommandExecutor, Listener
{
    public static ArrayList<Player> noParkour;
    
    static {
        VillagerParkour.noParkour = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("spawnvillagerparkour")) {
            if (!cfGrupo.ChecarGrupo(p, "Dono")) {
                cfGrupo.ChecarGrupo(p, "Admin");
            }
            final Villager v = (Villager)p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
            v.setCustomName("§8\u2022 §6§lPARKOUR §8\u2022");
            v.setCustomNameVisible(true);
            v.setProfession(Villager.Profession.BLACKSMITH);
        }
        return false;
    }
    
    @EventHandler
    public void aoClicar(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Villager && !ArraysAPI.Admin.contains(e.getPlayer())) {
            final Player p = e.getPlayer();
            final Villager v = (Villager)e.getRightClicked();
            if (v.getCustomName().equals("§8\u2022 §6§lPARKOUR §8\u2022")) {
                e.setCancelled(true);
                if (VillagerParkour.noParkour.contains(p)) {
                    p.sendMessage("§cVoc\u00ea j\u00e1 est\u00e1 no Parkour!");
                    e.setCancelled(true);
                    return;
                }
                if (!VillagerParkour.noParkour.contains(p)) {
                    final ItemStack Sair = new ItemStack(Material.BED);
                    final ItemMeta kSair = Sair.getItemMeta();
                    kSair.setDisplayName("§8\u2022 §6§lSAIR \u2022");
                    Sair.setItemMeta(kSair);
                    p.setAllowFlight(false);
                    VillagerParkour.noParkour.add(p);
                    WarpsAPI.Ir(p, "Parkour");
                    API.setWarp(p, "Parkour");
                    p.getInventory().clear();
                    p.getInventory().setArmorContents((ItemStack[])null);
                    p.getInventory().setItem(8, Sair);
                    p.updateInventory();
                    Player[] onlinePlayers;
                    for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                        final Player todos = onlinePlayers[i];
                        p.hidePlayer(todos);
                    }
                }
            }
        }
    }
    
    @EventHandler
    public void aoDano1(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Villager) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void aoDano2(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Villager) {
            e.setCancelled(true);
        }
    }
}
