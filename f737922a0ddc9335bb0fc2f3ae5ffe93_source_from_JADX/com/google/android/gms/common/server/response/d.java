package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair;
import java.util.ArrayList;

public class d implements Creator<Entry> {
    static void j6(Entry entry, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, entry.j6);
        b.j6(parcel, 2, entry.DW, false);
        b.DW(parcel, 3, entry.FH, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public Entry j6(Parcel parcel) {
        ArrayList arrayList = null;
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
                    arrayList = a.FH(parcel, j6, FieldMapPair.CREATOR);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new Entry(i, str, arrayList);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public Entry[] j6(int i) {
        return new Entry[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
