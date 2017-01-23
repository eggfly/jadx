package com.miui.support.hybrid;

import org.json.JSONException;
import org.json.JSONObject;

public class Response {
    private int f2072a;
    private String f2073b;
    private JSONObject f2074c;

    public Response(int i) {
        this(i, "");
    }

    public Response(int i, String str) {
        this.f2074c = new JSONObject();
        this.f2072a = i;
        this.f2073b = str;
        try {
            this.f2074c.put("code", this.f2072a);
            this.f2074c.put("content", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Response(JSONObject jSONObject) {
        this(0, jSONObject);
    }

    public Response(int i, JSONObject jSONObject) {
        this.f2074c = new JSONObject();
        this.f2072a = i;
        this.f2073b = jSONObject.toString();
        try {
            this.f2074c.put("code", this.f2072a);
            this.f2074c.put("content", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return this.f2074c.toString();
    }
}
