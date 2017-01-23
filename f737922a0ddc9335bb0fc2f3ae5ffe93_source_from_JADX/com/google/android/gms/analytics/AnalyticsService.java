package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.analytics.internal.l.a;

public final class AnalyticsService extends Service implements a {
    private l j6;

    private l DW() {
        if (this.j6 == null) {
            this.j6 = new l(this);
        }
        return this.j6;
    }

    public Context j6() {
        return this;
    }

    public boolean j6(int i) {
        return stopSelfResult(i);
    }

    public IBinder onBind(Intent intent) {
        return DW().j6(intent);
    }

    public void onCreate() {
        super.onCreate();
        DW().j6();
    }

    public void onDestroy() {
        DW().DW();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return DW().j6(intent, i, i2);
    }
}
