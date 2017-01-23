package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.openad.interfaces.utils.IOAdTimer.EventHandler;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.baidu.mobads.production.e */
class C2052e implements EventHandler {
    final /* synthetic */ C2028a f7158a;

    C2052e(C2028a c2028a) {
        this.f7158a = c2028a;
    }

    public void onTimer(int i) {
    }

    public void onTimerComplete() {
        this.f7158a.m7590g();
        this.f7158a.m7589f();
        this.f7158a.m7559a(XAdErrorCode.REQUEST_TIMEOUT, BuildConfig.FLAVOR);
    }
}
