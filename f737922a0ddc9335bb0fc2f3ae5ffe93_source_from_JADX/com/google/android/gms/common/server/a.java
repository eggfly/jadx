package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<FavaDiagnosticsEntity> {
    static void j6(FavaDiagnosticsEntity favaDiagnosticsEntity, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, favaDiagnosticsEntity.j6);
        b.j6(parcel, 2, favaDiagnosticsEntity.DW, false);
        b.j6(parcel, 3, favaDiagnosticsEntity.FH);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public FavaDiagnosticsEntity j6(Parcel parcel) {
        int i = 0;
        int DW = com.google.android.gms.common.internal.safeparcel.a.DW(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = com.google.android.gms.common.internal.safeparcel.a.j6(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    str = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    i = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new FavaDiagnosticsEntity(i2, str, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + DW, parcel);
    }

    public FavaDiagnosticsEntity[] j6(int i) {
        return new FavaDiagnosticsEntity[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
