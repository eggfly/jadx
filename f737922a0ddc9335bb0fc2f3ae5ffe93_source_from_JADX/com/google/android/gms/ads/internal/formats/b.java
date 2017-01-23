package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;

public class b implements Creator<NativeAdOptionsParcel> {
    static void j6(NativeAdOptionsParcel nativeAdOptionsParcel, Parcel parcel, int i) {
        int j6 = com.google.android.gms.common.internal.safeparcel.b.j6(parcel);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 1, nativeAdOptionsParcel.j6);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 2, nativeAdOptionsParcel.DW);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 3, nativeAdOptionsParcel.FH);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, 4, nativeAdOptionsParcel.Hw);
        com.google.android.gms.common.internal.safeparcel.b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public NativeAdOptionsParcel j6(Parcel parcel) {
        boolean z = false;
        int DW = a.DW(parcel);
        int i = 0;
        boolean z2 = false;
        int i2 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i2 = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    z2 = a.FH(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    z = a.FH(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new NativeAdOptionsParcel(i2, z2, i, z);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public NativeAdOptionsParcel[] j6(int i) {
        return new NativeAdOptionsParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
