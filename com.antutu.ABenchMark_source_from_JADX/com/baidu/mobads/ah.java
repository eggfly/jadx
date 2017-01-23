package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p080j.C1991m;

class ah implements IOAdEventListener {
    final /* synthetic */ VideoAdView f6680a;

    ah(VideoAdView videoAdView) {
        this.f6680a = videoAdView;
    }

    public void run(IOAdEvent iOAdEvent) {
        C1991m.m7449a().m7464m().m7420a(new ai(this, iOAdEvent));
    }
}
