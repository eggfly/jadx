package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<ConnectionEvent> {
    static void j6(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, connectionEvent.j6);
        b.j6(parcel, 2, connectionEvent.j6());
        b.j6(parcel, 4, connectionEvent.FH(), false);
        b.j6(parcel, 5, connectionEvent.Hw(), false);
        b.j6(parcel, 6, connectionEvent.v5(), false);
        b.j6(parcel, 7, connectionEvent.Zo(), false);
        b.j6(parcel, 8, connectionEvent.VH(), false);
        b.j6(parcel, 10, connectionEvent.EQ());
        b.j6(parcel, 11, connectionEvent.tp());
        b.j6(parcel, 12, connectionEvent.DW());
        b.j6(parcel, 13, connectionEvent.gn(), false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public ConnectionEvent j6(Parcel parcel) {
        int DW = com.google.android.gms.common.internal.safeparcel.a.DW(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = com.google.android.gms.common.internal.safeparcel.a.j6(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    j = com.google.android.gms.common.internal.safeparcel.a.Zo(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    str = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case 7:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case 8:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case 10:
                    j2 = com.google.android.gms.common.internal.safeparcel.a.Zo(parcel, j6);
                    break;
                case 11:
                    j3 = com.google.android.gms.common.internal.safeparcel.a.Zo(parcel, j6);
                    break;
                case 12:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    break;
                case 13:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + DW, parcel);
    }

    public ConnectionEvent[] j6(int i) {
        return new ConnectionEvent[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
