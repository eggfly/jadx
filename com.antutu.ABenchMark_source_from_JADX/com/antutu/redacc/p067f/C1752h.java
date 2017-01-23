package com.antutu.redacc.p067f;

import com.google.gson.Gson;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.antutu.redacc.f.h */
public class C1752h {
    public static <T> T m6757a(String str, Class<T> cls) {
        T t = null;
        try {
            Gson gson = new Gson();
            if (!(str == null || BuildConfig.FLAVOR.equals(str))) {
                t = gson.fromJson(str, (Class) cls);
            }
        } catch (Exception e) {
        }
        return t;
    }
}
