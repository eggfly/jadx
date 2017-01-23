package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<Flag> {
    static void j6(Flag flag, Parcel parcel, int i) {
        int j6 = com.google.android.gms.common.internal.safeparcel.b.j6(parcel);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 1, flag.j6);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 2, flag.DW, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 3, flag.FH);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 4, flag.Hw);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 5, flag.v5);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 6, flag.Zo, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 7, flag.VH, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 8, flag.gn);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 9, flag.u7);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public Flag j6(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int DW = a.DW(parcel);
        long j = 0;
        double d = 0.0d;
        int i2 = 0;
        String str = null;
        boolean z = false;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i3 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    str2 = a.J8(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    j = a.Zo(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    z = a.FH(parcel, j6);
                    break;
                case 5:
                    d = a.EQ(parcel, j6);
                    break;
                case 6:
                    str = a.J8(parcel, j6);
                    break;
                case 7:
                    bArr = a.XL(parcel, j6);
                    break;
                case 8:
                    i2 = a.Hw(parcel, j6);
                    break;
                case 9:
                    i = a.Hw(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new Flag(i3, str2, j, z, d, str, bArr, i2, i);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public Flag[] j6(int i) {
        return new Flag[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
