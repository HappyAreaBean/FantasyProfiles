package cc.happyareabean.fantasyprofiles.listener;

import cc.happyareabean.fantasyprofiles.manager.ProfileManager;
import cc.happyareabean.fantasyprofiles.utils.AsyncUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		AsyncUtils.runAsync(() -> new ProfileManager(player));
	}
}
