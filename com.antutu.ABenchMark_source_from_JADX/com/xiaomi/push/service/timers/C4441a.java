package com.xiaomi.push.service.timers;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import com.xiaomi.channel.commonutils.android.C4297i;
import com.xiaomi.channel.commonutils.logger.C4302b;

/* renamed from: com.xiaomi.push.service.timers.a */
public final class C4441a {
    private static C4440a f15156a;

    /* renamed from: com.xiaomi.push.service.timers.a.a */
    interface C4440a {
        void m18352a();

        void m18353a(boolean z);

        boolean m18354b();
    }

    public static synchronized void m18355a() {
        synchronized (C4441a.class) {
            if (f15156a != null) {
                f15156a.m18352a();
            }
        }
    }

    public static void m18356a(Context context) {
        Object obj = null;
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            f15156a = new C4442b(applicationContext);
            return;
        }
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4);
            if (packageInfo.services != null) {
                for (ServiceInfo serviceInfo : packageInfo.services) {
                    if ("com.xiaomi.push.service.XMJobService".equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                        obj = 1;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            C4302b.m17649a("check service err : " + e.getMessage());
        }
        if (obj == null && C4297i.m17627b(applicationContext)) {
            throw new RuntimeException("Should export service: com.xiaomi.push.service.XMJobService with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
        }
        if (VERSION.SDK_INT >= 21) {
            f15156a = new C4442b(applicationContext);
        } else {
            f15156a = new C4442b(applicationContext);
        }
    }

    public static synchronized void m18357a(boolean z) {
        synchronized (C4441a.class) {
            if (f15156a == null) {
                C4302b.m17649a("timer is not initialized");
            } else {
                f15156a.m18353a(z);
            }
        }
    }

    public static synchronized boolean m18358b() {
        boolean b;
        synchronized (C4441a.class) {
            b = f15156a == null ? false : f15156a.m18354b();
        }
        return b;
    }
}
