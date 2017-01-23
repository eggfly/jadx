package com.baidu.mobads.production.p098a;

import com.baidu.mobads.p080j.C1991m;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.baidu.mobads.production.a.b */
class C2030b implements Runnable {
    final /* synthetic */ C2029a f7098a;

    C2030b(C2029a c2029a) {
        this.f7098a = c2029a;
    }

    public void run() {
        C1991m.m7449a().m7464m().getBaiduMapsInfo(this.f7098a.f);
        C1991m.m7449a().m7465n().getCUID(this.f7098a.f);
        C1991m.m7449a().m7465n().getCell(this.f7098a.f);
        C1991m.m7449a().m7465n().getAppSDC();
        C1991m.m7449a().m7465n().getWIFI(this.f7098a.f);
        C1991m.m7449a().m7465n().getGPS(this.f7098a.f);
        C1991m.m7449a().m7465n().getNetType(this.f7098a.f);
        C1991m.m7449a().m7465n().getAppSDC();
        C1991m.m7449a().m7465n().getMem();
        C1991m.m7449a().m7465n().getAndroidId(this.f7098a.f);
        C1991m.m7449a().m7464m().createRequestId(this.f7098a.f, BuildConfig.FLAVOR);
    }
}
