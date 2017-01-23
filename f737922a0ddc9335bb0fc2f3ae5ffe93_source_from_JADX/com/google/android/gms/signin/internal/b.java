package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;

public class b implements Creator<CheckServerAuthResult> {
    static void j6(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int j6 = com.google.android.gms.common.internal.safeparcel.b.j6(parcel);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 1, checkServerAuthResult.j6);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 2, checkServerAuthResult.DW);
        com.google.android.gms.common.internal.safeparcel.b.DW(parcel, 3, checkServerAuthResult.FH, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public CheckServerAuthResult j6(Parcel parcel) {
        boolean z = false;
        int DW = a.DW(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    z = a.FH(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    list = a.FH(parcel, j6, Scope.CREATOR);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new CheckServerAuthResult(i, z, list);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public CheckServerAuthResult[] j6(int i) {
        return new CheckServerAuthResult[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
