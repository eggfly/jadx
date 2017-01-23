package com.xiaomi.smack;

import android.util.Pair;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.network.C4321d;
import com.xiaomi.channel.commonutils.string.C4328c;
import com.xiaomi.measite.smack.C4331a;
import com.xiaomi.push.service.C4450y.C4448b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aa;
import com.xiaomi.pushsdk.BuildConfig;
import com.xiaomi.smack.debugger.C4330a;
import com.xiaomi.smack.filter.C4406a;
import com.xiaomi.smack.packet.C4468d;
import com.xiaomi.smack.packet.C4485f;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.xiaomi.smack.a */
public abstract class C4461a {
    public static boolean f15300a;
    private static final AtomicInteger f15301q;
    protected int f15302b;
    protected long f15303c;
    protected volatile long f15304d;
    protected volatile long f15305e;
    protected int f15306f;
    protected final Map<C4336f, C4460a> f15307g;
    protected final Map<C4336f, C4460a> f15308h;
    protected C4330a f15309i;
    protected Reader f15310j;
    protected Writer f15311k;
    protected String f15312l;
    protected String f15313m;
    protected final int f15314n;
    protected C4403b f15315o;
    protected XMPushService f15316p;
    private LinkedList<Pair<Integer, Long>> f15317r;
    private final Collection<C4338d> f15318s;
    private int f15319t;
    private long f15320u;

    /* renamed from: com.xiaomi.smack.a.a */
    protected static class C4460a {
        private C4336f f15298a;
        private C4406a f15299b;

        public C4460a(C4336f c4336f, C4406a c4406a) {
            this.f15298a = c4336f;
            this.f15299b = c4406a;
        }

        public void m18452a(C4468d c4468d) {
            if (this.f15299b == null || this.f15299b.m18180a(c4468d)) {
                this.f15298a.m17767a(c4468d);
            }
        }
    }

    static {
        f15301q = new AtomicInteger(0);
        f15300a = false;
        try {
            f15300a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception e) {
        }
        C4467j.m18503a();
    }

    protected C4461a(XMPushService xMPushService, C4403b c4403b) {
        this.f15302b = 0;
        this.f15303c = -1;
        this.f15304d = 0;
        this.f15305e = 0;
        this.f15317r = new LinkedList();
        this.f15318s = new CopyOnWriteArrayList();
        this.f15307g = new ConcurrentHashMap();
        this.f15308h = new ConcurrentHashMap();
        this.f15309i = null;
        this.f15312l = BuildConfig.FLAVOR;
        this.f15313m = BuildConfig.FLAVOR;
        this.f15319t = 2;
        this.f15314n = f15301q.getAndIncrement();
        this.f15320u = 0;
        this.f15315o = c4403b;
        this.f15316p = xMPushService;
    }

