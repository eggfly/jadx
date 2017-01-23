package com.cmcm.p074a.p075a.p114c;

import android.content.IntentFilter;
import com.igexin.sdk.PushConsts;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cmcm.a.a.c.t */
public class C2155t extends C2136b {
    private C2157v f7512a;
    private long f7513b;
    private long f7514c;
    private long f7515d;

    public C2155t() {
        this.f7513b = 0;
        this.f7514c = 0;
        this.f7515d = 0;
    }

    private void m8137c() {
        if (this.f7513b != 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("screenOn", this.f7513b);
                if (this.f7515d != 0) {
                    jSONObject.put("screenUnlock", this.f7515d);
                }
                jSONObject.put("screenOff", this.f7514c);
                m8069a(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    protected void m8138b() {
        this.f7512a = new C2157v();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
        m8068a(this.f7512a, intentFilter);
    }

    public String m8139f() {
        return "screen_state";
    }

    protected void m8140g() {
        m8067a(this.f7512a);
    }
}
