package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.C2290u;
import com.facebook.ads.internal.util.C2498g;

/* renamed from: com.facebook.ads.internal.adapters.e */
public class C2310e {
    private int f7981a;
    private int f7982b;
    private final Context f7983c;
    private final View f7984d;
    private final int f7985e;
    private final C2266a f7986f;
    private final Handler f7987g;
    private final Runnable f7988h;
    private final boolean f7989i;
    private boolean f7990j;

    /* renamed from: com.facebook.ads.internal.adapters.e.a */
    public static abstract class C2266a {
        public abstract void m8572a();

        public void m8573b() {
        }
    }

    /* renamed from: com.facebook.ads.internal.adapters.e.b */
    private static final class C2309b extends C2290u<C2310e> {
        public C2309b(C2310e c2310e) {
            super(c2310e);
        }

        public void run() {
            C2310e c2310e = (C2310e) m8655a();
            if (c2310e != null) {
                View a = c2310e.f7984d;
                C2266a b = c2310e.f7986f;
                if (a != null && b != null) {
                    boolean a2 = C2498g.m9482a(c2310e.f7983c, a, c2310e.f7985e);
                    if (a2 && !c2310e.f7990j) {
                        b.m8572a();
                        if (!c2310e.f7989i) {
                            return;
                        }
                    } else if (!a2 && c2310e.f7990j) {
                        b.m8573b();
                    }
                    c2310e.f7990j = a2;
                    c2310e.f7987g.postDelayed(c2310e.f7988h, (long) c2310e.f7982b);
                }
            }
        }
    }

    public C2310e(Context context, View view, int i, C2266a c2266a) {
        this(context, view, i, false, c2266a);
    }

    public C2310e(Context context, View view, int i, boolean z, C2266a c2266a) {
        this.f7981a = 0;
        this.f7982b = AdError.NETWORK_ERROR_CODE;
        this.f7987g = new Handler();
        this.f7988h = new C2309b(this);
        this.f7983c = context;
        this.f7984d = view;
        this.f7985e = i;
        this.f7986f = c2266a;
        this.f7989i = z;
    }

    public void m8810a() {
        this.f7987g.postDelayed(this.f7988h, (long) this.f7981a);
    }

    public void m8811a(int i) {
        this.f7981a = i;
    }

    public void m8812b() {
        this.f7987g.removeCallbacks(this.f7988h);
    }

    public void m8813b(int i) {
        this.f7982b = i;
    }
}
