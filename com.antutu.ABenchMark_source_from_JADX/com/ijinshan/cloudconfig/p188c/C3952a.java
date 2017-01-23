package com.ijinshan.cloudconfig.p188c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.ijinshan.cloudconfig.c.a */
public class C3952a {
    private static Context f13256a;
    private static String f13257b;
    private static int f13258c;
    private static boolean f13259d;
    private static volatile boolean f13260e;
    private static volatile boolean f13261f;
    private static String f13262g;
    private static boolean f13263h;
    private static boolean f13264i;

    static {
        f13256a = null;
        f13257b = BuildConfig.FLAVOR;
        f13258c = 0;
        f13259d = true;
        f13260e = true;
        f13261f = false;
    }

    public static String m16241a() {
        return f13262g;
    }

    public static void m16242a(Context context) {
        if (f13256a == null) {
            f13256a = context;
        }
    }

    public static void m16243a(String str) {
        f13262g = str;
    }

    public static void m16244a(String str, String str2) {
        C3952a.m16245a(str, str2, true, false);
    }

    public static void m16245a(String str, String str2, boolean z, boolean z2) {
        C3952a.m16246b(str);
        C3952a.m16243a(str2);
        f13263h = z;
        f13264i = z2;
    }

    public static void m16246b(String str) {
        if (TextUtils.isEmpty(f13257b)) {
            f13257b = str;
        }
    }

    public static boolean m16247b() {
        return f13263h;
    }

    public static boolean m16248b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isAvailable()) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean m16249c() {
        return f13264i;
    }

    public static Context m16250d() {
        return f13256a;
    }

    public static String m16251e() {
        return f13257b;
    }

    public static void m16252f() {
        f13261f = true;
    }
}
