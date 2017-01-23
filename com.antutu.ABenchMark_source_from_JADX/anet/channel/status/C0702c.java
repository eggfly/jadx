package anet.channel.status;

import android.content.Context;

/* renamed from: anet.channel.status.c */
class C0702c implements Runnable {
    final /* synthetic */ Context f2303a;
    final /* synthetic */ NetworkStatusMonitor$1 f2304b;

    C0702c(NetworkStatusMonitor$1 networkStatusMonitor$1, Context context) {
        this.f2304b = networkStatusMonitor$1;
        this.f2303a = context;
    }

    public void run() {
        C0701b.m2857b(this.f2303a);
    }
}
