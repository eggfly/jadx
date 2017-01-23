package com.xiaomi.smack;

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import com.antutu.utils.widget.SystemBarTintManager;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.network.C4321d;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.service.C4450y.C4448b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.smack.packet.C4468d;
import com.xiaomi.smack.packet.C4485f;
import com.xiaomi.smack.packet.C4485f.C4484b;
import com.xiaomi.smack.util.C4497h;
import com.xiaomi.stats.C4512h;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.xiaomi.smack.l */
public class C4473l extends C4461a {
    private volatile long f15351A;
    private int f15352B;
    public Exception f15353q;
    protected Socket f15354r;
    String f15355s;
    C4466i f15356t;
    C4464g f15357u;
    private String f15358v;
    private String f15359w;
    private String f15360x;
    private XMPushService f15361y;
    private final String f15362z;

    public C4473l(XMPushService xMPushService, C4403b c4403b) {
        super(xMPushService, c4403b);
        this.f15353q = null;
        this.f15355s = null;
        this.f15358v = null;
        this.f15359w = BuildConfig.FLAVOR;
        this.f15362z = "<pf><p>t:%1$d</p></pf>";
        this.f15351A = 0;
        this.f15361y = xMPushService;
    }

    private void m18539a(C4403b c4403b) {
        m18541a(c4403b.m18165f(), c4403b.m18164e());
    }

