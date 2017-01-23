package anet.channel.strategy;

import android.os.AsyncTask;
import anet.channel.entity.ConnType;
import anet.channel.strategy.IPConnStrategy.C0706a;
import anet.channel.strategy.RawConnStrategy.C0708a;
import anet.channel.util.ALog;
import anet.channel.util.C0739d;
import com.taobao.accs.internal.C4103b;
import java.net.InetAddress;

/* renamed from: anet.channel.strategy.d */
class C0712d extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ String f2349a;
    final /* synthetic */ Object f2350b;
    final /* synthetic */ C0711c f2351c;

    C0712d(C0711c c0711c, String str, Object obj) {
        this.f2351c = c0711c;
        this.f2349a = str;
        this.f2350b = obj;
    }

    protected Void m2913a() {
        try {
            String hostAddress = InetAddress.getByName(this.f2349a).getHostAddress();
            if (C0739d.m2972a(hostAddress)) {
                if (C0734n.m2955c(this.f2349a)) {
                    this.f2351c.f2347a.put(this.f2349a, C0706a.m2866a(hostAddress, C0708a.m2868a()));
                } else {
                    this.f2351c.f2347a.put(this.f2349a, C0706a.m2866a(hostAddress, C0708a.m2869a(80, ConnType.HTTP)));
                }
                if (ALog.isPrintLog(1)) {
                    ALog.m2960d("awcn.LocalDnsStrategyTable", "resolve ip by local dns", null, C4103b.ELECTION_KEY_HOST, this.f2349a, "ip", hostAddress);
                }
            } else {
                this.f2351c.f2347a.put(this.f2349a, C0711c.f2346c);
            }
            synchronized (this.f2351c.f2348b) {
                this.f2351c.f2348b.remove(this.f2349a);
            }
            synchronized (this.f2350b) {
                this.f2350b.notifyAll();
            }
        } catch (Exception e) {
            if (ALog.isPrintLog(1)) {
                ALog.m2960d("awcn.LocalDnsStrategyTable", "resolve ip by local dns failed", null, C4103b.ELECTION_KEY_HOST, this.f2349a);
            }
            synchronized (this.f2351c.f2348b) {
            }
            this.f2351c.f2348b.remove(this.f2349a);
            synchronized (this.f2350b) {
            }
            this.f2350b.notifyAll();
        } catch (Throwable th) {
            synchronized (this.f2351c.f2348b) {
            }
            this.f2351c.f2348b.remove(this.f2349a);
            synchronized (this.f2350b) {
            }
            this.f2350b.notifyAll();
        }
        return null;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m2913a();
    }
}
