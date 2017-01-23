package com.igexin.push.p174c;

import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.config.C3754m;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C3855g;
import com.igexin.push.core.p176a.C3777e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.c.a */
public class C3722a {
    private static final String f12546f;
    public volatile C3725d f12547a;
    public AtomicBoolean f12548b;
    protected int f12549c;
    protected volatile long f12550d;
    protected volatile long f12551e;
    private int f12552g;
    private int f12553h;
    private int f12554i;
    private C3731j f12555j;
    private final List f12556k;
    private final List f12557l;
    private final Object f12558m;
    private final Object f12559n;
    private int f12560o;
    private final Comparator f12561p;

    static {
        f12546f = C3722a.class.getName();
    }

    public C3722a() {
        this.f12556k = new ArrayList();
        this.f12557l = new ArrayList();
        this.f12558m = new Object();
        this.f12559n = new Object();
        this.f12547a = C3725d.NORMAL;
        this.f12560o = 0;
        this.f12548b = new AtomicBoolean(false);
        this.f12561p = new C3723b(this);
    }

    private String m15253a(boolean z) {
        String b;
        synchronized (this.f12558m) {
            this.f12552g = this.f12552g >= this.f12557l.size() ? 0 : this.f12552g;
            this.f12555j = (C3731j) this.f12557l.get(this.f12552g);
            b = this.f12555j.m15290b(z);
        }
        return b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m15254a(com.igexin.push.p174c.C3725d r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0080 }
        r0.<init>();	 Catch:{ all -> 0x0080 }
        r1 = f12546f;	 Catch:{ all -> 0x0080 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0080 }
        r1 = "|set domain type = ";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0080 }
        r0 = r0.append(r3);	 Catch:{ all -> 0x0080 }
        r0 = r0.toString();	 Catch:{ all -> 0x0080 }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);	 Catch:{ all -> 0x0080 }
        r0 = com.igexin.push.config.C3754m.f12662f;	 Catch:{ all -> 0x0080 }
        if (r0 == 0) goto L_0x0041;
    L_0x0021:
        r0 = r2.f12547a;	 Catch:{ all -> 0x0080 }
        if (r0 == r3) goto L_0x0029;
    L_0x0025:
        r0 = 0;
        r2.m15258a(r0);	 Catch:{ all -> 0x0080 }
    L_0x0029:
        r0 = com.igexin.push.p174c.C3724c.f12563a;	 Catch:{ all -> 0x0080 }
        r1 = r3.ordinal();	 Catch:{ all -> 0x0080 }
        r0 = r0[r1];	 Catch:{ all -> 0x0080 }
        switch(r0) {
            case 1: goto L_0x004a;
            case 2: goto L_0x0083;
            case 3: goto L_0x0043;
            default: goto L_0x0034;
        };	 Catch:{ all -> 0x0080 }
    L_0x0034:
        r2.f12547a = r3;	 Catch:{ all -> 0x0080 }
        r0 = com.igexin.push.p174c.C3730i.m15273a();	 Catch:{ all -> 0x0080 }
        r0 = r0.m15281i();	 Catch:{ all -> 0x0080 }
        r0.m15337p();	 Catch:{ all -> 0x0080 }
    L_0x0041:
        monitor-exit(r2);
        return;
    L_0x0043:
        r0 = r2.f12547a;	 Catch:{ all -> 0x0080 }
        if (r0 == r3) goto L_0x004a;
    L_0x0047:
        r0 = 0;
        r2.f12560o = r0;	 Catch:{ all -> 0x0080 }
    L_0x004a:
        r0 = 0;
        r2.f12552g = r0;	 Catch:{ all -> 0x0080 }
        r0 = 1;
        r0 = r2.m15253a(r0);	 Catch:{ all -> 0x0080 }
        com.igexin.push.config.SDKUrlConfig.setCmAddress(r0);	 Catch:{ all -> 0x0080 }
        r0 = com.igexin.push.p174c.C3725d.NORMAL;	 Catch:{ all -> 0x0080 }
        if (r3 != r0) goto L_0x005f;
    L_0x0059:
        r0 = r2.f12548b;	 Catch:{ all -> 0x0080 }
        r1 = 0;
        r0.set(r1);	 Catch:{ all -> 0x0080 }
    L_0x005f:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0080 }
        r0.<init>();	 Catch:{ all -> 0x0080 }
        r1 = f12546f;	 Catch:{ all -> 0x0080 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0080 }
        r1 = "|set domain type normal cm = ";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0080 }
        r1 = com.igexin.push.config.SDKUrlConfig.getCmAddress();	 Catch:{ all -> 0x0080 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0080 }
        r0 = r0.toString();	 Catch:{ all -> 0x0080 }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);	 Catch:{ all -> 0x0080 }
        goto L_0x0034;
    L_0x0080:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
    L_0x0083:
        r0 = r2.f12548b;	 Catch:{ all -> 0x0080 }
        r1 = 1;
        r0.set(r1);	 Catch:{ all -> 0x0080 }
        r0 = r2.f12547a;	 Catch:{ all -> 0x0080 }
        if (r0 == r3) goto L_0x0093;
    L_0x008d:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0080 }
        r2.f12550d = r0;	 Catch:{ all -> 0x0080 }
    L_0x0093:
        r0 = com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK;	 Catch:{ all -> 0x0080 }
        r1 = 0;
        r0 = r0[r1];	 Catch:{ all -> 0x0080 }
        com.igexin.push.config.SDKUrlConfig.setCmAddress(r0);	 Catch:{ all -> 0x0080 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0080 }
        r0.<init>();	 Catch:{ all -> 0x0080 }
        r1 = f12546f;	 Catch:{ all -> 0x0080 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0080 }
        r1 = "|set domain type backup cm = ";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0080 }
        r1 = com.igexin.push.config.SDKUrlConfig.getCmAddress();	 Catch:{ all -> 0x0080 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0080 }
        r0 = r0.toString();	 Catch:{ all -> 0x0080 }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);	 Catch:{ all -> 0x0080 }
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.a.a(com.igexin.push.c.d):void");
    }

    private String m15255b(boolean z) {
        try {
            synchronized (this.f12559n) {
                if (this.f12556k.isEmpty()) {
                    C3688a.m15097b(f12546f + "cm list size = 0");
                    this.f12554i = 0;
                    this.f12553h = 0;
                    return null;
                }
                C3688a.m15097b(f12546f + "cm try = " + this.f12554i + " times");
                if (this.f12554i >= this.f12556k.size() * 3) {
                    C3688a.m15097b(f12546f + "cm invalid");
                    this.f12554i = 0;
                    this.f12553h = 0;
                    this.f12556k.clear();
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator it = this.f12556k.iterator();
                while (it.hasNext()) {
                    C3726e c3726e = (C3726e) it.next();
                    if (c3726e.f12570b < currentTimeMillis) {
                        C3688a.m15097b(f12546f + "|add[" + c3726e.f12569a + "] outDate");
                        it.remove();
                    }
                }
                if (this.f12556k.isEmpty()) {
                    return null;
                }
                this.f12553h = this.f12553h >= this.f12556k.size() ? 0 : this.f12553h;
                String str = ((C3726e) this.f12556k.get(this.f12553h)).f12569a;
                this.f12553h++;
                if (z) {
                    this.f12554i++;
                }
                return str;
            }
        } catch (Exception e) {
            C3688a.m15097b(f12546f + "|" + e.toString());
            return null;
        }
    }

    private void m15256k() {
        C3688a.m15097b(f12546f + "|before disconnect, type = " + this.f12547a);
        switch (C3724c.f12563a[this.f12547a.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                if (System.currentTimeMillis() - this.f12551e > 172800000 && this.f12549c > C3754m.f12648B) {
                    m15254a(C3725d.BACKUP);
                }
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                if (System.currentTimeMillis() - this.f12550d > C3754m.f12682z) {
                    m15254a(C3725d.TRY_NORMAL);
                }
            default:
        }
    }

    public void m15257a() {
        try {
            boolean z = !C3777e.m15491a().m15507C();
            String b = m15255b(z);
            C3688a.m15097b(f12546f + "|get from cm = " + b);
            if (b == null) {
                if (C3754m.f12662f && this.f12547a == C3725d.BACKUP) {
                    this.f12552g = this.f12552g >= SDKUrlConfig.XFR_ADDRESS_BAK.length ? 0 : this.f12552g;
                    b = SDKUrlConfig.XFR_ADDRESS_BAK[this.f12552g];
                    this.f12552g++;
                } else {
                    if (!(this.f12555j == null || this.f12555j.m15298f())) {
                        this.f12552g++;
                    }
                    b = m15253a(z);
                }
            }
            if (!SDKUrlConfig.getCmAddress().equals(b)) {
                C3688a.m15097b(f12546f + "|address changed : form [" + SDKUrlConfig.getCmAddress() + "] to [" + b + "]");
            }
            SDKUrlConfig.setCmAddress(b);
        } catch (Exception e) {
            e.printStackTrace();
            C3688a.m15097b(f12546f + "|switch address|" + e.toString());
        }
    }

    public void m15258a(List list) {
        synchronized (this.f12559n) {
            this.f12553h = 0;
            this.f12554i = 0;
            this.f12556k.clear();
            if (list != null) {
                this.f12556k.addAll(list);
                C3688a.m15097b(f12546f + "|set cm list: " + list.toString());
            }
        }
    }

    public synchronized void m15259b() {
        C3688a.m15097b(f12546f + "|login or register success, cmConncetTryCnt = 0");
        this.f12554i = 0;
        if (this.f12555j != null) {
            this.f12555j.m15300h();
        }
    }

    public void m15260b(List list) {
        synchronized (this.f12558m) {
            this.f12557l.clear();
            this.f12557l.addAll(list);
            Collections.sort(this.f12557l, this.f12561p);
        }
    }

    public synchronized void m15261c() {
        this.f12549c++;
        C3688a.m15097b(f12546f + "|before login success, loginFailedlCnt = " + this.f12549c);
    }

    public void m15262d() {
        synchronized (this.f12558m) {
            this.f12552g = 0;
            Collections.sort(this.f12557l, this.f12561p);
            try {
                int length = SDKUrlConfig.getXfrAddress().length;
                if (length >= 3) {
                    for (int i = 0; i < this.f12557l.size(); i++) {
                        ((C3731j) this.f12557l.get(i)).m15292b(length - i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                C3688a.m15097b(f12546f + "|" + e.toString());
            }
        }
    }

    public void m15263e() {
        C3688a.m15097b(f12546f + "|detect success, current type = " + this.f12547a);
        if (this.f12547a == C3725d.BACKUP) {
            m15254a(C3725d.TRY_NORMAL);
            C3777e.m15491a().m15548c(true);
        }
    }

    public void m15264f() {
        C3688a.m15097b(f12546f + "|detect max cnt ,set type = backup");
        m15254a(C3725d.BACKUP);
        C3777e.m15491a().m15548c(true);
    }

    public void m15265g() {
        switch (C3724c.f12563a[this.f12547a.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                if (System.currentTimeMillis() - this.f12550d > C3754m.f12682z) {
                    m15254a(C3725d.TRY_NORMAL);
                }
            default:
        }
    }

    public void m15266h() {
        if (this.f12547a != C3725d.BACKUP) {
            this.f12549c = 0;
        }
        switch (C3724c.f12563a[this.f12547a.ordinal()]) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f12551e = System.currentTimeMillis();
                C3730i.m15273a().m15281i().m15337p();
                this.f12548b.set(false);
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                m15254a(C3725d.NORMAL);
                this.f12548b.set(false);
            default:
        }
    }

    public void m15267i() {
        m15256k();
        if (C3855g.f12976n && this.f12547a != C3725d.BACKUP) {
            this.f12551e = System.currentTimeMillis();
            C3730i.m15273a().m15281i().m15337p();
        }
        switch (C3724c.f12563a[this.f12547a.ordinal()]) {
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                int i = this.f12560o + 1;
                this.f12560o = i;
                if (i >= 10) {
                    this.f12549c = 0;
                    this.f12550d = System.currentTimeMillis();
                    m15254a(C3725d.BACKUP);
                }
            default:
        }
    }

    public boolean m15268j() {
        return this.f12547a == C3725d.NORMAL;
    }
}
