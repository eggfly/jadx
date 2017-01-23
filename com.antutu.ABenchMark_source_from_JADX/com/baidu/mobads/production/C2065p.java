package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.p */
class C2065p implements Runnable {
    final /* synthetic */ IXAdContainer f7196a;
    final /* synthetic */ HashMap f7197b;
    final /* synthetic */ C2061l f7198c;

    C2065p(C2061l c2061l, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.f7198c = c2061l;
        this.f7196a = iXAdContainer;
        this.f7197b = hashMap;
    }

    public void run() {
        this.f7195c.f7171b.m7578b(this.f7196a, this.f7197b);
    }
}
