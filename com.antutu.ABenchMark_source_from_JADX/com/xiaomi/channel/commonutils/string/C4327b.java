package com.xiaomi.channel.commonutils.string;

import android.net.Uri;
import android.text.TextUtils;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.channel.commonutils.logger.C4302b;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* renamed from: com.xiaomi.channel.commonutils.string.b */
public class C4327b {
    public static String m17736a(String str) {
        try {
            return String.valueOf(C4326a.m17734a(MessageDigest.getInstance("SHA1").digest(str.getBytes(HttpRequest.f14548a))));
        } catch (Throwable e) {
            C4302b.m17650a("CloudCoder.hash4SHA1 ", e);
            throw new IllegalStateException("failed to SHA1");
        } catch (Throwable e2) {
            C4302b.m17650a("CloudCoder.hash4SHA1 ", e2);
            throw new IllegalStateException("failed to SHA1");
        } catch (Throwable e22) {
            C4302b.m17650a("CloudCoder.hash4SHA1 ", e22);
            throw new IllegalStateException("failed to SHA1");
        }
    }

    public static String m17737a(String str, String str2, Map<String, String> map, String str3) {
        int i = 1;
        if (TextUtils.isEmpty(str3)) {
            throw new InvalidParameterException("security is not nullable");
        }
        List<String> arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str.toUpperCase());
        }
        if (str2 != null) {
            arrayList.add(Uri.parse(str2).getEncodedPath());
        }
        if (!(map == null || map.isEmpty())) {
            for (Entry entry : new TreeMap(map).entrySet()) {
                arrayList.add(String.format("%s=%s", new Object[]{entry.getKey(), entry.getValue()}));
            }
        }
        arrayList.add(str3);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str4 : arrayList) {
            if (i == 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str4);
            i = 0;
        }
        return C4327b.m17736a(stringBuilder.toString());
    }
}
