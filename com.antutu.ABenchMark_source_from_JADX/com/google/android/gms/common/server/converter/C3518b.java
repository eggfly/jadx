package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.google.android.gms.common.server.converter.StringToIntConverter.Entry;
import java.util.ArrayList;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.server.converter.b */
public class C3518b implements Creator<StringToIntConverter> {
    static void m14614a(StringToIntConverter stringToIntConverter, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, stringToIntConverter.m14606a());
        C3508b.m14574b(parcel, 2, stringToIntConverter.m14610b(), false);
        C3508b.m14555a(parcel, a);
    }

    public StringToIntConverter m14615a(Parcel parcel) {
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
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StringToIntConverter(i, arrayList);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public StringToIntConverter[] m14616a(int i) {
        return new StringToIntConverter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14615a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14616a(i);
    }
}