    private String m18453a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : UtilityImpl.NET_TYPE_UNKNOWN;
    }

    private void m18454b(int i) {
        synchronized (this.f15317r) {
            if (i == 1) {
                this.f15317r.clear();
            } else {
                this.f15317r.add(new Pair(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f15317r.size() > 6) {
                    this.f15317r.remove(0);
                }
            }
        }
    }

    public C4403b m18455a() {
        return this.f15315o;
    }

    public void m18456a(int i, int i2, Exception exception) {
        if (i != this.f15319t) {
            C4302b.m17649a(String.format("update the connection status. %1$s -> %2$s : %3$s ", new Object[]{m18453a(this.f15319t), m18453a(i), aa.m18107a(i2)}));
        }
        if (C4321d.m17709d(this.f15316p)) {
            m18454b(i);
        }
        if (i == 1) {
            this.f15316p.m18078a(10);
            if (this.f15319t != 0) {
                C4302b.m17649a("try set connected while not connecting.");
            }
            this.f15319t = i;
            for (C4338d a : this.f15318s) {
                a.m17769a(this);
            }
        } else if (i == 0) {
            if (this.f15319t != 2) {
                C4302b.m17649a("try set connecting while not disconnected.");
            }
            this.f15319t = i;
            for (C4338d a2 : this.f15318s) {
                a2.m17772b(this);
            }
        } else if (i == 2) {
            this.f15316p.m18078a(10);
            if (this.f15319t == 0) {
                for (C4338d a22 : this.f15318s) {
                    a22.m17771a(this, exception == null ? new CancellationException("disconnect while connecting") : exception);
                }
            } else if (this.f15319t == 1) {
                for (C4338d a222 : this.f15318s) {
                    a222.m17770a(this, i2, exception);
                }
            }
            this.f15319t = i;
        }
    }

    public abstract void m18457a(C4448b c4448b);

    public void m18458a(C4338d c4338d) {
        if (c4338d != null && !this.f15318s.contains(c4338d)) {
            this.f15318s.add(c4338d);
        }
    }

    public void m18459a(C4336f c4336f, C4406a c4406a) {
        if (c4336f == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f15307g.put(c4336f, new C4460a(c4336f, c4406a));
    }

    public abstract void m18460a(C4468d c4468d);

    public abstract void m18461a(C4485f c4485f, int i, Exception exception);

    public synchronized void m18462a(String str) {
        if (this.f15319t == 0) {
            C4302b.m17649a("setChallenge hash = " + C4328c.m17739a(str).substring(0, 8));
            this.f15312l = str;
            m18456a(1, 0, null);
        } else {
            C4302b.m17649a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void m18463a(String str, String str2);

    public abstract void m18464a(C4468d[] c4468dArr);

    public synchronized boolean m18465a(long j) {
        return this.f15320u >= j;
    }

    public String m18466b() {
        return this.f15315o.m18161c();
    }

    public void m18467b(C4338d c4338d) {
        this.f15318s.remove(c4338d);
    }

    public void m18468b(C4336f c4336f, C4406a c4406a) {
        if (c4336f == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.f15308h.put(c4336f, new C4460a(c4336f, c4406a));
    }

    protected void m18469b(C4468d c4468d) {
        for (C4460a a : this.f15308h.values()) {
            a.m18452a(c4468d);
        }
    }

    public String m18470c() {
        return this.f15315o.m18165f();
    }

    public String m18471d() {
        return this.f15315o.m18163d();
    }

    public int m18472e() {
        return this.f15306f;
    }

    public long m18473f() {
        return this.f15305e;
    }

    protected void m18474g() {
        Class cls = null;
        if (this.f15310j != null && this.f15311k != null && this.f15315o.m18166g()) {
            if (this.f15309i == null) {
                String property;
                try {
                    property = System.getProperty("smack.debuggerClass");
                } catch (Throwable th) {
                    Object obj = cls;
                }
                if (property != null) {
                    try {
                        cls = Class.forName(property);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (cls == null) {
                    this.f15309i = new C4331a(this, this.f15311k, this.f15310j);
                    this.f15310j = this.f15309i.m17748a();
                    this.f15311k = this.f15309i.m17751b();
                    return;
                }
                try {
                    this.f15309i = (C4330a) cls.getConstructor(new Class[]{C4461a.class, Writer.class, Reader.class}).newInstance(new Object[]{this, this.f15311k, this.f15310j});
                    this.f15310j = this.f15309i.m17748a();
                    this.f15311k = this.f15309i.m17751b();
                    return;
                } catch (Throwable e2) {
                    throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
                }
            }
            this.f15310j = this.f15309i.m17749a(this.f15310j);
            this.f15311k = this.f15309i.m17750a(this.f15311k);
        }
    }

    public boolean m18475h() {
        return this.f15319t == 0;
    }

    public boolean m18476i() {
        return this.f15319t == 1;
    }

    public int m18477j() {
        return this.f15302b;
    }

    public void m18478k() {
        this.f15302b = 0;
    }

    public long m18479l() {
        return this.f15303c;
    }

    public void m18480m() {
        this.f15303c = -1;
    }

    public abstract void m18481n();

    public int m18482o() {
        return this.f15319t;
    }

    public synchronized void m18483p() {
        this.f15320u = System.currentTimeMillis();
    }

    public synchronized boolean m18484q() {
        return System.currentTimeMillis() - this.f15320u < ((long) C4467j.m18505b());
    }

    public void m18485r() {
        synchronized (this.f15317r) {
            this.f15317r.clear();
        }
    }
}
