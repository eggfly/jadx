package com.igexin.push.p174c;

import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3855g;
import com.igexin.push.p169f.p170b.C3732h;
import com.umeng.analytics.C4156a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.igexin.push.c.p */
public class C3738p extends C3732h {
    public static final int f12613a;
    private static final String f12614b;
    private volatile boolean f12615L;
    private volatile boolean f12616M;
    private C3731j f12617c;
    private Thread f12618e;
    private C3735o f12619f;
    private long f12620g;
    private Lock f12621h;
    private Condition f12622i;
    private final List f12623j;

    static {
        f12614b = C3738p.class.getName();
        f12613a = (int) C3738p.m15348a(20150601);
    }

    public C3738p() {
        super(604800000);
        this.f12620g = -1;
        this.f12621h = new ReentrantLock();
        this.f12622i = this.f12621h.newCondition();
        this.f12623j = new ArrayList(1);
        this.f12615L = true;
        this.o = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m15347A() {
        /*
        r2 = this;
        r0 = r2.f12621h;	 Catch:{ Exception -> 0x001a, all -> 0x0023 }
        r0.lock();	 Catch:{ Exception -> 0x001a, all -> 0x0023 }
        r0 = r2.f12623j;	 Catch:{ Exception -> 0x001a, all -> 0x0023 }
        r1 = new java.lang.Object;	 Catch:{ Exception -> 0x001a, all -> 0x0023 }
        r1.<init>();	 Catch:{ Exception -> 0x001a, all -> 0x0023 }
        r0.add(r1);	 Catch:{ Exception -> 0x001a, all -> 0x0023 }
        r0 = r2.f12622i;	 Catch:{ Exception -> 0x001a, all -> 0x0023 }
        r0.signalAll();	 Catch:{ Exception -> 0x001a, all -> 0x0023 }
        r0 = r2.f12621h;	 Catch:{ Exception -> 0x002c }
        r0.unlock();	 Catch:{ Exception -> 0x002c }
    L_0x0019:
        return;
    L_0x001a:
        r0 = move-exception;
        r0 = r2.f12621h;	 Catch:{ Exception -> 0x0021 }
        r0.unlock();	 Catch:{ Exception -> 0x0021 }
        goto L_0x0019;
    L_0x0021:
        r0 = move-exception;
        goto L_0x0019;
    L_0x0023:
        r0 = move-exception;
        r1 = r2.f12621h;	 Catch:{ Exception -> 0x002a }
        r1.unlock();	 Catch:{ Exception -> 0x002a }
    L_0x0029:
        throw r0;
    L_0x002a:
        r1 = move-exception;
        goto L_0x0029;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.p.A():void");
    }

    private static long m15348a(long j) {
        long j2 = j / 10;
        return ((long) (((Math.random() * ((double) j2)) * 2.0d) - ((double) j2))) + j;
    }

    private void m15359w() {
        this.f12618e = new Thread(new C3739q(this));
        this.f12618e.start();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m15360x() {
        /*
        r3 = this;
        r0 = 1800000; // 0x1b7740 float:2.522337E-39 double:8.89318E-318;
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r3.m14954a(r0, r2);
        r0 = r3.f12618e;
        if (r0 != 0) goto L_0x001d;
    L_0x000c:
        r0 = 1;
        r3.f12615L = r0;
        r0 = r3.f12623j;
        r1 = new java.lang.Object;
        r1.<init>();
        r0.add(r1);
        r3.m15359w();
    L_0x001c:
        return;
    L_0x001d:
        r0 = r3.f12621h;	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r0.lock();	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r0.<init>();	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r1 = f12614b;	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r1 = "|detect ";
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r1 = r3.m15361y();	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r1 = "running, start";
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r0 = r3.f12623j;	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r1 = new java.lang.Object;	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r1.<init>();	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r0.add(r1);	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r0 = r3.f12622i;	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r0.signalAll();	 Catch:{ Exception -> 0x005f, all -> 0x0068 }
        r0 = r3.f12621h;	 Catch:{ Exception -> 0x005d }
        r0.unlock();	 Catch:{ Exception -> 0x005d }
        goto L_0x001c;
    L_0x005d:
        r0 = move-exception;
        goto L_0x001c;
    L_0x005f:
        r0 = move-exception;
        r0 = r3.f12621h;	 Catch:{ Exception -> 0x0066 }
        r0.unlock();	 Catch:{ Exception -> 0x0066 }
        goto L_0x001c;
    L_0x0066:
        r0 = move-exception;
        goto L_0x001c;
    L_0x0068:
        r0 = move-exception;
        r1 = r3.f12621h;	 Catch:{ Exception -> 0x006f }
        r1.unlock();	 Catch:{ Exception -> 0x006f }
    L_0x006e:
        throw r0;
    L_0x006f:
        r1 = move-exception;
        goto L_0x006e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.p.x():void");
    }

    private String m15361y() {
        return this.f12617c.m15284a() + "[" + this.f12617c.m15295c() + "] ";
    }

    private void m15362z() {
        try {
            if (this.f12618e != null) {
                this.f12618e.interrupt();
            }
        } catch (Exception e) {
        }
    }

    protected void m15363a() {
        if (!this.f12616M) {
            m15360x();
        }
    }

    public void m15364a(C3731j c3731j) {
        this.f12617c = c3731j;
    }

    public void m15365a(C3735o c3735o) {
        this.f12619f = c3735o;
    }

    public void m15366a(boolean z) {
        if (z) {
            m15373j();
            C3688a.m15097b(f12614b + "|detect " + m15361y() + "reset delay = 0");
        }
        C3688a.m15097b(f12614b + "|network available : " + C3855g.f12971i);
        if (C3855g.f12971i) {
            if (this.f12620g <= 2000) {
                this.f12620g += 500;
            } else if (this.f12620g <= 15000) {
                this.f12620g += 5000;
            } else if (this.f12620g <= 60000) {
                this.f12620g += 15000;
            } else {
                this.f12620g += 120000;
            }
            if (this.f12620g > C4156a.f13949k) {
                this.f12620g = C4156a.f13949k;
            }
            this.f12620g = C3738p.m15348a(this.f12620g);
            C3688a.m15097b(f12614b + "|detect " + m15361y() + "redetect delay = " + this.f12620g);
        } else {
            this.f12620g = 604800000;
        }
        m14954a(this.f12620g, TimeUnit.MILLISECONDS);
    }

    public final int m15367b() {
        return f12613a;
    }

    public void m15368c() {
        super.m14960c();
    }

    public C3731j c_() {
        return this.f12617c;
    }

    public void m15369d() {
    }

    public void m15370g() {
        C3688a.m15097b(f12614b + "|detect " + m15361y() + "finish, task stop");
        m14954a(604800000, TimeUnit.MILLISECONDS);
    }

    public void m15371h() {
        this.f12616M = true;
        this.f12615L = false;
        this.o = false;
        this.f12619f = null;
        m15347A();
        m14966p();
        m15362z();
    }

    public void m15372i() {
        C3688a.m15097b(f12614b + "|detect " + m15361y() + "start");
        this.f12620g = 50;
        m14954a(this.f12620g, TimeUnit.MILLISECONDS);
    }

    public void m15373j() {
        this.f12620g = 0;
    }
}
