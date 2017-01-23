package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.b;

class ac extends BroadcastReceiver {
    static final String j6;
    private final ai DW;
    private boolean FH;
    private boolean Hw;

    class 1 implements Runnable {
        final /* synthetic */ ac DW;
        final /* synthetic */ boolean j6;

        1(ac acVar, boolean z) {
            this.DW = acVar;
            this.j6 = z;
        }

        public void run() {
            this.DW.DW.j6(this.j6);
        }
    }

    static {
        j6 = ac.class.getName();
    }

    ac(ai aiVar) {
        b.j6((Object) aiVar);
        this.DW = aiVar;
    }

    private Context Hw() {
        return this.DW.XL();
    }

    private aa v5() {
        return this.DW.Zo();
    }

    public void DW() {
        this.DW.j6();
        this.DW.er();
        if (FH()) {
            v5().ei().j6("Unregistering connectivity change receiver");
            this.FH = false;
            this.Hw = false;
            try {
                Hw().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                v5().Zo().j6("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public boolean FH() {
        this.DW.er();
        return this.FH;
    }

    public void j6() {
        this.DW.j6();
        this.DW.er();
        if (!this.FH) {
            Hw().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.Hw = this.DW.QX().Zo();
            v5().ei().j6("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.Hw));
            this.FH = true;
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.DW.j6();
        String action = intent.getAction();
        v5().ei().j6("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean Zo = this.DW.QX().Zo();
            if (this.Hw != Zo) {
                this.Hw = Zo;
                this.DW.gn().j6(new 1(this, Zo));
                return;
            }
            return;
        }
        v5().yS().j6("NetworkBroadcastReceiver received unknown action", action);
    }
}
