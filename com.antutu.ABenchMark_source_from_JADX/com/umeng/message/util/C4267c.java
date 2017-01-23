package com.umeng.message.util;

import android.os.Build;
import java.io.IOException;

/* renamed from: com.umeng.message.util.c */
public class C4267c {
    private static final String f14595a = "ro.build.version.emui";
    private static final String f14596b = "ro.miui.ui.version.code";
    private static final String f14597c = "ro.miui.ui.version.name";
    private static final String f14598d = "ro.miui.internal.storage";

    public static boolean m17548a() {
        return C4267c.m17549a(f14595a);
    }

    private static boolean m17549a(String... strArr) {
        try {
            C4265a g = C4265a.m17534g();
            for (String a : strArr) {
                if (g.m17535a(a) == null) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean m17550b() {
        return C4267c.m17549a(f14596b, f14597c, f14598d);
    }

    public static boolean m17551c() {
        try {
            return Build.class.getMethod("hasSmartBar", new Class[0]) != null;
        } catch (Exception e) {
            return false;
        }
    }
}
