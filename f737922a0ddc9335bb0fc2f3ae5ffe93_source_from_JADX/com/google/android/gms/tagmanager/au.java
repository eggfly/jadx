package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.h.a;
import java.net.URLEncoder;

class au {
    private static ab<a> j6(ab<a> abVar) {
        try {
            return new ab(as.FH(j6(as.j6((a) abVar.j6()))), abVar.DW());
        } catch (Throwable e) {
            r.j6("Escape URI: unsupported encoding", e);
            return abVar;
        }
    }

    private static ab<a> j6(ab<a> abVar, int i) {
        if (j6((a) abVar.j6())) {
            switch (i) {
                case 12:
                    return j6((ab) abVar);
                default:
                    r.j6("Unsupported Value Escaping: " + i);
                    return abVar;
            }
        }
        r.j6("Escaping can only be applied to strings.");
        return abVar;
    }

    static ab<a> j6(ab<a> abVar, int... iArr) {
        ab j6;
        for (int j62 : iArr) {
            j6 = j6(j6, j62);
        }
        return j6;
    }

    static String j6(String str) {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean j6(a aVar) {
        return as.FH(aVar) instanceof String;
    }
}
