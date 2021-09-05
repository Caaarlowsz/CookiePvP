package me.cangasso.commands;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class ChangepasswordCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if ((cmd.getName().equalsIgnoreCase("changepassword") || cmd.getName().equalsIgnoreCase("trocarsenha")) && args.length == 0) {
            p.sendMessage(" ");
            p.sendMessage("§6§lCOMO TROCAR DE SENHA? §f\u00c9 simples. Caso voc\u00ea tenha perdido ou esquecido a sua senha, entre em contato pelo Twitter §3§ohttps://twitter.com/Cookie_Suporte §fou §3§ohttps://twitter.com/Cangassow §fe solicite uma altera\u00e7\u00e3o! ");
            p.sendMessage("§fVoc\u00ea ser\u00e1 respondido em at\u00e9 §9§l24 horas§f.");
            p.sendMessage(" ");
            p.sendMessage("§f§oAntenciosamente, CookieNetwork. ");
            p.sendMessage(" ");
        }
        return false;
    }
}
