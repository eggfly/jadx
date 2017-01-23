package com.xiaomi.mistatistic.sdk.data;

import org.json.JSONObject;

/* renamed from: com.xiaomi.mistatistic.sdk.data.h */
public class C0607h extends AbstractEvent {
    private String f4839b;
    private Long f4840c;
    private long f4841d;

    public C0607h(String str, Long l) {
        this.f4839b = str;
        this.f4841d = l.longValue();
    }

    public void m6569a(Long l) {
        this.f4840c = l;
    }

    public long m6572d() {
        return this.f4841d;
    }

    public String m6573e() {
        return this.f4839b;
    }

    public String m6568a() {
        return "mistat_pt";
    }

    public JSONObject m6570b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", this.f4839b);
        jSONObject.put("value", this.f4840c);
        return jSONObject;
    }

    public StatEventPojo m6571c() {
        StatEventPojo statEventPojo = new StatEventPojo();
        statEventPojo.f4821a = m6568a();
        statEventPojo.f4822b = this.a;
        statEventPojo.f4823c = this.f4839b;
        statEventPojo.f4825e = Long.toString(this.f4840c.longValue());
        return statEventPojo;
    }
}
