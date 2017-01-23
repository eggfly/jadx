package com.google.android.gms.ads.internal.client;

import agh;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.reward.client.f;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.internal.bf;
import com.google.android.gms.internal.bq;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.do;
import com.google.android.gms.internal.dp;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.ea;
import com.google.android.gms.internal.eh;

@eh
public class v {
    private final Object DW;
    private final q FH;
    private final p Hw;
    private final f VH;
    private final bq Zo;
    private final ea gn;
    private ah j6;
    private final do u7;
    private final g v5;

    private abstract class a<T> {
        final /* synthetic */ v Zo;

        private a(v vVar) {
            this.Zo = vVar;
        }

        protected abstract T DW();

        protected abstract T DW(ah ahVar);

        protected final T FH() {
            T t = null;
            ah j6 = this.Zo.DW();
            if (j6 == null) {
                b.Hw("ClientApi class cannot be loaded.");
            } else {
                try {
                    t = DW(j6);
                } catch (Throwable e) {
                    b.FH("Cannot invoke local loader using ClientApi class", e);
                }
            }
            return t;
        }
    }

    class 1 extends a<ae> {
        final /* synthetic */ AdSizeParcel DW;
        final /* synthetic */ String FH;
        final /* synthetic */ cr Hw;
        final /* synthetic */ Context j6;
        final /* synthetic */ v v5;

        1(v vVar, Context context, AdSizeParcel adSizeParcel, String str, cr crVar) {
            this.v5 = vVar;
            this.j6 = context;
            this.DW = adSizeParcel;
            this.FH = str;
            this.Hw = crVar;
            super(null);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public /* synthetic */ Object DW(ah ahVar) {
            return j6(ahVar);
        }

        public ae j6() {
            ae j6 = this.v5.FH.j6(this.j6, this.DW, this.FH, this.Hw, 1);
            if (j6 != null) {
                return j6;
            }
            this.v5.j6(this.j6, "banner");
            return new i();
        }

        public ae j6(ah ahVar) {
            return ahVar.j6(agh.j6(this.j6), this.DW, this.FH, this.Hw, l.j6);
        }
    }

    class 2 extends a<ae> {
        final /* synthetic */ AdSizeParcel DW;
        final /* synthetic */ String FH;
        final /* synthetic */ v Hw;
        final /* synthetic */ Context j6;

        2(v vVar, Context context, AdSizeParcel adSizeParcel, String str) {
            this.Hw = vVar;
            this.j6 = context;
            this.DW = adSizeParcel;
            this.FH = str;
            super(null);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public /* synthetic */ Object DW(ah ahVar) {
            return j6(ahVar);
        }

        public ae j6() {
            ae j6 = this.Hw.FH.j6(this.j6, this.DW, this.FH, null, 3);
            if (j6 != null) {
                return j6;
            }
            this.Hw.j6(this.j6, "search");
            return new i();
        }

        public ae j6(ah ahVar) {
            return ahVar.j6(agh.j6(this.j6), this.DW, this.FH, (int) l.j6);
        }
    }

    class 3 extends a<ae> {
        final /* synthetic */ AdSizeParcel DW;
        final /* synthetic */ String FH;
        final /* synthetic */ cr Hw;
        final /* synthetic */ Context j6;
        final /* synthetic */ v v5;

        3(v vVar, Context context, AdSizeParcel adSizeParcel, String str, cr crVar) {
            this.v5 = vVar;
            this.j6 = context;
            this.DW = adSizeParcel;
            this.FH = str;
            this.Hw = crVar;
            super(null);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public /* synthetic */ Object DW(ah ahVar) {
            return j6(ahVar);
        }

        public ae j6() {
            ae j6 = this.v5.FH.j6(this.j6, this.DW, this.FH, this.Hw, 2);
            if (j6 != null) {
                return j6;
            }
            this.v5.j6(this.j6, "interstitial");
            return new i();
        }

        public ae j6(ah ahVar) {
            return ahVar.DW(agh.j6(this.j6), this.DW, this.FH, this.Hw, l.j6);
        }
    }

    class 4 extends a<ac> {
        final /* synthetic */ String DW;
        final /* synthetic */ cr FH;
        final /* synthetic */ v Hw;
        final /* synthetic */ Context j6;

        4(v vVar, Context context, String str, cr crVar) {
            this.Hw = vVar;
            this.j6 = context;
            this.DW = str;
            this.FH = crVar;
            super(null);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public /* synthetic */ Object DW(ah ahVar) {
            return j6(ahVar);
        }

        public ac j6() {
            ac j6 = this.Hw.Hw.j6(this.j6, this.DW, this.FH);
            if (j6 != null) {
                return j6;
            }
            this.Hw.j6(this.j6, "native_ad");
            return new h();
        }

        public ac j6(ah ahVar) {
            return ahVar.j6(agh.j6(this.j6), this.DW, this.FH, (int) l.j6);
        }
    }

