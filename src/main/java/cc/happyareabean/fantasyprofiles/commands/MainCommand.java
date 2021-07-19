package cc.happyareabean.fantasyprofiles.commands;

import cc.happyareabean.fantasyprofiles.FantasyProfiles;
import cc.happyareabean.fantasyprofiles.utils.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class MainCommand implements CommandExecutor {

	private String version = FantasyProfiles.getInstance().getDescription().getVersion();
	private String name = FantasyProfiles.getInstance().getDescription().getName();
	private String prefix = FantasyProfiles.getInstance().getConfig().getString("prefix");

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
		if (!sender.hasPermission("fantasyprofiles.admin")) {
			about(sender);
			return true;
		}

		if (args.length == 0) {
			String cmdname = Color.translate("&e/" + cmd.getName() + " ");
			sender.sendMessage(Color.translate("&8&m----------------------------------------"));
			sender.sendMessage(Color.translate(" &b&l" + name + " &f(v" + version + ") &fMade With &4❤ &fBy HappyAreaBean"));
			sender.sendMessage("");
			sender.sendMessage(Color.translate("  &f對於參數, &6<> &f表示必需, &2[] &f表示可選"));
			sender.sendMessage("");
			sender.sendMessage(Color.translate(cmdname + "reload &e- 重新載入設定檔"));
			sender.sendMessage(Color.translate(cmdname + "about &e- 取得插件資訊"));
			sender.sendMessage(Color.translate("&8&m----------------------------------------"));
		} else if (args[0].equalsIgnoreCase("about")) {
			about(sender);
		}

		return false;
	}

	public void about(CommandSender sender) {
		String version = FantasyProfiles.getInstance().getDescription().getVersion();
		List<String> message = Arrays.asList(
				"&8&m----------------------------------------------",
				"&b&lFantasyProfiles &8(&7v" + version + "&8)",
				"&fMade With &4❤ &fBy &bHappyAreaBean",
				"",
				"&bfantasyrealms.net",
				"&8&m----------------------------------------------"
		);
		message.forEach((m) -> sender.sendMessage(Color.translate(m)));
	}
}
