package com.google.android.gms.p146b;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.b.jx */
public class jx {
    public static <T> T m13581a(Callable<T> callable) {
        T call;
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(ThreadPolicy.LAX);
            call = callable.call();
        } catch (Throwable th) {
            call = null;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        return call;
    }
}
