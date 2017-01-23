package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.request.i */
public class C2933i implements Creator<CapabilityParcel> {
    static void m11414a(CapabilityParcel capabilityParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, capabilityParcel.f9911a);
        C3508b.m14567a(parcel, 2, capabilityParcel.f9912b);
        C3508b.m14567a(parcel, 3, capabilityParcel.f9913c);
        C3508b.m14567a(parcel, 4, capabilityParcel.f9914d);
        C3508b.m14555a(parcel, a);
    }

    public CapabilityParcel m11415a(Parcel parcel) {
        boolean z = false;
        int b = C3507a.m14526b(parcel);
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
                    z = C3507a.m14530c(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CapabilityParcel(i, z3, z2, z);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public CapabilityParcel[] m11416a(int i) {
        return new CapabilityParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11415a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11416a(i);
    }
}
