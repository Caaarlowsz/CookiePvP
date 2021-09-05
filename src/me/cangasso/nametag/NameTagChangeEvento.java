package me.cangasso.nametag;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

public class NameTagChangeEvento extends Event implements Cancellable
{
    private static final HandlerList handlers;
    private String OldJogador;
    private String OldPrefix;
    private String OldSuffix;
    private String NewPrefix;
    private String NewSuffix;
    private NametagChangeType Tipo;
    private NametagChangeReason Rea\u00e7\u00e3o;
    private boolean Cancelar;
    
    static {
        handlers = new HandlerList();
    }
    
    public static HandlerList getHandlerList() {
        return NameTagChangeEvento.handlers;
    }
    
    public HandlerList getHandlers() {
        return NameTagChangeEvento.handlers;
    }
    
    public NameTagChangeEvento(final String Jogador, final String OldPrefix, final String OldSuffix, final String NewPrefix, final String NewSuffix, final NametagChangeType Tipo, final NametagChangeReason Rea\u00e7\u00e3o) {
        this.Cancelar = false;
        this.OldJogador = Jogador;
        this.OldPrefix = OldPrefix;
        this.OldSuffix = OldSuffix;
        this.NewPrefix = NewPrefix;
        this.NewSuffix = NewSuffix;
        this.Tipo = Tipo;
        this.Rea\u00e7\u00e3o = Rea\u00e7\u00e3o;
    }
    
    public String PegarPlayerName() {
        return this.OldJogador;
    }
    
    public String PegarCurrentPrefix() {
        return this.OldPrefix;
    }
    
    public String PegarCurrentSuffix() {
        return this.OldSuffix;
    }
    
    public String PegarPrefix() {
        return this.NewPrefix;
    }
    
    public String PegarSuffix() {
        return this.NewSuffix;
    }
    
    public void SetarPrefix(final String Prefix) {
        this.NewPrefix = Prefix;
    }
    
    public void SetarSufix(final String Suffix) {
        this.NewSuffix = Suffix;
    }
    
    public NametagChangeType PegarTipo() {
        return this.Tipo;
    }
    
    public NametagChangeReason PegarReason() {
        return this.Rea\u00e7\u00e3o;
    }
    
    public void setCancelled(final boolean Cancelar) {
        this.Cancelar = Cancelar;
    }
    
    public boolean isCancelled() {
        return this.Cancelar;
    }
    
    public enum NametagChangeReason
    {
        SET_PREFIX("SET_PREFIX", 0), 
        SET_SUFFIX("SET_SUFFIX", 1), 
        GROUP_NODE("GROUP_NODE", 2), 
        CUSTOM("CUSTOM", 3);
        
        private NametagChangeReason(final String s, final int n) {
        }
    }
    
    public enum NametagChangeType
    {
        HARD("HARD", 0), 
        SOFT("SOFT", 1);
        
        private NametagChangeType(final String s, final int n) {
        }
    }
}
