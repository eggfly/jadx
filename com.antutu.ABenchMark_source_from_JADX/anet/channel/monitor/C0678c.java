package anet.channel.monitor;

import anet.channel.util.ALog;
import java.util.Iterator;

/* renamed from: anet.channel.monitor.c */
class C0678c implements Runnable {
    final /* synthetic */ C0676a f2251a;

    C0678c(C0676a c0676a) {
        this.f2251a = c0676a;
    }

    public void run() {
        Iterator it = this.f2251a.f2248n.iterator();
        while (it.hasNext()) {
            INetworkQualityChangeListener iNetworkQualityChangeListener = (INetworkQualityChangeListener) it.next();
            long currentTimeMillis = System.currentTimeMillis();
            iNetworkQualityChangeListener.onNetworkQualityChanged(NetworkSpeed.valueOfCode(this.f2251a.f2246l));
            if (System.currentTimeMillis() - currentTimeMillis > 500) {
                ALog.m2961e("awcn.BandWidthSampler", "call back cost too much time", null, new Throwable().fillInStackTrace(), new Object[0]);
            }
        }
    }
}
