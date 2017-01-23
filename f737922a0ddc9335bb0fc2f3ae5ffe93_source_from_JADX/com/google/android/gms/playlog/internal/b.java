package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<PlayLoggerContext> {
    static void j6(PlayLoggerContext playLoggerContext, Parcel parcel, int i) {
        int j6 = com.google.android.gms.common.internal.safeparcel.b.j6(parcel);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 1, playLoggerContext.j6);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 2, playLoggerContext.DW, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 3, playLoggerContext.FH);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 4, playLoggerContext.Hw);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 5, playLoggerContext.v5, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 6, playLoggerContext.Zo, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 7, playLoggerContext.VH);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 8, playLoggerContext.gn, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 9, playLoggerContext.u7);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 10, playLoggerContext.tp);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public PlayLoggerContext j6(Parcel parcel) {
        String str = null;
        int i = 0;
        int DW = a.DW(parcel);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        int i4 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i4 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    str4 = a.J8(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    i3 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    i2 = a.Hw(parcel, j6);
                    break;
                case 5:
                    str3 = a.J8(parcel, j6);
                    break;
                case 6:
                    str2 = a.J8(parcel, j6);
                    break;
                case 7:
                    z = a.FH(parcel, j6);
                    break;
                case 8:
                    str = a.J8(parcel, j6);
                    break;
                case 9:
                    z2 = a.FH(parcel, j6);
                    break;
                case 10:
                    i = a.Hw(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new PlayLoggerContext(i4, str4, i3, i2, str3, str2, z, str, z2, i);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public PlayLoggerContext[] j6(int i) {
        return new PlayLoggerContext[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
