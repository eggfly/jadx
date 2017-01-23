package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<DataHolder> {
    static void j6(DataHolder dataHolder, Parcel parcel, int i) {
        int j6 = com.google.android.gms.common.internal.safeparcel.b.j6(parcel);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 1, dataHolder.FH(), false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 2, dataHolder.Hw(), i, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 3, dataHolder.v5());
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 4, dataHolder.Zo(), false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 1000, dataHolder.DW());
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public DataHolder j6(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int DW = a.DW(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    strArr = a.er(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    cursorWindowArr = (CursorWindow[]) a.DW(parcel, j6, CursorWindow.CREATOR);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    bundle = a.QX(parcel, j6);
                    break;
                case 1000:
                    i2 = a.Hw(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() != DW) {
            throw new a.a("Overread allowed size end=" + DW, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.j6();
        return dataHolder;
    }

    public DataHolder[] j6(int i) {
        return new DataHolder[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
