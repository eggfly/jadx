package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.hy;

public final class l {
    private static Boolean Hw;
    private final a DW;
    private final Context FH;
    private final Handler j6;

    public interface a {
        Context j6();

        boolean j6(int i);
    }

    class 1 implements al {
        final /* synthetic */ v DW;
        final /* synthetic */ g FH;
        final /* synthetic */ l Hw;
        final /* synthetic */ int j6;

        class 1 implements Runnable {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void run() {
                if (!this.j6.Hw.DW.j6(this.j6.j6)) {
                    return;
                }
                if (this.j6.DW.v5().j6()) {
                    this.j6.FH.DW("Device AnalyticsService processed last dispatch request");
                } else {
                    this.j6.FH.DW("Local AnalyticsService processed last dispatch request");
                }
            }
        }

        1(l lVar, int i, v vVar, g gVar) {
            this.Hw = lVar;
            this.j6 = i;
            this.DW = vVar;
            this.FH = gVar;
        }

        public void j6(Throwable th) {
            this.Hw.j6.post(new 1(this));
        }
    }

    public l(a aVar) {
        this.FH = aVar.j6();
        b.j6(this.FH);
        this.DW = aVar;
        this.j6 = new Handler();
    }

    private void FH() {
        try {
            synchronized (k.j6) {
                hy hyVar = k.DW;
                if (hyVar != null && hyVar.DW()) {
                    hyVar.j6();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public static boolean j6(Context context) {
        b.j6((Object) context);
        if (Hw != null) {
            return Hw.booleanValue();
        }
        boolean j6 = p.j6(context, "com.google.android.gms.analytics.AnalyticsService");
        Hw = Boolean.valueOf(j6);
        return j6;
    }

    public void DW() {
        v j6 = v.j6(this.FH);
        g Zo = j6.Zo();
        if (j6.v5().j6()) {
            Zo.DW("Device AnalyticsService is shutting down");
        } else {
            Zo.DW("Local AnalyticsService is shutting down");
        }
    }

    public int j6(Intent intent, int i, int i2) {
        FH();
        v j6 = v.j6(this.FH);
        g Zo = j6.Zo();
        if (intent == null) {
            Zo.v5("AnalyticsService started with null intent");
        } else {
            String action = intent.getAction();
            if (j6.v5().j6()) {
                Zo.j6("Device AnalyticsService called. startId, action", Integer.valueOf(i2), action);
            } else {
                Zo.j6("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
            }
            if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
                j6.u7().j6(new 1(this, i2, j6, Zo));
            }
        }
        return 2;
    }

    public IBinder j6(Intent intent) {
        return null;
    }

    public void j6() {
        v j6 = v.j6(this.FH);
        g Zo = j6.Zo();
        if (j6.v5().j6()) {
            Zo.DW("Device AnalyticsService is starting up");
        } else {
            Zo.DW("Local AnalyticsService is starting up");
        }
    }
}
