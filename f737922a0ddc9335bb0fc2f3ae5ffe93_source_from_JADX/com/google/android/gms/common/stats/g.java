package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class g implements Creator<WakeLockEvent> {
    static void j6(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int j6 = b.j6(parcel);
        b.j6(parcel, 1, wakeLockEvent.j6);
        b.j6(parcel, 2, wakeLockEvent.j6());
        b.j6(parcel, 4, wakeLockEvent.FH(), false);
        b.j6(parcel, 5, wakeLockEvent.Zo());
        b.j6(parcel, 6, wakeLockEvent.VH(), false);
        b.j6(parcel, 8, wakeLockEvent.tp());
        b.j6(parcel, 10, wakeLockEvent.Hw(), false);
        b.j6(parcel, 11, wakeLockEvent.DW());
        b.j6(parcel, 12, wakeLockEvent.gn(), false);
        b.j6(parcel, 13, wakeLockEvent.J0(), false);
        b.j6(parcel, 14, wakeLockEvent.EQ());
        b.j6(parcel, 15, wakeLockEvent.J8());
        b.j6(parcel, 16, wakeLockEvent.Ws());
        b.j6(parcel, 17, wakeLockEvent.v5(), false);
        b.j6(parcel, j6);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return j6(parcel);
    }

    public WakeLockEvent j6(Parcel parcel) {
        int DW = a.DW(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        String str5 = null;
        while (parcel.dataPosition() < DW) {
            int j6 = a.j6(parcel);
            switch (a.j6(j6)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i = a.Hw(parcel, j6);
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    j = a.Zo(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    str = a.J8(parcel, j6);
                    break;
                case 5:
                    i3 = a.Hw(parcel, j6);
                    break;
                case 6:
                    list = a.yS(parcel, j6);
                    break;
                case 8:
                    j2 = a.Zo(parcel, j6);
                    break;
                case 10:
                    str3 = a.J8(parcel, j6);
                    break;
                case 11:
                    i2 = a.Hw(parcel, j6);
                    break;
                case 12:
                    str2 = a.J8(parcel, j6);
                    break;
                case 13:
                    str4 = a.J8(parcel, j6);
                    break;
                case 14:
                    i4 = a.Hw(parcel, j6);
                    break;
                case 15:
                    f = a.u7(parcel, j6);
                    break;
                case 16:
                    j3 = a.Zo(parcel, j6);
                    break;
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    str5 = a.J8(parcel, j6);
                    break;
                default:
                    a.DW(parcel, j6);
                    break;
            }
        }
        if (parcel.dataPosition() == DW) {
            return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3, str5);
        }
        throw new a.a("Overread allowed size end=" + DW, parcel);
    }

    public WakeLockEvent[] j6(int i) {
        return new WakeLockEvent[i];
    }

    public /* synthetic */ Object[] newArray(int i) {
        return j6(i);
    }
}
