package com.antutu.redacc.p067f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;

/* renamed from: com.antutu.redacc.f.b */
public class C1745b {
    private static volatile C1745b f6176a;
    private SharedPreferences f6177b;

    static {
        f6176a = null;
    }

    public C1745b(Context context) {
        this.f6177b = null;
        this.f6177b = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
    }

    public static C1745b m6737a(Context context) {
        if (f6176a == null) {
            synchronized (C1745b.class) {
                if (f6176a == null) {
                    f6176a = new C1745b(context.getApplicationContext());
                }
            }
        }
        return f6176a;
    }

    private void m6738a(Editor editor) {
        try {
            if (VERSION.SDK_INT > 8) {
                editor.apply();
            } else {
                editor.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e2) {
            e2.printStackTrace();
        }
    }

    private long m6739b() {
        return this.f6177b.getLong("cool_off_finish_time", 0);
    }

    private int m6740c() {
        return this.f6177b.getInt("cool_off_finish_time_random", 0);
    }

    public int m6741a(int i) {
        return System.currentTimeMillis() - m6739b() < 120000 ? i - m6740c() : i;
    }

    public void m6742a() {
        Editor edit = this.f6177b.edit();
        edit.putLong("cool_off_finish_time", System.currentTimeMillis());
        edit.putInt("cool_off_finish_time_random", (int) ((Math.random() + 1.0d) * 10.0d));
        m6738a(edit);
    }
}
