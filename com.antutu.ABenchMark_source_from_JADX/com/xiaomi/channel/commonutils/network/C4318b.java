package com.xiaomi.channel.commonutils.network;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.channel.commonutils.network.b */
public class C4318b {
    public int f14753a;
    public Map<String, String> f14754b;
    public String f14755c;

    public C4318b() {
        this.f14754b = new HashMap();
    }

    public String m17693a() {
        return this.f14755c;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", new Object[]{Integer.valueOf(this.f14753a), this.f14754b.toString(), this.f14755c});
    }
}
