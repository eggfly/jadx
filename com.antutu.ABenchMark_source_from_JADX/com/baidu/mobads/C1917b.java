package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.p080j.C1991m;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.b */
class C1917b implements Runnable {
    final /* synthetic */ IOAdEvent f6708a;
    final /* synthetic */ C1909a f6709b;

    C1917b(C1909a c1909a, IOAdEvent iOAdEvent) {
        this.f6709b = c1909a;
        this.f6708a = iOAdEvent;
    }

    public void run() {
        if (IXAdEvent.AD_LOADED.equals(this.f6708a.getType())) {
            this.f6709b.f6666a.f6616d.onAdReady(this.f6709b.f6666a);
        } else if (IXAdEvent.AD_STARTED.equals(this.f6708a.getType())) {
            this.f6709b.f6666a.f6616d.onAdSwitch();
            this.f6709b.f6666a.f6616d.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.f6708a.getType())) {
            this.f6709b.f6666a.f6616d.onAdFailed(C1991m.m7449a().m7468q().getMessage(this.f6708a.getData()));
        } else if ("AdUserClick".equals(this.f6708a.getType())) {
            this.f6709b.f6666a.f6616d.onAdClick(new JSONObject());
        }
    }
}
