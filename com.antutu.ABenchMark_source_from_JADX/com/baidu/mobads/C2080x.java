package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.p080j.C1991m;

/* renamed from: com.baidu.mobads.x */
class C2080x implements Runnable {
    final /* synthetic */ IOAdEvent f7317a;
    final /* synthetic */ C2079w f7318b;

    C2080x(C2079w c2079w, IOAdEvent iOAdEvent) {
        this.f7318b = c2079w;
        this.f7317a = iOAdEvent;
    }

    public void run() {
        if (IXAdEvent.AD_LOADED.equals(this.f7317a.getType())) {
            this.f7318b.f7316a.f6634e.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.f7317a.getType())) {
            this.f7318b.f7316a.f6634e.onAdFailed(C1991m.m7449a().m7468q().getMessage(this.f7317a.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.f7317a.getType())) {
            this.f7318b.f7316a.f6634e.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.f7317a.getType())) {
            this.f7318b.f7316a.f6634e.onAdPresent();
        } else if ("AdUserClick".equals(this.f7317a.getType())) {
            this.f7318b.f7316a.f6634e.onAdClick(this.f7318b.f7316a);
        }
    }
}
