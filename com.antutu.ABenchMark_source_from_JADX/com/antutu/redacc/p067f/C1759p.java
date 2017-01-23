package com.antutu.redacc.p067f;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.antutu.redacc.f.p */
public class C1759p {
    private static C1759p f6191a;
    private static ExecutorService f6192b;
    private static final BlockingQueue<Runnable> f6193c;

    static {
        f6193c = new LinkedBlockingQueue(100);
    }

    private C1759p() {
        f6192b = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY, 0, TimeUnit.MILLISECONDS, f6193c);
    }

    public static C1759p m6765a() {
        if (f6191a == null) {
            synchronized (C1759p.class) {
                if (f6191a == null) {
                    C1759p c1759p = new C1759p();
                    f6191a = c1759p;
                    return c1759p;
                }
            }
        }
        return f6191a;
    }

    public void m6766a(C1750o c1750o) {
        f6192b.submit(c1750o);
    }
}
