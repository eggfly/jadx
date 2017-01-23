package com.google.android.gms.common.stats;

import afp;
import afu;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.c.b;
import java.util.List;

public class h {
    private static h DW;
    private static Boolean FH;
    private static String j6;

    static {
        j6 = "WakeLockTracker";
        DW = new h();
    }

    private static boolean DW(Context context) {
        try {
            if (!afp.j6()) {
                return false;
            }
            return ((Integer) b.j6.j6()).intValue() != d.DW;
        } catch (SecurityException e) {
            return false;
        }
    }

    public static h j6() {
        return DW;
    }

    private static boolean j6(Context context) {
        if (FH == null) {
            FH = Boolean.valueOf(DW(context));
        }
        return FH.booleanValue();
    }

    public void j6(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        j6(context, str, i, str2, str3, str4, i2, list, 0);
    }

    public void j6(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        if (!j6(context)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            String str5 = j6;
            String str6 = "missing wakeLock key. ";
            String valueOf = String.valueOf(str);
            Log.e(str5, valueOf.length() != 0 ? str6.concat(valueOf) : new String(str6));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (7 == i || 8 == i || 10 == i || 11 == i) {
            try {
                context.startService(new Intent().setComponent(d.j6).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, f.j6((List) list), str, SystemClock.elapsedRealtime(), afu.j6(context), str3, f.j6(context.getPackageName()), afu.DW(context), j, str4)));
            } catch (Throwable e) {
                Log.wtf(j6, e);
            }
        }
    }
}
