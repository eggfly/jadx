package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.C3507a;
import com.google.android.gms.common.internal.safeparcel.C3507a.C3506a;
import com.google.android.gms.common.internal.safeparcel.C3508b;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.google.android.gms.signin.internal.i */
public class C3555i implements Creator<SignInRequest> {
    static void m14810a(SignInRequest signInRequest, Parcel parcel, int i) {
        int a = C3508b.m14554a(parcel);
        C3508b.m14557a(parcel, 1, signInRequest.f12256a);
        C3508b.m14562a(parcel, 2, signInRequest.m14760a(), i, false);
        C3508b.m14555a(parcel, a);
    }

    public SignInRequest m14811a(Parcel parcel) {
        int b = C3507a.m14526b(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < b) {
            int a = C3507a.m14521a(parcel);
            switch (C3507a.m14520a(a)) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i = C3507a.m14531d(parcel, a);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    resolveAccountRequest = (ResolveAccountRequest) C3507a.m14523a(parcel, a, ResolveAccountRequest.CREATOR);
                    break;
                default:
                    C3507a.m14527b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInRequest(i, resolveAccountRequest);
        }
        throw new C3506a("Overread allowed size end=" + b, parcel);
    }

    public SignInRequest[] m14812a(int i) {
        return new SignInRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14811a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14812a(i);
    }
}
