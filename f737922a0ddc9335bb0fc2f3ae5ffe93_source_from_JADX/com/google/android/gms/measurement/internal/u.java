package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class u implements Creator<EventParams> {
    static void j6(EventParams eventParams, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, eventParams.j6);
        b.j6(parcel, 2, eventParams.DW(), false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public EventParams j6(Parcel parcel) {
        int DW = a.DW(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    bundle = a.QX(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new EventParams(i, bundle);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public EventParams[] j6(int i) {
        return new EventParams[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
