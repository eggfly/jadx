package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p080j.C1991m;

/* renamed from: com.baidu.mobads.w */
class C2079w implements IOAdEventListener {
    final /* synthetic */ InterstitialAd f7316a;

    C2079w(InterstitialAd interstitialAd) {
        this.f7316a = interstitialAd;
    }

    public void run(IOAdEvent iOAdEvent) {
        C1991m.m7449a().m7457f().m7402i(InterstitialAd.TAG, "evt.type=" + iOAdEvent.getType());
        C1991m.m7449a().m7464m().m7420a(new C2080x(this, iOAdEvent));
    }
}
