package anet.channel;

import anet.channel.C0665e.C0664a;
import anet.channel.SessionRequest.C06411;
import anet.channel.entity.C0667d;
import anet.channel.entity.EventCb;
import anet.channel.entity.EventType;
import anet.channel.util.ALog;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.spdy.SpdyProtocol;

/* renamed from: anet.channel.f */
class C0671f implements EventCb {
    final /* synthetic */ IConnCb f2225a;
    final /* synthetic */ long f2226b;
    final /* synthetic */ SessionRequest f2227c;

    C0671f(SessionRequest sessionRequest, IConnCb iConnCb, long j) {
        this.f2227c = sessionRequest;
        this.f2225a = iConnCb;
        this.f2226b = j;
    }

    public void onEvent(Session session, EventType eventType, C0667d c0667d) {
        if (session != null && eventType != null) {
            int i = c0667d == null ? 0 : c0667d.f2218d;
            String str = c0667d == null ? BuildConfig.FLAVOR : c0667d.f2219e;
            switch (C06411.f2157a[eventType.ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    ALog.m2960d("awcn.SessionRequest", null, session != null ? session.mSeq : null, "Session", session, "EventType", eventType, "Event", c0667d);
                    this.f2227c.m2749a(session.getHost(), true, 0, null);
                    this.f2225a.onSuccess(session, this.f2226b);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    ALog.m2960d("awcn.SessionRequest", null, session != null ? session.mSeq : null, "Session", session, "EventType", eventType, "Event", c0667d);
                    this.f2227c.m2749a(session.getHost(), false, i, str);
                    if (C0664a.f2207a.m2796c(this.f2227c, session)) {
                        this.f2225a.onDisConnect(session, this.f2226b, eventType);
                    } else {
                        this.f2225a.onFailed(session, this.f2226b, eventType, i);
                    }
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    ALog.m2960d("awcn.SessionRequest", null, session != null ? session.mSeq : null, "Session", session, "EventType", eventType, "Event", c0667d);
                    this.f2227c.m2749a(session.getHost(), false, i, str);
                    this.f2225a.onFailed(session, this.f2226b, eventType, i);
                default:
            }
        }
    }
}
