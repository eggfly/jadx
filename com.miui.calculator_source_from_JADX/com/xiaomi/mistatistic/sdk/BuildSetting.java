package com.xiaomi.mistatistic.sdk;

import android.content.ContentResolver;
import android.content.Context;
import com.miui.support.reflect.Field;
import com.xiaomi.mistatistic.sdk.controller.C0551c;
import com.xiaomi.mistatistic.sdk.controller.C0566h;
import com.xiaomi.mistatistic.sdk.controller.C0597q;
import java.lang.reflect.Method;

public class BuildSetting {
    private static boolean f4636a;
    private static boolean f4637b;
    private static Boolean f4638c;
    private static boolean f4639d;
    private static long f4640e;
    private static long f4641f;

    static {
        f4636a = false;
        f4637b = false;
        f4638c = null;
        f4639d = true;
        f4640e = 60000;
        f4641f = 0;
    }

    public static boolean m6240a() {
        return f4636a;
    }

    public static boolean m6242b() {
        return f4637b;
    }

    public static boolean m6241a(Context context) {
        boolean z = false;
        if (f4639d) {
            if (f4638c == null || C0597q.m6526a(f4641f, f4640e)) {
                if (C0597q.m6534d(context) && C0597q.m6535e(context)) {
                    if (!m6243b(context)) {
                        z = true;
                    }
                    f4638c = Boolean.valueOf(z);
                } else {
                    f4638c = Boolean.valueOf(false);
                    C0566h.m6419b("isDisabled false, not miui app or OS ");
                }
                f4641f = System.currentTimeMillis();
            }
            return f4638c.booleanValue();
        }
        C0566h.m6419b("isDisabled false, sRespectUEP " + f4639d);
        return false;
    }

    public static boolean m6243b(Context context) {
        boolean booleanValue;
        try {
            Method declaredMethod = Class.forName("android.provider.MiuiSettings$Secure").getDeclaredMethod("isUserExperienceProgramEnable", new Class[]{ContentResolver.class});
            declaredMethod.setAccessible(true);
            booleanValue = ((Boolean) declaredMethod.invoke(null, new Object[]{context.getContentResolver()})).booleanValue();
        } catch (Throwable e) {
            C0566h.m6421b("BS", "isUserExperienceProgramEnable exception:", e);
            booleanValue = true;
        }
        C0566h.m6419b("UEP " + booleanValue);
        return booleanValue;
    }

    public static boolean m6245c(Context context) {
        boolean booleanValue;
        Throwable e;
        try {
            Method declaredMethod = Class.forName("android.provider.MiuiSettings$Secure").getDeclaredMethod("isUploadDebugLogEnable", new Class[]{ContentResolver.class});
            declaredMethod.setAccessible(true);
            booleanValue = ((Boolean) declaredMethod.invoke(null, new Object[]{context.getContentResolver()})).booleanValue();
            try {
                C0566h.m6414a("isUploadDebugLogEnable: " + booleanValue);
            } catch (Exception e2) {
                e = e2;
                C0566h.m6421b("BS", "isUploadDebugLogEnable exception:", e);
                return booleanValue;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            booleanValue = true;
            e = th;
            C0566h.m6421b("BS", "isUploadDebugLogEnable exception:", e);
            return booleanValue;
        }
        return booleanValue;
    }

    public static boolean m6244c() {
        try {
            if (C0597q.m6534d(C0551c.m6352a())) {
                return ((Boolean) Class.forName("com.miui.support.os.Build").getField("IS_CTA_BUILD").get(null)).booleanValue();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean m6247e() {
        try {
            if (!C0597q.m6534d(C0551c.m6352a())) {
                return false;
            }
            Object obj = Class.forName("com.miui.support.os.Build").getField("IS_ALPHA_BUILD").get(null);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (Exception e) {
        }
    }

    private static boolean m6248f() {
        try {
            if (!C0597q.m6534d(C0551c.m6352a())) {
                return false;
            }
            Object obj = Class.forName("com.miui.support.os.Build").getField("IS_DEVELOPMENT_VERSION").get(null);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (Exception e) {
        }
    }

    private static boolean m6249g() {
        try {
            if (!C0597q.m6534d(C0551c.m6352a())) {
                return false;
            }
            Object obj = Class.forName("com.miui.support.os.Build").getField("IS_STABLE_VERSION").get(null);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (Exception e) {
        }
    }

    public static String m6246d() {
        if (m6249g()) {
            return Field.SHORT_SIGNATURE_PRIMITIVE;
        }
        if (m6248f()) {
            return Field.DOUBLE_SIGNATURE_PRIMITIVE;
        }
        if (m6247e()) {
            return "A";
        }
        return "";
    }
}
