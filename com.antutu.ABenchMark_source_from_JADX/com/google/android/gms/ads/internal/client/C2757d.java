package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.ads.C2301a;
import com.google.android.gms.ads.C2724g;
import com.google.android.gms.ads.internal.reward.client.C2961f;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.p149d.C2639b;
import com.google.android.gms.ads.p152a.C2694a;
import com.google.android.gms.ads.p152a.C2696c;
import com.google.android.gms.ads.p152a.C2698e;
import com.google.android.gms.ads.purchase.C2992b;
import com.google.android.gms.ads.purchase.C2994d;
import com.google.android.gms.p146b.be;
import com.google.android.gms.p146b.dt;
import com.google.android.gms.p146b.fh;
import com.google.android.gms.p146b.fl;
import com.google.android.gms.p146b.gb;

@gb
/* renamed from: com.google.android.gms.ads.internal.client.d */
public class C2757d {
    private final dt f9408a;
    private final Context f9409b;
    private final C2779q f9410c;
    private C2301a f9411d;
    private C2646a f9412e;
    private ad f9413f;
    private String f9414g;
    private String f9415h;
    private C2694a f9416i;
    private C2994d f9417j;
    private C2992b f9418k;
    private C2698e f9419l;
    private C2696c f9420m;
    private C2724g f9421n;
    private C2639b f9422o;
    private String f9423p;
    private boolean f9424q;

    public C2757d(Context context) {
        this(context, C2779q.m10726a(), null);
    }

    public C2757d(Context context, C2779q c2779q, C2698e c2698e) {
        this.f9408a = new dt();
        this.f9409b = context;
        this.f9410c = c2779q;
        this.f9419l = c2698e;
    }

    private void m10635c(String str) {
        if (this.f9414g == null) {
            m10636d(str);
        }
        this.f9413f = C2784w.m10743b().m10719b(this.f9409b, this.f9424q ? AdSizeParcel.m10499a() : new AdSizeParcel(), this.f9414g, this.f9408a);
        if (this.f9411d != null) {
            this.f9413f.m10398a(new C2774l(this.f9411d));
        }
        if (this.f9412e != null) {
            this.f9413f.m10397a(new C2771k(this.f9412e));
        }
        if (this.f9416i != null) {
            this.f9413f.m10395a(new C2781s(this.f9416i));
        }
        if (this.f9418k != null) {
            this.f9413f.m10401a(new fh(this.f9418k));
        }
        if (this.f9417j != null) {
            this.f9413f.m10402a(new fl(this.f9417j), this.f9415h);
        }
        if (this.f9420m != null) {
            this.f9413f.m10400a(new be(this.f9420m));
        }
        if (this.f9421n != null) {
            this.f9413f.m10396a(this.f9421n.m10372a());
        }
        if (this.f9422o != null) {
            this.f9413f.m10399a(new C2961f(this.f9422o));
        }
        if (this.f9423p != null) {
            this.f9413f.m10403a(this.f9423p);
        }
    }

    private void m10636d(String str) {
        if (this.f9413f == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    public void m10637a() {
        try {
            m10636d("show");
            this.f9413f.m10410f();
        } catch (Throwable e) {
            C2972b.m11584d("Failed to show interstitial.", e);
        }
    }

    public void m10638a(C2301a c2301a) {
        try {
            this.f9411d = c2301a;
            if (this.f9413f != null) {
                this.f9413f.m10398a(c2301a != null ? new C2774l(c2301a) : null);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to set the AdListener.", e);
        }
    }

    public void m10639a(C2639b c2639b) {
        try {
            this.f9422o = c2639b;
            if (this.f9413f != null) {
                this.f9413f.m10399a(c2639b != null ? new C2961f(c2639b) : null);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to set the AdListener.", e);
        }
    }

    public void m10640a(C2646a c2646a) {
        try {
            this.f9412e = c2646a;
            if (this.f9413f != null) {
                this.f9413f.m10397a(c2646a != null ? new C2771k(c2646a) : null);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to set the AdClickListener.", e);
        }
    }

    public void m10641a(C2755b c2755b) {
        try {
            if (this.f9413f == null) {
                m10635c("loadAd");
            }
            if (this.f9413f.m10405a(this.f9410c.m10727a(this.f9409b, c2755b))) {
                this.f9408a.m12363a(c2755b.m10602j());
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to load ad.", e);
        }
    }

    public void m10642a(String str) {
        if (this.f9414g != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.f9414g = str;
    }

    public void m10643a(boolean z) {
        this.f9424q = z;
    }

    public void m10644b(String str) {
        try {
            this.f9423p = str;
            if (this.f9413f != null) {
                this.f9413f.m10403a(str);
            }
        } catch (Throwable e) {
            C2972b.m11584d("Failed to set the AdListener.", e);
        }
    }
}
