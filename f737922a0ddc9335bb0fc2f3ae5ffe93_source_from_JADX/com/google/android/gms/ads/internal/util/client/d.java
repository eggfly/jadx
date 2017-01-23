package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d implements Creator<VersionInfoParcel> {
    static void j6(VersionInfoParcel versionInfoParcel, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, versionInfoParcel.j6);
        b.j6(parcel, 2, versionInfoParcel.DW, false);
        b.j6(parcel, 3, versionInfoParcel.FH);
        b.j6(parcel, 4, versionInfoParcel.Hw);
        b.j6(parcel, 5, versionInfoParcel.v5);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public VersionInfoParcel j6(Parcel parcel) {
        boolean z = false;
        int DW = a.DW(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i3 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    str = a.J8(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    i2 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    i = a.Hw(parcel, j6);
                    break;
                case 5:
                    z = a.FH(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new VersionInfoParcel(i3, str, i2, i, z);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public VersionInfoParcel[] j6(int i) {
        return new VersionInfoParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
