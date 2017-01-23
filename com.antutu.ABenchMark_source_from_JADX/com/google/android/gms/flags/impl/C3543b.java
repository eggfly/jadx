package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.p146b.jx;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.b */
public class C3543b {
    private static SharedPreferences f12229a;

    /* renamed from: com.google.android.gms.flags.impl.b.1 */
    static class C35421 implements Callable<SharedPreferences> {
        final /* synthetic */ Context f12228a;

        C35421(Context context) {
            this.f12228a = context;
        }

        public SharedPreferences m14746a() {
            return this.f12228a.getSharedPreferences("google_sdk_flags", 1);
        }

        public /* synthetic */ Object call() {
            return m14746a();
        }
    }

    static {
        f12229a = null;
    }

    public static SharedPreferences m14747a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f12229a == null) {
                f12229a = (SharedPreferences) jx.m13581a(new C35421(context));
            }
            sharedPreferences = f12229a;
        }
        return sharedPreferences;
    }
}
