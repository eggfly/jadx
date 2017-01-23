package com.google.android.gms.internal;

import aeo$a;
import com.google.ads.mediation.d;
import com.google.ads.mediation.e;
import com.google.ads.mediation.f;
import com.google.ads.mediation.g;
import com.google.ads.mediation.h;
import com.google.ads.mediation.i;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.ads.internal.util.client.b;

@eh
public final class de<NETWORK_EXTRAS extends i, SERVER_PARAMETERS extends h> implements e, g {
    private final ct j6;

    class 1 implements Runnable {
        final /* synthetic */ de DW;
        final /* synthetic */ aeo$a j6;

        1(de deVar, aeo$a aeo_a) {
            this.DW = deVar;
            this.j6 = aeo_a;
        }

        public void run() {
            try {
                this.DW.j6.j6(df.j6(this.j6));
            } catch (Throwable e) {
                b.FH("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ de DW;
        final /* synthetic */ aeo$a j6;

        2(de deVar, aeo$a aeo_a) {
            this.DW = deVar;
            this.j6 = aeo_a;
        }

        public void run() {
            try {
                this.DW.j6.j6(df.j6(this.j6));
            } catch (Throwable e) {
                b.FH("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    public de(ct ctVar) {
        this.j6 = ctVar;
    }

    public void j6(d<?, ?> dVar, aeo$a aeo_a) {
        String valueOf = String.valueOf(aeo_a);
        b.j6(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error. ").append(valueOf).toString());
        if (w.j6().DW()) {
            try {
                this.j6.j6(df.j6(aeo_a));
                return;
            } catch (Throwable e) {
                b.FH("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        b.Hw("onFailedToReceiveAd must be called on the main UI thread.");
        a.j6.post(new 2(this, aeo_a));
    }

    public void j6(f<?, ?> fVar, aeo$a aeo_a) {
        String valueOf = String.valueOf(aeo_a);
        b.j6(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error ").append(valueOf).append(".").toString());
        if (w.j6().DW()) {
            try {
                this.j6.j6(df.j6(aeo_a));
                return;
            } catch (Throwable e) {
                b.FH("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        b.Hw("onFailedToReceiveAd must be called on the main UI thread.");
        a.j6.post(new 1(this, aeo_a));
    }
}
