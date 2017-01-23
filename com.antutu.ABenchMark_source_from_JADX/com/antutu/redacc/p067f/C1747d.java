package com.antutu.redacc.p067f;

import android.content.Context;
import android.os.Binder;
import android.os.Build.VERSION;
import android.text.TextUtils;

/* renamed from: com.antutu.redacc.f.d */
public class C1747d {
    public static int m6744a(Context context, int i, boolean z) {
        if (z && VERSION.SDK_INT < 23 && TextUtils.isEmpty(C1754k.m6759a("ro.miui.ui.version.name"))) {
            return 0;
        }
        if (VERSION.SDK_INT >= 19) {
            Object systemService = context.getSystemService("appops");
            try {
                int intValue = ((Integer) systemService.getClass().getDeclaredMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(systemService, new Object[]{Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue();
                if (intValue == 3 || intValue == 0) {
                    intValue = 0;
                }
                return intValue;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return -1;
    }
}
