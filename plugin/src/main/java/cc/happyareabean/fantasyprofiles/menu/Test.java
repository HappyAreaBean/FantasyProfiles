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

import cc.happyareabean.fantasyprofiles.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.ipvp.canvas.Menu;
import org.ipvp.canvas.slot.SlotSettings;

public class Test extends SettingsMenu {

	@Override
	public Menu build(Player player) {
		return super.build(player);
	}

	@Override
	public ItemStack getItem(boolean enchanted) {
		return Utils.buildNavigator(Material.SIGN, "&bPractice Settings", "Customize your practice experience", enchanted);
	}

	@Override
	public SlotSettings getSlotSettings() {
		return SlotSettings.builder().item(getItem(false)).clickHandler((player, info) -> new Test().display(player)).build();
	}

	@Override
	public boolean isReturnButton() {
		return true;
	}
}
