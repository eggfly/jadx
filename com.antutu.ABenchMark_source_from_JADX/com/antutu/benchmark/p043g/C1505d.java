package com.antutu.benchmark.p043g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;

/* renamed from: com.antutu.benchmark.g.d */
public class C1505d {
    private static volatile C1505d f5167c;
    private final byte[] f5168a;
    private SharedPreferences f5169b;

    static {
        f5167c = null;
    }

    public C1505d(Context context) {
        this.f5168a = new byte[0];
        this.f5169b = null;
        this.f5169b = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
    }

    public C1505d(Context context, String str) {
        this.f5168a = new byte[0];
        this.f5169b = null;
        this.f5169b = context.getApplicationContext().getSharedPreferences(context.getPackageName() + str, 0);
    }

    public static C1505d m5976a(Context context) {
        if (f5167c == null) {
            synchronized (C1505d.class) {
                if (f5167c == null) {
                    f5167c = new C1505d(context.getApplicationContext());
                }
            }
        }
        return f5167c;
    }

    public static C1505d m5977a(Context context, String str) {
        if (f5167c == null) {
            synchronized (C1505d.class) {
                if (f5167c == null) {
                    f5167c = new C1505d(context.getApplicationContext(), str);
                }
            }
        }
        return f5167c;
    }

    public static void m5978a(Editor editor) {
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

    private SharedPreferences m5979b() {
        return this.f5169b;
    }

    public long m5980a(String str, long j) {
        return m5979b().getLong(str, j);
    }

    public Editor m5981a() {
        return m5979b().edit();
    }

    public void m5982a(String str, int i) {
        synchronized (this.f5168a) {
            Editor a = m5981a();
            a.putInt(str, i);
            C1505d.m5978a(a);
        }
    }

    public void m5983a(String str, Long l) {
        synchronized (this.f5168a) {
            Editor a = m5981a();
            a.putLong(str, l.longValue());
            C1505d.m5978a(a);
        }
    }

    public void m5984a(String str, String str2) {
        synchronized (this.f5168a) {
            Editor a = m5981a();
            a.putString(str, str2);
            C1505d.m5978a(a);
        }
    }

    public void m5985a(String str, boolean z) {
        synchronized (this.f5168a) {
            Editor a = m5981a();
            a.putBoolean(str, z);
            C1505d.m5978a(a);
        }
    }

    public int m5986b(String str, int i) {
        return m5979b().getInt(str, i);
    }

    public String m5987b(String str, String str2) {
        return m5979b().getString(str, str2);
    }

    public boolean m5988b(String str, boolean z) {
        return m5979b().getBoolean(str, z);
    }
}
