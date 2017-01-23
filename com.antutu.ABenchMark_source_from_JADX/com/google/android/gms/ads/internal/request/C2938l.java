package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.request.l */
public class C2938l implements Creator<LargeParcelTeleporter> {
    static void m11423a(LargeParcelTeleporter largeParcelTeleporter, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, largeParcelTeleporter.f9918a);
        C3508b.m14562a(parcel, 2, largeParcelTeleporter.f9919b, i, false);
        C3508b.m14555a(parcel, a);
    }

    public LargeParcelTeleporter m11424a(Parcel parcel) {
        int b = C3507a.m14526b(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) C3507a.m14523a(parcel, a, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LargeParcelTeleporter(i, parcelFileDescriptor);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public LargeParcelTeleporter[] m11425a(int i) {
        return new LargeParcelTeleporter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11424a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11425a(i);
    }
}
