package com.xiaomi.mipush.sdk;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.commonutils.network.C4321d;
import com.xiaomi.push.service.ac;

/* renamed from: com.xiaomi.mipush.sdk.p */
class C4361p extends ContentObserver {
    final /* synthetic */ C4360o f14832a;

    C4361p(C4360o c4360o, Handler handler) {
        this.f14832a = c4360o;
        super(handler);
    }

    public void onChange(boolean z) {
        this.f14832a.f14831g = Integer.valueOf(ac.m18115a(this.f14832a.f14828c).m18117b());
        if (this.f14832a.f14831g.intValue() != 0) {
            this.f14832a.f14828c.getContentResolver().unregisterContentObserver(this);
            if (C4321d.m17709d(this.f14832a.f14828c)) {
                this.f14832a.m17875c();
            }
        }
    }
}
