package com.umeng.message.entity;

import org.json.JSONException;
import org.json.JSONObject;

public class ULocation {
    private String f14291a;
    private String f14292b;
    private String f14293c;
    private String f14294d;
    private String f14295e;
    private String f14296f;
    private String f14297g;
    private String f14298h;

    public ULocation(JSONObject jSONObject) {
        try {
            this.f14291a = jSONObject.getString("cenx");
            this.f14292b = jSONObject.getString("ceny");
            JSONObject jSONObject2 = jSONObject.getJSONObject("revergeo");
            this.f14293c = jSONObject2.getString("country");
            this.f14294d = jSONObject2.getString("province");
            this.f14295e = jSONObject2.getString("city");
            this.f14296f = jSONObject2.getString("district");
            this.f14297g = jSONObject2.getString("road");
            this.f14298h = jSONObject2.getString("street");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getCity() {
        return this.f14295e;
    }

    public String getCountry() {
        return this.f14293c;
    }

    public String getDistrict() {
        return this.f14296f;
    }

    public String getLatitude() {
        return this.f14292b;
    }

    public String getLongitude() {
        return this.f14291a;
    }

    public String getProvince() {
        return this.f14294d;
    }

    public String getRoad() {
        return this.f14297g;
    }

    public String getStreet() {
        return this.f14298h;
    }
}
