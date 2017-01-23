package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.common.internal.b;
import java.util.Map;
import java.util.Map.Entry;

public class g extends t {
    private static String DW;
    private static g FH;
    private static String j6;

    static {
        j6 = "3";
        DW = "01VDIWEA?";
    }

    public g(v vVar) {
        super(vVar);
    }

    public static g DW() {
        return FH;
    }

    public synchronized void DW(int i, String str, Object obj, Object obj2, Object obj3) {
        int i2 = 0;
        synchronized (this) {
            b.j6((Object) str);
            if (i >= 0) {
                i2 = i;
            }
            int length = i2 >= DW.length() ? DW.length() - 1 : i2;
            char c = XL().DW() ? XL().j6() ? 'P' : 'C' : XL().j6() ? 'p' : 'c';
            String str2 = j6;
            char charAt = DW.charAt(length);
            String str3 = u.j6;
            String valueOf = String.valueOf(s.FH(str, j6(obj), j6(obj2), j6(obj3)));
            String stringBuilder = new StringBuilder(((String.valueOf(str2).length() + 3) + String.valueOf(str3).length()) + String.valueOf(valueOf).length()).append(str2).append(charAt).append(c).append(str3).append(":").append(valueOf).toString();
            if (stringBuilder.length() > 1024) {
                stringBuilder = stringBuilder.substring(0, 1024);
            }
            j J8 = EQ().J8();
            if (J8 != null) {
                J8.VH().j6(stringBuilder);
            }
        }
    }

    protected String j6(Object obj) {
        if (obj == null) {
            return null;
        }
        Object l = obj instanceof Integer ? new Long((long) ((Integer) obj).intValue()) : obj;
        if (!(l instanceof Long)) {
            return l instanceof Boolean ? String.valueOf(l) : l instanceof Throwable ? l.getClass().getCanonicalName() : "-";
        } else {
            if (Math.abs(((Long) l).longValue()) < 100) {
                return String.valueOf(l);
            }
            String str = String.valueOf(l).charAt(0) == '-' ? "-" : "";
            String valueOf = String.valueOf(Math.abs(((Long) l).longValue()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))));
            stringBuilder.append("...");
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d));
            return stringBuilder.toString();
        }
    }

    protected void j6() {
        synchronized (g.class) {
            FH = this;
        }
    }

    public void j6(int i, String str, Object obj, Object obj2, Object obj3) {
        String str2 = (String) an.FH.j6();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, s.FH(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            DW(i, str, obj, obj2, obj3);
        }
    }

    public void j6(c cVar, String str) {
        Object obj;
        if (str == null) {
            obj = "no reason provided";
        }
        Object cVar2 = cVar != null ? cVar.toString() : "no hit data";
        String str2 = "Discarding hit. ";
        String valueOf = String.valueOf(obj);
        Hw(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), cVar2);
    }

    public void j6(Map<String, String> map, String str) {
        Object obj;
        Object stringBuilder;
        if (str == null) {
            obj = "no reason provided";
        }
        if (map != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : map.entrySet()) {
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.append(',');
                }
                stringBuilder2.append((String) entry.getKey());
                stringBuilder2.append('=');
                stringBuilder2.append((String) entry.getValue());
            }
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = "no hit data";
        }
        String str2 = "Discarding hit. ";
        String valueOf = String.valueOf(obj);
        Hw(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), stringBuilder);
    }
}
