package com.facebook.ads.internal.util;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.facebook.ads.internal.util.p */
public class C2508p implements ThreadFactory {
    protected final AtomicLong f8620a;
    private int f8621b;

    public C2508p() {
        this.f8620a = new AtomicLong();
        this.f8621b = Thread.currentThread().getPriority();
    }

    protected String m9513a() {
        return String.format(Locale.ENGLISH, "com.facebook.ads thread-%d %tF %<tT", new Object[]{Long.valueOf(this.f8620a.incrementAndGet()), Long.valueOf(System.currentTimeMillis())});
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(null, runnable, m9513a(), 0);
        thread.setPriority(this.f8621b);
        return thread;
    }
}
