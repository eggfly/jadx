package org.android.spdy;

import android.util.Log;

public class spduLog {
    private static long savedTraffic;

    static {
        savedTraffic = 0;
    }

    public static void Logd(String str, String str2) {
        if (SpdyAgent.enableDebug && str != null && str2 != null) {
            Log.d(str, Thread.currentThread().getId() + " - " + str2);
        }
    }

    public static void Logd(String str, String str2, long j) {
        if (SpdyAgent.enableDebug && str != null && str2 != null) {
            Log.i(str, Thread.currentThread().getId() + " - " + str2 + ((System.nanoTime() - j) / 1000000));
        }
    }

    public static void Loge(String str, String str2) {
        if (SpdyAgent.enableDebug && str != null && str2 != null) {
            Log.e(str, Thread.currentThread().getId() + " - " + str2);
        }
    }

    public static void Logf(String str, String str2) {
        if (str != null && str2 != null) {
            Log.d(str, Thread.currentThread().getId() + " - " + str2);
        }
    }

    public static void Logi(String str, String str2) {
        if (SpdyAgent.enableDebug && str != null && str2 != null) {
            Log.i(str, Thread.currentThread().getId() + " - " + str2);
        }
    }

    public static void Logv(String str, String str2) {
        if (SpdyAgent.enableDebug && str != null && str2 != null) {
            Log.v(str, Thread.currentThread().getId() + " - " + str2);
        }
    }

    public static void Logw(String str, String str2) {
        if (SpdyAgent.enableDebug && str != null && str2 != null) {
            Log.w(str, Thread.currentThread().getId() + " - " + str2);
        }
    }

    public static void addTraffic(long j) {
        savedTraffic += j;
    }

    public static long getSavedTraffic() {
        return savedTraffic;
    }

    public static long now() {
        return SpdyAgent.enableDebug ? System.nanoTime() : 0;
    }
}
