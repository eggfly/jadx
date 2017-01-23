package com.facebook.ads.internal.util;

import com.umeng.message.common.C4209a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.util.i */
public class C2500i {
    private final String f8588a;
    private final String f8589b;
    private final String f8590c;
    private final List<String> f8591d;
    private final String f8592e;
    private final String f8593f;

    private C2500i(String str, String str2, String str3, List<String> list, String str4, String str5) {
        this.f8588a = str;
        this.f8589b = str2;
        this.f8590c = str3;
        this.f8591d = list;
        this.f8592e = str4;
        this.f8593f = str5;
    }

    public static C2500i m9495a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString(C4209a.f14200c);
        String optString2 = jSONObject.optString("appsite");
        String optString3 = jSONObject.optString("appsite_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("key_hashes");
        List arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
        }
        return new C2500i(optString, optString2, optString3, arrayList, jSONObject.optString("market_uri"), jSONObject.optString("fallback_url"));
    }

    public String m9496a() {
        return this.f8588a;
    }

    public String m9497b() {
        return this.f8589b;
    }

    public String m9498c() {
        return this.f8590c;
    }
}
