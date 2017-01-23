package anet.channel;

import anet.channel.C0655b.C06491;
import anet.channel.entity.C0667d;
import anet.channel.entity.C0668b;
import anet.channel.entity.C0670e;
import anet.channel.entity.EventCb;
import anet.channel.entity.EventType;
import anet.channel.strategy.C0734n;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import org.android.spdy.SpdyProtocol;

/* renamed from: anet.channel.c */
final class C0661c implements EventCb {
    final /* synthetic */ long f2203a;

    C0661c(long j) {
        this.f2203a = j;
    }

    public void onEvent(Session session, EventType eventType, C0667d c0667d) {
        if (session != null && eventType != null) {
            C0670e c0670e = new C0670e(EventType.HORSE_RIDE);
            if (ALog.isPrintLog(1)) {
                ALog.m2960d("awcn.HorseRide", "horse ride evnet callback now !!!! ", session.mSeq, "ip", session.getIp(), "port", Integer.valueOf(session.getPort()), "conntype", session.getConnType(), "EventType", eventType, "Event", c0667d);
            }
            switch (C06491.f2181a[eventType.ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    c0670e.f2223a = true;
                    if (c0667d instanceof C0668b) {
                        c0670e.f2224b = ((C0668b) c0667d).f2220a;
                    } else {
                        c0670e.f2224b = System.currentTimeMillis() - this.f2203a;
                    }
                    C0655b.m2780c(session);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    C0655b.m2779b(c0670e, c0667d);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    C0655b.m2779b(c0670e, c0667d);
                    break;
                default:
                    return;
            }
            StrategyCenter.getInstance().notifyConnEvent(C0734n.m2957e(session.getHost()), session.getConnStrategy(), EventType.HORSE_RIDE, c0670e);
        }
    }
}
