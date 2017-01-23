package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.pushsdk.BuildConfig;
import p023b.p024a.am;
import p023b.p024a.ap;
import p023b.p024a.at;

public class AnalyticsConfig {
    public static boolean ACTIVITY_DURATION_OPEN;
    public static boolean CATCH_EXCEPTION;
    public static final boolean FLAG_DPLUS = false;
    public static final boolean FLAG_INTERNATIONAL = false;
    public static String GPU_RENDERER;
    public static String GPU_VENDER;
    static double[] f13927a;
    private static String f13928b;
    private static String f13929c;
    private static String f13930d;
    private static int f13931e;
    public static long kContinueSessionMillis;
    public static String mWrapperType;
    public static String mWrapperVersion;
    public static boolean sEncrypt;
    public static int sLatentWindow;

    static {
        f13928b = null;
        f13929c = null;
        f13930d = null;
        mWrapperType = null;
        mWrapperVersion = null;
        f13931e = 0;
        GPU_VENDER = BuildConfig.FLAVOR;
        GPU_RENDERER = BuildConfig.FLAVOR;
        ACTIVITY_DURATION_OPEN = true;
        CATCH_EXCEPTION = true;
        kContinueSessionMillis = 30000;
        sEncrypt = false;
        f13927a = null;
        sEncrypt = false;
    }

    static void m16954a(Context context, int i) {
        f13931e = i;
        at.m3424a(context).m3434a(f13931e);
    }

    static void m16955a(Context context, String str) {
        if (context == null) {
            f13928b = str;
            return;
        }
        String n = am.m3356n(context);
        if (TextUtils.isEmpty(n)) {
            Object c = at.m3424a(context).m3443c();
            if (TextUtils.isEmpty(c)) {
                at.m3424a(context).m3436a(str);
            } else if (!c.equals(str)) {
                ap.m3389c("Appkey\u548c\u4e0a\u6b21\u914d\u7f6e\u7684\u4e0d\u4e00\u81f4 ");
                at.m3424a(context).m3436a(str);
            }
            f13928b = str;
            return;
        }
        f13928b = n;
        if (!n.equals(str)) {
            ap.m3389c("Appkey\u548cAndroidManifest.xml\u4e2d\u914d\u7f6e\u7684\u4e0d\u4e00\u81f4 ");
        }
    }

    static void m16956a(String str) {
        f13929c = str;
    }

    static void m16957a(boolean z) {
        sEncrypt = z;
    }

    static void m16958b(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            f13930d = str;
            at.m3424a(context).m3441b(f13930d);
        }
    }

    public static String getAppkey(Context context) {
        if (TextUtils.isEmpty(f13928b)) {
            f13928b = am.m3356n(context);
            if (TextUtils.isEmpty(f13928b)) {
                f13928b = at.m3424a(context).m3443c();
            }
        }
        return f13928b;
    }

    public static String getChannel(Context context) {
        if (TextUtils.isEmpty(f13929c)) {
            f13929c = am.m3359q(context);
        }
        return f13929c;
    }

    public static double[] getLocation() {
        return f13927a;
    }

    public static String getSDKVersion(Context context) {
        return C4156a.f13941c;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f13930d)) {
            f13930d = at.m3424a(context).m3444d();
        }
        return f13930d;
    }

    public static int getVerticalType(Context context) {
        if (f13931e == 0) {
            f13931e = at.m3424a(context).m3445e();
        }
        return f13931e;
    }
}
