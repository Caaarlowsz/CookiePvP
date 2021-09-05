package me.cangasso.commands;

import me.cangasso.scoreboard.sScoreAPI;
import me.cangasso.invencivel.Prote\u00e7\u00e3o;
import me.cangasso.API.KitAPI;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.Inventory;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.EventHandler;
import me.cangasso.main.Main;
import me.cangasso.API.API;
import org.bukkit.GameMode;
import org.bukkit.Bukkit;
import org.bukkit.event.block.Action;
import me.cangasso.API.ArraysAPI;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import java.util.HashMap;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class AdminCommand implements CommandExecutor, Listener
{
    public static HashMap<Player, ItemStack[]> inventario;
    public static HashMap<Player, String> warp;
    public static HashMap<Player, String> kit;
    
    static {
        AdminCommand.inventario = new HashMap<Player, ItemStack[]>();
        AdminCommand.warp = new HashMap<Player, String>();
        AdminCommand.kit = new HashMap<Player, String>();
    }
    
    @EventHandler
    private void interact(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((p.getItemInHand().getType() == Material.MAGMA_CREAM && ArraysAPI.Admin.contains(p) && e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equals("§aTroca Rapida"))) {
            Player[] onlinePlayers;
            for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                final Player todos = onlinePlayers[i];
                todos.showPlayer(p);
                p.showPlayer(todos);
            }
            p.setGameMode(GameMode.SURVIVAL);
            ArraysAPI.Admin.remove(p);
            p.sendMessage("§aTroca r\u00e1pida efetuada com sucesso! ");
            p.getInventory().clear();
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().setItem(4, API.criarItem(p, Material.MAGMA_CREAM, "§aQuickAdmin", new String[] { "" }, 1, (short)0));
            p.getInventory().setItem(2, API.criarItem(p, Material.MUSHROOM_SOUP, "§aAutoSoup", new String[] { "" }, 1, (short)0));
            p.getInventory().setItem(6, API.criarItem(p, Material.IRON_FENCE, "§aJaula", new String[] { "" }, 1, (short)0));
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    ArraysAPI.Admin.add(p);
                    p.getInventory().clear();
                    p.getInventory().setArmorContents((ItemStack[])null);
                    p.getInventory().setItem(4, API.criarItem(p, Material.MAGMA_CREAM, "§aQuickAdmin", new String[] { "" }, 1, (short)0));
                    p.getInventory().setItem(2, API.criarItem(p, Material.MUSHROOM_SOUP, "§aAutoSoup", new String[] { "" }, 1, (short)0));
                    p.getInventory().setItem(6, API.criarItem(p, Material.IRON_FENCE, "§aJaula", new String[] { "" }, 1, (short)0));
                    p.setGameMode(GameMode.CREATIVE);
                    p.setHealth(20.0);
                    AdminCommand.setAdmin(p);
                }
            }, 10L);
        }
    }
    
    @EventHandler
    public void autosoup(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (p instanceof Player && e.getRightClicked() instanceof Player && p.getItemInHand().getType() == Material.MUSHROOM_SOUP && ArraysAPI.Admin.contains(p)) {
            final Player t = (Player)e.getRightClicked();
            if (ArraysAPI.Checando.contains(t)) {
                p.sendMessage("§4§lERRO §7Outro membro da equipe j\u00e1 est\u00e1 realizando testes neste jogador!");
                return;
            }
            AdminCommand.inventario.put(t, t.getInventory().getContents());
            t.getInventory().clear();
            t.setHealth(0.5);
            ArraysAPI.Checando.add(t);
            p.openInventory((Inventory)t.getInventory());
            t.getInventory().setItem(11, API.criarItem(p, Material.MUSHROOM_SOUP, "§f§oSopa", new String[] { "" }, 1, (short)0));
            t.getInventory().setItem(13, API.criarItem(p, Material.MUSHROOM_SOUP, "§f§oSopa", new String[] { "" }, 1, (short)0));
            t.getInventory().setItem(16, API.criarItem(p, Material.MUSHROOM_SOUP, "§f§oSopa", new String[] { "" }, 1, (short)0));
            p.sendMessage("§aCarregando informa\u00e7\u00f5es...");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    if (API.getAmount(t, Material.BOWL) >= 1) {
                        p.closeInventory();
                        p.sendMessage("§c§m>-------------------------<");
                        p.sendMessage("               §6» §f§lAUTOSOUP §6«     ");
                        p.sendMessage("§c§m>-------------------------<");
                        p.sendMessage(" ");
                        p.sendMessage("§6\u2022 §fProbabilidade: §2§lBAIXA");
                        p.sendMessage("§6\u2022 §fSopas tomadas: §6§l1");
                        p.sendMessage(" ");
                        p.sendMessage("§c§m>-------------------------<");
                        if (API.getAmount(t, Material.BOW) >= 3) {
                            p.closeInventory();
                            p.sendMessage("§c§m>-------------------------<");
                            p.sendMessage("               §6» §f§lAUTOSOUP §6«     ");
                            p.sendMessage("§c§m>-------------------------<");
                            p.sendMessage(" ");
                            p.sendMessage("§6\u2022 §fProbabilidade: §4§lCERTEZA");
                            p.sendMessage("§6\u2022 §fSopas tomadas: §6§l3");
                            p.sendMessage(" ");
                            p.sendMessage("§c§m>-------------------------<");
                        }
                        if (API.getAmount(t, Material.BOWL) >= 2) {
                            p.closeInventory();
                            p.sendMessage("§c§m>-------------------------<");
                            p.sendMessage("               §6» §f§lAUTOSOUP §6«     ");
                            p.sendMessage("§c§m>-------------------------<");
                            p.sendMessage(" ");
                            p.sendMessage("§6\u2022 §fProbabilidade: §6§lMEDIA");
                            p.sendMessage("§6\u2022 §fSopas tomadas: §6§l2");
                            p.sendMessage(" ");
                            p.sendMessage("§c§m>-------------------------<");
                        }
                    }
                    else if (API.getAmount(t, Material.BOWL) == 0) {
                        p.closeInventory();
                        p.sendMessage("§c§m>-------------------------<");
                        p.sendMessage("               §6» §f§lAUTOSOUP §6«     ");
                        p.sendMessage("§c§m>-------------------------<");
                        p.sendMessage(" ");
                        p.sendMessage("§6\u2022 §fProbabilidade: §a§lNENHUMA");
                        p.sendMessage("§6\u2022 §fSopas tomadas: §6§l0");
                        p.sendMessage(" ");
                        p.sendMessage("§c§m>-------------------------<");
                    }
                    ArraysAPI.Checando.remove(t);
                    t.getInventory().clear();
                    t.closeInventory();
                    t.getInventory().setContents((ItemStack[])AdminCommand.inventario.get(t));
                    t.setHealth(20.0);
                }
            }, 60L);
        }
        if (p.getItemInHand().getType() == Material.IRON_FENCE && ArraysAPI.Admin.contains(p)) {
            final Player t = (Player)e.getRightClicked();
            p.sendMessage("§a§l(!) §7Voc\u00ea prendeu o jogador: §6§l" + t.getName());
            t.getLocation().add(0.0, 13.0, 0.0).getBlock().setType(Material.BEDROCK);
            t.getLocation().add(0.0, 11.0, 1.0).getBlock().setType(Material.BEDROCK);
            t.getLocation().add(1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
            t.getLocation().add(0.0, 11.0, -1.0).getBlock().setType(Material.BEDROCK);
            t.getLocation().add(-1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
            t.getLocation().add(0.0, 10.0, 0.0).getBlock().setType(Material.BEDROCK);
            t.teleport(t.getLocation().add(0.0, 11.0, -0.05));
            p.teleport(t.getLocation().add(3.0, 0.0, 0.05));
        }
        if (p.getItemInHand().getType() == Material.AIR && ArraysAPI.Admin.contains(p)) {
            final Player t = (Player)e.getRightClicked();
            p.openInventory((Inventory)t.getInventory());
        }
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("admin")) {
            if (!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Helper")) {
                p.sendMessage("§c§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
                return true;
            }
            if (!ArraysAPI.Admin.contains(p)) {
                ArraysAPI.Admin.add(p);
                AdminCommand.kit.put(p, KitAPI.getKitAntes(p));
                AdminCommand.warp.put(p, API.getWarp(p));
                AdminCommand.inventario.put(p, p.getInventory().getContents());
                p.getInventory().clear();
                p.getInventory().setArmorContents((ItemStack[])null);
                Prote\u00e7\u00e3o.setImortal(p, false);
                p.sendMessage("§c§lADMIN: §fModo Admin: §aATIVADO");
                p.sendMessage("§6§lINVIS: §fVoc\u00ea est\u00e1 invis\u00edvel para todos os jogadores!");
                API.sendWarn("§7§o[" + p.getName() + "§7§o entrou no modo ADMIN]");
                KitAPI.setKitAntes(p, "Admin");
                API.setWarp(p, "Admin");
                p.setHealth(20.0);
                p.setMaxHealth(20.0);
                p.setGameMode(GameMode.CREATIVE);
                p.getInventory().setItem(4, API.criarItem(p, Material.MAGMA_CREAM, "§aQuickAdmin", new String[] { "" }, 1, (short)0));
                p.getInventory().setItem(2, API.criarItem(p, Material.MUSHROOM_SOUP, "§aAutoSoup", new String[] { "" }, 1, (short)0));
                p.getInventory().setItem(6, API.criarItem(p, Material.IRON_FENCE, "§aJaula", new String[] { "" }, 1, (short)0));
                setAdmin(p);
                ArraysAPI.Jogando.remove(p);
                Player[] onlinePlayers;
                for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                    final Player todos = onlinePlayers[i];
                    sScoreAPI.scoreboard(todos);
                }
                sScoreAPI.scoreboard(p);
                return true;
            }
            if (ArraysAPI.Admin.contains(p)) {
                ArraysAPI.Admin.remove(p);
                p.sendMessage("§c§lADMIN: §fModo Admin: §cDESATIVADO");
                p.sendMessage("§6§lVIS: §fVoc\u00ea est\u00e1 vis\u00edvel para todos os jogadores!");
                API.sendWarn("§7§o[" + p.getName() + "§7§o saiu do modo ADMIN]");
                KitAPI.setKitAntes(p, AdminCommand.kit.get(p));
                API.setWarp(p, AdminCommand.warp.get(p));
                p.setGameMode(GameMode.SURVIVAL);
                p.getInventory().clear();
                p.getInventory().setArmorContents((ItemStack[])null);
                p.getInventory().setContents((ItemStack[])AdminCommand.inventario.get(p));
                p.updateInventory();
                ArraysAPI.Jogando.add(p);
                Player[] onlinePlayers2;
                for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
                    final Player todos = onlinePlayers2[j];
                    sScoreAPI.scoreboard(todos);
                }
                Player[] onlinePlayers3;
                for (int length3 = (onlinePlayers3 = Bukkit.getOnlinePlayers()).length, k = 0; k < length3; ++k) {
                    final Player todos = onlinePlayers3[k];
                    todos.showPlayer(p);
                    p.showPlayer(todos);
                }
                sScoreAPI.scoreboard(p);
            }
        }
        return false;
    }
    
    public static void setAdmin(final Player p) {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player todos = onlinePlayers[i];
            if (cfGrupo.ChecarGrupo(todos, "Dono") || cfGrupo.ChecarGrupo(todos, "Gerente") || cfGrupo.ChecarGrupo(todos, "Admin") || cfGrupo.ChecarGrupo(todos, "Mod+") || cfGrupo.ChecarGrupo(todos, "Mod")) {
                todos.showPlayer(p);
                p.showPlayer(todos);
            }
            else if (ArraysAPI.Admin.contains(p)) {
                todos.hidePlayer(p);
            }
        }
    }
    
    public static void checarAdmin() {
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
            final Player todos = onlinePlayers[i];
            if (ArraysAPI.Admin.contains(todos)) {
                setAdmin(todos);
            }
        }
    }
}
