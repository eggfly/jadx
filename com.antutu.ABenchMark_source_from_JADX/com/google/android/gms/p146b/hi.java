package com.google.android.gms.p146b;

import android.os.Process;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@gb
/* renamed from: com.google.android.gms.b.hi */
public final class hi {
    private static final ExecutorService f11292a;
    private static final ExecutorService f11293b;

    /* renamed from: com.google.android.gms.b.hi.1 */
    static class C32461 implements Callable<Void> {
        final /* synthetic */ Runnable f11284a;

        C32461(Runnable runnable) {
            this.f11284a = runnable;
        }

        public Void m13001a() {
            this.f11284a.run();
            return null;
        }

        public /* synthetic */ Object call() {
            return m13001a();
        }
    }

    /* renamed from: com.google.android.gms.b.hi.2 */
    static class C32472 implements Callable<Void> {
        final /* synthetic */ Runnable f11285a;

        C32472(Runnable runnable) {
            this.f11285a = runnable;
        }

        public Void m13002a() {
            this.f11285a.run();
            return null;
        }

        public /* synthetic */ Object call() {
            return m13002a();
        }
    }

    /* renamed from: com.google.android.gms.b.hi.3 */
    static class C32483 implements Runnable {
        final /* synthetic */ hw f11286a;
        final /* synthetic */ Callable f11287b;

        C32483(hw hwVar, Callable callable) {
            this.f11286a = hwVar;
            this.f11287b = callable;
        }

        public void run() {
            try {
                Process.setThreadPriority(10);
                this.f11286a.m12217b(this.f11287b.call());
            } catch (Throwable e) {
                C2968s.m11528h().m12941a(e, true);
                this.f11286a.cancel(true);
            }
        }
    }

    /* renamed from: com.google.android.gms.b.hi.4 */
    static class C32494 implements Runnable {
        final /* synthetic */ hw f11288a;
        final /* synthetic */ Future f11289b;

        C32494(hw hwVar, Future future) {
            this.f11288a = hwVar;
            this.f11289b = future;
        }

        public void run() {
            if (this.f11288a.isCancelled()) {
                this.f11289b.cancel(true);
            }
        }
    }

    /* renamed from: com.google.android.gms.b.hi.5 */
    static class C32505 implements ThreadFactory {
        final /* synthetic */ String f11290a;
        private final AtomicInteger f11291b;

        C32505(String str) {
            this.f11290a = str;
            this.f11291b = new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker(" + this.f11290a + ") #" + this.f11291b.getAndIncrement());
        }
    }

    static {
        f11292a = Executors.newFixedThreadPool(10, hi.m13007a("Default"));
        f11293b = Executors.newFixedThreadPool(5, hi.m13007a("Loader"));
    }

    public static hz<Void> m13003a(int i, Runnable runnable) {
        return i == 1 ? hi.m13006a(f11293b, new C32461(runnable)) : hi.m13006a(f11292a, new C32472(runnable));
    }

    public static hz<Void> m13004a(Runnable runnable) {
        return hi.m13003a(0, runnable);
    }

    public static <T> hz<T> m13005a(Callable<T> callable) {
        return hi.m13006a(f11292a, (Callable) callable);
    }

    public static <T> hz<T> m13006a(ExecutorService executorService, Callable<T> callable) {
        Object hwVar = new hw();
        try {
            hwVar.m12218b(new C32494(hwVar, executorService.submit(new C32483(hwVar, callable))));
        } catch (Throwable e) {
            C2972b.m11584d("Thread execution is rejected.", e);
            hwVar.cancel(true);
        }
        return hwVar;
    }

    private static ThreadFactory m13007a(String str) {
        return new C32505(str);
    }
}
