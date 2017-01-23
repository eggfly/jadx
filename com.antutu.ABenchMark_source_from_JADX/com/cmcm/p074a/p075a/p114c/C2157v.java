package com.cmcm.p074a.p075a.p114c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igexin.sdk.PushConsts;

/* renamed from: com.cmcm.a.a.c.v */
class C2157v extends BroadcastReceiver {
    final /* synthetic */ C2155t f7516a;

    private C2157v(C2155t c2155t) {
        this.f7516a = c2155t;
    }

    public void onReceive(Context context, Intent intent) {
        long currentTimeMillis = (long) ((int) (System.currentTimeMillis() / 1000));
        String action = intent.getAction();
        if ("android.intent.action.SCREEN_ON".equals(action)) {
            this.f7516a.f7513b = currentTimeMillis;
        } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
            this.f7516a.f7514c = currentTimeMillis;
            this.f7516a.m8137c();
            this.f7516a.f7514c = 0;
            this.f7516a.f7513b = 0;
            this.f7516a.f7515d = 0;
        } else if (PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(action)) {
            this.f7516a.f7515d = currentTimeMillis;
        }
    }
}
