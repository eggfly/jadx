package anet.channel.status;

import anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;
import anet.channel.util.ALog;
import java.util.Iterator;

/* renamed from: anet.channel.status.a */
final class C0700a implements Runnable {
    final /* synthetic */ NetworkStatus f2291a;

    C0700a(NetworkStatus networkStatus) {
        this.f2291a = networkStatus;
    }

    public void run() {
        try {
            Iterator it = NetworkStatusHelper.f2290a.iterator();
            while (it.hasNext()) {
                INetworkStatusChangeListener iNetworkStatusChangeListener = (INetworkStatusChangeListener) it.next();
                long currentTimeMillis = System.currentTimeMillis();
                iNetworkStatusChangeListener.onNetworkStatusChanged(this.f2291a);
                if (System.currentTimeMillis() - currentTimeMillis > 500) {
                    ALog.m2961e("awcn.NetworkStatusHelper", "call back cost too much time", null, new Throwable().fillInStackTrace(), new Object[0]);
                }
            }
        } catch (Exception e) {
        }
    }
}
