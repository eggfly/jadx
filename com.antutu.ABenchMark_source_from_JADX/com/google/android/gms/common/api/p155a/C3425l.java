package com.google.android.gms.common.api.p155a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.C3457f;
import com.umeng.message.common.C4209a;

/* renamed from: com.google.android.gms.common.api.a.l */
abstract class C3425l extends BroadcastReceiver {
    protected Context f11898a;

    C3425l() {
    }

    public static <T extends C3425l> T m14124a(Context context, T t, C3457f c3457f) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme(C4209a.f14200c);
        context.registerReceiver(t, intentFilter);
        t.f11898a = context;
        if (c3457f.m14275a(context, "com.google.android.gms")) {
            return t;
        }
        t.m14125a();
        t.m14126b();
        return null;
    }

    protected abstract void m14125a();

    public synchronized void m14126b() {
        if (this.f11898a != null) {
            this.f11898a.unregisterReceiver(this);
        }
        this.f11898a = null;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            m14125a();
            m14126b();
        }
    }
}
