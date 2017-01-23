package com.taobao.accs.ut.statistics;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.qq.p035e.comm.constants.Constants.KEYS;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import java.util.Map;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.taobao.accs.ut.statistics.b */
public class C4131b implements UTInterface {
    public String f13852a;
    public String f13853b;
    public boolean f13854c;
    public String f13855d;
    public String f13856e;
    private final String f13857f;
    private boolean f13858g;

    public C4131b() {
        this.f13857f = "BindUser";
        this.f13858g = false;
    }

    private void m16898b(String str) {
        String str2;
        String valueOf;
        Throwable th;
        if (!this.f13858g) {
            this.f13858g = true;
            Map hashMap = new HashMap();
            try {
                str2 = this.f13852a;
                try {
                    valueOf = String.valueOf(Constants.SDK_VERSION_CODE);
                    try {
                        hashMap.put("device_id", this.f13852a);
                        hashMap.put("bind_date", this.f13853b);
                        hashMap.put(KEYS.RET, this.f13854c ? "y" : IXAdRequestInfo.AD_COUNT);
                        hashMap.put("fail_reasons", this.f13855d);
                        hashMap.put("user_id", this.f13856e);
                        if (ALog.isPrintLog(Level.D)) {
                            ALog.m16901d("accs.BindUserStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, str2, null, valueOf, hashMap), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent((int) UT.EVENT_ID, str, (Object) str2, null, (Object) valueOf, hashMap);
                    } catch (Throwable th2) {
                        th = th2;
                        ALog.m16901d("accs.BindUserStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, str2, null, valueOf, hashMap) + " " + th.toString(), new Object[0]);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    valueOf = null;
                    ALog.m16901d("accs.BindUserStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, str2, null, valueOf, hashMap) + " " + th.toString(), new Object[0]);
                }
            } catch (Throwable th4) {
                th = th4;
                valueOf = null;
                str2 = null;
                ALog.m16901d("accs.BindUserStatistic", UTMini.getCommitInfo((int) UT.EVENT_ID, str2, null, valueOf, hashMap) + " " + th.toString(), new Object[0]);
            }
        }
    }

    public void m16899a(int i) {
        switch (i) {
            case ErrorCode.MESSAGE_TOO_LARGE /*-4*/:
                m16900a("msg too large");
            case TnetStatusCode.EASY_REQ_STATE_PROCESS_RSP_FAIL /*-3*/:
                m16900a("service not available");
            case TnetStatusCode.EASY_REQ_STAGE_SEND_FAIL /*-2*/:
                m16900a("param error");
            case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                m16900a("network fail");
            case Constants.COMMAND_HANDSHAKE /*200*/:
            case ErrorCode.APP_NOT_BIND /*300*/:
                m16900a("app not bind");
            default:
                m16900a(String.valueOf(i));
        }
    }

    public void m16900a(String str) {
        this.f13855d = str;
    }

    public void commitUT() {
        m16898b("BindUser");
    }
}
