package com.xiaomi.mistatistic.sdk.controller;

import android.text.TextUtils;
import android.util.Log;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.Locale;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.h */
public class C0566h {
    private static boolean f4743a;

    static {
        f4743a = false;
    }

    private static void m6413a(int i, Throwable th, String str, String str2, Object... objArr) {
        String e = C0566h.m6427e(str);
        String a = C0566h.m6411a(str2, objArr);
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                Log.e(e, a, th);
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                Log.w(e, a, th);
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                Log.i(e, a, th);
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                Log.d(e, a, th);
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                Log.v(e, a, th);
            default:
        }
    }

    private static void m6412a(int i, Throwable th, String str, String str2) {
        String e = C0566h.m6427e(str);
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                Log.e(e, str2, th);
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                Log.w(e, str2, th);
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                Log.i(e, str2, th);
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                Log.d(e, str2, th);
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                Log.v(e, str2, th);
            default:
        }
    }

    private static String m6427e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "MI_STAT";
        }
        return "MI_STAT_" + str;
    }

    private static String m6411a(String str, Object... objArr) {
        try {
            return String.format(Locale.getDefault(), str, objArr);
        } catch (Throwable e) {
            C0566h.m6418a("log getMessage exception :", e);
            return null;
        }
    }

    public static void m6417a(String str, String str2, Object... objArr) {
        if (f4743a) {
            C0566h.m6413a(4, null, str, str2, objArr);
        }
    }

    public static void m6415a(String str, String str2) {
        if (f4743a) {
            C0566h.m6412a(4, null, str, str2);
        }
    }

    public static void m6414a(String str) {
        if (f4743a) {
            C0566h.m6412a(4, null, null, str);
        }
    }

    public static void m6416a(String str, String str2, Throwable th) {
        if (f4743a) {
            C0566h.m6412a(0, th, str, str2);
        }
    }

    public static void m6418a(String str, Throwable th) {
        if (f4743a) {
            C0566h.m6412a(0, th, null, str);
        }
    }

    public static void m6422b(String str, String str2, Object... objArr) {
        if (f4743a) {
            C0566h.m6413a(3, null, str, str2, objArr);
        }
    }

    public static void m6420b(String str, String str2) {
        if (f4743a) {
            C0566h.m6412a(3, null, str, str2);
        }
    }

    public static void m6419b(String str) {
        if (f4743a) {
            C0566h.m6412a(3, null, null, str);
        }
    }

    public static void m6424c(String str, String str2) {
        if (f4743a) {
            C0566h.m6412a(2, null, str, str2);
        }
    }

    public static void m6423c(String str) {
        if (f4743a) {
            C0566h.m6412a(2, null, null, str);
        }
    }

    public static void m6421b(String str, String str2, Throwable th) {
        if (f4743a) {
            C0566h.m6412a(1, th, str, str2);
        }
    }

    public static void m6426d(String str, String str2) {
        if (f4743a) {
            C0566h.m6412a(1, null, null, str2);
        }
    }

    public static void m6425d(String str) {
        if (f4743a) {
            C0566h.m6412a(1, null, null, str);
        }
    }
}
