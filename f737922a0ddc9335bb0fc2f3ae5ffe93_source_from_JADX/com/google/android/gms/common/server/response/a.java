package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;

public class a implements Creator<Field> {
    static void j6(Field field, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, field.j6());
        b.j6(parcel, 2, field.DW());
        b.j6(parcel, 3, field.FH());
        b.j6(parcel, 4, field.Hw());
        b.j6(parcel, 5, field.v5());
        b.j6(parcel, 6, field.Zo(), false);
        b.j6(parcel, 7, field.VH());
        b.j6(parcel, 8, field.u7(), false);
        b.j6(parcel, 9, field.EQ(), i, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public Field j6(Parcel parcel) {
        ConverterWrapper converterWrapper = null;
        int i = 0;
        int DW = com.google.android.gms.common.internal.safeparcel.a.DW(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = com.google.android.gms.common.internal.safeparcel.a.j6(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i4 = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    i3 = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    z2 = com.google.android.gms.common.internal.safeparcel.a.FH(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.a.FH(parcel, j6);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case 9:
                    converterWrapper = (ConverterWrapper) com.google.android.gms.common.internal.safeparcel.a.j6(parcel, j6, ConverterWrapper.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new Field(i4, i3, z2, i2, z, str2, i, str, converterWrapper);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + DW, parcel);
    }

    public Field[] j6(int i) {
        return new Field[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
