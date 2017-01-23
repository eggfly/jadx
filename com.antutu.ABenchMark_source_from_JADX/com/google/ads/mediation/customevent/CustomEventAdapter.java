package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.C2631a.C2622a;
import com.google.ads.C2632b;
import com.google.ads.mediation.C2650b;
import com.google.ads.mediation.C2656d;
import com.google.ads.mediation.C2657f;
import com.google.ads.mediation.C2663e;
import com.google.ads.mediation.C2664g;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.mediation.customevent.C2984d;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class CustomEventAdapter implements C2656d<C2984d, C2662f>, C2657f<C2984d, C2662f> {
    C2659b f9216a;
    C2660d f9217b;
    private View f9218c;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.a */
    static final class C2653a implements C2652c {
        private final CustomEventAdapter f9211a;
        private final C2663e f9212b;

        public C2653a(CustomEventAdapter customEventAdapter, C2663e c2663e) {
            this.f9211a = customEventAdapter;
            this.f9212b = c2663e;
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.b */
    class C2655b implements C2654e {
        final /* synthetic */ CustomEventAdapter f9213a;
        private final CustomEventAdapter f9214b;
        private final C2664g f9215c;

        public C2655b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, C2664g c2664g) {
            this.f9213a = customEventAdapter;
            this.f9214b = customEventAdapter2;
            this.f9215c = c2664g;
        }
    }

    private static <T> T m10235a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            C2972b.m11583d("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    C2655b m10236a(C2664g c2664g) {
        return new C2655b(this, this, c2664g);
    }

    public void m10237a() {
        if (this.f9216a != null) {
            this.f9216a.m10246a();
        }
        if (this.f9217b != null) {
            this.f9217b.m10246a();
        }
    }

    public void m10238a(C2663e c2663e, Activity activity, C2662f c2662f, C2632b c2632b, C2650b c2650b, C2984d c2984d) {
        this.f9216a = (C2659b) m10235a(c2662f.f9220b);
        if (this.f9216a == null) {
            c2663e.m10252a(this, C2622a.INTERNAL_ERROR);
        } else {
            this.f9216a.m10247a(new C2653a(this, c2663e), activity, c2662f.f9219a, c2662f.f9221c, c2632b, c2650b, c2984d == null ? null : c2984d.m11611a(c2662f.f9219a));
        }
    }

    public void m10240a(C2664g c2664g, Activity activity, C2662f c2662f, C2650b c2650b, C2984d c2984d) {
        this.f9217b = (C2660d) m10235a(c2662f.f9220b);
        if (this.f9217b == null) {
            c2664g.m10253a(this, C2622a.INTERNAL_ERROR);
        } else {
            this.f9217b.m10248a(m10236a(c2664g), activity, c2662f.f9219a, c2662f.f9221c, c2650b, c2984d == null ? null : c2984d.m11611a(c2662f.f9219a));
        }
    }

    public Class<C2984d> m10242b() {
        return C2984d.class;
    }

    public Class<C2662f> m10243c() {
        return C2662f.class;
    }

    public View m10244d() {
        return this.f9218c;
    }

    public void m10245e() {
        this.f9217b.m10249b();
    }
}
