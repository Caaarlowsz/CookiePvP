package me.cangasso.events;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import me.cangasso.API.TopKillStreak;
import me.cangasso.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffectType;
import me.cangasso.commands.AdminCommand;
import me.cangasso.API.KitAPI;
import me.cangasso.API.KitdiarioAPI;
import me.cangasso.API.WarpsAPI;
import me.cangasso.API.ArraysAPI;
import me.cangasso.scoreboard.sScoreAPI;
import org.bukkit.GameMode;
import org.bukkit.inventory.ItemStack;
import me.cangasso.invencivel.Prote\u00e7\u00e3o;
import me.cangasso.configura\u00e7\u00e3o.cfStatus;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import me.cangasso.bans.Config;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import me.cangasso.API.API;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.Listener;

public class eEvents implements Listener
{
    @EventHandler
    public void login(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        final PlayerLoginEvent.Result result = e.getResult();
        e.getResult();
        if (result != PlayerLoginEvent.Result.KICK_WHITELIST) {
            API.checarNameTag(p);
        }
    }
    
    @EventHandler
    public void join(final PlayerJoinEvent e) {
        e.setJoinMessage((String)null);
        final Player p = e.getPlayer();
        Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Nome", (Object)p.getName());
        Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Grupo", cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo"));
        Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Coins", (Object)cfStatus.getMoney(p));
        Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Kills", (Object)cfStatus.getKills(p));
        Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Deaths", (Object)cfStatus.getDeaths(p));
        Config.getConfig().saveJogadores();
        p.setWalkSpeed(0.2f);
        Prote\u00e7\u00e3o.setImortal(p, true);
        Prote\u00e7\u00e3o.isImortal(p);
        p.getInventory().clear();
        p.getInventory().setArmorContents((ItemStack[])null);
        p.setGameMode(GameMode.ADVENTURE);
        sScoreAPI.Score.add(p);
        ArraysAPI.Jogando.add(p);
        ArraysAPI.Admin.remove(p);
        API.setWarp(p, "Spawn");
        WarpsAPI.Ir(p, "Spawn");
        API.mandarTitulo(p, "§6§lCookie§f§lNetwork");
        API.mandarSubTitulo(p, "§eSeja bem-vindo, §f" + p.getName());
        API.checarPermissao(p);
        API.checarGrupo(p);
        API.corGrupo(p);
        API.checarConfig(p);
        API.checarAlgumasCoisas(p);
        ArraysAPI.CooldownChat.remove(p);
        KitdiarioAPI.iniciarContagem(p);
        KitAPI.removeKits(p);
        AdminCommand.checarAdmin();
        cfStatus.FirstJoin(p);
        p.removePotionEffect(PotionEffectType.SPEED);
        p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        p.setHealth(20.0);
        p.setMaxHealth(20.0);
        sScoreAPI.scoreboard(p);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                API.sendItems(p);
            }
        }, 1L);
        for (int i = 1; i < 100; ++i) {
            p.sendMessage(" ");
        }
        p.sendMessage("§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-");
        p.sendMessage(" ");
        p.sendMessage("§8§l<§c§l!§8§l> §7Seja bem-vindo ao §6§lCookie§f§lNetwork§7, §6§l" + p.getName() + "§7!");
        p.sendMessage("§8§l<§c§l!§8§l> §7Fique por dentro de nossas novidades atrav\u00e9s de nosso Twitter §b§l@_McCookie§7.");
        p.sendMessage(" ");
        p.sendMessage("§8§l<§e§l!§8§l> §7Temos atualmente §e§l" + Bukkit.getOnlinePlayers().length + "§7 jogadores conectados em nosso §6§lKitPvP§7.");
        p.sendMessage(" ");
        p.sendMessage("§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-§b§m-§f§m-");
        if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Helper")) {
            p.chat("/admin");
        }
        TopKillStreak.Ks.put(p, 0);
        Player[] onlinePlayers;
        for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, j = 0; j < length; ++j) {
            final Player players = onlinePlayers[j];
            TopKillStreak.KsTop.put(p, TopKillStreak.getKsTop(players));
            TopKillStreak.Name.put(p, TopKillStreak.getNameTop(players));
        }
        if (cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Gerente")) {
            ArraysAPI.Monitor.add(p);
        }
        ArraysAPI.CooldownChat.remove(p);
    }
    
    @EventHandler
    public void death(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        final Player d = e.getEntity().getKiller();
        WarpsAPI.Ir(p, "Spawn");
        API.setWarp(p, "Spawn");
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                p.spigot().respawn();
            }
        }, 1L);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                API.sendItems(p);
            }
        }, 2L);
        if (KitAPI.getKit(p) != "1v1") {
            WarpsAPI.Ir(p, "Spawn");
            API.setWarp(p, "Spawn");
            KitAPI.removeKits(p);
            if (d != null) {
                p.sendMessage("§7Voc\u00ea morreu para o jogador: §c§l" + d.getName());
                d.sendMessage("§7Voc\u00ea matou o jogador: §a§l" + p.getName());
                d.sendMessage("§7(§a+100XP\u2b06§7)");
                cfStatus.setKills(d);
                cfStatus.setDeaths(p);
                cfStatus.setMoney(d, 100);
                cfStatus.RemoveMoney(p, 50);
                cfStatus.RemoverKS(p);
                TopKillStreak.createTopKillStreak(d);
                sScoreAPI.scoreboard(p);
                sScoreAPI.scoreboard(d);
                e.setDeathMessage((String)null);
                e.getDrops().clear();
                if (TopKillStreak.getKsTop(p) == 5) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l5");
                }
                if (TopKillStreak.getKsTop(p) == 10) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l10");
                }
                if (TopKillStreak.getKsTop(p) == 15) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l15");
                }
                if (TopKillStreak.getKsTop(p) == 20) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l20");
                }
                if (TopKillStreak.getKsTop(p) == 25) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l25");
                }
                if (TopKillStreak.getKsTop(p) == 30) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l30");
                }
                if (TopKillStreak.getKsTop(p) == 35) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l35");
                }
                if (TopKillStreak.getKsTop(p) == 40) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l40");
                }
                if (TopKillStreak.getKsTop(p) == 45) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l45");
                }
                if (TopKillStreak.getKsTop(p) == 50) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l50");
                }
                if (TopKillStreak.getKsTop(p) == 55) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l55");
                }
                if (TopKillStreak.getKsTop(p) == 60) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l60");
                }
                if (TopKillStreak.getKsTop(p) == 65) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l65");
                }
                if (TopKillStreak.getKsTop(p) == 70) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l70");
                }
                if (TopKillStreak.getKsTop(p) == 75) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l75");
                }
                if (TopKillStreak.getKsTop(p) == 80) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l80");
                }
                if (TopKillStreak.getKsTop(p) == 85) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l85");
                }
                if (TopKillStreak.getKsTop(p) == 90) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l90");
                }
                if (TopKillStreak.getKsTop(p) == 95) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §fest\u00e1 com um §6§lKILLSTREAK §fde §a§l95");
                }
                if (TopKillStreak.getKsTop(p) == 100) {
                    Bukkit.broadcastMessage("§a§l" + d.getName() + " §falcan\u00e7ou o §6§lKILLSTREAK §fm\u00e1ximo de §a§l100§f!");
                }
                else {
                    e.setDeathMessage((String)null);
                    e.getDrops().clear();
                    TopKillStreak.Ks.put(p, 0);
                    Player[] onlinePlayers;
                    for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                        final Player players = onlinePlayers[i];
                        TopKillStreak.createTopKillStreak(players);
                    }
                }
            }
        }
    }
    
    @EventHandler
    public void quit(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        ArraysAPI.Jogando.remove(p);
        KitAPI.removeKits(p);
        e.setQuitMessage((String)null);
    }
    
    @EventHandler
    public void cmdnotfound(final PlayerCommandPreprocessEvent e) {
        if (e.isCancelled()) {
            return;
        }
        final Player p = e.getPlayer();
        final String msg = e.getMessage().split(" ")[0];
        final HelpTopic t = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
        if (t == null) {
            e.setCancelled(true);
            p.sendMessage("§4§l(!) §cComando desconhecido");
        }
    }
    
    @EventHandler
    void BuildConstruct(final BlockPlaceEvent evento) {
        final Player jogador = evento.getPlayer();
        if (jogador.getGameMode() != GameMode.CREATIVE) {
            evento.setCancelled(true);
        }
        else {
            evento.setCancelled(false);
        }
    }
    
    @EventHandler
    void BuildBreak(final BlockBreakEvent evento) {
        final Player jogador = evento.getPlayer();
        if (jogador.getGameMode() != GameMode.CREATIVE) {
            evento.setCancelled(true);
        }
        else if (jogador.getItemInHand().getTypeId() == 268 || jogador.getItemInHand().getTypeId() == 272 || jogador.getItemInHand().getTypeId() == 267 || jogador.getItemInHand().getTypeId() == 276 || jogador.getItemInHand().getTypeId() == 283) {
            evento.setCancelled(true);
        }
        else {
            evento.setCancelled(false);
        }
    }
}
