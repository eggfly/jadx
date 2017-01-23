package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class t implements Creator<AdSizeParcel> {
    static void j6(AdSizeParcel adSizeParcel, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, adSizeParcel.j6);
        b.j6(parcel, 2, adSizeParcel.DW, false);
        b.j6(parcel, 3, adSizeParcel.FH);
        b.j6(parcel, 4, adSizeParcel.Hw);
        b.j6(parcel, 5, adSizeParcel.v5);
        b.j6(parcel, 6, adSizeParcel.Zo);
        b.j6(parcel, 7, adSizeParcel.VH);
        b.j6(parcel, 8, adSizeParcel.gn, i, false);
        b.j6(parcel, 9, adSizeParcel.u7);
        b.j6(parcel, 10, adSizeParcel.tp);
        b.j6(parcel, 11, adSizeParcel.EQ);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public AdSizeParcel j6(Parcel parcel) {
        AdSizeParcel[] adSizeParcelArr = null;
        boolean z = false;
        int DW = a.DW(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        boolean z4 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i5 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    str = a.J8(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    i4 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    i3 = a.Hw(parcel, j6);
                    break;
                case 5:
                    z4 = a.FH(parcel, j6);
                    break;
                case 6:
                    i2 = a.Hw(parcel, j6);
                    break;
                case 7:
                    i = a.Hw(parcel, j6);
                    break;
                case 8:
                    adSizeParcelArr = (AdSizeParcel[]) a.DW(parcel, j6, AdSizeParcel.CREATOR);
                    break;
                case 9:
                    z3 = a.FH(parcel, j6);
                    break;
                case 10:
                    z2 = a.FH(parcel, j6);
                    break;
                case 11:
                    z = a.FH(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new AdSizeParcel(i5, str, i4, i3, z4, i2, i, adSizeParcelArr, z3, z2, z);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public AdSizeParcel[] j6(int i) {
        return new AdSizeParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
