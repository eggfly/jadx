package com.google.analytics.tracking.android;

import com.google.android.gms.common.util.VisibleForTesting;

public class Log {
    @VisibleForTesting
    static final String LOG_TAG = "GAV2";
    private static boolean sDebug;

    public static int m10256d(String str) {
        return android.util.Log.d(LOG_TAG, formatMessage(str));
    }

    public static int dDebug(String str) {
        return sDebug ? m10256d(str) : 0;
    }

    public static int m10257e(String str) {
        return android.util.Log.e(LOG_TAG, formatMessage(str));
    }

    public static int eDebug(String str) {
        return sDebug ? m10257e(str) : 0;
    }

    private static String formatMessage(String str) {
        return Thread.currentThread().toString() + ": " + str;
    }

    public static int m10258i(String str) {
        return android.util.Log.i(LOG_TAG, formatMessage(str));
    }

    public static int iDebug(String str) {
        return sDebug ? m10258i(str) : 0;
    }

    public static boolean isDebugEnabled() {
        return sDebug;
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static int m10259v(String str) {
        return android.util.Log.v(LOG_TAG, formatMessage(str));
    }

    public static int vDebug(String str) {
        return sDebug ? m10259v(str) : 0;
    }

    public static int m10260w(String str) {
        return android.util.Log.w(LOG_TAG, formatMessage(str));
    }

    public static int wDebug(String str) {
        return sDebug ? m10260w(str) : 0;
    }
}
