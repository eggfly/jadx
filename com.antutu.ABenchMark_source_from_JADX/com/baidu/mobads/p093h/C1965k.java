package com.baidu.mobads.p093h;

/* renamed from: com.baidu.mobads.h.k */
class C1965k implements Runnable {
    final /* synthetic */ boolean f6846a;
    final /* synthetic */ C1960g f6847b;

    C1965k(C1960g c1960g, boolean z) {
        this.f6847b = c1960g;
        this.f6846a = z;
    }

    public void run() {
        new Thread(new C1966l(this)).start();
    }
}
