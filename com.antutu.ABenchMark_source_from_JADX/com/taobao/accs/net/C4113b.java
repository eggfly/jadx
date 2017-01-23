package com.taobao.accs.net;

import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.monitor.SessionMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;

/* renamed from: com.taobao.accs.net.b */
class C4113b implements Runnable {
    final /* synthetic */ C4112a f13766a;

    C4113b(C4112a c4112a) {
        this.f13766a = c4112a;
    }

    public void run() {
        AppMonitor.getInstance().register(NetPerformanceMonitor.class);
        AppMonitor.getInstance().register(TrafficsMonitor.class);
        AppMonitor.getInstance().register(SessionMonitor.class);
    }
}
