package me.cangasso.packets;

import org.bukkit.entity.Player;

public class SentPacket extends Packet {
	public SentPacket(final Object packet, final Cancellable cancel, final Player player) {
		super(packet, cancel, player);
	}
}
