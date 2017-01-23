package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.ads.internal.request.n */
public class C2949n implements Creator<StringParcel> {
    static void m11446a(StringParcel stringParcel, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, stringParcel.f9922a);
        C3508b.m14565a(parcel, 2, stringParcel.f9923b, false);
        C3508b.m14555a(parcel, a);
    }

    public StringParcel m11447a(Parcel parcel) {
        int b = C3507a.m14526b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StringParcel(i, str);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public StringParcel[] m11448a(int i) {
        return new StringParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11447a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11448a(i);
    }
}
