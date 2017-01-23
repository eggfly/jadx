package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.hy;

public final class e {
    private static Boolean Hw;
    private final Context DW;
    private final a FH;
    private final Handler j6;

    public interface a {
        Context j6();

        boolean j6(int i);
    }

    class 1 implements Runnable {
        final /* synthetic */ int DW;
        final /* synthetic */ aa FH;
        final /* synthetic */ e Hw;
        final /* synthetic */ ai j6;

        class 1 implements Runnable {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void run() {
                if (!this.j6.Hw.FH.j6(this.j6.DW)) {
                    return;
                }
                if (this.j6.j6.Hw().ef()) {
                    this.j6.FH.ei().j6("Device AppMeasurementService processed last upload request");
                } else {
                    this.j6.FH.ei().j6("Local AppMeasurementService processed last upload request");
                }
            }
        }

        1(e eVar, ai aiVar, int i, aa aaVar) {
            this.Hw = eVar;
            this.j6 = aiVar;
            this.DW = i;
            this.FH = aaVar;
        }

        public void run() {
            this.j6.cn();
            this.j6.KD();
            this.Hw.j6.post(new 1(this));
        }
    }

    public e(a aVar) {
        this.DW = aVar.j6();
        b.j6(this.DW);
        this.FH = aVar;
        this.j6 = new Handler();
    }

    private void FH() {
        try {
            synchronized (af.j6) {
                hy hyVar = af.DW;
                if (hyVar != null && hyVar.DW()) {
                    hyVar.j6();
                }
            }
        } catch (SecurityException e) {
        }
    }

    private aa Hw() {
        return ai.j6(this.DW).Zo();
    }

    public static boolean j6(Context context) {
        b.j6((Object) context);
        if (Hw != null) {
            return Hw.booleanValue();
        }
        boolean j6 = l.j6(context, "com.google.android.gms.measurement.AppMeasurementService");
        Hw = Boolean.valueOf(j6);
        return j6;
    }

    public void DW() {
        ai j6 = ai.j6(this.DW);
        aa Zo = j6.Zo();
        if (j6.Hw().ef()) {
            Zo.ei().j6("Device AppMeasurementService is shutting down");
        } else {
            Zo.ei().j6("Local AppMeasurementService is shutting down");
        }
    }

    public boolean DW(Intent intent) {
        if (intent == null) {
            Hw().Zo().j6("onUnbind called with null intent");
        } else {
            Hw().ei().j6("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }

    public void FH(Intent intent) {
        if (intent == null) {
            Hw().Zo().j6("onRebind called with null intent");
            return;
        }
        Hw().ei().j6("onRebind called. action", intent.getAction());
    }

    public int j6(Intent intent, int i, int i2) {
        FH();
        ai j6 = ai.j6(this.DW);
        aa Zo = j6.Zo();
        if (intent == null) {
            Zo.yS().j6("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            if (j6.Hw().ef()) {
                Zo.ei().j6("Device AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            } else {
                Zo.ei().j6("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            }
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                j6.gn().j6(new 1(this, j6, i2, Zo));
            }
        }
        return 2;
    }

    public IBinder j6(Intent intent) {
        if (intent == null) {
            Hw().Zo().j6("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new aj(ai.j6(this.DW));
        }
        Hw().yS().j6("onBind received unknown action", action);
        return null;
    }

    public void j6() {
        ai j6 = ai.j6(this.DW);
        aa Zo = j6.Zo();
        if (j6.Hw().ef()) {
            Zo.ei().j6("Device AppMeasurementService is starting up");
        } else {
            Zo.ei().j6("Local AppMeasurementService is starting up");
        }
    }
}
