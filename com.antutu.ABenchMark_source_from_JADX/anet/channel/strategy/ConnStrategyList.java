package anet.channel.strategy;

import anet.channel.entity.C0667d;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventType;
import anet.channel.strategy.C0731k.C0728a;
import anet.channel.strategy.C0731k.C0729b;
import anet.channel.strategy.IPConnStrategy.C0706a;
import anet.channel.strategy.RawConnStrategy.C0708a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class ConnStrategyList {

    private static class CDNStrategyList extends ConnStrategyList implements Serializable {
        private List<IPConnStrategy> f2305a;

        public CDNStrategyList() {
            this.f2305a = new ArrayList();
        }

        public List<IConnStrategy> getStrategyList() {
            return new ArrayList(this.f2305a);
        }

        public boolean isUnavailable() {
            for (IPConnStrategy isAvailable : this.f2305a) {
                if (isAvailable.isAvailable()) {
                    return false;
                }
            }
            return true;
        }

        public void notifyConnEvent(IConnStrategy iConnStrategy, EventType eventType, C0667d c0667d) {
            if (this.f2305a.indexOf(iConnStrategy) != -1) {
                iConnStrategy.notifyEvent(eventType, c0667d);
                Collections.sort(this.f2305a);
            }
        }

        public void resetStatus() {
            for (IPConnStrategy resetConnStatus : this.f2305a) {
                resetConnStatus.resetConnStatus();
            }
        }

        public String toString() {
            return this.f2305a.toString();
        }

        public void update(C0729b c0729b) {
            for (IPConnStrategy iPConnStrategy : this.f2305a) {
                IPConnStrategy iPConnStrategy2;
                iPConnStrategy2.isToRemove = true;
            }
            for (String str : c0729b.f2393e) {
                for (C0728a c0728a : c0729b.f2394f) {
                    int a = ConnStrategyList.m2860a(this.f2305a, new C0709a(this, c0728a, ConnType.valueOf(c0728a), str));
                    if (a != -1) {
                        iPConnStrategy2 = (IPConnStrategy) this.f2305a.get(a);
                        iPConnStrategy2.isToRemove = false;
                        iPConnStrategy2.resetConnStatus();
                    } else {
                        iPConnStrategy2 = C0706a.m2867a(str, c0728a);
                        if (iPConnStrategy2 != null) {
                            this.f2305a.add(iPConnStrategy2);
                        }
                    }
                }
            }
            ListIterator listIterator = this.f2305a.listIterator();
            while (listIterator.hasNext()) {
                if (((IPConnStrategy) listIterator.next()).isToRemove) {
                    listIterator.remove();
                }
            }
        }
    }

    private static class IDCStrategyList extends ConnStrategyList implements Serializable {
        public volatile transient List<IConnStrategy> cache;
        public final List<String> ips;
        public final List<RawConnStrategy> strategies;

        public IDCStrategyList() {
            this.ips = new ArrayList();
            this.strategies = new ArrayList();
            this.cache = null;
        }

        public IDCStrategyList(String[] strArr, RawConnStrategy... rawConnStrategyArr) {
            this.ips = new ArrayList();
            this.strategies = new ArrayList();
            this.cache = null;
            this.ips.addAll(Arrays.asList(strArr));
            Collections.shuffle(this.ips);
            this.strategies.addAll(Arrays.asList(rawConnStrategyArr));
            m2861a();
        }

        private void m2861a() {
            if (this.cache == null) {
                this.cache = new ArrayList();
            } else {
                this.cache.clear();
            }
            for (String str : this.ips) {
                for (RawConnStrategy a : this.strategies) {
                    this.cache.add(C0706a.m2866a(str, a));
                }
            }
        }

        public List<IConnStrategy> getStrategyList() {
            if (this.cache == null) {
                synchronized (this) {
                    if (this.cache == null) {
                        m2861a();
                    }
                }
            }
            return new ArrayList(this.cache);
        }

        public boolean isUnavailable() {
            for (RawConnStrategy isAvailable : this.strategies) {
                if (isAvailable.isAvailable()) {
                    return false;
                }
            }
            return true;
        }

        public void notifyConnEvent(IConnStrategy iConnStrategy, EventType eventType, C0667d c0667d) {
            if (iConnStrategy instanceof IPConnStrategy) {
                Object obj;
                for (RawConnStrategy rawConnStrategy : this.strategies) {
                    if (((IPConnStrategy) iConnStrategy).rawConnStrategy == rawConnStrategy) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    iConnStrategy.notifyEvent(eventType, c0667d);
                    Collections.sort(this.strategies);
                }
            }
        }

        public void resetStatus() {
            for (RawConnStrategy resetConnStatus : this.strategies) {
                resetConnStatus.resetConnStatus();
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.ips).append(' ').append(this.strategies);
            return stringBuilder.toString();
        }

        public void update(C0729b c0729b) {
            RawConnStrategy rawConnStrategy;
            this.ips.clear();
            this.ips.addAll(Arrays.asList(c0729b.f2393e));
            for (RawConnStrategy rawConnStrategy2 : this.strategies) {
                rawConnStrategy2.isToRemove = true;
            }
            for (C0728a c0728a : c0729b.f2394f) {
                int a = ConnStrategyList.m2860a(this.strategies, new C0710b(this, c0728a, ConnType.valueOf(c0728a)));
                if (a != -1) {
                    rawConnStrategy2 = (RawConnStrategy) this.strategies.get(a);
                    rawConnStrategy2.isToRemove = false;
                    rawConnStrategy2.resetConnStatus();
                } else {
                    rawConnStrategy2 = C0708a.m2870a(c0728a);
                    if (rawConnStrategy2 != null) {
                        this.strategies.add(rawConnStrategy2);
                    }
                }
            }
            ListIterator listIterator = this.strategies.listIterator();
            while (listIterator.hasNext()) {
                if (((RawConnStrategy) listIterator.next()).isToRemove) {
                    listIterator.remove();
                }
            }
            m2861a();
        }
    }

    private interface Predicate<T> {
        boolean apply(T t);
    }

    static <T> int m2860a(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null) {
            return -1;
        }
        int i = 0;
        Iterator it = collection.iterator();
        while (it.hasNext() && !predicate.apply(it.next())) {
            i++;
        }
        if (i == collection.size()) {
            i = -1;
        }
        return i;
    }

    public static ConnStrategyList createForCDN() {
        return new CDNStrategyList();
    }

    public static ConnStrategyList createForIDC() {
        return new IDCStrategyList();
    }

    public static ConnStrategyList createForIDC(String[] strArr, RawConnStrategy... rawConnStrategyArr) {
        return new IDCStrategyList(strArr, rawConnStrategyArr);
    }

    public abstract List<IConnStrategy> getStrategyList();

    public abstract boolean isUnavailable();

    public abstract void notifyConnEvent(IConnStrategy iConnStrategy, EventType eventType, C0667d c0667d);

    public abstract void resetStatus();

    public abstract void update(C0729b c0729b);
}
