package com.cmcm.p074a.p075a.p112a;

import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.cmcm.a.a.a.ad */
public class ad {
    public static void m7931a(String str, String str2, Object... objArr) {
        if (!TextUtils.isEmpty(str2)) {
            String format = String.format(str2, objArr);
            Log.i("DMC", String.format("[%s] %s", new Object[]{str, format}));
        }
    }

    public static void m7932a(String str, Object... objArr) {
        if (!TextUtils.isEmpty(str)) {
            Log.i("DMC", String.format(str, objArr));
        }
    }
}
