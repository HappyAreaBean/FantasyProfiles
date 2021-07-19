package cc.happyareabean.fantasyprofiles.listener;

import cc.happyareabean.fantasyprofiles.menu.MainSettingsMenu;
import cc.happyareabean.fantasyprofiles.utils.Color;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.imanity.framework.bukkit.util.nms.NBTEditor;

public class ProfileMenuListener implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		ItemStack item = e.getCurrentItem();
		if (e.getCurrentItem() != null && e.getCurrentItem().getItemMeta() != null && e.getCurrentItem().getItemMeta().getDisplayName() != null) {
			if (e.getClickedInventory().getTitle().equalsIgnoreCase(Color.translate("&b&l我的個人檔案"))) {
				e.setCancelled(true);
				if (NBTEditor.getString(item, "fantasyprofile") != null) {
					if (NBTEditor.getString(item, "fantasyprofile").equalsIgnoreCase("settings")) {
						player.openInventory(new MainSettingsMenu().build(player, true));
					}

					if (item.getType() == Material.SKULL_ITEM && item.getDurability() == 3 && NBTEditor.getString(item, "fantasyprofile").equalsIgnoreCase("playerinfo")) {
						player.closeInventory();
						player.performCommand("bstore");
					}
				}
			}
		}
	}

}
