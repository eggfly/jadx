package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.C0665e.C0664a;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.p019c.C0660c;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;
import anet.channel.strategy.C0731k.C0728a;
import anet.channel.strategy.C0731k.C0729b;
import anet.channel.strategy.C0731k.C0730c;
import anet.channel.util.ALog;
import anet.channel.util.LruCache;
import anet.channel.util.StringUtils;
import com.taobao.accs.internal.C4103b;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class StrategyInfoHolder implements INetworkStatusChangeListener {
    Map<String, StrategyTable> f2322a;
    UnitMap f2323b;
    SafeAislesMap f2324c;
    HorseRideStrategyMap f2325d;
    final C0711c f2326e;
    final ConcurrentHashMap<String, String> f2327f;
    private final StrategyTable f2328g;
    private final Object f2329h;
    private final Set<String> f2330i;
    private volatile String f2331j;

    private static class ConfigInfoWrapper implements Serializable {
        UnitMap f2318a;
        SafeAislesMap f2319b;
        HorseRideStrategyMap f2320c;

        ConfigInfoWrapper(StrategyInfoHolder strategyInfoHolder) {
            this.f2318a = null;
            this.f2319b = null;
            this.f2320c = null;
            this.f2318a = strategyInfoHolder.f2323b;
            this.f2319b = strategyInfoHolder.f2324c;
            this.f2320c = strategyInfoHolder.f2325d;
        }

        void m2878a(StrategyInfoHolder strategyInfoHolder) {
            strategyInfoHolder.f2323b = this.f2318a;
            strategyInfoHolder.f2324c = this.f2319b;
            strategyInfoHolder.f2325d = this.f2320c;
        }
    }

    private static class LURStrategyMap extends LruCache<String, StrategyTable> {
        public LURStrategyMap() {
            super(3);
        }

        protected boolean m2880a(Entry<String, StrategyTable> entry) {
            new C0725h(this, entry).execute(new Void[0]);
            return true;
        }
    }

    private StrategyInfoHolder() {
        this.f2322a = new LURStrategyMap();
        this.f2323b = null;
        this.f2324c = null;
        this.f2325d = null;
        this.f2326e = new C0711c();
        this.f2327f = new ConcurrentHashMap();
        this.f2328g = new StrategyTable("Unknown");
        this.f2329h = new Object();
        this.f2330i = new HashSet();
        this.f2331j = BuildConfig.FLAVOR;
        try {
            m2889d();
            m2891f();
        } catch (Exception e) {
        } finally {
            m2890e();
        }
    }

    public static StrategyInfoHolder m2881a() {
        return new StrategyInfoHolder();
    }

    private String m2882a(NetworkStatus networkStatus) {
        String str = BuildConfig.FLAVOR;
        if (!networkStatus.isWifi()) {
            return networkStatus.isMobile() ? networkStatus.getType() : str;
        } else {
            if (TextUtils.isEmpty(NetworkStatusHelper.m2845d())) {
                return str;
            }
            return StringUtils.buildString(networkStatus.getType(), "$", NetworkStatusHelper.m2845d());
        }
    }

    private void m2885a(String str, String str2) {
        synchronized (this.f2330i) {
            boolean contains = this.f2330i.contains(str);
            if (!contains) {
                this.f2330i.add(str);
            }
        }
        if (!contains) {
            StrategyTable strategyTable = (StrategyTable) C0732l.m2945b(str);
            if (strategyTable != null) {
                strategyTable.m2901a();
            } else if (!TextUtils.isEmpty(str2)) {
                strategyTable = new StrategyTable(str2);
            }
            if (strategyTable != null) {
                synchronized (this.f2322a) {
                    this.f2322a.put(strategyTable.f2332a, strategyTable);
                }
            }
            synchronized (this.f2330i) {
                this.f2330i.remove(str);
            }
        }
    }

    private void m2886a(C0729b[] c0729bArr) {
        for (C0729b c0729b : c0729bArr) {
            if (c0729b.f2405q) {
                ALog.m2963i("awcn.StrategyInfoHolder", "find effectNow", null, C4103b.ELECTION_KEY_HOST, c0729b.f2389a);
                C0728a[] c0728aArr = c0729b.f2394f;
                String[] strArr = c0729b.f2393e;
                for (Session session : C0664a.f2207a.m2793a(C0734n.m2951a(c0729b.f2391c, c0729b.f2389a))) {
                    if (!session.getConnType().isHttpType()) {
                        int i;
                        Object obj;
                        for (Object equals : strArr) {
                            if (session.getIp().equals(equals)) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            if (ALog.isPrintLog(2)) {
                                ALog.m2963i("awcn.StrategyInfoHolder", "ip not match", null, "session ip", session.getIp(), "ips", Arrays.toString(strArr));
                            }
                            session.close(true);
                        } else {
                            i = 0;
                            while (i < c0728aArr.length) {
                                if (session.getPort() == c0728aArr[i].f2379a && session.getConnType().equals(ConnType.valueOf(c0728aArr[i]))) {
                                    obj = 1;
                                    break;
                                }
                                i++;
                            }
                            obj = null;
                            if (obj == null) {
                                if (ALog.isPrintLog(2)) {
                                    ALog.m2963i("awcn.StrategyInfoHolder", "aisle not match", null, "port", Integer.valueOf(session.getPort()), "connType", session.getConnType(), "aisle", Arrays.toString(c0728aArr));
                                }
                                session.close(true);
                            } else {
                                ALog.m2963i("awcn.StrategyInfoHolder", "session matches, do nothing", null, new Object[0]);
                            }
                        }
                    }
                }
            }
        }
    }

    private static String m2887b(String str) {
        Object md5ToHex = StringUtils.md5ToHex(str);
        return !TextUtils.isEmpty(md5ToHex) ? md5ToHex : "DefaultStrategy";
    }

    private void m2888b(C0730c c0730c) {
        if (c0730c.f2408c != null) {
            for (C0729b c0729b : c0730c.f2408c) {
                if (TextUtils.isEmpty(c0729b.f2392d)) {
                    this.f2327f.remove(c0729b.f2389a);
                } else {
                    this.f2327f.put(c0729b.f2389a, c0729b.f2392d);
                }
            }
        }
    }

    private void m2889d() {
        NetworkStatusHelper.m2841a((INetworkStatusChangeListener) this);
        this.f2331j = m2882a(NetworkStatusHelper.m2839a());
    }

    private void m2890e() {
        for (Entry value : this.f2322a.entrySet()) {
            ((StrategyTable) value.getValue()).m2901a();
        }
        if (this.f2323b == null) {
            this.f2323b = new UnitMap();
        } else {
            this.f2323b.m2906a();
        }
        if (this.f2324c == null) {
            this.f2324c = new SafeAislesMap();
        } else {
            this.f2324c.m2875a();
        }
        if (this.f2325d == null) {
            this.f2325d = new HorseRideStrategyMap();
        } else {
            this.f2325d.m2864a();
        }
    }

    private void m2891f() {
        String b = m2887b(this.f2331j);
        if (!TextUtils.isEmpty(this.f2331j)) {
            m2885a(b, this.f2331j);
        }
        ConfigInfoWrapper configInfoWrapper = (ConfigInfoWrapper) C0732l.m2945b("config");
        if (configInfoWrapper != null) {
            configInfoWrapper.m2878a(this);
        }
        C0660c.m2783a(new C0723f(this, b));
    }

    void m2892a(C0730c c0730c) {
        if (c0730c.f2412g != 0) {
            GlobalAppRuntimeInfo.setAmdcLimit(c0730c.f2412g, c0730c.f2413h);
        }
        m2888b(c0730c);
        m2894c().update(c0730c);
        synchronized (this.f2329h) {
            this.f2324c.m2876a(c0730c);
            this.f2323b.m2907a(c0730c);
            this.f2325d.m2865a(c0730c);
        }
        m2886a(c0730c.f2408c);
    }

    void m2893b() {
        synchronized (this.f2322a) {
            for (StrategyTable strategyTable : this.f2322a.values()) {
                C0732l.m2943a(strategyTable, m2887b(strategyTable.f2332a));
            }
        }
        synchronized (this.f2329h) {
            C0732l.m2943a(new ConfigInfoWrapper(this), "config");
        }
    }

    StrategyTable m2894c() {
        StrategyTable strategyTable = this.f2328g;
        if (TextUtils.isEmpty(this.f2331j)) {
            return strategyTable;
        }
        StrategyTable strategyTable2;
        synchronized (this.f2322a) {
            strategyTable2 = (StrategyTable) this.f2322a.get(this.f2331j);
            if (strategyTable2 == null) {
                strategyTable2 = !this.f2322a.isEmpty() ? (StrategyTable) this.f2322a.values().iterator().next() : strategyTable;
            }
        }
        return strategyTable2;
    }

    public void onNetworkStatusChanged(NetworkStatus networkStatus) {
        if (ALog.isPrintLog(2)) {
            NetworkStatusHelper.m2850i();
        }
        this.f2331j = m2882a(networkStatus);
        if (!TextUtils.isEmpty(this.f2331j)) {
            synchronized (this.f2322a) {
                if (!this.f2322a.containsKey(this.f2331j)) {
                    C0660c.m2783a(new C0724g(this, this.f2331j));
                }
            }
        }
    }
}
