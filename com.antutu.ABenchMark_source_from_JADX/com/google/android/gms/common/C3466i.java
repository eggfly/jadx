package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.C3464g.C3458a;
import com.google.android.gms.common.C3464g.C3459b;
import com.google.android.gms.common.C3464g.C3463d;

/* renamed from: com.google.android.gms.common.i */
public class C3466i {
    private static final C3466i f12017a;

    static {
        f12017a = new C3466i();
    }

    private C3466i() {
    }

    public static C3466i m14304a() {
        return f12017a;
    }

    C3458a m14305a(PackageInfo packageInfo, C3458a... c3458aArr) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        C3458a c3459b = new C3459b(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < c3458aArr.length; i++) {
            if (c3458aArr[i].equals(c3459b)) {
                return c3458aArr[i];
            }
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(c3459b.m14280a(), 0));
        }
        return null;
    }

    public boolean m14306a(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            C3458a a;
            if (z) {
                a = m14305a(packageInfo, C3463d.f12007a);
            } else {
                a = m14305a(packageInfo, C3463d.f12007a[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }

    public boolean m14307a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (C3465h.m14297b(packageManager)) {
            return m14306a(packageInfo, true);
        }
        boolean a = m14306a(packageInfo, false);
        if (a || !m14306a(packageInfo, true)) {
            return a;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return a;
    }
}
