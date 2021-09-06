package me.cangasso.umVum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Itens {
	public static HashMap<ItemStack, String> items;

	static {
		Itens.items = new HashMap<ItemStack, String>();
	}

	public ItemStack createItem(final Material m, final String id, final String displayName, final String[] lore,
			final int amount, final short data) {
		final ItemStack item = new ItemStack(m, amount, data);
		final ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayName);
		final ArrayList<String> l = new ArrayList<>();
		if (lore != null) {
			for (int i = 0; i < lore.length; ++i) {
				l.add(lore[i]);
			}
		}
		meta.setLore(l);
		item.setItemMeta(meta);
		if (Itens.items.containsKey(item)) {
			Itens.items.remove(item);
		}
		Itens.items.put(item, id);
		return item;
	}

	public HashMap<ItemStack, String> getItems() {
		return Itens.items;
	}

	public ItemStack getItemByID(final String id) {
		if (this.getItems().containsValue(id)) {
			for (final Map.Entry<ItemStack, String> en : Itens.items.entrySet()) {
				if (en.getValue().equals(id)) {
					return en.getKey();
				}
			}
		}
		return null;
	}
}
