package cc.happyareabean.fantasyprofiles.menu;
import cc.happyareabean.fantasyprofiles.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.imanity.framework.bukkit.util.items.ItemBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainSettingsMenu {

	public Inventory build(Player player, Boolean backButton) {

		// Server Settings Item
		ItemStack serverSettings = new ItemBuilder(Material.REDSTONE_COMPARATOR).name("&b&l伺服器設定").lore("&7更改與伺服器有關的設置").build();

		// Auto scale inventory size
		List<ItemStack> itemList = new ArrayList<>();
		itemList.add(serverSettings);

		int size = 27;
		if (itemList.size() >= 7) {
			size = 9 * 4;
		} else if (itemList.size() >= 14) {
			size = 9 * 5;
		} else if (itemList.size() >= 21) {
			size = 9 * 6;
		}

		//Create a new inventory
		Inventory inv = Bukkit.createInventory(null, size, Color.translate("&e&l設定"));
		fillBorder(inv, backButton);

		// Get the empty slot and set the item (loop item list)
		for (int i = 0; i < itemList.size(); i++) {
			int empty = inv.firstEmpty();
			if (inv.getItem(empty) != null) {
				i--;
				empty++;
			} else {
				inv.setItem(empty, itemList.get(i));
				empty++;
			}
		}
		return inv;
	}

	/**
	 * Fill the inventory with glass pane border
	 * @param inv Inventory
	 * @param backButton enable back button or not
	 */
	private void fillBorder(Inventory inv, Boolean backButton) {
		for (int i = 0; i < inv.getSize(); i++) {
			if ((i <= 8) || (i >= (inv.getSize()) - 9) // bottom and top
					|| i == 9 || i == 18 // borders
					|| i == 27 || i == 36
					|| i == 17 || i == 26
					|| i == 35 || i == 44)
				inv.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE).name("&f").data(15).build());
			if (backButton && (i == (inv.getSize() - 9 + 4))) {
				inv.setItem(i, new ItemBuilder(Material.BARRIER).name("&c&l返回").build());
			}
		}
	}
}
