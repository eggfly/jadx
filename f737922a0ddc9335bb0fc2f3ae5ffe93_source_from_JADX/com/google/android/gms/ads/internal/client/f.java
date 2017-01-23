package com.google.android.gms.ads.internal.client;

import agg;
import agh;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.doubleclick.c;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.g;
import com.google.android.gms.ads.purchase.b;
import com.google.android.gms.ads.purchase.d;
import com.google.android.gms.internal.bc;
import com.google.android.gms.internal.cp;
import com.google.android.gms.internal.dz;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.eh;
import java.util.concurrent.atomic.AtomicBoolean;

@eh
public class f {
    private final cp DW;
    private ae EQ;
    private final s FH;
    private final AtomicBoolean Hw;
    private c J0;
    private d J8;
    private boolean Mr;
    private String QX;
    private a VH;
    private g Ws;
    private String XL;
    private a Zo;
    private ViewGroup aM;
    private com.google.android.gms.ads.d[] gn;
    private boolean j3;
    final y j6;
    private e tp;
    private com.google.android.gms.ads.doubleclick.a u7;
    private final com.google.android.gms.ads.f v5;
    private b we;

    class 1 extends y {
        final /* synthetic */ f j6;

        1(f fVar) {
            this.j6 = fVar;
        }

        public void j6() {
            this.j6.v5.j6(this.j6.J0());
            super.j6();
        }

        public void j6(int i) {
            this.j6.v5.j6(this.j6.J0());
            super.j6(i);
        }
    }

    public f(ViewGroup viewGroup) {
        this(viewGroup, null, false, s.j6(), false);
    }

