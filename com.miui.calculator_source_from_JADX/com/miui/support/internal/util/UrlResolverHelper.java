package com.miui.support.internal.util;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

public class UrlResolverHelper {
    private static final String[] f2577a;
    private static final String[] f2578b;
    private static final String[] f2579c;
    private static Set<String> f2580d;
    private static Set<String> f2581e;

    static {
        f2577a = new String[]{"xiaomi.com", "mi.com", "com.miui.support.com", "mipay.com"};
        f2578b = new String[]{"duokan.com", "duokanbox.com"};
        f2579c = new String[]{"com.xiaomi.channel", "com.duokan.reader", "com.duokan.hdreader", "com.duokan.fiction", "com.xiaomi.router", "com.xiaomi.smarthome", "com.xiaomi.o2o", "com.xiaomi.shop", "com.xiaomi.jr", "com.miui.miuibbs", "com.wali.live", "com.mi.live", "com.xiaomi.ab", "com.mfashiongallery.emag"};
        f2580d = new HashSet();
        f2580d.add("mihttp");
        f2580d.add("mihttps");
        f2581e = new HashSet();
        f2581e.add("http");
        f2581e.add("https");
        f2581e.addAll(f2580d);
    }

    public static boolean m4259a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if ("http".equals(parse.getScheme()) || "https".equals(parse.getScheme())) {
            return m4260b(parse.getHost());
        }
        return false;
    }

    public static boolean m4260b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (CharSequence contains : f2577a) {
            if (str.contains(contains)) {
                return true;
            }
        }
        for (CharSequence contains2 : f2578b) {
            if (str.contains(contains2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m4261c(String str) {
        for (String equals : f2579c) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m4262d(String str) {
        return f2580d.contains(str);
    }

    public static Uri m4263e(String str) {
        return Uri.parse(str.substring("mi".length()));
    }

    public static String m4257a(Uri uri) {
        String a = m4258a(uri, 0, null);
        if (a != null) {
            if (f2581e.contains(Uri.parse(a).getScheme())) {
                return a;
            }
        }
        return null;
    }

    private static String m4258a(Uri uri, int i, String str) {
        Object obj;
        StringBuilder append = new StringBuilder().append("mifb");
        if (i == 0) {
            obj = "";
        } else {
            obj = Integer.valueOf(i);
        }
        String queryParameter = uri.getQueryParameter(append.append(obj).toString());
        if (queryParameter != null) {
            return m4258a(uri, i + 1, queryParameter);
        }
        return str;
    }
}
