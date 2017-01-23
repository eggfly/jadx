package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import java.util.ArrayList;

public class c implements Creator<FieldMappingDictionary> {
    static void j6(FieldMappingDictionary fieldMappingDictionary, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, fieldMappingDictionary.DW());
        b.DW(parcel, 2, fieldMappingDictionary.FH(), false);
        b.j6(parcel, 3, fieldMappingDictionary.Hw(), false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public FieldMappingDictionary j6(Parcel parcel) {
        String str = null;
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
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    str = a.J8(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new FieldMappingDictionary(i, arrayList, str);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public FieldMappingDictionary[] j6(int i) {
        return new FieldMappingDictionary[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
