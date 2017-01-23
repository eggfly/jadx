package com.xiaomi.stats;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.network.C4321d;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.thrift.C4452a;
import com.xiaomi.push.thrift.C4455b;
import com.xiaomi.smack.C4338d;
import com.xiaomi.smack.C4461a;
import com.xiaomi.smack.C4467j;

/* renamed from: com.xiaomi.stats.e */
public class C4507e implements C4338d {
    XMPushService f15491a;
    C4461a f15492b;
    private int f15493c;
    private Exception f15494d;
    private String f15495e;
    private long f15496f;
    private long f15497g;
    private long f15498h;
    private long f15499i;

    C4507e(XMPushService xMPushService) {
        this.f15496f = 0;
        this.f15497g = 0;
        this.f15498h = 0;
        this.f15499i = 0;
        this.f15491a = xMPushService;
        this.f15495e = C4321d.m17712g(xMPushService);
        m18683c();
    }

    private void m18683c() {
        this.f15497g = 0;
        this.f15499i = 0;
        this.f15496f = 0;
        this.f15498h = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (C4321d.m17709d(this.f15491a)) {
            this.f15496f = elapsedRealtime;
        }
        if (this.f15491a.m18101e()) {
            this.f15498h = elapsedRealtime;
        }
    }

    private synchronized void m18684d() {
        C4302b.m17653c("stat connpt = " + this.f15495e + " netDuration = " + this.f15497g + " ChannelDuration = " + this.f15499i + " channelConnectedTime = " + this.f15498h);
        C4455b c4455b = new C4455b();
        c4455b.f15272a = (byte) 0;
        c4455b.m18412a(C4452a.CHANNEL_ONLINE_RATE.m18407a());
        c4455b.m18413a(this.f15495e);
        c4455b.m18428d((int) (System.currentTimeMillis() / 1000));
        c4455b.m18419b((int) (this.f15497g / 1000));
        c4455b.m18424c((int) (this.f15499i / 1000));
        C4509f.m18692a().m18699a(c4455b);
        m18683c();
    }

    Exception m18685a() {
        return this.f15494d;
    }

    public void m18686a(C4461a c4461a) {
        m18689b();
        this.f15498h = SystemClock.elapsedRealtime();
        C4512h.m18709a(0, C4452a.CONN_SUCCESS.m18407a(), c4461a.m18470c(), c4461a.m18477j());
    }

    public void m18687a(C4461a c4461a, int i, Exception exception) {
        if (this.f15493c == 0 && this.f15494d == null) {
            this.f15493c = i;
            this.f15494d = exception;
            C4512h.m18714b(c4461a.m18470c(), exception);
        }
        if (i == 22 && this.f15498h != 0) {
            long f = c4461a.m18473f() - this.f15498h;
            if (f < 0) {
                f = 0;
            }
            this.f15499i = (f + ((long) (C4467j.m18506c() / 2))) + this.f15499i;
            this.f15498h = 0;
        }
        m18689b();
    }

    public void m18688a(C4461a c4461a, Exception exception) {
        C4512h.m18708a(0, C4452a.CHANNEL_CON_FAIL.m18407a(), 1, c4461a.m18470c(), C4321d.m17709d(this.f15491a) ? 1 : 0);
        m18689b();
    }

    public synchronized void m18689b() {
        if (this.f15491a != null) {
            Object g = C4321d.m17712g(this.f15491a);
            boolean d = C4321d.m17709d(this.f15491a);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f15496f > 0) {
                this.f15497g += elapsedRealtime - this.f15496f;
                this.f15496f = 0;
            }
            if (this.f15498h != 0) {
                this.f15499i += elapsedRealtime - this.f15498h;
                this.f15498h = 0;
            }
            if (d) {
                if ((!TextUtils.equals(this.f15495e, g) && this.f15497g > 30000) || this.f15497g > 5400000) {
                    m18684d();
                }
                this.f15495e = g;
                if (this.f15496f == 0) {
                    this.f15496f = elapsedRealtime;
                }
                if (this.f15491a.m18101e()) {
                    this.f15498h = elapsedRealtime;
                }
            }
        }
    }

    public void m18690b(C4461a c4461a) {
        this.f15493c = 0;
        this.f15494d = null;
        this.f15492b = c4461a;
        C4512h.m18707a(0, C4452a.CONN_SUCCESS.m18407a());
    }
}
