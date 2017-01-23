package anet.channel.strategy;

import anet.channel.entity.ConnType;
import anet.channel.strategy.C0731k.C0728a;

/* renamed from: anet.channel.strategy.b */
class C0710b implements Predicate<RawConnStrategy> {
    final /* synthetic */ C0728a f2343a;
    final /* synthetic */ ConnType f2344b;
    final /* synthetic */ IDCStrategyList f2345c;

    C0710b(IDCStrategyList iDCStrategyList, C0728a c0728a, ConnType connType) {
        this.f2345c = iDCStrategyList;
        this.f2343a = c0728a;
        this.f2344b = connType;
    }

    public boolean m2910a(RawConnStrategy rawConnStrategy) {
        return rawConnStrategy.port == this.f2343a.f2379a && rawConnStrategy.connType.equals(this.f2344b);
    }

    public /* synthetic */ boolean apply(Object obj) {
        return m2910a((RawConnStrategy) obj);
    }
}
