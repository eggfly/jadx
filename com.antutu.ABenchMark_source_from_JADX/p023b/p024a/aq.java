package p023b.p024a;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: b.a.aq */
public class aq {
    private static List<WeakReference<ScheduledFuture<?>>> f2683a;
    private static ExecutorService f2684b;
    private static long f2685c;
    private static ScheduledExecutorService f2686d;

    static {
        f2683a = new ArrayList();
        f2684b = Executors.newSingleThreadExecutor();
        f2685c = 5;
        f2686d = Executors.newSingleThreadScheduledExecutor();
    }

    public static void m3393a() {
        try {
            for (WeakReference weakReference : f2683a) {
                ScheduledFuture scheduledFuture = (ScheduledFuture) weakReference.get();
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
            }
            f2683a.clear();
            if (!f2684b.isShutdown()) {
                f2684b.shutdown();
            }
            if (!f2686d.isShutdown()) {
                f2686d.shutdown();
            }
            f2684b.awaitTermination(f2685c, TimeUnit.SECONDS);
            f2686d.awaitTermination(f2685c, TimeUnit.SECONDS);
        } catch (Exception e) {
        }
    }

    public static void m3394a(Runnable runnable) {
        if (f2684b.isShutdown()) {
            f2684b = Executors.newSingleThreadExecutor();
        }
        f2684b.execute(runnable);
    }

    public static synchronized void m3395a(Runnable runnable, long j) {
        synchronized (aq.class) {
            if (f2686d.isShutdown()) {
                f2686d = Executors.newSingleThreadScheduledExecutor();
            }
            f2683a.add(new WeakReference(f2686d.schedule(runnable, j, TimeUnit.MILLISECONDS)));
        }
    }

    public static synchronized void m3396b(Runnable runnable) {
        synchronized (aq.class) {
            if (f2686d.isShutdown()) {
                f2686d = Executors.newSingleThreadScheduledExecutor();
            }
            f2686d.execute(runnable);
        }
    }

    public static synchronized void m3397c(Runnable runnable) {
        synchronized (aq.class) {
            if (f2686d.isShutdown()) {
                f2686d = Executors.newSingleThreadScheduledExecutor();
            }
            try {
                f2686d.submit(runnable).get(5, TimeUnit.SECONDS);
            } catch (Exception e) {
            }
        }
    }
}
