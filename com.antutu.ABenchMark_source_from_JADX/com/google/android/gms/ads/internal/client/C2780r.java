package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.client.r */
public class C2780r implements Creator<AdSizeParcel> {
    static void m10728a(AdSizeParcel adSizeParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, adSizeParcel.f9325a);
        C3508b.m14565a(parcel, 2, adSizeParcel.f9326b, false);
        C3508b.m14557a(parcel, 3, adSizeParcel.f9327c);
        C3508b.m14557a(parcel, 4, adSizeParcel.f9328d);
        C3508b.m14567a(parcel, 5, adSizeParcel.f9329e);
        C3508b.m14557a(parcel, 6, adSizeParcel.f9330f);
        C3508b.m14557a(parcel, 7, adSizeParcel.f9331g);
        C3508b.m14570a(parcel, 8, adSizeParcel.f9332h, i, false);
        C3508b.m14567a(parcel, 9, adSizeParcel.f9333i);
        C3508b.m14567a(parcel, 10, adSizeParcel.f9334j);
        C3508b.m14567a(parcel, 11, adSizeParcel.f9335k);
        C3508b.m14555a(parcel, a);
    }

    public AdSizeParcel m10729a(Parcel parcel) {
        AdSizeParcel[] adSizeParcelArr = null;
        boolean z = false;
        int b = C3507a.m14526b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        boolean z4 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i5 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    i4 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    i3 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    z4 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    adSizeParcelArr = (AdSizeParcel[]) C3507a.m14528b(parcel, a, AdSizeParcel.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    z3 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    z2 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdSizeParcel(i5, str, i4, i3, z4, i2, i, adSizeParcelArr, z3, z2, z);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public AdSizeParcel[] m10730a(int i) {
        return new AdSizeParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10729a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10730a(i);
    }
}
