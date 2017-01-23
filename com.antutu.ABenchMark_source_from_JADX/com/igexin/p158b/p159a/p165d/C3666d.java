package com.igexin.p158b.p159a.p165d;

import com.igexin.p158b.p159a.p165d.p166a.C3663a;
import com.igexin.p158b.p159a.p165d.p166a.C3691d;
import com.igexin.p158b.p159a.p165d.p166a.C3692e;
import com.igexin.p158b.p159a.p165d.p166a.C3693g;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.igexin.b.a.d.d */
public abstract class C3666d extends C3665a implements C3663a {
    protected static C3684e f12327E;
    public int f12328A;
    public Exception f12329B;
    public Object f12330C;
    public C3693g f12331D;
    protected final ReentrantLock f12332F;
    protected final Condition f12333G;
    Thread f12334H;
    protected volatile boolean f12335I;
    int f12336J;
    protected C3691d f12337K;
    private byte f12338a;
    protected volatile boolean f12339k;
    protected volatile boolean f12340m;
    protected volatile boolean f12341n;
    protected volatile boolean f12342o;
    protected volatile boolean f12343p;
    protected volatile boolean f12344q;
    protected volatile boolean f12345r;
    protected volatile boolean f12346s;
    protected volatile boolean f12347t;
    protected volatile long f12348u;
    volatile int f12349v;
    public long f12350w;
    public int f12351x;
    public int f12352y;
    public int f12353z;

    public C3666d(int i) {
        this(i, null);
    }

    public C3666d(int i, C3691d c3691d) {
        this.f12353z = i;
        this.f12337K = c3691d;
        this.f12332F = new ReentrantLock();
        this.f12333G = this.f12332F.newCondition();
    }

    public final int m14954a(long j, TimeUnit timeUnit) {
        if (j <= 0) {
            return 0;
        }
        switch (f12327E.f12419k.m15112a(this, j, timeUnit)) {
            case TnetStatusCode.EASY_REQ_STAGE_SEND_FAIL /*-2*/:
                return -2;
            case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                this.f12348u = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(j, timeUnit);
                return -1;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return 1;
            default:
                return 0;
        }
    }

    public long m14955a(TimeUnit timeUnit) {
        return timeUnit.convert(m14965o(), TimeUnit.MILLISECONDS);
    }

    public final void m14956a(int i) {
        this.f12338a = (byte) (this.f12338a & 15);
        this.f12338a = (byte) (this.f12338a | ((i & 15) << 4));
    }

    public final void m14957a(int i, C3693g c3693g) {
        if (i < 0) {
            throw new IllegalArgumentException("second must > 0");
        }
        this.f12352y = i;
        this.f12331D = c3693g;
    }

    public final void m14958a(C3691d c3691d) {
        this.f12337K = c3691d;
    }

    public void a_() {
        this.f12334H = Thread.currentThread();
        this.f12343p = true;
    }

    public final void m14959b(long j) {
        this.f12350w = j;
    }

    public void m14960c() {
        if (this.f12339k || this.f12340m) {
            m14963f();
        }
    }

    public void m14961d() {
        this.f12346s = true;
    }

    protected abstract void m14962e();

    public void m14963f() {
        this.f12330C = null;
        this.f12329B = null;
        this.f12334H = null;
    }

    final void m14964n() {
        this.f12336J++;
        this.f12336J &= 1090519038;
    }

    long m14965o() {
        return this.f12348u - System.currentTimeMillis();
    }

    public final void m14966p() {
        this.f12339k = true;
    }

    public final boolean m14967q() {
        return this.f12341n;
    }

    public final boolean m14968r() {
        return this.f12340m;
    }

    protected void m14969s() {
    }

    public final void m14970t() {
        this.f12340m = true;
    }

    protected void m14971u() {
        if (!this.f12342o && !this.f12344q && !this.f12345r) {
            this.f12339k = true;
            this.f12343p = false;
        } else if (this.f12344q && !this.f12339k) {
            this.f12343p = false;
        } else if (this.f12342o && !this.f12341n && !this.f12339k) {
            this.f12343p = false;
        }
    }

    protected void m14972v() {
        if (this.f12337K != null) {
            this.f12337K.m15104a(C3692e.error);
        }
    }
}
