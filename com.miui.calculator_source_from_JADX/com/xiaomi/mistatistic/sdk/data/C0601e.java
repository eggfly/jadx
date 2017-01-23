package com.xiaomi.mistatistic.sdk.data;

import android.text.TextUtils;
import com.xiaomi.mistatistic.sdk.controller.C0566h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.xiaomi.mistatistic.sdk.data.e */
public abstract class C0601e extends AbstractEvent {
    protected long f4831b;
    private String f4832c;
    private String f4833d;
    private Map<String, String> f4834e;

    public abstract String m6558d();

    public C0601e(String str, String str2, long j) {
        this(str, str2, j, null);
    }

    public C0601e(String str, String str2, long j, Map<String, String> map) {
        this.f4832c = str;
        this.f4833d = str2;
        this.f4831b = j;
        if (map == null) {
            this.f4834e = null;
        } else {
            this.f4834e = new HashMap(map);
        }
    }

    public String m6555a() {
        return this.f4832c;
    }

    public JSONObject m6556b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("category", this.f4832c);
        jSONObject.put("key", this.f4833d);
        jSONObject.put("type", m6558d());
        jSONObject.put("value", this.f4831b);
        if (this.f4834e != null) {
            jSONObject.put("params", new JSONObject(this.f4834e));
        }
        return jSONObject;
    }

    public StatEventPojo m6557c() {
        StatEventPojo statEventPojo = new StatEventPojo();
        statEventPojo.f4821a = this.f4832c;
        statEventPojo.f4823c = this.f4833d;
        statEventPojo.f4822b = this.a;
        statEventPojo.f4824d = m6558d();
        statEventPojo.f4825e = String.valueOf(this.f4831b);
        statEventPojo.f4826f = m6554a(this.f4834e);
        return statEventPojo;
    }

    private String m6554a(Map<String, String> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str : map.keySet()) {
                        jSONObject.put(str, map.get(str));
                    }
                    return jSONObject.toString();
                }
            } catch (Throwable e) {
                C0566h.m6418a("json error", e);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0601e)) {
            return false;
        }
        C0601e c0601e = (C0601e) obj;
        if (TextUtils.equals(this.f4832c, c0601e.f4832c) && TextUtils.equals(this.f4833d, c0601e.f4833d) && TextUtils.equals(m6558d(), c0601e.m6558d()) && this.f4831b == c0601e.f4831b && this.f4834e != null) {
            return this.f4834e.equals(c0601e.f4834e);
        }
        return true;
    }
}
