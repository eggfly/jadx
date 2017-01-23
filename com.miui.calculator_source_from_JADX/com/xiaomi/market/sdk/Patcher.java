package com.xiaomi.market.sdk;

import android.util.Log;

public class Patcher {
    public native int applyPatch(String str, String str2, String str3);

    public static boolean m6193a() {
        try {
            System.loadLibrary("sdk_patcher_jni");
            return true;
        } catch (Throwable th) {
            Log.e("MarketPatcher", "load patcher library failed : " + th.toString());
            return false;
        }
    }

    public static int m6192a(String str, String str2, String str3) {
        return new Patcher().applyPatch(str, str2, str3);
    }
}
