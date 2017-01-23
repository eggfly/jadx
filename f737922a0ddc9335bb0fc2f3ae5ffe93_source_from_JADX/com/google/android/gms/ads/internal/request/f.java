package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f implements Creator<LargeParcelTeleporter> {
    static void j6(LargeParcelTeleporter largeParcelTeleporter, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, largeParcelTeleporter.j6);
        b.j6(parcel, 2, largeParcelTeleporter.DW, i, false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public LargeParcelTeleporter j6(Parcel parcel) {
        int DW = a.DW(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) a.j6(parcel, j6, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new LargeParcelTeleporter(i, parcelFileDescriptor);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public LargeParcelTeleporter[] j6(int i) {
        return new LargeParcelTeleporter[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
