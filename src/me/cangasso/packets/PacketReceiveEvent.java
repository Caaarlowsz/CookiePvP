package me.cangasso.packets;

import java.lang.reflect.Field;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Event;

@Deprecated
public class PacketReceiveEvent extends Event
{
    private static HandlerList handlers;
    private Player player;
    private Object packet;
    private Cancellable cancel;
    
    static {
        PacketReceiveEvent.handlers = new HandlerList();
    }
    
    public PacketReceiveEvent(final Object packet, final Cancellable cancel, final Player player) {
        super(true);
        this.player = player;
        this.packet = packet;
        this.cancel = cancel;
    }
    
    public void setPacketValue(final String field, final Object value) {
        try {
            final Field f = this.packet.getClass().getDeclaredField(field);
            f.setAccessible(true);
            f.set(this.packet, value);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Object getPacketValue(final String field) {
        Object value = null;
        try {
            final Field f = this.packet.getClass().getDeclaredField(field);
            f.setAccessible(true);
            value = f.get(this.packet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    
    public void setCancelled(final boolean b) {
        this.cancel.setCancelled(b);
    }
    
    public boolean isCancelled() {
        return this.cancel.isCancelled();
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public String getPlayername() {
        return this.player.getName();
    }
    
    public void setPacket(final Object packet) {
        this.packet = packet;
    }
    
    public Object getPacket() {
        return this.packet;
    }
    
    public String getPacketName() {
        return this.packet.getClass().getSimpleName();
    }
    
    public HandlerList getHandlers() {
        return PacketReceiveEvent.handlers;
    }
    
    public static HandlerList getHandlerList() {
        return PacketReceiveEvent.handlers;
    }
}