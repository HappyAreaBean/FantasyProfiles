/*
 * Copyright (c) 2021 HappyAreaBean
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cc.happyareabean.fantasyprofiles.menu;
import cc.happyareabean.fantasyprofiles.utils.Color;
import cc.happyareabean.fantasyprofiles.utils.Utils;
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
		Utils.fillBorder(inv, backButton);

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
}
