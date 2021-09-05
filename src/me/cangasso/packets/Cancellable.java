package me.cangasso.packets;

public class Cancellable
{
    private boolean cancelled;
    
    public Cancellable() {
        this.cancelled = false;
    }
    
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    public void setCancelled(final boolean paramBoolean) {
        this.cancelled = paramBoolean;
    }
}
