package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.C2301a;
import com.google.android.gms.ads.C2719d;
import com.google.android.gms.ads.C2724g;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.p152a.C2694a;
import com.google.android.gms.ads.p152a.C2696c;
import com.google.android.gms.ads.purchase.C2992b;
import com.google.android.gms.ads.purchase.C2994d;
import com.google.android.gms.p146b.be;
import com.google.android.gms.p146b.dt;
import com.google.android.gms.p146b.fh;
import com.google.android.gms.p146b.fl;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;
import java.util.concurrent.atomic.AtomicBoolean;

@gb
/* renamed from: com.google.android.gms.ads.internal.client.c */
public class C2756c {
    private final dt f9391a;
    private final C2779q f9392b;
    private final AtomicBoolean f9393c;
    private C2301a f9394d;
    private C2646a f9395e;
    private ad f9396f;
    private C2719d[] f9397g;
    private String f9398h;
    private String f9399i;
    private ViewGroup f9400j;
    private C2694a f9401k;
    private C2992b f9402l;
    private C2994d f9403m;
    private C2696c f9404n;
    private boolean f9405o;
    private C2724g f9406p;
    private boolean f9407q;

    C2756c(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, C2779q c2779q, ad adVar, boolean z2) {
        this.f9391a = new dt();
        this.f9400j = viewGroup;
        this.f9392b = c2779q;
        this.f9396f = adVar;
        this.f9393c = new AtomicBoolean(false);
        this.f9407q = z2;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                C2782t c2782t = new C2782t(context, attributeSet);
                this.f9397g = c2782t.m10734a(z);
                this.f9398h = c2782t.m10733a();
                if (viewGroup.isInEditMode()) {
                    C2784w.m10741a().m11566a(viewGroup, C2756c.m10608a(context, this.f9397g[0], this.f9407q), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                C2784w.m10741a().m11567a(viewGroup, new AdSizeParcel(context, C2719d.f9257a), e.getMessage(), e.getMessage());
            }
        }
    }

    C2756c(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, C2779q c2779q, boolean z2) {
        this(viewGroup, attributeSet, z, c2779q, null, z2);
    }

    public C2756c(ViewGroup viewGroup, boolean z) {
        this(viewGroup, null, false, C2779q.m10726a(), z);
    }

