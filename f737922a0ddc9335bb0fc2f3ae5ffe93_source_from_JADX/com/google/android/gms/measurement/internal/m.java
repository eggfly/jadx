package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class m implements Creator<AppMetadata> {
    static void j6(AppMetadata appMetadata, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, appMetadata.j6);
        b.j6(parcel, 2, appMetadata.DW, false);
        b.j6(parcel, 3, appMetadata.FH, false);
        b.j6(parcel, 4, appMetadata.Hw, false);
        b.j6(parcel, 5, appMetadata.v5, false);
        b.j6(parcel, 6, appMetadata.Zo);
        b.j6(parcel, 7, appMetadata.VH);
        b.j6(parcel, 8, appMetadata.gn, false);
        b.j6(parcel, 9, appMetadata.u7);
        b.j6(parcel, 10, appMetadata.tp);
        b.j6(parcel, 11, appMetadata.EQ);
        b.j6(parcel, 12, appMetadata.we, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public AppMetadata j6(Parcel parcel) {
        int DW = a.DW(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        String str5 = null;
        boolean z = false;
        boolean z2 = false;
        long j3 = 0;
        String str6 = null;
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
                    str2 = a.J8(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    str3 = a.J8(parcel, j6);
                    break;
                case 5:
                    str4 = a.J8(parcel, j6);
                    break;
                case 6:
                    j = a.Zo(parcel, j6);
                    break;
                case 7:
                    j2 = a.Zo(parcel, j6);
                    break;
                case 8:
                    str5 = a.J8(parcel, j6);
                    break;
                case 9:
                    z = a.FH(parcel, j6);
                    break;
                case 10:
                    z2 = a.FH(parcel, j6);
                    break;
                case 11:
                    j3 = a.Zo(parcel, j6);
                    break;
                case 12:
                    str6 = a.J8(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new AppMetadata(i, str, str2, str3, str4, j, j2, str5, z, z2, j3, str6);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public AppMetadata[] j6(int i) {
        return new AppMetadata[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
