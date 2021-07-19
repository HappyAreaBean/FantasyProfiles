package cc.happyareabean.fantasyprofiles.commands;

import cc.happyareabean.fantasyprofiles.menu.MainSettingsMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SettingsCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {

		Player player = (Player) sender;
		player.openInventory(new MainSettingsMenu().build(player, false));

		return false;
	}
}
