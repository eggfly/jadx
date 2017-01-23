package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainerContext;

/* renamed from: com.baidu.mobads.production.i */
class C2058i implements Runnable {
    final /* synthetic */ IXAdContainerContext f7166a;
    final /* synthetic */ C2028a f7167b;

    C2058i(C2028a c2028a, IXAdContainerContext iXAdContainerContext) {
        this.f7167b = c2028a;
        this.f7166a = iXAdContainerContext;
    }

    public void run() {
        this.f7167b.m7568a(this.f7166a);
    }
}
