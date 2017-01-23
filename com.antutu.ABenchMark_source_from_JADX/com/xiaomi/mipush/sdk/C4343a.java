package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.analytics.tracking.android.ModelFields;
import com.xiaomi.channel.commonutils.android.C4290b;
import com.xiaomi.channel.commonutils.android.C4293e;
import com.xiaomi.channel.commonutils.logger.C4302b;

/* renamed from: com.xiaomi.mipush.sdk.a */
public class C4343a {
    private static C4343a f14801a;
    private Context f14802b;
    private C4342a f14803c;

    /* renamed from: com.xiaomi.mipush.sdk.a.a */
    private class C4342a {
        public String f14790a;
        public String f14791b;
        public String f14792c;
        public String f14793d;
        public String f14794e;
        public String f14795f;
        public String f14796g;
        public boolean f14797h;
        public boolean f14798i;
        public int f14799j;
        final /* synthetic */ C4343a f14800k;

        private C4342a(C4343a c4343a) {
            this.f14800k = c4343a;
            this.f14797h = true;
            this.f14798i = false;
            this.f14799j = 1;
        }

        private String m17790d() {
            return C4290b.m17598a(this.f14800k.f14802b, this.f14800k.f14802b.getPackageName());
        }

        public void m17791a(int i) {
            this.f14799j = i;
        }

        public void m17792a(String str, String str2) {
            this.f14792c = str;
            this.f14793d = str2;
            this.f14795f = C4293e.m17613e(this.f14800k.f14802b);
            this.f14794e = m17790d();
            this.f14797h = true;
            Editor edit = this.f14800k.m17817j().edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f14795f);
            edit.putString("vName", m17790d());
            edit.putBoolean("valid", true);
            edit.commit();
        }

        public void m17793a(String str, String str2, String str3) {
            this.f14790a = str;
            this.f14791b = str2;
            this.f14796g = str3;
            Editor edit = this.f14800k.m17817j().edit();
            edit.putString(ModelFields.APP_ID, this.f14790a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void m17794a(boolean z) {
            this.f14798i = z;
        }

        public boolean m17795a() {
            return m17797b(this.f14790a, this.f14791b);
        }

        public void m17796b() {
            this.f14800k.m17817j().edit().clear().commit();
            this.f14790a = null;
            this.f14791b = null;
            this.f14792c = null;
            this.f14793d = null;
            this.f14795f = null;
            this.f14794e = null;
            this.f14797h = false;
            this.f14798i = false;
            this.f14799j = 1;
        }

        public boolean m17797b(String str, String str2) {
            return TextUtils.equals(this.f14790a, str) && TextUtils.equals(this.f14791b, str2) && !TextUtils.isEmpty(this.f14792c) && !TextUtils.isEmpty(this.f14793d) && TextUtils.equals(this.f14795f, C4293e.m17613e(this.f14800k.f14802b));
        }

        public void m17798c() {
            this.f14797h = false;
            this.f14800k.m17817j().edit().putBoolean("valid", this.f14797h).commit();
        }
    }

    private C4343a(Context context) {
        this.f14802b = context;
        m17801o();
    }

    public static C4343a m17800a(Context context) {
        if (f14801a == null) {
            f14801a = new C4343a(context);
        }
        return f14801a;
    }

    private void m17801o() {
        this.f14803c = new C4342a();
        SharedPreferences j = m17817j();
        this.f14803c.f14790a = j.getString(ModelFields.APP_ID, null);
        this.f14803c.f14791b = j.getString("appToken", null);
        this.f14803c.f14792c = j.getString("regId", null);
        this.f14803c.f14793d = j.getString("regSec", null);
        this.f14803c.f14795f = j.getString("devId", null);
        if (!TextUtils.isEmpty(this.f14803c.f14795f) && this.f14803c.f14795f.startsWith("a-")) {
            this.f14803c.f14795f = C4293e.m17613e(this.f14802b);
            j.edit().putString("devId", this.f14803c.f14795f).commit();
        }
        this.f14803c.f14794e = j.getString("vName", null);
        this.f14803c.f14797h = j.getBoolean("valid", true);
        this.f14803c.f14798i = j.getBoolean("paused", false);
        this.f14803c.f14799j = j.getInt("envType", 1);
        this.f14803c.f14796g = j.getString("regResource", null);
    }

    public void m17802a(int i) {
        this.f14803c.m17791a(i);
        m17817j().edit().putInt("envType", i).commit();
    }

    public void m17803a(String str) {
        Editor edit = m17817j().edit();
        edit.putString("vName", str);
        edit.commit();
        this.f14803c.f14794e = str;
    }

    public void m17804a(String str, String str2, String str3) {
        this.f14803c.m17793a(str, str2, str3);
    }

    public void m17805a(boolean z) {
        this.f14803c.m17794a(z);
        m17817j().edit().putBoolean("paused", z).commit();
    }

    public boolean m17806a() {
        return !TextUtils.equals(C4290b.m17598a(this.f14802b, this.f14802b.getPackageName()), this.f14803c.f14794e);
    }

    public boolean m17807a(String str, String str2) {
        return this.f14803c.m17797b(str, str2);
    }

    public void m17808b(String str, String str2) {
        this.f14803c.m17792a(str, str2);
    }

    public boolean m17809b() {
        if (this.f14803c.m17795a()) {
            return true;
        }
        C4302b.m17649a("Don't send message before initialization succeeded!");
        return false;
    }

    public String m17810c() {
        return this.f14803c.f14790a;
    }

    public String m17811d() {
        return this.f14803c.f14791b;
    }

    public String m17812e() {
        return this.f14803c.f14792c;
    }

    public String m17813f() {
        return this.f14803c.f14793d;
    }

    public String m17814g() {
        return this.f14803c.f14796g;
    }

    public void m17815h() {
        this.f14803c.m17796b();
    }

    public boolean m17816i() {
        return this.f14803c.m17795a();
    }

    public SharedPreferences m17817j() {
        return this.f14802b.getSharedPreferences("mipush", 0);
    }

    public void m17818k() {
        this.f14803c.m17798c();
    }

    public boolean m17819l() {
        return this.f14803c.f14798i;
    }

    public int m17820m() {
        return this.f14803c.f14799j;
    }

    public boolean m17821n() {
        return !this.f14803c.f14797h;
    }
}
