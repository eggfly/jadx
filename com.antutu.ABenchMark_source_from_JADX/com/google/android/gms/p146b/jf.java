package com.google.android.gms.p146b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.internal.C3475f;

/* renamed from: com.google.android.gms.b.jf */
public class jf {
    public static boolean m13541a() {
        return C3475f.f12055a && ja.m13515b() && ja.m13511a() == Process.myUid();
    }

    public static boolean m13542a(Context context, String str) {
        try {
            return (context.getPackageManager().getApplicationInfo(str, 0).flags & AccessibilityNodeInfoCompat.ACTION_SET_TEXT) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
