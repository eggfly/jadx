package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.e;

@Deprecated
public class f {
    private static volatile e j6;

    static {
        j6(new ah());
    }

    public static void DW(String str) {
        g DW = g.DW();
        if (DW != null) {
            DW.DW(str);
        } else if (j6(0)) {
            Log.v((String) an.FH.j6(), str);
        }
        e eVar = j6;
        if (eVar != null) {
            eVar.j6(str);
        }
    }

    public static void FH(String str) {
        g DW = g.DW();
        if (DW != null) {
            DW.v5(str);
        } else if (j6(2)) {
            Log.w((String) an.FH.j6(), str);
        }
        e eVar = j6;
        if (eVar != null) {
            eVar.FH(str);
        }
    }

    public static e j6() {
        return j6;
    }

    public static void j6(e eVar) {
        j6 = eVar;
    }

    public static void j6(String str) {
        g DW = g.DW();
        if (DW != null) {
            DW.Hw(str);
        } else if (j6(1)) {
            Log.i((String) an.FH.j6(), str);
        }
        e eVar = j6;
        if (eVar != null) {
            eVar.DW(str);
        }
    }

    public static void j6(String str, Object obj) {
        g DW = g.DW();
        if (DW != null) {
            DW.v5(str, obj);
        } else if (j6(3)) {
            String stringBuilder;
            if (obj != null) {
                String valueOf = String.valueOf(obj);
                stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(valueOf).length()).append(str).append(":").append(valueOf).toString();
            } else {
                stringBuilder = str;
            }
            Log.e((String) an.FH.j6(), stringBuilder);
        }
        e eVar = j6;
        if (eVar != null) {
            eVar.Hw(str);
        }
    }

    public static boolean j6(int i) {
        return j6() != null && j6().j6() <= i;
    }
}
