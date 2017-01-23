package p023b.p024a;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: b.a.u */
public class C0892u implements C0883l {
    public int f2980a;
    public int f2981b;
    public long f2982c;
    private final int f2983d;
    private int f2984e;
    private long f2985f;
    private long f2986g;
    private Context f2987h;

    public C0892u(Context context) {
        this.f2983d = 3600000;
        this.f2985f = 0;
        this.f2986g = 0;
        m3960a(context);
    }

    private void m3960a(Context context) {
        this.f2987h = context.getApplicationContext();
        SharedPreferences a = C0888r.m3932a(context);
        this.f2980a = a.getInt("successful_request", 0);
        this.f2981b = a.getInt("failed_requests ", 0);
        this.f2984e = a.getInt("last_request_spent_ms", 0);
        this.f2982c = a.getLong("last_request_time", 0);
        this.f2985f = a.getLong("last_req", 0);
    }

    public static void m3961a(Context context, C0909w c0909w) {
        SharedPreferences a = C0888r.m3932a(context);
        c0909w.f3094a.f3051Q = (long) a.getInt("failed_requests ", 0);
        c0909w.f3094a.f3050P = (long) a.getInt("successful_request", 0);
        c0909w.f3094a.f3052R = (long) a.getInt("last_request_spent_ms", 0);
    }

    public void m3962a() {
        m3969h();
    }

    public void m3963b() {
        m3970i();
    }

    public void m3964c() {
        m3967f();
    }

    public void m3965d() {
        m3968g();
    }

    public boolean m3966e() {
        return ((this.f2982c > 0 ? 1 : (this.f2982c == 0 ? 0 : -1)) == 0) && (!at.m3424a(this.f2987h).m3448h());
    }

    public void m3967f() {
        this.f2980a++;
        this.f2982c = this.f2985f;
    }

    public void m3968g() {
        this.f2981b++;
    }

    public void m3969h() {
        this.f2985f = System.currentTimeMillis();
    }

    public void m3970i() {
        this.f2984e = (int) (System.currentTimeMillis() - this.f2985f);
    }

    public void m3971j() {
        C0888r.m3932a(this.f2987h).edit().putInt("successful_request", this.f2980a).putInt("failed_requests ", this.f2981b).putInt("last_request_spent_ms", this.f2984e).putLong("last_request_time", this.f2982c).putLong("last_req", this.f2985f).commit();
    }

    public long m3972k() {
        SharedPreferences a = C0888r.m3932a(this.f2987h);
        this.f2986g = C0888r.m3932a(this.f2987h).getLong("first_activate_time", 0);
        if (this.f2986g == 0) {
            this.f2986g = System.currentTimeMillis();
            a.edit().putLong("first_activate_time", this.f2986g).commit();
        }
        return this.f2986g;
    }

    public long m3973l() {
        return this.f2985f;
    }
}
