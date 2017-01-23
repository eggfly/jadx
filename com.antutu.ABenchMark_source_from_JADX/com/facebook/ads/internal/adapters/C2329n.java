package com.facebook.ads.internal.adapters;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.C2493e;
import com.facebook.ads.internal.util.C2494f;
import com.facebook.ads.internal.util.C2494f.C2325a;
import com.facebook.ads.internal.util.C2498g;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.n */
public class C2329n implements C2325a {
    private final String f8101a;
    private final String f8102b;
    private final String f8103c;
    private final C2493e f8104d;
    private final String f8105e;
    private final Collection<String> f8106f;
    private final Map<String, String> f8107g;
    private final String f8108h;
    private final int f8109i;
    private final int f8110j;

    private C2329n(String str, String str2, String str3, C2493e c2493e, String str4, Collection<String> collection, Map<String, String> map, String str5, int i, int i2) {
        this.f8101a = str;
        this.f8102b = str2;
        this.f8103c = str3;
        this.f8104d = c2493e;
        this.f8105e = str4;
        this.f8106f = collection;
        this.f8107g = map;
        this.f8108h = str5;
        this.f8109i = i;
        this.f8110j = i2;
    }

    public static C2329n m8936a(Bundle bundle) {
        return new C2329n(bundle.getString("markup"), null, bundle.getString("native_impression_report_url"), C2493e.NONE, BuildConfig.FLAVOR, null, null, bundle.getString("request_id"), bundle.getInt("viewability_check_initial_delay"), bundle.getInt("viewability_check_interval"));
    }

    public static C2329n m8937a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArray;
        String optString = jSONObject.optString("markup");
        String optString2 = jSONObject.optString("activation_command");
        String optString3 = jSONObject.optString("native_impression_report_url");
        String optString4 = jSONObject.optString("request_id");
        C2493e a = C2493e.m9464a(jSONObject.optString("invalidation_behavior"));
        String optString5 = jSONObject.optString("invalidation_report_url");
        try {
            jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        Collection a2 = C2494f.m9465a(jSONArray);
        JSONObject optJSONObject = jSONObject.optJSONObject("metadata");
        Map hashMap = new HashMap();
        if (optJSONObject != null) {
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, optJSONObject.optString(str));
            }
        }
        int i = 0;
        int i2 = AdError.NETWORK_ERROR_CODE;
        if (hashMap.containsKey("viewability_check_initial_delay")) {
            i = Integer.parseInt((String) hashMap.get("viewability_check_initial_delay"));
        }
        if (hashMap.containsKey("viewability_check_interval")) {
            i2 = Integer.parseInt((String) hashMap.get("viewability_check_interval"));
        }
        return new C2329n(optString, optString2, optString3, a, optString5, a2, hashMap, optString4, i, i2);
    }

    public static C2329n m8938b(Intent intent) {
        return new C2329n(C2498g.m9473a(intent.getByteArrayExtra("markup")), intent.getStringExtra("activation_command"), intent.getStringExtra("native_impression_report_url"), C2493e.NONE, BuildConfig.FLAVOR, null, null, intent.getStringExtra("request_id"), intent.getIntExtra("viewability_check_initial_delay", 0), intent.getIntExtra("viewability_check_interval", AdError.NETWORK_ERROR_CODE));
    }

    public C2493e m8939C() {
        return this.f8104d;
    }

    public String m8940D() {
        return this.f8105e;
    }

    public Collection<String> m8941E() {
        return this.f8106f;
    }

    public String m8942a() {
        return this.f8101a;
    }

    public void m8943a(Intent intent) {
        intent.putExtra("markup", C2498g.m9484a(this.f8101a));
        intent.putExtra("activation_command", this.f8102b);
        intent.putExtra("native_impression_report_url", this.f8103c);
        intent.putExtra("request_id", this.f8108h);
        intent.putExtra("viewability_check_initial_delay", this.f8109i);
        intent.putExtra("viewability_check_interval", this.f8110j);
    }

    public String m8944b() {
        return this.f8102b;
    }

    public String m8945c() {
        return this.f8103c;
    }

    public String m8946d() {
        return "facebookAd.sendImpression();";
    }

    public Map<String, String> m8947e() {
        return this.f8107g;
    }

    public String m8948f() {
        return this.f8108h;
    }

    public int m8949g() {
        return this.f8109i;
    }

    public int m8950h() {
        return this.f8110j;
    }

    public Bundle m8951i() {
        Bundle bundle = new Bundle();
        bundle.putString("markup", this.f8101a);
        bundle.putString("native_impression_report_url", this.f8103c);
        bundle.putString("request_id", this.f8108h);
        bundle.putInt("viewability_check_initial_delay", this.f8109i);
        bundle.putInt("viewability_check_interval", this.f8110j);
        return bundle;
    }
}
