package com.google.ads.mediation;

import aer;
import aes$a;
import aet;
import aeu;
import aew;
import aex;
import aey;
import afa;
import afb;
import afc;
import afe;
import aff;
import afg;
import afh;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.ft;
import java.util.Date;
import java.util.Set;

@eh
public abstract class a implements aet, aex, afg, ft {
    protected InterstitialAd DW;
    final aff FH;
    private com.google.android.gms.ads.b Hw;
    private afh VH;
    private InterstitialAd Zo;
    protected AdView j6;
    private Context v5;

    class 1 implements aff {
        final /* synthetic */ a j6;

        1(a aVar) {
            this.j6 = aVar;
        }

        public void DW() {
            this.j6.VH.FH(this.j6);
        }

        public void FH() {
            this.j6.VH.Hw(this.j6);
        }

        public void Hw() {
            this.j6.VH.v5(this.j6);
            this.j6.Zo = null;
        }

        public void j6() {
            this.j6.VH.DW(this.j6);
        }

        public void j6(int i) {
            this.j6.VH.j6(this.j6, i);
        }

        public void j6(afe afe) {
            this.j6.VH.j6(this.j6, afe);
        }

        public void v5() {
            this.j6.VH.Zo(this.j6);
        }
    }

    static class a extends afa {
        private final com.google.android.gms.ads.formats.c Hw;

        public a(com.google.android.gms.ads.formats.c cVar) {
            this.Hw = cVar;
            j6(cVar.DW().toString());
            j6(cVar.FH());
            DW(cVar.Hw().toString());
            j6(cVar.v5());
            FH(cVar.Zo().toString());
            j6(cVar.VH().doubleValue());
            Hw(cVar.gn().toString());
            v5(cVar.u7().toString());
            j6(true);
            DW(true);
        }

