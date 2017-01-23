package anet.channel.session;

import anet.channel.entity.EventType;
import anet.channel.util.ALog;

/* renamed from: anet.channel.session.a */
class C0688a implements Runnable {
    final /* synthetic */ AccsSession f2269a;

    C0688a(AccsSession accsSession) {
        this.f2269a = accsSession;
    }

    public void run() {
        if (this.f2269a.mHasUnrevPing) {
            ALog.m2962e("awcn.AccsSession", "send msg time out!", this.f2269a.mSeq, "pingUnRcv:", Boolean.valueOf(this.f2269a.mHasUnrevPing));
            try {
                this.f2269a.handleCallbacks(EventType.DATA_TIMEOUT, null);
                if (this.f2269a.mSessionStat != null) {
                    this.f2269a.mSessionStat.closeReason = "ping time out";
                }
                this.f2269a.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
