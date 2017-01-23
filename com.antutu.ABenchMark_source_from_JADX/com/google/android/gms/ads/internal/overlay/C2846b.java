package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.overlay.b */
public class C2846b implements Creator<AdLauncherIntentInfoParcel> {
    static void m11045a(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, adLauncherIntentInfoParcel.f9636a);
        C3508b.m14565a(parcel, 2, adLauncherIntentInfoParcel.f9637b, false);
        C3508b.m14565a(parcel, 3, adLauncherIntentInfoParcel.f9638c, false);
        C3508b.m14565a(parcel, 4, adLauncherIntentInfoParcel.f9639d, false);
        C3508b.m14565a(parcel, 5, adLauncherIntentInfoParcel.f9640e, false);
        C3508b.m14565a(parcel, 6, adLauncherIntentInfoParcel.f9641f, false);
        C3508b.m14565a(parcel, 7, adLauncherIntentInfoParcel.f9642g, false);
        C3508b.m14565a(parcel, 8, adLauncherIntentInfoParcel.f9643h, false);
        C3508b.m14562a(parcel, 9, adLauncherIntentInfoParcel.f9644i, i, false);
        C3508b.m14555a(parcel, a);
    }

    public AdLauncherIntentInfoParcel m11046a(Parcel parcel) {
        Intent intent = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    str7 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    str6 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    str5 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    str4 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    str3 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    intent = (Intent) C3507a.m14523a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdLauncherIntentInfoParcel(i, str7, str6, str5, str4, str3, str2, str, intent);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public AdLauncherIntentInfoParcel[] m11047a(int i) {
        return new AdLauncherIntentInfoParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11046a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11047a(i);
    }
}
