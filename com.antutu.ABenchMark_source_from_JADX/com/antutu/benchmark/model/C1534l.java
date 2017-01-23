package com.antutu.benchmark.model;

import com.antutu.utils.MLog;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.antutu.benchmark.model.l */
public class C1534l implements C1519k {
    public String f5341a;
    public String f5342b;
    public String f5343c;

    public C1519k m6076a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f5341a = jSONObject.getString("SESSION-ID");
            this.f5342b = jSONObject.getString("SESSION-STRING");
        } catch (JSONException e) {
        }
        MLog.m6865d("KeyModel", str);
        return this;
    }
}
