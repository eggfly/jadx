package com.taobao.accs.net;

import com.taobao.accs.utl.ALog;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.taobao.accs.net.d */
class C4115d implements Runnable {
    final /* synthetic */ C4112a f13769a;

    C4115d(C4112a c4112a) {
        this.f13769a = c4112a;
    }

    public void run() {
        if (this.f13769a.f13759c.m16760d()) {
            ALog.m16903e(this.f13769a.m16820e(), this.f13769a.f13757a + "receive ping time out! ", new Object[0]);
            C4116e.m16824a(this.f13769a.f13758b).m16827c();
            this.f13769a.m16811a(BuildConfig.FLAVOR, "receive ping timeout");
            this.f13769a.f13759c.m16748a(-12);
        }
    }
}
