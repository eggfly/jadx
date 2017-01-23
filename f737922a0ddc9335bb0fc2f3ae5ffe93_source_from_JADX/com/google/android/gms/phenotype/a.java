package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<Configuration> {
    static void j6(Configuration configuration, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, configuration.j6);
        b.j6(parcel, 2, configuration.DW);
        b.j6(parcel, 3, configuration.FH, i, false);
        b.j6(parcel, 4, configuration.Hw, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public Configuration j6(Parcel parcel) {
        String[] strArr = null;
        int i = 0;
        int DW = com.google.android.gms.common.internal.safeparcel.a.DW(parcel);
        Flag[] flagArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < DW) {
            Flag[] flagArr2;
            int i3;
            String[] strArr2;
            int j6 = com.google.android.gms.common.internal.safeparcel.a.j6(parcel);
            String[] strArr3;
            switch (com.google.android.gms.common.internal.safeparcel.a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    strArr3 = strArr;
                    flagArr2 = flagArr;
                    i3 = i;
                    i = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    strArr2 = strArr3;
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    i = i2;
                    Flag[] flagArr3 = flagArr;
                    i3 = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    strArr2 = strArr;
                    flagArr2 = flagArr3;
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    i3 = i;
                    i = i2;
                    strArr3 = strArr;
                    flagArr2 = (Flag[]) com.google.android.gms.common.internal.safeparcel.a.DW(parcel, j6, Flag.CREATOR);
                    strArr2 = strArr3;
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    strArr2 = com.google.android.gms.common.internal.safeparcel.a.er(parcel, j6);
                    flagArr2 = flagArr;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.DW(parcel, j6);
                    strArr2 = strArr;
                    flagArr2 = flagArr;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            flagArr = flagArr2;
            strArr = strArr2;
        }
        if (parcel.dataPosition() == DW) {
            return new Configuration(i2, i, flagArr, strArr);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + DW, parcel);
    }

    public Configuration[] j6(int i) {
        return new Configuration[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
