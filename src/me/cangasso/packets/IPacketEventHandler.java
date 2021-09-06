package me.cangasso.packets;

import org.bukkit.entity.Player;

public interface IPacketEventHandler {
	Object onPacketReceive(final Player p0, final Object p1, final Cancellable p2);

	Object onPacketSend(final Player p0, final Object p1, final Cancellable p2);
}
