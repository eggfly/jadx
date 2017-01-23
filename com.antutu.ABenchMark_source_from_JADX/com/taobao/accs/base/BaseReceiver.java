package com.taobao.accs.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.taobao.accs.common.Constants;
import com.taobao.accs.p193d.C4091a;
import com.taobao.accs.utl.ALog;

public class BaseReceiver extends BroadcastReceiver {
    private static final String TAG = "BaseReceiver";
    private IBaseReceiver baseReceiver;

    public void onReceive(Context context, Intent intent) {
        if (this.baseReceiver == null) {
            try {
                this.baseReceiver = (IBaseReceiver) C4091a.m16693a().m16696a(context.getApplicationContext()).loadClass(Constants.RECEIVER_IMPL_NAME).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable e) {
                Throwable th = e;
                th.printStackTrace();
                try {
                    this.baseReceiver = (IBaseReceiver) Class.forName(Constants.RECEIVER_IMPL_NAME).newInstance();
                } catch (Throwable e2) {
                    ALog.m16902e(TAG, "onReceive1", e2, new Object[0]);
                }
                ALog.m16902e(TAG, "onReceive", th, new Object[0]);
            }
            if (this.baseReceiver != null) {
                ALog.m16901d(TAG, "onReceive", new Object[0]);
                this.baseReceiver.onReceive(context, intent);
                return;
            }
            ALog.m16903e(TAG, "onReceive baseReceiver NULL", new Object[0]);
        }
    }
}
