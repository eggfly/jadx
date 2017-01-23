package com.google.android.gms.common.api.p155a;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C3386f;
import com.google.android.gms.common.api.C3444a;
import com.google.android.gms.common.api.C3444a.C2924c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.p155a.C3392a.C3307a;
import com.google.android.gms.common.api.p155a.C3428h.C3306e;
import com.google.android.gms.common.api.p155a.C3430j.C3400a;

/* renamed from: com.google.android.gms.common.api.a.e */
public class C3404e implements C3403i {
    private final C3430j f11852a;
    private boolean f11853b;

    /* renamed from: com.google.android.gms.common.api.a.e.1 */
    class C34011 extends C3400a {
        final /* synthetic */ C3404e f11850a;

        C34011(C3404e c3404e, C3403i c3403i) {
            this.f11850a = c3404e;
            super(c3403i);
        }

        public void m14028a() {
            this.f11850a.m14042a(1);
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.e.2 */
    class C34022 extends C3400a {
        final /* synthetic */ C3404e f11851a;

        C34022(C3404e c3404e, C3403i c3403i) {
            this.f11851a = c3404e;
            super(c3403i);
        }

        public void m14029a() {
            this.f11851a.f11852a.f11935h.m13981a(null);
        }
    }

    public C3404e(C3430j c3430j) {
        this.f11853b = false;
        this.f11852a = c3430j;
    }

    private <A extends C2924c> void m14039a(C3306e<A> c3306e) {
        this.f11852a.f11934g.m14158a((C3306e) c3306e);
        C2924c a = this.f11852a.f11934g.m14152a(c3306e.m13456b());
        if (a.m11352e() || !this.f11852a.f11929b.containsKey(c3306e.m13456b())) {
            c3306e.m13454a(a);
        } else {
            c3306e.m13453a(new Status(17));
        }
    }

    public <A extends C2924c, R extends C3386f, T extends C3307a<R, A>> T m14040a(T t) {
        return m14045b(t);
    }

    public void m14041a() {
    }

    public void m14042a(int i) {
        this.f11852a.m14181a(null);
        this.f11852a.f11935h.m13980a(i, this.f11853b);
    }

    public void m14043a(Bundle bundle) {
    }

    public void m14044a(ConnectionResult connectionResult, C3444a<?> c3444a, int i) {
    }

    public <A extends C2924c, T extends C3307a<? extends C3386f, A>> T m14045b(T t) {
        try {
            m14039a((C3306e) t);
        } catch (DeadObjectException e) {
            this.f11852a.m14183a(new C34011(this, this));
        }
        return t;
    }

    public boolean m14046b() {
        if (this.f11853b) {
            return false;
        }
        if (this.f11852a.f11934g.m14172i()) {
            this.f11853b = true;
            for (C3443s a : this.f11852a.f11934g.f11909i) {
                a.m14235a();
            }
            return false;
        }
        this.f11852a.m14181a(null);
        return true;
    }

    public void m14047c() {
        if (this.f11853b) {
            this.f11853b = false;
            this.f11852a.m14183a(new C34022(this, this));
        }
    }

    void m14048d() {
        if (this.f11853b) {
            this.f11853b = false;
            this.f11852a.f11934g.m14162a(false);
            m14046b();
        }
    }
}
