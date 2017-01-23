package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p080j.C1991m;

class ae implements IOAdEventListener {
    final /* synthetic */ SplashAd f6672a;

    ae(SplashAd splashAd) {
        this.f6672a = splashAd;
    }

    public void run(IOAdEvent iOAdEvent) {
        if (this.f6672a.f6637c != null) {
            C1991m.m7449a().m7464m().m7420a(new af(this, iOAdEvent));
        }
    }
}
