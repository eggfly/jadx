package com.cmcm.p074a.p075a.p114c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import com.cmcm.p074a.p075a.p112a.C2109c;
import com.cmcm.p074a.p075a.p112a.C2126s;
import com.cmcm.p074a.p075a.p112a.C2132y;
import com.cmcm.p074a.p075a.p112a.ab;
import com.facebook.ads.AdError;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cmcm.a.a.c.o */
public class C2150o extends C2136b implements C2132y {
    private ab f7505a;
    private C2109c f7506b;

    private int m8114c() {
        return (Math.max(C2126s.m8026a(m8118f(), MsgConstant.KEY_LOCATION_INTERVAL, 60), 5) * 60) * AdError.NETWORK_ERROR_CODE;
    }

    public void m8116a(Location location) {
        if (location != null) {
            SharedPreferences h = m8076h();
            if (h.getLong("location_location_time", 0) != location.getTime()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("provider", location.getProvider());
                    jSONObject.put("longitude", location.getLongitude());
                    jSONObject.put("latitude", location.getLatitude());
                    jSONObject.put(C4233j.f14377D, (int) (location.getTime() / 1000));
                    m8069a(jSONObject.toString());
                    Editor edit = h.edit();
                    edit.putLong("location_last_update", System.currentTimeMillis());
                    edit.putLong("location_location_time", location.getTime());
                    edit.apply();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void m8117b() {
        long j = 300000;
        if (!C2126s.m8036a(8)) {
            this.f7505a = new ab();
            int c = m8114c();
            long currentTimeMillis = System.currentTimeMillis() - m8076h().getLong("location_last_update", 0);
            if (currentTimeMillis > 0 && currentTimeMillis < ((long) c) - 300000) {
                j = ((long) c) - currentTimeMillis;
            }
            this.f7506b = new C2109c();
            this.f7506b.m7951a(new C2151p(this), j);
        }
    }

    public String m8118f() {
        return MsgConstant.KEY_LOCATION_PARAMS;
    }

    protected void m8119g() {
        if (this.f7505a != null) {
            this.f7505a.m7928a();
            this.f7505a = null;
            this.f7506b.m7953b();
            this.f7506b = null;
        }
    }
}
