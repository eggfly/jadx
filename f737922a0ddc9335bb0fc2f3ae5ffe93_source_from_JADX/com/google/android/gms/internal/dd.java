package com.google.android.gms.internal;

import agg;
import agh;
import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.c;
import com.google.ads.mediation.d;
import com.google.ads.mediation.f;
import com.google.ads.mediation.h;
import com.google.ads.mediation.i;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.internal.cs.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@eh
public final class dd<NETWORK_EXTRAS extends i, SERVER_PARAMETERS extends h> extends a {
    private final NETWORK_EXTRAS DW;
    private final c<NETWORK_EXTRAS, SERVER_PARAMETERS> j6;

    public dd(c<NETWORK_EXTRAS, SERVER_PARAMETERS> cVar, NETWORK_EXTRAS network_extras) {
        this.j6 = cVar;
        this.DW = network_extras;
    }

    private SERVER_PARAMETERS j6(String str, int i, String str2) {
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
                b.FH("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class FH = this.j6.FH();
        if (FH == null) {
            return null;
        }
        h hVar = (h) FH.newInstance();
        hVar.j6(hashMap);
        return hVar;
    }

    public void DW() {
        if (this.j6 instanceof f) {
            b.j6("Showing interstitial from adapter.");
            try {
                ((f) this.j6).v5();
            } catch (Throwable th) {
                b.FH("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.j6.getClass().getCanonicalName());
            b.Hw(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public Bundle EQ() {
        return new Bundle();
    }

    public void FH() {
        try {
            this.j6.j6();
        } catch (Throwable th) {
            b.FH("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void Hw() {
        throw new RemoteException();
    }

    public boolean VH() {
        return true;
    }

    public void Zo() {
    }

    public cv gn() {
        return null;
    }

    public agg j6() {
        if (this.j6 instanceof d) {
            try {
                return agh.j6(((d) this.j6).Hw());
            } catch (Throwable th) {
                b.FH("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.j6.getClass().getCanonicalName());
            b.Hw(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void j6(agg agg) {
    }

    public void j6(agg agg, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.a aVar, String str2) {
    }

    public void j6(agg agg, AdRequestParcel adRequestParcel, String str, ct ctVar) {
        j6(agg, adRequestParcel, str, null, ctVar);
    }

    public void j6(agg agg, AdRequestParcel adRequestParcel, String str, String str2, ct ctVar) {
        if (this.j6 instanceof f) {
            b.j6("Requesting interstitial ad from adapter.");
            try {
                ((f) this.j6).j6(new de(ctVar), (Activity) agh.j6(agg), j6(str, adRequestParcel.VH, str2), df.j6(adRequestParcel), this.DW);
            } catch (Throwable th) {
                b.FH("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.j6.getClass().getCanonicalName());
            b.Hw(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void j6(agg agg, AdRequestParcel adRequestParcel, String str, String str2, ct ctVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
    }

    public void j6(agg agg, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, ct ctVar) {
        j6(agg, adSizeParcel, adRequestParcel, str, null, ctVar);
    }

    public void j6(agg agg, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, ct ctVar) {
        if (this.j6 instanceof d) {
            b.j6("Requesting banner ad from adapter.");
            try {
                ((d) this.j6).j6(new de(ctVar), (Activity) agh.j6(agg), j6(str, adRequestParcel.VH, str2), df.j6(adSizeParcel), df.j6(adRequestParcel), this.DW);
            } catch (Throwable th) {
                b.FH("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.j6.getClass().getCanonicalName());
            b.Hw(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void j6(AdRequestParcel adRequestParcel, String str) {
    }

    public void j6(AdRequestParcel adRequestParcel, String str, String str2) {
    }

    public Bundle tp() {
        return new Bundle();
    }

    public cw u7() {
        return null;
    }

    public void v5() {
        throw new RemoteException();
    }

    public Bundle we() {
        return new Bundle();
    }
}
