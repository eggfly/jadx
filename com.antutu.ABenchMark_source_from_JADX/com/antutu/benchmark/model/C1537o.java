package com.antutu.benchmark.model;

import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.antutu.benchmark.model.o */
public class C1537o {
    private String f5348a;
    private String f5349b;
    private int[] f5350c;

    public C1537o() {
        this.f5350c = new int[42];
        for (int i = 0; i < 42; i++) {
            this.f5350c[i] = 0;
        }
        this.f5348a = BuildConfig.FLAVOR;
        this.f5349b = BuildConfig.FLAVOR;
    }

    public int m6082a(int i) {
        return (i < 30 || i > 41) ? 0 : this.f5350c[i];
    }

    public String m6083a() {
        return this.f5348a;
    }

    public void m6084a(int i, int i2) {
        if (i >= 30 && i <= 41) {
            this.f5350c[i] = i2;
        }
    }

    public void m6085a(String str) {
        int i = 11;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f5348a = jSONObject.getString("name");
            this.f5349b = jSONObject.getString(Constants.KEY_BRAND);
            this.f5350c[41] = jSONObject.getInt("score");
            JSONArray jSONArray = jSONObject.getJSONArray("s");
            int length = jSONArray.length();
            if (length <= 11) {
                i = length;
            }
            for (length = 0; length < i; length++) {
                this.f5350c[length + 30] = jSONArray.getInt(length);
            }
        } catch (Exception e) {
        }
    }

    public String m6086b() {
        return this.f5349b;
    }

    public void m6087b(String str) {
        this.f5348a = str;
    }

    public void m6088c(String str) {
        this.f5349b = str;
    }
}
