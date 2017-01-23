package com.baidu.mobads.production.p102e;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.p091f.C1933a;

/* renamed from: com.baidu.mobads.production.e.c */
class C2050c implements Runnable {
    final /* synthetic */ C2048a f7157a;

    C2050c(C2048a c2048a) {
        this.f7157a = c2048a;
    }

    public void run() {
        this.f7157a.dispatchEvent(new C1933a(IXAdEvent.AD_STOPPED));
    }
}
