package anet.channel.session;

import anet.channel.Session.Status;
import anet.channel.entity.EventType;
import anet.channel.util.ALog;

/* renamed from: anet.channel.session.j */
class C0697j implements Runnable {
    final /* synthetic */ C0696i f2282a;

    C0697j(C0696i c0696i) {
        this.f2282a = c0696i;
    }

    public void run() {
        if (this.f2282a.mHasUnrevPing) {
            if (ALog.isPrintLog(1)) {
                ALog.m2962e(C0696i.f2281a, "getRecvTimeOutRunnable", this.f2282a.mSeq, "send msg time out! pingUnRcv:" + this.f2282a.mHasUnrevPing);
            }
            try {
                if (this.f2282a.mStatus == Status.CONNECTED) {
                    this.f2282a.notifyStatus(Status.AUTH_FAIL, null);
                } else {
                    this.f2282a.handleCallbacks(EventType.DATA_TIMEOUT, null);
                }
                if (this.f2282a.mSessionStat != null) {
                    this.f2282a.mSessionStat.closeReason = "ping time out";
                }
                this.f2282a.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
