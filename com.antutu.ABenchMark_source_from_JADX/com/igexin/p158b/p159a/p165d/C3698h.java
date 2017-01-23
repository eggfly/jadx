package com.igexin.p158b.p159a.p165d;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.igexin.b.a.d.h */
final class C3698h implements ThreadFactory {
    final AtomicInteger f12470a;
    final /* synthetic */ C3696f f12471b;

    public C3698h(C3696f c3696f) {
        this.f12471b = c3696f;
        this.f12470a = new AtomicInteger(0);
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "TaskService-pool-" + this.f12470a.incrementAndGet());
    }
}
