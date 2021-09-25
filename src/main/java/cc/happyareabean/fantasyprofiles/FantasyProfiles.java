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

package cc.happyareabean.fantasyprofiles;

import cc.happyareabean.fantasyprofiles.commands.MainCommand;
import cc.happyareabean.fantasyprofiles.commands.ProfileCommand;
import cc.happyareabean.fantasyprofiles.commands.SettingsCommand;
import cc.happyareabean.fantasyprofiles.listener.MainSettingsMenuListener;
import cc.happyareabean.fantasyprofiles.listener.ProfileMenuListener;
import cc.happyareabean.fantasyprofiles.utils.Color;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class FantasyProfiles extends JavaPlugin {

	@Getter public String prefix = Color.translate("&8[&6FantasyProfiles&8] &e");
	@Getter public static FantasyProfiles instance;

	@Override
	public void onEnable() {
		instance = this;

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
				"  ______          _                           ",
				" |  ____|        | |                          ",
				" | |__ __ _ _ __ | |_ __ _ ___ _   _          ",
				" |  __/ _` | '_ \\| __/ _` / __| | | |         ",
				" | | | (_| | | | | || (_| \\__ \\ |_| |         ",
				" |_|  \\__,_|_| |_|\\__\\__,_|___/\\__, |         ",
				"                                __/ |         ",
				"                               |___/          ",
				"            _____            __ _ _           ",
				"           |  __ \\          / _(_) |          ",
				"           | |__) | __ ___ | |_ _| | ___  ___ ",
				"           |  ___/ '__/ _ \\|  _| | |/ _ \\/ __|",
				"           | |   | | | (_) | | | | |  __/\\__ \\",
				"           |_|   |_|  \\___/|_| |_|_|\\___||___/",
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
