package com.cmcm.p074a.p075a.p114c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.cmcm.a.a.c.l */
class C2147l extends BroadcastReceiver {
    final /* synthetic */ C2145j f7504a;

    private C2147l(C2145j c2145j) {
        this.f7504a = c2145j;
    }

    public void onReceive(Context context, Intent intent) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int intExtra = intent.getIntExtra("state", -1);
        int intExtra2 = intent.getIntExtra("microphone", -1);
        if (intExtra == 1) {
            this.f7504a.f7503b = currentTimeMillis;
        } else if (intExtra == 0) {
            this.f7504a.m8102a(intExtra2, this.f7504a.f7503b, currentTimeMillis);
            this.f7504a.f7503b = 0;
        }
    }
}
