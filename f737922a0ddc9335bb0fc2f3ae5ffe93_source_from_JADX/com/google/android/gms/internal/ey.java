package com.google.android.gms.internal;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.concurrent.Callable;

@eh
public class ey {
    public static <T> T j6(Callable<T> callable) {
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        T call;
        try {
            StrictMode.setThreadPolicy(new Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            call = callable.call();
            return call;
        } catch (Throwable th) {
            call = th;
            b.DW("Unexpected exception.", call);
            f.Zo().j6((Throwable) call, true);
            return null;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
