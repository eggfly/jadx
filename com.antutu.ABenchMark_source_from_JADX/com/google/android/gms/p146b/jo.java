package com.google.android.gms.p146b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;

/* renamed from: com.google.android.gms.b.jo */
public class jo {
    public static void m13565a(StringBuilder stringBuilder, HashMap<String, String> hashMap) {
        stringBuilder.append("{");
        Object obj = 1;
        for (String str : hashMap.keySet()) {
            Object obj2;
            if (obj == null) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                obj2 = obj;
            } else {
                obj2 = null;
            }
            String str2 = (String) hashMap.get(str);
            stringBuilder.append("\"").append(str).append("\":");
            if (str2 == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append("\"").append(str2).append("\"");
            }
            obj = obj2;
        }
        stringBuilder.append("}");
    }
}
