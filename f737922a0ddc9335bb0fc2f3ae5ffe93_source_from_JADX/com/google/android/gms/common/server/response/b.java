package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair;

public class b implements Creator<FieldMapPair> {
    static void j6(FieldMapPair fieldMapPair, Parcel parcel, int i) {
        int j6 = com.google.android.gms.common.internal.safeparcel.b.j6(parcel);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 1, fieldMapPair.j6);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 2, fieldMapPair.DW, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 3, fieldMapPair.FH, i, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public FieldMapPair j6(Parcel parcel) {
        Field field = null;
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
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    field = (Field) a.j6(parcel, j6, Field.CREATOR);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new FieldMapPair(i, str, field);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public FieldMapPair[] j6(int i) {
        return new FieldMapPair[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
