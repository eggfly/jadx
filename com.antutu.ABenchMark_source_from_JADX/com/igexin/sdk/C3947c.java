package com.igexin.sdk;

import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.util.C3925d;

/* renamed from: com.igexin.sdk.c */
class C3947c implements C3925d {
    final /* synthetic */ PushService f13248a;

    C3947c(PushService pushService) {
        this.f13248a = pushService;
    }

    public void m16230a(boolean z) {
        C3688a.m15097b(PushService.f13230a + "|load so error, report bi result = " + z + " ###########");
        this.f13248a.m16214d();
        this.f13248a.stopSelf();
    }
}
