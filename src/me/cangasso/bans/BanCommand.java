package me.cangasso.bans;

import org.bukkit.OfflinePlayer;
import me.cangasso.API.HorarioAPI;
import me.cangasso.twitter.TweetAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import me.cangasso.configura\u00e7\u00e3o.cfGrupo;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class BanCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player jogador = (Player)sender;
        if (!cmd.getName().equalsIgnoreCase("ban")) {
            return false;
        }
        if (!cfGrupo.ChecarGrupo(jogador, "Dono") && !cfGrupo.ChecarGrupo(jogador, "Gerente") && !cfGrupo.ChecarGrupo(jogador, "Admin") && !cfGrupo.ChecarGrupo(jogador, "Mod+") && !cfGrupo.ChecarGrupo(jogador, "Mod") && !cfGrupo.ChecarGrupo(jogador, "Trial") && !cfGrupo.ChecarGrupo(jogador, "Youtuber+")) {
            API.sendMsg((CommandSender)jogador, "§4§l(!) §cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando!");
            return true;
        }
        if (args.length == 0) {
            API.sendMsg((CommandSender)jogador, "§cUse /ban (jogador) (motivo)");
            API.sendSound(jogador, Sound.NOTE_PLING, 10);
            return true;
        }
        final Player vitima = Bukkit.getPlayer(args[0]);
        if (vitima == null) {
            final OfflinePlayer vitimaoff = Bukkit.getOfflinePlayer(args[0]);
            if (vitimaoff.getName() == jogador.getName()) {
                API.sendMsg((CommandSender)jogador, "§cVoc\u00ea n\u00e3o pode banir a si mesmo!");
                API.sendSound(jogador, Sound.NOTE_PLING, 10);
                return true;
            }
            if (Config.getConfig().getBans().get("Bans." + vitimaoff.getUniqueId()) != null) {
                API.sendMsg((CommandSender)jogador, "§fO jogador §c§l" + vitimaoff.getName() + " §fj\u00e1 est\u00e1 §4§lBANIDO§f!");
                API.sendSound(jogador, Sound.NOTE_PLING, 10);
                return true;
            }
            if (Config.getConfig().getIpBans().get("IPBans." + vitimaoff.getUniqueId()) != null) {
                API.sendMsg((CommandSender)jogador, "§fO jogador §c§l" + vitimaoff.getName() + " §fj\u00e1 est\u00e1 §4§lBANIDO§4(IP)§f!");
                API.sendSound(jogador, Sound.NOTE_PLING, 10);
                return true;
            }
            if (Config.getConfig().getTempBans().get("TempBans." + vitimaoff.getUniqueId()) != null) {
                API.sendMsg((CommandSender)jogador, "§fO jogador §c§l" + vitimaoff.getName() + " §fj\u00e1 est\u00e1 §9§lBANIDO§9(tempban)§f!");
                API.sendSound(jogador, Sound.NOTE_PLING, 10);
                return true;
            }
            if (vitimaoff.getName() == "Cangasso") {
                API.sendMsg((CommandSender)jogador, "§fVoc\u00ea n\u00e3o pode banir §4§lCANGASSO§f!");
            }
            String Motivo = "";
            for (int i = 1; i < args.length; ++i) {
                Motivo = String.valueOf(Motivo) + args[i] + " ";
            }
            final double l = Config.getConfig().getBans().getDouble("Players Banidos");
            API.sendMsg((CommandSender)jogador, "§aVoc\u00ea baniu o jogador " + vitimaoff.getName() + "§a!");
            API.sendBC("§4§l[BAN] §7" + vitimaoff.getName() + " §7foi banido permanentemente por " + Motivo);
            API.sendStaff("§c" + jogador.getName() + " §cbaniu o jogador §c" + vitimaoff.getName() + "§c. Motivo: " + Motivo);
            TweetAPI.update("\ud83d\udd10 Jogador banido: " + vitimaoff.getName() + "\n" + "Banido por: " + jogador.getName() + "\n" + "Motivo: " + Motivo);
            Config.getConfig().getBans().set("Players Banidos", (Object)(l + 1.0));
            Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Nome", (Object)vitimaoff.getName());
            Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Banido por", (Object)jogador.getName());
            Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Motivo", (Object)Motivo);
            Config.getConfig().saveBans();
            return true;
        }
        else {
            if (vitima.getName() == jogador.getName()) {
                API.sendMsg((CommandSender)jogador, "§cVoc\u00ea n\u00e3o pode banir a si mesmo!");
                API.sendSound(jogador, Sound.NOTE_PLING, 10);
                return true;
            }
            if (Config.getConfig().getBans().get("Bans." + vitima.getUniqueId()) != null) {
                API.sendMsg((CommandSender)jogador, "§cO jogador " + vitima.getName() + " §cj\u00e1 est\u00e1 banido!");
                API.sendSound(jogador, Sound.NOTE_PLING, 10);
                return true;
            }
            if (Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId()) != null) {
                API.sendMsg((CommandSender)jogador, "§cO jogador " + vitima.getName() + " §cj\u00e1 est\u00e1 banido!");
                API.sendSound(jogador, Sound.NOTE_PLING, 10);
                return true;
            }
            if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
                API.sendMsg((CommandSender)jogador, "§cO jogador " + vitima.getName() + " §cj\u00e1 est\u00e1 banido!");
                API.sendSound(jogador, Sound.NOTE_PLING, 10);
                return true;
            }
            if (args.length == 1) {
                API.sendMsg((CommandSender)jogador, "§cUse /ban (jogador) (motivo)");
                API.sendSound(jogador, Sound.NOTE_PLING, 10);
                return true;
            }
            String Motivo2 = "";
            for (int j = 1; j < args.length; ++j) {
                Motivo2 = String.valueOf(Motivo2) + args[j] + " ";
            }
            final double k = Config.getConfig().getBans().getDouble("Players Banidos");
            API.sendMsg((CommandSender)jogador, "§aVoc\u00ea baniu " + vitima.getName() + "§a!");
            API.sendBC("§4§l[BAN] §7" + vitima.getName() + " §7foi banido permanentemente por " + Motivo2);
            API.sendStaff("§c" + jogador.getName() + " §cbaniu o jogador §c" + vitima.getName() + "§c. Motivo: " + Motivo2);
            vitima.kickPlayer("§7Voc\u00ea foi banido §4§lPERMANENTEMENTE §7do servidor!\n§7Username banido: §c§l" + vitima.getName() + "\n" + "§7Banido por: §c§l" + jogador.getName() + "\n" + "§7Motivo: §c§l" + Motivo2 + "\n" + "§7Expira em: §c§lNUNCA" + "\n" + "§7Data do banimento: §c" + HorarioAPI.getHorario() + "\n" + "§7Compre §e§lUNBAN §7em nossa loja: §e§lmc-cookie.com.br" + "\n" + "§7Banimento incorreto? Contate-nos pelo Twitter §b§l@Cookie_Suporte§7!");
            TweetAPI.update("\ud83d\udd10 Jogador banido: " + vitima.getName() + "\n" + "Banido por: " + jogador.getName() + "\n" + "Motivo: " + Motivo2);
            Config.getConfig().getBans().set("Players Banidos", (Object)(k + 1.0));
            Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Nome", (Object)vitima.getName());
            Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Banido por", (Object)jogador.getName());
            Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Motivo", (Object)Motivo2);
            Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Data do banimento", (Object)HorarioAPI.getHorario());
            Config.getConfig().saveBans();
            return true;
        }
    }
}
