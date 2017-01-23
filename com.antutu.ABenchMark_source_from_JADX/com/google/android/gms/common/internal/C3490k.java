package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

/* renamed from: com.google.android.gms.common.internal.k */
public abstract class C3490k {
    private static final Object f12092a;
    private static C3490k f12093b;

    static {
        f12092a = new Object();
    }

    public static C3490k m14388a(Context context) {
        synchronized (f12092a) {
            if (f12093b == null) {
                f12093b = new C3494l(context.getApplicationContext());
            }
        }
        return f12093b;
    }

    public abstract boolean m14389a(String str, ServiceConnection serviceConnection, String str2);

    public abstract void m14390b(String str, ServiceConnection serviceConnection, String str2);
}
