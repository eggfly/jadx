package com.google.android.gms.p146b;

import android.util.Log;
import com.google.android.gms.ads.internal.util.client.C2972b;

@gb
/* renamed from: com.google.android.gms.b.hf */
public final class hf extends C2972b {
    public static boolean m12980a() {
        return ((Boolean) aq.ak.m11794c()).booleanValue();
    }

    private static boolean m12981b() {
        return C2972b.m11578a(2) && hf.m12980a();
    }

    public static void m12982e(String str) {
        if (hf.m12981b()) {
            Log.v("Ads", str);
        }
    }
}
