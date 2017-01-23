package com.taobao.accs.internal;

import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.taobao.accs.utl.ALog;

/* renamed from: com.taobao.accs.internal.e */
class C4108e implements Runnable {
    final /* synthetic */ C4103b f13750a;

    C4108e(C4103b c4103b) {
        this.f13750a = c4103b;
    }

    public void run() {
        ALog.m16906w("ElectionServiceImpl", "time out, onReportComplete", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_KEY, this.f13750a.f13721c);
        this.f13750a.m16787e();
    }
}
