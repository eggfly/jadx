package com.antutu.redacc.p067f;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* renamed from: com.antutu.redacc.f.l */
public class C1755l {
    private static C1755l f6188a;
    private SharedPreferences f6189b;

    private C1755l(Context context) {
        this.f6189b = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static C1755l m6760a(Context context) {
        if (f6188a == null) {
            f6188a = new C1755l(context);
        }
        return f6188a;
    }

    public boolean m6761a(String str, boolean z) {
        try {
            z = this.f6189b.getBoolean(str, z);
        } catch (Exception e) {
        }
        return z;
    }

    public void m6762b(String str, boolean z) {
        try {
            this.f6189b.edit().putBoolean(str, z).commit();
        } catch (Exception e) {
        }
    }
}
