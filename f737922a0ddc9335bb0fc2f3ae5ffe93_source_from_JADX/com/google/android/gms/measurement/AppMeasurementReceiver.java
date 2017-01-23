package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.af;

public final class AppMeasurementReceiver extends BroadcastReceiver {
    private af j6;

    private af j6() {
        if (this.j6 == null) {
            this.j6 = new af();
        }
        return this.j6;
    }

    public void onReceive(Context context, Intent intent) {
        j6().j6(context, intent);
    }
}
