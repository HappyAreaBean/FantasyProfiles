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

import cc.happyareabean.fantasyprofiles.utils.menu.ServerSettingsUtils;
import cc.happyareabean.fantasyprofiles.utils.Utils;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.ipvp.canvas.Menu;
import org.ipvp.canvas.type.ChestMenu;

public abstract class AbstractMenu {

	@Getter private boolean returnButton = false;

	public Menu build(Player player) {
		Menu.Builder<ChestMenu.Builder> menuBuilder = ChestMenu.builder(6).title("AbstractMenu!");
		return menuBuilder.build();
	}

	public Menu build(Player player, boolean backButton) {
		return null;
	}

	public void setupReturnButton(Menu menu) {
		menu.getSlot(menu.getDimensions().getRows(), 5).setSettings(ServerSettingsUtils.returnToProfile());
	}

	public void display(Player player) {
		this.build(player).open(player);
	}

	public void display(Player player, SettingsNav settingsNav) {
		Menu menu = this.build(player);

		// Setup the SettingsNav
		menu.getSlot(settingsNav.getOrder()).setItem(settingsNav.getItem(true));
		menu.getSlot(2, settingsNav.getOrder() + 1).setItem(Utils.getGreenGlass());

		// If returnButton is true, then add the return button
		if (isReturnButton()) setupReturnButton(menu);

		menu.open(player);
	}

	public void display(Player player, boolean backButton) {
		this.build(player, backButton).open(player);
	}
}
