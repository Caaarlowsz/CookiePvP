package me.cangasso.friends;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class FriendsCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (Cmd.getName().equalsIgnoreCase("friends")) {
            p.sendMessage("§e§m>------- §f §f §9§l§kAAA §f §6§lFRIENDS §9§l§kAAA §f §e§m-------<");
            p.sendMessage(" ");
            p.sendMessage("§a§lFRIENDS? §fO sistema de friends \u00e9 muito pr\u00e1tico. Desenvolvido para um jogatina amig\u00e1vel e divertida, voc\u00ea pode utilizar os comandos abaixo para ter uma intera\u00e7\u00e3o maior com seus amigos!");
            p.sendMessage(" ");
            p.sendMessage("§8§l<§e§l!§8§l> §7/friend add §f| §8Para adicionar um amigo");
            p.sendMessage("§8§l<§e§l!§8§l> §7/friend find §f| §8Para ver em qual IP seu amigo se encontra");
            p.sendMessage("§8§l<§e§l!§8§l> §7/friend list §f| §8Para ver sua lista de amigos");
            p.sendMessage("§8§l<§e§l!§8§l> §7/friend chat §f| §8Para abrir um chat privado com seu amigo");
            p.sendMessage("§8§l<§e§l!§8§l> §7/friend delete §f| §8Para deletar seu amigo");
            p.sendMessage("");
            p.sendMessage("§e§m>------- §f §f §9§l§kAAA §f §6§lFRIENDS §f §9§l§kAAA §f §e§m-------<");
        }
        else if (Cmd.getName().equalsIgnoreCase("batata")) {
            p.sendMessage("§9§m>------- §f§6§lCookie§f§lNetwork §e§m-------<");
            p.sendMessage(" ");
            p.sendMessage("§6\u2022 §c§l/friend find §f| §8Para ver em qual IP seu amigo se encontra");
            p.sendMessage("§6\u2022 §c§l/friend list §f| §8Para ver sua lista de amigos");
            p.sendMessage("§6\u2022 §c§l/friend chat (jogador) §f| §8Para abrir um chat privado com seu amigo");
            p.sendMessage("§6\u2022 §c§l/friend delete §f| §8Para deletar seu amigo");
            p.sendMessage("");
            p.sendMessage("§9§m>------- §f§6§lCookie§f§lNetwork §e§m-------<");
        }
        return false;
    }
}
