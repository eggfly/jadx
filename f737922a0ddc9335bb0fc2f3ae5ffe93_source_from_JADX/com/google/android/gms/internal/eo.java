package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.ads.internal.util.client.b;

@eh
public final class eo extends b {
    private static boolean DW() {
        return b.j6(2) && j6();
    }

    public static boolean j6() {
        return ((Boolean) aq.Ev.FH()).booleanValue();
    }

    public static void v5(String str) {
        if (DW()) {
            Log.v("Ads", str);
        }
    }
}
