package com.aide.common;

import android.util.Log;

public class e {
    public static void j6(String str) {
        Log.d("AIDE", str);
    }

    public static void j6(Object obj, String str) {
        Log.i("AIDE", obj.getClass().getName() + "." + str);
    }

    public static void DW(String str) {
        Log.i("AIDE", str);
    }

    public static void j6(Throwable th) {
        Log.e("AIDE", th.toString(), th);
    }

    public static void FH(String str) {
        Log.e("AIDE", str);
    }

    public static void j6(String str, Throwable th) {
        Log.e("AIDE", str, th);
    }

    public static void Hw(String str) {
        Log.w("AIDE", str);
    }

    public static void DW(Throwable th) {
        Log.e("AIDE", th.toString(), th);
    }
}
