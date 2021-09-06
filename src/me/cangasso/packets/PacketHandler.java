package me.cangasso.packets;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public abstract class PacketHandler {
	private static final List<PacketHandler> handlers;
	private Plugin plugin;

	static {
		handlers = new ArrayList<PacketHandler>();
	}

	public static boolean addHandler(final PacketHandler handler) {
		final boolean b = PacketHandler.handlers.contains(handler);
		PacketHandler.handlers.add(handler);
		return !b;
	}

	public static boolean removeHandler(final PacketHandler handler) {
		return PacketHandler.handlers.remove(handler);
	}

	public static void notifyHandlers(final SentPacket packet) {
		for (final PacketHandler handler : getHandlers()) {
			try {
				final PacketOptions options = handler.getClass().getMethod("onSend", SentPacket.class)
						.getAnnotation(PacketOptions.class);
				if (options != null) {
					if (options.forcePlayer() && options.forceServer()) {
						throw new IllegalArgumentException("Cannot force player and server packets at the same time!");
					}
					if (options.forcePlayer()) {
						if (!packet.hasPlayer()) {
							continue;
						}
					} else if (options.forceServer() && packet.hasPlayer()) {
						continue;
					}
				}
				handler.onSend(packet);
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}

	public static void notifyHandlers(final ReceivedPacket packet) {
		for (final PacketHandler handler : getHandlers()) {
			try {
				final PacketOptions options = handler.getClass().getMethod("onReceive", ReceivedPacket.class)
						.getAnnotation(PacketOptions.class);
				if (options != null) {
					if (options.forcePlayer() && options.forceServer()) {
						throw new IllegalArgumentException("Cannot force player and server packets at the same time!");
					}
					if (options.forcePlayer()) {
						if (!packet.hasPlayer()) {
							continue;
						}
					} else if (options.forceServer() && packet.hasPlayer()) {
						continue;
					}
				}
				handler.onReceive(packet);
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}

	public static List<PacketHandler> getHandlers() {
		return new ArrayList<PacketHandler>(PacketHandler.handlers);
	}

	public static List<PacketHandler> getForPlugin(final Plugin plugin) {
		final List<PacketHandler> handlers = new ArrayList<PacketHandler>();
		if (plugin == null) {
			return handlers;
		}
		for (final PacketHandler h : getHandlers()) {
			if (plugin.equals(h.getPlugin())) {
				handlers.add(h);
			}
		}
		return handlers;
	}

	public void sendPacket(final Player p, final Object packet) {
		if (p == null || packet == null) {
			throw new NullPointerException();
		}
		try {
			final Object handle = NMSUtils.getHandle(p);
			final Object connection = NMSUtils.getField(handle.getClass(), "playerConnection").get(handle);
			NMSUtils.getMethod(connection.getClass(), "sendPacket", NMSUtils.getNMSClass("Packet")).invoke(connection,
					packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object cloneObject(final Object obj) throws Exception {
		if (obj == null) {
			return obj;
		}
		final Object clone = obj.getClass().newInstance();
		Field[] declaredFields;
		for (int length = (declaredFields = obj.getClass().getDeclaredFields()).length, i = 0; i < length; ++i) {
			Field f = declaredFields[i];
			f = AccessUtil.setAccessible(f);
			f.set(clone, f.get(obj));
		}
		return clone;
	}

	@Deprecated
	public PacketHandler() {
	}

	public PacketHandler(final Plugin plugin) {
		this.plugin = plugin;
	}

	public Plugin getPlugin() {
		return this.plugin;
	}

	public abstract void onSend(final SentPacket p0);

	public abstract void onReceive(final ReceivedPacket p0);
}
