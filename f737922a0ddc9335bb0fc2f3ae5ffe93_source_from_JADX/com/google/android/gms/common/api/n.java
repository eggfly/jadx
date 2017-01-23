package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class n implements Creator<Scope> {
    static void j6(Scope scope, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, scope.j6);
        b.j6(parcel, 2, scope.j6(), false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public Scope j6(Parcel parcel) {
        int DW = a.DW(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    str = a.J8(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new Scope(i, str);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public Scope[] j6(int i) {
        return new Scope[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
