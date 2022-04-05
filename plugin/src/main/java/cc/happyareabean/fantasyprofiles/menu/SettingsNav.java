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

import cc.happyareabean.fantasyprofiles.menu.impl.ChatSettingsMenu;
import cc.happyareabean.fantasyprofiles.menu.impl.ServerSettingsMenu;
import cc.happyareabean.fantasyprofiles.utils.Utils;
import cc.happyareabean.fantasyprofiles.api.SettingsNavItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.ipvp.canvas.slot.SlotSettings;

public enum SettingsNav implements SettingsNavItems {

	SERVER_SETTINGS {
		@Override
		public ItemStack getItem(boolean enchanted) {
			return Utils.buildNavigator(Material.REDSTONE_COMPARATOR, "&b&l伺服器設定", "更改與伺服器有關的設置", enchanted);
		}

		@Override
		public SlotSettings getSlotSettings() {
			return SlotSettings.builder().item(getItem(false)).clickHandler((player, info) -> new ServerSettingsMenu().display(player)).build();
		}

		@Override
		public int getOrder() {
			return 0;
		}
	},

	CHAT_SETTINGS {
		@Override
		public ItemStack getItem(boolean enchanted) {
			return Utils.buildNavigator(Material.BOOK_AND_QUILL, "&c&l聊天設定", "管理你自己的聊天室!", enchanted);
		}

		@Override
		public SlotSettings getSlotSettings() {
			return SlotSettings.builder().item(getItem(false)).clickHandler((player, info) -> new ChatSettingsMenu().display(player)).build();
		}

		@Override
		public int getOrder() {
			return 1;
		}
	};

}
