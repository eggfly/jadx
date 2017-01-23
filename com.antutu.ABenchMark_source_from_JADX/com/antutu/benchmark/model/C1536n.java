package com.antutu.benchmark.model;

import com.antutu.utils.jni;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.antutu.benchmark.model.n */
public class C1536n implements C1519k {
    private int f5346a;
    private String f5347b;

    public C1536n(String str) {
        this.f5346a = -1;
        this.f5347b = BuildConfig.FLAVOR;
        this.f5347b = str;
    }

    public int m6080a() {
        return this.f5346a;
    }

    public C1519k m6081a(String str) {
        try {
            this.f5346a = new JSONObject(jni.getStringSafe(str.substring(0, str.length() - 8), (str.substring(str.length() - 8, str.length()) + this.f5347b).substring(4, 12))).getInt(Constants.KEY_HTTP_CODE);
        } catch (JSONException e) {
        }
        return this;
    }
}
