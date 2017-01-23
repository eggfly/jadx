package com.facebook.ads.internal.p125c;

import com.facebook.ads.internal.util.C2510r;
import com.umeng.message.proguard.C4233j;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.c.a */
public class C2344a {
    private final String f8160a;
    private final JSONObject f8161b;
    private final Map<C2351f, List<String>> f8162c;

    public C2344a(String str, JSONObject jSONObject, JSONArray jSONArray) {
        this.f8162c = new HashMap();
        this.f8160a = str;
        this.f8161b = jSONObject;
        if (jSONArray != null && jSONArray.length() != 0) {
            int i;
            for (Object put : C2351f.values()) {
                this.f8162c.put(put, new LinkedList());
            }
            for (i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString(C4233j.f14402y);
                    String string2 = jSONObject2.getString("url");
                    C2351f valueOf = C2351f.valueOf(string.toUpperCase(Locale.US));
                    if (!(valueOf == null || C2510r.m9516a(string2))) {
                        ((List) this.f8162c.get(valueOf)).add(string2);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public String m9037a() {
        return this.f8160a;
    }

    public List<String> m9038a(C2351f c2351f) {
        return (List) this.f8162c.get(c2351f);
    }

    public JSONObject m9039b() {
        return this.f8161b;
    }
}
