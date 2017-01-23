package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.hy;

public final class k {
    static hy DW;
    static Boolean FH;
    static Object j6;

    static {
        j6 = new Object();
    }

    public static boolean j6(Context context) {
        b.j6((Object) context);
        if (FH != null) {
            return FH.booleanValue();
        }
        boolean j6 = p.j6(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        FH = Boolean.valueOf(j6);
        return j6;
    }

    public void j6(Context context, Intent intent) {
        v j6 = v.j6(context);
        g Zo = j6.Zo();
        if (intent == null) {
            Zo.v5("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (j6.v5().j6()) {
            Zo.j6("Device AnalyticsReceiver got", action);
        } else {
            Zo.j6("Local AnalyticsReceiver got", action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean j62 = l.j6(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (j6) {
                context.startService(intent2);
                if (j62) {
                    try {
                        if (DW == null) {
                            DW = new hy(context, 1, "Analytics WakeLock");
                            DW.j6(false);
                        }
                        DW.j6(1000);
                    } catch (SecurityException e) {
                        Zo.v5("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                    return;
                }
            }
        }
    }
}
