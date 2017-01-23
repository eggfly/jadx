package com.taobao.accs.internal;

import android.content.Intent;
import android.os.Process;
import com.taobao.accs.internal.ServiceImpl.C41022;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C4135a;
import com.taobao.accs.utl.UT;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.taobao.accs.internal.h */
class C4111h implements Runnable {
    final /* synthetic */ C41022 f13753a;

    C4111h(C41022 c41022) {
        this.f13753a = c41022;
    }

    public void run() {
        try {
            if (this.f13753a.this$0.f13734b == null || !UtilityImpl.getServiceEnabled(r1.f13734b)) {
                Process.killProcess(Process.myPid());
            } else {
                Intent intent = new Intent();
                intent.setAction(AgooConstants.INTENT_FROM_AGOO_PING);
                intent.setClassName(this.f13753a.this$0.f13734b.getPackageName(), C4135a.channelService);
                this.f13753a.this$0.f13734b.startService(intent);
                UTMini.getInstance().commitEvent(UT.EVENT_ID, "probeServiceEnabled", UtilityImpl.getDeviceId(this.f13753a.this$0.f13734b));
                ALog.m16901d("ServiceImpl", "ReceiverImpl probeTaoBao........mContext.startService(intent) [probe][successfully]", new Object[0]);
            }
            ALog.m16901d("ServiceImpl", "ReceiverImpl probeTaoBao........messageServiceBinder [probe][end]", new Object[0]);
        } catch (Throwable th) {
            ALog.m16901d("ServiceImpl", "ReceiverImpl probeTaoBao error........e=" + th, new Object[0]);
        }
    }
}
