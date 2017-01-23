package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import java.util.ArrayList;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.server.response.c */
public class C3522c implements Creator<FieldMappingDictionary> {
    static void m14676a(FieldMappingDictionary fieldMappingDictionary, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, fieldMappingDictionary.m14652b());
        C3508b.m14574b(parcel, 2, fieldMappingDictionary.m14653c(), false);
        C3508b.m14565a(parcel, 3, fieldMappingDictionary.m14654d(), false);
        C3508b.m14555a(parcel, a);
    }

    public FieldMappingDictionary m14677a(Parcel parcel) {
        String str = null;
        int b = C3507a.m14526b(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    arrayList = C3507a.m14529c(parcel, a, Entry.CREATOR);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new FieldMappingDictionary(i, arrayList, str);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public FieldMappingDictionary[] m14678a(int i) {
        return new FieldMappingDictionary[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14677a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14678a(i);
    }
}
