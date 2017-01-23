package com.cmcm.support.p116a;

import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.cmcm.support.a.g */
public class C2194g {
    protected Map<String, String> f7590c;

    public C2194g() {
        this.f7590c = new HashMap();
    }

    public static String m8252a(String str) {
        return str == null ? BuildConfig.FLAVOR : str.length() > 0 ? str.replaceAll("%", "%25").replaceAll("&", "%26").replaceAll("=", "%3d") : str;
    }

    public static String m8253a(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append((String) entry.getKey()).append("=").append((String) entry.getValue()).append("&");
        }
        if (stringBuilder.length() > 1) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public void m8254a(String str, int i) {
        this.f7590c.put(str, Integer.toString(i));
    }

    public void m8255a(String str, long j) {
        this.f7590c.put(str, Long.toString(j));
    }

    public void m8256a(String str, String str2) {
        this.f7590c.put(str, C2194g.m8252a(str2));
    }

    public String m8257b() {
        return C2194g.m8253a(this.f7590c);
    }
}
