package com.google.android.gms.internal;

import aes;
import aet;
import aev;
import aex;
import aez;
import afa;
import afb;
import afd;
import afg;
import agg;
import agh;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.h;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.internal.cs.a;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@eh
public final class cy extends a {
    private cz DW;
    private final aes j6;

    public cy(aes aes) {
        this.j6 = aes;
    }

    private Bundle j6(String str, int i, String str2) {
        String str3 = "Server parameters: ";
        String valueOf = String.valueOf(str);
        b.Hw(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    valueOf = (String) keys.next();
                    bundle2.putString(valueOf, jSONObject.getString(valueOf));
                }
                bundle = bundle2;
            }
            if (this.j6 instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            b.FH("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void DW() {
        if (this.j6 instanceof aev) {
            b.j6("Showing interstitial from adapter.");
            try {
                ((aev) this.j6).v5();
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
        if (this.j6 instanceof ft) {
            return ((ft) this.j6).Zo();
        }
        String str = "MediationAdapter is not a v2 MediationInterstitialAdapter: ";
        String valueOf = String.valueOf(this.j6.getClass().getCanonicalName());
        b.Hw(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
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
        try {
            this.j6.DW();
        } catch (Throwable th) {
            b.FH("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public boolean VH() {
        if (this.j6 instanceof afg) {
            b.j6("Check if adapter is initialized.");
            try {
                return ((afg) this.j6).gn();
            } catch (Throwable th) {
                b.FH("Could not check if adapter is initialized.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.j6.getClass().getCanonicalName());
            b.Hw(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void Zo() {
        if (this.j6 instanceof afg) {
            b.j6("Show rewarded video ad from adapter.");
            try {
                ((afg) this.j6).VH();
            } catch (Throwable th) {
                b.FH("Could not show rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.j6.getClass().getCanonicalName());
            b.Hw(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public cv gn() {
        aez j6 = this.DW.j6();
        return j6 instanceof afa ? new da((afa) j6) : null;
    }

    public agg j6() {
        if (this.j6 instanceof aet) {
            try {
                return agh.j6(((aet) this.j6).Hw());
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
        try {
            ((afd) this.j6).j6((Context) agh.j6(agg));
        } catch (Throwable th) {
            b.j6("Could not inform adapter of changed context", th);
        }
    }

    public void j6(agg agg, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.a aVar, String str2) {
        if (this.j6 instanceof afg) {
            b.j6("Initialize rewarded video adapter.");
            try {
                afg afg = (afg) this.j6;
                afg.j6((Context) agh.j6(agg), new cx(adRequestParcel.DW == -1 ? null : new Date(adRequestParcel.DW), adRequestParcel.Hw, adRequestParcel.v5 != null ? new HashSet(adRequestParcel.v5) : null, adRequestParcel.EQ, adRequestParcel.Zo, adRequestParcel.VH, adRequestParcel.aM), str, new com.google.android.gms.ads.internal.reward.mediation.client.b(aVar), j6(str2, adRequestParcel.VH, null), adRequestParcel.J0 != null ? adRequestParcel.J0.getBundle(afg.getClass().getName()) : null);
            } catch (Throwable th) {
                b.FH("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.j6.getClass().getCanonicalName());
            b.Hw(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void j6(agg agg, AdRequestParcel adRequestParcel, String str, ct ctVar) {
        j6(agg, adRequestParcel, str, null, ctVar);
    }

    public void j6(agg agg, AdRequestParcel adRequestParcel, String str, String str2, ct ctVar) {
        if (this.j6 instanceof aev) {
            b.j6("Requesting interstitial ad from adapter.");
            try {
                aev aev = (aev) this.j6;
                aev.j6((Context) agh.j6(agg), new cz(ctVar), j6(str, adRequestParcel.VH, str2), new cx(adRequestParcel.DW == -1 ? null : new Date(adRequestParcel.DW), adRequestParcel.Hw, adRequestParcel.v5 != null ? new HashSet(adRequestParcel.v5) : null, adRequestParcel.EQ, adRequestParcel.Zo, adRequestParcel.VH, adRequestParcel.aM), adRequestParcel.J0 != null ? adRequestParcel.J0.getBundle(aev.getClass().getName()) : null);
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
        if (this.j6 instanceof aex) {
            try {
                aex aex = (aex) this.j6;
                dc dcVar = new dc(adRequestParcel.DW == -1 ? null : new Date(adRequestParcel.DW), adRequestParcel.Hw, adRequestParcel.v5 != null ? new HashSet(adRequestParcel.v5) : null, adRequestParcel.EQ, adRequestParcel.Zo, adRequestParcel.VH, nativeAdOptionsParcel, list, adRequestParcel.aM);
                Bundle bundle = adRequestParcel.J0 != null ? adRequestParcel.J0.getBundle(aex.getClass().getName()) : null;
                this.DW = new cz(ctVar);
                aex.j6((Context) agh.j6(agg), this.DW, j6(str, adRequestParcel.VH, str2), dcVar, bundle);
            } catch (Throwable th) {
                b.FH("Could not request native ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationNativeAdapter: ";
            String valueOf = String.valueOf(this.j6.getClass().getCanonicalName());
            b.Hw(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void j6(agg agg, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, ct ctVar) {
        j6(agg, adSizeParcel, adRequestParcel, str, null, ctVar);
    }

    public void j6(agg agg, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, ct ctVar) {
        if (this.j6 instanceof aet) {
            b.j6("Requesting banner ad from adapter.");
            try {
                aet aet = (aet) this.j6;
                aet.j6((Context) agh.j6(agg), new cz(ctVar), j6(str, adRequestParcel.VH, str2), h.j6(adSizeParcel.Zo, adSizeParcel.FH, adSizeParcel.DW), new cx(adRequestParcel.DW == -1 ? null : new Date(adRequestParcel.DW), adRequestParcel.Hw, adRequestParcel.v5 != null ? new HashSet(adRequestParcel.v5) : null, adRequestParcel.EQ, adRequestParcel.Zo, adRequestParcel.VH, adRequestParcel.aM), adRequestParcel.J0 != null ? adRequestParcel.J0.getBundle(aet.getClass().getName()) : null);
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
        j6(adRequestParcel, str, null);
    }

    public void j6(AdRequestParcel adRequestParcel, String str, String str2) {
        if (this.j6 instanceof afg) {
            b.j6("Requesting rewarded video ad from adapter.");
            try {
                afg afg = (afg) this.j6;
                afg.j6(new cx(adRequestParcel.DW == -1 ? null : new Date(adRequestParcel.DW), adRequestParcel.Hw, adRequestParcel.v5 != null ? new HashSet(adRequestParcel.v5) : null, adRequestParcel.EQ, adRequestParcel.Zo, adRequestParcel.VH, adRequestParcel.aM), j6(str, adRequestParcel.VH, str2), adRequestParcel.J0 != null ? adRequestParcel.J0.getBundle(afg.getClass().getName()) : null);
            } catch (Throwable th) {
                b.FH("Could not load rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.j6.getClass().getCanonicalName());
            b.Hw(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public Bundle tp() {
        if (this.j6 instanceof fs) {
            return ((fs) this.j6).v5();
        }
        String str = "MediationAdapter is not a v2 MediationBannerAdapter: ";
        String valueOf = String.valueOf(this.j6.getClass().getCanonicalName());
        b.Hw(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public cw u7() {
        aez j6 = this.DW.j6();
        return j6 instanceof afb ? new db((afb) j6) : null;
    }

    public void v5() {
        try {
            this.j6.FH();
        } catch (Throwable th) {
            b.FH("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public Bundle we() {
        return new Bundle();
    }
}
