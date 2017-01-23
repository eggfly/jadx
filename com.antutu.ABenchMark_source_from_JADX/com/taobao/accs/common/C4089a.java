package com.taobao.accs.common;

import com.taobao.accs.utl.ALog;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.taobao.accs.common.a */
public class C4089a {
    private static volatile ScheduledThreadPoolExecutor f13644a;
    private static volatile ScheduledThreadPoolExecutor f13645b;
    private static final AtomicInteger f13646c;

    /* renamed from: com.taobao.accs.common.a.a */
    static class C4088a implements ThreadFactory {
        private String f13643a;

        public C4088a(String str) {
            this.f13643a = str;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "tag:" + C4089a.f13646c.getAndIncrement());
            thread.setPriority(5);
            return thread;
        }
    }

    static {
        f13646c = new AtomicInteger();
    }

    public static ScheduledFuture<?> m16687a(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledFuture<?> scheduledFuture = null;
        try {
            scheduledFuture = C4089a.m16688a().schedule(runnable, j, timeUnit);
        } catch (Throwable th) {
            ALog.m16902e("ThreadPoolExecutorFactory", "ThreadPoolExecutorFactory schedule", th, new Object[0]);
        }
        return scheduledFuture;
    }

    public static ScheduledThreadPoolExecutor m16688a() {
        if (f13644a == null) {
            synchronized (C4089a.class) {
                if (f13644a == null) {
                    f13644a = new ScheduledThreadPoolExecutor(1, new C4088a("ACCS"));
                }
            }
        }
        return f13644a;
    }

    public static void m16689a(Runnable runnable) {
        try {
            C4089a.m16688a().execute(runnable);
        } catch (Throwable th) {
            ALog.m16902e("ThreadPoolExecutorFactory", "ThreadPoolExecutorFactory execute", th, new Object[0]);
        }
    }

    public static ScheduledThreadPoolExecutor m16690b() {
        if (f13645b == null) {
            synchronized (C4089a.class) {
                if (f13645b == null) {
                    f13645b = new ScheduledThreadPoolExecutor(1, new C4088a("ACCS SEND"));
                }
            }
        }
        return f13645b;
    }
}
