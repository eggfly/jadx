package com.igexin.p158b.p159a.p161b.p162a.p163a;

import android.os.Message;
import com.igexin.p158b.p159a.p161b.C3683b;
import com.igexin.p158b.p159a.p161b.C3685c;
import com.igexin.p158b.p159a.p161b.C3686d;
import com.igexin.p158b.p159a.p165d.C3684e;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.p176a.C3777e;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.igexin.b.a.b.a.a.d */
public final class C3671d {
    private static final String f12369e;
    private static C3671d f12370m;
    private static final Object f12371n;
    public Lock f12372a;
    public Condition f12373b;
    public ConcurrentLinkedQueue f12374c;
    public List f12375d;
    private C3683b f12376f;
    private C3686d f12377g;
    private Socket f12378h;
    private C3677j f12379i;
    private C3679l f12380j;
    private C3670c f12381k;
    private boolean f12382l;
    private C3676i f12383o;
    private long f12384p;
    private final Comparator f12385q;

    static {
        f12369e = C3671d.class.getName();
        f12371n = new Object();
    }

    private C3671d() {
        this.f12372a = new ReentrantLock();
        this.f12373b = this.f12372a.newCondition();
        this.f12374c = new ConcurrentLinkedQueue();
        this.f12375d = new ArrayList();
        this.f12385q = new C3675h(this);
        this.f12383o = new C3676i(this);
    }

    public static synchronized C3671d m14981a() {
        C3671d c3671d;
        synchronized (C3671d.class) {
            if (f12370m == null) {
                f12370m = new C3671d();
            }
            c3671d = f12370m;
        }
        return c3671d;
    }

    private void m14984a(Socket socket) {
        try {
            if (!this.f12381k.m14977g()) {
                this.f12378h = socket;
                this.f12377g = new C3686d();
                m14989b(socket);
                m14990c(socket);
            }
        } catch (Exception e) {
            C3688a.m15097b(f12369e + "|" + e.toString());
            m15011b();
        }
    }