        public void j6(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.Hw);
            }
        }
    }

    static class b extends afb {
        private final com.google.android.gms.ads.formats.d Hw;

        public b(com.google.android.gms.ads.formats.d dVar) {
            this.Hw = dVar;
            j6(dVar.DW().toString());
            j6(dVar.FH());
            DW(dVar.Hw().toString());
            j6(dVar.v5());
            FH(dVar.Zo().toString());
            Hw(dVar.VH().toString());
            j6(true);
            DW(true);
        }

        public void j6(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.Hw);
            }
        }
    }

    static final class c extends com.google.android.gms.ads.a implements com.google.android.gms.ads.internal.client.a {
        final aeu DW;
        final a j6;

        public c(a aVar, aeu aeu) {
            this.j6 = aVar;
            this.DW = aeu;
        }

        public void DW() {
            this.DW.DW(this.j6);
        }

        public void FH() {
            this.DW.FH(this.j6);
        }

        public void Hw() {
            this.DW.Hw(this.j6);
        }

        public void j6() {
            this.DW.j6(this.j6);
        }

        public void j6(int i) {
            this.DW.j6(this.j6, i);
        }

        public void v5() {
            this.DW.v5(this.j6);
        }
    }

    static final class d extends com.google.android.gms.ads.a implements com.google.android.gms.ads.internal.client.a {
        final aew DW;
        final a j6;

        public d(a aVar, aew aew) {
            this.j6 = aVar;
            this.DW = aew;
        }

        public void DW() {
            this.DW.DW(this.j6);
        }

        public void FH() {
            this.DW.FH(this.j6);
        }

        public void Hw() {
            this.DW.Hw(this.j6);
        }

        public void j6() {
            this.DW.j6(this.j6);
        }

        public void j6(int i) {
            this.DW.j6(this.j6, i);
        }

        public void v5() {
            this.DW.v5(this.j6);
        }
    }

    static final class e extends com.google.android.gms.ads.a implements com.google.android.gms.ads.formats.c.a, com.google.android.gms.ads.formats.d.a, com.google.android.gms.ads.internal.client.a {
        final aey DW;
        final a j6;

        public e(a aVar, aey aey) {
            this.j6 = aVar;
            this.DW = aey;
        }

        public void DW() {
            this.DW.j6(this.j6);
        }

        public void FH() {
            this.DW.DW(this.j6);
        }

        public void Hw() {
            this.DW.FH(this.j6);
        }

        public void j6() {
        }

        public void j6(int i) {
            this.DW.j6(this.j6, i);
        }

        public void j6(com.google.android.gms.ads.formats.c cVar) {
            this.DW.j6(this.j6, new a(cVar));
        }

        public void j6(com.google.android.gms.ads.formats.d dVar) {
            this.DW.j6(this.j6, new b(dVar));
        }

        public void v5() {
            this.DW.Hw(this.j6);
        }
    }

    public a() {
        this.FH = new 1(this);
    }

    public void DW() {
        if (this.j6 != null) {
            this.j6.DW();
        }
    }

    public void FH() {
        if (this.j6 != null) {
            this.j6.j6();
        }
    }

    public View Hw() {
        return this.j6;
    }

    public void VH() {
        this.Zo.j6();
    }

    public Bundle Zo() {
        return new aes$a().j6(1).j6();
    }

    public boolean gn() {
        return this.VH != null;
    }

    protected abstract Bundle j6(Bundle bundle, Bundle bundle2);

    com.google.android.gms.ads.b.a j6(Context context, String str) {
        return new com.google.android.gms.ads.b.a(context, str);
    }

    com.google.android.gms.ads.c j6(Context context, aer aer, Bundle bundle, Bundle bundle2) {
        com.google.android.gms.ads.c.a aVar = new com.google.android.gms.ads.c.a();
        Date j6 = aer.j6();
        if (j6 != null) {
            aVar.j6(j6);
        }
        int DW = aer.DW();
        if (DW != 0) {
            aVar.j6(DW);
        }
        Set<String> FH = aer.FH();
        if (FH != null) {
            for (String j62 : FH) {
                aVar.j6(j62);
            }
        }
        Location Hw = aer.Hw();
        if (Hw != null) {
            aVar.j6(Hw);
        }
        if (aer.Zo()) {
            aVar.DW(w.j6().j6(context));
        }
        if (aer.v5() != -1) {
            aVar.j6(aer.v5() == 1);
        }
        aVar.DW(aer.VH());
        aVar.j6(AdMobAdapter.class, j6(bundle, bundle2));
        return aVar.j6();
    }

    public String j6(Bundle bundle) {
        return bundle.getString("pubid");
    }

    public void j6() {
        if (this.j6 != null) {
            this.j6.FH();
            this.j6 = null;
        }
        if (this.DW != null) {
            this.DW = null;
        }
        if (this.Hw != null) {
            this.Hw = null;
        }
        if (this.Zo != null) {
            this.Zo = null;
        }
    }

    public void j6(aer aer, Bundle bundle, Bundle bundle2) {
        if (this.v5 == null || this.VH == null) {
            com.google.android.gms.ads.internal.util.client.b.DW("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.Zo = new InterstitialAd(this.v5);
        this.Zo.j6(true);
        this.Zo.j6(j6(bundle));
        this.Zo.j6(this.FH);
        this.Zo.j6(j6(this.v5, aer, bundle2, bundle));
    }

    public void j6(Context context, aer aer, String str, afh afh, Bundle bundle, Bundle bundle2) {
        this.v5 = context.getApplicationContext();
        this.VH = afh;
        this.VH.j6(this);
    }

    public void j6(Context context, aeu aeu, Bundle bundle, com.google.android.gms.ads.d dVar, aer aer, Bundle bundle2) {
        this.j6 = new AdView(context);
        this.j6.setAdSize(new com.google.android.gms.ads.d(dVar.DW(), dVar.j6()));
        this.j6.setAdUnitId(j6(bundle));
        this.j6.setAdListener(new c(this, aeu));
        this.j6.j6(j6(context, aer, bundle2, bundle));
    }

    public void j6(Context context, aew aew, Bundle bundle, aer aer, Bundle bundle2) {
        this.DW = new InterstitialAd(context);
        this.DW.j6(j6(bundle));
        this.DW.j6(new d(this, aew));
        this.DW.j6(j6(context, aer, bundle2, bundle));
    }

    public void j6(Context context, aey aey, Bundle bundle, afc afc, Bundle bundle2) {
        com.google.android.gms.ads.formats.d.a eVar = new e(this, aey);
        com.google.android.gms.ads.b.a j6 = j6(context, bundle.getString("pubid")).j6((com.google.android.gms.ads.a) eVar);
        com.google.android.gms.ads.formats.b gn = afc.gn();
        if (gn != null) {
            j6.j6(gn);
        }
        if (afc.u7()) {
            j6.j6((com.google.android.gms.ads.formats.c.a) eVar);
        }
        if (afc.tp()) {
            j6.j6(eVar);
        }
        this.Hw = j6.j6();
        this.Hw.j6(j6(context, afc, bundle2, bundle));
    }

    public void v5() {
        this.DW.j6();
    }
}
