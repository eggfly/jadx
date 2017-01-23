package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.converter.StringToIntConverter.Entry;
import java.util.ArrayList;

public class b implements Creator<StringToIntConverter> {
    static void j6(StringToIntConverter stringToIntConverter, Parcel parcel, int i) {
        int j6 = com.google.android.gms.common.internal.safeparcel.b.j6(parcel);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 1, stringToIntConverter.j6());
        com.google.android.gms.common.internal.safeparcel.b.DW(parcel, 2, stringToIntConverter.DW(), false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public StringToIntConverter j6(Parcel parcel) {
        int DW = a.DW(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    arrayList = a.FH(parcel, j6, Entry.CREATOR);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new StringToIntConverter(i, arrayList);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public StringToIntConverter[] j6(int i) {
        return new StringToIntConverter[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
