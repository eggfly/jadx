package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.umeng.message.proguard.C4233j;

class ai implements Runnable {
    final /* synthetic */ IOAdEvent f6681a;
    final /* synthetic */ ah f6682b;

    ai(ah ahVar, IOAdEvent iOAdEvent) {
        this.f6682b = ahVar;
        this.f6681a = iOAdEvent;
    }

    public void run() {
        if (IXAdEvent.AD_LOADED.equals(this.f6681a.getType())) {
            this.f6682b.f6680a.f6652c.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.f6681a.getType())) {
            this.f6682b.f6680a.f6652c.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.f6681a.getType())) {
            this.f6682b.f6680a.f6652c.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.f6681a.getType())) {
            this.f6682b.f6680a.f6652c.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.f6681a.getType())) {
            String str = (String) this.f6681a.getData().get(C4233j.f14376C);
            this.f6682b.f6680a.f6652c.onVideoError();
        }
    }
}
