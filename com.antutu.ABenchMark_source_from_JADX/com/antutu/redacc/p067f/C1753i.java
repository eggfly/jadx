package com.antutu.redacc.p067f;

import android.content.Context;
import android.os.Build.VERSION;

/* renamed from: com.antutu.redacc.f.i */
public class C1753i {
    public static void m6758a(Context context) {
        try {
            Object systemService = context.getSystemService("statusbar");
            (VERSION.SDK_INT <= 16 ? systemService.getClass().getMethod("collapse", new Class[0]) : systemService.getClass().getMethod("collapsePanels", new Class[0])).invoke(systemService, new Object[0]);
        } catch (Exception e) {
        }
    }
}
