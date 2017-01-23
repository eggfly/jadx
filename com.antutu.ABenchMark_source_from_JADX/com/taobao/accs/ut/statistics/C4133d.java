package com.taobao.accs.ut.statistics;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.taobao.accs.ut.statistics.d */
public class C4133d implements UTInterface {
    public String f13870a;
    public String f13871b;
    public String f13872c;
    public String f13873d;
    public String f13874e;
    public String f13875f;
    public String f13876g;
    public boolean f13877h;
    public String f13878i;
    private final String f13879j;
    private boolean f13880k;

    public C4133d() {
        this.f13879j = "receiveMessage";
        this.f13877h = false;
        this.f13880k = false;
    }

    public void commitUT() {
        String str;
        String valueOf;
        Throwable th;
        if (!this.f13880k) {
            this.f13880k = true;
            Map hashMap = new HashMap();
            try {
                str = this.f13870a;
                try {
                    valueOf = String.valueOf(Constants.SDK_VERSION_CODE);
                    try {
                        hashMap.put("device_id", this.f13870a);
                        hashMap.put("data_id", this.f13871b);
                        hashMap.put("receive_date", this.f13872c);
                        hashMap.put("to_bz_date", this.f13873d);
                        hashMap.put("service_id", this.f13874e);
                        hashMap.put("data_length", this.f13875f);
                        hashMap.put("msg_type", this.f13876g);
                        hashMap.put("repeat", this.f13877h ? "y" : IXAdRequestInfo.AD_COUNT);
                        hashMap.put("user_id", this.f13878i);
                        if (ALog.isPrintLog(Level.D)) {
                            ALog.m16901d("accs.ReceiveMessage", UTMini.getCommitInfo((int) UT.EVENT_ID, str, null, valueOf, hashMap), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent((int) UT.EVENT_ID, "receiveMessage", (Object) str, null, (Object) valueOf, hashMap);
                    } catch (Throwable th2) {
                        th = th2;
                        ALog.m16901d("accs.ReceiveMessage", UTMini.getCommitInfo((int) UT.EVENT_ID, str, null, valueOf, hashMap) + " " + th.toString(), new Object[0]);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    valueOf = null;
                    ALog.m16901d("accs.ReceiveMessage", UTMini.getCommitInfo((int) UT.EVENT_ID, str, null, valueOf, hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th4) {
                th = th4;
                valueOf = null;
                str = null;
                ALog.m16901d("accs.ReceiveMessage", UTMini.getCommitInfo((int) UT.EVENT_ID, str, null, valueOf, hashMap) + " " + th.toString(), new Object[0]);
            }
        }
    }
}
