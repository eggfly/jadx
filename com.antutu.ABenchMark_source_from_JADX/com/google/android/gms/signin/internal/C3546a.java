package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.signin.internal.a */
public class C3546a implements Creator<AuthAccountResult> {
    static void m14763a(AuthAccountResult authAccountResult, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, authAccountResult.f12246a);
        C3508b.m14557a(parcel, 2, authAccountResult.m14755b());
        C3508b.m14562a(parcel, 3, authAccountResult.m14756c(), i, false);
        C3508b.m14555a(parcel, a);
    }

    public AuthAccountResult m14764a(Parcel parcel) {
        int i = 0;
        int b = C3507a.m14526b(parcel);
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i2 = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    intent = (Intent) C3507a.m14523a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountResult(i2, i, intent);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public AuthAccountResult[] m14765a(int i) {
        return new AuthAccountResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14764a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14765a(i);
    }
}
