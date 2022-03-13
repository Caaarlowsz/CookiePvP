package me.cangasso.menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.cangasso.API.PadraoAPI;
import me.cangasso.configuração.cfConfig;
import me.cangasso.configuração.cfPermissão;
import me.cangasso.configuração.cfStatus;

public class CliqueInventory implements Listener {
	@EventHandler
	public void clickartodoskits(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("�7\u27b3 �9�lTODOS OS KITS �8(p\u00e1g. 1)")
				&& e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �a�lSEUS KITS")) {
				e.setCancelled(true);
				KitsMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �2�lLOJA DE KITS")) {
				e.setCancelled(true);
				LojaMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �3�lKIT PADRAO")) {
				e.setCancelled(true);
				PadraoMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �a�lPROXIMA PAGINA")) {
				e.setCancelled(true);
				TodosKits2Menu.inventory(p);
			}
		}
	}

	@EventHandler
	public void clickartodoskits2(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("�7\u27b3 �9�lTODOS OS KITS �8(p\u00e1g. 2)")
				&& e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �a�lSEUS KITS")) {
				e.setCancelled(true);
				KitsMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �2�lLOJA DE KITS")) {
				e.setCancelled(true);
				LojaMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �3�lKIT PADRAO")) {
				e.setCancelled(true);
				PadraoMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �c�lPAGINA ANTERIOR")) {
				e.setCancelled(true);
				TodosKitsMenu.inventory(p);
			}
		}
	}

	@EventHandler
	public void clickarlojavips(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("�aQual {VIP} deseja?") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6Cookie�fNetwork�7] �f- �a�lVIP")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("�6�lCookie�f�lNetwork �7� �fAcesse nossa loja: �6�lmc-cookie.com.br");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6Cookie�fNetwork�7] �f- �9�lMVP")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("�6�lCookie�f�lNetwork �7� �fAcesse nossa loja: �6�lmc-cookie.com.br");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6Cookie�fNetwork�7] �f- �6�lPRO")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("�6�lCookie�f�lNetwork �7� �fAcesse nossa loja: �6�lmc-cookie.com.br");
			}
		}
	}

	@EventHandler
	public void clickarwarps(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("�7\u27b3 �6�lWARPS") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�6�lFPS")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp fps");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�6�l1V1")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp 1v1");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�6�lKNOCKBACK")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp knockback");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�6�lMAIN")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp main");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�6�lFISHERMAN")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp fisherman");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�6�lMLG")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("�cEsta warp est\u00e1 em manutenção.");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�c�lEM BREVE")) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("�cEm breve...");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�6�lCookie�lNetwork")) {
				e.setCancelled(true);
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�6�lLAVACHALLENGE")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/warp challenge");
			}
		}
	}

	@EventHandler
	public void clickarloja2(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("�7\u27b3 �2�lLOJA DE KITS �8(p\u00e1g. 2)")
				&& e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �a�lSEUS KITS")) {
				e.setCancelled(true);
				KitsMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �9�lTODOS OS KITS")) {
				e.setCancelled(true);
				TodosKitsMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �3�lKIT PADRAO")) {
				e.setCancelled(true);
				PadraoMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �c�lPAGINA ANTERIOR")) {
				e.setCancelled(true);
				LojaMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6�lStrong�7] �f- �7Valor: �9�l30.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 30000) {
					p.sendMessage("�4�l(!) �cVoc\u00ea não possui XP o suficiente para finalizar a compra.");
				} else {
					cfPermissão.setarPermissao(p, "kit.strong", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Strong!");
					cfStatus.RemoveMoney(p, 30000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6�Forcefield�7] �f- �7Valor: �9�l20.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 20000) {
					p.sendMessage(
							"�6�lNew�f�lPvP �6� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.forcefield", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Forcefield");
					cfStatus.RemoveMoney(p, 20000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6�Sumo�7] �f- �7Valor: �9�l15.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 15000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.sumo", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Sumo");
					cfStatus.RemoveMoney(p, 15000);
				}
				p.closeInventory();
			}
		}
	}

	@EventHandler
	public void clickarloja(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("�7\u27b3 �9�lTODOS OS KITS �8(p\u00e1g. 1)")
				&& e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �a�lSEUS KITS")) {
				e.setCancelled(true);
				KitsMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �9�lTODOS OS KITS")) {
				e.setCancelled(true);
				TodosKitsMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �3�lKIT PADRAO")) {
				e.setCancelled(true);
				PadraoMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �c�lPAGINA ANTERIOR")) {
				e.setCancelled(true);
				Loja2Menu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6�Monk�7] �f- �7Valor: �9�l15.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 15000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.monk", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Monk");
					cfStatus.RemoveMoney(p, 15000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6�Ninja�7] �f- �7Valor: �9�l17.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 17000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.ninja", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Ninja");
					cfStatus.RemoveMoney(p, 17000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6�Phantom�7] �f- �7Valor: �9�l15.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 15000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.phantom", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Phantom");
					cfStatus.RemoveMoney(p, 15000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6�Grappler�7] �f- �7Valor: �9�l17.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 17000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.grappler", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Grappler");
					cfStatus.RemoveMoney(p, 17000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6�Viper�7] �f- �7Valor: �9�l10.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 10000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.viper", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Viper");
					cfStatus.RemoveMoney(p, 10000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6�Snail�7] �f- �7Valor: �9�l10.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 10000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.snail", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Snail");
					cfStatus.RemoveMoney(p, 10000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6�Hulk�7] �f- �7Valor: �9�l15.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 15000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.hulk", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Hulk");
					cfStatus.RemoveMoney(p, 15000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6��7] �f- �7Valor: �9�l15.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 15000) {
					p.sendMessage(
							"�6�lNew�f�lPvP �6� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.timelord", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Timelord");
					cfStatus.RemoveMoney(p, 15000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�cThor �c�l15.000")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 15000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.thor", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Thor");
					cfStatus.RemoveMoney(p, 15000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6�l�7] �f- �7Valor: �9�l10.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 10000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.switcher", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Switcher");
					cfStatus.RemoveMoney(p, 10000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6�lGladiator�7] �f- �7Valor: �9�l30.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 30000) {
					p.sendMessage(
							"�6�lNew�f�lPvP �6� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.gladiator", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Gladiator");
					cfStatus.RemoveMoney(p, 30000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6�lEndermage�7] �f- �7Valor: �9�l17.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 17000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.endermage", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Endermage");
					cfStatus.RemoveMoney(p, 17000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�cStomper �c�l35.000")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 35000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.stomper", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Stomper");
					cfStatus.RemoveMoney(p, 35000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName()
					.equalsIgnoreCase("�7[�6��7] �f- �7Valor: �9�l17.000XP")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 17000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.magma", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Magma");
					cfStatus.RemoveMoney(p, 17000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�cGrandpa �c�l10.000")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 10000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.grandpa", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Grandpa");
					cfStatus.RemoveMoney(p, 10000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�cAjnin �c�l20.000")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 20000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.ajnin", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Ajnin");
					cfStatus.RemoveMoney(p, 20000);
				}
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�cFireLauncher �c�l15.000")) {
				e.setCancelled(true);
				if (cfStatus.getMoney(p) < 15000) {
					p.sendMessage(
							"�6�lCookie�f�lNetwork �7� �7Voc\u00ea não possui coins suficientes para comprar esse kit.");
				} else {
					cfPermissão.setarPermissao(p, "kit.firelauncher", "true");
					p.sendMessage("�a�l(!) �aVoc\u00ea comprou o kit Firelauncher");
					cfStatus.RemoveMoney(p, 15000);
				}
				p.closeInventory();
			}
		}
	}

	@EventHandler
	public void clickarkits2(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("�7\u27b3 �a�lSEUS KITS �8(p\u00e1g. 2)") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �9�lTODOS OS KITS")) {
				e.setCancelled(true);
				TodosKitsMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �3�lKIT PADRAO")) {
				e.setCancelled(true);
				PadraoMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �2�lLOJA DE KITS")) {
				e.setCancelled(true);
				LojaMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �c�lPAGINA ANTERIOR")) {
				e.setCancelled(true);
				KitsMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATCH) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit strong");
				return;
			}
			if (e.getCurrentItem().getType() == Material.APPLE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit sumo");
			}
		}
	}

	@EventHandler
	public void clickarkits(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("�7\u27b3 �a�lSEUS KITS �8(p\u00e1g. 1)") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �9�lTODOS OS KITS")) {
				e.setCancelled(true);
				TodosKitsMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �3�lKIT PADRAO")) {
				e.setCancelled(true);
				PadraoMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �2�lLOJA DE KITS")) {
				e.setCancelled(true);
				LojaMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �a�lPROXIMA PAGINA")) {
				e.setCancelled(true);
				Kits2Menu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getType() == Material.STONE_SWORD) {
				e.setCancelled(true);
				p.chat("/kit pvp");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.BOW) {
				e.setCancelled(true);
				p.chat("/kit archer");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREWORK) {
				e.setCancelled(true);
				p.chat("/kit kangaroo");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
				e.setCancelled(true);
				p.chat("/kit fisherman");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.CACTUS) {
				e.setCancelled(true);
				p.chat("/kit cactus");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				e.setCancelled(true);
				p.chat("/kit monk");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.COMPASS) {
				e.setCancelled(true);
				p.chat("/kit ninja");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.FEATHER) {
				e.setCancelled(true);
				p.chat("/kit phantom");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEASH) {
				e.setCancelled(true);
				p.chat("/kit grappler");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.SPIDER_EYE) {
				e.setCancelled(true);
				p.chat("/kit viper");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.STRING) {
				e.setCancelled(true);
				p.chat("/kit snail");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.SADDLE) {
				e.setCancelled(true);
				p.chat("/kit hulk");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATCH) {
				e.setCancelled(true);
				p.chat("/kit timelord");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.WOOD_AXE) {
				e.setCancelled(true);
				p.chat("/kit thor");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
				e.setCancelled(true);
				p.chat("/kit switcher");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
				e.setCancelled(true);
				p.chat("/kit gladiator");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aEndermage")) {
				e.setCancelled(true);
				p.chat("/kit endermage");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_BOOTS) {
				e.setCancelled(true);
				p.chat("/kit stomper");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIRE) {
				e.setCancelled(true);
				p.chat("/kit magma");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.STICK) {
				e.setCancelled(true);
				p.chat("/kit grandpa");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
				e.setCancelled(true);
				p.chat("/kit ajnin");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREBALL) {
				e.setCancelled(true);
				p.chat("/kit firelauncher");
				p.closeInventory();
			}
		}
	}

	@EventHandler
	public void clickarkitspadrao2(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("�7\u27b3 �3�lKIT PADRAO �8(p\u00e1g. 2)") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�c�lVOLTAR")) {
				e.setCancelled(true);
				KitsMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �c�lPAGINA ANTERIOR")) {
				e.setCancelled(true);
				PadraoMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aStrong")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Strong");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aForcefield")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Forcefield");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aSumo")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Sumo");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
			}
		}
	}

	@EventHandler
	public void clickarkitspadrao(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("�7\u27b3 �3�lKIT PADRAO �8(p\u00e1g. 1)") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�c�lVOLTAR")) {
				e.setCancelled(true);
				KitsMenu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7\u27b3 �a�lPROXIMA PAGINA")) {
				e.setCancelled(true);
				Padrao2Menu.inventory(p);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aPvP")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "PvP");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aArcher")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Archer");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aKangaroo")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Kangaroo");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aFisherman")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Fisherman");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aCactus")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Cactus");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aMonk")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Monk");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aNinja")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Ninja");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aPhantom")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Phantom");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aGrappler")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Grappler");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aViper")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Viper");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aSnail")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Snail");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aHulk")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Hulk");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aTimelord")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Timelord");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aThor")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Thor");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aSwitcher")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Switcher");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aGladiator")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Gladiator");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aEndermage")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Endermage");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aStomper")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Stomper");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aMagma")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Magma");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aGrandpa")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Grandpa");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aAjnin")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "Ajnin");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aFireLauncher")) {
				e.setCancelled(true);
				PadraoAPI.setKit(p, "FireLauncher");
				p.sendMessage("�7Agora seu kit padrão \u00e9 �6"
						+ cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit"));
				p.closeInventory();
			}
		}
	}
}
