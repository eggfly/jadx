package com.baidu.mobads.production.p102e;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.p091f.C1933a;

/* renamed from: com.baidu.mobads.production.e.b */
class C2049b implements Runnable {
    final /* synthetic */ C2048a f7156a;

    C2049b(C2048a c2048a) {
        this.f7156a = c2048a;
    }

    public void run() {
        this.f7156a.dispatchEvent(new C1933a(IXAdEvent.AD_LOADED));
    }
}
