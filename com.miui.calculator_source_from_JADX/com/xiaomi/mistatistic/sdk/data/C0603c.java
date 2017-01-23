package com.xiaomi.mistatistic.sdk.data;

import org.json.JSONObject;

/* renamed from: com.xiaomi.mistatistic.sdk.data.c */
public class C0603c extends AbstractEvent {
    private String f4835b;

    public String m6560a() {
        return "mistat_extra";
    }

    public JSONObject m6561b() {
        return null;
    }

    public StatEventPojo m6562c() {
        StatEventPojo statEventPojo = new StatEventPojo();
        statEventPojo.f4821a = m6560a();
        statEventPojo.f4822b = this.a;
        statEventPojo.f4825e = this.f4835b;
        return statEventPojo;
    }
}
