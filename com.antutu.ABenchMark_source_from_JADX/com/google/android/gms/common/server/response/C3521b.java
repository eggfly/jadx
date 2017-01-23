package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.server.response.b */
public class C3521b implements Creator<FieldMapPair> {
    static void m14673a(FieldMapPair fieldMapPair, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, fieldMapPair.f12145a);
        C3508b.m14565a(parcel, 2, fieldMapPair.f12146b, false);
        C3508b.m14562a(parcel, 3, fieldMapPair.f12147c, i, false);
        C3508b.m14555a(parcel, a);
    }

    public FieldMapPair m14674a(Parcel parcel) {
        Field field = null;
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
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    field = (Field) C3507a.m14523a(parcel, a, Field.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new FieldMapPair(i, str, field);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public FieldMapPair[] m14675a(int i) {
        return new FieldMapPair[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14674a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14675a(i);
    }
}
