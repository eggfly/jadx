package com.google.android.gms.p146b;

import java.util.HashMap;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.ay */
public class ay {
    private final Map<String, aw> f10342a;
    private final az f10343b;

    public ay(az azVar) {
        this.f10343b = azVar;
        this.f10342a = new HashMap();
    }

    public az m11846a() {
        return this.f10343b;
    }

    public void m11847a(String str, aw awVar) {
        this.f10342a.put(str, awVar);
    }

    public void m11848a(String str, String str2, long j) {
        au.m11833a(this.f10343b, (aw) this.f10342a.get(str2), j, str);
        this.f10342a.put(str, au.m11832a(this.f10343b, j));
    }
}
