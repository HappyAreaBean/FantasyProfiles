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

package cc.happyareabean.fantasyprofiles.menu;

import cc.happyareabean.fantasyprofiles.api.FantasyProfilesAPI;
import cc.happyareabean.fantasyprofiles.api.SettingsNavItems;
import cc.happyareabean.fantasyprofiles.utils.Utils;
import cc.happyareabean.fantasyprofiles.utils.menu.ServerSettingsUtils;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.ipvp.canvas.Menu;
import org.ipvp.canvas.slot.SlotSettings;

public class SettingsMenu extends AbstractMenu implements SettingsNavItems {

	@Override
	public void display(Player player) {
		Menu menu = this.build(player);

		// Add navigation
		ServerSettingsUtils.addSettingNavigation(menu, 0);

		// Set up the Green Glass
		menu.getSlot(this.getOrder()).setItem(this.getItem(true));
		menu.getSlot(2, this.getOrder() + 1).setItem(Utils.getGreenGlass());

		// If returnButton is true, then add the return button
		if (isReturnButton()) setupReturnButton(menu);

		menu.open(player);
	}

	@Override
	public ItemStack getItem(boolean enchanted) {
		return null;
	}

	@Override
	public SlotSettings getSlotSettings() {
		return null;
	}

	@Override
	public int getOrder() {
		return SettingsNav.values().length + FantasyProfilesAPI.getMenuList().size() - 1;
	}
}
