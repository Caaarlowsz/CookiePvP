package me.cangasso.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class ColorSigns implements Listener {
	@EventHandler
	public void aoEscrever(final SignChangeEvent e) {
		if (e.getLine(0).contains("&")) {
			e.setLine(0, e.getLine(0).replace("&", "§"));
		}
		if (e.getLine(1).contains("&")) {
			e.setLine(1, e.getLine(1).replace("&", "§"));
		}
		if (e.getLine(2).contains("&")) {
			e.setLine(2, e.getLine(2).replace("&", "§"));
		}
		if (e.getLine(3).contains("&")) {
			e.setLine(3, e.getLine(3).replace("&", "§"));
		}
	}
}
