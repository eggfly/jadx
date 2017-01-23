package anet.channel;

import anet.channel.entity.C0667d;
import anet.channel.entity.EventCb;
import anet.channel.entity.EventType;
import anet.channel.strategy.C0734n;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import com.umeng.message.proguard.C4233j;

/* renamed from: anet.channel.g */
class C0672g implements EventCb {
    final /* synthetic */ Session f2228a;
    final /* synthetic */ SessionRequest f2229b;

    C0672g(SessionRequest sessionRequest, Session session) {
        this.f2229b = sessionRequest;
        this.f2228a = session;
    }

    public void onEvent(Session session, EventType eventType, C0667d c0667d) {
        ALog.m2960d("awcn.SessionRequest", "Receive session event", null, C4233j.f14402y, eventType);
        StrategyCenter.getInstance().notifyConnEvent(C0734n.m2957e(this.f2228a.getHost()), this.f2228a.getConnStrategy(), eventType, c0667d);
    }
}