    private static AdSizeParcel m10608a(Context context, C2719d c2719d, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, c2719d);
        adSizeParcel.m10503a(z);
        return adSizeParcel;
    }

    private static AdSizeParcel m10609a(Context context, C2719d[] c2719dArr, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, c2719dArr);
        adSizeParcel.m10503a(z);
        return adSizeParcel;
    }

    private void m10610n() {
        try {
            C2687a f_ = this.f9396f.f_();
            if (f_ != null) {
                this.f9400j.addView((View) C2690b.m10263a(f_));
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to get an ad frame.", e);
        }
    }

    public void m10611a() {
        try {
            if (this.f9396f != null) {
                this.f9396f.m10406b();
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to destroy AdView.", e);
        }
    }

    public void m10612a(C2694a c2694a) {
        try {
            this.f9401k = c2694a;
            if (this.f9396f != null) {
                this.f9396f.m10395a(c2694a != null ? new C2781s(c2694a) : null);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to set the AppEventListener.", e);
        }
    }

    public void m10613a(C2696c c2696c) {
        this.f9404n = c2696c;
        try {
            if (this.f9396f != null) {
                this.f9396f.m10400a(c2696c != null ? new be(c2696c) : null);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void m10614a(C2301a c2301a) {
        try {
            this.f9394d = c2301a;
            if (this.f9396f != null) {
                this.f9396f.m10398a(c2301a != null ? new C2774l(c2301a) : null);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to set the AdListener.", e);
        }
    }

    public void m10615a(C2724g c2724g) {
        this.f9406p = c2724g;
        try {
            if (this.f9396f != null) {
                this.f9396f.m10396a(this.f9406p == null ? null : this.f9406p.m10372a());
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to set correlator.", e);
        }
    }

    public void m10616a(C2646a c2646a) {
        try {
            this.f9395e = c2646a;
            if (this.f9396f != null) {
                this.f9396f.m10397a(c2646a != null ? new C2771k(c2646a) : null);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to set the AdClickListener.", e);
        }
    }

    public void m10617a(C2755b c2755b) {
        try {
            if (this.f9396f == null) {
                m10633l();
            }
            if (this.f9396f.m10405a(this.f9392b.m10727a(this.f9400j.getContext(), c2755b))) {
                this.f9391a.m12363a(c2755b.m10602j());
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to load ad.", e);
        }
    }

    public void m10618a(C2992b c2992b) {
        if (this.f9403m != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.f9402l = c2992b;
            if (this.f9396f != null) {
                this.f9396f.m10401a(c2992b != null ? new fh(c2992b) : null);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void m10619a(String str) {
        if (this.f9398h != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f9398h = str;
    }

    public void m10620a(boolean z) {
        this.f9405o = z;
        try {
            if (this.f9396f != null) {
                this.f9396f.m10404a(this.f9405o);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to set manual impressions.", e);
        }
    }

    public void m10621a(C2719d... c2719dArr) {
        if (this.f9397g != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        m10623b(c2719dArr);
    }

    public C2301a m10622b() {
        return this.f9394d;
    }

    public void m10623b(C2719d... c2719dArr) {
        this.f9397g = c2719dArr;
        try {
            if (this.f9396f != null) {
                this.f9396f.m10394a(C2756c.m10609a(this.f9400j.getContext(), this.f9397g, this.f9407q));
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to set the ad size.", e);
        }
        this.f9400j.requestLayout();
    }

    public C2719d m10624c() {
        try {
            if (this.f9396f != null) {
                AdSizeParcel i = this.f9396f.m10412i();
                if (i != null) {
                    return i.m10504b();
                }
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to get the current AdSize.", e);
        }
        return this.f9397g != null ? this.f9397g[0] : null;
    }

    public C2719d[] m10625d() {
        return this.f9397g;
    }

    public String m10626e() {
        return this.f9398h;
    }

    public C2694a m10627f() {
        return this.f9401k;
    }

    public C2992b m10628g() {
        return this.f9402l;
    }

    public C2696c m10629h() {
        return this.f9404n;
    }

    public void m10630i() {
        try {
            if (this.f9396f != null) {
                this.f9396f.m10408d();
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to call pause.", e);
        }
    }

    public void m10631j() {
        try {
            if (this.f9396f != null) {
                this.f9396f.m10409e();
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to call resume.", e);
        }
    }

    public String m10632k() {
        try {
            if (this.f9396f != null) {
                return this.f9396f.m10413j();
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    void m10633l() {
        if ((this.f9397g == null || this.f9398h == null) && this.f9396f == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        this.f9396f = m10634m();
        if (this.f9394d != null) {
            this.f9396f.m10398a(new C2774l(this.f9394d));
        }
        if (this.f9395e != null) {
            this.f9396f.m10397a(new C2771k(this.f9395e));
        }
        if (this.f9401k != null) {
            this.f9396f.m10395a(new C2781s(this.f9401k));
        }
        if (this.f9402l != null) {
            this.f9396f.m10401a(new fh(this.f9402l));
        }
        if (this.f9403m != null) {
            this.f9396f.m10402a(new fl(this.f9403m), this.f9399i);
        }
        if (this.f9404n != null) {
            this.f9396f.m10400a(new be(this.f9404n));
        }
        if (this.f9406p != null) {
            this.f9396f.m10396a(this.f9406p.m10372a());
        }
        this.f9396f.m10404a(this.f9405o);
        m10610n();
    }

    protected ad m10634m() {
        Context context = this.f9400j.getContext();
        return C2784w.m10743b().m10717a(context, C2756c.m10609a(context, this.f9397g, this.f9407q), this.f9398h, this.f9391a);
    }
}
