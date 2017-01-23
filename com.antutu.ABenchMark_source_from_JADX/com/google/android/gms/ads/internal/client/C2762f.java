package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.aa.C2739a;
import com.google.android.gms.ads.internal.client.ab.C2741a;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.C2971a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.bo;
import com.google.android.gms.p146b.bp;
import com.google.android.gms.p146b.bq;
import com.google.android.gms.p146b.br;

/* renamed from: com.google.android.gms.ads.internal.client.f */
public class C2762f extends C2741a {
    private C2772z f9427a;

    /* renamed from: com.google.android.gms.ads.internal.client.f.a */
    private class C2761a extends C2739a {
        final /* synthetic */ C2762f f9426a;

        /* renamed from: com.google.android.gms.ads.internal.client.f.a.1 */
        class C27601 implements Runnable {
            final /* synthetic */ C2761a f9425a;

            C27601(C2761a c2761a) {
                this.f9425a = c2761a;
            }

            public void run() {
                if (this.f9425a.f9426a.f9427a != null) {
                    try {
                        this.f9425a.f9426a.f9427a.m10702a(1);
                    } catch (Throwable e) {
                        C2972b.m11584d("Could not notify onAdFailedToLoad event.", e);
                    }
                }
            }
        }

        private C2761a(C2762f c2762f) {
            this.f9426a = c2762f;
        }

        public void m10647a(AdRequestParcel adRequestParcel) {
            C2972b.m11579b("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
            C2971a.f10085a.post(new C27601(this));
        }

        public boolean m10648a() {
            return false;
        }

        public String m10649b() {
            return null;
        }
    }

    public aa m10651a() {
        return new C2761a();
    }

    public void m10652a(ag agVar) {
    }

    public void m10653a(C2772z c2772z) {
        this.f9427a = c2772z;
    }

    public void m10654a(NativeAdOptionsParcel nativeAdOptionsParcel) {
    }

    public void m10655a(bo boVar) {
    }

    public void m10656a(bp bpVar) {
    }

    public void m10657a(String str, br brVar, bq bqVar) {
    }
}
