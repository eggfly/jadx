package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p080j.C1991m;

/* renamed from: com.baidu.mobads.a */
class C1909a implements IOAdEventListener {
    final /* synthetic */ AdView f6666a;

    C1909a(AdView adView) {
        this.f6666a = adView;
    }

    public void run(IOAdEvent iOAdEvent) {
        if (this.f6666a.f6616d != null) {
            C1991m.m7449a().m7464m().m7420a(new C1917b(this, iOAdEvent));
        }
    }
}
