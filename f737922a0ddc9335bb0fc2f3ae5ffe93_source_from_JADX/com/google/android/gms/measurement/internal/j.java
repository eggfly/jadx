package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class j implements Creator<UserAttributeParcel> {
    static void j6(UserAttributeParcel userAttributeParcel, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, userAttributeParcel.j6);
        b.j6(parcel, 2, userAttributeParcel.DW, false);
        b.j6(parcel, 3, userAttributeParcel.FH);
        b.j6(parcel, 4, userAttributeParcel.Hw, false);
        b.j6(parcel, 5, userAttributeParcel.v5, false);
        b.j6(parcel, 6, userAttributeParcel.Zo, false);
        b.j6(parcel, 7, userAttributeParcel.VH, false);
        b.j6(parcel, 8, userAttributeParcel.gn, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public UserAttributeParcel j6(Parcel parcel) {
        Double d = null;
        int DW = a.DW(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    str3 = a.J8(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    j = a.Zo(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    l = a.VH(parcel, j6);
                    break;
                case 5:
                    f = a.tp(parcel, j6);
                    break;
                case 6:
                    str2 = a.J8(parcel, j6);
                    break;
                case 7:
                    str = a.J8(parcel, j6);
                    break;
                case 8:
                    d = a.we(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new UserAttributeParcel(i, str3, j, l, f, str2, str, d);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public UserAttributeParcel[] j6(int i) {
        return new UserAttributeParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
