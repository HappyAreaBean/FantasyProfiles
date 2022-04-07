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

package cc.happyareabean.fantasyprofiles.menu.impl;

import cc.happyareabean.fantasyprofiles.constant.MenuTitleConstant;
import cc.happyareabean.fantasyprofiles.menu.AbstractMenu;
import cc.happyareabean.fantasyprofiles.menu.SettingsNav;
import cc.happyareabean.fantasyprofiles.utils.menu.ServerSettingsUtils;
import org.bukkit.entity.Player;
import org.ipvp.canvas.Menu;
import org.ipvp.canvas.type.ChestMenu;

public class ServerSettingsMenu extends AbstractMenu {

	@Override
	public Menu build(Player player) {

		Menu.Builder<ChestMenu.Builder> menuBuilder = ChestMenu.builder(6).title(MenuTitleConstant.SERVER_SETTINGS);
		Menu menu = menuBuilder.build();

		ServerSettingsUtils.addSettingNavigation(menu, 0);

		menu.getSlot(4, 5).setItem(ServerSettingsUtils.comingSoon());
		menu.getSlot(6, 5).setSettings(ServerSettingsUtils.returnToProfile());

		return menu;
	}

	@Override
	public void display(Player player) {
		super.display(player, SettingsNav.SERVER_SETTINGS);
	}
}
