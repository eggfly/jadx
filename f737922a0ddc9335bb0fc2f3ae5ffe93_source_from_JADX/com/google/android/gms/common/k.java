package com.google.android.gms.common;

import aeq$c;
import aft;
import afv;
import agb;
import age;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.internal.hl;
import java.util.concurrent.atomic.AtomicBoolean;

public class k {
    @Deprecated
    public static final int DW;
    public static boolean FH;
    public static boolean Hw;
    private static int VH;
    static final AtomicBoolean Zo;
    private static boolean gn;
    private static String j6;
    private static final AtomicBoolean u7;
    static boolean v5;

    static {
        DW = DW();
        FH = false;
        Hw = false;
        v5 = false;
        j6 = null;
        VH = 0;
        gn = false;
        Zo = new AtomicBoolean();
        u7 = new AtomicBoolean();
    }

    private static int DW() {
        return l.j6;
    }

    @Deprecated
    public static int DW(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(aeq$c.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            j6(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            l j6 = l.j6(context);
            if (!aft.j6(context)) {
                try {
                    if (j6.j6(packageManager.getPackageInfo("com.android.vending", 8256), d.j6) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (j6.j6(packageInfo, j6.j6(packageManager.getPackageInfo("com.android.vending", 8256), d.j6)) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                    return 9;
                }
            } else if (j6.j6(packageInfo, d.j6) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (afv.j6(packageInfo.versionCode) < afv.j6(DW)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + DW + " but found " + packageInfo.versionCode);
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
    public static boolean DW(int i) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean DW(Context context, int i) {
        return age.j6(context, i);
    }

    public static boolean FH(Context context) {
        u7(context);
        return v5;
    }

    @Deprecated
    public static boolean FH(Context context, int i) {
        return i == 18 ? true : i == 1 ? j6(context, "com.google.android.gms") : false;
    }

    public static boolean Hw(Context context) {
        return FH(context) || !j6();
    }

    @Deprecated
    public static int VH(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return i;
        }
    }

    public static String Zo(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo j6;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            j6 = hl.DW(context).j6(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            j6 = null;
        }
        return j6 != null ? packageManager.getApplicationLabel(j6).toString() : packageName;
    }

    @TargetApi(18)
    public static boolean gn(Context context) {
        if (agb.Zo()) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }

    private static void j6(Context context) {
        if (!u7.get()) {
            u7(context);
            if (VH == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (VH != DW) {
                int i = DW;
                int i2 = VH;
                String valueOf = String.valueOf("com.google.android.gms.version");
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 290).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(i).append(" but found ").append(i2).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"").append(valueOf).append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        }
    }

    @Deprecated
    public static boolean j6() {
        return "user".equals(Build.TYPE);
    }

    static boolean j6(int i) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
            case 42:
                return true;
            default:
                return false;
        }
    }

    @TargetApi(21)
    static boolean j6(Context context, String str) {
        if (agb.tp()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        if (gn(context)) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 8192).enabled;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void tp(android.content.Context r7) {
        /*
        r6 = 1;
        r0 = r7.getPackageName();	 Catch:{ NameNotFoundException -> 0x003b }
        j6 = r0;	 Catch:{ NameNotFoundException -> 0x003b }
        r0 = com.google.android.gms.internal.hl.DW(r7);	 Catch:{ NameNotFoundException -> 0x003b }
        r1 = com.google.android.gms.common.internal.ad.DW(r7);	 Catch:{ NameNotFoundException -> 0x003b }
        VH = r1;	 Catch:{ NameNotFoundException -> 0x003b }
        r1 = "com.google.android.gms";
        r2 = 64;
        r0 = r0.DW(r1, r2);	 Catch:{ NameNotFoundException -> 0x003b }
        if (r0 == 0) goto L_0x0037;
    L_0x001c:
        r1 = com.google.android.gms.common.l.j6(r7);	 Catch:{ NameNotFoundException -> 0x003b }
        r2 = 1;
        r2 = new com.google.android.gms.common.j.a[r2];	 Catch:{ NameNotFoundException -> 0x003b }
        r3 = 0;
        r4 = com.google.android.gms.common.j.d.j6;	 Catch:{ NameNotFoundException -> 0x003b }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ NameNotFoundException -> 0x003b }
        r2[r3] = r4;	 Catch:{ NameNotFoundException -> 0x003b }
        r0 = r1.j6(r0, r2);	 Catch:{ NameNotFoundException -> 0x003b }
        if (r0 == 0) goto L_0x0037;
    L_0x0031:
        r0 = 1;
        v5 = r0;	 Catch:{ NameNotFoundException -> 0x003b }
    L_0x0034:
        gn = r6;
    L_0x0036:
        return;
    L_0x0037:
        r0 = 0;
        v5 = r0;	 Catch:{ NameNotFoundException -> 0x003b }
        goto L_0x0034;
    L_0x003b:
        r0 = move-exception;
        r1 = "GooglePlayServicesUtil";
        r2 = "Cannot find Google Play services package name.";
        android.util.Log.w(r1, r2, r0);	 Catch:{ all -> 0x0048 }
        gn = r6;
        goto L_0x0036;
    L_0x0048:
        r0 = move-exception;
        gn = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.k.tp(android.content.Context):void");
    }

    private static void u7(Context context) {
        if (!gn) {
            tp(context);
        }
    }

    public static Context v5(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }
}
