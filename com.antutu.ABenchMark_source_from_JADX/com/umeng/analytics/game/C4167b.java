package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.umeng.analytics.C4156a;
import java.io.Serializable;
import p023b.p024a.C0886o;
import p023b.p024a.C0888r;

/* renamed from: com.umeng.analytics.game.b */
public class C4167b {
    public String f14001a;
    public String f14002b;
    private Context f14003c;
    private final String f14004d;
    private final String f14005e;
    private final String f14006f;
    private final String f14007g;
    private C4166a f14008h;

    /* renamed from: com.umeng.analytics.game.b.a */
    static class C4166a implements Serializable {
        private static final long f13997a = 20140327;
        private String f13998b;
        private long f13999c;
        private long f14000d;

        public C4166a(String str) {
            this.f13998b = str;
        }

        public void m17016a() {
            this.f14000d = System.currentTimeMillis();
        }

        public boolean m17017a(String str) {
            return this.f13998b.equals(str);
        }

        public void m17018b() {
            this.f13999c += System.currentTimeMillis() - this.f14000d;
            this.f14000d = 0;
        }

        public void m17019c() {
            m17016a();
        }

        public void m17020d() {
            m17018b();
        }

        public long m17021e() {
            return this.f13999c;
        }

        public String m17022f() {
            return this.f13998b;
        }
    }

    public C4167b(Context context) {
        this.f14004d = "um_g_cache";
        this.f14005e = "single_level";
        this.f14006f = "stat_player_level";
        this.f14007g = "stat_game_level";
        this.f14008h = null;
        this.f14003c = context;
    }

    public C4166a m17023a(String str) {
        this.f14008h = new C4166a(str);
        this.f14008h.m17016a();
        return this.f14008h;
    }

    public void m17024a() {
        if (this.f14008h != null) {
            this.f14008h.m17018b();
            Editor edit = this.f14003c.getSharedPreferences("um_g_cache", 0).edit();
            edit.putString("single_level", C0886o.m3928a(this.f14008h));
            edit.putString("stat_player_level", this.f14002b);
            edit.putString("stat_game_level", this.f14001a);
            edit.commit();
        }
    }

    public C4166a m17025b(String str) {
        if (this.f14008h != null) {
            this.f14008h.m17020d();
            if (this.f14008h.m17017a(str)) {
                C4166a c4166a = this.f14008h;
                this.f14008h = null;
                return c4166a;
            }
        }
        return null;
    }

    public void m17026b() {
        SharedPreferences a = C0888r.m3933a(this.f14003c, "um_g_cache");
        String string = a.getString("single_level", null);
        if (string != null) {
            this.f14008h = (C4166a) C0886o.m3927a(string);
            if (this.f14008h != null) {
                this.f14008h.m17019c();
            }
        }
        if (this.f14002b == null) {
            this.f14002b = a.getString("stat_player_level", null);
            if (this.f14002b == null) {
                SharedPreferences a2 = C0888r.m3932a(this.f14003c);
                if (a2 != null) {
                    this.f14002b = a2.getString(C4156a.f13938A, null);
                } else {
                    return;
                }
            }
        }
        if (this.f14001a == null) {
            this.f14001a = a.getString("stat_game_level", null);
        }
    }
}
