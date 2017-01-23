package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c implements Creator<InterstitialAdParameterParcel> {
    static void j6(InterstitialAdParameterParcel interstitialAdParameterParcel, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, interstitialAdParameterParcel.j6);
        b.j6(parcel, 2, interstitialAdParameterParcel.DW);
        b.j6(parcel, 3, interstitialAdParameterParcel.FH);
        b.j6(parcel, 4, interstitialAdParameterParcel.Hw, false);
        b.j6(parcel, 5, interstitialAdParameterParcel.v5);
        b.j6(parcel, 6, interstitialAdParameterParcel.Zo);
        b.j6(parcel, 7, interstitialAdParameterParcel.VH);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public InterstitialAdParameterParcel j6(Parcel parcel) {
        int i = 0;
        int DW = a.DW(parcel);
        String str = null;
        float f = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i2 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    z3 = a.FH(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    z2 = a.FH(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    str = a.J8(parcel, j6);
                    break;
                case 5:
                    z = a.FH(parcel, j6);
                    break;
                case 6:
                    f = a.u7(parcel, j6);
                    break;
                case 7:
                    i = a.Hw(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new InterstitialAdParameterParcel(i2, z3, z2, str, z, f, i);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public InterstitialAdParameterParcel[] j6(int i) {
        return new InterstitialAdParameterParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
