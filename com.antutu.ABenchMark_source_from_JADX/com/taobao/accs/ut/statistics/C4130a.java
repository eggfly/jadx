package com.taobao.accs.ut.statistics;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.qq.p035e.comm.constants.Constants.KEYS;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.taobao.accs.ut.statistics.a */
public class C4130a implements UTInterface {
    public String f13846a;
    public String f13847b;
    public boolean f13848c;
    public String f13849d;
    private final String f13850e;
    private boolean f13851f;

    public C4130a() {
        this.f13850e = "BindApp";
        this.f13851f = false;
    }

    private void m16895b(String str) {
        String str2;
        String valueOf;
        Throwable th;
        if (!this.f13851f) {
            this.f13851f = true;
            Map hashMap = new HashMap();
            try {
                str2 = this.f13846a;
                try {
                    valueOf = String.valueOf(Constants.SDK_VERSION_CODE);
                    try {
                        hashMap.put("device_id", this.f13846a);
                        hashMap.put("bind_date", this.f13847b);
                        hashMap.put(KEYS.RET, this.f13848c ? "y" : IXAdRequestInfo.AD_COUNT);
                        hashMap.put("fail_reasons", this.f13849d);
                        hashMap.put("push_token", BuildConfig.FLAVOR);
                        if (ALog.isPrintLog(Level.D)) {
                            ALog.m16901d("accs.BindAppStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, str2, null, valueOf, hashMap), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent((int) UT.EVENT_ID, str, (Object) str2, null, (Object) valueOf, hashMap);
                    } catch (Throwable th2) {
                        th = th2;
                        ALog.m16901d("accs.BindAppStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, str2, null, valueOf, hashMap) + " " + th.toString(), new Object[0]);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    valueOf = null;
                    ALog.m16901d("accs.BindAppStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, str2, null, valueOf, hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th4) {
                th = th4;
                valueOf = null;
                str2 = null;
                ALog.m16901d("accs.BindAppStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, str2, null, valueOf, hashMap) + " " + th.toString(), new Object[0]);
            }
        }
    }

    public void m16896a(int i) {
        switch (i) {
            case ErrorCode.MESSAGE_TOO_LARGE /*-4*/:
                m16897a("msg too large");
            case TnetStatusCode.EASY_REQ_STATE_PROCESS_RSP_FAIL /*-3*/:
                m16897a("service not available");
            case TnetStatusCode.EASY_REQ_STAGE_SEND_FAIL /*-2*/:
                m16897a("param error");
            case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                m16897a("network fail");
            case Constants.COMMAND_HANDSHAKE /*200*/:
            case ErrorCode.APP_NOT_BIND /*300*/:
                m16897a("app not bind");
            default:
                m16897a(String.valueOf(i));
        }
    }

    public void m16897a(String str) {
        this.f13849d = str;
    }

    public void commitUT() {
        m16895b("BindApp");
    }
}
