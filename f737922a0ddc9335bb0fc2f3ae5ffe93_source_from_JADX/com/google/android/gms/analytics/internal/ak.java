package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.internal.b;

public class ak extends t {
    private boolean DW;
    private AlarmManager FH;
    private boolean j6;

    protected ak(v vVar) {
        super(vVar);
        this.FH = (AlarmManager) Ws().getSystemService("alarm");
    }

    private PendingIntent Zo() {
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(Ws(), "com.google.android.gms.analytics.AnalyticsReceiver"));
        return PendingIntent.getBroadcast(Ws(), 0, intent, 0);
    }

    public boolean DW() {
        return this.j6;
    }

    public boolean FH() {
        return this.DW;
    }

    public void Hw() {
        P8();
        b.j6(DW(), (Object) "Receiver not registered");
        long tp = XL().tp();
        if (tp > 0) {
            v5();
            long DW = J8().DW() + tp;
            this.DW = true;
            this.FH.setInexactRepeating(2, DW, 0, Zo());
        }
    }

    protected void j6() {
        try {
            this.FH.cancel(Zo());
            if (XL().tp() > 0) {
                ActivityInfo receiverInfo = Ws().getPackageManager().getReceiverInfo(new ComponentName(Ws(), "com.google.android.gms.analytics.AnalyticsReceiver"), 2);
                if (receiverInfo != null && receiverInfo.enabled) {
                    DW("Receiver registered. Using alarm for local dispatch.");
                    this.j6 = true;
                }
            }
        } catch (NameNotFoundException e) {
        }
    }

    public void v5() {
        P8();
        this.DW = false;
        this.FH.cancel(Zo());
    }
}
