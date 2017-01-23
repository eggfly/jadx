package com.google.android.gms.internal;

import com.google.android.gms.internal.aa.a;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class ic {
    public static long j6(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0;
        }
    }

    public static a j6(ef efVar) {
        Object obj;
        long j;
        Object obj2;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = efVar.FH;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = (String) map.get("Date");
        if (str != null) {
            j2 = j6(str);
        }
        str = (String) map.get("Cache-Control");
        if (str != null) {
            String[] split = str.split(",");
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
        str = (String) map.get("Expires");
        long j6 = str != null ? j6(str) : 0;
        str = (String) map.get("Last-Modified");
        long j62 = str != null ? j6(str) : 0;
        str = (String) map.get("ETag");
        if (obj2 != null) {
            j3 = currentTimeMillis + (1000 * j3);
            j = obj != null ? j3 : (1000 * j4) + j3;
        } else if (j2 <= 0 || j6 < j2) {
            j = 0;
            j3 = 0;
        } else {
            j = (j6 - j2) + currentTimeMillis;
            j3 = j;
        }
        a aVar = new a();
        aVar.j6 = efVar.DW;
        aVar.DW = str;
        aVar.Zo = j3;
        aVar.v5 = j;
        aVar.FH = j2;
        aVar.Hw = j62;
        aVar.VH = map;
        return aVar;
    }

    public static String j6(Map<String, String> map) {
        return j6(map, "ISO-8859-1");
    }

    public static String j6(Map<String, String> map, String str) {
        String str2 = (String) map.get("Content-Type");
        if (str2 == null) {
            return str;
        }
        String[] split = str2.split(";");
        for (int i = 1; i < split.length; i++) {
            String[] split2 = split[i].trim().split("=");
            if (split2.length == 2 && split2[0].equals("charset")) {
                return split2[1];
            }
        }
        return str;
    }
}
