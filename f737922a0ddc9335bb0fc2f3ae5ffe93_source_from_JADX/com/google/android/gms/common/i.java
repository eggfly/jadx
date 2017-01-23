package com.google.android.gms.common;

import aft;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.u;

public class i {
    public static final int DW;
    private static final i j6;

    static {
        DW = k.DW;
        j6 = new i();
    }

    i() {
    }

    public static i DW() {
        return j6;
    }

    private String DW(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(DW);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public int DW(Context context) {
        return k.VH(context);
    }

    public int j6(Context context) {
        int DW = k.DW(context);
        return k.FH(context, DW) ? 18 : DW;
    }

    public PendingIntent j6(Context context, int i, int i2) {
        return j6(context, i, i2, null);
    }

    public PendingIntent j6(Context context, int i, int i2, String str) {
        if (aft.j6(context) && i == 2) {
            i = 42;
        }
        Intent j6 = j6(context, i, str);
        return j6 == null ? null : PendingIntent.getActivity(context, i2, j6, 268435456);
    }

    public Intent j6(Context context, int i, String str) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return u.j6("com.google.android.gms", DW(context, str));
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return u.j6("com.google.android.gms");
            case 42:
                return u.j6();
            default:
                return null;
        }
    }

    public boolean j6(int i) {
        return k.DW(i);
    }

    public boolean j6(Context context, String str) {
        return k.j6(context, str);
    }
}
