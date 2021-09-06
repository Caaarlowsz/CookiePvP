package me.cangasso.packets;

import org.bukkit.entity.Player;

public class ReceivedPacket extends Packet {
	public ReceivedPacket(final Object packet, final Cancellable cancel, final Player player) {
		super(packet, cancel, player);
	}
}
