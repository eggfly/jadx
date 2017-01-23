package com.antutu.benchmark.p043g;

import android.content.Context;
import android.preference.PreferenceManager;

/* renamed from: com.antutu.benchmark.g.c */
public class C1504c {
    private static volatile C1504c f5165b;
    private C1503b f5166a;

    static {
        f5165b = null;
    }

    private C1504c() {
        this.f5166a = C1503b.m5915c();
    }

    public static C1504c m5974a() {
        if (f5165b == null) {
            synchronized (C1504c.class) {
                if (f5165b == null) {
                    f5165b = new C1504c();
                }
            }
        }
        return f5165b;
    }

    public void m5975a(Context context) {
        this.f5166a.m5927a(context, PreferenceManager.getDefaultSharedPreferences(context));
    }
}
