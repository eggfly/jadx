package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.hy;

public final class af {
    static hy DW;
    static Boolean FH;
    static final Object j6;

    static {
        j6 = new Object();
    }

    public static boolean j6(Context context) {
        b.j6((Object) context);
        if (FH != null) {
            return FH.booleanValue();
        }
        boolean j6 = l.j6(context, "com.google.android.gms.measurement.AppMeasurementReceiver", false);
        FH = Boolean.valueOf(j6);
        return j6;
    }

    public void j6(Context context, Intent intent) {
        ai j6 = ai.j6(context);
        aa Zo = j6.Zo();
        if (intent == null) {
            Zo.yS().j6("AppMeasurementReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (j6.Hw().ef()) {
            Zo.ei().j6("Device AppMeasurementReceiver got", action);
        } else {
            Zo.ei().j6("Local AppMeasurementReceiver got", action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            boolean j62 = e.j6(context);
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            synchronized (j6) {
                context.startService(className);
                if (j62) {
                    try {
                        if (DW == null) {
                            DW = new hy(context, 1, "AppMeasurement WakeLock");
                            DW.j6(false);
                        }
                        DW.j6(1000);
                    } catch (SecurityException e) {
                        Zo.yS().j6("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
                    }
                    return;
                }
            }
        }
    }
}
