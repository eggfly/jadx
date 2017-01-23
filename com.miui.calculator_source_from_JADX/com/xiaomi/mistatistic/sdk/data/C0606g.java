package com.xiaomi.mistatistic.sdk.data;

import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.xiaomi.mistatistic.sdk.data.g */
public class C0606g extends AbstractEvent {
    private String f4836b;
    private String f4837c;
    private String f4838d;

    public C0606g(String str, String str2, String str3) {
        this.f4836b = str;
        this.f4837c = str2;
        this.f4838d = str3;
    }

    public String m6565a() {
        return this.f4836b;
    }

    public JSONObject m6566b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("category", this.f4836b);
        jSONObject.put("key", this.f4837c);
        jSONObject.put("type", "property");
        jSONObject.put("value", this.f4838d);
        return jSONObject;
    }

    public StatEventPojo m6567c() {
        StatEventPojo statEventPojo = new StatEventPojo();
        statEventPojo.f4821a = this.f4836b;
        statEventPojo.f4823c = this.f4837c;
        statEventPojo.f4822b = this.a;
        statEventPojo.f4825e = this.f4838d;
        statEventPojo.f4824d = "property";
        return statEventPojo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0606g)) {
            return false;
        }
        C0606g c0606g = (C0606g) obj;
        if (TextUtils.equals(this.f4836b, c0606g.f4836b) && TextUtils.equals(this.f4837c, c0606g.f4837c) && TextUtils.equals(this.f4838d, c0606g.f4838d)) {
            return true;
        }
        return false;
    }
}
