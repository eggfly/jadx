package com.xiaomi.mistatistic.sdk.data;

import android.annotation.SuppressLint;
import android.view.View;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
/* renamed from: com.xiaomi.mistatistic.sdk.data.a */
public class C0600a {
    private int f4827a;
    private int f4828b;
    private int f4829c;
    private int f4830d;

    public C0600a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.f4827a = iArr[0];
        this.f4828b = iArr[1];
        this.f4829c = view.getWidth();
        this.f4830d = view.getHeight();
    }

    public JSONObject m6553a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("left", this.f4827a);
        jSONObject.put("top", this.f4828b);
        jSONObject.put("width", this.f4829c);
        jSONObject.put("height", this.f4830d);
        return jSONObject;
    }

    public String toString() {
        try {
            return m6553a().toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
