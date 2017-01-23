package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.C2686R;
import com.google.android.gms.common.C3464g.C3463d;
import com.google.android.gms.common.internal.C3475f;
import com.google.android.gms.p146b.jj;
import com.google.android.gms.p146b.jk;
import com.google.android.gms.p146b.jq;
import com.umeng.message.entity.UMessage;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.h */
public class C3465h {
    @Deprecated
    public static final int f12008a;
    public static boolean f12009b;
    public static boolean f12010c;
    static int f12011d;
    static final AtomicBoolean f12012e;
    private static final Object f12013f;
    private static String f12014g;
    private static Integer f12015h;
    private static final AtomicBoolean f12016i;

    static {
        f12008a = C3465h.m14293b();
        f12009b = false;
        f12010c = false;
        f12011d = -1;
        f12013f = new Object();
        f12014g = null;
        f12015h = null;
        f12012e = new AtomicBoolean();
        f12016i = new AtomicBoolean();
    }

    @Deprecated
    public static int m14286a(Context context) {
        if (C3475f.f12055a) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C2686R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            C3465h.m14303h(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            C3466i a = C3466i.m14304a();
            if (!jj.m13557a(context)) {
                try {
                    if (a.m14305a(packageManager.getPackageInfo("com.android.vending", 8256), C3463d.f12007a) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (a.m14305a(packageInfo, a.m14305a(packageManager.getPackageInfo("com.android.vending", 8256), C3463d.f12007a)) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                    return 9;
                }
            } else if (a.m14305a(packageInfo, C3463d.f12007a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (jk.m13558a(packageInfo.versionCode) < jk.m13558a(f12008a)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + f12008a + " but found " + packageInfo.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static String m14287a(int i) {
        return ConnectionResult.m13949a(i);
    }

    public static boolean m14288a() {
        return f12009b ? f12010c : "user".equals(Build.TYPE);
    }

    public static boolean m14289a(Context context, int i) {
        boolean z = false;
        if (!C3465h.m14290a(context, i, "com.google.android.gms")) {
            return z;
        }
        try {
            return C3466i.m14304a().m14307a(context.getPackageManager(), context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("GooglePlayServicesUtil", 3)) {
                return z;
            }
            Log.d("GooglePlayServicesUtil", "Package manager can't find google play services package, defaulting to false");
            return z;
        }
    }

    @TargetApi(19)
    public static boolean m14290a(Context context, int i, String str) {
        if (jq.m13572e()) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(21)
    static boolean m14291a(Context context, String str) {
        if (jq.m13575h()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        if (C3465h.m14302g(context)) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, SpdyProtocol.SLIGHTSSL_1_RTT_MODE).enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean m14292a(PackageManager packageManager) {
        boolean z = true;
        synchronized (f12013f) {
            if (f12011d == -1) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
                    if (C3466i.m14304a().m14305a(packageInfo, C3463d.f12007a[1]) != null) {
                        f12011d = 1;
                    } else {
                        f12011d = 0;
                    }
                } catch (NameNotFoundException e) {
                    f12011d = 0;
                }
            }
            if (f12011d == 0) {
                z = false;
            }
        }
        return z;
    }

    private static int m14293b() {
        return 8487000;
    }

    @Deprecated
    public static void m14294b(Context context) {
        if (!f12012e.getAndSet(true)) {
            try {
                ((NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)).cancel(10436);
            } catch (SecurityException e) {
            }
        }
    }

    @Deprecated
    public static boolean m14295b(int i) {
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean m14296b(Context context, int i) {
        return i == 18 ? true : i == 1 ? C3465h.m14291a(context, "com.google.android.gms") : false;
    }

    public static boolean m14297b(PackageManager packageManager) {
        return C3465h.m14292a(packageManager) || !C3465h.m14288a();
    }

    public static Resources m14298c(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Context m14299d(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static int m14300e(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return i;
        }
    }

    public static boolean m14301f(Context context) {
        return jq.m13575h() && context.getPackageManager().hasSystemFeature("cn.google");
    }

    @TargetApi(18)
    public static boolean m14302g(Context context) {
        if (jq.m13571d()) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }

    private static void m14303h(Context context) {
        if (!f12016i.get()) {
            Integer num;
            synchronized (f12013f) {
                if (f12014g == null) {
                    f12014g = context.getPackageName();
                    try {
                        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), SpdyProtocol.SLIGHTSSLV2).metaData;
                        if (bundle != null) {
                            f12015h = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                        } else {
                            f12015h = null;
                        }
                    } catch (Throwable e) {
                        Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
                    }
                } else if (!f12014g.equals(context.getPackageName())) {
                    throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + f12014g + "' and this call used package '" + context.getPackageName() + "'.");
                }
                num = f12015h;
            }
            if (num == null) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (num.intValue() != f12008a) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + f12008a + " but" + " found " + num + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
    }
}
