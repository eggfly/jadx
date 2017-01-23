package org.android.agoo.control;

import com.taobao.accs.utl.ALog;
import org.android.agoo.control.AgooFactory.C4580a;

/* renamed from: org.android.agoo.control.f */
class C4587f implements Runnable {
    final /* synthetic */ C4580a f16427a;

    C4587f(C4580a c4580a) {
        this.f16427a = c4580a;
    }

    public void run() {
        try {
            ALog.m16901d("AgooFactory", "onConnected running tid:" + Thread.currentThread().getId(), new Object[0]);
            this.f16427a.f16408d.doSend(this.f16427a.f16406b);
            ALog.m16901d("AgooFactory", "send finish. close this connection", new Object[0]);
            this.f16427a.f16408d = null;
            AgooFactory.mContext.unbindService(this.f16427a.f16409e);
        } catch (Throwable e) {
            ALog.m16902e("AgooFactory", "send error", e, new Object[0]);
            ALog.m16901d("AgooFactory", "send finish. close this connection", new Object[0]);
            this.f16427a.f16408d = null;
            AgooFactory.mContext.unbindService(this.f16427a.f16409e);
        } catch (Throwable th) {
            ALog.m16901d("AgooFactory", "send finish. close this connection", new Object[0]);
            this.f16427a.f16408d = null;
            AgooFactory.mContext.unbindService(this.f16427a.f16409e);
        }
    }
}
