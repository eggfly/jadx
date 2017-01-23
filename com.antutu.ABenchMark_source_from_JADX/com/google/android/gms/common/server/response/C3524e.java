package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.server.response.e */
public class C3524e implements Creator<SafeParcelResponse> {
    static void m14682a(SafeParcelResponse safeParcelResponse, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, safeParcelResponse.m14667d());
        C3508b.m14561a(parcel, 2, safeParcelResponse.m14668e(), false);
        C3508b.m14562a(parcel, 3, safeParcelResponse.m14669f(), i, false);
        C3508b.m14555a(parcel, a);
    }

    public SafeParcelResponse m14683a(Parcel parcel) {
        FieldMappingDictionary fieldMappingDictionary = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    parcel2 = C3507a.m14552y(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    fieldMappingDictionary = (FieldMappingDictionary) C3507a.m14523a(parcel, a, FieldMappingDictionary.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public SafeParcelResponse[] m14684a(int i) {
        return new SafeParcelResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14683a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14684a(i);
    }
}
