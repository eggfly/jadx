package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.m */
public class C2837m implements Creator<InterstitialAdParameterParcel> {
    static void m11000a(InterstitialAdParameterParcel interstitialAdParameterParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, interstitialAdParameterParcel.f9287a);
        C3508b.m14567a(parcel, 2, interstitialAdParameterParcel.f9288b);
        C3508b.m14567a(parcel, 3, interstitialAdParameterParcel.f9289c);
        C3508b.m14565a(parcel, 4, interstitialAdParameterParcel.f9290d, false);
        C3508b.m14567a(parcel, 5, interstitialAdParameterParcel.f9291e);
        C3508b.m14556a(parcel, 6, interstitialAdParameterParcel.f9292f);
        C3508b.m14555a(parcel, a);
    }

    public InterstitialAdParameterParcel m11001a(Parcel parcel) {
        boolean z = false;
        int b = C3507a.m14526b(parcel);
        String str = null;
        float f = 0.0f;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    z3 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    z2 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    f = C3507a.m14536i(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new InterstitialAdParameterParcel(i, z3, z2, str, z, f);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public InterstitialAdParameterParcel[] m11002a(int i) {
        return new InterstitialAdParameterParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11001a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11002a(i);
    }
}
