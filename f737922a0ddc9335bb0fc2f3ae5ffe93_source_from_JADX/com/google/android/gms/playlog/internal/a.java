package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.b;

public class a implements Creator<LogEvent> {
    static void j6(LogEvent logEvent, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, logEvent.j6);
        b.j6(parcel, 2, logEvent.DW);
        b.j6(parcel, 3, logEvent.Hw, false);
        b.j6(parcel, 4, logEvent.v5, false);
        b.j6(parcel, 5, logEvent.Zo, false);
        b.j6(parcel, 6, logEvent.FH);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public LogEvent j6(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int DW = com.google.android.gms.common.internal.safeparcel.a.DW(parcel);
        int i = 0;
        byte[] bArr = null;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < DW) {
            int j6 = com.google.android.gms.common.internal.safeparcel.a.j6(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = com.google.android.gms.common.internal.safeparcel.a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    j2 = com.google.android.gms.common.internal.safeparcel.a.Zo(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    str = com.google.android.gms.common.internal.safeparcel.a.J8(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    bArr = com.google.android.gms.common.internal.safeparcel.a.XL(parcel, j6);
                    break;
                case 5:
                    bundle = com.google.android.gms.common.internal.safeparcel.a.QX(parcel, j6);
                    break;
                case 6:
                    j = com.google.android.gms.common.internal.safeparcel.a.Zo(parcel, j6);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new LogEvent(i, j2, j, str, bArr, bundle);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + DW, parcel);
    }

    public LogEvent[] j6(int i) {
        return new LogEvent[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
