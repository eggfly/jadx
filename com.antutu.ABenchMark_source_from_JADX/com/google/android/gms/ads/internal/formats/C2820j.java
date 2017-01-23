package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.formats.j */
public class C2820j implements Creator<NativeAdOptionsParcel> {
    static void m10902a(NativeAdOptionsParcel nativeAdOptionsParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, nativeAdOptionsParcel.f9485a);
        C3508b.m14567a(parcel, 2, nativeAdOptionsParcel.f9486b);
        C3508b.m14557a(parcel, 3, nativeAdOptionsParcel.f9487c);
        C3508b.m14567a(parcel, 4, nativeAdOptionsParcel.f9488d);
        C3508b.m14555a(parcel, a);
    }

    public NativeAdOptionsParcel m10903a(Parcel parcel) {
        boolean z = false;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        boolean z2 = false;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    z2 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new NativeAdOptionsParcel(i2, z2, i, z);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public NativeAdOptionsParcel[] m10904a(int i) {
        return new NativeAdOptionsParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10903a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10904a(i);
    }
}
