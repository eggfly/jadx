package com.facebook.ads.internal.util;

import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.facebook.ads.internal.util.c */
public class C2490c {
    private static final List<C2489b> f8571a;

    static {
        f8571a = new ArrayList();
    }

    public static String m9455a() {
        synchronized (f8571a) {
            if (f8571a.isEmpty()) {
                String str = BuildConfig.FLAVOR;
                return str;
            }
            List<C2489b> arrayList = new ArrayList(f8571a);
            f8571a.clear();
            JSONArray jSONArray = new JSONArray();
            for (C2489b a : arrayList) {
                jSONArray.put(a.m9454a());
            }
            return jSONArray.toString();
        }
    }

    public static void m9456a(C2489b c2489b) {
        synchronized (f8571a) {
            f8571a.add(c2489b);
        }
    }
}
