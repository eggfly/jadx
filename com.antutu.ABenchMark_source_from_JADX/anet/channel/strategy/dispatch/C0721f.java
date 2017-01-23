package anet.channel.strategy.dispatch;

import anet.channel.p019c.C0660c;
import anet.channel.strategy.dispatch.C0720e.C0719a;
import java.util.Map;

/* renamed from: anet.channel.strategy.dispatch.f */
class C0721f implements Runnable {
    final /* synthetic */ C0720e f2368a;

    C0721f(C0720e c0720e) {
        this.f2368a = c0720e;
    }

    public void run() {
        synchronized (this.f2368a) {
            Map map = this.f2368a.f2367a;
            this.f2368a.f2367a = null;
            C0660c.m2784a(new C0719a(map), 0);
        }
    }
}
