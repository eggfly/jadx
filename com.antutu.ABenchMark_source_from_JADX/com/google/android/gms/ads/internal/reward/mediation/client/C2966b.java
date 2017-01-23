package com.google.android.gms.ads.internal.reward.mediation.client;

import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.p149d.C2718a;
import com.google.android.gms.ads.p149d.p150a.C2634a;
import com.google.android.gms.ads.p149d.p150a.C2717b;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p151a.C2690b;

@gb
/* renamed from: com.google.android.gms.ads.internal.reward.mediation.client.b */
public class C2966b implements C2717b {
    private final C2963a f10015a;

    public C2966b(C2963a c2963a) {
        this.f10015a = c2963a;
    }

    public void m11509a(C2634a c2634a) {
        C3512u.m14587b("onInitializationSucceeded must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onInitializationSucceeded.");
        try {
            this.f10015a.m11488a(C2690b.m10262a((Object) c2634a));
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onInitializationSucceeded.", e);
        }
    }

    public void m11510a(C2634a c2634a, int i) {
        C3512u.m14587b("onAdFailedToLoad must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdFailedToLoad.");
        try {
            this.f10015a.m11492b(C2690b.m10262a((Object) c2634a), i);
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdFailedToLoad.", e);
        }
    }

    public void m11511a(C2634a c2634a, C2718a c2718a) {
        C3512u.m14587b("onRewarded must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onRewarded.");
        if (c2718a != null) {
            try {
                this.f10015a.m11490a(C2690b.m10262a((Object) c2634a), new RewardItemParcel(c2718a));
                return;
            } catch (Throwable e) {
                C2972b.m11584d("Could not call onRewarded.", e);
                return;
            }
        }
        this.f10015a.m11490a(C2690b.m10262a((Object) c2634a), new RewardItemParcel(c2634a.getClass().getName(), 1));
    }

    public void m11512b(C2634a c2634a) {
        C3512u.m14587b("onAdLoaded must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdLoaded.");
        try {
            this.f10015a.m11491b(C2690b.m10262a((Object) c2634a));
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdLoaded.", e);
        }
    }

    public void m11513c(C2634a c2634a) {
        C3512u.m14587b("onAdOpened must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdOpened.");
        try {
            this.f10015a.m11493c(C2690b.m10262a((Object) c2634a));
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdOpened.", e);
        }
    }

    public void m11514d(C2634a c2634a) {
        C3512u.m14587b("onVideoStarted must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onVideoStarted.");
        try {
            this.f10015a.m11494d(C2690b.m10262a((Object) c2634a));
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onVideoStarted.", e);
        }
    }

    public void m11515e(C2634a c2634a) {
        C3512u.m14587b("onAdClosed must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdClosed.");
        try {
            this.f10015a.m11495e(C2690b.m10262a((Object) c2634a));
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdClosed.", e);
        }
    }

    public void m11516f(C2634a c2634a) {
        C3512u.m14587b("onAdLeftApplication must be called on the main UI thread.");
        C2972b.m11576a("Adapter called onAdLeftApplication.");
        try {
            this.f10015a.m11497g(C2690b.m10262a((Object) c2634a));
        } catch (Throwable e) {
            C2972b.m11584d("Could not call onAdLeftApplication.", e);
        }
    }
}
