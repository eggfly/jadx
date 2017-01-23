package com.ijinshan.cloudconfig.p187b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.ijinshan.cloudconfig.p188c.C3952a;

/* renamed from: com.ijinshan.cloudconfig.b.a */
public class C3951a {
    private static C3951a f13252d;
    private final String f13253a;
    private SharedPreferences f13254b;
    private Context f13255c;

    private C3951a() {
        this.f13253a = "cloudconfig";
        this.f13255c = C3952a.m16250d();
        this.f13254b = this.f13255c.getSharedPreferences("cloudconfig", 0);
    }

    public static C3951a m16236a() {
        if (f13252d == null) {
            synchronized (C3951a.class) {
                if (f13252d == null) {
                    f13252d = new C3951a();
                }
            }
        }
        return f13252d;
    }

    public long m16237a(String str, long j) {
        return this.f13254b.getLong(str, j);
    }

    public void m16238a(String str, Long l) {
        Editor edit = this.f13254b.edit();
        edit.putLong(str, l.longValue());
        edit.commit();
    }

    public void m16239a(String str, String str2) {
        Editor edit = this.f13254b.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public String m16240b(String str, String str2) {
        return this.f13254b.getString(str, str2);
    }
}
