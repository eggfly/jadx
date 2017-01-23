package anet.channel.p018b;

import anet.channel.strategy.C0734n;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import com.qq.p035e.comm.constants.ErrorCode.AdError;
import com.qq.p035e.comm.constants.ErrorCode.OtherError;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: anet.channel.b.c */
class C0654c extends C0650a {
    List<Long> f2188c;
    HashMap<String, Long> f2189d;

    C0654c() {
        this.f2188c = new LinkedList();
        this.f2189d = new HashMap();
    }

    private void m2770a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f2189d) {
            Long l = (Long) this.f2189d.get(str);
            if (l == null || l.longValue() - currentTimeMillis > 60000) {
                this.f2189d.put(str, Long.valueOf(currentTimeMillis));
                StrategyCenter.getInstance().forceRefreshStrategy(str);
            }
        }
    }

    protected Object m2771a(int i, Object... objArr) {
        if (i == 0) {
            m2772a(((Integer) objArr[0]).intValue());
        } else if (i == 1) {
            m2770a((String) objArr[0]);
            return b;
        }
        return a;
    }

    public void m2772a(int i) {
        if (ALog.isPrintLog(1)) {
            ALog.m2960d("awcn.FailOverHandler", "FailOverHandler hook onResponseCode", null, new Object[0]);
        }
        if (i < AdError.PLACEMENT_ERROR || i >= OtherError.CONTAINER_INVISIBLE_ERROR) {
            synchronized (this.f2188c) {
                this.f2188c.clear();
            }
            return;
        }
        synchronized (this.f2188c) {
            if (this.f2188c.size() < 5) {
                this.f2188c.add(Long.valueOf(System.currentTimeMillis()));
            } else {
                long longValue = ((Long) this.f2188c.remove(0)).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - longValue <= 60000) {
                    m2770a(C0734n.m2950a());
                    this.f2188c.clear();
                } else {
                    this.f2188c.add(Long.valueOf(currentTimeMillis));
                }
            }
        }
    }
}
