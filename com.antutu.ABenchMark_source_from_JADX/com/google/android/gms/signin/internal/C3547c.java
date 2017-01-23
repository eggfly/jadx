package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.signin.internal.c */
public class C3547c implements Creator<CheckServerAuthResult> {
    static void m14766a(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, checkServerAuthResult.f12249a);
        C3508b.m14567a(parcel, 2, checkServerAuthResult.f12250b);
        C3508b.m14574b(parcel, 3, checkServerAuthResult.f12251c, false);
        C3508b.m14555a(parcel, a);
    }

    public CheckServerAuthResult m14767a(Parcel parcel) {
        boolean z = false;
        int b = C3507a.m14526b(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    z = C3507a.m14530c(parcel, a);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    list = C3507a.m14529c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CheckServerAuthResult(i, z, list);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public CheckServerAuthResult[] m14768a(int i) {
        return new CheckServerAuthResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14767a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14768a(i);
    }
}
