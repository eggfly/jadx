package com.facebook.ads.internal.p125c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.facebook.ads.internal.C2470f;
import com.facebook.ads.internal.C2470f.C2413c;
import com.facebook.ads.internal.util.C2489b;
import com.facebook.ads.internal.util.C2490c;
import com.facebook.ads.internal.util.C2498g;
import com.facebook.ads.internal.util.C2498g.C2497a;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.facebook.ads.internal.c.g */
public class C2352g {
    public static final String f8199a;
    public static String f8200b;
    public static String f8201c;
    public static String f8202d;
    public static String f8203e;
    public static String f8204f;
    public static int f8205g;
    public static String f8206h;
    public static String f8207i;
    public static int f8208j;
    public static String f8209k;
    public static int f8210l;
    public static String f8211m;
    public static String f8212n;
    public static String f8213o;
    public static boolean f8214p;
    public static String f8215q;
    private static boolean f8216r;

    static {
        f8216r = false;
        f8199a = VERSION.RELEASE;
        f8200b = BuildConfig.FLAVOR;
        f8201c = BuildConfig.FLAVOR;
        f8202d = BuildConfig.FLAVOR;
        f8203e = BuildConfig.FLAVOR;
        f8204f = BuildConfig.FLAVOR;
        f8205g = 0;
        f8206h = BuildConfig.FLAVOR;
        f8207i = BuildConfig.FLAVOR;
        f8208j = 0;
        f8209k = BuildConfig.FLAVOR;
        f8210l = 0;
        f8211m = BuildConfig.FLAVOR;
        f8212n = BuildConfig.FLAVOR;
        f8213o = BuildConfig.FLAVOR;
        f8214p = false;
        f8215q = BuildConfig.FLAVOR;
    }

    public static synchronized void m9064a(Context context) {
        synchronized (C2352g.class) {
            if (!f8216r) {
                f8216r = true;
                C2352g.m9066c(context);
            }
            C2352g.m9067d(context);
        }
    }

    public static void m9065b(Context context) {
        if (f8216r) {
            try {
                C2497a a;
                C2470f a2;
                SharedPreferences sharedPreferences = context.getSharedPreferences("SDKIDFA", 0);
                if (sharedPreferences.contains("attributionId")) {
                    f8212n = sharedPreferences.getString("attributionId", BuildConfig.FLAVOR);
                }
                if (sharedPreferences.contains("advertisingId")) {
                    f8213o = sharedPreferences.getString("advertisingId", BuildConfig.FLAVOR);
                    f8214p = sharedPreferences.getBoolean("limitAdTracking", f8214p);
                    f8215q = C2413c.SHARED_PREFS.name();
                }
                try {
                    a = C2498g.m9469a(context.getContentResolver());
                } catch (Throwable e) {
                    C2490c.m9456a(C2489b.m9453a(e, "Error retrieving attribution id from fb4a"));
                    a = null;
                }
                if (a != null) {
                    String str = a.f8581a;
                    if (str != null) {
                        f8212n = str;
                    }
                }
                try {
                    a2 = C2470f.m9392a(context, a);
                } catch (Throwable e2) {
                    C2490c.m9456a(C2489b.m9453a(e2, "Error retrieving advertising id from Google Play Services"));
                    a2 = null;
                }
                if (a2 != null) {
                    String a3 = a2.m9395a();
                    Boolean valueOf = Boolean.valueOf(a2.m9396b());
                    if (a3 != null) {
                        f8213o = a3;
                        f8214p = valueOf.booleanValue();
                        f8215q = a2.m9397c().name();
                    }
                }
                Editor edit = sharedPreferences.edit();
                edit.putString("attributionId", f8212n);
                edit.putString("advertisingId", f8213o);
                edit.putBoolean("limitAdTracking", f8214p);
                edit.apply();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private static void m9066c(Context context) {
        String networkOperatorName;
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            f8202d = packageInfo.packageName;
            f8204f = packageInfo.versionName;
            f8205g = packageInfo.versionCode;
        } catch (NameNotFoundException e) {
        }
        try {
            if (f8202d != null && f8202d.length() >= 0) {
                String installerPackageName = packageManager.getInstallerPackageName(f8202d);
                if (installerPackageName != null && installerPackageName.length() > 0) {
                    f8206h = installerPackageName;
                }
            }
        } catch (Exception e2) {
        }
        try {
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            if (applicationLabel != null && applicationLabel.length() > 0) {
                f8203e = applicationLabel.toString();
            }
        } catch (NameNotFoundException e3) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            networkOperatorName = telephonyManager.getNetworkOperatorName();
            if (networkOperatorName != null && networkOperatorName.length() > 0) {
                f8207i = networkOperatorName;
            }
        }
        networkOperatorName = Build.MANUFACTURER;
        if (networkOperatorName != null && networkOperatorName.length() > 0) {
            f8200b = networkOperatorName;
        }
        networkOperatorName = Build.MODEL;
        if (networkOperatorName != null && networkOperatorName.length() > 0) {
            f8201c = Build.MODEL;
        }
    }

    private static void m9067d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                f8208j = activeNetworkInfo.getType();
                f8209k = activeNetworkInfo.getTypeName();
                f8210l = activeNetworkInfo.getSubtype();
                f8211m = activeNetworkInfo.getSubtypeName();
            }
        } catch (Exception e) {
        }
    }
}
