package com.google.android.gms.p146b;

import com.google.ads.C2631a.C2622a;
import com.google.ads.mediation.C2656d;
import com.google.ads.mediation.C2657f;
import com.google.ads.mediation.C2661h;
import com.google.ads.mediation.C2663e;
import com.google.ads.mediation.C2664g;
import com.google.ads.mediation.C2667i;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.util.client.C2971a;
import com.google.android.gms.ads.internal.util.client.C2972b;

@gb
/* renamed from: com.google.android.gms.b.ei */
public final class ei<NETWORK_EXTRAS extends C2667i, SERVER_PARAMETERS extends C2661h> implements C2663e, C2664g {
    private final dw f10757a;

    /* renamed from: com.google.android.gms.b.ei.1 */
    class C31621 implements Runnable {
        final /* synthetic */ C2622a f10753a;
        final /* synthetic */ ei f10754b;

        C31621(ei eiVar, C2622a c2622a) {
            this.f10754b = eiVar;
            this.f10753a = c2622a;
        }

        public void run() {
            try {
                this.f10754b.f10757a.m12295a(ej.m12582a(this.f10753a));
            } catch (Throwable e) {
                C2972b.m11584d("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.b.ei.2 */
    class C31632 implements Runnable {
        final /* synthetic */ C2622a f10755a;
        final /* synthetic */ ei f10756b;

        C31632(ei eiVar, C2622a c2622a) {
            this.f10756b = eiVar;
            this.f10755a = c2622a;
        }

        public void run() {
            try {
                this.f10756b.f10757a.m12295a(ej.m12582a(this.f10755a));
            } catch (Throwable e) {
                C2972b.m11584d("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    public ei(dw dwVar) {
        this.f10757a = dwVar;
    }

    public void m12580a(C2656d<?, ?> c2656d, C2622a c2622a) {
        C2972b.m11576a("Adapter called onFailedToReceiveAd with error. " + c2622a);
        if (C2784w.m10741a().m11571b()) {
            try {
                this.f10757a.m12295a(ej.m12582a(c2622a));
                return;
            } catch (Throwable e) {
                C2972b.m11584d("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        C2972b.m11583d("onFailedToReceiveAd must be called on the main UI thread.");
        C2971a.f10085a.post(new C31632(this, c2622a));
    }

    public void m12581a(C2657f<?, ?> c2657f, C2622a c2622a) {
        C2972b.m11576a("Adapter called onFailedToReceiveAd with error " + c2622a + ".");
        if (C2784w.m10741a().m11571b()) {
            try {
                this.f10757a.m12295a(ej.m12582a(c2622a));
                return;
            } catch (Throwable e) {
                C2972b.m11584d("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        C2972b.m11583d("onFailedToReceiveAd must be called on the main UI thread.");
        C2971a.f10085a.post(new C31621(this, c2622a));
    }
}
