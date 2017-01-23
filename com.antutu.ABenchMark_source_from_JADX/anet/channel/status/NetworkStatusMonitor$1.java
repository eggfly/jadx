package anet.channel.status;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import anet.channel.p019c.C0660c;
import anet.channel.util.ALog;

final class NetworkStatusMonitor$1 extends BroadcastReceiver {
    NetworkStatusMonitor$1() {
    }

    public void onReceive(Context context, Intent intent) {
        if (ALog.isPrintLog(1)) {
            ALog.m2960d("awcn.NetworkStatusMonitor", "receiver:" + intent.getAction(), null, new Object[0]);
        }
        C0660c.m2783a(new C0702c(this, context));
    }
}
