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

package cc.happyareabean.fantasyprofiles.api;

import cc.happyareabean.fantasyprofiles.menu.SettingsMenu;
import org.ipvp.canvas.slot.SlotSettings;

import java.util.List;

public interface FantasyProfilesAPI {

	static List<SettingsMenu> getMenuList() {
		return null;
	}

	/**
	 * <p>Add a Slot into the settings menu</p>
	 * <p>The items you add will always be <b>displayed at the end</b></p>
	 * <br>
	 * <p>Please be aware you can only add the same item one time.</p>
	 * <p>If you call this method multiple time it will duplicate the item.</p>
	 * <br>
	 * <p>For example, you can implement it after the relevant classes/systems are initialized or when the plugin enabling.</p>
	 * @param slot The SlotSettings you want
	 */
	void addSettingsSlot(SlotSettings slot);
}
