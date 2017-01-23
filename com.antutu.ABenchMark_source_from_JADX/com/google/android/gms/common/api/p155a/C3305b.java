package com.google.android.gms.common.api.p155a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.C3079e;
import com.google.android.gms.common.api.C3304d;
import com.google.android.gms.common.api.C3304d.C3300a;
import com.google.android.gms.common.api.C3386f;
import com.google.android.gms.common.api.C3427c;
import com.google.android.gms.common.api.C3442g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C3497o;
import com.google.android.gms.common.internal.C3512u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.api.a.b */
public abstract class C3305b<R extends C3386f> extends C3304d<R> {
    protected final C3393a<R> f11510a;
    private final Object f11511b;
    private final WeakReference<C3427c> f11512c;
    private final CountDownLatch f11513d;
    private final ArrayList<C3300a> f11514e;
    private C3442g<? super R> f11515f;
    private volatile R f11516g;
    private volatile boolean f11517h;
    private boolean f11518i;
    private boolean f11519j;
    private boolean f11520k;
    private C3497o f11521l;
    private Integer f11522m;
    private volatile C3443s<R> f11523n;

    /* renamed from: com.google.android.gms.common.api.a.b.a */
    public static class C3393a<R extends C3386f> extends Handler {
        public C3393a() {
            this(Looper.getMainLooper());
        }

        public C3393a(Looper looper) {
            super(looper);
        }

        public void m13972a() {
            removeMessages(2);
        }

        public void m13973a(C3442g<? super R> c3442g, R r) {
            sendMessage(obtainMessage(1, new Pair(c3442g, r)));
        }

        protected void m13974b(C3442g<? super R> c3442g, R r) {
            try {
                c3442g.m14222a(r);
            } catch (RuntimeException e) {
                C3305b.m13438b((C3386f) r);
                throw e;
            }
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    Pair pair = (Pair) message.obj;
                    m13974b((C3442g) pair.first, (C3386f) pair.second);
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    ((C3305b) message.obj).m13445b(Status.f11824d);
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    protected C3305b(C3427c c3427c) {
        this.f11511b = new Object();
        this.f11513d = new CountDownLatch(1);
        this.f11514e = new ArrayList();
        this.f11510a = new C3393a(c3427c != null ? c3427c.m14129a() : Looper.getMainLooper());
        this.f11512c = new WeakReference(c3427c);
    }

    public static void m13438b(C3386f c3386f) {
        if (c3386f instanceof C3079e) {
            try {
                ((C3079e) c3386f).m12076a();
            } catch (Throwable e) {
                Log.w("BasePendingResult", "Unable to release " + c3386f, e);
            }
        }
    }

    private void m13439c(R r) {
        this.f11516g = r;
        this.f11521l = null;
        this.f11513d.countDown();
        Status a = this.f11516g.m13957a();
        if (this.f11515f != null) {
            this.f11510a.m13972a();
            if (!this.f11518i) {
                this.f11510a.m13973a(this.f11515f, m13440i());
            }
        }
        Iterator it = this.f11514e.iterator();
        while (it.hasNext()) {
            ((C3300a) it.next()).m13433a(a);
        }
        this.f11514e.clear();
    }

    private R m13440i() {
        R r;
        boolean z = true;
        synchronized (this.f11511b) {
            if (this.f11517h) {
                z = false;
            }
            C3512u.m14585a(z, (Object) "Result has already been consumed.");
            C3512u.m14585a(m13448e(), (Object) "Result is not ready.");
            r = this.f11516g;
            this.f11516g = null;
            this.f11515f = null;
            this.f11517h = true;
        }
        m13447d();
        return r;
    }

    public Integer m13441a() {
        return this.f11522m;
    }

    public final void m13442a(C3300a c3300a) {
        boolean z = true;
        C3512u.m14585a(!this.f11517h, (Object) "Result has already been consumed.");
        if (c3300a == null) {
            z = false;
        }
        C3512u.m14589b(z, "Callback cannot be null.");
        synchronized (this.f11511b) {
            if (m13448e()) {
                c3300a.m13433a(this.f11516g.m13957a());
            } else {
                this.f11514e.add(c3300a);
            }
        }
    }

    public final void m13443a(R r) {
        boolean z = true;
        synchronized (this.f11511b) {
            if (this.f11519j || this.f11518i) {
                C3305b.m13438b((C3386f) r);
                return;
            }
            C3512u.m14585a(!m13448e(), (Object) "Results have already been set");
            if (this.f11517h) {
                z = false;
            }
            C3512u.m14585a(z, (Object) "Result has already been consumed");
            m13439c((C3386f) r);
        }
    }

    public final void m13444a(C3442g<? super R> c3442g) {
        boolean z = true;
        C3512u.m14585a(!this.f11517h, (Object) "Result has already been consumed.");
        synchronized (this.f11511b) {
            if (this.f11523n != null) {
                z = false;
            }
            C3512u.m14585a(z, (Object) "Cannot set callbacks if then() has been called.");
            if (m13451h()) {
            } else if (!this.f11520k || (((C3427c) this.f11512c.get()) != null && (c3442g instanceof C3443s))) {
                if (m13448e()) {
                    this.f11510a.m13973a(c3442g, m13440i());
                } else {
                    this.f11515f = c3442g;
                }
            } else {
                m13449f();
            }
        }
    }

    public final void m13445b(Status status) {
        synchronized (this.f11511b) {
            if (!m13448e()) {
                m13443a(m13446c(status));
                this.f11519j = true;
            }
        }
    }

    protected abstract R m13446c(Status status);

    protected void m13447d() {
    }

    public final boolean m13448e() {
        return this.f11513d.getCount() == 0;
    }

    public void m13449f() {
        synchronized (this.f11511b) {
            if (this.f11518i || this.f11517h) {
                return;
            }
            if (this.f11521l != null) {
                try {
                    this.f11521l.m14419a();
                } catch (RemoteException e) {
                }
            }
            C3305b.m13438b(this.f11516g);
            this.f11515f = null;
            this.f11518i = true;
            m13439c(m13446c(Status.f11825e));
        }
    }

    public void m13450g() {
        synchronized (this.f11511b) {
            if (((C3427c) this.f11512c.get()) == null) {
                m13449f();
                return;
            }
            if (this.f11515f == null || (this.f11515f instanceof C3443s)) {
                this.f11520k = true;
            } else {
                m13449f();
            }
        }
    }

    public boolean m13451h() {
        boolean z;
        synchronized (this.f11511b) {
            z = this.f11518i;
        }
        return z;
    }
}
