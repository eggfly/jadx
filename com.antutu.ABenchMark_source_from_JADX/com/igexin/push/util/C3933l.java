package com.igexin.push.util;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.igexin.push.core.C3855g;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.igexin.push.util.l */
public class C3933l {
    public static String m16183a() {
        try {
            return VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0];
        } catch (Throwable th) {
            return BuildConfig.FLAVOR;
        }
    }

    public static String m16184a(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public static int m16185b(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (Exception e) {
            return i;
        }
    }

    public static String m16186b() {
        String str = BuildConfig.FLAVOR;
        try {
            str = Secure.getString(C3855g.f12969g.getContentResolver(), "android_id");
        } catch (Throwable th) {
        }
        return str;
    }

    public static String m16187c() {
        ServiceConnection c3935n;
        String str = BuildConfig.FLAVOR;
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                try {
                    C3855g.f12969g.getPackageManager().getPackageInfo("com.android.vending", 0);
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    c3935n = new C3935n();
                    if (C3855g.f12969g.bindService(intent, c3935n, 1)) {
                        str = new C3936o(c3935n.m16188a()).m16189a();
                        C3855g.f12969g.unbindService(c3935n);
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            C3855g.f12969g.unbindService(c3935n);
        } catch (Throwable th) {
        }
        return str;
    }
}
