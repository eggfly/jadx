package com.google.analytics.tracking.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.igexin.sdk.PushConsts;

class GANetworkReceiver extends BroadcastReceiver {
    private final ServiceManager mManager;

    GANetworkReceiver(ServiceManager serviceManager) {
        this.mManager = serviceManager;
    }

    public void onReceive(Context context, Intent intent) {
        if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            Boolean bool = Boolean.FALSE;
            if (extras != null) {
                bool = Boolean.valueOf(intent.getExtras().getBoolean("noConnectivity"));
            }
            this.mManager.updateConnectivityStatus(!bool.booleanValue());
        }
    }
}
