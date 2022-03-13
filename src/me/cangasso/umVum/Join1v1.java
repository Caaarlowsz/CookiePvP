package me.cangasso.umVum;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class Join1v1 implements Listener {
	private static Itens Item;
	public static ItemStack Item_;
	public static ItemStack Cinza;
	public static ItemStack Verde1;
	public static ItemStack Verde2;
	public static ItemStack Verde3;

	static {
		Join1v1.Item = new Itens();
		Join1v1.Item_ = Join1v1.Item.createItem(Material.BLAZE_ROD, "BLAZE_ROD",
				"�eDesafie um jogador! �8(bot\u00e3o direito)", new String[0], 1, (short) 0);
		Join1v1.Cinza = Join1v1.Item.createItem(Material.INK_SACK, "INK_SACK",
				"�eDuelo r\u00e1pido! �8(bot\u00e3o direito)", new String[0], 1, (short) 8);
		Join1v1.Verde1 = Join1v1.Item.createItem(Material.INK_SACK, "INK_SACK", "�eProcurando partidas", new String[0],
				1, (short) 10);
		Join1v1.Verde2 = Join1v1.Item.createItem(Material.INK_SACK, "INK_SACK", "�eProcurando partidas", new String[0],
				1, (short) 10);
		Join1v1.Verde3 = Join1v1.Item.createItem(Material.INK_SACK, "INK_SACK", "�eProcurando partidas", new String[0],
				1, (short) 10);
	}
}
