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

package cc.happyareabean.fantasyprofiles.listener;

import cc.happyareabean.fantasyprofiles.menu.impl.ServerSettingsMenu;
import cc.happyareabean.fantasyprofiles.utils.Color;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ProfileMenuListener implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		ItemStack item = e.getCurrentItem();
		if (item != null && item.getItemMeta() != null && item.getItemMeta().getDisplayName() != null) {
			if (e.getClickedInventory().getTitle().equalsIgnoreCase(Color.translate("&b&l我的個人檔案"))) {
				e.setCancelled(true);
				NBTItem nbti = new NBTItem(item);
				if (nbti.hasKey("fantasyprofile")) {
					if (nbti.getString("fantasyprofile").equalsIgnoreCase("settings")) {
						new ServerSettingsMenu().display(player);
					}

					if (item.getType() == Material.SKULL_ITEM && item.getDurability() == 3 && nbti.getString("fantasyprofile").equalsIgnoreCase("playerinfo")) {
						player.closeInventory();
						player.performCommand("bstore");
					}
				}
			}
		}
	}

}
