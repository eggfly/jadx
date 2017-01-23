package p023b.p024a;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import p023b.p024a.ct.C0863a;

/* renamed from: b.a.z */
public class C0912z implements C0871q {
    private static C0912z f3107l;
    private final long f3108a;
    private final long f3109b;
    private final int f3110c;
    private final int f3111d;
    private at f3112e;
    private C0892u f3113f;
    private long f3114g;
    private int f3115h;
    private long f3116i;
    private long f3117j;
    private Context f3118k;

    static {
        f3107l = null;
    }

    private C0912z(Context context, C0892u c0892u) {
        this.f3108a = 1296000000;
        this.f3109b = 129600000;
        this.f3110c = 1800000;
        this.f3111d = 10000;
        this.f3114g = 1296000000;
        this.f3115h = 10000;
        this.f3116i = 0;
        this.f3117j = 0;
        this.f3118k = context;
        this.f3112e = at.m3424a(context);
        this.f3113f = c0892u;
    }

    public static synchronized C0912z m4000a(Context context, C0892u c0892u) {
        C0912z c0912z;
        synchronized (C0912z.class) {
            if (f3107l == null) {
                f3107l = new C0912z(context, c0892u);
                f3107l.m4001a(ct.m3820a(context).m3828b());
            }
            c0912z = f3107l;
        }
        return c0912z;
    }

    public void m4001a(C0863a c0863a) {
        this.f3114g = c0863a.m3807a(1296000000);
        int b = c0863a.m3812b(0);
        if (b != 0) {
            this.f3115h = b;
        } else if (AnalyticsConfig.sLatentWindow <= 0 || AnalyticsConfig.sLatentWindow > 1800000) {
            this.f3115h = 10000;
        } else {
            this.f3115h = AnalyticsConfig.sLatentWindow;
        }
    }

    public boolean m4002a() {
        if (this.f3112e.m3448h() || this.f3113f.m3966e()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f3113f.m3973l();
        if (currentTimeMillis > this.f3114g) {
            this.f3116i = (long) ak.m3320a(this.f3115h, cp.m3776a(this.f3118k));
            this.f3117j = currentTimeMillis;
            return true;
        } else if (currentTimeMillis <= 129600000) {
            return false;
        } else {
            this.f3116i = 0;
            this.f3117j = currentTimeMillis;
            return true;
        }
    }

    public long m4003b() {
        return this.f3116i;
    }
}
