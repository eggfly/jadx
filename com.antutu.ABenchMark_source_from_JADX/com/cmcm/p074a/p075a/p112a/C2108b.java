package com.cmcm.p074a.p075a.p112a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;

/* renamed from: com.cmcm.a.a.a.b */
public class C2108b {
    private static HashMap f7414a;
    private static HashMap f7415b;
    private SharedPreferences f7416c;

    static {
        f7414a = new HashMap();
        f7415b = new HashMap();
        f7415b.put("report_timestamp", Long.valueOf(0));
        f7415b.put("config_version", null);
        f7415b.put("config_verion_timestamp", Long.valueOf(0));
        f7415b.put("config_update_timestamp", Long.valueOf(0));
        f7415b.put("receiver_priority_version", Integer.valueOf(-1));
        f7415b.put("report_heartbeat", Long.valueOf(0));
    }

    private C2108b(String str) {
        this.f7416c = C2126s.m8027a(str);
    }

    public static C2108b m7936a() {
        return C2108b.m7937a("default");
    }

    public static synchronized C2108b m7937a(String str) {
        C2108b c2108b;
        synchronized (C2108b.class) {
            c2108b = (C2108b) f7414a.get(str);
            if (c2108b == null) {
                c2108b = new C2108b(str);
                f7414a.put(str, c2108b);
            }
        }
        return c2108b;
    }

    public long m7938b(String str) {
        Long l = (Long) f7415b.get(str);
        return this.f7416c.getLong(str, l == null ? 0 : l.longValue());
    }

    public SharedPreferences m7939b() {
        return this.f7416c;
    }

    public Editor m7940c() {
        return this.f7416c.edit();
    }

    public String m7941c(String str) {
        return this.f7416c.getString(str, (String) f7415b.get(str));
    }
}
