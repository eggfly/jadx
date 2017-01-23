package com.xiaomi.channel.commonutils.misc;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.channel.commonutils.misc.d */
public class C4308d {
    private static volatile C4308d f14733a;
    private ScheduledThreadPoolExecutor f14734b;
    private SparseArray<ScheduledFuture> f14735c;
    private Object f14736d;
    private SharedPreferences f14737e;

    /* renamed from: com.xiaomi.channel.commonutils.misc.d.a */
    public static abstract class C4306a implements Runnable {
        public abstract int m17663a();
    }

    /* renamed from: com.xiaomi.channel.commonutils.misc.d.b */
    private static class C4307b implements Runnable {
        C4306a f14732c;

        public C4307b(C4306a c4306a) {
            this.f14732c = c4306a;
        }

        void m17664a() {
        }

        void m17665b() {
        }

        public void run() {
            m17664a();
            this.f14732c.run();
            m17665b();
        }
    }

    private C4308d(Context context) {
        this.f14734b = new ScheduledThreadPoolExecutor(1);
        this.f14735c = new SparseArray();
        this.f14736d = new Object();
        this.f14737e = context.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
    }

    public static C4308d m17667a(Context context) {
        if (f14733a == null) {
            synchronized (C4308d.class) {
                if (f14733a == null) {
                    f14733a = new C4308d(context);
                }
            }
        }
        return f14733a;
    }

    private static String m17668a(int i) {
        return "last_job_time" + i;
    }

    private ScheduledFuture m17669a(C4306a c4306a) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f14736d) {
            scheduledFuture = (ScheduledFuture) this.f14735c.get(c4306a.m17663a());
        }
        return scheduledFuture;
    }

    public void m17670a(Runnable runnable) {
        m17671a(runnable, 0);
    }

    public void m17671a(Runnable runnable, int i) {
        this.f14734b.schedule(runnable, (long) i, TimeUnit.SECONDS);
    }

    public boolean m17672a(C4306a c4306a, int i, int i2) {
        if (c4306a == null || m17669a(c4306a) != null) {
            return false;
        }
        String a = C4308d.m17668a(c4306a.m17663a());
        Runnable c4309e = new C4309e(this, c4306a, a);
        long abs = Math.abs(System.currentTimeMillis() - this.f14737e.getLong(a, 0)) / 1000;
        if (abs < ((long) (i - i2))) {
            i2 = (int) (((long) i) - abs);
        }
        ScheduledFuture scheduleAtFixedRate = this.f14734b.scheduleAtFixedRate(c4309e, (long) i2, (long) i, TimeUnit.SECONDS);
        synchronized (this.f14736d) {
            this.f14735c.put(c4306a.m17663a(), scheduleAtFixedRate);
        }
        return true;
    }
}
