package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.entity.C0667d;
import anet.channel.entity.EventType;
import anet.channel.p018b.C0653b;
import anet.channel.strategy.C0731k.C0729b;
import anet.channel.strategy.RawConnStrategy.C0708a;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import com.taobao.accs.internal.C4103b;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

class StrategyCollection implements Serializable {
    String f2312a;
    ConnStrategyList f2313b;
    volatile long f2314c;
    volatile String f2315d;
    volatile String f2316e;
    volatile long f2317f;

    public StrategyCollection() {
        this.f2313b = null;
        this.f2314c = 0;
        this.f2315d = null;
        this.f2316e = null;
        this.f2317f = 0;
    }

    protected StrategyCollection(String str) {
        this.f2313b = null;
        this.f2314c = 0;
        this.f2315d = null;
        this.f2316e = null;
        this.f2317f = 0;
        this.f2312a = str;
    }

    protected StrategyCollection(String str, ConnStrategyList connStrategyList) {
        this.f2313b = null;
        this.f2314c = 0;
        this.f2315d = null;
        this.f2316e = null;
        this.f2317f = 0;
        this.f2312a = str;
        this.f2313b = connStrategyList;
    }

    public String getHostWithEtag() {
        if (TextUtils.isEmpty(this.f2316e)) {
            return this.f2312a;
        }
        return StringUtils.buildString(this.f2312a, ":", this.f2316e);
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.f2314c;
    }

    public synchronized void notifyConnEvent(IConnStrategy iConnStrategy, EventType eventType, C0667d c0667d) {
        if (eventType == EventType.HORSE_RIDE) {
            this.f2317f = System.currentTimeMillis();
        }
        if (this.f2313b != null) {
            this.f2313b.notifyConnEvent(iConnStrategy, eventType, c0667d);
            if ((eventType == EventType.CONNECT_FAIL || eventType == EventType.AUTH_FAIL) && this.f2313b.isUnavailable()) {
                C0653b.m2767a().m2769a(1, this.f2312a);
            }
        }
    }

    public synchronized List<IConnStrategy> queryStrategyList() {
        return this.f2313b == null ? Collections.EMPTY_LIST : this.f2313b.getStrategyList();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("\nStrategyList = ").append(this.f2314c);
        if (this.f2313b == null) {
            stringBuilder.append("[]");
        } else {
            stringBuilder.append(this.f2313b.toString());
        }
        return stringBuilder.toString();
    }

    public synchronized void update(C0729b c0729b) {
        this.f2314c = System.currentTimeMillis() + (((long) c0729b.f2390b) * 1000);
        if (!c0729b.f2389a.equalsIgnoreCase(this.f2312a)) {
            ALog.m2962e("StrategyCollection", "update error!", null, C4103b.ELECTION_KEY_HOST, this.f2312a, "dnsInfo.host", c0729b.f2389a);
        } else if (c0729b.f2403o) {
            if (this.f2313b != null) {
                this.f2313b.resetStatus();
            }
        } else if (TextUtils.isEmpty(c0729b.f2392d)) {
            this.f2316e = c0729b.f2402n;
            if (HttpConstant.HTTP.equalsIgnoreCase(c0729b.f2391c) || HttpConstant.HTTPS.equalsIgnoreCase(c0729b.f2391c)) {
                this.f2315d = c0729b.f2391c;
            }
            if (c0729b.f2393e == null || c0729b.f2393e.length == 0 || c0729b.f2394f == null || c0729b.f2394f.length == 0) {
                this.f2313b = null;
                if (C0734n.m2952a(this.f2312a)) {
                    this.f2313b = ConnStrategyList.createForIDC(C0734n.m2954b(), C0708a.m2868a());
                }
            } else {
                if (this.f2313b == null) {
                    this.f2313b = C0734n.m2956d(c0729b.f2389a) ? ConnStrategyList.createForIDC() : ConnStrategyList.createForCDN();
                }
                this.f2313b.update(c0729b);
            }
        }
    }
}
