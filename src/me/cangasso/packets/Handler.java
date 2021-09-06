package me.cangasso.packets;

import org.bukkit.entity.Player;

public interface Handler {
	void addChannel(final Player p0);

	void removeChannel(final Player p0);

	void addServerConnectionChannel();
}
