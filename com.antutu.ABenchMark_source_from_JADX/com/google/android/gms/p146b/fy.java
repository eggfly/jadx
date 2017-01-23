package com.google.android.gms.p146b;

import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.formats.C2799a;
import com.google.android.gms.ads.internal.formats.C2802c;
import com.google.android.gms.ads.internal.formats.C2809f;
import com.google.android.gms.ads.internal.formats.C2810h.C2804a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.fv.C3216a;
import com.umeng.message.proguard.C4233j;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.fy */
public class fy implements C3216a<C2809f> {
    private final boolean f11004a;

    public fy(boolean z) {
        this.f11004a = z;
    }

    private <K, V> SimpleArrayMap<K, V> m12797a(SimpleArrayMap<K, Future<V>> simpleArrayMap) {
        SimpleArrayMap<K, V> simpleArrayMap2 = new SimpleArrayMap();
        for (int i = 0; i < simpleArrayMap.size(); i++) {
            simpleArrayMap2.put(simpleArrayMap.keyAt(i), ((Future) simpleArrayMap.valueAt(i)).get());
        }
        return simpleArrayMap2;
    }

    private void m12798a(fv fvVar, JSONObject jSONObject, SimpleArrayMap<String, Future<C2802c>> simpleArrayMap) {
        simpleArrayMap.put(jSONObject.getString("name"), fvVar.m12788a(jSONObject, "image_value", this.f11004a));
    }

    private void m12799a(JSONObject jSONObject, SimpleArrayMap<String, String> simpleArrayMap) {
        simpleArrayMap.put(jSONObject.getString("name"), jSONObject.getString("string_value"));
    }

    public /* synthetic */ C2804a m12800a(fv fvVar, JSONObject jSONObject) {
        return m12801b(fvVar, jSONObject);
    }

    public C2809f m12801b(fv fvVar, JSONObject jSONObject) {
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
        Future b = fvVar.m12791b(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString(C4233j.f14402y);
            if ("string".equals(string)) {
                m12799a(jSONObject2, simpleArrayMap2);
            } else if ("image".equals(string)) {
                m12798a(fvVar, jSONObject2, simpleArrayMap);
            } else {
                C2972b.m11583d("Unknown custom asset type: " + string);
            }
        }
        return new C2809f(jSONObject.getString("custom_template_id"), m12797a(simpleArrayMap), simpleArrayMap2, (C2799a) b.get());
    }
}
