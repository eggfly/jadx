package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.C2960e;
import com.google.android.gms.ads.internal.util.client.C2971a;
import com.google.android.gms.p146b.bs;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.client.w */
public class C2784w {
    private static final Object f9456a;
    private static C2784w f9457b;
    private final C2971a f9458c;
    private final C2776n f9459d;
    private final C2783u f9460e;
    private final C2758e f9461f;
    private final bs f9462g;
    private final C2960e f9463h;

    static {
        f9456a = new Object();
        C2784w.m10742a(new C2784w());
    }

    protected C2784w() {
        this.f9458c = new C2971a();
        this.f9459d = new C2776n();
        this.f9460e = new C2783u();
        this.f9461f = new C2758e();
        this.f9462g = new bs();
        this.f9463h = new C2960e();
    }

    public static C2971a m10741a() {
        return C2784w.m10746e().f9458c;
    }

    protected static void m10742a(C2784w c2784w) {
        synchronized (f9456a) {
            f9457b = c2784w;
        }
    }

    public static C2776n m10743b() {
        return C2784w.m10746e().f9459d;
    }

    public static C2783u m10744c() {
        return C2784w.m10746e().f9460e;
    }

    public static bs m10745d() {
        return C2784w.m10746e().f9462g;
    }

    private static C2784w m10746e() {
        C2784w c2784w;
        synchronized (f9456a) {
            c2784w = f9457b;
        }
        return c2784w;
    }
}
