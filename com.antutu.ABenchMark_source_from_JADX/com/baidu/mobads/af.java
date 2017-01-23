package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.p080j.C1991m;

class af implements Runnable {
    final /* synthetic */ IOAdEvent f6673a;
    final /* synthetic */ ae f6674b;

    af(ae aeVar, IOAdEvent iOAdEvent) {
        this.f6674b = aeVar;
        this.f6673a = iOAdEvent;
    }

    public void run() {
        if (IXAdEvent.AD_LOADED.equals(this.f6673a.getType())) {
            C1991m.m7449a().m7457f().m7404i(this.f6673a);
        } else if (IXAdEvent.AD_STARTED.equals(this.f6673a.getType())) {
            this.f6674b.f6672a.f6637c.onAdPresent();
        } else if ("AdUserClick".equals(this.f6673a.getType())) {
            this.f6674b.f6672a.f6637c.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.f6673a.getType())) {
            this.f6674b.f6672a.f6635a.removeAllListeners();
            this.f6674b.f6672a.f6637c.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.f6673a.getType())) {
            this.f6674b.f6672a.f6635a.removeAllListeners();
            this.f6674b.f6672a.f6637c.onAdFailed(C1991m.m7449a().m7468q().getMessage(this.f6673a.getData()));
        }
    }
}
