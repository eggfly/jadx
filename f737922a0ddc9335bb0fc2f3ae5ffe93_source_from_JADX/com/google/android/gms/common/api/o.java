package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class o implements Creator<Status> {
    static void j6(Status status, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, status.Zo());
        b.j6(parcel, 2, status.FH(), false);
        b.j6(parcel, 3, status.j6(), i, false);
        b.j6(parcel, 1000, status.Hw());
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public Status j6(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int DW = a.DW(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    str = a.J8(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    pendingIntent = (PendingIntent) a.j6(parcel, j6, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = a.Hw(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public Status[] j6(int i) {
        return new Status[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
