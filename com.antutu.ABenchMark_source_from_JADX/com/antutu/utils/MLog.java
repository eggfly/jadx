package com.antutu.utils;

import android.util.Log;

public class MLog {
    public static boolean IS_LOG = false;
    private static final String TAG = "AntutuDebug";

    static {
        IS_LOG = false;
    }

    public static void m6864d(String str) {
        if (IS_LOG) {
            Log.d(TAG, str);
        }
    }

    public static void m6865d(String str, String str2) {
        if (IS_LOG) {
            Log.d(str, str2);
        }
    }

    public static void m6866d(String str, String str2, Throwable th) {
        if (IS_LOG) {
            Log.d(str, str2, th);
        }
    }

    public static void m6867e(String str) {
        if (IS_LOG) {
            Log.e(TAG, str);
        }
    }

    public static void m6868e(String str, String str2) {
        if (IS_LOG) {
            Log.e(str, str2);
        }
    }

    public static void m6869e(String str, String str2, Throwable th) {
        if (IS_LOG) {
            Log.e(str, str2, th);
        }
    }

    public static void m6870i(String str) {
        if (IS_LOG) {
            Log.i(TAG, str);
        }
    }

    public static void m6871i(String str, String str2) {
        if (IS_LOG) {
            Log.i(str, str2);
        }
    }

    public static void m6872i(String str, String str2, Throwable th) {
        if (IS_LOG) {
            Log.i(str, str2, th);
        }
    }

    public static void isLoggable(String str, int i) {
        if (IS_LOG) {
            Log.isLoggable(str, i);
        }
    }

    public static void sysout(String str, String str2) {
        if (IS_LOG) {
            System.out.println(str + "  " + str2);
        }
    }

    public static void m6873v(String str) {
        if (IS_LOG) {
            Log.v(TAG, str);
        }
    }

    public static void m6874v(String str, String str2) {
        if (IS_LOG) {
            Log.v(str, str2);
        }
    }

    public static void m6875v(String str, String str2, Throwable th) {
        if (IS_LOG) {
            Log.v(str, str2, th);
        }
    }

    public static void m6876w(String str) {
        if (IS_LOG) {
            Log.w(TAG, str);
        }
    }

    public static void m6877w(String str, String str2) {
        if (IS_LOG) {
            Log.w(str, str2);
        }
    }

    public static void m6878w(String str, String str2, Throwable th) {
        if (IS_LOG) {
            Log.w(str, str2, th);
        }
    }

    public static void m6879w(String str, Throwable th) {
        if (IS_LOG) {
            Log.w(str, th);
        }
    }

    public static void wtf(String str, String str2) {
        if (IS_LOG) {
            Log.wtf(str, str2);
        }
    }

    public static void wtf(String str, String str2, Throwable th) {
        if (IS_LOG) {
            Log.wtf(str, str2, th);
        }
    }

    public static void wtf(String str, Throwable th) {
        if (IS_LOG) {
            Log.wtf(str, th);
        }
    }
}
