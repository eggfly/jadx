package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair;
import java.util.ArrayList;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.server.response.d */
public class C3523d implements Creator<Entry> {
    static void m14679a(Entry entry, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, entry.f12142a);
        C3508b.m14565a(parcel, 2, entry.f12143b, false);
        C3508b.m14574b(parcel, 3, entry.f12144c, false);
        C3508b.m14555a(parcel, a);
    }

    public Entry m14680a(Parcel parcel) {
        ArrayList arrayList = null;
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
                    arrayList = C3507a.m14529c(parcel, a, FieldMapPair.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Entry(i, str, arrayList);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public Entry[] m14681a(int i) {
        return new Entry[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14680a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14681a(i);
    }
}
