package com.umeng.analytics.social;

import android.util.Log;

/* renamed from: com.umeng.analytics.social.b */
public class C4185b {
    public static void m17054a(String str, String str2) {
        if (C4188e.f14079v) {
            Log.i(str, str2);
        }
    }

    public static void m17055a(String str, String str2, Exception exception) {
        if (C4188e.f14079v) {
            Log.i(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    public static void m17056b(String str, String str2) {
        if (C4188e.f14079v) {
            Log.e(str, str2);
        }
    }

    public static void m17057b(String str, String str2, Exception exception) {
        if (C4188e.f14079v) {
            Log.e(str, exception.toString() + ":  [" + str2 + "]");
            for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                Log.e(str, "        at\t " + stackTraceElement.toString());
            }
        }
    }

    public static void m17058c(String str, String str2) {
        if (C4188e.f14079v) {
            Log.d(str, str2);
        }
    }

    public static void m17059c(String str, String str2, Exception exception) {
        if (C4188e.f14079v) {
            Log.d(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    public static void m17060d(String str, String str2) {
        if (C4188e.f14079v) {
            Log.v(str, str2);
        }
    }

    public static void m17061d(String str, String str2, Exception exception) {
        if (C4188e.f14079v) {
            Log.v(str, exception.toString() + ":  [" + str2 + "]");
        }
    }

    public static void m17062e(String str, String str2) {
        if (C4188e.f14079v) {
            Log.w(str, str2);
        }
    }

    public static void m17063e(String str, String str2, Exception exception) {
        if (C4188e.f14079v) {
            Log.w(str, exception.toString() + ":  [" + str2 + "]");
            for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                Log.w(str, "        at\t " + stackTraceElement.toString());
            }
        }
    }
}
