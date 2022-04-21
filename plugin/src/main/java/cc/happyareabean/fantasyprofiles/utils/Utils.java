/*
 * Copyright (c) 2022 HappyAreaBean
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

import cc.happyareabean.fantasyprofiles.FantasyProfiles;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.ipvp.canvas.Menu;
import org.ipvp.canvas.mask.BinaryMask;

public class Utils {

	public static ItemStack getBorderGlass() {
		return new ItemBuilder(Material.STAINED_GLASS_PANE).name("&f").data(15).build();
	}

	public static ItemStack getGreenGlass() {
		return new ItemBuilder(Material.STAINED_GLASS_PANE).name("&f").data(5).build();
	}

	public static String parseBoolean(boolean value) {
		return value ? "啟用" : "停用";
	}

	public static String parseColor(boolean value) {
		return Color.translate(value ? "&a" : "&c");
	}

	public static boolean isChatEnabled() {
		return FantasyProfiles.getInstance().isChatPluginLoaded();
	}

	/**
	 * Quick way to build a navigation item.
	 * @param name The item name
	 * @param lore The lore (default have &7 at the start)
	 * @param enchanted Is this item will be enchanted?
	 * @return ItemStack built from the builder
	 */
	public static ItemStack buildNavigator(Material material, String name, String lore, boolean enchanted) {
		ItemBuilder itemBuilder = new ItemBuilder(material).name(name).lore("&7" + lore).itemFlag(ItemFlag.HIDE_ATTRIBUTES);
		if (enchanted) itemBuilder.shiny();
		return itemBuilder.build();
	}

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
				inv.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE).name("&f").data(15).build());
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
				inv.setItem(i, new ItemBuilder(Material.STAINED_GLASS_PANE).name("&f").data(15).build());
			}
		}
	}

	/**
	 * Fill the inventory empty slot with glass pane
	 * @param menu the menu
	 */
	public static void fillEmpty(Menu menu) {
		BinaryMask.Builder mask = BinaryMask.builder(menu).item(new ItemBuilder(Material.STAINED_GLASS_PANE).name("&f").data(15).build());
		for (int i = 0; i < menu.getDimensions().getRows(); i++) {
			mask.pattern("111111111");
		}
		mask.build().apply(menu);
	}

	/**
	 * Fill the inventory empty slot with glass pane
	 * @param menu the menu
	 */
	public static void fillBorder(Menu menu) {
		BinaryMask.Builder mask = BinaryMask.builder(menu).item(new ItemBuilder(Material.STAINED_GLASS_PANE).name("&f").data(15).build());
		for (int i = 0; i < menu.getDimensions().getRows(); i++) {
			if (i == 0 || i + 1 == menu.getDimensions().getRows()) {
				mask.pattern("111111111");
			} else {
				mask.pattern("100000001");
			}
		}
		mask.build().apply(menu);
	}

}
