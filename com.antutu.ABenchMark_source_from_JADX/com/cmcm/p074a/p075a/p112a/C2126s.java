package com.cmcm.p074a.p075a.p112a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.cmcm.p074a.p075a.p114c.C2152q;
import java.io.File;

/* renamed from: com.cmcm.a.a.a.s */
public class C2126s {
    private static volatile int f7459a;
    private static Context f7460b;
    private static Handler f7461c;
    private static File f7462d;
    private static int f7463e;
    private static C2116j f7464f;
    private static volatile C2152q f7465g;
    private static C2111e f7466h;
    private static aa f7467i;
    private static BroadcastReceiver f7468j;

    static {
        f7459a = 0;
        f7463e = 0;
    }

    public static synchronized int m8025a() {
        int i;
        synchronized (C2126s.class) {
            i = f7459a;
        }
        return i;
    }

    public static int m8026a(String str, String str2, int i) {
        return f7464f.getIntValue(C2131x.m8050a().m8054c(), str, str2, i);
    }

    public static SharedPreferences m8027a(String str) {
        return f7460b.getSharedPreferences("dmc_" + str, 0);
    }

    public static String m8029a(String str, String str2, String str3) {
        return f7464f.getStringValue(C2131x.m8050a().m8054c(), str, str2, str3);
    }

    public static void m8030a(BroadcastReceiver broadcastReceiver) {
        f7460b.unregisterReceiver(broadcastReceiver);
    }

    public static void m8031a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        f7460b.registerReceiver(broadcastReceiver, intentFilter, null, f7461c);
    }

    public static void m8032a(Context context, Handler handler, File file, int i, C2116j c2116j) {
        f7460b = context;
        f7461c = handler;
        f7462d = file;
        f7463e = i;
        f7464f = c2116j;
    }

    public static void m8033a(C2111e c2111e) {
        f7466h = c2111e;
    }

    public static void m8034a(C2114h c2114h) {
        if (f7467i == null) {
            f7467i = new aa();
        }
        f7467i.m7922a(c2114h);
    }

    public static void m8035a(Runnable runnable) {
        if (f7461c != null) {
            if (Looper.myLooper() == f7461c.getLooper()) {
                runnable.run();
            } else {
                f7461c.post(runnable);
            }
        }
    }

    public static boolean m8036a(int i) {
        return (f7463e & i) == i;
    }

    public static boolean m8037a(String str, String str2, boolean z) {
        return f7464f.getBoolValue(C2131x.m8050a().m8054c(), str, str2, z);
    }

    public static void m8039b() {
        if (C2133z.f7482a) {
            ad.m7931a("ContextUtils", "startup", new Object[0]);
        }
        C2126s.m8035a(new C2127t());
    }

    public static Context m8041c() {
        return f7460b;
    }

    private static synchronized void m8042c(int i) {
        synchronized (C2126s.class) {
            f7459a = i;
        }
    }

    public static File m8043d() {
        return f7462d;
    }

    public static void m8044e() {
        if (C2126s.m8025a() == 1) {
            C2126s.m8035a(new C2128u());
        }
    }

    public static void m8045f() {
        if (C2126s.m8025a() == 1) {
            C2126s.m8035a(new C2129v());
        }
    }
}
