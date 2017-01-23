package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<UserProfileChangeRequest> {
    static void j6(UserProfileChangeRequest userProfileChangeRequest, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, userProfileChangeRequest.j6);
        b.j6(parcel, 2, userProfileChangeRequest.j6(), false);
        b.j6(parcel, 3, userProfileChangeRequest.DW(), false);
        b.j6(parcel, 4, userProfileChangeRequest.FH());
        b.j6(parcel, 5, userProfileChangeRequest.Hw());
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public UserProfileChangeRequest j6(Parcel parcel) {
        String str = null;
        boolean z = false;
        int DW = com.google.android.gms.common.internal.safeparcel.a.DW(parcel);
        boolean z2 = false;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = com.google.android.gms.common.internal.safeparcel.a.j6(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    str = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    z2 = com.google.android.gms.common.internal.safeparcel.a.FH(parcel, j6);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.a.FH(parcel, j6);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new UserProfileChangeRequest(i, str2, str, z2, z);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + DW, parcel);
    }

    public UserProfileChangeRequest[] j6(int i) {
        return new UserProfileChangeRequest[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
