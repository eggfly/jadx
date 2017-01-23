package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.entity.C0667d;
import anet.channel.entity.EventType;
import anet.channel.p017a.C0644a;
import anet.channel.statist.RequestStatistic;
import java.util.List;
import java.util.Map;

/* renamed from: anet.channel.session.h */
class C0695h implements RequestCb {
    final /* synthetic */ C0694g f2280a;

    C0695h(C0694g c0694g) {
        this.f2280a = c0694g;
    }

    public void onDataReceive(C0644a c0644a, boolean z) {
        this.f2280a.f2278b.onDataReceive(c0644a, z);
    }

    public void onFinish(int i, String str, RequestStatistic requestStatistic) {
        this.f2280a.f2278b.onFinish(i, str, requestStatistic);
    }

    public void onResponseCode(int i, Map<String, List<String>> map) {
        if (i <= 0) {
            this.f2280a.f2279c.handleCallbacks(EventType.DISCONNECTED, new C0667d(EventType.DISCONNECTED, 0, "Http connect fail"));
        }
        this.f2280a.f2278b.onResponseCode(i, map);
    }
}
