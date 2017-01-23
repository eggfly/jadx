package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.entity.C0667d;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.RawConnStrategy.C0708a;
import anet.channel.strategy.dispatch.C0714a;
import anet.channel.strategy.dispatch.C0717c;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.LruCache;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

class StrategyTable implements Serializable {
    protected String f2332a;
    protected volatile String f2333b;
    private volatile transient int f2334c;
    private HotHostLruCache f2335d;
    private transient Map<String, StrategyCollection> f2336e;
    private Set<String> f2337f;

    private static class HotHostLruCache extends LruCache<String, StrategyCollection> {
        public HotHostLruCache(int i) {
            super(i);
        }

        protected boolean m2895a(Entry<String, StrategyCollection> entry) {
            String str = (String) entry.getKey();
            if (!C0734n.m2950a().equals(str) && !C0714a.m2914a().equals(str)) {
                return true;
            }
            Iterator it = entrySet().iterator();
            while (it.hasNext()) {
                str = (String) ((Entry) it.next()).getKey();
                if (!C0734n.m2950a().equals(str) && !C0714a.m2914a().equals(str)) {
                    it.remove();
                    break;
                }
            }
            return false;
        }
    }

    protected StrategyTable(String str) {
        this.f2332a = str;
        m2901a();
    }

    private void m2896a(EventType eventType, String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f2337f) {
                if (eventType == EventType.AUTH_SUCC || eventType == EventType.CONNECTED) {
                    this.f2337f.add(str);
                } else if (eventType == EventType.AUTH_FAIL || eventType == EventType.CONNECT_FAIL) {
                    this.f2337f.remove(str);
                }
            }
        }
    }

    private Set<String> m2897b(Map<String, StrategyCollection> map) {
        Set<String> hashSet = new HashSet();
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = map == this.f2335d ? 1 : null;
        for (StrategyCollection strategyCollection : map.values()) {
            if (obj != null || currentTimeMillis >= strategyCollection.f2314c) {
                hashSet.add(strategyCollection.getHostWithEtag());
                strategyCollection.f2314c = 30000 + currentTimeMillis;
            }
        }
        return hashSet;
    }

    private void m2898b() {
        if (HttpDispatcher.getInstance().isInitHostsChanged(this.f2332a)) {
            for (String str : HttpDispatcher.getInstance().getInitHosts()) {
                Object strategyCollection;
                if (C0714a.m2914a().equalsIgnoreCase(str)) {
                    strategyCollection = new StrategyCollection(C0714a.m2914a(), ConnStrategyList.createForIDC(C0714a.m2916b(), C0708a.m2869a(80, ConnType.HTTP), C0708a.m2869a(Constants.PORT, ConnType.HTTP)));
                } else if (C0734n.m2950a().equalsIgnoreCase(str)) {
                    strategyCollection = new StrategyCollection(C0734n.m2950a(), ConnStrategyList.createForIDC(C0734n.m2954b(), C0708a.m2868a()));
                } else if (C0734n.f2417c.equalsIgnoreCase(str)) {
                    strategyCollection = new StrategyCollection(C0734n.f2417c, ConnStrategyList.createForIDC(C0734n.f2418d, C0708a.m2868a()));
                } else if (C0734n.f2419e.equalsIgnoreCase(str)) {
                    strategyCollection = new StrategyCollection(C0734n.f2419e, ConnStrategyList.createForIDC(C0734n.f2420f, C0708a.m2868a()));
                } else {
                    strategyCollection = new StrategyCollection(str);
                }
                this.f2335d.put(str, strategyCollection);
            }
        }
    }

    private void m2899c() {
        try {
            if (HttpDispatcher.getInstance().isInitHostsChanged(this.f2332a)) {
                int i;
                synchronized (this.f2335d) {
                    synchronized (this.f2336e) {
                        i = 0;
                        for (String str : HttpDispatcher.getInstance().getInitHosts()) {
                            int i2;
                            if (this.f2335d.containsKey(str) || this.f2336e.containsKey(str)) {
                                i2 = i;
                            } else {
                                this.f2336e.put(str, new StrategyCollection(str));
                                i2 = 1;
                            }
                            i = i2;
                        }
                    }
                }
                if (i != 0) {
                    m2903a(this.f2336e);
                }
            }
        } catch (Throwable e) {
            ALog.m2961e("awcn.StrategyTable", "checkInitHost failed", null, e, new Object[0]);
        }
    }

    private String m2900d() {
        StringBuilder stringBuilder = new StringBuilder();
        synchronized (this.f2337f) {
            for (String append : this.f2337f) {
                stringBuilder.append(append).append(";");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    protected void m2901a() {
        if (this.f2335d == null) {
            this.f2335d = new HotHostLruCache(32);
            m2898b();
        }
        if (this.f2336e == null) {
            this.f2336e = new LruCache(32);
        }
        if (this.f2337f == null) {
            this.f2337f = new TreeSet();
        }
        this.f2334c = GlobalAppRuntimeInfo.isTargetProcess() ? 0 : -1;
    }

    protected void m2902a(String str) {
        if (!GlobalAppRuntimeInfo.isAppBackground() && !TextUtils.isEmpty(str) && NetworkStatusHelper.m2846e()) {
            int amdcLimitLevel = GlobalAppRuntimeInfo.getAmdcLimitLevel();
            if (amdcLimitLevel != 3) {
                Set hashSet;
                if (amdcLimitLevel == 2) {
                    hashSet = new HashSet();
                    hashSet.add(str);
                } else {
                    StrategyCollection strategyCollection;
                    Set b;
                    synchronized (this.f2335d) {
                        strategyCollection = (StrategyCollection) this.f2335d.get(str);
                        if (strategyCollection != null) {
                            b = m2897b(this.f2335d);
                            b.add(strategyCollection.getHostWithEtag());
                        } else {
                            b = null;
                        }
                    }
                    if (strategyCollection == null) {
                        synchronized (this.f2336e) {
                            StrategyCollection strategyCollection2;
                            strategyCollection = (StrategyCollection) this.f2336e.get(str);
                            if (strategyCollection == null) {
                                strategyCollection = new StrategyCollection(str);
                                this.f2336e.put(str, strategyCollection);
                                strategyCollection2 = strategyCollection;
                            } else {
                                strategyCollection2 = strategyCollection;
                            }
                            hashSet = m2897b(this.f2336e);
                            hashSet.add(strategyCollection2.getHostWithEtag());
                        }
                    } else {
                        hashSet = b;
                    }
                }
                if (ALog.isPrintLog(2)) {
                    ALog.m2963i("awcn.StrategyTable", "sendAmdcRequest", null, "hosts:", hashSet.toString());
                }
                HttpDispatcher.getInstance().sendHttpDispatchRequest(hashSet, m2900d(), this.f2334c);
            }
        }
    }

    protected void m2903a(Map<String, StrategyCollection> map) {
        if (!GlobalAppRuntimeInfo.isAppBackground() && GlobalAppRuntimeInfo.getAmdcLimitLevel() <= 0 && NetworkStatusHelper.m2846e()) {
            Set b;
            synchronized (map) {
                b = m2897b(map);
            }
            if (ALog.isPrintLog(2)) {
                ALog.m2963i("awcn.StrategyTable", "sendAmdcRequest", null, "hosts:", b.toString());
            }
            if (!b.isEmpty()) {
                HttpDispatcher.getInstance().sendHttpDispatchRequest(b, m2900d(), this.f2334c);
            }
        }
    }

    public void fillLastHorseRideTime(Map<String, HorseRideStrategy> map) {
        if (map != null && !map.isEmpty()) {
            synchronized (this.f2335d) {
                synchronized (this.f2336e) {
                    for (Entry entry : map.entrySet()) {
                        StrategyCollection strategyCollection = (StrategyCollection) this.f2335d.get(entry.getKey());
                        if (strategyCollection == null) {
                            strategyCollection = (StrategyCollection) this.f2336e.get(entry.getKey());
                        }
                        if (strategyCollection != null) {
                            ((HorseRideStrategy) entry.getValue()).lastHorseRideTime = strategyCollection.f2317f;
                        }
                    }
                }
            }
        }
    }

    public void notifyConnEvent(String str, IConnStrategy iConnStrategy, EventType eventType, C0667d c0667d) {
        if (ALog.isPrintLog(1)) {
            ALog.m2960d("awcn.StrategyTable", "[notifyConnEvent]", null, HttpConstant.HOST, str, "IConnStrategy", iConnStrategy, "eventType", eventType);
        }
        C0717c.m2928a(this.f2332a, this.f2333b, str, iConnStrategy, eventType, c0667d);
        m2896a(eventType, iConnStrategy.getIp());
        synchronized (this.f2335d) {
            synchronized (this.f2336e) {
                StrategyCollection strategyCollection = (StrategyCollection) this.f2335d.get(str);
                if (strategyCollection == null) {
                    strategyCollection = (StrategyCollection) this.f2336e.get(str);
                }
            }
        }
        if (strategyCollection != null) {
            strategyCollection.notifyConnEvent(iConnStrategy, eventType, c0667d);
        }
    }

    public List<IConnStrategy> queryByHost(String str) {
        if (TextUtils.isEmpty(str) || !C0734n.m2958f(str)) {
            return Collections.EMPTY_LIST;
        }
        StrategyCollection strategyCollection;
        m2899c();
        synchronized (this.f2335d) {
            strategyCollection = (StrategyCollection) this.f2335d.get(str);
        }
        if (strategyCollection == null) {
            Object obj = null;
            synchronized (this.f2336e) {
                strategyCollection = (StrategyCollection) this.f2336e.get(str);
                if (strategyCollection == null) {
                    StrategyCollection strategyCollection2 = new StrategyCollection(str);
                    this.f2336e.put(str, strategyCollection2);
                    strategyCollection = strategyCollection2;
                    obj = 1;
                }
            }
            if (obj != null) {
                m2902a(str);
            }
        } else if (strategyCollection.isExpired()) {
            m2903a(this.f2335d);
        }
        return strategyCollection.queryStrategyList();
    }

    public String querySchemeByHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StrategyCollection strategyCollection;
        synchronized (this.f2335d) {
            strategyCollection = (StrategyCollection) this.f2335d.get(str);
        }
        if (strategyCollection == null) {
            synchronized (this.f2336e) {
                strategyCollection = (StrategyCollection) this.f2336e.get(str);
            }
        }
        return strategyCollection != null ? strategyCollection.f2315d : null;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("\nuniqueId : ").append(this.f2332a).append("\n");
        append.append("--------hot domains:------------------------------------");
        synchronized (this.f2335d) {
            for (Entry entry : this.f2335d.entrySet()) {
                append.append("\n").append((String) entry.getKey()).append(" = ").append(((StrategyCollection) entry.getValue()).toString());
            }
        }
        append.append("\n--------cold domains:------------------------------------");
        synchronized (this.f2336e) {
            for (Entry entry2 : this.f2336e.entrySet()) {
                append.append("\n").append((String) entry2.getKey()).append(" = ").append(((StrategyCollection) entry2.getValue()).toString());
            }
        }
        return append.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(anet.channel.strategy.C0731k.C0730c r14) {
        /*
        r13 = this;
        r12 = 0;
        r11 = 1;
        r3 = 0;
        r0 = "awcn.StrategyTable";
        r1 = "update strategyTable with httpDns response";
        r2 = new java.lang.Object[r3];
        anet.channel.util.ALog.m2963i(r0, r1, r12, r2);
        r0 = r14.f2406a;	 Catch:{ Throwable -> 0x004b }
        r13.f2333b = r0;	 Catch:{ Throwable -> 0x004b }
        r0 = r14.f2411f;	 Catch:{ Throwable -> 0x004b }
        r13.f2334c = r0;	 Catch:{ Throwable -> 0x004b }
        r4 = r14.f2408c;	 Catch:{ Throwable -> 0x004b }
        if (r4 != 0) goto L_0x0019;
    L_0x0018:
        return;
    L_0x0019:
        r5 = r13.f2335d;	 Catch:{ Throwable -> 0x004b }
        monitor-enter(r5);	 Catch:{ Throwable -> 0x004b }
        r6 = r13.f2336e;	 Catch:{ all -> 0x0048 }
        monitor-enter(r6);	 Catch:{ all -> 0x0048 }
        r2 = r3;
    L_0x0020:
        r0 = r4.length;	 Catch:{ all -> 0x0045 }
        if (r2 >= r0) goto L_0x00c0;
    L_0x0023:
        r7 = r4[r2];	 Catch:{ all -> 0x0045 }
        if (r7 == 0) goto L_0x002b;
    L_0x0027:
        r0 = r7.f2389a;	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x002f;
    L_0x002b:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0020;
    L_0x002f:
        r0 = r7.f2401m;	 Catch:{ all -> 0x0045 }
        if (r0 == 0) goto L_0x0067;
    L_0x0033:
        r0 = r13.f2335d;	 Catch:{ all -> 0x0045 }
        r1 = r7.f2389a;	 Catch:{ all -> 0x0045 }
        r0 = r0.remove(r1);	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x002b;
    L_0x003d:
        r0 = r13.f2336e;	 Catch:{ all -> 0x0045 }
        r1 = r7.f2389a;	 Catch:{ all -> 0x0045 }
        r0.remove(r1);	 Catch:{ all -> 0x0045 }
        goto L_0x002b;
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0048 }
        throw r0;	 Catch:{ all -> 0x0048 }
    L_0x0048:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ Throwable -> 0x004b }
        throw r0;	 Catch:{ Throwable -> 0x004b }
    L_0x004b:
        r0 = move-exception;
        r1 = "awcn.StrategyTable";
        r2 = "fail to update strategyTable";
        r4 = new java.lang.Object[r3];
        anet.channel.util.ALog.m2961e(r1, r2, r12, r0, r4);
    L_0x0055:
        r0 = anet.channel.util.ALog.isPrintLog(r11);
        if (r0 == 0) goto L_0x0018;
    L_0x005b:
        r0 = "awcn.StrategyTable";
        r1 = r13.toString();
        r2 = new java.lang.Object[r3];
        anet.channel.util.ALog.m2960d(r0, r1, r12, r2);
        goto L_0x0018;
    L_0x0067:
        r0 = r13.f2335d;	 Catch:{ all -> 0x0045 }
        r1 = r7.f2389a;	 Catch:{ all -> 0x0045 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0045 }
        r0 = (anet.channel.strategy.StrategyCollection) r0;	 Catch:{ all -> 0x0045 }
        if (r0 == 0) goto L_0x008a;
    L_0x0073:
        r1 = r7.f2404p;	 Catch:{ all -> 0x0045 }
        if (r1 != 0) goto L_0x0086;
    L_0x0077:
        r1 = r13.f2336e;	 Catch:{ all -> 0x0045 }
        r8 = r7.f2389a;	 Catch:{ all -> 0x0045 }
        r9 = r13.f2335d;	 Catch:{ all -> 0x0045 }
        r10 = r7.f2389a;	 Catch:{ all -> 0x0045 }
        r9 = r9.remove(r10);	 Catch:{ all -> 0x0045 }
        r1.put(r8, r9);	 Catch:{ all -> 0x0045 }
    L_0x0086:
        r0.update(r7);	 Catch:{ all -> 0x0045 }
        goto L_0x002b;
    L_0x008a:
        r0 = r13.f2336e;	 Catch:{ all -> 0x0045 }
        r1 = r7.f2389a;	 Catch:{ all -> 0x0045 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0045 }
        r0 = (anet.channel.strategy.StrategyCollection) r0;	 Catch:{ all -> 0x0045 }
        if (r0 == 0) goto L_0x00aa;
    L_0x0096:
        r1 = r7.f2404p;	 Catch:{ all -> 0x0045 }
        if (r1 != r11) goto L_0x0086;
    L_0x009a:
        r1 = r13.f2335d;	 Catch:{ all -> 0x0045 }
        r8 = r7.f2389a;	 Catch:{ all -> 0x0045 }
        r9 = r13.f2336e;	 Catch:{ all -> 0x0045 }
        r10 = r7.f2389a;	 Catch:{ all -> 0x0045 }
        r9 = r9.remove(r10);	 Catch:{ all -> 0x0045 }
        r1.put(r8, r9);	 Catch:{ all -> 0x0045 }
        goto L_0x0086;
    L_0x00aa:
        r0 = new anet.channel.strategy.StrategyCollection;	 Catch:{ all -> 0x0045 }
        r1 = r7.f2389a;	 Catch:{ all -> 0x0045 }
        r0.<init>(r1);	 Catch:{ all -> 0x0045 }
        r1 = r7.f2404p;	 Catch:{ all -> 0x0045 }
        if (r1 != r11) goto L_0x00bd;
    L_0x00b5:
        r1 = r13.f2335d;	 Catch:{ all -> 0x0045 }
    L_0x00b7:
        r8 = r7.f2389a;	 Catch:{ all -> 0x0045 }
        r1.put(r8, r0);	 Catch:{ all -> 0x0045 }
        goto L_0x0086;
    L_0x00bd:
        r1 = r13.f2336e;	 Catch:{ all -> 0x0045 }
        goto L_0x00b7;
    L_0x00c0:
        monitor-exit(r6);	 Catch:{ all -> 0x0045 }
        monitor-exit(r5);	 Catch:{ all -> 0x0048 }
        goto L_0x0055;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.StrategyTable.update(anet.channel.strategy.k$c):void");
    }
}
