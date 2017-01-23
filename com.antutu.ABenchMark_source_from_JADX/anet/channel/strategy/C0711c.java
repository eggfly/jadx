package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.strategy.IPConnStrategy.C0706a;
import anet.channel.strategy.RawConnStrategy.C0708a;
import anet.channel.util.ALog;
import com.taobao.accs.internal.C4103b;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: anet.channel.strategy.c */
class C0711c {
    static final IPConnStrategy f2346c;
    final ConcurrentHashMap<String, IPConnStrategy> f2347a;
    final HashMap<String, Object> f2348b;

    static {
        f2346c = C0706a.m2866a(BuildConfig.FLAVOR, C0708a.m2869a(0, ConnType.HTTP));
    }

    C0711c() {
        this.f2347a = new ConcurrentHashMap();
        this.f2348b = new HashMap();
    }

    private void m2911a(String str, Object obj) {
        new C0712d(this, str, obj).execute(new Void[0]);
    }

    public List m2912a(String str) {
        if (TextUtils.isEmpty(str) || !C0734n.m2958f(str)) {
            return Collections.EMPTY_LIST;
        }
        if (ALog.isPrintLog(1)) {
            ALog.m2960d("awcn.LocalDnsStrategyTable", "try resolve ip with local dns", null, C4103b.ELECTION_KEY_HOST, str);
        }
        List list = Collections.EMPTY_LIST;
        if (!this.f2347a.containsKey(str)) {
            Object obj;
            synchronized (this.f2348b) {
                if (this.f2348b.containsKey(str)) {
                    obj = this.f2348b.get(str);
                } else {
                    Object obj2 = new Object();
                    this.f2348b.put(str, obj2);
                    m2911a(str, obj2);
                    obj = obj2;
                }
            }
            if (obj != null) {
                try {
                    synchronized (obj) {
                        obj.wait(500);
                    }
                } catch (InterruptedException e) {
                }
            }
        }
        IPConnStrategy iPConnStrategy = (IPConnStrategy) this.f2347a.get(str);
        if (iPConnStrategy == null || iPConnStrategy == f2346c) {
            return list;
        }
        list = new ArrayList();
        list.add(iPConnStrategy);
        return list;
    }
}
