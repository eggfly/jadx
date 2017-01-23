package com.google.android.gms.p146b;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.C2726i;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.C2963a;
import com.google.android.gms.ads.internal.reward.mediation.client.C2966b;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.mediation.C2633b;
import com.google.android.gms.ads.mediation.C2635c;
import com.google.android.gms.ads.mediation.C2636g;
import com.google.android.gms.ads.mediation.C2637e;
import com.google.android.gms.ads.mediation.C2641i;
import com.google.android.gms.ads.mediation.C2642j;
import com.google.android.gms.ads.mediation.C2644k;
import com.google.android.gms.ads.p149d.p150a.C2634a;
import com.google.android.gms.p146b.dv.C3153a;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.ec */
public final class ec extends C3153a {
    private final C2633b f10736a;
    private ed f10737b;

    public ec(C2633b c2633b) {
        this.f10736a = c2633b;
    }

    private Bundle m12482a(String str, int i, String str2) {
        C2972b.m11583d("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    bundle2.putString(str3, jSONObject.getString(str3));
                }
                bundle = bundle2;
            }
            if (this.f10736a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            C2972b.m11584d("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public C2687a m12483a() {
        if (this.f10736a instanceof C2635c) {
            try {
                return C2690b.m10262a(((C2635c) this.f10736a).m10145d());
            } catch (Throwable th) {
                C2972b.m11584d("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            C2972b.m11583d("MediationAdapter is not a MediationBannerAdapter: " + this.f10736a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m12484a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, C2963a c2963a, String str2) {
        if (this.f10736a instanceof C2634a) {
            C2972b.m11576a("Initialize rewarded video adapter.");
            try {
                C2634a c2634a = (C2634a) this.f10736a;
                c2634a.m10140a((Context) C2690b.m10263a(c2687a), new eb(adRequestParcel.f9308b == -1 ? null : new Date(adRequestParcel.f9308b), adRequestParcel.f9310d, adRequestParcel.f9311e != null ? new HashSet(adRequestParcel.f9311e) : null, adRequestParcel.f9317k, adRequestParcel.f9312f, adRequestParcel.f9313g, adRequestParcel.f9324r), str, new C2966b(c2963a), m12482a(str2, adRequestParcel.f9313g, null), adRequestParcel.f9319m != null ? adRequestParcel.f9319m.getBundle(c2634a.getClass().getName()) : null);
            } catch (Throwable th) {
                C2972b.m11584d("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            C2972b.m11583d("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.f10736a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m12485a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, dw dwVar) {
        m12486a(c2687a, adRequestParcel, str, null, dwVar);
    }

    public void m12486a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, String str2, dw dwVar) {
        if (this.f10736a instanceof C2637e) {
            C2972b.m11576a("Requesting interstitial ad from adapter.");
            try {
                C2637e c2637e = (C2637e) this.f10736a;
                c2637e.m10147a((Context) C2690b.m10263a(c2687a), new ed(dwVar), m12482a(str, adRequestParcel.f9313g, str2), new eb(adRequestParcel.f9308b == -1 ? null : new Date(adRequestParcel.f9308b), adRequestParcel.f9310d, adRequestParcel.f9311e != null ? new HashSet(adRequestParcel.f9311e) : null, adRequestParcel.f9317k, adRequestParcel.f9312f, adRequestParcel.f9313g, adRequestParcel.f9324r), adRequestParcel.f9319m != null ? adRequestParcel.f9319m.getBundle(c2637e.getClass().getName()) : null);
            } catch (Throwable th) {
                C2972b.m11584d("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            C2972b.m11583d("MediationAdapter is not a MediationInterstitialAdapter: " + this.f10736a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m12487a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, String str2, dw dwVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
        if (this.f10736a instanceof C2636g) {
            try {
                C2636g c2636g = (C2636g) this.f10736a;
                eg egVar = new eg(adRequestParcel.f9308b == -1 ? null : new Date(adRequestParcel.f9308b), adRequestParcel.f9310d, adRequestParcel.f9311e != null ? new HashSet(adRequestParcel.f9311e) : null, adRequestParcel.f9317k, adRequestParcel.f9312f, adRequestParcel.f9313g, nativeAdOptionsParcel, list, adRequestParcel.f9324r);
                Bundle bundle = adRequestParcel.f9319m != null ? adRequestParcel.f9319m.getBundle(c2636g.getClass().getName()) : null;
                this.f10737b = new ed(dwVar);
                c2636g.m10146a((Context) C2690b.m10263a(c2687a), this.f10737b, m12482a(str, adRequestParcel.f9313g, str2), egVar, bundle);
            } catch (Throwable th) {
                C2972b.m11584d("Could not request native ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            C2972b.m11583d("MediationAdapter is not a MediationNativeAdapter: " + this.f10736a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m12488a(C2687a c2687a, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, dw dwVar) {
        m12489a(c2687a, adSizeParcel, adRequestParcel, str, null, dwVar);
    }

    public void m12489a(C2687a c2687a, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, dw dwVar) {
        if (this.f10736a instanceof C2635c) {
            C2972b.m11576a("Requesting banner ad from adapter.");
            try {
                C2635c c2635c = (C2635c) this.f10736a;
                c2635c.m10144a((Context) C2690b.m10263a(c2687a), new ed(dwVar), m12482a(str, adRequestParcel.f9313g, str2), C2726i.m10380a(adSizeParcel.f9330f, adSizeParcel.f9327c, adSizeParcel.f9326b), new eb(adRequestParcel.f9308b == -1 ? null : new Date(adRequestParcel.f9308b), adRequestParcel.f9310d, adRequestParcel.f9311e != null ? new HashSet(adRequestParcel.f9311e) : null, adRequestParcel.f9317k, adRequestParcel.f9312f, adRequestParcel.f9313g, adRequestParcel.f9324r), adRequestParcel.f9319m != null ? adRequestParcel.f9319m.getBundle(c2635c.getClass().getName()) : null);
            } catch (Throwable th) {
                C2972b.m11584d("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            C2972b.m11583d("MediationAdapter is not a MediationBannerAdapter: " + this.f10736a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m12490a(AdRequestParcel adRequestParcel, String str) {
        m12491a(adRequestParcel, str, null);
    }

    public void m12491a(AdRequestParcel adRequestParcel, String str, String str2) {
        if (this.f10736a instanceof C2634a) {
            C2972b.m11576a("Requesting rewarded video ad from adapter.");
            try {
                C2634a c2634a = (C2634a) this.f10736a;
                c2634a.m10141a(new eb(adRequestParcel.f9308b == -1 ? null : new Date(adRequestParcel.f9308b), adRequestParcel.f9310d, adRequestParcel.f9311e != null ? new HashSet(adRequestParcel.f9311e) : null, adRequestParcel.f9317k, adRequestParcel.f9312f, adRequestParcel.f9313g, adRequestParcel.f9324r), m12482a(str, adRequestParcel.f9313g, str2), adRequestParcel.f9319m != null ? adRequestParcel.f9319m.getBundle(c2634a.getClass().getName()) : null);
            } catch (Throwable th) {
                C2972b.m11584d("Could not load rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            C2972b.m11583d("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.f10736a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m12492b() {
        if (this.f10736a instanceof C2637e) {
            C2972b.m11576a("Showing interstitial from adapter.");
            try {
                ((C2637e) this.f10736a).m10148e();
            } catch (Throwable th) {
                C2972b.m11584d("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            C2972b.m11583d("MediationAdapter is not a MediationInterstitialAdapter: " + this.f10736a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m12493c() {
        try {
            this.f10736a.m10137a();
        } catch (Throwable th) {
            C2972b.m11584d("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void m12494d() {
        try {
            this.f10736a.m10138b();
        } catch (Throwable th) {
            C2972b.m11584d("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void m12495e() {
        try {
            this.f10736a.m10139c();
        } catch (Throwable th) {
            C2972b.m11584d("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void m12496f() {
        if (this.f10736a instanceof C2634a) {
            C2972b.m11576a("Show rewarded video ad from adapter.");
            try {
                ((C2634a) this.f10736a).m10142g();
            } catch (Throwable th) {
                C2972b.m11584d("Could not show rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            C2972b.m11583d("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.f10736a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public boolean m12497g() {
        if (this.f10736a instanceof C2634a) {
            C2972b.m11576a("Check if adapter is initialized.");
            try {
                return ((C2634a) this.f10736a).m10143h();
            } catch (Throwable th) {
                C2972b.m11584d("Could not check if adapter is initialized.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            C2972b.m11583d("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.f10736a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public dz m12498h() {
        C2641i a = this.f10737b.m12503a();
        return a instanceof C2642j ? new ee((C2642j) a) : null;
    }

    public ea m12499i() {
        C2641i a = this.f10737b.m12503a();
        return a instanceof C2644k ? new ef((C2644k) a) : null;
    }

    public Bundle m12500j() {
        if (this.f10736a instanceof is) {
            return ((is) this.f10736a).m13426e();
        }
        C2972b.m11583d("MediationAdapter is not a v2 MediationBannerAdapter: " + this.f10736a.getClass().getCanonicalName());
        return new Bundle();
    }

    public Bundle m12501k() {
        if (this.f10736a instanceof iu) {
            return ((iu) this.f10736a).m10149f();
        }
        C2972b.m11583d("MediationAdapter is not a v2 MediationInterstitialAdapter: " + this.f10736a.getClass().getCanonicalName());
        return new Bundle();
    }

    public Bundle m12502l() {
        return new Bundle();
    }
}
