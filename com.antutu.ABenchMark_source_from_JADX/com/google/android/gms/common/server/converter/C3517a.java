package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.server.converter.a */
public class C3517a implements Creator<ConverterWrapper> {
    static void m14611a(ConverterWrapper converterWrapper, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, converterWrapper.m14601a());
        C3508b.m14562a(parcel, 2, converterWrapper.m14602b(), i, false);
        C3508b.m14555a(parcel, a);
    }

    public ConverterWrapper m14612a(Parcel parcel) {
        int b = C3507a.m14526b(parcel);
        int i = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    stringToIntConverter = (StringToIntConverter) C3507a.m14523a(parcel, a, StringToIntConverter.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConverterWrapper(i, stringToIntConverter);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public ConverterWrapper[] m14613a(int i) {
        return new ConverterWrapper[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14612a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14613a(i);
    }
}
