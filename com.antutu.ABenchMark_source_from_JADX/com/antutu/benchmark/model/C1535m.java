package com.antutu.benchmark.model;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.antutu.benchmark.model.m */
public class C1535m implements C1519k {
    public String f5344a;
    private int f5345b;

    public C1535m(int i) {
        this.f5344a = null;
        this.f5345b = -1;
        this.f5345b = i;
    }

    private void m6077b(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("results").getJSONObject(0).getJSONArray("address_components");
            String string = jSONArray.getJSONObject(jSONArray.length() - 2).getString("long_name");
            String string2 = jSONArray.getJSONObject(jSONArray.length() - 3).getString("long_name");
            Log.d("OemG", jSONArray.toString());
            this.f5344a = string + " " + string2;
        } catch (JSONException e) {
        }
    }

    private void m6078c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("result").getJSONObject("addressComponent");
            String string = jSONObject.getString("city");
            this.f5344a = string + " " + jSONObject.getString("district");
        } catch (JSONException e) {
        }
    }

    public C1519k m6079a(String str) {
        if (this.f5345b != 1) {
            m6078c(str);
        } else {
            m6077b(str);
        }
        return this;
    }
}