    private void m14988b(C3678k c3678k) {
        if (c3678k.y <= 0 || c3678k.D == null) {
            c3678k.m14966p();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        c3678k.m14959b(currentTimeMillis);
        synchronized (f12371n) {
            this.f12375d.add(c3678k);
            Collections.sort(this.f12375d, this.f12385q);
            this.f12384p = TimeUnit.SECONDS.toMillis((long) ((C3678k) this.f12375d.get(0)).y);
            if (this.f12384p > 0 && this.f12375d.size() == 1) {
                C3688a.m15097b(f12369e + "|add : " + c3678k.toString() + " --- " + c3678k.c.getClass().getName() + " set alarm " + "delay = " + (this.f12384p + C3684e.f12414u));
                C3685c.m15060b().m15056b((currentTimeMillis + this.f12384p) + C3684e.f12414u);
            }
        }
    }

    private void m14989b(Socket socket) {
        this.f12379i = new C3677j(new C3680m(socket.getInputStream()), this.f12376f, this.f12377g);
        this.f12379i.m15025a(new C3673f(this));
        C3685c.m15060b().m15052a(this.f12379i, true);
    }

    private void m14990c(Socket socket) {
        this.f12380j = new C3679l(new C3681n(socket.getOutputStream()), this.f12376f, this.f12377g);
        this.f12380j.m15033a(new C3674g(this));
        C3685c.m15060b().m15052a(this.f12380j, true);
    }

    private void m14996f() {
        C3688a.m15097b(f12369e + "|disconnect = true, reconnect");
        this.f12381k = new C3670c(new C3672e(this));
        C3685c.m15060b().m15052a(this.f12381k, true);
    }

    private void m14998g() {
        if (this.f12381k != null) {
            this.f12381k.m14980h();
        }
        if (this.f12380j != null) {
            this.f12380j.m15036h();
            if (this.f12380j.f12401j != null) {
                try {
                    this.f12380j.f12401j.m15039a();
                } catch (Exception e) {
                }
            }
        }
        if (this.f12379i != null) {
            this.f12379i.m15028h();
            if (this.f12379i.f12395i != null) {
                try {
                    this.f12379i.f12395i.m15038a();
                } catch (Exception e2) {
                }
            }
        }
        if (this.f12378h != null) {
            try {
                if (!this.f12378h.isClosed()) {
                    this.f12378h.close();
                }
            } catch (Exception e3) {
            }
        }
    }

    private void m15000h() {
        if (!this.f12382l) {
            this.f12382l = true;
            m15001i();
            C3777e.m15491a().m15541b(false);
        }
    }

    private void m15001i() {
        if (this.f12380j != null) {
            this.f12380j.f12401j = null;
            this.f12380j = null;
        }
        if (this.f12379i != null) {
            this.f12379i.f12395i = null;
            this.f12379i = null;
        }
        this.f12381k = null;
        this.f12378h = null;
        this.f12377g = null;
    }

    private boolean m15004j() {
        return (this.f12381k == null || this.f12381k.e) && ((this.f12379i == null || this.f12379i.e) && (this.f12380j == null || this.f12380j.e));
    }

    private boolean m15005k() {
        return (this.f12378h == null || this.f12378h.isClosed()) ? false : true;
    }

    private void m15006l() {
        C3685c.m15060b().m15057e();
        C3688a.m15097b(f12369e + "|cancel alrm");
        synchronized (f12371n) {
            if (!this.f12375d.isEmpty()) {
                for (C3678k p : this.f12375d) {
                    p.m14966p();
                }
                this.f12375d.clear();
            }
        }
        if (!f12370m.f12374c.isEmpty()) {
            Iterator it = f12370m.f12374c.iterator();
            while (it.hasNext()) {
                ((C3678k) it.next()).m14966p();
            }
            f12370m.f12374c.clear();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m15007a(com.igexin.p158b.p159a.p161b.p162a.p163a.C3678k r3) {
        /*
        r2 = this;
        r0 = r2.f12372a;	 Catch:{ Exception -> 0x0015, all -> 0x001e }
        r0.lock();	 Catch:{ Exception -> 0x0015, all -> 0x001e }
        r0 = r2.f12374c;	 Catch:{ Exception -> 0x0015, all -> 0x001e }
        r0.offer(r3);	 Catch:{ Exception -> 0x0015, all -> 0x001e }
        r0 = r2.f12373b;	 Catch:{ Exception -> 0x0015, all -> 0x001e }
        r0.signalAll();	 Catch:{ Exception -> 0x0015, all -> 0x001e }
        r0 = r2.f12372a;	 Catch:{ Exception -> 0x0027 }
        r0.unlock();	 Catch:{ Exception -> 0x0027 }
    L_0x0014:
        return;
    L_0x0015:
        r0 = move-exception;
        r0 = r2.f12372a;	 Catch:{ Exception -> 0x001c }
        r0.unlock();	 Catch:{ Exception -> 0x001c }
        goto L_0x0014;
    L_0x001c:
        r0 = move-exception;
        goto L_0x0014;
    L_0x001e:
        r0 = move-exception;
        r1 = r2.f12372a;	 Catch:{ Exception -> 0x0025 }
        r1.unlock();	 Catch:{ Exception -> 0x0025 }
    L_0x0024:
        throw r0;
    L_0x0025:
        r1 = move-exception;
        goto L_0x0024;
    L_0x0027:
        r0 = move-exception;
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.a.a.d.a(com.igexin.b.a.b.a.a.k):void");
    }

    public void m15008a(C3683b c3683b) {
        this.f12376f = c3683b;
        if (this.f12379i != null) {
            this.f12379i.f12396j = c3683b;
        }
        if (this.f12380j != null) {
            this.f12380j.f12400i = c3683b;
        }
    }

    public void m15009a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (f12371n) {
            Object obj;
            C3688a.m15097b(f12369e + "|" + str + " -- resp");
            Iterator it = this.f12375d.iterator();
            while (it.hasNext()) {
                C3678k c3678k = (C3678k) it.next();
                if (c3678k.D.m15106a(currentTimeMillis, c3678k)) {
                    c3678k.m14966p();
                    c3678k.D.m15105a(c3678k);
                    obj = 1;
                    it.remove();
                    break;
                }
                long b = c3678k.D.m15107b(currentTimeMillis, c3678k);
                if (this.f12384p < 0 || this.f12384p > b) {
                    this.f12384p = b;
                }
            }
            obj = null;
            C3685c.m15060b().m15057e();
            if (obj != null) {
                C3688a.m15097b(f12369e + "|time out");
                m15013d();
                return;
            }
            if (this.f12375d.size() > 0) {
                c3678k = (C3678k) this.f12375d.get(0);
                c3678k.m14966p();
                C3685c.m15060b().m15055a((Object) c3678k);
                this.f12375d.remove(c3678k);
                C3688a.m15097b(f12369e + "|remove : " + c3678k.toString() + " -- " + c3678k.c.getClass().getSimpleName());
            }
            int size = this.f12375d.size();
            C3688a.m15097b(f12369e + "|r, size = " + size);
            if (size > 0 && this.f12384p > 0) {
                C3688a.m15097b(f12369e + "|set alarm = " + this.f12384p);
                C3685c.m15060b().m15056b((currentTimeMillis + this.f12384p) + C3684e.f12414u);
            }
        }
    }

    public synchronized void m15010a(boolean z) {
        Message obtain = Message.obtain();
        obtain.obj = Boolean.valueOf(z);
        obtain.what = 5;
        this.f12383o.sendMessage(obtain);
    }

    public synchronized void m15011b() {
        this.f12383o.sendEmptyMessage(4);
    }

    public void m15012c() {
        this.f12383o.sendEmptyMessage(0);
    }

    public synchronized void m15013d() {
        C3688a.m15097b(f12369e + "|alarm timeout disconnect");
        this.f12383o.sendEmptyMessage(4);
    }
}
