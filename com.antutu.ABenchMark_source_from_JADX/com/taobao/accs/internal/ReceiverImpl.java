package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.taobao.accs.base.IBaseReceiver;
import com.taobao.accs.client.C4085a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C4135a;
import com.taobao.accs.utl.UtilityImpl;

public class ReceiverImpl implements IBaseReceiver {
    public void onReceive(Context context, Intent intent) {
        ALog.m16901d("ReceiverImpl", "ReceiverImpl onReceive begin......", new Object[0]);
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            intent = new Intent();
        }
        try {
            if (UtilityImpl.getServiceEnabled(context)) {
                intent.setClassName(context.getPackageName(), C4135a.channelService);
                context.startService(intent);
            } else {
                Process.killProcess(Process.myPid());
            }
            if (UtilityImpl.getAgooServiceEnabled(context)) {
                intent.setClassName(context, C4085a.m16663b(context.getPackageName()));
                context.startService(intent);
            }
        } catch (Throwable th) {
            ALog.m16903e("ReceiverImpl", "ReceiverImpl onReceive,exception,e=" + th.getMessage(), new Object[0]);
        }
    }
}
