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