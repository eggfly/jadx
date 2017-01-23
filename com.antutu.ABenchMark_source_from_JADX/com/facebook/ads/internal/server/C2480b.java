package com.facebook.ads.internal.server;

import com.facebook.ads.internal.p125c.C2344a;
import com.facebook.ads.internal.p125c.C2347c;
import com.facebook.ads.internal.p125c.C2348d;
import com.facebook.ads.internal.server.C2482c.C2481a;
import com.facebook.ads.internal.util.C2510r;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.server.b */
public class C2480b {
    private static C2480b f8538a;

    static {
        f8538a = new C2480b();
    }

    public static synchronized C2480b m9440a() {
        C2480b c2480b;
        synchronized (C2480b.class) {
            c2480b = f8538a;
        }
        return c2480b;
    }

    private C2483d m9441a(JSONObject jSONObject) {
        int i = 0;
        JSONObject jSONObject2 = jSONObject.getJSONArray("placements").getJSONObject(0);
        C2347c c2347c = new C2347c(C2348d.m9046a(jSONObject2.getJSONObject("definition")), jSONObject2.optString("feature_config"));
        if (jSONObject2.has("ads")) {
            JSONArray jSONArray = jSONObject2.getJSONArray("ads");
            while (i < jSONArray.length()) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                c2347c.m9042a(new C2344a(jSONObject3.optString("adapter"), jSONObject3.optJSONObject(Constants.KEY_DATA), jSONObject3.optJSONArray("trackers")));
                i++;
            }
        }
        return new C2483d(c2347c);
    }

    private C2484e m9442b(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONArray("placements").getJSONObject(0);
            return new C2484e(jSONObject.optString(C4233j.f14376C, BuildConfig.FLAVOR), jSONObject.optInt(Constants.KEY_HTTP_CODE, 0), new C2347c(C2348d.m9046a(jSONObject2.getJSONObject("definition")), jSONObject2.optString("feature_config")));
        } catch (JSONException e) {
            return m9443c(jSONObject);
        }
    }

    private C2484e m9443c(JSONObject jSONObject) {
        return new C2484e(jSONObject.optString(C4233j.f14376C, BuildConfig.FLAVOR), jSONObject.optInt(Constants.KEY_HTTP_CODE, 0), null);
    }

    public C2482c m9444a(String str) {
        if (!C2510r.m9516a(str)) {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(C4233j.f14402y);
            Object obj = -1;
            switch (optString.hashCode()) {
                case 96432:
                    if (optString.equals("ads")) {
                        obj = null;
                        break;
                    }
                    break;
                case 96784904:
                    if (optString.equals(C4233j.f14375B)) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    return m9441a(jSONObject);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    return m9442b(jSONObject);
                default:
                    JSONObject optJSONObject = jSONObject.optJSONObject(C4233j.f14375B);
                    if (optJSONObject != null) {
                        return m9443c(optJSONObject);
                    }
                    break;
            }
        }
        return new C2482c(C2481a.UNKNOWN, null);
    }
}
