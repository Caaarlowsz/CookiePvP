package me.cangasso.v_1_8;

import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;
import net.minecraft.server.v1_7_R4.Packet;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import org.spigotmc.ProtocolInjector;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class TituloAPI
{
    public static void MandarTitulo(final Player Jogador, final String Titulo) {
        if (((CraftPlayer)Jogador).getHandle().playerConnection.networkManager.getVersion() < 45) {
            return;
        }
        ((CraftPlayer)Jogador).getHandle().playerConnection.sendPacket((Packet)new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TITLE, ChatSerializer.a("{\"text\": \"\"}").a(Titulo)));
    }
    
    public static void MandarSubTitulo(final Player Jogador, final String Titulo) {
        if (((CraftPlayer)Jogador).getHandle().playerConnection.networkManager.getVersion() < 45) {
            return;
        }
        ((CraftPlayer)Jogador).getHandle().playerConnection.sendPacket((Packet)new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE, ChatSerializer.a("{\"text\": \"\"}").a(Titulo)));
    }
    
    public static void MandarActionBar(final Player Jogador, final String Titulo) {
        final CraftPlayer CraftPlayer = (CraftPlayer)Jogador;
        if (CraftPlayer.getHandle().playerConnection.networkManager.getVersion() != 47) {
            return;
        }
        final IChatBaseComponent IChatBaseComponent = ChatSerializer.a("{\"text\": \"" + Titulo + "\"}");
        final PacketPlayOutChat PacketPlayOutChat = new PacketPlayOutChat(IChatBaseComponent, 2);
        CraftPlayer.getHandle().playerConnection.sendPacket((Packet)PacketPlayOutChat);
        CraftPlayer.getHandle().playerConnection.sendPacket((Packet)PacketPlayOutChat);
    }
    
    public static void LimparTitulo(final Player Jogador) {
        if (((CraftPlayer)Jogador).getHandle().playerConnection.networkManager.getVersion() < 45) {
            return;
        }
        ((CraftPlayer)Jogador).getHandle().playerConnection.sendPacket((Packet)new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.CLEAR));
    }
}
