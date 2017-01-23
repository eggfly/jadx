package com.taobao.accs.ut.statistics;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.taobao.accs.ut.statistics.e */
public class C4134e implements UTInterface {
    public String f13881a;
    public String f13882b;
    public String f13883c;
    public String f13884d;
    public String f13885e;
    public String f13886f;
    private final String f13887g;
    private boolean f13888h;

    public C4134e() {
        this.f13887g = "sendAck";
        this.f13888h = false;
    }

    public void commitUT() {
        Throwable th;
        if (!this.f13888h) {
            this.f13888h = true;
            Map hashMap = new HashMap();
            String str;
            String valueOf;
            try {
                str = this.f13881a;
                try {
                    valueOf = String.valueOf(Constants.SDK_VERSION_CODE);
                    try {
                        hashMap.put("device_id", this.f13881a);
                        hashMap.put("session_id", this.f13882b);
                        hashMap.put("data_id", this.f13883c);
                        hashMap.put("ack_date", this.f13884d);
                        hashMap.put("service_id", this.f13885e);
                        hashMap.put("fail_reasons", this.f13886f);
                        if (ALog.isPrintLog(Level.D)) {
                            ALog.m16901d("accs.SendAckStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, str, null, valueOf, hashMap), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent((int) UT.EVENT_ID, "sendAck", (Object) str, null, (Object) valueOf, hashMap);
                    } catch (Throwable th2) {
                        th = th2;
                        ALog.m16901d("accs.SendAckStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, str, null, valueOf, hashMap) + " " + th.toString(), new Object[0]);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    valueOf = null;
                    ALog.m16901d("accs.SendAckStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, str, null, valueOf, hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th4) {
                th = th4;
                valueOf = null;
                str = null;
                ALog.m16901d("accs.SendAckStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, str, null, valueOf, hashMap) + " " + th.toString(), new Object[0]);
            }
        }
    }
}
