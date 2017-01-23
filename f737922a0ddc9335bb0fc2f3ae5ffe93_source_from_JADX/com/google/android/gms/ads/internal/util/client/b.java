package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.internal.eh;

@eh
public class b {
    public static void DW(String str) {
        if (j6(6)) {
            Log.e("Ads", str);
        }
    }

    public static void DW(String str, Throwable th) {
        if (j6(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void FH(String str) {
        if (j6(4)) {
            Log.i("Ads", str);
        }
    }

    public static void FH(String str, Throwable th) {
        if (j6(5)) {
            Log.w("Ads", str, th);
        }
    }

    public static void Hw(String str) {
        if (j6(5)) {
            Log.w("Ads", str);
        }
    }

    public static void j6(String str) {
        if (j6(3)) {
            Log.d("Ads", str);
        }
    }

    public static void j6(String str, Throwable th) {
        if (j6(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static boolean j6(int i) {
        return i >= 5 || Log.isLoggable("Ads", i);
    }
}
