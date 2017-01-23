package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.e;
import com.google.android.gms.measurement.internal.e.a;

public final class AppMeasurementService extends Service implements a {
    private e j6;

    private e DW() {
        if (this.j6 == null) {
            this.j6 = new e(this);
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

    public void onRebind(Intent intent) {
        DW().FH(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return DW().j6(intent, i, i2);
    }

    public boolean onUnbind(Intent intent) {
        return DW().DW(intent);
    }
}
