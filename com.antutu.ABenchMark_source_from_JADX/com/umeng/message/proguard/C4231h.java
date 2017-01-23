package com.umeng.message.proguard;

import com.xiaomi.pushsdk.BuildConfig;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/* renamed from: com.umeng.message.proguard.h */
public class C4231h {
    public static String m17286a(Map<String, Object> map, String str) {
        if (map == null || map.isEmpty()) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        Set<String> keySet = map.keySet();
        if (!str.endsWith("?")) {
            stringBuilder.append("?");
        }
        for (String str2 : keySet) {
            stringBuilder.append(URLEncoder.encode(str2) + "=" + URLEncoder.encode(map.get(str2) == null ? BuildConfig.FLAVOR : map.get(str2).toString()) + "&");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
