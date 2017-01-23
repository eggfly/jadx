package com.umeng.message.common;

import android.util.Log;

public class UmLog {
    public static boolean LOG;

    static {
        LOG = true;
    }

    public static void m17136d(String str, String str2) {
        if (LOG) {
            Log.d(str, str2);
        }
    }

    public static void m17137d(String str, String str2, Exception exception) {
        if (LOG) {
            Log.d(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    public static void m17138e(String str, String str2) {
        if (LOG) {
            Log.e(str, str2);
        }
    }

    public static void m17139e(String str, String str2, Exception exception) {
        if (LOG) {
            Log.e(str, exception.toString() + ":  [" + str2 + "]");
            for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                Log.e(str, "        at\t " + stackTraceElement.toString());
            }
        }
    }

    public static void m17140i(String str, String str2) {
        if (LOG) {
            Log.i(str, str2);
        }
    }

    public static void m17141i(String str, String str2, Exception exception) {
        if (LOG) {
            Log.i(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    public static void m17142v(String str, String str2) {
        if (LOG) {
            Log.v(str, str2);
        }
    }

    public static void m17143v(String str, String str2, Exception exception) {
        if (LOG) {
            Log.v(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    public static void m17144w(String str, String str2) {
        if (LOG) {
            Log.w(str, str2);
        }
    }

    public static void m17145w(String str, String str2, Exception exception) {
        if (LOG) {
            Log.w(str, exception.toString() + ":  [" + str2 + "]");
            for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                Log.w(str, "        at\t " + stackTraceElement.toString());
            }
        }
    }
}
