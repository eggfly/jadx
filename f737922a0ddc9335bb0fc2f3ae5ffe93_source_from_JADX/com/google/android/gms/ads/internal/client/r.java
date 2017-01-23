package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class r implements Creator<AdRequestParcel> {
    static void j6(AdRequestParcel adRequestParcel, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, adRequestParcel.j6);
        b.j6(parcel, 2, adRequestParcel.DW);
        b.j6(parcel, 3, adRequestParcel.FH, false);
        b.j6(parcel, 4, adRequestParcel.Hw);
        b.j6(parcel, 5, adRequestParcel.v5, false);
        b.j6(parcel, 6, adRequestParcel.Zo);
        b.j6(parcel, 7, adRequestParcel.VH);
        b.j6(parcel, 8, adRequestParcel.gn);
        b.j6(parcel, 9, adRequestParcel.u7, false);
        b.j6(parcel, 10, adRequestParcel.tp, i, false);
        b.j6(parcel, 11, adRequestParcel.EQ, i, false);
        b.j6(parcel, 12, adRequestParcel.we, false);
        b.j6(parcel, 13, adRequestParcel.J0, false);
        b.j6(parcel, 14, adRequestParcel.J8, false);
        b.j6(parcel, 15, adRequestParcel.Ws, false);
        b.j6(parcel, 16, adRequestParcel.QX, false);
        b.j6(parcel, 17, adRequestParcel.XL, false);
        b.j6(parcel, 18, adRequestParcel.aM);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public AdRequestParcel j6(Parcel parcel) {
        int DW = a.DW(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        SearchAdRequestParcel searchAdRequestParcel = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    j = a.Zo(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    bundle = a.QX(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    i2 = a.Hw(parcel, j6);
                    break;
                case 5:
                    list = a.yS(parcel, j6);
                    break;
                case 6:
                    z = a.FH(parcel, j6);
                    break;
                case 7:
                    i3 = a.Hw(parcel, j6);
                    break;
                case 8:
                    z2 = a.FH(parcel, j6);
                    break;
                case 9:
                    str = a.J8(parcel, j6);
                    break;
                case 10:
                    searchAdRequestParcel = (SearchAdRequestParcel) a.j6(parcel, j6, SearchAdRequestParcel.CREATOR);
                    break;
                case 11:
                    location = (Location) a.j6(parcel, j6, Location.CREATOR);
                    break;
                case 12:
                    str2 = a.J8(parcel, j6);
                    break;
                case 13:
                    bundle2 = a.QX(parcel, j6);
                    break;
                case 14:
                    bundle3 = a.QX(parcel, j6);
                    break;
                case 15:
                    list2 = a.yS(parcel, j6);
                    break;
                case 16:
                    str3 = a.J8(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    str4 = a.J8(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                    z3 = a.FH(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new AdRequestParcel(i, j, bundle, i2, list, z, i3, z2, str, searchAdRequestParcel, location, str2, bundle2, bundle3, list2, str3, str4, z3);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public AdRequestParcel[] j6(int i) {
        return new AdRequestParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
