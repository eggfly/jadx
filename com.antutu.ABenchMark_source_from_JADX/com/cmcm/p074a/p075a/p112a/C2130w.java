package com.cmcm.p074a.p075a.p112a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igexin.sdk.PushConsts;

/* renamed from: com.cmcm.a.a.a.w */
class C2130w extends BroadcastReceiver {
    private C2130w() {
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.cmplay.activesdk.cloud_cfg.update")) {
            C2126s.m8045f();
        } else if (action.equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
            C2126s.m8044e();
        }
    }
}
