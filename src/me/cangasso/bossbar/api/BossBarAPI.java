package me.cangasso.bossbar.api;

import me.cangasso.bossbar.Reflection;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.annotation.Nonnull;
import org.bukkit.entity.Player;
import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;
import java.util.Map;

public abstract class BossBarAPI
{
    private static final Map<UUID, BossBar> barMap;
    
    static {
        barMap = new ConcurrentHashMap<UUID, BossBar>();
    }
    
    public static void setMessage(final Player player, final String message) {
        setMessage(player, message, 100.0f);
    }
    
    public static void setMessage(final Player player, final String message, final float percentage) {
        setMessage(player, message, percentage, 0);
    }
    
    public static void setMessage(final Player player, final String message, final float percentage, final int timeout) {
        setMessage(player, message, percentage, timeout, 100.0f);
    }
    
    public static void setMessage(final Player player, final String message, final float percentage, final int timeout, final float minHealth) {
        if (!BossBarAPI.barMap.containsKey(player.getUniqueId())) {
            BossBarAPI.barMap.put(player.getUniqueId(), new BossBar(player, message, percentage, timeout, minHealth));
        }
        final BossBar bar = BossBarAPI.barMap.get(player.getUniqueId());
        if (!bar.message.equals(message)) {
            bar.setMessage(message);
        }
        final float newHealth = percentage / 100.0f * bar.getMaxHealth();
        if (bar.health != newHealth) {
            bar.setHealth(newHealth);
        }
        if (!bar.isVisible()) {
            bar.setVisible(true);
        }
    }
    
    public static String getMessage(final Player player) {
        final BossBar bar = getBossBar(player);
        if (bar == null) {
            return null;
        }
        return bar.getMessage();
    }
    
    public static boolean hasBar(@Nonnull final Player player) {
        return BossBarAPI.barMap.containsKey(player.getUniqueId());
    }
    
    public static void removeBar(@Nonnull final Player player) {
        final BossBar bar = getBossBar(player);
        if (bar == null) {
            return;
        }
        bar.setVisible(false);
        BossBarAPI.barMap.remove(player.getUniqueId());
    }
    
    public static void setHealth(final Player player, final float percentage) {
        final BossBar bar = getBossBar(player);
        if (bar == null) {
            return;
        }
        bar.setHealth(percentage);
    }
    
    public static float getHealth(@Nonnull final Player player) {
        final BossBar bar = getBossBar(player);
        if (bar == null) {
            return -1.0f;
        }
        return bar.getHealth();
    }
    
    @Nullable
    public static BossBar getBossBar(@Nonnull final Player player) {
        if (player == null) {
            return null;
        }
        return BossBarAPI.barMap.get(player.getUniqueId());
    }
    
    public static Collection<BossBar> getBossBars() {
        final List<BossBar> list = new ArrayList<BossBar>(BossBarAPI.barMap.values());
        return list;
    }
    
    protected static void sendPacket(final Player p, final Object packet) {
        if (p == null || packet == null) {
            throw new IllegalArgumentException("player and packet cannot be null");
        }
        try {
            final Object handle = Reflection.getHandle(p);
            final Object connection = Reflection.getField(handle.getClass(), "playerConnection").get(handle);
            Reflection.getMethod(connection.getClass(), "sendPacket", Reflection.getNMSClass("Packet")).invoke(connection, packet);
        }
        catch (Exception ex) {}
    }
}
