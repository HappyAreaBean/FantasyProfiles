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

package cc.happyareabean.fantasyprofiles.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncUtils {

	public static void runAsync(final Runnable runnable) {
		final ExecutorService executor = Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().setNameFormat("FantasyProfiles-" + runnable.hashCode()).build());

		executor.submit(runnable);
	}

	/*public static BukkitTask runTaskTimer(final BukkitRunnable runnable, final long delay, final long time, final boolean async) {
		if (async)
			return runnable.runTaskTimerAsynchronously(ShitPractice.getInstance(), delay, time);
		return runnable.runTaskTimer(ShitPractice.getInstance(), delay, time);
	}

	public static BukkitTask runTaskLater(final Runnable runnable, final long delay, final boolean async) {
		if (async)
			return Bukkit.getScheduler().runTaskLaterAsynchronously(ShitPractice.getInstance(), runnable, delay);
		return Bukkit.getScheduler().runTaskLater(ShitPractice.getInstance(), runnable, delay);
	}*/
}