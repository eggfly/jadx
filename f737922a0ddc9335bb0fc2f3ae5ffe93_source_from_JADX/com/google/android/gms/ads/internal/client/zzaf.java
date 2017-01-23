package com.google.android.gms.ads.internal.client;

import aff;
import android.content.Context;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.doubleclick.c;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.internal.reward.client.g;
import com.google.android.gms.ads.purchase.b;
import com.google.android.gms.ads.purchase.d;
import com.google.android.gms.internal.bc;
import com.google.android.gms.internal.cp;
import com.google.android.gms.internal.dz;
import com.google.android.gms.internal.ed;
import com.google.android.gms.internal.eh;

@eh
public class zzaf {
    private final Context DW;
    private b EQ;
    private final s FH;
    private a Hw;
    private c J0;
    private e J8;
    private boolean QX;
    private String VH;
    private aff Ws;
    private ae Zo;
    private String gn;
    private final cp j6;
    private d tp;
    private com.google.android.gms.ads.doubleclick.a u7;
    private a v5;
    private PublisherInterstitialAd we;

    public zzaf(Context context) {
        this(context, s.j6(), null);
    }

    public zzaf(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, s.j6(), publisherInterstitialAd);
    }

    public zzaf(Context context, s sVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.j6 = new cp();
        this.DW = context;
        this.FH = sVar;
        this.we = publisherInterstitialAd;
    }

    private void DW(String str) {
        if (this.VH == null) {
            FH(str);
        }
        this.Zo = w.DW().DW(this.DW, this.QX ? AdSizeParcel.j6() : new AdSizeParcel(), this.VH, this.j6);
        if (this.Hw != null) {
            this.Zo.j6(new o(this.Hw));
        }
        if (this.v5 != null) {
            this.Zo.j6(new n(this.v5));
        }
        if (this.u7 != null) {
            this.Zo.j6(new u(this.u7));
        }
        if (this.EQ != null) {
            this.Zo.j6(new dz(this.EQ));
        }
        if (this.tp != null) {
            this.Zo.j6(new ed(this.tp), this.gn);
        }
        if (this.J0 != null) {
            this.Zo.j6(new bc(this.J0));
        }
        if (this.J8 != null) {
            this.Zo.j6(this.J8.j6());
        }
        if (this.Ws != null) {
            this.Zo.j6(new g(this.Ws));
        }
    }

    private void FH(String str) {
        if (this.Zo == null) {
            throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 63).append("The ad unit ID must be set on InterstitialAd before ").append(str).append(" is called.").toString());
        }
    }

    public void j6() {
        try {
            FH("show");
            this.Zo.Zo();
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to show interstitial.", e);
        }
    }

    public void j6(aff aff) {
        try {
            this.Ws = aff;
            if (this.Zo != null) {
                this.Zo.j6(aff != null ? new g(aff) : null);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to set the AdListener.", e);
        }
    }

    public void j6(a aVar) {
        try {
            this.Hw = aVar;
            if (this.Zo != null) {
                this.Zo.j6(aVar != null ? new o(aVar) : null);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to set the AdListener.", e);
        }
    }

    public void j6(a aVar) {
        try {
            this.v5 = aVar;
            if (this.Zo != null) {
                this.Zo.j6(aVar != null ? new n(aVar) : null);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to set the AdClickListener.", e);
        }
    }

    public void j6(e eVar) {
        try {
            if (this.Zo == null) {
                DW("loadAd");
            }
            if (this.Zo.j6(this.FH.j6(this.DW, eVar))) {
                this.j6.j6(eVar.tp());
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Failed to load ad.", e);
        }
    }

    public void j6(String str) {
        if (this.VH != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.VH = str;
    }

    public void j6(boolean z) {
        this.QX = z;
    }
}
