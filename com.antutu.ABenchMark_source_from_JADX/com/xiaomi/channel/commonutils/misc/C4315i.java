package com.xiaomi.channel.commonutils.misc;

import android.os.Looper;

/* renamed from: com.xiaomi.channel.commonutils.misc.i */
public class C4315i {
    public static void m17688a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new RuntimeException("can't do this on ui thread");
        }
    }
}
