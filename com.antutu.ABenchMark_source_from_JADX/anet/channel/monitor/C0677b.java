package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;

/* renamed from: anet.channel.monitor.b */
class C0677b implements INetworkStatusChangeListener {
    final /* synthetic */ C0676a f2250a;

    C0677b(C0676a c0676a) {
        this.f2250a = c0676a;
    }

    public void onNetworkStatusChanged(NetworkStatus networkStatus) {
        this.f2250a.f2249o.m2817a();
        C0676a.f2240f = 0;
        this.f2250a.m2814c();
    }
}
