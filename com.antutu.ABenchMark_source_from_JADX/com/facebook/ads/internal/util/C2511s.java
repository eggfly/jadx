package com.facebook.ads.internal.util;

import com.xiaomi.pushsdk.BuildConfig;
import java.util.Set;

/* renamed from: com.facebook.ads.internal.util.s */
public class C2511s {
    public static String m9518a(Set<String> set, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : set) {
            stringBuilder.append(append);
            stringBuilder.append(str);
        }
        return stringBuilder.length() > 0 ? stringBuilder.substring(0, stringBuilder.length() - 1) : BuildConfig.FLAVOR;
    }
}
