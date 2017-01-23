package anet.channel.p019c;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: anet.channel.c.c */
public class C0660c {
    private static volatile ScheduledExecutorService f2200a;
    private static volatile ThreadPoolExecutor f2201b;
    private static volatile C0658b f2202c;

    /* renamed from: anet.channel.c.c.a */
    static class C0659a implements ThreadFactory {
        AtomicInteger f2198a;
        String f2199b;

        C0659a(String str) {
            this.f2198a = new AtomicInteger(0);
            this.f2199b = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f2199b + this.f2198a.incrementAndGet());
            thread.setPriority(5);
            return thread;
        }
    }

    public static Future<?> m2783a(Runnable runnable) {
        return C0660c.m2785a().submit(runnable);
    }

    public static Future<?> m2784a(Runnable runnable, int i) {
        Object c0656a = new C0656a(runnable, i);
        C0660c.m2787b().submit(c0656a);
        return c0656a;
    }

    static ScheduledExecutorService m2785a() {
        if (f2200a == null) {
            synchronized (C0660c.class) {
                if (f2200a == null) {
                    f2200a = new ScheduledThreadPoolExecutor(1, new C0659a("AWCN Scheduler"));
                }
            }
        }
        return f2200a;
    }

    public static ScheduledFuture<?> m2786a(Runnable runnable, long j, TimeUnit timeUnit) {
        return C0660c.m2785a().schedule(runnable, j, timeUnit);
    }

    static ThreadPoolExecutor m2787b() {
        if (f2202c == null) {
            synchronized (C0660c.class) {
                if (f2202c == null) {
                    f2202c = new C0658b(1, 1, 300, TimeUnit.SECONDS, new PriorityBlockingQueue(), new C0659a("AWCN Dispatcher"));
                }
            }
        }
        return f2202c;
    }

    static ThreadPoolExecutor m2788c() {
        if (f2201b == null) {
            synchronized (C0660c.class) {
                if (f2201b == null) {
                    f2201b = new ThreadPoolExecutor(2, 7, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(16), new C0659a("AWCN Worker"));
                }
            }
        }
        return f2201b;
    }
}
