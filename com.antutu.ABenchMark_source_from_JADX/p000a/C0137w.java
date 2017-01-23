package p000a;

import com.xiaomi.pushsdk.BuildConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p000a.p001a.C0021b;
import p000a.p001a.p002a.C0002a;
import p000a.p001a.p003b.C0011a;
import p000a.p001a.p005c.C0023a;
import p000a.p001a.p005c.C0024b;
import p000a.p001a.p005c.C0031g;
import p000a.p001a.p005c.C0034j;
import p000a.p001a.p009g.C0090e;

/* renamed from: a.w */
final class C0137w implements C0109e {
    final C0134u f618a;
    final C0034j f619b;
    final C0139x f620c;
    final boolean f621d;
    private boolean f622e;

    /* renamed from: a.w.a */
    final class C0136a extends C0021b {
        final /* synthetic */ C0137w f616a;
        private final C0110f f617c;

        String m644a() {
            return this.f616a.f620c.m661a().m598f();
        }

        protected void m645b() {
            IOException e;
            Object obj = 1;
            Object obj2 = null;
            try {
                C0143z f = this.f616a.m652f();
                if (this.f616a.f619b.m145a()) {
                    try {
                        this.f617c.m482a(this.f616a, new IOException("Canceled"));
                    } catch (IOException e2) {
                        e = e2;
                        if (obj == null) {
                            this.f617c.m482a(this.f616a, e);
                        } else {
                            try {
                                C0090e.m389b().m394a(4, "Callback failure for " + this.f616a.m650d(), (Throwable) e);
                            } catch (Throwable th) {
                                this.f616a.f618a.m638s().m531a(this);
                            }
                        }
                        this.f616a.f618a.m638s().m531a(this);
                    }
                }
                this.f617c.m481a(this.f616a, f);
                this.f616a.f618a.m638s().m531a(this);
            } catch (IOException e3) {
                e = e3;
                obj = obj2;
                if (obj == null) {
                    C0090e.m389b().m394a(4, "Callback failure for " + this.f616a.m650d(), (Throwable) e);
                } else {
                    this.f617c.m482a(this.f616a, e);
                }
                this.f616a.f618a.m638s().m531a(this);
            }
        }
    }

    C0137w(C0134u c0134u, C0139x c0139x, boolean z) {
        this.f618a = c0134u;
        this.f620c = c0139x;
        this.f621d = z;
        this.f619b = new C0034j(c0134u, z);
    }

    private void m646g() {
        this.f619b.m144a(C0090e.m389b().m392a("response.body().close()"));
    }

    public C0143z m647a() {
        synchronized (this) {
            if (this.f622e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f622e = true;
        }
        m646g();
        try {
            this.f618a.m638s().m532a(this);
            C0143z f = m652f();
            if (f != null) {
                return f;
            }
            throw new IOException("Canceled");
        } finally {
            this.f618a.m638s().m534b(this);
        }
    }

    public boolean m648b() {
        return this.f619b.m145a();
    }

    public C0137w m649c() {
        return new C0137w(this.f618a, this.f620c, this.f621d);
    }

    public /* synthetic */ Object clone() {
        return m649c();
    }

    String m650d() {
        return (m648b() ? "canceled " : BuildConfig.FLAVOR) + (this.f621d ? "web socket" : NotificationCompatApi21.CATEGORY_CALL) + " to " + m651e();
    }

    String m651e() {
        return this.f620c.m661a().m605m();
    }

    C0143z m652f() {
        List arrayList = new ArrayList();
        arrayList.addAll(this.f618a.m641v());
        arrayList.add(this.f619b);
        arrayList.add(new C0023a(this.f618a.m625f()));
        arrayList.add(new C0002a(this.f618a.m626g()));
        arrayList.add(new C0011a(this.f618a));
        if (!this.f621d) {
            arrayList.addAll(this.f618a.m642w());
        }
        arrayList.add(new C0024b(this.f621d));
        return new C0031g(arrayList, null, null, null, 0, this.f620c).m118a(this.f620c);
    }
}
