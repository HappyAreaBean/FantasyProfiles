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

package cc.happyareabean.fantasyprofiles.menu;
import cc.happyareabean.fantasyprofiles.utils.Color;
import cc.happyareabean.fantasyprofiles.utils.Utils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import cc.happyareabean.fantasyprofiles.utils.ItemBuilder;

import java.util.Arrays;


public class ProfileMenu {

	Inventory inv = Bukkit.createInventory(null, 27, Color.translate("&b&l我的個人檔案"));

	public Inventory build(Player player) {
		Utils.fillEmpty(inv);

		ItemStack playerhead = new ItemBuilder(Material.SKULL_ITEM)
				.name(PlaceholderAPI.setPlaceholders(player, "%luckperms_prefix%" + player.getName()))
				.lore(PlaceholderAPI.setPlaceholders(player, Arrays.asList(
					"&7階級 &8» %luckperms_primary_group_name%",
					"",
					"&e點擊獲取商店連結!"
				)))
				.data(3)
				.tag("playerinfo","fantasyprofile")
				.skull(player.getName())
				.build();

		ItemStack mail = new ItemBuilder(Material.SKULL_ITEM)
				.name("&c&l信箱")
				.lore(Arrays.asList(
						"&7查看更新變更日誌, 幻想領域的社交媒體鏈接等等!",
						"",
						"&e點擊打開信箱!"
				))
				.data(3)
				.tag("mailman","fantasyprofile")
				.skullTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDIzZjY1MmNkNTNhNjIxZjY4ODAxZmFhN2FkNzIyNjFlNjBlY2I0N2IyNTUxN2ZjMTdlODg0YzI0YjhlNzlmOSJ9fX0=")
				.build();

		ItemStack settings = new ItemBuilder(Material.WATCH)
				.name("&e&l設定")
				.lore(Arrays.asList(
						"&7查看和編輯你在幻想領域上的體驗",
						"",
						"&e點擊更改你的喜好!"
				))
				.tag("settings","fantasyprofile")
				.build();

		inv.setItem(4, playerhead);
		inv.setItem(10, mail);
		inv.setItem(16, settings);

		return inv;
	}
}
