package com.taobao.accs.net;

import anet.channel.entity.ConnType;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.HttpDispatcher;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.taobao.accs.net.f */
public class C4117f {
    private int f13780a;
    private List<IConnStrategy> f13781b;

    public C4117f(String str) {
        this.f13780a = 0;
        this.f13781b = new ArrayList();
        HttpDispatcher.getInstance().addListener(new C4118g(this));
        m16833a(str);
    }

    public IConnStrategy m16831a() {
        return m16832a(this.f13781b);
    }

    public IConnStrategy m16832a(List<IConnStrategy> list) {
        if (list == null || list.isEmpty()) {
            ALog.m16901d("HttpDnsProvider", "strategys null or 0", new Object[0]);
            return null;
        }
        if (this.f13780a < 0 || this.f13780a >= list.size()) {
            this.f13780a = 0;
        }
        return (IConnStrategy) list.get(this.f13780a);
    }

    public List<IConnStrategy> m16833a(String str) {
        if (this.f13780a == 0 || this.f13781b.isEmpty()) {
            List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str);
            if (!(connStrategyListByHost == null || connStrategyListByHost.isEmpty())) {
                this.f13781b.clear();
                for (IConnStrategy iConnStrategy : connStrategyListByHost) {
                    if (ConnType.ACCS_0RTT.equals(iConnStrategy.getConnType()) || ConnType.HTTP2.equals(iConnStrategy.getConnType())) {
                        this.f13781b.add(iConnStrategy);
                    }
                }
            }
        }
        return this.f13781b;
    }

    public void m16834b() {
        this.f13780a++;
        if (ALog.isPrintLog(Level.D)) {
            ALog.m16901d("HttpDnsProvider", "updateStrategyPos StrategyPos:" + this.f13780a, new Object[0]);
        }
    }

    public void m16835b(String str) {
        StrategyCenter.getInstance().forceRefreshStrategy(str);
    }

    public int m16836c() {
        return this.f13780a;
    }
}
