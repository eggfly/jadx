package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h implements Creator<ConnectionResult> {
    static void j6(ConnectionResult connectionResult, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, connectionResult.DW);
        b.j6(parcel, 2, connectionResult.FH());
        b.j6(parcel, 3, connectionResult.Hw(), i, false);
        b.j6(parcel, 4, connectionResult.v5(), false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public ConnectionResult j6(Parcel parcel) {
        String str = null;
        int i = 0;
        int DW = a.DW(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < DW) {
            PendingIntent pendingIntent2;
            int i3;
            String str2;
            int j6 = a.j6(parcel);
            String str3;
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    str3 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = a.Hw(parcel, j6);
                    str2 = str3;
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    i = i2;
                    PendingIntent pendingIntent3 = pendingIntent;
                    i3 = a.Hw(parcel, j6);
                    str2 = str;
                    pendingIntent2 = pendingIntent3;
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    i3 = i;
                    i = i2;
                    str3 = str;
                    pendingIntent2 = (PendingIntent) a.j6(parcel, j6, PendingIntent.CREATOR);
                    str2 = str3;
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    str2 = a.J8(parcel, j6);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    a.DW(parcel, j6);
                    str2 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            pendingIntent = pendingIntent2;
            str = str2;
        }
        if (parcel.dataPosition() == DW) {
            return new ConnectionResult(i2, i, pendingIntent, str);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public ConnectionResult[] j6(int i) {
        return new ConnectionResult[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
