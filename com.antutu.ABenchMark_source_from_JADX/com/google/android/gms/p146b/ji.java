package com.google.android.gms.p146b;

import android.os.SystemClock;

/* renamed from: com.google.android.gms.b.ji */
public final class ji implements jg {
    private static ji f11562a;

    public static synchronized jg m13553d() {
        jg jgVar;
        synchronized (ji.class) {
            if (f11562a == null) {
                f11562a = new ji();
            }
            jgVar = f11562a;
        }
        return jgVar;
    }

    public long m13554a() {
        return System.currentTimeMillis();
    }

    public long m13555b() {
        return SystemClock.elapsedRealtime();
    }

    public long m13556c() {
        return System.nanoTime();
    }
}
