package com.antutu.benchmark.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ConnectionChangeReceiver extends BroadcastReceiver {
    private static final String f5591a;
    private int f5592b;
    private int f5593c;

    static {
        f5591a = ConnectionChangeReceiver.class.getSimpleName();
    }

    public ConnectionChangeReceiver() {
        this.f5592b = -1;
        this.f5593c = -1;
    }

    public void onReceive(Context context, Intent intent) {
    }
}
