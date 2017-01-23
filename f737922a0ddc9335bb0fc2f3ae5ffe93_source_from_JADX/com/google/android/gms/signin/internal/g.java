package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g implements Creator<SignInRequest> {
    static void j6(SignInRequest signInRequest, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, signInRequest.j6);
        b.j6(parcel, 2, signInRequest.j6(), i, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public SignInRequest j6(Parcel parcel) {
        int DW = a.DW(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    resolveAccountRequest = (ResolveAccountRequest) a.j6(parcel, j6, ResolveAccountRequest.CREATOR);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new SignInRequest(i, resolveAccountRequest);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public SignInRequest[] j6(int i) {
        return new SignInRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
