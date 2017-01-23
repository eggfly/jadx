package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.b;

class h extends BroadcastReceiver {
    static final String j6;
    private final v DW;
    private boolean FH;
    private boolean Hw;

    static {
        j6 = h.class.getName();
    }

    h(v vVar) {
        b.j6((Object) vVar);
        this.DW = vVar;
    }

    private void VH() {
        u7();
        tp();
    }

    private Context gn() {
        return this.DW.DW();
    }

    private r tp() {
        return this.DW.u7();
    }

    private g u7() {
        return this.DW.Zo();
    }

    public void DW() {
        if (Hw()) {
            this.DW.Zo().DW("Unregistering connectivity change receiver");
            this.FH = false;
            this.Hw = false;
            try {
                gn().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                u7().v5("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public void FH() {
        if (VERSION.SDK_INT > 10) {
            Context gn = gn();
            Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
            intent.addCategory(gn.getPackageName());
            intent.putExtra(j6, true);
            gn.sendOrderedBroadcast(intent, null);
        }
    }

    public boolean Hw() {
        return this.FH;
    }

    protected boolean Zo() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) gn().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException e) {
            return false;
        }
    }

    public void j6() {
        VH();
        if (!this.FH) {
            Context gn = gn();
            gn.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
            intentFilter.addCategory(gn.getPackageName());
            gn.registerReceiver(this, intentFilter);
            this.Hw = Zo();
            this.DW.Zo().j6("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.Hw));
            this.FH = true;
        }
    }

    public void onReceive(Context context, Intent intent) {
        VH();
        String action = intent.getAction();
        this.DW.Zo().j6("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean Zo = Zo();
            if (this.Hw != Zo) {
                this.Hw = Zo;
                tp().j6(Zo);
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.DW.Zo().Hw("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(j6)) {
            tp().VH();
        }
    }

    public boolean v5() {
        if (!this.FH) {
            this.DW.Zo().v5("Connectivity unknown. Receiver not registered");
        }
        return this.Hw;
    }
}
