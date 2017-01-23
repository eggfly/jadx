package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.b;

public class l {
    private static l j6;
    private final Context DW;

    private l(Context context) {
        this.DW = context.getApplicationContext();
    }

    public static l j6(Context context) {
        b.j6((Object) context);
        synchronized (l.class) {
            if (j6 == null) {
                j.j6(context);
                j6 = new l(context);
            }
        }
        return j6;
    }

    a j6(PackageInfo packageInfo, a... aVarArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        a bVar = new b(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < aVarArr.length; i++) {
            if (aVarArr[i].equals(bVar)) {
                return aVarArr[i];
            }
        }
        String valueOf = String.valueOf(packageInfo.packageName);
        String valueOf2 = String.valueOf(Base64.encodeToString(bVar.FH(), 0));
        Log.v("GoogleSignatureVerifier", new StringBuilder((String.valueOf(valueOf).length() + 31) + String.valueOf(valueOf2).length()).append(valueOf).append(" signature not valid.  Found: \n").append(valueOf2).toString());
        return null;
    }

    public boolean j6(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            a j6;
            if (z) {
                j6 = j6(packageInfo, d.j6);
            } else {
                j6 = j6(packageInfo, d.j6[0]);
            }
            if (j6 != null) {
                return true;
            }
        }
        return false;
    }

    public boolean j6(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (k.Hw(this.DW)) {
            return j6(packageInfo, true);
        }
        boolean j6 = j6(packageInfo, false);
        if (j6 || !j6(packageInfo, true)) {
            return j6;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return j6;
    }
}
