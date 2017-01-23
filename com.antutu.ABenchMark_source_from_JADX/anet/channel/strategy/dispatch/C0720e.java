package anet.channel.strategy.dispatch;

import anet.channel.p019c.C0660c;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;
import anet.channel.util.ALog;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: anet.channel.strategy.dispatch.e */
class C0720e {
    public static final int REQUEST_MERGE_PERIOD = 2500;
    Map<String, Object> f2367a;

    /* renamed from: anet.channel.strategy.dispatch.e.a */
    private static class C0719a implements Runnable {
        private Map<String, Object> f2365a;
        private NetworkStatus f2366b;

        C0719a(Map<String, Object> map) {
            this.f2365a = map;
            this.f2366b = NetworkStatusHelper.m2839a();
        }

        public void run() {
            try {
                if (NetworkStatusHelper.m2846e() || NetworkStatusHelper.m2839a() == this.f2366b) {
                    C0715b.m2924b(C0717c.m2927a(this.f2365a));
                }
            } catch (Throwable e) {
                ALog.m2961e("DispatchTaskExecutor", "exec amdc task failed.", null, e, new Object[0]);
            }
        }
    }

    C0720e() {
    }

    public void m2933a(Map<String, Object> map) {
        synchronized (this) {
            if (this.f2367a == null) {
                this.f2367a = map;
                C0660c.m2786a(new C0721f(this), 2500, TimeUnit.MILLISECONDS);
            } else {
                Set set = (Set) this.f2367a.get(C0714a.HOSTS);
                Set set2 = (Set) map.get(C0714a.HOSTS);
                if (set.size() + set2.size() >= 40) {
                    C0660c.m2784a(new C0719a(map), 0);
                    return;
                }
                set2.addAll(set);
                this.f2367a = map;
            }
        }
    }
}
