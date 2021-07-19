package cc.happyareabean.fantasyprofiles;

import cc.happyareabean.fantasyprofiles.commands.MainCommand;
import cc.happyareabean.fantasyprofiles.commands.ProfileCommand;
import cc.happyareabean.fantasyprofiles.commands.SettingsCommand;
import cc.happyareabean.fantasyprofiles.databases.MongoDB;
import cc.happyareabean.fantasyprofiles.listener.PlayerListener;
import cc.happyareabean.fantasyprofiles.listener.ProfileMenuListener;
import cc.happyareabean.fantasyprofiles.listener.MainSettingsMenuListener;
import cc.happyareabean.fantasyprofiles.utils.Color;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.InsertOneOptions;
import com.mongodb.client.model.UpdateOptions;
import lombok.Getter;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class FantasyProfiles extends JavaPlugin {

	@Getter public String prefix = Color.translate("&8[&6FantasyProfiles&8] &e");
	@Getter public static FantasyProfiles instance;
	@Getter public MongoDB mongoDB;

	@Override
	public void onEnable() {
		instance = this;
//		mongoDB = new MongoDB();
		startmessage();
		registercommands();
		registerevents();
	}

	@Override
	public void onDisable() {

	}

	public void registercommands() {
		long commandtimestart = System.currentTimeMillis();
		Bukkit.getPluginCommand("fantasyprofiles").setExecutor(new MainCommand());
		Bukkit.getPluginCommand("settings").setExecutor(new SettingsCommand());
		Bukkit.getPluginCommand("profile").setExecutor(new ProfileCommand());
		long commandtimeend = System.currentTimeMillis();
		Bukkit.getConsoleSender().sendMessage(Color.translate(prefix + "&e已成功加載所有指令 &7(花費" + (commandtimeend - commandtimestart) + "ms)"));
	}

	public void registerevents() {
		long eventtimestart = System.currentTimeMillis();
		Bukkit.getPluginManager().registerEvents(new ProfileMenuListener(), this);
		Bukkit.getPluginManager().registerEvents(new MainSettingsMenuListener(), this);
//		Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
		long eventtimeend = System.currentTimeMillis();
		Bukkit.getConsoleSender().sendMessage(Color.translate(prefix + "&e已成功加載所有事件 &7(花費" + (eventtimeend - eventtimestart) + "ms)"));
	}

	public void startmessage() {
		Arrays.asList(
				"",
				"█▀▀ ▄▀█ █▄░█ ▀█▀ ▄▀█ █▀ █▄█ █▀█ █▀█ █▀█ █▀▀ █ █░░ █▀▀ █▀",
				"█▀░ █▀█ █░▀█ ░█░ █▀█ ▄█ ░█░ █▀▀ █▀▄ █▄█ █▀░ █ █▄▄ ██▄ ▄█",
				"",
				"   &6Fantasy Realms Profiles System",
				"   &fv" + getDescription().getVersion() + " &fMade With &4❤ &fBy HappyAreaBean",
				""
		).forEach((m -> Bukkit.getConsoleSender().sendMessage(Color.translate(prefix + m))));
	}

	public void debugLog(String message) {
		Bukkit.getConsoleSender().sendMessage(prefix + Color.translate("&8[&7DEBUG&8] &7" + message));
	}
}
