package com.xiaomi.mistatistic.sdk.data;

import org.json.JSONObject;

/* renamed from: com.xiaomi.mistatistic.sdk.data.j */
public class C0609j extends AbstractEvent {
    private long f4844b;
    private long f4845c;
    private String f4846d;

    public C0609j(long j, long j2, String str) {
        this.f4844b = j;
        this.f4845c = j2;
        this.f4846d = str;
    }

    public String m6577a() {
        return "mistat_session";
    }

    public JSONObject m6578b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("start", this.f4844b);
        jSONObject.put("end", this.f4845c);
        jSONObject.put("env", this.f4846d);
        return jSONObject;
    }

    public StatEventPojo m6579c() {
        StatEventPojo statEventPojo = new StatEventPojo();
        statEventPojo.f4821a = m6577a();
        statEventPojo.f4822b = this.a;
        statEventPojo.f4825e = this.f4844b + "," + this.f4845c;
        statEventPojo.f4826f = this.f4846d;
        return statEventPojo;
    }
}
