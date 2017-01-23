package com.baidu.mobads.openad.p083a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igexin.sdk.PushConsts;

/* renamed from: com.baidu.mobads.openad.a.b */
public class C2004b extends BroadcastReceiver {
    private C2005c f6984a;

    public C2004b(C2005c c2005c) {
        this.f6984a = c2005c;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
            this.f6984a.m7482b();
        }
    }
}
