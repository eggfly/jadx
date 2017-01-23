package anet.channel.strategy;

import anet.channel.entity.ConnType;
import anet.channel.strategy.C0731k.C0728a;

/* renamed from: anet.channel.strategy.a */
class C0709a implements Predicate<IPConnStrategy> {
    final /* synthetic */ C0728a f2339a;
    final /* synthetic */ ConnType f2340b;
    final /* synthetic */ String f2341c;
    final /* synthetic */ CDNStrategyList f2342d;

    C0709a(CDNStrategyList cDNStrategyList, C0728a c0728a, ConnType connType, String str) {
        this.f2342d = cDNStrategyList;
        this.f2339a = c0728a;
        this.f2340b = connType;
        this.f2341c = str;
    }

    public boolean m2909a(IPConnStrategy iPConnStrategy) {
        return iPConnStrategy.getPort() == this.f2339a.f2379a && iPConnStrategy.getConnType().equals(this.f2340b) && iPConnStrategy.getIp().equals(this.f2341c);
    }

    public /* synthetic */ boolean apply(Object obj) {
        return m2909a((IPConnStrategy) obj);
    }
}
