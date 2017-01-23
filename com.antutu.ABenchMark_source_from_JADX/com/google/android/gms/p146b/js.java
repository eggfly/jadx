package com.google.android.gms.p146b;

import com.google.android.gms.common.internal.C3512u;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.b.js */
public class js implements ThreadFactory {
    private final String f11566a;
    private final int f11567b;
    private final AtomicInteger f11568c;
    private final ThreadFactory f11569d;

    public js(String str) {
        this(str, 0);
    }

    public js(String str, int i) {
        this.f11568c = new AtomicInteger();
        this.f11569d = Executors.defaultThreadFactory();
        this.f11566a = (String) C3512u.m14581a((Object) str, (Object) "Name must not be null");
        this.f11567b = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f11569d.newThread(new jt(runnable, this.f11567b));
        newThread.setName(this.f11566a + "[" + this.f11568c.getAndIncrement() + "]");
        return newThread;
    }
}
