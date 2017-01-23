package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class v implements Creator<EventParcel> {
    static void j6(EventParcel eventParcel, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, eventParcel.j6);
        b.j6(parcel, 2, eventParcel.DW, false);
        b.j6(parcel, 3, eventParcel.FH, i, false);
        b.j6(parcel, 4, eventParcel.Hw, false);
        b.j6(parcel, 5, eventParcel.v5);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public EventParcel j6(Parcel parcel) {
        String str = null;
        int DW = a.DW(parcel);
        int i = 0;
        long j = 0;
        EventParams eventParams = null;
        String str2 = null;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    str2 = a.J8(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    eventParams = (EventParams) a.j6(parcel, j6, EventParams.CREATOR);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    str = a.J8(parcel, j6);
                    break;
                case 5:
                    j = a.Zo(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new EventParcel(i, str2, eventParams, str, j);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public EventParcel[] j6(int i) {
        return new EventParcel[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
