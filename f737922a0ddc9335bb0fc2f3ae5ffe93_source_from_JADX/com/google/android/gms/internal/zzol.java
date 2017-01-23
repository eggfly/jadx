package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zzol extends BroadcastReceiver {
    private final a DW;
    protected Context j6;

    public static abstract class a {
        public abstract void j6();
    }

    public zzol(a aVar) {
        this.DW = aVar;
    }

    public synchronized void j6() {
        if (this.j6 != null) {
            this.j6.unregisterReceiver(this);
        }
        this.j6 = null;
    }

    public void j6(Context context) {
        this.j6 = context;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            this.DW.j6();
            j6();
        }
    }
}