    public f(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, s.j6(), false);
    }

    f(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, s sVar, ae aeVar, boolean z2) {
        this.DW = new cp();
        this.v5 = new com.google.android.gms.ads.f();
        this.j6 = new 1(this);
        this.aM = viewGroup;
        this.FH = sVar;
        this.EQ = aeVar;
        this.Hw = new AtomicBoolean(false);
        this.j3 = z2;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzk com_google_android_gms_ads_internal_client_zzk = new zzk(context, attributeSet);
                this.gn = com_google_android_gms_ads_internal_client_zzk.j6(z);
                this.QX = com_google_android_gms_ads_internal_client_zzk.j6();
                if (viewGroup.isInEditMode()) {
                    w.j6().j6(viewGroup, j6(context, this.gn[0], this.j3), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                w.j6().j6(viewGroup, new AdSizeParcel(context, com.google.android.gms.ads.d.j6), e.getMessage(), e.getMessage());
            }
        }
    }

    f(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, s sVar, boolean z2) {
        this(viewGroup, attributeSet, z, sVar, null, z2);
    }

    public f(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, boolean z2) {
        this(viewGroup, attributeSet, z, s.j6(), z2);
    }

    public f(ViewGroup viewGroup, boolean z) {
        this(viewGroup, null, false, s.j6(), z);
    }

    private void XL() {
        try {
            agg j6 = this.EQ.j6();
            if (j6 != null) {
                this.aM.addView((View) agh.j6(j6));
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to get an ad frame.", e);
        }
    }

    private static AdSizeParcel j6(Context context, com.google.android.gms.ads.d dVar, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, dVar);
        adSizeParcel.j6(z);
        return adSizeParcel;
    }

    private static AdSizeParcel j6(Context context, com.google.android.gms.ads.d[] dVarArr, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, dVarArr);
        adSizeParcel.j6(z);
        return adSizeParcel;
    }

    public a DW() {
        return this.VH;
    }

    public void DW(com.google.android.gms.ads.d... dVarArr) {
        this.gn = dVarArr;
        try {
            if (this.EQ != null) {
                this.EQ.j6(j6(this.aM.getContext(), this.gn, this.j3));
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to set the ad size.", e);
        }
        this.aM.requestLayout();
    }

    public String EQ() {
        try {
            if (this.EQ != null) {
                return this.EQ.tp();
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public com.google.android.gms.ads.d FH() {
        try {
            if (this.EQ != null) {
                AdSizeParcel u7 = this.EQ.u7();
                if (u7 != null) {
                    return u7.DW();
                }
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to get the current AdSize.", e);
        }
        return this.gn != null ? this.gn[0] : null;
    }

    public com.google.android.gms.ads.d[] Hw() {
        return this.gn;
    }

    public c J0() {
        c cVar = null;
        if (this.EQ != null) {
            try {
                cVar = this.EQ.we();
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.b.FH("Failed to retrieve VideoController.", e);
            }
        }
        return cVar;
    }

    public g J8() {
        return this.Ws;
    }

    protected ae QX() {
        Context context = this.aM.getContext();
        AdSizeParcel j6 = j6(context, this.gn, this.j3);
        return j6(j6) ? w.DW().j6(context, j6, this.QX) : w.DW().j6(context, j6, this.QX, this.DW);
    }

    public b VH() {
        return this.we;
    }

    void Ws() {
        if ((this.gn == null || this.QX == null) && this.EQ == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        this.EQ = QX();
        this.EQ.j6(new o(this.j6));
        if (this.Zo != null) {
            this.EQ.j6(new n(this.Zo));
        }
        if (this.u7 != null) {
            this.EQ.j6(new u(this.u7));
        }
        if (this.we != null) {
            this.EQ.j6(new dz(this.we));
        }
        if (this.J8 != null) {
            this.EQ.j6(new ed(this.J8), this.XL);
        }
        if (this.J0 != null) {
            this.EQ.j6(new bc(this.J0));
        }
        if (this.tp != null) {
            this.EQ.j6(this.tp.j6());
        }
        if (this.Ws != null) {
            this.EQ.j6(new VideoOptionsParcel(this.Ws));
        }
        this.EQ.j6(this.Mr);
        XL();
    }

    public com.google.android.gms.ads.doubleclick.a Zo() {
        return this.u7;
    }

    public c gn() {
        return this.J0;
    }

    public void j6() {
        try {
            if (this.EQ != null) {
                this.EQ.DW();
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to destroy AdView.", e);
        }
    }

    public void j6(a aVar) {
        this.VH = aVar;
        this.j6.j6(aVar);
    }

    public void j6(com.google.android.gms.ads.doubleclick.a aVar) {
        try {
            this.u7 = aVar;
            if (this.EQ != null) {
                this.EQ.j6(aVar != null ? new u(aVar) : null);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to set the AppEventListener.", e);
        }
    }

    public void j6(c cVar) {
        this.J0 = cVar;
        try {
            if (this.EQ != null) {
                this.EQ.j6(cVar != null ? new bc(cVar) : null);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void j6(e eVar) {
        this.tp = eVar;
        try {
            if (this.EQ != null) {
                this.EQ.j6(this.tp == null ? null : this.tp.j6());
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to set correlator.", e);
        }
    }

    public void j6(g gVar) {
        this.Ws = gVar;
        try {
            if (this.EQ != null) {
                this.EQ.j6(gVar == null ? null : new VideoOptionsParcel(gVar));
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to set video options.", e);
        }
    }

    public void j6(a aVar) {
        try {
            this.Zo = aVar;
            if (this.EQ != null) {
                this.EQ.j6(aVar != null ? new n(aVar) : null);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to set the AdClickListener.", e);
        }
    }

    public void j6(e eVar) {
        try {
            if (this.EQ == null) {
                Ws();
            }
            if (this.EQ.j6(this.FH.j6(this.aM.getContext(), eVar))) {
                this.DW.j6(eVar.tp());
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to load ad.", e);
        }
    }

    public void j6(b bVar) {
        if (this.J8 != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.we = bVar;
            if (this.EQ != null) {
                this.EQ.j6(bVar != null ? new dz(bVar) : null);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void j6(String str) {
        if (this.QX != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.QX = str;
    }

    public void j6(boolean z) {
        this.Mr = z;
        try {
            if (this.EQ != null) {
                this.EQ.j6(this.Mr);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to set manual impressions.", e);
        }
    }

    public void j6(com.google.android.gms.ads.d... dVarArr) {
        if (this.gn != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        DW(dVarArr);
    }

    public boolean j6(AdSizeParcel adSizeParcel) {
        return "search_v2".equals(adSizeParcel.DW);
    }

    public void tp() {
        try {
            if (this.EQ != null) {
                this.EQ.v5();
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to call resume.", e);
        }
    }

    public void u7() {
        try {
            if (this.EQ != null) {
                this.EQ.Hw();
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to call pause.", e);
        }
    }

    public String v5() {
        return this.QX;
    }

    public com.google.android.gms.ads.f we() {
        return this.v5;
    }
}
