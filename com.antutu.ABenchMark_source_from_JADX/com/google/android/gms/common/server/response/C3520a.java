package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.common.server.response.a */
public class C3520a implements Creator<Field> {
    static void m14670a(Field field, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, field.m14621a());
        C3508b.m14557a(parcel, 2, field.m14624b());
        C3508b.m14567a(parcel, 3, field.m14625c());
        C3508b.m14557a(parcel, 4, field.m14626d());
        C3508b.m14567a(parcel, 5, field.m14627e());
        C3508b.m14565a(parcel, 6, field.m14628f(), false);
        C3508b.m14557a(parcel, 7, field.m14629g());
        C3508b.m14565a(parcel, 8, field.m14631i(), false);
        C3508b.m14562a(parcel, 9, field.m14633k(), i, false);
        C3508b.m14555a(parcel, a);
    }

    public Field m14671a(Parcel parcel) {
        ConverterWrapper converterWrapper = null;
        int i = 0;
        int b = C3507a.m14526b(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i4 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    i3 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    z2 = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    str2 = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    str = C3507a.m14539l(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    converterWrapper = (ConverterWrapper) C3507a.m14523a(parcel, a, ConverterWrapper.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Field(i4, i3, z2, i2, z, str2, i, str, converterWrapper);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public Field[] m14672a(int i) {
        return new Field[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14671a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14672a(i);
    }
}
