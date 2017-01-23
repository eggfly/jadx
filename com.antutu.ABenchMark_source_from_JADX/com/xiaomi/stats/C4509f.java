package com.xiaomi.stats;

import com.facebook.ads.AdError;
import com.xiaomi.channel.commonutils.android.C4293e;
import com.xiaomi.channel.commonutils.android.C4297i;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.network.C4321d;
import com.xiaomi.channel.commonutils.stats.C4325a;
import com.xiaomi.channel.commonutils.stats.C4325a.C4324a;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.thrift.C4452a;
import com.xiaomi.push.thrift.C4455b;
import com.xiaomi.push.thrift.C4457c;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.smack.C4473l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.thrift.C4597f;
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4617k.C4616a;
import org.apache.thrift.transport.C4618d;
import org.apache.thrift.transport.C4620b;

/* renamed from: com.xiaomi.stats.f */
public class C4509f {
    private String f15501a;
    private boolean f15502b;
    private int f15503c;
    private long f15504d;
    private C4507e f15505e;
    private C4325a f15506f;

    /* renamed from: com.xiaomi.stats.f.a */
    static class C4508a {
        static final C4509f f15500a;

        static {
            f15500a = new C4509f();
        }
    }

    public C4509f() {
        this.f15502b = false;
        this.f15506f = C4325a.m17726a();
    }

    private C4455b m18691a(C4324a c4324a) {
        if (c4324a.f14766a == 0) {
            return c4324a.f14768c instanceof C4455b ? (C4455b) c4324a.f14768c : null;
        } else {
            C4455b f = m18703f();
            f.m18412a(C4452a.CHANNEL_STATS_COUNTER.m18407a());
            f.m18424c(c4324a.f14766a);
            f.m18425c(c4324a.f14767b);
            return f;
        }
    }

    public static C4509f m18692a() {
        return C4508a.f15500a;
    }

    private C4457c m18693b(int i) {
        List arrayList = new ArrayList();
        C4457c c4457c = new C4457c(this.f15501a, arrayList);
        if (!C4321d.m17711f(this.f15505e.f15491a)) {
            c4457c.m18443a(C4293e.m17614f(this.f15505e.f15491a));
        }
        C4618d c4620b = new C4620b(i);
        C4607e a = new C4616a().m19379a(c4620b);
        try {
            c4457c.m18448b(a);
        } catch (C4597f e) {
        }
        LinkedList c = this.f15506f.m17730c();
        while (c.size() > 0) {
            try {
                C4455b a2 = m18691a((C4324a) c.getLast());
                if (a2 != null) {
                    a2.m18421b(a);
                }
                if (c4620b.a_() > i) {
                    break;
                }
                if (a2 != null) {
                    arrayList.add(a2);
                }
                c.removeLast();
            } catch (NoSuchElementException e2) {
            } catch (C4597f e3) {
            }
        }
        return c4457c;
    }

    public static C4507e m18694b() {
        return C4508a.f15500a.f15505e;
    }

    private void m18695g() {
        if (this.f15504d == 0) {
            this.f15504d = System.currentTimeMillis();
        }
    }

    private void m18696h() {
        if (this.f15502b && System.currentTimeMillis() - this.f15504d > ((long) this.f15503c)) {
            this.f15502b = false;
            this.f15504d = 0;
        }
    }

    public void m18697a(int i) {
        int i2 = 604800000;
        if (i > 0) {
            this.f15502b = true;
            int i3 = i * AdError.NETWORK_ERROR_CODE;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.f15503c != i2) {
                this.f15503c = i2;
                m18695g();
            }
        }
    }

    public synchronized void m18698a(XMPushService xMPushService, C4473l c4473l) {
        this.f15505e = new C4507e(xMPushService);
        this.f15501a = BuildConfig.FLAVOR;
        if (c4473l != null) {
            c4473l.m18458a(this.f15505e);
        }
        ah.m18136a().m18146a(new C4510g(this));
    }

    synchronized void m18699a(C4455b c4455b) {
        this.f15506f.m17728a(c4455b);
    }

    public boolean m18700c() {
        return this.f15502b;
    }

    boolean m18701d() {
        m18696h();
        return this.f15502b && this.f15506f.m17729b() > 0;
    }

    synchronized C4457c m18702e() {
        C4457c c4457c;
        c4457c = null;
        if (m18701d()) {
            int i = 750;
            if (!C4321d.m17711f(C4297i.m17624a())) {
                i = 375;
            }
            c4457c = m18693b(i);
        }
        return c4457c;
    }

    C4455b m18703f() {
        C4455b c4455b = new C4455b();
        c4455b.f15272a = (byte) 0;
        c4455b.f15274c = 1;
        c4455b.m18413a(BuildConfig.FLAVOR);
        c4455b.m18428d((int) (System.currentTimeMillis() / 1000));
        if (this.f15505e == null || this.f15505e.f15491a == null) {
            C4302b.m17649a("createStatsEvent err: context is null");
            m18697a(14400000);
            C4455b c4455b2 = new C4455b(c4455b);
            c4455b2.m18412a(C4452a.CHANNEL_STATS_COUNTER.m18407a());
            c4455b2.m18424c((int) AdError.NETWORK_ERROR_CODE);
            m18699a(c4455b2);
        } else {
            c4455b.m18413a(C4321d.m17712g(this.f15505e.f15491a));
            if (this.f15505e.f15492b != null) {
                c4455b.m18432e(this.f15505e.f15492b.m18472e());
            }
        }
        return c4455b;
    }
}
