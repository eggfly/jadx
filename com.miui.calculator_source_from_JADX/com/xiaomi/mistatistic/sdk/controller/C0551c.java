package com.xiaomi.mistatistic.sdk.controller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.c */
public abstract class C0551c {
    private static Context f4706a;
    private static String f4707b;
    private static String f4708c;
    private static String f4709d;
    private static String f4710e;
    private static String f4711f;
    private static String f4712g;

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.c.1 */
    final class C05501 implements Callable<String> {
        final /* synthetic */ PackageManager f4705a;

        C05501(PackageManager packageManager) {
            this.f4705a = packageManager;
        }

        public /* synthetic */ Object call() {
            return m6351a();
        }

        public String m6351a() {
            try {
                PackageInfo packageInfo = this.f4705a.getPackageInfo(C0551c.f4706a.getPackageName(), 16384);
                if (packageInfo != null) {
                    return packageInfo.versionName;
                }
                return null;
            } catch (Throwable e) {
                C0566h.m6418a("getPackageInfo exception: ", e);
                return null;
            }
        }
    }

    public static void m6353a(Context context, String str, String str2, String str3) {
        f4706a = context;
        f4707b = str;
        f4708c = str2;
        f4709d = str3;
        f4712g = String.valueOf(System.currentTimeMillis());
    }

    public static Context m6352a() {
        return f4706a;
    }

    public static String m6354b() {
        return f4707b;
    }

    public static String m6355c() {
        return f4708c;
    }

    public static String m6356d() {
        return f4709d;
    }

    public static String m6357e() {
        if (!TextUtils.isEmpty(f4710e)) {
            return f4710e;
        }
        try {
            Object futureTask = new FutureTask(new C05501(f4706a.getPackageManager()));
            new Thread(futureTask).start();
            f4710e = (String) futureTask.get(1000, TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            C0566h.m6418a("getVersion exception: ", e);
        }
        return f4710e;
    }

    public static String m6358f() {
        return f4712g;
    }

    public static String m6359g() {
        if (!TextUtils.isEmpty(f4711f)) {
            return f4711f;
        }
        f4711f = f4706a.getPackageName();
        return f4711f;
    }
}