    private void m18540a(Exception exception) {
        if (SystemClock.elapsedRealtime() - this.f15351A >= 300000) {
            this.f15352B = 0;
        } else if (C4321d.m17709d(this.f15361y)) {
            this.f15352B++;
            if (this.f15352B >= 2) {
                String c = m18554c();
                C4302b.m17649a("max short conn time reached, sink down current host:" + c);
                m18542a(c, 0, exception);
                this.f15352B = 0;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m18541a(java.lang.String r17, int r18) {
        /*
        r16 = this;
        r4 = 0;
        r2 = 0;
        r0 = r16;
        r0.f15353q = r2;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = "get bucket for host : ";
        r2 = r2.append(r5);
        r0 = r17;
        r2 = r2.append(r0);
        r2 = r2.toString();
        r2 = com.xiaomi.channel.commonutils.logger.C4302b.m17655e(r2);
        r5 = r2.intValue();
        r2 = r16.m18553c(r17);
        r5 = java.lang.Integer.valueOf(r5);
        com.xiaomi.channel.commonutils.logger.C4302b.m17648a(r5);
        if (r2 == 0) goto L_0x003a;
    L_0x0035:
        r3 = 1;
        r3 = r2.m17894a(r3);
    L_0x003a:
        r5 = r3.isEmpty();
        if (r5 == 0) goto L_0x0045;
    L_0x0040:
        r0 = r17;
        r3.add(r0);
    L_0x0045:
        r6 = 0;
        r0 = r16;
        r0.f15351A = r6;
        r0 = r16;
        r5 = r0.f15361y;
        r10 = com.xiaomi.channel.commonutils.network.C4321d.m17712g(r5);
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r12 = r3.iterator();
    L_0x005c:
        r3 = r12.hasNext();
        if (r3 == 0) goto L_0x0240;
    L_0x0062:
        r3 = r12.next();
        r3 = (java.lang.String) r3;
        r14 = java.lang.System.currentTimeMillis();
        r0 = r16;
        r5 = r0.b;
        r5 = r5 + 1;
        r0 = r16;
        r0.b = r5;
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r5.<init>();	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r6 = "begin to connect to ";
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r5 = r5.append(r3);	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r5 = r5.toString();	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        com.xiaomi.channel.commonutils.logger.C4302b.m17649a(r5);	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r5 = r16.m18559v();	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r0 = r16;
        r0.f15354r = r5;	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r0 = r16;
        r5 = r0.f15354r;	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r6 = 0;
        r5.bind(r6);	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r0 = r18;
        r5 = com.xiaomi.network.Host.m17914b(r3, r0);	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r0 = r16;
        r6 = r0.f15354r;	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r7 = 8000; // 0x1f40 float:1.121E-41 double:3.9525E-320;
        r6.connect(r5, r7);	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r5 = "tcp connected";
        com.xiaomi.channel.commonutils.logger.C4302b.m17649a(r5);	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r0 = r16;
        r5 = r0.f15354r;	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r6 = 1;
        r5.setTcpNoDelay(r6);	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r0 = r16;
        r0.f15360x = r3;	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r16.m18543y();	 Catch:{ IOException -> 0x0117, p -> 0x0183, Throwable -> 0x01ed }
        r9 = 1;
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
        r4 = r4 - r14;
        r0 = r16;
        r0.c = r4;	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
        r0 = r16;
        r0.m = r10;	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
        if (r2 == 0) goto L_0x00d8;
    L_0x00cf:
        r0 = r16;
        r4 = r0.c;	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
        r6 = 0;
        r2.m17906b(r3, r4, r6);	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
    L_0x00d8:
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
        r0 = r16;
        r0.f15351A = r4;	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
        r4.<init>();	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
        r5 = "connected to ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
        r4 = r4.append(r3);	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
        r5 = " in ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
        r0 = r16;
        r6 = r0.c;	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
        r4 = r4.append(r6);	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
        com.xiaomi.channel.commonutils.logger.C4302b.m17649a(r4);	 Catch:{ IOException -> 0x023a, p -> 0x0237, Throwable -> 0x0233 }
    L_0x0104:
        r2 = com.xiaomi.network.HostManager.getInstance();
        r2.persist();
        if (r9 != 0) goto L_0x0230;
    L_0x010d:
        r2 = new com.xiaomi.smack.p;
        r3 = r11.toString();
        r2.<init>(r3);
        throw r2;
    L_0x0117:
        r8 = move-exception;
        r9 = r4;
    L_0x0119:
        if (r2 == 0) goto L_0x0125;
    L_0x011b:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0231 }
        r4 = r4 - r14;
        r6 = 0;
        r2.m17907b(r3, r4, r6, r8);	 Catch:{ all -> 0x0231 }
    L_0x0125:
        r0 = r16;
        r0.f15353q = r8;	 Catch:{ all -> 0x0231 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0231 }
        r4.<init>();	 Catch:{ all -> 0x0231 }
        r5 = "SMACK: Could not connect to:";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0231 }
        r4 = r4.append(r3);	 Catch:{ all -> 0x0231 }
        r4 = r4.toString();	 Catch:{ all -> 0x0231 }
        com.xiaomi.channel.commonutils.logger.C4302b.m17654d(r4);	 Catch:{ all -> 0x0231 }
        r4 = "SMACK: Could not connect to ";
        r4 = r11.append(r4);	 Catch:{ all -> 0x0231 }
        r4 = r4.append(r3);	 Catch:{ all -> 0x0231 }
        r5 = " port:";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0231 }
        r0 = r18;
        r4 = r4.append(r0);	 Catch:{ all -> 0x0231 }
        r5 = " ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0231 }
        r5 = r8.getMessage();	 Catch:{ all -> 0x0231 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0231 }
        r5 = "\n";
        r4.append(r5);	 Catch:{ all -> 0x0231 }
        if (r9 != 0) goto L_0x017f;
    L_0x016a:
        r0 = r16;
        r4 = r0.f15353q;
        com.xiaomi.stats.C4512h.m18712a(r3, r4);
        r0 = r16;
        r3 = r0.f15361y;
        r3 = com.xiaomi.channel.commonutils.network.C4321d.m17712g(r3);
        r3 = android.text.TextUtils.equals(r10, r3);
        if (r3 == 0) goto L_0x0104;
    L_0x017f:
        r3 = r9;
    L_0x0180:
        r4 = r3;
        goto L_0x005c;
    L_0x0183:
        r8 = move-exception;
        r9 = r4;
    L_0x0185:
        if (r2 == 0) goto L_0x0191;
    L_0x0187:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0231 }
        r4 = r4 - r14;
        r6 = 0;
        r2.m17907b(r3, r4, r6, r8);	 Catch:{ all -> 0x0231 }
    L_0x0191:
        r0 = r16;
        r0.f15353q = r8;	 Catch:{ all -> 0x0231 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0231 }
        r4.<init>();	 Catch:{ all -> 0x0231 }
        r5 = "SMACK: Could not connect to:";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0231 }
        r4 = r4.append(r3);	 Catch:{ all -> 0x0231 }
        r4 = r4.toString();	 Catch:{ all -> 0x0231 }
        com.xiaomi.channel.commonutils.logger.C4302b.m17654d(r4);	 Catch:{ all -> 0x0231 }
        r4 = "SMACK: Could not connect to ";
        r4 = r11.append(r4);	 Catch:{ all -> 0x0231 }
        r4 = r4.append(r3);	 Catch:{ all -> 0x0231 }
        r5 = " port:";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0231 }
        r0 = r18;
        r4 = r4.append(r0);	 Catch:{ all -> 0x0231 }
        r5 = " ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0231 }
        r5 = r8.getMessage();	 Catch:{ all -> 0x0231 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0231 }
        r5 = "\n";
        r4.append(r5);	 Catch:{ all -> 0x0231 }
        if (r9 != 0) goto L_0x017f;
    L_0x01d6:
        r0 = r16;
        r4 = r0.f15353q;
        com.xiaomi.stats.C4512h.m18712a(r3, r4);
        r0 = r16;
        r3 = r0.f15361y;
        r3 = com.xiaomi.channel.commonutils.network.C4321d.m17712g(r3);
        r3 = android.text.TextUtils.equals(r10, r3);
        if (r3 != 0) goto L_0x017f;
    L_0x01eb:
        goto L_0x0104;
    L_0x01ed:
        r5 = move-exception;
    L_0x01ee:
        r6 = new java.lang.Exception;	 Catch:{ all -> 0x0216 }
        r7 = "abnormal exception";
        r6.<init>(r7, r5);	 Catch:{ all -> 0x0216 }
        r0 = r16;
        r0.f15353q = r6;	 Catch:{ all -> 0x0216 }
        com.xiaomi.channel.commonutils.logger.C4302b.m17651a(r5);	 Catch:{ all -> 0x0216 }
        if (r4 != 0) goto L_0x023d;
    L_0x01fe:
        r0 = r16;
        r5 = r0.f15353q;
        com.xiaomi.stats.C4512h.m18712a(r3, r5);
        r0 = r16;
        r3 = r0.f15361y;
        r3 = com.xiaomi.channel.commonutils.network.C4321d.m17712g(r3);
        r3 = android.text.TextUtils.equals(r10, r3);
        if (r3 != 0) goto L_0x023d;
    L_0x0213:
        r9 = r4;
        goto L_0x0104;
    L_0x0216:
        r2 = move-exception;
        r9 = r4;
    L_0x0218:
        if (r9 != 0) goto L_0x022f;
    L_0x021a:
        r0 = r16;
        r4 = r0.f15353q;
        com.xiaomi.stats.C4512h.m18712a(r3, r4);
        r0 = r16;
        r3 = r0.f15361y;
        r3 = com.xiaomi.channel.commonutils.network.C4321d.m17712g(r3);
        r3 = android.text.TextUtils.equals(r10, r3);
        if (r3 == 0) goto L_0x0104;
    L_0x022f:
        throw r2;
    L_0x0230:
        return;
    L_0x0231:
        r2 = move-exception;
        goto L_0x0218;
    L_0x0233:
        r4 = move-exception;
        r5 = r4;
        r4 = r9;
        goto L_0x01ee;
    L_0x0237:
        r8 = move-exception;
        goto L_0x0185;
    L_0x023a:
        r8 = move-exception;
        goto L_0x0119;
    L_0x023d:
        r3 = r4;
        goto L_0x0180;
    L_0x0240:
        r9 = r4;
        goto L_0x0104;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.l.a(java.lang.String, int):void");
    }

    private void m18542a(String str, long j, Exception exception) {
        Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(C4403b.m18156b(), false);
        if (fallbacksByHost != null) {
            fallbacksByHost.m17907b(str, j, 0, exception);
            HostManager.getInstance().persist();
        }
    }

    private synchronized void m18543y() {
        m18544z();
        this.f15356t = new C4466i(this);
        this.f15357u = new C4464g(this);
        if (this.o.m18166g()) {
            m18459a(this.i.m17752c(), null);
            if (this.i.m17753d() != null) {
                m18468b(this.i.m17753d(), null);
            }
        }
        this.p.m18078a(10);
        this.p.m18104h();
        C4302b.m17649a("begin to openstream...");
        this.f15356t.m18500c();
        this.f15357u.m18493b();
    }

    private void m18544z() {
        try {
            this.j = new BufferedReader(new InputStreamReader(this.f15354r.getInputStream(), HttpRequest.f14548a), SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
            this.k = new BufferedWriter(new OutputStreamWriter(this.f15354r.getOutputStream(), HttpRequest.f14548a));
            if (this.j != null && this.k != null) {
                m18474g();
            }
        } catch (Throwable e) {
            throw new C4477p("Error to init reader and writer", e);
        }
    }

    public void m18545a(int i, Exception exception) {
        this.f15361y.m18080a(new C4475n(this, 2, i, exception));
    }

    public synchronized void m18546a(C4448b c4448b) {
        new C4472k().m18537a(c4448b, m18556s(), this);
    }

    public void m18547a(C4468d c4468d) {
        if (this.f15356t != null) {
            this.f15356t.m18498a(c4468d);
            return;
        }
        throw new C4477p("the writer is null.");
    }

    public void m18548a(C4485f c4485f, int i, Exception exception) {
        m18551b(c4485f, i, exception);
        if ((exception != null || i == 18) && this.f15351A != 0) {
            m18540a(exception);
        }
    }

    public synchronized void m18549a(String str, String str2) {
        C4468d c4485f = new C4485f(C4484b.unavailable);
        c4485f.m18518l(str);
        c4485f.m18522n(str2);
        if (this.f15356t != null) {
            this.f15356t.m18498a(c4485f);
        }
    }

    public void m18550a(C4468d[] c4468dArr) {
        for (C4468d a : c4468dArr) {
            m18547a(a);
        }
    }

    protected synchronized void m18551b(C4485f c4485f, int i, Exception exception) {
        if (m18482o() != 2) {
            m18456a(2, i, exception);
            this.l = BuildConfig.FLAVOR;
            if (this.f15357u != null) {
                this.f15357u.m18494c();
                this.f15357u.m18495d();
                this.f15357u = null;
            }
            if (this.f15356t != null) {
                try {
                    this.f15356t.m18499b();
                } catch (Throwable e) {
                    C4302b.m17651a(e);
                }
                this.f15356t.m18497a();
                this.f15356t = null;
            }
            try {
                this.f15354r.close();
            } catch (Throwable th) {
            }
            if (this.j != null) {
                try {
                    this.j.close();
                } catch (Throwable th2) {
                }
                this.j = null;
            }
            if (this.k != null) {
                try {
                    this.k.close();
                } catch (Throwable th3) {
                }
                this.k = null;
            }
            this.d = 0;
            this.e = 0;
        }
    }

    public void m18552b(String str) {
        this.f15359w = str;
    }

    Fallback m18553c(String str) {
        Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(str, false);
        if (!fallbacksByHost.m17908b()) {
            C4497h.m18655a(new C4476o(this, str));
        }
        this.f = 0;
        try {
            byte[] address = InetAddress.getByName(fallbacksByHost.f14845f).getAddress();
            this.f = address[0] & MotionEventCompat.ACTION_MASK;
            this.f |= (address[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
            this.f |= (address[2] << 16) & 16711680;
            this.f = ((address[3] << 24) & SystemBarTintManager.DEFAULT_TINT_COLOR) | this.f;
        } catch (UnknownHostException e) {
        }
        return fallbacksByHost;
    }

    public String m18554c() {
        return this.f15360x;
    }

    public void m18555n() {
        if (this.f15356t != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f15356t.m18501d();
            this.f15361y.m18081a(new C4474m(this, 13, currentTimeMillis), 10000);
            return;
        }
        throw new C4477p("the packetwriter is null.");
    }

    public String m18556s() {
        return this.l;
    }

    public synchronized void m18557t() {
        try {
            if (m18476i() || m18475h()) {
                C4302b.m17649a("WARNING: current xmpp has connected");
            } else {
                m18456a(0, 0, null);
                m18539a(this.o);
            }
        } catch (Throwable e) {
            throw new C4477p(e);
        }
    }

    public String m18558u() {
        String str = BuildConfig.FLAVOR;
        String c = C4512h.m18715c();
        c = c != null ? "<q>" + c + "</q>" : BuildConfig.FLAVOR;
        return String.format(this.f15359w, new Object[]{str, c});
    }

    public Socket m18559v() {
        return new Socket();
    }

    public void m18560w() {
        this.d = SystemClock.elapsedRealtime();
    }

    public void m18561x() {
        this.e = SystemClock.elapsedRealtime();
    }
}
