package com.taobao.accs.internal;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4136b;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.taobao.accs.internal.g */
class C4110g implements Runnable {
    final /* synthetic */ ServiceImpl f13752a;

    C4110g(ServiceImpl serviceImpl) {
        this.f13752a = serviceImpl;
    }

    public void run() {
        ServiceImpl serviceImpl = this.f13752a;
        ServiceImpl.m16798d();
        this.f13752a.m16793a(this.f13752a.f13734b);
        UTMini.getInstance().commitEvent(UT.EVENT_ID, UtilityImpl.getDeviceId(this.f13752a.f13734b), UtilityImpl.getProxy(), "PROXY");
        long serviceAliveTime = UtilityImpl.getServiceAliveTime(this.f13752a.f13734b);
        ALog.m16901d("ServiceImpl", "getServiceAliveTime", "aliveTime", Long.valueOf(serviceAliveTime));
        if (serviceAliveTime > 20000) {
            C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_SERVICE_ALIVE, BuildConfig.FLAVOR, (double) (serviceAliveTime / 1000));
        }
        UtilityImpl.setServiceTime(this.f13752a.f13734b, Constants.SP_KEY_SERVICE_START, System.currentTimeMillis());
    }
}
