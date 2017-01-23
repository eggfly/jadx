package com.google.android.gms.p146b;

import com.google.android.gms.p146b.C3345w.C3369a;
import com.umeng.message.proguard.C4218e;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import org.apache.http.entity.mime.MIME;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

/* renamed from: com.google.android.gms.b.kv */
public class kv {
    public static long m13769a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0;
        }
    }

    public static C3369a m13770a(gs gsVar) {
        Object obj;
        long j;
        Object obj2;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = gsVar.f11163c;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = (String) map.get(HttpRequest.f14560m);
        if (str != null) {
            j2 = kv.m13769a(str);
        }
        str = (String) map.get(HttpRequest.f14556i);
        if (str != null) {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            obj = null;
            j = 0;
            j4 = 0;
            for (String trim : split) {
                String trim2 = trim2.trim();
                if (trim2.equals("no-cache") || trim2.equals("no-store")) {
                    return null;
                }
                if (trim2.startsWith("max-age=")) {
                    try {
                        j4 = Long.parseLong(trim2.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim2.startsWith("stale-while-revalidate=")) {
                    try {
                        j = Long.parseLong(trim2.substring(23));
                    } catch (Exception e2) {
                    }
                } else if (trim2.equals("must-revalidate") || trim2.equals("proxy-revalidate")) {
                    obj = 1;
                }
            }
            j3 = j4;
            j4 = j;
            obj2 = 1;
        } else {
            obj = null;
            obj2 = null;
        }
        str = (String) map.get(HttpRequest.f14562o);
        long a = str != null ? kv.m13769a(str) : 0;
        str = (String) map.get(HttpRequest.f14564q);
        long a2 = str != null ? kv.m13769a(str) : 0;
        str = (String) map.get(HttpRequest.f14561n);
        if (obj2 != null) {
            j3 = currentTimeMillis + (1000 * j3);
            j = obj != null ? j3 : (1000 * j4) + j3;
        } else if (j2 <= 0 || a < j2) {
            j = 0;
            j3 = 0;
        } else {
            j = (a - j2) + currentTimeMillis;
            j3 = j;
        }
        C3369a c3369a = new C3369a();
        c3369a.f11746a = gsVar.f11162b;
        c3369a.f11747b = str;
        c3369a.f11751f = j3;
        c3369a.f11750e = j;
        c3369a.f11748c = j2;
        c3369a.f11749d = a2;
        c3369a.f11752g = map;
        return c3369a;
    }

    public static String m13771a(Map<String, String> map) {
        return kv.m13772a(map, C4218e.f14336a);
    }

    public static String m13772a(Map<String, String> map, String str) {
        String str2 = (String) map.get(MIME.CONTENT_TYPE);
        if (str2 == null) {
            return str;
        }
        String[] split = str2.split(";");
        for (int i = 1; i < split.length; i++) {
            String[] split2 = split[i].trim().split("=");
            if (split2.length == 2 && split2[0].equals(HttpRequest.f14538D)) {
                return split2[1];
            }
        }
        return str;
    }
}
