package com.cmcm.p074a.p075a.p112a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: com.cmcm.a.a.a.ae */
public class ae {
    public static PackageInfo m7933a(Context context, String str) {
        PackageInfo packageInfo = null;
        if (!(context == null || str == null)) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (Exception e) {
            }
        }
        return packageInfo;
    }

    public static boolean m7934a(Context context) {
        boolean z = true;
        if (!ae.m7935b(context, "com.android.vending")) {
            return false;
        }
        PackageInfo a = ae.m7933a(context, "com.google.android.gsf");
        if (a == null || a.applicationInfo == null || (a.applicationInfo.flags & 1) != 1) {
            z = false;
        }
        return z;
    }

    public static boolean m7935b(Context context, String str) {
        if (context == null || str == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
