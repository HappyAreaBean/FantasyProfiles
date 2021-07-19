package cc.happyareabean.fantasyprofiles.listener;

import cc.happyareabean.fantasyprofiles.menu.ProfileMenu;
import cc.happyareabean.fantasyprofiles.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MainSettingsMenuListener implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		ItemStack item = e.getCurrentItem();
		if (item != null) {
			if (item.hasItemMeta()) {
				if (item.getItemMeta().hasDisplayName()) {
					if (e.getClickedInventory().getTitle().equalsIgnoreCase(Color.translate("&e&l設定"))) {
						e.setCancelled(true);
					}

					if (item.getItemMeta().getDisplayName().equalsIgnoreCase(Color.translate("&c&l返回"))) {
						player.openInventory(new ProfileMenu().build(player));
					}
				}
			}
		}
	}

}
