package com.google.android.gms.ads.internal.reward.mediation.client;

import afe;
import afg;
import afh;
import agh;
import com.google.android.gms.internal.eh;

@eh
public class b implements afh {
    private final a j6;

    public b(a aVar) {
        this.j6 = aVar;
    }

    public void DW(afg afg) {
        com.google.android.gms.common.internal.b.DW("onAdLoaded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdLoaded.");
        try {
            this.j6.DW(agh.j6((Object) afg));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdLoaded.", e);
        }
    }

    public void FH(afg afg) {
        com.google.android.gms.common.internal.b.DW("onAdOpened must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdOpened.");
        try {
            this.j6.FH(agh.j6((Object) afg));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdOpened.", e);
        }
    }

    public void Hw(afg afg) {
        com.google.android.gms.common.internal.b.DW("onVideoStarted must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onVideoStarted.");
        try {
            this.j6.Hw(agh.j6((Object) afg));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onVideoStarted.", e);
        }
    }

    public void Zo(afg afg) {
        com.google.android.gms.common.internal.b.DW("onAdLeftApplication must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdLeftApplication.");
        try {
            this.j6.VH(agh.j6((Object) afg));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdLeftApplication.", e);
        }
    }

    public void j6(afg afg) {
        com.google.android.gms.common.internal.b.DW("onInitializationSucceeded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onInitializationSucceeded.");
        try {
            this.j6.j6(agh.j6((Object) afg));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onInitializationSucceeded.", e);
        }
    }

    public void j6(afg afg, int i) {
        com.google.android.gms.common.internal.b.DW("onAdFailedToLoad must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdFailedToLoad.");
        try {
            this.j6.DW(agh.j6((Object) afg), i);
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdFailedToLoad.", e);
        }
    }

    public void j6(afg afg, afe afe) {
        com.google.android.gms.common.internal.b.DW("onRewarded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onRewarded.");
        if (afe != null) {
            try {
                this.j6.j6(agh.j6((Object) afg), new RewardItemParcel(afe));
                return;
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.b.FH("Could not call onRewarded.", e);
                return;
            }
        }
        this.j6.j6(agh.j6((Object) afg), new RewardItemParcel(afg.getClass().getName(), 1));
    }

    public void v5(afg afg) {
        com.google.android.gms.common.internal.b.DW("onAdClosed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.b.j6("Adapter called onAdClosed.");
        try {
            this.j6.v5(agh.j6((Object) afg));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.b.FH("Could not call onAdClosed.", e);
        }
    }
}