    class 5 extends a<bf> {
        final /* synthetic */ FrameLayout DW;
        final /* synthetic */ Context FH;
        final /* synthetic */ v Hw;
        final /* synthetic */ FrameLayout j6;

        5(v vVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
            this.Hw = vVar;
            this.j6 = frameLayout;
            this.DW = frameLayout2;
            this.FH = context;
            super(null);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public /* synthetic */ Object DW(ah ahVar) {
            return j6(ahVar);
        }

        public bf j6() {
            bf j6 = this.Hw.Zo.j6(this.FH, this.j6, this.DW);
            if (j6 != null) {
                return j6;
            }
            this.Hw.j6(this.FH, "native_ad_view_delegate");
            return new j();
        }

        public bf j6(ah ahVar) {
            return ahVar.j6(agh.j6(this.j6), agh.j6(this.DW));
        }
    }

    class 6 extends a<dv> {
        final /* synthetic */ v DW;
        final /* synthetic */ Activity j6;

        6(v vVar, Activity activity) {
            this.DW = vVar;
            this.j6 = activity;
            super(null);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public /* synthetic */ Object DW(ah ahVar) {
            return j6(ahVar);
        }

        public dv j6() {
            dv j6 = this.DW.gn.j6(this.j6);
            if (j6 != null) {
                return j6;
            }
            this.DW.j6(this.j6, "iap");
            return null;
        }

        public dv j6(ah ahVar) {
            return ahVar.DW(agh.j6(this.j6));
        }
    }

    class 7 extends a<dp> {
        final /* synthetic */ v DW;
        final /* synthetic */ Activity j6;

        7(v vVar, Activity activity) {
            this.DW = vVar;
            this.j6 = activity;
            super(null);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public /* synthetic */ Object DW(ah ahVar) {
            return j6(ahVar);
        }

        public dp j6() {
            dp j6 = this.DW.u7.j6(this.j6);
            if (j6 != null) {
                return j6;
            }
            this.DW.j6(this.j6, "ad_overlay");
            return null;
        }

        public dp j6(ah ahVar) {
            return ahVar.FH(agh.j6(this.j6));
        }
    }

    public v(q qVar, p pVar, g gVar, bq bqVar, f fVar, ea eaVar, do doVar) {
        this.DW = new Object();
        this.FH = qVar;
        this.Hw = pVar;
        this.v5 = gVar;
        this.Zo = bqVar;
        this.VH = fVar;
        this.gn = eaVar;
        this.u7 = doVar;
    }

    private ah DW() {
        ah ahVar;
        synchronized (this.DW) {
            if (this.j6 == null) {
                this.j6 = j6();
            }
            ahVar = this.j6;
        }
        return ahVar;
    }

    private static ah j6() {
        try {
            Object newInstance = v.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return com.google.android.gms.ads.internal.client.ah.a.j6((IBinder) newInstance);
            }
            b.Hw("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Throwable e) {
            b.FH("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    private <T> T j6(Context context, boolean z, a<T> aVar) {
        if (!(z || w.j6().DW(context))) {
            b.j6("Google Play Services is not available");
            z = true;
        }
        T FH;
        if (z) {
            FH = aVar.FH();
            return FH == null ? aVar.DW() : FH;
        } else {
            FH = aVar.DW();
            return FH == null ? aVar.FH() : FH;
        }
    }

    private void j6(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        w.j6().j6(context, null, "gmob-apps", bundle, true);
    }

    private static boolean j6(Activity activity, String str) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra(str)) {
            return intent.getBooleanExtra(str, false);
        }
        b.DW("useClientJar flag not found in activity intent extras.");
        return false;
    }

    public ae DW(Context context, AdSizeParcel adSizeParcel, String str, cr crVar) {
        return (ae) j6(context, false, new 3(this, context, adSizeParcel, str, crVar));
    }

    public dp DW(Activity activity) {
        return (dp) j6((Context) activity, j6(activity, "com.google.android.gms.ads.internal.overlay.useClientJar"), new 7(this, activity));
    }

    public ac j6(Context context, String str, cr crVar) {
        return (ac) j6(context, false, new 4(this, context, str, crVar));
    }

    public ae j6(Context context, AdSizeParcel adSizeParcel, String str) {
        return (ae) j6(context, false, new 2(this, context, adSizeParcel, str));
    }

    public ae j6(Context context, AdSizeParcel adSizeParcel, String str, cr crVar) {
        return (ae) j6(context, false, new 1(this, context, adSizeParcel, str, crVar));
    }

    public bf j6(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (bf) j6(context, false, new 5(this, frameLayout, frameLayout2, context));
    }

    public dv j6(Activity activity) {
        return (dv) j6((Context) activity, j6(activity, "com.google.android.gms.ads.internal.purchase.useClientJar"), new 6(this, activity));
    }
}
