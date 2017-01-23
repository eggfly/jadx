package anet.channel;

import anet.channel.entity.C0667d;
import anet.channel.entity.EventCb;
import anet.channel.entity.EventType;
import anet.channel.util.ALog;

/* renamed from: anet.channel.d */
class C0662d implements Runnable {
    final /* synthetic */ EventType f2204a;
    final /* synthetic */ C0667d f2205b;
    final /* synthetic */ Session f2206c;

    C0662d(Session session, EventType eventType, C0667d c0667d) {
        this.f2206c = session;
        this.f2204a = eventType;
        this.f2205b = c0667d;
    }

    public void run() {
        try {
            if (this.f2206c.mEventCallBacks != null && this.f2204a != null) {
                for (EventCb eventCb : this.f2206c.mEventCallBacks.keySet()) {
                    if (!(eventCb == null || (((Integer) this.f2206c.mEventCallBacks.get(eventCb)).intValue() & this.f2204a.getType()) == 0)) {
                        try {
                            eventCb.onEvent(this.f2206c, this.f2204a, this.f2205b);
                        } catch (Exception e) {
                            ALog.m2962e("awcn.Session", e.toString(), this.f2206c.mSeq, new Object[0]);
                        }
                    }
                }
            }
        } catch (Throwable e2) {
            ALog.m2961e("awcn.Session", "handleCallbacks", this.f2206c.mSeq, e2, new Object[0]);
        }
    }
}
