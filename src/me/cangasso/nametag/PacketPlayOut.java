package me.cangasso.nametag;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PacketPlayOut {
	Object packet;
	private static Method getHandle;
	private static Method sendPacket;
	private static Field playerConnection;
	private static String version;
	private static Class<?> packetType;

	static {
		PacketPlayOut.version = "";
		try {
			PacketPlayOut.version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
			PacketPlayOut.packetType = Class.forName(getPacketTeamClasspath());
			final Class<?> typeCraftPlayer = Class
					.forName("org.bukkit.craftbukkit." + PacketPlayOut.version + ".entity.CraftPlayer");
			final Class<?> typeNMSPlayer = Class
					.forName("net.minecraft.server." + PacketPlayOut.version + ".EntityPlayer");
			final Class<?> typePlayerConnection = Class
					.forName("net.minecraft.server." + PacketPlayOut.version + ".PlayerConnection");
			PacketPlayOut.getHandle = typeCraftPlayer.getMethod("getHandle", (Class<?>[]) new Class[0]);
			PacketPlayOut.playerConnection = typeNMSPlayer.getField("playerConnection");
			PacketPlayOut.sendPacket = typePlayerConnection.getMethod("sendPacket",
					Class.forName("net.minecraft.server." + PacketPlayOut.version + ".Packet"));
		} catch (Exception e) {
			System.out.println("Failed to setup reflection for Packet209Mod!");
			e.printStackTrace();
		}
	}

	PacketPlayOut(final String name, final String prefix, final String suffix, final Collection<String> players,
			final int paramInt) throws ClassNotFoundException, IllegalAccessException, InstantiationException,
			NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
		this.packet = PacketPlayOut.packetType.newInstance();
		this.setField("a", name);
		this.setField("f", paramInt);
		if (paramInt == 0 || paramInt == 2) {
			this.setField("b", name);
			this.setField("c", prefix);
			this.setField("d", suffix);
			this.setField("g", 1);
		}
		if (paramInt == 0) {
			this.addAll(players);
		}
	}

	PacketPlayOut(final String name, Collection<String> players, final int paramInt)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException,
			NoSuchFieldException, InvocationTargetException {
		this.packet = PacketPlayOut.packetType.newInstance();
		if (paramInt != 3 && paramInt != 4) {
			throw new IllegalArgumentException("Method must be join or leave for player constructor");
		}
		if (players == null || players.isEmpty()) {
			players = new ArrayList<>();
		}
		this.setField("a", name);
		this.setField("f", paramInt);
		this.addAll(players);
	}

	public void sendToPlayer(final Player bukkitPlayer) throws ClassNotFoundException, IllegalAccessException,
			InstantiationException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
		final Object player = PacketPlayOut.getHandle.invoke(bukkitPlayer, new Object[0]);
		final Object connection = PacketPlayOut.playerConnection.get(player);
		PacketPlayOut.sendPacket.invoke(connection, this.packet);
	}

	private void setField(final String field, final Object value) throws NoSuchFieldException, IllegalAccessException {
		final Field f = this.packet.getClass().getDeclaredField(field);
		f.setAccessible(true);
		f.set(this.packet, value);
	}

	@SuppressWarnings("unchecked")
	private void addAll(final Collection<String> col) throws NoSuchFieldException, IllegalAccessException {
		final Field f = this.packet.getClass().getDeclaredField("e");
		f.setAccessible(true);
		((Collection<String>) f.get(this.packet)).addAll(col);
	}

	private static String getPacketTeamClasspath() {
		if (Integer.valueOf(PacketPlayOut.version.split("_")[1]) < 7
				&& Integer.valueOf(PacketPlayOut.version.toLowerCase().split("_")[0].replace("v", "")) == 1) {
			return "net.minecraft.server." + PacketPlayOut.version + ".Packet209SetScoreboardTeam";
		}
		return "net.minecraft.server." + PacketPlayOut.version + ".PacketPlayOutScoreboardTeam";
	}
}
