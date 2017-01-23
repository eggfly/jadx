package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<BitmapTeleporter> {
    static void j6(BitmapTeleporter bitmapTeleporter, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, bitmapTeleporter.j6);
        b.j6(parcel, 2, bitmapTeleporter.DW, i, false);
        b.j6(parcel, 3, bitmapTeleporter.FH);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public BitmapTeleporter j6(Parcel parcel) {
        int i = 0;
        int DW = com.google.android.gms.common.internal.safeparcel.a.DW(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < DW) {
            ParcelFileDescriptor parcelFileDescriptor2;
            int Hw;
            int j6 = com.google.android.gms.common.internal.safeparcel.a.j6(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    int i3 = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    Hw = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    j6 = i3;
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    Hw = i2;
                    ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.a.j6(parcel, j6, ParcelFileDescriptor.CREATOR);
                    j6 = i;
                    parcelFileDescriptor2 = parcelFileDescriptor3;
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    j6 = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    Hw = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.DW(parcel, j6);
                    j6 = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    Hw = i2;
                    break;
            }
            i2 = Hw;
            parcelFileDescriptor = parcelFileDescriptor2;
            i = j6;
        }
        if (parcel.dataPosition() == DW) {
            return new BitmapTeleporter(i2, parcelFileDescriptor, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + DW, parcel);
    }

    public BitmapTeleporter[] j6(int i) {
        return new BitmapTeleporter[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
