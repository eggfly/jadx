package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.k;

public final class AnalyticsReceiver extends BroadcastReceiver {
    private k j6;

    private k j6() {
        if (this.j6 == null) {
            this.j6 = new k();
        }
        return this.j6;
    }

    public void onReceive(Context context, Intent intent) {
        j6().j6(context, intent);
    }
}
