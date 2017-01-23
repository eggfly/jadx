package com.taobao.accs.ut.statistics;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.taobao.accs.ut.statistics.c */
public class C4132c implements UTInterface {
    public int f13859a;
    public int f13860b;
    public boolean f13861c;
    public int f13862d;
    public int f13863e;
    public String f13864f;
    public String f13865g;
    public long f13866h;
    public boolean f13867i;
    public boolean f13868j;
    private long f13869k;

    public C4132c() {
        this.f13869k = 0;
        this.f13861c = false;
        this.f13862d = 0;
        this.f13863e = 0;
    }

    public void commitUT() {
        String valueOf;
        String valueOf2;
        Throwable th;
        long currentTimeMillis = System.currentTimeMillis();
        if (ALog.isPrintLog(Level.D)) {
            ALog.m16901d("MonitorStatistic", "commitUT interval:" + (currentTimeMillis - this.f13869k) + " interval1:" + (currentTimeMillis - this.f13866h), new Object[0]);
        }
        if (currentTimeMillis - this.f13869k > 1200000 && currentTimeMillis - this.f13866h > 60000) {
            Map hashMap = new HashMap();
            try {
                valueOf = String.valueOf(this.f13862d);
                try {
                    valueOf2 = String.valueOf(this.f13863e);
                    try {
                        Object valueOf3 = String.valueOf(Constants.SDK_VERSION_CODE);
                        hashMap.put("connStatus", String.valueOf(this.f13859a));
                        hashMap.put("connType", String.valueOf(this.f13860b));
                        hashMap.put("tcpConnected", String.valueOf(this.f13861c));
                        hashMap.put("proxy", String.valueOf(this.f13864f));
                        hashMap.put("startServiceTime", String.valueOf(this.f13866h));
                        hashMap.put("commitTime", String.valueOf(currentTimeMillis));
                        hashMap.put("networkAvailable", String.valueOf(this.f13867i));
                        hashMap.put("threadIsalive", String.valueOf(this.f13868j));
                        hashMap.put("url", this.f13865g);
                        if (ALog.isPrintLog(Level.D)) {
                            ALog.m16901d("MonitorStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, valueOf, valueOf2, (String) valueOf3, hashMap), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent((int) UT.EVENT_ID, "MONITOR", (Object) valueOf, (Object) valueOf2, valueOf3, hashMap);
                        this.f13869k = currentTimeMillis;
                    } catch (Throwable th2) {
                        th = th2;
                        ALog.m16901d("MonitorStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, valueOf, valueOf2, null, hashMap) + " " + th.toString(), new Object[0]);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    valueOf2 = null;
                    ALog.m16901d("MonitorStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, valueOf, valueOf2, null, hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th4) {
                th = th4;
                valueOf2 = null;
                valueOf = null;
                ALog.m16901d("MonitorStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, valueOf, valueOf2, null, hashMap) + " " + th.toString(), new Object[0]);
            }
        }
    }
}
