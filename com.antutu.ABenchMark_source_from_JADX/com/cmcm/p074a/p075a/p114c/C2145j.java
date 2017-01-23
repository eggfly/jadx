package com.cmcm.p074a.p075a.p114c;

import android.content.IntentFilter;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cmcm.a.a.c.j */
public class C2145j extends C2136b {
    private C2147l f7502a;
    private int f7503b;

    public C2145j() {
        this.f7503b = 0;
    }

    private void m8102a(int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("microphone", i);
            jSONObject.put("startTime", i2);
            jSONObject.put("endTime", i3);
            m8069a(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void m8104b() {
        this.f7503b = 0;
        this.f7502a = new C2147l();
        m8068a(this.f7502a, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    }

    public String m8105f() {
        return "headset_plug";
    }

    protected void m8106g() {
        if (this.f7502a != null) {
            m8067a(this.f7502a);
        }
    }
}
