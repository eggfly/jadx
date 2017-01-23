package com.miui.support.net.http;

import com.miui.support.net.http.Cache.Entry;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

class HttpHeaderParser {
    HttpHeaderParser() {
    }

    public static Entry m5133a(HttpResponse httpResponse) {
        long j;
        long j2;
        Object obj;
        long a;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = 0;
        Map d = httpResponse.m5099d();
        String str2 = (String) d.get("date");
        if (str2 != null) {
            j3 = m5132a(str2);
        }
        str2 = (String) d.get("cache-control");
        if (str2 != null) {
            j = 0;
            for (String trim : str2.split(",")) {
                String trim2 = trim2.trim();
                if (trim2.equals("no-cache") || trim2.equals("no-store")) {
                    return null;
                }
                if (trim2.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim2.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim2.equals("must-revalidate") || trim2.equals("proxy-revalidate")) {
                    j = 0;
                }
            }
            j2 = j;
            obj = 1;
        } else {
            obj = null;
            j2 = 0;
        }
        str2 = (String) d.get("expires");
        if (str2 != null) {
            a = m5132a(str2);
        } else {
            a = 0;
        }
        str2 = (String) d.get("etag");
        if (str2 != null) {
            str = str2;
        } else {
            str = null;
        }
        if (obj != null) {
            j = (1000 * j2) + currentTimeMillis;
        } else if (j3 <= 0 || a < j3) {
            return null;
        } else {
            j = (a - j3) + currentTimeMillis;
        }
        if (httpResponse.m5096a() == null) {
            return null;
        }
        Entry entry = new Entry();
        entry.f3400a = httpResponse.m5096a();
        entry.f3401b = httpResponse.m5097b();
        entry.f3402c = str;
        entry.f3407h = j;
        entry.f3406g = j;
        entry.f3405f = j3;
        entry.f3408i = httpResponse.m5099d();
        return entry;
    }

    public static long m5132a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0;
        }
    }
}
