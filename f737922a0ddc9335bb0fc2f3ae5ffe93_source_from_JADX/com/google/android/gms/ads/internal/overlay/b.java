package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<AdLauncherIntentInfoParcel> {
    static void j6(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, Parcel parcel, int i) {
        int j6 = com.google.android.gms.common.internal.safeparcel.b.j6(parcel);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 1, adLauncherIntentInfoParcel.j6);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 2, adLauncherIntentInfoParcel.DW, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 3, adLauncherIntentInfoParcel.FH, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 4, adLauncherIntentInfoParcel.Hw, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 5, adLauncherIntentInfoParcel.v5, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 6, adLauncherIntentInfoParcel.Zo, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 7, adLauncherIntentInfoParcel.VH, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 8, adLauncherIntentInfoParcel.gn, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 9, adLauncherIntentInfoParcel.u7, i, false);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public AdLauncherIntentInfoParcel j6(Parcel parcel) {
        Intent intent = null;
        int DW = a.DW(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    str7 = a.J8(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    str6 = a.J8(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    str5 = a.J8(parcel, j6);
                    break;
                case 5:
                    str4 = a.J8(parcel, j6);
                    break;
                case 6:
                    str3 = a.J8(parcel, j6);
                    break;
                case 7:
                    str2 = a.J8(parcel, j6);
                    break;
                case 8:
                    str = a.J8(parcel, j6);
                    break;
                case 9:
                    intent = (Intent) a.j6(parcel, j6, Intent.CREATOR);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new AdLauncherIntentInfoParcel(i, str7, str6, str5, str4, str3, str2, str, intent);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public AdLauncherIntentInfoParcel[] j6(int i) {
        return new AdLauncherIntentInfoParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
