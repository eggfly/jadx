package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<ConverterWrapper> {
    static void j6(ConverterWrapper converterWrapper, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, converterWrapper.j6());
        b.j6(parcel, 2, converterWrapper.DW(), i, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public ConverterWrapper j6(Parcel parcel) {
        int DW = com.google.android.gms.common.internal.safeparcel.a.DW(parcel);
        int i = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < DW) {
            int j6 = com.google.android.gms.common.internal.safeparcel.a.j6(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    stringToIntConverter = (StringToIntConverter) com.google.android.gms.common.internal.safeparcel.a.j6(parcel, j6, StringToIntConverter.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new ConverterWrapper(i, stringToIntConverter);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + DW, parcel);
    }

    public ConverterWrapper[] j6(int i) {
        return new ConverterWrapper[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
