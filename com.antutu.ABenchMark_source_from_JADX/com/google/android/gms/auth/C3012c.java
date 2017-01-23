package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.auth.c */
public class C3012c implements Creator<AccountChangeEventsResponse> {
    static void m11714a(AccountChangeEventsResponse accountChangeEventsResponse, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, accountChangeEventsResponse.f10116a);
        C3508b.m14574b(parcel, 2, accountChangeEventsResponse.f10117b, false);
        C3508b.m14555a(parcel, a);
    }

    public AccountChangeEventsResponse m11715a(Parcel parcel) {
        int b = C3507a.m14526b(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    list = C3507a.m14529c(parcel, a, AccountChangeEvent.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AccountChangeEventsResponse(i, list);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public AccountChangeEventsResponse[] m11716a(int i) {
        return new AccountChangeEventsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11715a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11716a(i);
    }
}
