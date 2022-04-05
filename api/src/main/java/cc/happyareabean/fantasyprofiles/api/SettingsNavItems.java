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

package cc.happyareabean.fantasyprofiles.api;

import org.bukkit.inventory.ItemStack;
import org.ipvp.canvas.slot.SlotSettings;

public interface SettingsNavItems {

	/**
	 * The item will show in the navigation
	 *
	 * @param enchanted Is the item will be enchanted
	 * @return {@link ItemStack}
	 */
	ItemStack getItem(boolean enchanted);

	/**
	 * The SlotSettings for this navigation item.
	 * @return {@link SlotSettings} This navigation item's slot setting
	 */
	SlotSettings getSlotSettings();

	/**
	 * The order number
	 * @return The order number.
	 */
	int getOrder();

}
