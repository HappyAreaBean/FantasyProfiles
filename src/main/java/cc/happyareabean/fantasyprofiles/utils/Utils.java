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

package cc.happyareabean.fantasyprofiles.utils;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.imanity.framework.bukkit.util.items.ItemBuilder;

public class Utils {

	/**
	 * Fill the inventory with glass pane border
	 * @param inv Inventory
	 * @param backButton enable back button or not
	 */
	public static void fillBorder(Inventory inv, Boolean backButton) {
		for (int i = 0; i < inv.getSize(); i++) {
			if ((i <= 8) || (i >= (inv.getSize()) - 9) // bottom and top
					|| i == 9 || i == 18 // borders
					|| i == 27 || i == 36
					|| i == 17 || i == 26
					|| i == 35 || i == 44)
				inv.setItem(i, new org.imanity.framework.bukkit.util.items.ItemBuilder(Material.STAINED_GLASS_PANE).name("&f").data(15).build());
			if (backButton && (i == (inv.getSize() - 9 + 4))) {
				inv.setItem(i, new ItemBuilder(Material.BARRIER).name("&c&l返回").build());
			}
		}
	}

	/**
	 * Fill the inventory empty slot with glass pane
	 * @param inv Inventory
	 */
	public static void fillEmpty(Inventory inv) {
		for (int i = 0; i < inv.getSize(); i++) {
			if (inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR) {
				inv.setItem(i, new cc.happyareabean.fantasyprofiles.utils.ItemBuilder(Material.STAINED_GLASS_PANE).name("&f").data(15).build());
			}
		}
	}

}
