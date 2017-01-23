package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4136b;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.taobao.accs.data.g */
class C4101g implements Runnable {
    final /* synthetic */ String f13708a;
    final /* synthetic */ Context f13709b;
    final /* synthetic */ Intent f13710c;
    final /* synthetic */ C4095e f13711d;

    C4101g(C4095e c4095e, String str, Context context, Intent intent) {
        this.f13711d = c4095e;
        this.f13708a = str;
        this.f13709b = context;
        this.f13710c = intent;
    }

    public void run() {
        if (C4095e.f13686a != null && C4095e.f13686a.contains(this.f13708a)) {
            ALog.m16903e("MsgDistribute", "routing msg time out, try election", Constants.KEY_DATA_ID, this.f13708a);
            C4095e.f13686a.remove(this.f13708a);
            this.f13711d.m16710a(this.f13709b);
            C4136b.m16917a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.ALARM_MSG_ROUTING_RATE, BuildConfig.FLAVOR, "timeout", "pkg:" + this.f13710c.getPackage());
        }
    }
}
