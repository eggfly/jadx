package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e implements Creator<AdOverlayInfoParcel> {
    static void j6(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, adOverlayInfoParcel.j6);
        b.j6(parcel, 2, adOverlayInfoParcel.DW, i, false);
        b.j6(parcel, 3, adOverlayInfoParcel.j6(), false);
        b.j6(parcel, 4, adOverlayInfoParcel.DW(), false);
        b.j6(parcel, 5, adOverlayInfoParcel.FH(), false);
        b.j6(parcel, 6, adOverlayInfoParcel.Hw(), false);
        b.j6(parcel, 7, adOverlayInfoParcel.VH, false);
        b.j6(parcel, 8, adOverlayInfoParcel.gn);
        b.j6(parcel, 9, adOverlayInfoParcel.u7, false);
        b.j6(parcel, 10, adOverlayInfoParcel.Zo(), false);
        b.j6(parcel, 11, adOverlayInfoParcel.EQ);
        b.j6(parcel, 12, adOverlayInfoParcel.we);
        b.j6(parcel, 13, adOverlayInfoParcel.J0, false);
        b.j6(parcel, 14, adOverlayInfoParcel.J8, i, false);
        b.j6(parcel, 15, adOverlayInfoParcel.v5(), false);
        b.j6(parcel, 16, adOverlayInfoParcel.QX, false);
        b.j6(parcel, 17, adOverlayInfoParcel.XL, i, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public AdOverlayInfoParcel j6(Parcel parcel) {
        int DW = a.DW(parcel);
        int i = 0;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        VersionInfoParcel versionInfoParcel = null;
        IBinder iBinder6 = null;
        String str4 = null;
        InterstitialAdParameterParcel interstitialAdParameterParcel = null;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    adLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel) a.j6(parcel, j6, AdLauncherIntentInfoParcel.CREATOR);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    iBinder = a.Ws(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    iBinder2 = a.Ws(parcel, j6);
                    break;
                case 5:
                    iBinder3 = a.Ws(parcel, j6);
                    break;
                case 6:
                    iBinder4 = a.Ws(parcel, j6);
                    break;
                case 7:
                    str = a.J8(parcel, j6);
                    break;
                case 8:
                    z = a.FH(parcel, j6);
                    break;
                case 9:
                    str2 = a.J8(parcel, j6);
                    break;
                case 10:
                    iBinder5 = a.Ws(parcel, j6);
                    break;
                case 11:
                    i2 = a.Hw(parcel, j6);
                    break;
                case 12:
                    i3 = a.Hw(parcel, j6);
                    break;
                case 13:
                    str3 = a.J8(parcel, j6);
                    break;
                case 14:
                    versionInfoParcel = (VersionInfoParcel) a.j6(parcel, j6, VersionInfoParcel.CREATOR);
                    break;
                case 15:
                    iBinder6 = a.Ws(parcel, j6);
                    break;
                case 16:
                    str4 = a.J8(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    interstitialAdParameterParcel = (InterstitialAdParameterParcel) a.j6(parcel, j6, InterstitialAdParameterParcel.CREATOR);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new AdOverlayInfoParcel(i, adLauncherIntentInfoParcel, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, versionInfoParcel, iBinder6, str4, interstitialAdParameterParcel);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public AdOverlayInfoParcel[] j6(int i) {
        return new AdOverlayInfoParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
