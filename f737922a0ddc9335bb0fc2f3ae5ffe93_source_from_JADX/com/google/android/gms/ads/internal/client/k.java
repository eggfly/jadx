package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class k implements Creator<SearchAdRequestParcel> {
    static void j6(SearchAdRequestParcel searchAdRequestParcel, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, searchAdRequestParcel.j6);
        b.j6(parcel, 2, searchAdRequestParcel.DW);
        b.j6(parcel, 3, searchAdRequestParcel.FH);
        b.j6(parcel, 4, searchAdRequestParcel.Hw);
        b.j6(parcel, 5, searchAdRequestParcel.v5);
        b.j6(parcel, 6, searchAdRequestParcel.Zo);
        b.j6(parcel, 7, searchAdRequestParcel.VH);
        b.j6(parcel, 8, searchAdRequestParcel.gn);
        b.j6(parcel, 9, searchAdRequestParcel.u7);
        b.j6(parcel, 10, searchAdRequestParcel.tp, false);
        b.j6(parcel, 11, searchAdRequestParcel.EQ);
        b.j6(parcel, 12, searchAdRequestParcel.we, false);
        b.j6(parcel, 13, searchAdRequestParcel.J0);
        b.j6(parcel, 14, searchAdRequestParcel.J8);
        b.j6(parcel, 15, searchAdRequestParcel.Ws, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public SearchAdRequestParcel j6(Parcel parcel) {
        int DW = a.DW(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    i2 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    i3 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    i4 = a.Hw(parcel, j6);
                    break;
                case 5:
                    i5 = a.Hw(parcel, j6);
                    break;
                case 6:
                    i6 = a.Hw(parcel, j6);
                    break;
                case 7:
                    i7 = a.Hw(parcel, j6);
                    break;
                case 8:
                    i8 = a.Hw(parcel, j6);
                    break;
                case 9:
                    i9 = a.Hw(parcel, j6);
                    break;
                case 10:
                    str = a.J8(parcel, j6);
                    break;
                case 11:
                    i10 = a.Hw(parcel, j6);
                    break;
                case 12:
                    str2 = a.J8(parcel, j6);
                    break;
                case 13:
                    i11 = a.Hw(parcel, j6);
                    break;
                case 14:
                    i12 = a.Hw(parcel, j6);
                    break;
                case 15:
                    str3 = a.J8(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new SearchAdRequestParcel(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public SearchAdRequestParcel[] j6(int i) {
        return new SearchAdRequestParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
