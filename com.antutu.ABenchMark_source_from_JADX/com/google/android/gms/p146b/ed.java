package com.google.android.gms.p146b;

import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.mediation.C2635c;
import com.google.android.gms.ads.mediation.C2636g;
import com.google.android.gms.ads.mediation.C2637e;
import com.google.android.gms.ads.mediation.C2641i;
import com.google.android.gms.ads.mediation.C2987d;
import com.google.android.gms.ads.mediation.C2988f;
import com.google.android.gms.ads.mediation.C2989h;
import com.google.android.gms.common.internal.C3512u;

@gb
/* renamed from: com.google.android.gms.b.ed */
public final class ed implements C2987d, C2988f, C2989h {
    private final dw f10738a;
    private C2641i f10739b;

    public ed(dw dwVar) {
        this.f10738a = dwVar;
    }

    public C2641i m12503a() {
        return this.f10739b;
    }

    public void m12504a(C2635c c2635c) {
        C3512u.m14587b("onAdLoaded must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdLoaded.");
        try {
            this.f10738a.m12300e();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdLoaded.", e);
        }
    }

    public void m12505a(C2635c c2635c, int i) {
        C3512u.m14587b("onAdFailedToLoad must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.f10738a.m12295a(i);
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdFailedToLoad.", e);
        }
    }

    public void m12506a(C2637e c2637e) {
        C3512u.m14587b("onAdLoaded must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdLoaded.");
        try {
            this.f10738a.m12300e();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdLoaded.", e);
        }
    }

    public void m12507a(C2637e c2637e, int i) {
        C3512u.m14587b("onAdFailedToLoad must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.f10738a.m12295a(i);
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdFailedToLoad.", e);
        }
    }

    public void m12508a(C2636g c2636g) {
        C3512u.m14587b("onAdOpened must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdOpened.");
        try {
            this.f10738a.m12299d();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdOpened.", e);
        }
    }

    public void m12509a(C2636g c2636g, int i) {
        C3512u.m14587b("onAdFailedToLoad must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.f10738a.m12295a(i);
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdFailedToLoad.", e);
        }
    }

    public void m12510a(C2636g c2636g, C2641i c2641i) {
        C3512u.m14587b("onAdLoaded must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdLoaded.");
        this.f10739b = c2641i;
        try {
            this.f10738a.m12300e();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdLoaded.", e);
        }
    }

    public void m12511b(C2635c c2635c) {
        C3512u.m14587b("onAdOpened must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdOpened.");
        try {
            this.f10738a.m12299d();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdOpened.", e);
        }
    }

    public void m12512b(C2637e c2637e) {
        C3512u.m14587b("onAdOpened must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdOpened.");
        try {
            this.f10738a.m12299d();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdOpened.", e);
        }
    }

    public void m12513b(C2636g c2636g) {
        C3512u.m14587b("onAdClosed must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdClosed.");
        try {
            this.f10738a.m12297b();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdClosed.", e);
        }
    }

    public void m12514c(C2635c c2635c) {
        C3512u.m14587b("onAdClosed must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdClosed.");
        try {
            this.f10738a.m12297b();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdClosed.", e);
        }
    }

    public void m12515c(C2637e c2637e) {
        C3512u.m14587b("onAdClosed must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdClosed.");
        try {
            this.f10738a.m12297b();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdClosed.", e);
        }
    }

    public void m12516c(C2636g c2636g) {
        C3512u.m14587b("onAdLeftApplication must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdLeftApplication.");
        try {
            this.f10738a.m12298c();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdLeftApplication.", e);
        }
    }

    public void m12517d(C2635c c2635c) {
        C3512u.m14587b("onAdLeftApplication must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdLeftApplication.");
        try {
            this.f10738a.m12298c();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdLeftApplication.", e);
        }
    }

    public void m12518d(C2637e c2637e) {
        C3512u.m14587b("onAdLeftApplication must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdLeftApplication.");
        try {
            this.f10738a.m12298c();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdLeftApplication.", e);
        }
    }

    public void m12519d(C2636g c2636g) {
        C3512u.m14587b("onAdClicked must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdClicked.");
        try {
            this.f10738a.m12294a();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdClicked.", e);
        }
    }

    public void m12520e(C2635c c2635c) {
        C3512u.m14587b("onAdClicked must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdClicked.");
        try {
            this.f10738a.m12294a();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdClicked.", e);
        }
    }

    public void m12521e(C2637e c2637e) {
        C3512u.m14587b("onAdClicked must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdClicked.");
        try {
            this.f10738a.m12294a();
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdClicked.", e);
        }
    }
}
