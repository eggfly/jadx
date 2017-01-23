package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@eh
public final class er {
    private static final ExecutorService DW;
    private static final ExecutorService j6;

    class 1 implements Callable<Void> {
        final /* synthetic */ Runnable j6;

        1(Runnable runnable) {
            this.j6 = runnable;
        }

        public /* synthetic */ Object call() {
            return j6();
        }

        public Void j6() {
            this.j6.run();
            return null;
        }
    }

    class 2 implements Callable<Void> {
        final /* synthetic */ Runnable j6;

        2(Runnable runnable) {
            this.j6 = runnable;
        }

        public /* synthetic */ Object call() {
            return j6();
        }

        public Void j6() {
            this.j6.run();
            return null;
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ Callable DW;
        final /* synthetic */ fa j6;

        3(fa faVar, Callable callable) {
            this.j6 = faVar;
            this.DW = callable;
        }

        public void run() {
            try {
                Process.setThreadPriority(10);
                this.j6.DW(this.DW.call());
            } catch (Throwable e) {
                f.Zo().j6(e, true);
                this.j6.cancel(true);
            }
        }
    }

    class 4 implements Runnable {
        final /* synthetic */ Future DW;
        final /* synthetic */ fa j6;

        4(fa faVar, Future future) {
            this.j6 = faVar;
            this.DW = future;
        }

        public void run() {
            if (this.j6.isCancelled()) {
                this.DW.cancel(true);
            }
        }
    }

    class 5 implements ThreadFactory {
        private final AtomicInteger DW;
        final /* synthetic */ String j6;

        5(String str) {
            this.j6 = str;
            this.DW = new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            String str = this.j6;
            return new Thread(runnable, new StringBuilder(String.valueOf(str).length() + 23).append("AdWorker(").append(str).append(") #").append(this.DW.getAndIncrement()).toString());
        }
    }

    static {
        j6 = Executors.newFixedThreadPool(10, j6("Default"));
        DW = Executors.newFixedThreadPool(5, j6("Loader"));
    }

    public static fb<Void> j6(int i, Runnable runnable) {
        return i == 1 ? j6(DW, new 1(runnable)) : j6(j6, new 2(runnable));
    }

    public static fb<Void> j6(Runnable runnable) {
        return j6(0, runnable);
    }

    public static <T> fb<T> j6(ExecutorService executorService, Callable<T> callable) {
        Object faVar = new fa();
        try {
            faVar.j6(new 4(faVar, executorService.submit(new 3(faVar, callable))));
        } catch (Throwable e) {
            b.FH("Thread execution is rejected.", e);
            faVar.cancel(true);
        }
        return faVar;
    }

    private static ThreadFactory j6(String str) {
        return new 5(str);
    }
}
