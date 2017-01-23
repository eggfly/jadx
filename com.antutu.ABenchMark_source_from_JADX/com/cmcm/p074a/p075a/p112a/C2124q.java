package com.cmcm.p074a.p075a.p112a;

import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.cmcm.a.a.a.q */
class C2124q extends C2122o {
    final /* synthetic */ C2116j f7456b;
    private String f7457c;

    private C2124q(C2116j c2116j) {
        this.f7456b = c2116j;
        super(null);
    }

    public void m8022a(String str, String str2) {
        this.f7457c = str2;
        m8015c(str);
    }

    public boolean m8023b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getInt(C4233j.f14375B) == 0) {
                    JSONArray jSONArray = jSONObject.getJSONArray(Constants.KEY_DATA);
                    int length = jSONArray.length();
                    Map hashMap = new HashMap(length);
                    for (int i = 0; i < length; i++) {
                        Map map;
                        jSONObject = jSONArray.getJSONObject(i);
                        Integer valueOf = Integer.valueOf(jSONObject.getInt("func_type"));
                        String string = jSONObject.getString("section");
                        String string2 = jSONObject.getString("key_value");
                        String str2 = valueOf + string;
                        Map map2 = (Map) hashMap.get(str2);
                        if (map2 == null) {
                            HashMap hashMap2 = new HashMap();
                            hashMap.put(str2, hashMap2);
                            map = hashMap2;
                        } else {
                            map = map2;
                        }
                        try {
                            JSONObject jSONObject2 = new JSONObject(string2);
                            Iterator keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String str3 = (String) keys.next();
                                map.put(str3, jSONObject2.getString(str3));
                            }
                        } catch (Exception e) {
                            map.put("7a0ddfee-0149-4d44-8db6-d28c46eaf068", string2);
                        }
                    }
                    C2108b.m7936a().m7940c().putString("config_version", this.f7457c).putLong("config_update_timestamp", System.currentTimeMillis()).apply();
                    this.f7456b.m7990a(hashMap);
                    this.f7456b.m7995b(hashMap);
                    return false;
                }
            } catch (Exception e2) {
                if (C2133z.f7482a) {
                    ad.m7931a("HttpDownloader", "failed to process the result of Update : " + e2.getMessage(), new Object[0]);
                }
            }
        }
        if (m8018a()) {
            return true;
        }
        this.f7456b.m7995b(null);
        return false;
    }
}
