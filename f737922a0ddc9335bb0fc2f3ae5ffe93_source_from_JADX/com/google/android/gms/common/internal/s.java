package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class s {
    private static s DW;
    private static final Object j6;

    static {
        j6 = new Object();
    }

    public static s j6(Context context) {
        synchronized (j6) {
            if (DW == null) {
                DW = new t(context.getApplicationContext());
            }
        }
        return DW;
    }

    public abstract void DW(String str, String str2, ServiceConnection serviceConnection, String str3);

    public abstract boolean j6(String str, String str2, ServiceConnection serviceConnection, String str3);
}
