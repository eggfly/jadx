package anet.channel.strategy;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class HorseRideStrategyMap implements Serializable {
    private Map<String, HorseRideStrategy> f2306a;

    HorseRideStrategyMap() {
        m2864a();
    }

    Map<String, IHRStrategy> m2863a(StrategyTable strategyTable) {
        Map<String, IHRStrategy> map;
        synchronized (this.f2306a) {
            if (this.f2306a.isEmpty()) {
                map = Collections.EMPTY_MAP;
            } else {
                strategyTable.fillLastHorseRideTime(this.f2306a);
                map = new HashMap(this.f2306a);
            }
        }
        return map;
    }

    void m2864a() {
        if (this.f2306a == null) {
            this.f2306a = new HashMap();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m2865a(anet.channel.strategy.C0731k.C0730c r10) {
        /*
        r9 = this;
        r0 = r10.f2408c;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r7 = r9.f2306a;
        monitor-enter(r7);
        r0 = 0;
        r6 = r0;
    L_0x000a:
        r0 = r10.f2408c;	 Catch:{ all -> 0x0045 }
        r0 = r0.length;	 Catch:{ all -> 0x0045 }
        if (r6 >= r0) goto L_0x0050;
    L_0x000f:
        r0 = r10.f2408c;	 Catch:{ all -> 0x0045 }
        r8 = r0[r6];	 Catch:{ all -> 0x0045 }
        r0 = r8.f2401m;	 Catch:{ all -> 0x0045 }
        if (r0 == 0) goto L_0x0022;
    L_0x0017:
        r0 = r9.f2306a;	 Catch:{ all -> 0x0045 }
        r1 = r8.f2389a;	 Catch:{ all -> 0x0045 }
        r0.remove(r1);	 Catch:{ all -> 0x0045 }
    L_0x001e:
        r0 = r6 + 1;
        r6 = r0;
        goto L_0x000a;
    L_0x0022:
        r0 = r8.f2403o;	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x001e;
    L_0x0026:
        r0 = r8.f2395g;	 Catch:{ all -> 0x0045 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x0048;
    L_0x002e:
        r0 = r8.f2395g;	 Catch:{ all -> 0x0045 }
        r1 = r8.f2397i;	 Catch:{ all -> 0x0045 }
        r2 = r8.f2396h;	 Catch:{ all -> 0x0045 }
        r2 = (long) r2;	 Catch:{ all -> 0x0045 }
        r4 = r8.f2399k;	 Catch:{ all -> 0x0045 }
        r5 = r8.f2398j;	 Catch:{ all -> 0x0045 }
        r0 = anet.channel.strategy.HorseRideStrategy.C0704a.m2862a(r0, r1, r2, r4, r5);	 Catch:{ all -> 0x0045 }
        r1 = r9.f2306a;	 Catch:{ all -> 0x0045 }
        r2 = r8.f2389a;	 Catch:{ all -> 0x0045 }
        r1.put(r2, r0);	 Catch:{ all -> 0x0045 }
        goto L_0x001e;
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x0048:
        r0 = r9.f2306a;	 Catch:{ all -> 0x0045 }
        r1 = r8.f2389a;	 Catch:{ all -> 0x0045 }
        r0.remove(r1);	 Catch:{ all -> 0x0045 }
        goto L_0x001e;
    L_0x0050:
        monitor-exit(r7);	 Catch:{ all -> 0x0045 }
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.HorseRideStrategyMap.a(anet.channel.strategy.k$c):void");
    }
}
