package p023b.p024a;

import android.content.Context;

/* renamed from: b.a.g */
public final class C0877g implements C0870j {
    private static C0877g f2943c;
    private C0870j f2944a;
    private Context f2945b;

    /* renamed from: b.a.g.1 */
    class C08731 extends as {
        final /* synthetic */ C0882k f2938a;
        final /* synthetic */ C0877g f2939b;

        C08731(C0877g c0877g, C0882k c0882k) {
            this.f2939b = c0877g;
            this.f2938a = c0882k;
        }

        public void m3882a() {
            this.f2939b.f2944a.m3852a(this.f2938a);
        }
    }

    /* renamed from: b.a.g.2 */
    class C08742 extends as {
        final /* synthetic */ C0877g f2940a;

        C08742(C0877g c0877g) {
            this.f2940a = c0877g;
        }

        public void m3883a() {
            this.f2940a.f2944a.m3851a();
        }
    }

    /* renamed from: b.a.g.3 */
    class C08753 extends as {
        final /* synthetic */ C0877g f2941a;

        C08753(C0877g c0877g) {
            this.f2941a = c0877g;
        }

        public void m3884a() {
            this.f2941a.f2944a.m3853b();
        }
    }

    /* renamed from: b.a.g.4 */
    class C08764 extends as {
        final /* synthetic */ C0877g f2942a;

        C08764(C0877g c0877g) {
            this.f2942a = c0877g;
        }

        public void m3885a() {
            this.f2942a.f2944a.m3855c();
        }
    }

    private C0877g(Context context) {
        this.f2945b = context;
        this.f2944a = new C0872f(this.f2945b);
    }

    public static synchronized C0877g m3887b(Context context) {
        C0877g c0877g;
        synchronized (C0877g.class) {
            if (f2943c == null && context != null) {
                f2943c = new C0877g(context);
            }
            c0877g = f2943c;
        }
        return c0877g;
    }

    public synchronized C0872f m3888a(Context context) {
        return (C0872f) this.f2944a;
    }

    public void m3889a() {
        aq.m3396b(new C08742(this));
    }

    public void m3890a(C0882k c0882k) {
        aq.m3396b(new C08731(this, c0882k));
    }

    public void m3891b() {
        aq.m3396b(new C08753(this));
    }

    public void m3892b(C0882k c0882k) {
        this.f2944a.m3854b(c0882k);
    }

    public void m3893c() {
        aq.m3397c(new C08764(this));
    }
}
