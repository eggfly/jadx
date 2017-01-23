package com.cmcm.support;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Random;

@SuppressLint({"CommitPrefEdits"})
/* renamed from: com.cmcm.support.h */
public class C2236h {
    private SharedPreferences f7702a;

    @SuppressLint({"NewApi"})
    /* renamed from: com.cmcm.support.h.a */
    public static class C2235a {
        private static boolean f7701a;

        static {
            f7701a = false;
        }

        public static void m8427a(Editor editor) {
            if (f7701a) {
                Log.d("show", "SDK_INT  = " + VERSION.SDK_INT);
            }
            if (VERSION.SDK_INT >= 9) {
                editor.apply();
            } else {
                editor.commit();
            }
        }
    }

    public C2236h() {
        this.f7702a = null;
    }

    private int m8428a(String str, int i) {
        return this.f7702a != null ? this.f7702a.getInt(str, i) : i;
    }

    private long m8429a(String str, long j) {
        return this.f7702a != null ? this.f7702a.getLong(str, j) : j;
    }

    private boolean m8430a(String str, boolean z) {
        return this.f7702a != null ? this.f7702a.getBoolean(str, z) : false;
    }

    private boolean m8431b(String str, int i) {
        if (this.f7702a == null) {
            return false;
        }
        Editor edit = this.f7702a.edit();
        edit.putInt(str, i);
        C2235a.m8427a(edit);
        return true;
    }

    private boolean m8432b(String str, long j) {
        if (this.f7702a == null) {
            return false;
        }
        Editor edit = this.f7702a.edit();
        edit.putLong(str, j);
        C2235a.m8427a(edit);
        return true;
    }

    private boolean m8433b(String str, String str2) {
        if (this.f7702a == null) {
            return false;
        }
        Editor edit = this.f7702a.edit();
        edit.putString(str, str2);
        C2235a.m8427a(edit);
        return true;
    }

    private boolean m8434b(String str, boolean z) {
        if (this.f7702a == null) {
            return false;
        }
        Editor edit = this.f7702a.edit();
        edit.putBoolean(str, z);
        C2235a.m8427a(edit);
        return true;
    }

    private String m8435c(String str, String str2) {
        return this.f7702a != null ? this.f7702a.getString(str, str2) : str2;
    }

    public long m8436a() {
        return m8429a("last_batch_report_time", 0);
    }

    public long m8437a(int i) {
        return m8429a("last_report_active_time_" + String.valueOf(i), 0);
    }

    public void m8438a(String str, String str2) {
        m8433b(str + Constants.SP_KEY_VERSION, str2);
    }

    public boolean m8439a(int i, long j) {
        return m8432b("last_report_active_time_" + String.valueOf(i), j);
    }

    public boolean m8440a(long j) {
        return m8432b("last_batch_report_time", j);
    }

    public boolean m8441a(SharedPreferences sharedPreferences) {
        this.f7702a = sharedPreferences;
        return true;
    }

    public boolean m8442a(String str) {
        return m8430a(str + "_need_report", true);
    }

    public boolean m8443a(String str, C2237i c2237i) {
        int a = m8428a(str + "_user_probability", 10000);
        int b = c2237i.m8449b(str);
        double nextDouble = new Random(System.currentTimeMillis()).nextDouble();
        if (a != b && b < 10000 && ((int) (nextDouble * 10000.0d)) > b) {
            m8431b(str + "_user_probability", b);
            m8434b(str + "_need_report", false);
        }
        return true;
    }

    public String m8444b(String str) {
        return m8435c(str + Constants.SP_KEY_VERSION, BuildConfig.FLAVOR);
    }
}
