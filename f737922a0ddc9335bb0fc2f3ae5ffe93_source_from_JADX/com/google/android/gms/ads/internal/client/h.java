package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.internal.bm;
import com.google.android.gms.internal.bn;
import com.google.android.gms.internal.bo;
import com.google.android.gms.internal.bp;

public class h extends com.google.android.gms.ads.internal.client.ac.a {
    private aa j6;

    private class a extends com.google.android.gms.ads.internal.client.ab.a {
        final /* synthetic */ h j6;

        class 1 implements Runnable {
            final /* synthetic */ a j6;

            1(a aVar) {
                this.j6 = aVar;
            }

            public void run() {
                if (this.j6.j6.j6 != null) {
                    try {
                        this.j6.j6.j6.j6(1);
                    } catch (Throwable e) {
                        b.FH("Could not notify onAdFailedToLoad event.", e);
                    }
                }
            }
        }

        private a(h hVar) {
            this.j6 = hVar;
        }

        public String DW() {
            return null;
        }

        public void j6(AdRequestParcel adRequestParcel) {
            b.DW("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
            com.google.android.gms.ads.internal.util.client.a.j6.post(new 1(this));
        }

        public boolean j6() {
            return false;
        }
    }

    public ab j6() {
        return new a();
    }

    public void j6(aa aaVar) {
        this.j6 = aaVar;
    }

    public void j6(ai aiVar) {
    }

    public void j6(NativeAdOptionsParcel nativeAdOptionsParcel) {
    }

    public void j6(bm bmVar) {
    }

    public void j6(bn bnVar) {
    }

    public void j6(String str, bp bpVar, bo boVar) {
    }
}
