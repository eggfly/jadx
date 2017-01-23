package com.google.android.gms.p146b;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.C2651c;
import com.google.ads.mediation.C2656d;
import com.google.ads.mediation.C2657f;
import com.google.ads.mediation.C2661h;
import com.google.ads.mediation.C2667i;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.C2963a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.dv.C3153a;
import com.google.android.gms.p151a.C2687a;
import com.google.android.gms.p151a.C2690b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.eh */
public final class eh<NETWORK_EXTRAS extends C2667i, SERVER_PARAMETERS extends C2661h> extends C3153a {
    private final C2651c<NETWORK_EXTRAS, SERVER_PARAMETERS> f10751a;
    private final NETWORK_EXTRAS f10752b;

    public eh(C2651c<NETWORK_EXTRAS, SERVER_PARAMETERS> c2651c, NETWORK_EXTRAS network_extras) {
        this.f10751a = c2651c;
        this.f10752b = network_extras;
    }

    private SERVER_PARAMETERS m12558a(String str, int i, String str2) {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                C2972b.m11584d("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class c = this.f10751a.m10230c();
        if (c == null) {
            return null;
        }
        C2661h c2661h = (C2661h) c.newInstance();
        c2661h.m10251a(hashMap);
        return c2661h;
    }

    public C2687a m12559a() {
        if (this.f10751a instanceof C2656d) {
            try {
                return C2690b.m10262a(((C2656d) this.f10751a).m10232d());
            } catch (Throwable th) {
                C2972b.m11584d("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            C2972b.m11583d("MediationAdapter is not a MediationBannerAdapter: " + this.f10751a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m12560a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, C2963a c2963a, String str2) {
    }

    public void m12561a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, dw dwVar) {
        m12562a(c2687a, adRequestParcel, str, null, dwVar);
    }

    public void m12562a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, String str2, dw dwVar) {
        if (this.f10751a instanceof C2657f) {
            C2972b.m11576a("Requesting interstitial ad from adapter.");
            try {
                ((C2657f) this.f10751a).m10233a(new ei(dwVar), (Activity) C2690b.m10263a(c2687a), m12558a(str, adRequestParcel.f9313g, str2), ej.m12585a(adRequestParcel), this.f10752b);
            } catch (Throwable th) {
                C2972b.m11584d("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            C2972b.m11583d("MediationAdapter is not a MediationInterstitialAdapter: " + this.f10751a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m12563a(C2687a c2687a, AdRequestParcel adRequestParcel, String str, String str2, dw dwVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
    }

    public void m12564a(C2687a c2687a, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, dw dwVar) {
        m12565a(c2687a, adSizeParcel, adRequestParcel, str, null, dwVar);
    }

    public void m12565a(C2687a c2687a, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, dw dwVar) {
        if (this.f10751a instanceof C2656d) {
            C2972b.m11576a("Requesting banner ad from adapter.");
            try {
                ((C2656d) this.f10751a).m10231a(new ei(dwVar), (Activity) C2690b.m10263a(c2687a), m12558a(str, adRequestParcel.f9313g, str2), ej.m12584a(adSizeParcel), ej.m12585a(adRequestParcel), this.f10752b);
            } catch (Throwable th) {
                C2972b.m11584d("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            C2972b.m11583d("MediationAdapter is not a MediationBannerAdapter: " + this.f10751a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m12566a(AdRequestParcel adRequestParcel, String str) {
    }

    public void m12567a(AdRequestParcel adRequestParcel, String str, String str2) {
    }

    public void m12568b() {
        if (this.f10751a instanceof C2657f) {
            C2972b.m11576a("Showing interstitial from adapter.");
            try {
                ((C2657f) this.f10751a).m10234e();
            } catch (Throwable th) {
                C2972b.m11584d("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            C2972b.m11583d("MediationAdapter is not a MediationInterstitialAdapter: " + this.f10751a.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m12569c() {
        try {
            this.f10751a.m10228a();
        } catch (Throwable th) {
            C2972b.m11584d("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void m12570d() {
        throw new RemoteException();
    }

    public void m12571e() {
        throw new RemoteException();
    }

    public void m12572f() {
    }

    public boolean m12573g() {
        return true;
    }

    public dz m12574h() {
        return null;
    }

    public ea m12575i() {
        return null;
    }

    public Bundle m12576j() {
        return new Bundle();
    }

    public Bundle m12577k() {
        return new Bundle();
    }

    public Bundle m12578l() {
        return new Bundle();
    }
}
