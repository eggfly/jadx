package anet.channel.strategy;

import anet.channel.entity.ConnType;
import java.util.Comparator;

/* renamed from: anet.channel.strategy.e */
final class C0722e implements Comparator<RawConnStrategy> {
    C0722e() {
    }

    public int m2934a(RawConnStrategy rawConnStrategy, RawConnStrategy rawConnStrategy2) {
        if (rawConnStrategy.f2309b != rawConnStrategy2.f2309b) {
            return rawConnStrategy.f2309b - rawConnStrategy2.f2309b;
        }
        int compare = ConnType.compare(rawConnStrategy.connType, rawConnStrategy2.connType);
        return compare == 0 ? (int) (rawConnStrategy.f2310c - rawConnStrategy2.f2310c) : compare;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2934a((RawConnStrategy) obj, (RawConnStrategy) obj2);
    }
}
