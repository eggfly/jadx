package com.google.android.gms.ads.internal.client;

import agg;
import com.google.android.gms.ads.internal.client.ae.a;
import com.google.android.gms.ads.internal.reward.client.d;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.dy;

public class i extends a {
    private aa j6;

    class 1 implements Runnable {
        final /* synthetic */ i j6;

        1(i iVar) {
            this.j6 = iVar;
        }

        public void run() {
            if (this.j6.j6 != null) {
                try {
                    this.j6.j6.j6(1);
                } catch (Throwable e) {
                    b.FH("Could not notify onAdFailedToLoad event.", e);
                }
            }
        }
    }

    public void DW() {
    }

    public boolean EQ() {
        return false;
    }

    public boolean FH() {
        return false;
    }

    public void Hw() {
    }

    public void VH() {
    }

    public void Zo() {
    }

    public void gn() {
    }

    public agg j6() {
        return null;
    }

    public void j6(AdSizeParcel adSizeParcel) {
    }

    public void j6(VideoOptionsParcel videoOptionsParcel) {
    }

    public void j6(aa aaVar) {
        this.j6 = aaVar;
    }

    public void j6(ag agVar) {
    }

    public void j6(ai aiVar) {
    }

    public void j6(z zVar) {
    }

    public void j6(d dVar) {
    }

    public void j6(bb bbVar) {
    }

    public void j6(du duVar) {
    }

    public void j6(dy dyVar, String str) {
    }

    public void j6(String str) {
    }

    public void j6(boolean z) {
    }

    public boolean j6(AdRequestParcel adRequestParcel) {
        b.DW("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        com.google.android.gms.ads.internal.util.client.a.j6.post(new 1(this));
        return false;
    }

    public String tp() {
        return null;
    }

    public AdSizeParcel u7() {
        return null;
    }

    public void v5() {
    }

    public c we() {
        return null;
    }
}
