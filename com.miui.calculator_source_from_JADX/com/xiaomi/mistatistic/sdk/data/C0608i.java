package com.xiaomi.mistatistic.sdk.data;

import org.json.JSONObject;

/* renamed from: com.xiaomi.mistatistic.sdk.data.i */
public class C0608i extends AbstractEvent {
    private String f4842b;
    private String f4843c;

    public C0608i(String str, String str2) {
        this.f4842b = str;
        this.f4843c = str2;
    }

    public String m6574a() {
        return "mistat_pv";
    }

    public JSONObject m6575b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("path", this.f4842b);
        jSONObject.put("source", this.f4843c);
        return jSONObject;
    }

    public StatEventPojo m6576c() {
        StatEventPojo statEventPojo = new StatEventPojo();
        statEventPojo.f4821a = m6574a();
        statEventPojo.f4822b = this.a;
        statEventPojo.f4825e = this.f4842b;
        statEventPojo.f4826f = this.f4843c;
        return statEventPojo;
    }
}
