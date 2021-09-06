package me.cangasso.anticheat.hacks;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.cangasso.anticheat.Utills;

public class AutoSoup implements Listener {
	private static HashMap<UUID, Long> JogadorSendoAtacado;

	static {
		AutoSoup.JogadorSendoAtacado = new HashMap<UUID, Long>();
	}

	@EventHandler
	public void onSoup(final PlayerInteractEvent e) {
		final Damageable hp;
		final Player p = (Player) (hp = (Damageable) e.getPlayer());
		if (hp.getHealth() != 20.0) {
			final int sopa = 7;
			if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
					&& p.getItemInHand().getTypeId() == 282) {
				p.setHealth((hp.getHealth() + sopa > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + sopa));
				p.getItemInHand().setType(Material.BOWL);
			}
		}
	}

	@EventHandler
	private void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
		if (!(event.getDamager() instanceof Player)) {
			return;
		}
		final Player player = (Player) event.getDamager();
		SetarAtacandoTempo(player.getUniqueId());
	}

	@EventHandler
	public void onInventoryInteract(final InventoryClickEvent Evento) {
		final Player Jogador = (Player) Evento.getWhoClicked();
		if (!(Evento.getWhoClicked() instanceof Player)) {
			return;
		}
		if (Evento.isCancelled()) {
			return;
		}
		if (Evento.getAction() != InventoryAction.MOVE_TO_OTHER_INVENTORY) {
			return;
		}
		if (Evento.getSlot() == -1) {
			return;
		}
		final long Tempo = System.currentTimeMillis() - PegarAtacandoTempo(Jogador.getUniqueId());
		int Botes = 0;
		ItemStack[] ItemStacks;
		for (int ASoup = (ItemStacks = Jogador.getInventory().getContents()).length, i = 0; i < ASoup; ++i) {
			final ItemStack ItemStack = ItemStacks[i];
			if (ItemStack != null && ItemStack.getType() == Material.BOWL) {
				Botes += ItemStack.getAmount();
			}
		}
		if (Tempo >= 99L) {
			return;
		}
		if (Botes < 5) {
			return;
		}
		final Utills.Hack AutoSoupTalvez = Utills.Hack.AUTOSOUPTALVEZ;
		final Utills.Hack AutoSoupProvavelmente = Utills.Hack.AUTOSOUPPROVAVELMENTE;
		final Utills.Hack AutoSoupDefinitivamente = Utills.Hack.AUTOSOUPDEFINITIVAMENTE;
		if (Tempo < 30L) {
			Utills.AutoSoup = AutoSoupTalvez.getMenssagem().replace("nick", Jogador.getName()).replace("avisos",
					new StringBuilder().append(Utills.AvisosAutoSoup.get(Jogador)).toString());
			if (Utills.AutoSoup != null) {
				Utills.AvisosAutoSoup.put(Jogador, Utills.AvisosAutoSoup.get(Jogador) + 1);
				Utills.sendAntiCheat(Utills.AutoSoup);
			}
			Utills.AutoSoup = null;
		} else if (Tempo < 60L) {
			Utills.AutoSoup = AutoSoupProvavelmente.getMenssagem().replace("nick", Jogador.getName()).replace("avisos",
					new StringBuilder().append(Utills.AvisosAutoSoup.get(Jogador)).toString());
			if (Utills.AutoSoup != null) {
				Utills.AvisosAutoSoup.put(Jogador, Utills.AvisosAutoSoup.get(Jogador) + 1);
				Utills.sendAntiCheat(Utills.AutoSoup);
			}
			Utills.AutoSoup = null;
		} else if (Tempo < 99L) {
			Utills.AutoSoup = AutoSoupDefinitivamente.getMenssagem().replace("nick", Jogador.getName())
					.replace("avisos", new StringBuilder().append(Utills.AvisosAutoSoup.get(Jogador)).toString());
			if (Utills.AutoSoup != null) {
				Utills.AvisosAutoSoup.put(Jogador, Utills.AvisosAutoSoup.get(Jogador) + 1);
				Utills.sendAntiCheat(Utills.AutoSoup);
			}
			Utills.AutoSoup = null;
		}
	}

	public static long PegarAtacandoTempo(final UUID uuid) {
		if (!AutoSoup.JogadorSendoAtacado.containsKey(uuid)) {
			AutoSoup.JogadorSendoAtacado.put(uuid, System.currentTimeMillis() / 1000L);
		}
		return AutoSoup.JogadorSendoAtacado.get(uuid);
	}

	public static void SetarAtacandoTempo(final UUID uuid) {
		AutoSoup.JogadorSendoAtacado.put(uuid, System.currentTimeMillis());
	}
}
