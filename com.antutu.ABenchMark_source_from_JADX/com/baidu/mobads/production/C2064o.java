package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.o */
class C2064o implements Runnable {
    final /* synthetic */ IXAdContainer f7193a;
    final /* synthetic */ HashMap f7194b;
    final /* synthetic */ C2061l f7195c;

    C2064o(C2061l c2061l, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.f7195c = c2061l;
        this.f7193a = iXAdContainer;
        this.f7194b = hashMap;
    }

    public void run() {
        this.f7195c.f7171b.m7567a(this.f7193a, this.f7194b);
    }
}
