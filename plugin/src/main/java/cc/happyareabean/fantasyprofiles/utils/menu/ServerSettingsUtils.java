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

package cc.happyareabean.fantasyprofiles.utils.menu;

import cc.happyareabean.fantasyprofiles.api.FantasyProfilesAPI;
import cc.happyareabean.fantasyprofiles.menu.SettingsMenu;
import cc.happyareabean.fantasyprofiles.menu.SettingsNav;
import cc.happyareabean.fantasyprofiles.menu.impl.ChatSettingsMenu;
import cc.happyareabean.fantasyprofiles.menu.impl.ProfileMenu;
import cc.happyareabean.fantasyprofiles.utils.Debug;
import cc.happyareabean.fantasyprofiles.utils.ItemBuilder;
import cc.happyareabean.fantasyprofiles.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.ipvp.canvas.Menu;
import org.ipvp.canvas.mask.BinaryMask;
import org.ipvp.canvas.slot.Slot;
import org.ipvp.canvas.slot.SlotSettings;
import org.mineacademy.chatcontrol.PlayerCache;
import org.mineacademy.chatcontrol.api.ChatControlAPI;
import org.mineacademy.chatcontrol.model.Toggle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServerSettingsUtils {

	public static void addSettingNavigation(Menu menu, int startingIndex) {
		Class<ChatSettingsMenu> targetClass = ChatSettingsMenu.class;

		int currentIndex = startingIndex; // Assign local variables
		Debug.message("Starting Navigation.");
		long started = System.currentTimeMillis();
		List<SlotSettings> settingsNav = Arrays.stream(SettingsNav.values())
				.map(SettingsNav::getSlotSettings)
				.collect(Collectors.toList()); // Get all the SlotSettings from SettingsNav and turn it into a list.
		Debug.message(FantasyProfilesAPI.getMenuList().size() + "");
		settingsNav.addAll(FantasyProfilesAPI.getMenuList().stream().map(SettingsMenu::getSlotSettings).collect(Collectors.toList())); // Add the SlotSettings from the API (If any)
		for (SlotSettings selectedSlot : settingsNav) {
			menu.getSlot(currentIndex).setSettings(selectedSlot);
			++currentIndex;
		}
		BinaryMask.builder(menu).item(Utils.getBorderGlass()).pattern("000000000").pattern("111111111").build().apply(menu);
		long finish = System.currentTimeMillis();
		Debug.message("Used " + (finish - started) + "ms.");
	}

	public static void addClickToggle(Menu menu, Slot slot, Toggle toggle) {
		slot.setClickHandler((player, clickHandler) -> {
			PlayerCache cache = ChatControlAPI.getPlayerCache(player);
			boolean ignorePM = cache.isIgnoringPart(toggle);
			cache.setIgnoredPart(toggle, !ignorePM);
			menu.update(player);
		});
	}

	public static void addToggleButton(Menu menu, Slot icon, Slot button, ItemStack iconItemStack, Toggle toggle) {
		ItemMeta iconMeta = iconItemStack.getItemMeta();
		String iconName = iconMeta.getDisplayName();
		icon.setItemTemplate(p -> {
			PlayerCache cache = ChatControlAPI.getPlayerCache(p);
			boolean booleanValue = !cache.isIgnoringPart(toggle);
			return new ItemBuilder(iconItemStack.getType())
					.name(Utils.parseColor(booleanValue) + iconName)
					.lore(iconMeta.getLore())
					.build();
		});
		button.setItemTemplate(p -> {
			PlayerCache cache = ChatControlAPI.getPlayerCache(p);
			boolean booleanValue = !cache.isIgnoringPart(toggle);
			return new ItemBuilder(Material.INK_SACK)
					.data(booleanValue ? 10 : 8)
					.name(Utils.parseColor(booleanValue) + iconName)
					.lore("&7點擊" + Utils.parseBoolean(!booleanValue) + "!")
					.build();
		});
		addClickToggle(menu, icon, toggle);
		addClickToggle(menu, button, toggle);
	}

	public static SlotSettings returnToProfile() {
		return SlotSettings.builder()
				.item(new ItemBuilder(Material.ARROW).name("&c返回")
						.lore("&7點擊返回個人檔案")
						.build())
				.clickHandler((playerClicked, info) -> new ProfileMenu().display(playerClicked)).build();
	}

	public static ItemStack comingSoon() {
		return new ItemBuilder(Material.INK_SACK).data(8).name("&c即將推出!").lore("&7更多設定很快就會推出，敬請期待！").build();
	}
}