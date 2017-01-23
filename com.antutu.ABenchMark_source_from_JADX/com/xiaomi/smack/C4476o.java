package com.xiaomi.smack;

import com.xiaomi.network.HostManager;

/* renamed from: com.xiaomi.smack.o */
class C4476o implements Runnable {
    final /* synthetic */ String f15368a;
    final /* synthetic */ C4473l f15369b;

    C4476o(C4473l c4473l, String str) {
        this.f15369b = c4473l;
        this.f15368a = str;
    }

    public void run() {
        HostManager.getInstance().getFallbacksByHost(this.f15368a, true);
    }
}
